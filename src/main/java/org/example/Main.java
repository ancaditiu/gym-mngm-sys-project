package org.example;

import org.example.entities.Member;
import org.example.repositories.MemberRepository;

import org.example.entities.Trainer;
import org.example.entities.TrainingSession;
import org.example.enums.Specialization;
import org.example.repositories.TrainerRepository;
import org.example.util.HibernateUtil;

public class Main {

    public static void main(String[] args) {
        Member member = new Member();
        member.setFirstName("Jean-Claude");
        member.setLastName("Van Damme");
        MemberRepository memberRepository = new MemberRepository();
        memberRepository.save(member);
        System.out.println("Membrul " + memberRepository.findById(1).getFirstName());
        Trainer trainer = new Trainer();
    trainer.setFirstName("Ionut");
    trainer.setLastName("Anghelescu");
    trainer.setId(1);
    trainer.setSpecialization(Specialization.FITNESS);

        TrainerRepository trainerRepository = new TrainerRepository();
        trainerRepository.save(trainer);

        Trainer trainerScos = trainerRepository.findById(1);
        System.out.println(trainerScos.getId());

        HibernateUtil.getSessionFactory().close();




    }
}