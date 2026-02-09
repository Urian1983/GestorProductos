package Urian1983.GestorProductos.mapper;

import Urian1983.GestorProductos.domain.dto.ProductRequestDTO;
import Urian1983.GestorProductos.domain.dto.UserRequestDTO;
import Urian1983.GestorProductos.domain.dto.UserResponseDTO;
import Urian1983.GestorProductos.domain.model.Product;
import Urian1983.GestorProductos.domain.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {

    @Mapping(source = "id", target = "id")
    User toEntity(UserRequestDTO dto);

    @Mapping(source = "id", target = "userId")
    @Mapping(source = "name", target = "userName")
    @Mapping(source = "email", target ="userEmail")
    UserResponseDTO toDTO(User user);

    List<UserResponseDTO> toDTOList(List<User> users);
}
