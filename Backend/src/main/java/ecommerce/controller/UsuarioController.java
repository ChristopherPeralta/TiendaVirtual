package ecommerce.controller;

import ecommerce.dto.user.UserRequestDTO;
import ecommerce.service.UsuarioEntityService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UsuarioController {

    private final UsuarioEntityService usuarioEntityService;

    @PostMapping("/register")
    public ResponseEntity<UserRequestDTO> createUserWithRole(@RequestBody UserRequestDTO userRequestDTO) {
        UserRequestDTO createdUser = usuarioEntityService.createUserWithRole(userRequestDTO.username(), userRequestDTO.email(), userRequestDTO.password());
        return new ResponseEntity<>(createdUser, HttpStatus.CREATED);
    }
}
