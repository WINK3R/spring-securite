package com.example.apisecurite.client;

import java.util.Objects;

public record Client(String firstName, String lastName) {

    public Client {
        if (firstName == null || firstName.isBlank()) {
            throw new IllegalArgumentException("firstName must not be blank");
        }
        if (lastName == null || lastName.isBlank()) {
            throw new IllegalArgumentException("lastName must not be blank");
        }
    }

    public boolean matches(String firstName, String lastName) {
        return Objects.equals(this.firstName, firstName) && Objects.equals(this.lastName, lastName);
    }
}

