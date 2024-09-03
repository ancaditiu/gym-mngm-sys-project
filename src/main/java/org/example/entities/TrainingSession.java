package org.example.entities;

import lombok.Getter;
import lombok.Setter;


import javax.persistence.*;
import java.util.List;


@Entity
@Getter
@Setter
public class TrainingSession {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String sessionName;
    private String schedule;

@ManyToOne()
@JoinColumn(name = "trainer_id")
    private Trainer trainer;

    @ManyToMany
    @JoinTable(name = "trainingSessions",
            joinColumns = @JoinColumn(name = "trainingSession"),
            inverseJoinColumns = @JoinColumn(name = "members"))
    private List<Member> members;


}
