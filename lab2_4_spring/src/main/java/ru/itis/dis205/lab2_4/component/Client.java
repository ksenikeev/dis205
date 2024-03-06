package ru.itis.dis205.lab2_4.component;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.CommonsLogWriter;

import java.util.List;

@Component
public class Client {

    private final Log log = LogFactory.getLog(getClass());

    private String name;
    private List<Amount> amounts;

    public Client() {
        this.name = "test client";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Amount> getAmounts() {
        log.info("return amount");
        return amounts;
    }

    public void setAmounts(List<Amount> amounts) {
        log.info("amount = " + amounts);
        this.amounts = amounts;
    }
}
