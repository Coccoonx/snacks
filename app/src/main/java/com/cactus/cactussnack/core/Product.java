package com.cactus.cactussnack.core;

import lombok.Data;

import java.util.UUID;

//@Data
public class Product {

    private String uuid = UUID.randomUUID().toString();

    private String code;

    private String intitule;

    private double prixAchat;

    private double prixVente;

    private int quantiteStock;

    private int categorieProduit;
}
