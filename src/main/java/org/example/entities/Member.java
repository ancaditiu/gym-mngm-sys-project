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

    @ManyToMany(mappedBy = "members",fetch = FetchType.EAGER)
    private List<TrainingSession> trainingSessions;

    @OneToOne(mappedBy = "members",fetch = FetchType.EAGER)
    private Subscription subscription;

    @OneToMany(mappedBy = "members")
    private List<Progress> progresses; // list pentru ca are legatura cu mai multe progrese

    @Override
    public String toString() {
        return "Member{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", membershipType=" + membershipType +
                '}';
    }
}