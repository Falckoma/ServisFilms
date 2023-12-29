package com.example.demo_kr.model;

import org.jetbrains.annotations.NotNull;

public record Profile(
        @NotNull
        String email,
        @NotNull
        String password
) {
        public String getPassword() {
                return password;
        }
}