package net.javaguides.Project.model;
import lombok.*;
import jakarta.persistence.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Entity
@Table(name = "Animal")
@Data
public class Animal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "animal_name")
    private String name;

    @Column(name = "age")
    private int age;

    @Column(name = "breed")
    private String breed;

    @Column(name = "gender")
    private String gender;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "arrivedDate")
    private Date arrivedDate;

    @Column(name = "medication")
    private String medication;

    @Column(name = "skills")
    private String skills;

    public String getMedication() {
        return medication;
    }

    public String getSkills() {
        return skills;
    }
}
