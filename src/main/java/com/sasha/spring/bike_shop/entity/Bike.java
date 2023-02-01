package com.sasha.spring.bike_shop.entity;

import com.sun.istack.NotNull;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.HashMap;
import java.util.Map;

@Entity
@Table (name = "bikes")
public class Bike {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "product_name")
    @NotBlank(message = "product name is required field and should not be filled with space only")
    private String productName; //form:radiobutton (hardcode case)

    @Column(name = "color")
    private String color; //form:select (hardcode case)

    @Column(name = "frame_size")
    private String frameSize; //form:select (hardcode case)

    @Column(name = "price")
    private int price;

    public int choosePrice(String productName){
        Map<String, Integer> prices = new HashMap<>();
        prices.put("Silex200", 1_900);
        prices.put("Silex400", 2_250);
        prices.put("Silex600", 3_050);
        return prices.get(productName);
    }

    public Bike() {
    }

    public Bike(String productName, String color, String frameSize) {
        this.productName = productName;
        this.color = color;
        this.frameSize = frameSize;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getFrameSize() {
        return frameSize;
    }

    public void setFrameSize(String frameSize) {
        this.frameSize = frameSize;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int itemPer) {
        this.price = itemPer;
    }

}
