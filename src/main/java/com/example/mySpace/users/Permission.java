package com.example.mySpace.users;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum Permission {
    ADMIN_READ("admin : read"),
    ADMIN_WRITE("admin : write"),
    NORMAL_USER_READ("normal_user : read"),
    NORMAL_USER_WRITE("normal_user : write")
    ;

    @Getter
    private final String permission;
}



