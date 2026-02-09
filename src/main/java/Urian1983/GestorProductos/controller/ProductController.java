package Urian1983.GestorProductos.controller;

import Urian1983.GestorProductos.domain.dto.ProductRequestDTO;
import Urian1983.GestorProductos.domain.dto.ProductResponseDTO;
import Urian1983.GestorProductos.domain.model.Product;
import Urian1983.GestorProductos.mapper.ProductMapper;
import Urian1983.GestorProductos.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    ProductService productService;

    @Autowired
    ProductMapper productMapper;

    @PostMapping
    public ResponseEntity<ProductResponseDTO> createUser(@RequestBody ProductRequestDTO dto) {
        Product product = productMapper.toEntity(dto);
        Product saved = productService.addProduct(product);
        ProductResponseDTO responseDTO = productMapper.toDTO(saved);
        return ResponseEntity.status(201).body(responseDTO);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductResponseDTO> getProductById(@PathVariable Long id) {
        Optional<Product> product = productService.getProductById(id);
        return ResponseEntity.ok(productMapper.toDTO(product.orElse(null)));
    }

    @GetMapping("/{id}")
    public ResponseEntity<List<ProductResponseDTO>> getAllUsers() {
        List<Product> users = productService.getAllProducts();
        List<ProductResponseDTO> dtos = productMapper.toDTOList(users);
        return ResponseEntity.ok(dtos);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> removeProduct(@PathVariable Long id) {
        productService.removeProduct(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProductResponseDTO> updateProduct(@PathVariable Long id,
                                                      @RequestBody ProductRequestDTO dto) {
       Product updatedProduct = productMapper.toEntity(dto);
       Product saved = productService.updateProduct(id, updatedProduct);
        return ResponseEntity.ok(productMapper.toDTO(saved));
    }

}
