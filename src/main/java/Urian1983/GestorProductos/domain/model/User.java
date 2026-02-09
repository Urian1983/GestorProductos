package Urian1983.GestorProductos.domain.model;


import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name="users")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id:",length = 10, nullable = false,unique = true)
    private Long id;

    @Column(name="nombre_y_apellidos: ", length= 100, nullable = false, unique = true)
    private String name;

    @Column(name="email")
    @Email
    private String email;

    @OneToMany(mappedBy = "user")
    private List<Product> products;
}
