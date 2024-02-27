package de.aittr.g_27_security_practice.domain;

import java.util.Objects;
import java.util.Set;

public class UserDto {
    private int id;
    private String username;
    private Set<Role> roles;

    public UserDto() {
    }

    public UserDto(int id, String username, Set<Role> roles) {
        this.id = id;
        this.username = username;
        this.roles = roles;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserDto userDto = (UserDto) o;
        return id == userDto.id && Objects.equals(username, userDto.username) && Objects.equals(roles, userDto.roles);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, username, roles);
    }

    @Override
    public String toString() {
        return "UserDto{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", roles=" + roles +
                '}';
    }
}