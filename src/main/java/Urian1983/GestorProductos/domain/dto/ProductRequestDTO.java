package Urian1983.GestorProductos.domain.dto;

import lombok.Data;

@Data
public class ProductRequestDTO {
    private String name;
    private double price;
    private int stock;
}
