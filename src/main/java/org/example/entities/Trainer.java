package org.example.entities;

import lombok.Getter;
import lombok.Setter;
import org.example.enums.Specialization;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
public class Trainer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String firstName;
    private String lastName;

    @Enumerated(EnumType.STRING)
    private Specialization specialization;

    @OneToMany(mappedBy = "trainer" , fetch = FetchType.EAGER) // o sa aduca absolut tot din baza de date cu fetchType.EAGER
    private List<TrainingSession> trainingSessions;

    @Override
    public String toString() {
        return "Trainer{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", specialization=" + specialization +
                '}';
    }
}
