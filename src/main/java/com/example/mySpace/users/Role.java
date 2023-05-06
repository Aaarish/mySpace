package com.example.mySpace.users;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static com.example.mySpace.users.Permission.*;

@RequiredArgsConstructor
public enum Role {
    NORMAL_USER(Set.of(NORMAL_USER_READ, NORMAL_USER_WRITE)),
    ADMIN(Set.of(ADMIN_READ, ADMIN_WRITE ,NORMAL_USER_READ, NORMAL_USER_WRITE))
    ;

    @Getter
    private final Set<Permission> permissions;

    public List<SimpleGrantedAuthority> getAuthorities(){
        List<SimpleGrantedAuthority> simpleGrantedAuthorities = this.permissions.stream()
                .map(permission -> new SimpleGrantedAuthority(permission.getPermission()))
                .collect(Collectors.toList());

        simpleGrantedAuthorities.add(new SimpleGrantedAuthority("ROLE_" + this.name()));

        return simpleGrantedAuthorities;
    }
}
