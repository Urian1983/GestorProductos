package Urian1983.GestorProductos.mapper;

import Urian1983.GestorProductos.domain.dto.ProductRequestDTO;
import Urian1983.GestorProductos.domain.dto.ProductResponseDTO;
import Urian1983.GestorProductos.domain.model.Product;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductMapperImpl implements ProductMapper {

    @Override
    public Product toEntity(ProductRequestDTO dto) {
        if(dto == null){
            throw new IllegalArgumentException("cannot be null");
        }
         Product product = new Product();

        product.setName(dto.getName());
        product.setPrice(dto.getPrice());
        product.setStock(dto.getStock());

        return product;
    }

    @Override
    public ProductResponseDTO toDTO(Product product) {
        if(product == null){
            throw new IllegalArgumentException("cannot be null");
        }
        ProductResponseDTO dto = new ProductResponseDTO();

        dto.setId(product.getId());
        dto.setName(product.getName());
        dto.setPrice(product.getPrice());
        dto.setStock(product.getStock());

        return dto;
    }

    @Override
    public List<ProductResponseDTO> toDTOList(List<Product> products) {

        if(products == null){
            throw new IllegalArgumentException("cannot be null");
        }
        return products.stream()
                .map(this::toDTO)
                .toList();
    }
}
