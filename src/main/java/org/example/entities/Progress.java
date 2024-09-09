package org.example.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.List;


@Entity
@Getter
@Setter
public class Progress {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int memberId;
    @Temporal(TemporalType.DATE)
    private Date date;
    private String weight;
    private String bodyFatPercentage;

    @ManyToOne()
    @JoinColumn(name = "progresses_id")
    private Member members;

    @Override
    public String toString() {
        return "Progress{" +
                "id=" + id +
                ", memberId=" + memberId +
                ", date=" + date +
                ", weight='" + weight + '\'' +
                ", bodyFatPercentage='" + bodyFatPercentage + '\'' +
                ", members=" + members +
                '}';
    }
}
