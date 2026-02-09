package Urian1983.GestorProductos.mapper;

import Urian1983.GestorProductos.domain.dto.ProductRequestDTO;
import Urian1983.GestorProductos.domain.dto.ProductResponseDTO;
import Urian1983.GestorProductos.domain.model.Product;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProductMapper {

    @Mapping(source = "id", target = "id")
    Product toEntity(ProductRequestDTO dto);

    @Mapping(source = "id", target = "productId")
    @Mapping(source = "name", target = "productName")
    @Mapping(source = "price", target ="productPrice")
    @Mapping(source = "stock", target="productStock")
    ProductResponseDTO toDTO(Product product);

    List<ProductResponseDTO> toDTOList(List<Product> products);
}
