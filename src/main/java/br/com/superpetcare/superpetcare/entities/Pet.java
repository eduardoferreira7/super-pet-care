package br.com.superpetcare.superpetcare.entities;

import jakarta.persistence.*;

import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "tb_pet")
public class Pet {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String breedName;
    private String serviceDescription;
    private String imageUrl;
    private double serviceValue;

    public Pet() {
    }

    public Pet(UUID id, String breedName, String serviceDescription, String imageUrl, double serviceValue) {
        this.id = id;
        this.breedName = breedName;
        this.serviceDescription = serviceDescription;
        this.imageUrl = imageUrl;
        this.serviceValue = serviceValue;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getBreedName() {
        return breedName;
    }

    public void setBreedName(String name) {
        this.breedName = name;
    }

    public String getServiceDescription() {
        return serviceDescription;
    }

    public void setServiceDescription(String description) {
        this.serviceDescription = description;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public double getServiceValue() {
        return serviceValue;
    }

    public void setServiceValue(double serviceValue) {
        this.serviceValue = serviceValue;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pet pet = (Pet) o;
        return Double.compare(serviceValue, pet.serviceValue) == 0 && Objects.equals(id, pet.id) && Objects.equals(breedName, pet.breedName) && Objects.equals(serviceDescription, pet.serviceDescription) && Objects.equals(imageUrl, pet.imageUrl);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, breedName, serviceDescription, imageUrl, serviceValue);
    }

    @Override
    public String toString() {
        return "Pet{" +
                "id=" + id +
                ", name='" + breedName + '\'' +
                ", serviceDescription='" + serviceDescription + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                ", serviceValue=" + serviceValue +
                '}';
    }
}
