package de.aittr.g_27_security_practice.services.mapping;

import de.aittr.g_27_security_practice.domain.Role;
import de.aittr.g_27_security_practice.domain.dto.RoleDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface RoleMappingService {
    RoleDto mapEntityToDto(Role role);
    Role mapDtoToEntity(RoleDto roleDto);
}