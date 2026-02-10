package Urian1983.GestorProductos.domain.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class ProductRequestDTO {
    @NotBlank
    @NotNull
    private String name;

    @NotNull
    private double price;

    @NotNull
    private int stock;
}
