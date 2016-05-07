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

    public Product(){}
    public Product(String code, String intitule, double prixVente){
        this.code = code;
        this.intitule = intitule;
        this.prixVente = prixVente;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getIntitule() {
        return intitule;
    }

    public void setIntitule(String intitule) {
        this.intitule = intitule;
    }

    public double getPrixAchat() {
        return prixAchat;
    }

    public void setPrixAchat(double prixAchat) {
        this.prixAchat = prixAchat;
    }

    public double getPrixVente() {
        return prixVente;
    }

    public void setPrixVente(double prixVente) {
        this.prixVente = prixVente;
    }

    public int getQuantiteStock() {
        return quantiteStock;
    }

    public void setQuantiteStock(int quantiteStock) {
        this.quantiteStock = quantiteStock;
    }

    public int getCategorieProduit() {
        return categorieProduit;
    }

    public void setCategorieProduit(int categorieProduit) {
        this.categorieProduit = categorieProduit;
    }
}
