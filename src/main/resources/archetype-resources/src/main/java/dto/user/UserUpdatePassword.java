#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.dto.user;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record UserUpdatePassword(
        @NotBlank(message = "Campo password não pode ser vazio")
        @Size(min = 8, max = 20, message = "Sua senha precisa ter entre 8-20 caracteres")
        String newPassword,
        @NotBlank(message = "Campo password não pode ser vazio")
        @Size(min = 8, max = 20, message = "Sua senha precisa ter entre 8-20 caracteres")
        String confirmNewPassword
) {
}
