package ecommerce.dto.user;

public record UserRequestDTO(
        String username,
        String email,
        String password
    ) {
    }