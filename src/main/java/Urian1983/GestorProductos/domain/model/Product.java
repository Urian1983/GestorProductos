package Urian1983.GestorProductos.domain.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="products")
public class Product {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id:",length=10, nullable=false, unique=true)
    private Long id;
    @Column(name="descripción:",length=100, nullable=false)
    String name;
    @Column(name="precio:",nullable=false)
    Double price;
    @Column(name="stock:")
    int stock;

    @ManyToOne
    @JoinColumn(name = "usuario")
    private User user;

}
