package com.example.demo.routes;

import com.example.demo.dto.PriceList;
import org.apache.camel.Exchange;
import org.apache.camel.Message;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.support.DefaultMessage;
import org.springframework.stereotype.Component;
import static com.example.demo.configuration.CamelConfiguration.RABBIT_URI;

@Component
public class PriceRoute extends RouteBuilder
{

    @Override
    public void configure()
    {
        fromF(RABBIT_URI, "priceList", "priceList")
            .setProperty("packageID", xpath("//packageID/text()"))
            .split(xpath("//priceList"))
            .unmarshal().jacksonxml(PriceList.class)
            .process(this::enrich)
            .marshal().jacksonxml(PriceList.class)
            .toF(RABBIT_URI, "priceListSplit", "priceListSplit");
    }

    private void enrich(Exchange exchange)
    {
        final PriceList dto = exchange.getMessage().getBody(PriceList.class);
        final Integer camelSplitIndex = (Integer) exchange.getProperty("CamelSplitIndex");
        final String packageID = exchange.getProperty("packageID", String.class);
        dto.setNewPackage(packageID + "-" + camelSplitIndex);

        final Message message = new DefaultMessage(exchange);
        message.setBody(dto);
        exchange.setMessage(message);
    }
}