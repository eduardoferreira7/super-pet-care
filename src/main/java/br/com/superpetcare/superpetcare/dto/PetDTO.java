package br.com.superpetcare.superpetcare.dto;

import java.util.UUID;

public record PetDTO(
        UUID id,
        String name,
        String serviceDescription,
        String imageUrl,
        double serviceValue
) {
}
