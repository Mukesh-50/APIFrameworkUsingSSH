package models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class ProductData {

    private int year;
    private double price;

    @JsonProperty("CPU model")
    private String CPUmodel;

    @JsonProperty("Hard disk size")
    private String harddisksize;
    
    private String color;
}
