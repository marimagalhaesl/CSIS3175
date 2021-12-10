package com.example.mtforfinals.util;

public class Item {
    String destinationCategory;
    Integer imageCategory;
    Double price;

    public Item(String destinationCategory, Integer imageCategory, Double price) {
        this.destinationCategory = destinationCategory;
        this.imageCategory = imageCategory;
        this.price = price;
    }

    public String getDestinationCategory() {
        return destinationCategory;
    }

    public Integer getImageCategory() {
        return imageCategory;
    }

    public Double getPrice() {
        return price;
    }
}
