package net.javaguides.Project.model;

import lombok.*;
import jakarta.persistence.*;

@Entity
@Table(name = "medication")
@Data
public class Medication {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "total_cost")
    private double totalCost;

    @Column(name = "medication_type")
    private String medicationType;

    public Medication(String medicationType) {
        this.medicationType = medicationType;
    }
}
