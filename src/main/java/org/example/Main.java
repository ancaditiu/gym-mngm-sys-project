package org.example;

import org.example.entities.Member;
import org.example.repositories.MemberRepository;

public class Main {

    public static void main(String[] args) {
        Member member = new Member();
        member.setFirstName("Jean-Claude");
        member.setLastName("Van Damme");
        MemberRepository memberRepository = new MemberRepository();
        memberRepository.save(member);
        System.out.println("Membrul " + memberRepository.findById(1).getFirstName());

    }
}