package Urian1983.GestorProductos.mapper;

import Urian1983.GestorProductos.domain.dto.ProductRequestDTO;
import Urian1983.GestorProductos.domain.dto.ProductResponseDTO;
import Urian1983.GestorProductos.domain.model.Product;

import java.util.List;

public interface ProductMapper {

    Product toEntity(ProductRequestDTO dto);
    ProductResponseDTO toDTO(Product product);

    List<ProductResponseDTO> toDTOList(List<Product> products);
}
