package Urian1983.GestorProductos.controller;

import Urian1983.GestorProductos.domain.dto.UserRequestDTO;
import Urian1983.GestorProductos.domain.dto.UserResponseDTO;
import Urian1983.GestorProductos.domain.model.User;
import Urian1983.GestorProductos.mapper.UserMapper;
import Urian1983.GestorProductos.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    UserService userService;
    @Autowired
    UserMapper userMapper;

    @PostMapping
    public ResponseEntity<UserResponseDTO> createUser(@RequestBody UserRequestDTO dto) {
        User user = userMapper.toEntity(dto);
        User saved = userService.addUser(user);
        UserResponseDTO responseDTO = userMapper.toDTO(saved);

        return ResponseEntity.status(201).body(responseDTO);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserResponseDTO> getUserById(@PathVariable Long id) {
        Optional<User> user = userService.getUserById(id);
        return ResponseEntity.ok(userMapper.toDTO(user.orElse(null)));
    }

    @GetMapping
    public ResponseEntity<List<UserResponseDTO>> getAllUsers() {
        List<User> users = userService.getAllUsers();
        List<UserResponseDTO> dtos = userMapper.toDTOList(users);
        return ResponseEntity.ok(dtos);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserResponseDTO> updateUser(@PathVariable Long id,
                                                      @RequestBody UserRequestDTO dto) {
        User updatedUser = userMapper.toEntity(dto);
        User saved = userService.updateUser(id, updatedUser);
        return ResponseEntity.ok(userMapper.toDTO(saved));
    }
}
