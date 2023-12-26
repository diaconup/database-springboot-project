package net.javaguides.Project.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "skills")
@Data
public class Skills {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "skill")
    private String skill;

    @Column(name = "happiness")
    private int happiness;

    public Skills(String skill) {
        this.skill = skill;
    }
}
