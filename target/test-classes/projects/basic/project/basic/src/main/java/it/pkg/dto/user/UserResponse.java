package it.pkg.dto.user;

import java.util.UUID;

public record UserResponse(
        UUID uuid,
        String name,
        String email
) {
}
