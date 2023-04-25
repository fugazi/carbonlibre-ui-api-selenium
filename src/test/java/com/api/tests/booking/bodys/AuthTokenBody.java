package com.api.tests.booking.bodys;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Data
@NoArgsConstructor
@Builder(setterPrefix = "set")
@AllArgsConstructor
public class AuthTokenBody {
    private String username;
    private String password;

    public static AuthTokenBody getInstance() {
        AuthTokenBody authTokenBody = AuthTokenBody.builder()
                .setUsername("admin")
                .setPassword("password123")
                .build();

        log.info("authTokenBody: {}", authTokenBody);
        return authTokenBody;
    }
}
