#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.mock;

import ${package}.dto.user.UserLogin;
import ${package}.dto.user.UserRequest;
import ${package}.dto.user.UserUpdate;
import ${package}.entity.User;
import ${package}.entity.enums.Role;

import java.util.UUID;

public class MockUser implements MockInterface<User, UserRequest>{
    public static final String MOCK_TOKEN = "mockToken";

    @Override
    public User mockEntity(Integer num) {
        return new User(
                UUID.randomUUID(),
                "User" + num,
                "user@gmail.com",
                "12345678",
                Role.USER
        );
    }

    @Override
    public UserRequest mockRequest(Integer num) {
        return new UserRequest(
                "User" + num,
                "user@gmail.com",
                "12345678"
        );
    }

    public UserUpdate mockUserUpdate(){
        return new UserUpdate("Novo nome");
    }

    public UserLogin mockUserLogin(){
        return new UserLogin("user@gmail.com", "12345678");
    }
}
