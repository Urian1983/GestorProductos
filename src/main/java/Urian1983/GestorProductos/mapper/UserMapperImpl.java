package Urian1983.GestorProductos.mapper;

import Urian1983.GestorProductos.domain.dto.UserRequestDTO;
import Urian1983.GestorProductos.domain.dto.UserResponseDTO;
import Urian1983.GestorProductos.domain.model.User;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserMapperImpl implements UserMapper {
    @Override
    public User toEntity(UserRequestDTO dto) {
        User user = new User();
        user.setName(dto.getName());
        user.setEmail(dto.getEmail());
        return user;
    }

    @Override
    public UserResponseDTO toDTO(User user) {

        UserResponseDTO dto = new UserResponseDTO();

        dto.setId(user.getId());
        dto.setName(user.getName());
        dto.setEmail(user.getEmail());

        return dto;

    }

    @Override
    public List<UserResponseDTO> toDTOList(List<User> users) {
        if(users == null || users.isEmpty()){
            throw new IllegalArgumentException("cannot be null");
        }

        return users.stream()
                .map(this::toDTO)
                .toList();
    }
}
