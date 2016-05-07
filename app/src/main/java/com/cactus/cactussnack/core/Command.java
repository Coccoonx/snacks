package com.cactus.cactussnack.core;

import lombok.Data;

import java.util.Date;
import java.util.HashMap;

//@Data
public class Command {
    String clientName ;

    String clientPhone;

    HashMap<String, Integer> productsRequested = new HashMap();

    Date dateCommand;

    boolean status;

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public String getClientPhone() {
        return clientPhone;
    }

    public void setClientPhone(String clientPhone) {
        this.clientPhone = clientPhone;
    }

    public HashMap<String, Integer> getProductsRequested() {
        return productsRequested;
    }

    public void setProductsRequested(HashMap<String, Integer> productsRequested) {
        this.productsRequested = productsRequested;
    }

    public Date getDateCommand() {
        return dateCommand;
    }

    public void setDateCommand(Date dateCommand) {
        this.dateCommand = dateCommand;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
