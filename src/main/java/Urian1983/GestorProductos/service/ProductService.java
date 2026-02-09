package Urian1983.GestorProductos.service;

import Urian1983.GestorProductos.domain.model.Product;
import Urian1983.GestorProductos.domain.model.User;
import Urian1983.GestorProductos.exception.NotFoundException;
import Urian1983.GestorProductos.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public Product addProduct(Product product){

        return productRepository.save(product);
    }

    public Boolean removeProduct(Long id){

        if(!productRepository.findById(id).isPresent()){
            throw new NotFoundException("La id del producto no se encuentra en la base de datos" +id);
        }

        productRepository.deleteById(id);
        return true;
    }

    public Product updateProduct(Long id,Product updatedProduct){

        Product product = productRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Producto no encontrado"));

           product.setName(updatedProduct.getName());
            product.setPrice(updatedProduct.getPrice());
            product.setStock(updatedProduct.getStock());

         productRepository.save(product);
        return product;
    }

    public Optional<Product> getProductById(Long id) {
        return productRepository.findById(id);
    }

    public List<Product> getAllProducts(){
        return productRepository.findAll();
    }

}


