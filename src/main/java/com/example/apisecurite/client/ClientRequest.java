package com.example.apisecurite.client;

import jakarta.validation.constraints.NotBlank;

public record ClientRequest(@NotBlank String firstName, @NotBlank String lastName) {
}

