package Urian1983.GestorProductos.service;

import Urian1983.GestorProductos.domain.model.Product;
import Urian1983.GestorProductos.exception.NotFoundException;
import Urian1983.GestorProductos.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Product addProduct(Product product){

        return productRepository.save(product);
    }

    public void removeProduct(Long id){

        Product productToRemove=productRepository.findById(id)
                .orElseThrow(()->new NotFoundException("Product not found"));
        productRepository.delete(productToRemove);
    }

    public Product updateProduct(Long id,Product updatedProduct){

        Product product = productRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Product not found"));

           product.setName(updatedProduct.getName());
            product.setPrice(updatedProduct.getPrice());
            product.setStock(updatedProduct.getStock());

         productRepository.save(product);
        return product;
    }

    public Product getProductById(Long id) {

       return productRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Product not found"));
    }

    public List<Product> getAllProducts(){
        return productRepository.findAll();
    }

}


