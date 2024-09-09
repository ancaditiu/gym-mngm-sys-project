package org.example.entities;

import lombok.Getter;
import lombok.Setter;
import org.example.enums.MembershipType;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
public class Subscription {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Enumerated(EnumType.STRING)
    private MembershipType membershipType;
    private LocalDate startDate;
    private LocalDate endDate;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "members_id") // se refera la relatia cu membrii
    private Member members;

    @Override
    public String toString() {
        return "Subscription{" +
                "id=" + id +
                ", membershipType='" + membershipType + '\'' +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                '}';
    }
}
