package Urian1983.GestorProductos.mapper;

import Urian1983.GestorProductos.domain.dto.ProductRequestDTO;
import Urian1983.GestorProductos.domain.dto.ProductResponseDTO;
import Urian1983.GestorProductos.domain.model.Product;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProductMapper {

    @Mapping(source = "name", target = "name")
    Product toEntity(ProductRequestDTO dto);

    @Mapping(source = "id", target = "id")
    @Mapping(source = "name", target = "name")
    @Mapping(source = "price", target ="price")
    @Mapping(source = "stock", target="stock")
    ProductResponseDTO toDTO(Product product);

    List<ProductResponseDTO> toDTOList(List<Product> products);
}
