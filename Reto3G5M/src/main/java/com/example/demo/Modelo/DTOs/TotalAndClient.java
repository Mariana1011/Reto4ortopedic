package com.example.demo.Modelo.DTOs;

import com.example.demo.Modelo.Client;

public class TotalAndClient {
    private long total;
    private Client client;

    public TotalAndClient(Long total, Client client){
        this.total = total;
        this.client = client;
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }
}
