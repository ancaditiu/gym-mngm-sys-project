package org.example.entities;

import lombok.Getter;
import lombok.Setter;
import org.example.enums.SessionName;


import javax.persistence.*;
import java.util.List;


@Entity
@Getter
@Setter
public class TrainingSession {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Enumerated(EnumType.STRING)
    private SessionName sessionName;
    private String schedule;
    private String trainerId;

    @ManyToOne
    @JoinColumn(name = "trainer_id")
    private Trainer trainer;

    @ManyToMany(mappedBy = "trainingSessions")
    private List<Member> members;

}
