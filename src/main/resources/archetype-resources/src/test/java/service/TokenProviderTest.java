#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.service;

import com.auth0.jwt.algorithms.Algorithm;
import ${package}.entity.User;
import ${package}.mock.MockUser;
import ${package}.security.TokenProvider;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.test.util.ReflectionTestUtils;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;

class TokenProviderTest {
    MockUser mockUser;
    @InjectMocks
    TokenProvider tokenProvider;
    @Mock
    Algorithm algorithm;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        ReflectionTestUtils.setField(tokenProvider, "secret", "quizapi-dev");
        tokenProvider.setUp();
        mockUser = new MockUser();
    }

    @Test
    void generateToken() {
        User user = mockUser.mockEntity(1);

        Mockito.lenient().when(algorithm.sign(any())).thenReturn("generatedToken".getBytes());

        String result = tokenProvider.generateToken(user);

        assertNotNull(result);
        assertTrue(result.contains("."));
    }

}