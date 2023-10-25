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
    private String name;
    private String serviceDescription;
    private String imageUrl;
    private double serviceValue;

    public Pet() {
    }

    public Pet(UUID id, String name, String serviceDescription, String imageUrl, double serviceValue) {
        this.id = id;
        this.name = name;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
        return Double.compare(serviceValue, pet.serviceValue) == 0 && Objects.equals(id, pet.id) && Objects.equals(name, pet.name) && Objects.equals(serviceDescription, pet.serviceDescription) && Objects.equals(imageUrl, pet.imageUrl);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, serviceDescription, imageUrl, serviceValue);
    }

    @Override
    public String toString() {
        return "Pet{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", serviceDescription='" + serviceDescription + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                ", serviceValue=" + serviceValue +
                '}';
    }
}
