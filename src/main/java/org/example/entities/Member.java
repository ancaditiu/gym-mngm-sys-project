package org.example.entities;

import lombok.Getter;
import lombok.Setter;
import org.example.enums.MembershipType;

import javax.persistence.*;

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





}
