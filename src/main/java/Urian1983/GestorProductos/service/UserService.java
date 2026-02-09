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

    @Autowired
    UserRepository userRepository;

    public User addUser(User user) {
        return userRepository.save(user);
    }

    public boolean deleteUser(Long id) {
        if(!userRepository.existsById(id)) {
            throw new NotFoundException("No existe el usuario con el id: " + id);
        }
        else{
            userRepository.deleteById(id);
            return true;
        }
    }

    public User updateUser(Long id, User updatedUser) {

        User user = userRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("No existe el usuario con la siguiente Id: " +id));

        user.setName(updatedUser.getName());
        user.setEmail(updatedUser.getEmail());

        return userRepository.save(user);

    }

    public Optional<User> getUserById(Long id) {
        return userRepository.findById(id);
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
}
