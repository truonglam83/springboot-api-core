package com.api.coreapi.security;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SessionUser {
    private Long id;
    private String username;
    private String role;

    public static SessionUser getCurrentUser() {
        Authentication authentication =
                SecurityContextHolder.getContext().getAuthentication();

        if (authentication == null
                || !(authentication.getPrincipal() instanceof SessionUser)) {
            return null;
        }

        return (SessionUser) authentication.getPrincipal();
    }
}
