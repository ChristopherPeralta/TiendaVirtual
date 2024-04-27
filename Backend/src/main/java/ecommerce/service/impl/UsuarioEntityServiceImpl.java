package ecommerce.service.impl;

import ecommerce.dto.user.UserRequestDTO;
import ecommerce.model.Erol;
import ecommerce.model.RolEntity;
import ecommerce.model.UsuarioEntity;
import ecommerce.repository.RolEntityRepository;
import ecommerce.repository.UsuarioEntityRepository;
import ecommerce.service.UsuarioEntityService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class UsuarioEntityServiceImpl implements UsuarioEntityService {

    private final UsuarioEntityRepository usuarioEntityRepository;
    private final RolEntityRepository rolEntityRepository;
    private final BCryptPasswordEncoder passwordEncoder;


    @Override
    public UserRequestDTO createUserWithRole(String username, String email, String password) {

        RolEntity rol = new RolEntity();
        rol.setName(Erol.CLIENTE);

        UsuarioEntity usuario = new UsuarioEntity();
        usuario.setUsername(username);
        usuario.setEmail(email);
        usuario.setPassword(passwordEncoder.encode(password));

        usuario.setEstado(true);

        Set<RolEntity> roles =new HashSet<>();
        roles.add(rol);
        usuario.setRoles(roles);

        usuarioEntityRepository.save(usuario);

        return new UserRequestDTO(usuario.getUsername(), usuario.getEmail(), null);
    }
}
