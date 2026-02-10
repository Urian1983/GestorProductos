package Urian1983.GestorProductos.service;

import Urian1983.GestorProductos.domain.model.User;
import Urian1983.GestorProductos.exception.NotFoundException;
import Urian1983.GestorProductos.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {


    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User addUser(User user) {
        return userRepository.save(user);
    }

    public void deleteUser(Long id) {
        User userToDelete = userRepository.findById(id)
        .orElseThrow(() -> new NotFoundException("Can't be deleted, Not Found user with id: " +id)
        );

     userRepository.delete(userToDelete);

    }

    public User updateUser(Long id, User updatedUser) {

        User user = userRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("No existe el usuario con la siguiente Id: " +id));

        user.setName(updatedUser.getName());
        user.setEmail(updatedUser.getEmail());

        return userRepository.save(user);

    }

    public User getUserById(Long id) {
       return userRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Can't be found, Not Found user with id: " +id));
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
}
