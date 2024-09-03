package org.example.entities;

import lombok.Getter;
import lombok.Setter;
import org.example.enums.MembershipType;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String firstName;

    private String lastName;

    @Enumerated(EnumType.STRING)
    private MembershipType membershipType;

    @ManyToMany
    @JoinTable(name = "member_trainingSessions",
            joinColumns = @JoinColumn(name = "member_id"),
            inverseJoinColumns = @JoinColumn(name = "trainingSession_id"))
    private List<TrainingSession> trainingSessions;

}
