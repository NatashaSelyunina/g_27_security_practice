package de.aittr.g_27_security_practice.services.mapping;

import de.aittr.g_27_security_practice.domain.User;
import de.aittr.g_27_security_practice.domain.dto.UserDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMappingService {
    UserDto mapEntityToDto(User user);
    User mapDtoToEntity(UserDto userDto);
}