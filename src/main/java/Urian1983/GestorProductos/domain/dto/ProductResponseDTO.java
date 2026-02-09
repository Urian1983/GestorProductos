package Urian1983.GestorProductos.domain.dto;

import lombok.Data;

@Data
public class ProductResponseDTO {
    private Long id;
    private String name;
    private double price;
    private int stock;
}
