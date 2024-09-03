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

    @ManyToMany(mappedBy = "members")
    private List<TrainingSession> trainingSessions;

//Many-to-Many între Member și TrainingSession: Un membru poate participa la mai multe sesiuni
// , iar o sesiune poate avea mai mulți membri înscriș


}
