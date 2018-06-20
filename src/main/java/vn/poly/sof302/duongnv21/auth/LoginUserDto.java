package vn.poly.sof302.duongnv21.auth;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * Login user dto
 *
 * @author duongnguyen
 */
@Component
@Scope("session")
public class LoginUserDto {

    private String username;

    /**
     * @return the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * @param username the username to set
     */
    public void setUsername(String username) {
        this.username = username;
    }
}
