package com.cactus.cactussnack.server;

import com.cactus.cactussnack.core.Product;

import java.util.ArrayList;
import java.util.List;

public class FakeServer {


    public static List<Product> listOfProducts() {

        List<Product> availableProduct = new ArrayList<>();
        availableProduct.add(new Product("COCA33", "Coca Cola 33 cl", 500));
        availableProduct.add(new Product("FANT33", "Fanta 33 cl", 500));
        availableProduct.add(new Product("ICEB33", "Smirnoff Ice Black 33 cl", 1000));
        availableProduct.add(new Product("GUIN65", "Guinness 65 cl", 1500));
        availableProduct.add(new Product("HARP65", "Harp 65 cl", 1000));
        return availableProduct;
    }


}
