package ecommerce.service;

import ecommerce.dto.user.UserRequestDTO;

public interface UsuarioEntityService {
    UserRequestDTO createUserWithRole(String username, String email, String password);
}