#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.dto.user;

import java.util.UUID;

public record UserResponse(
        UUID uuid,
        String name,
        String email
) {
}
