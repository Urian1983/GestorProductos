package Urian1983.GestorProductos.mapper;

import Urian1983.GestorProductos.domain.dto.UserRequestDTO;
import Urian1983.GestorProductos.domain.dto.UserResponseDTO;
import Urian1983.GestorProductos.domain.model.User;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {

    User toEntity(UserRequestDTO dto);
    UserResponseDTO toDTO(User user);

    List<UserResponseDTO> toDTOList(List<User> users);
}
