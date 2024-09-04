package org.example;

import org.example.entities.Member;
import org.example.entities.TrainingSession;
import org.example.enums.MembershipType;
import org.example.enums.SessionName;
import org.example.repositories.MemberRepository;

import org.example.entities.Trainer;
import org.example.enums.Specialization;
import org.example.repositories.TrainerRepository;
import org.example.repositories.TrainingSessionRepository;
import org.example.util.HibernateUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static Scanner scanner = new Scanner(System.in);

    public static TrainerRepository trainerRepository = new TrainerRepository();
    public static MemberRepository memberRepository = new MemberRepository();

    public static TrainingSession trainingSession = new TrainingSession();
    public static TrainingSessionRepository trainingSessionRepository = new TrainingSessionRepository();

    public static void main(String[] args) {
        boolean running = true;
        while (running) {
            showMenu();
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    saveTrainer();
                    break;
                case 2:
                    saveMember();
                    break;
                case 3:
                    findTrainer();
                    break;
                case 4:
                    findMember();
                    break;
                case 5:
                    editTrainer();
                    break;
                case 6:
                    editMember();
                    break;
                case 7:
                    deleteTrainer();
                    break;
                case 8:
                    deleteMember();
                    break;
                case 9:
                    break;
                case 10:
                    break;
                case 11:
                    break;
                case 12:
                    break;
                case 13:
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice. Try again.");
                    break;
            }
        }
        HibernateUtil.getSessionFactory().close();
    }

    private static void showMenu() {
        System.out.println("\n1. Register Trainer");
        System.out.println("\n2. Register Member");
        System.out.println("\n3. Find Trainer");
        System.out.println("\n4. Find Member");
        System.out.println("\n5. Edit Trainer");
        System.out.println("\n6. Edit Member");
        System.out.println("\n7. Delete Trainer");
        System.out.println("\n8. Delete Member");
        System.out.println("\n13. Exit application");

        System.out.print("Enter your choice: ");
    }

    private static void saveTrainer() {
        Trainer trainer = new Trainer();
        System.out.print("Enter Last Name: \n");
        String lastName = scanner.nextLine();
        System.out.print("Enter First Name: \n");
        String firstName = scanner.nextLine();
        System.out.print("Enter specialization (FITNESS,BODYBUILDING,YOGA) \n");
        String specialization = scanner.nextLine();
        trainer.setFirstName(firstName);
        trainer.setLastName(lastName);
        trainer.setSpecialization(Specialization.valueOf(specialization.toUpperCase()));
        trainerRepository.save(trainer);
    }

    private static void saveMember() {
        Member member = new Member();
        System.out.print("Enter Last Name: \n");
        String lastName = scanner.nextLine();
        System.out.print("Enter First Name: \n");
        String firstName = scanner.nextLine();
        System.out.print("Enter membership type (MONTHLY, ANNUALLY) \n");
        String membershipType = scanner.nextLine();
        member.setFirstName(firstName);
        member.setLastName(lastName);
        member.setMembershipType(MembershipType.valueOf(membershipType.toUpperCase()));
        memberRepository.save(member);
    }

    private static void findTrainer() {
        System.out.print("Enter trainer's id: \n");
        int id = Integer.parseInt(scanner.nextLine());
        trainerRepository.findById(id);
        System.out.println(trainerRepository.findById(id));
    }

    private static void findMember() {
        System.out.print("Enter member's id: \n");
        int id = Integer.parseInt(scanner.nextLine());
        memberRepository.findById(id);
        System.out.println(memberRepository.findById(id));
    }

    private static void editTrainer() {
        System.out.print("What trainer do you want to edit? (insert id) \n");
        int searchTrainerId = Integer.parseInt(scanner.nextLine());
        Trainer foundTrainer = trainerRepository.findById(searchTrainerId);
        if(trainerRepository.findById(searchTrainerId) != null){
            System.out.print("What do you want to edit? (first name, last name or spcialization) \n");
            String fieldToUpdate = scanner.nextLine();
            switch (fieldToUpdate) {
                case "first name": {
                    System.out.print("Insert new first name: \n");
                    String firstName = scanner.nextLine();
                    foundTrainer.setFirstName(firstName);
                    trainerRepository.update(foundTrainer);
                }
                break;
                case "last name": {
                    System.out.print("Insert new last name: \n");
                    String lastName = scanner.nextLine();
                    foundTrainer.setLastName(lastName);
                    trainerRepository.update(foundTrainer);
                }
                break;
                case "specialization": {
                    System.out.print("Insert new specialization: (FITNESS,BODYBUILDING,YOGA) \n");
                    String specialization = scanner.nextLine();
                    foundTrainer.setSpecialization(Specialization.valueOf(specialization.toUpperCase()));
                    trainerRepository.update(foundTrainer);
                }
                break;
                default:
                    System.out.println("You didn't choose an option or you wrote it wrong");
                    break;
            }
        } else {
            System.out.println("this trainer desn't exist");
            editTrainer();
        }
    }

    private static void editMember() {
        System.out.print("What member do you want to edit? (insert id) \n");
        int searchMemberId = Integer.parseInt(scanner.nextLine());
        Member foundMember = memberRepository.findById(searchMemberId);
        if(memberRepository.findById(searchMemberId) != null) {
            System.out.print("What do you want to edit? (first name, last name or membership) \n");
            String fieldToUpdate = scanner.nextLine();
            switch (fieldToUpdate) {
                case "first name": {
                    System.out.print("Insert new first name: \n");
                    String firstName = scanner.nextLine();
                    foundMember.setFirstName(firstName);
                    memberRepository.update(foundMember);
                }
                break;
                case "last name": {
                    System.out.print("Insert new last name: \n");
                    String lastName = scanner.nextLine();
                    foundMember.setLastName(lastName);
                    memberRepository.update(foundMember);
                }
                break;
                case "specialization": {
                    System.out.print("Insert new membership: (MONTHLY, ANNUALLY) \n");
                    String membership = scanner.nextLine();
                    foundMember.setMembershipType(MembershipType.valueOf(membership.toUpperCase()));
                    memberRepository.update(foundMember);
                }
                break;
                default:
                    System.out.println("You didn't choose an option or you wrote it wrong");
                    break;
            }
        } else {
            System.out.println("This member desn't exist");
            editMember();
        }
    }

    private static void deleteTrainer() {
        System.out.print("What trainer do you want to delete: (insert id) \n");
        int id = Integer.parseInt(scanner.nextLine());
        Trainer foundTrainer = trainerRepository.findById(id);
        trainerRepository.delete(foundTrainer);
    }

    private static void deleteMember() {
        System.out.print("What member do you want to delete: (insert id) \n");
        int id = Integer.parseInt(scanner.nextLine());
        Member foundMember = memberRepository.findById(id);
        memberRepository.delete(foundMember);
    }
    public static void saveTrainingSession(){
       TrainingSession trainingSession = new TrainingSession();
        System.out.print("Enter Session Name: \n");
        String sessionName = scanner.nextLine();
        trainingSession.setSessionName(SessionName.valueOf(sessionName.toUpperCase()));

        System.out.print("Enter Trainer id for this session training: \n");
        int id = Integer.parseInt(scanner.nextLine());
        Trainer trainer = trainerRepository.findById(id);
        trainingSession.setTrainer(trainer);
        System.out.println("Enter Training Schedule ");
        String schedule = scanner.nextLine();
        trainingSession.setSchedule(schedule);
        List<Member> memberList = new ArrayList<>();
        System.out.println("Do you want to add member? Yes or No");
        String answer = scanner.nextLine();
        if("Yes".equals(answer)){
            boolean flag = true;
            while (flag){
                System.out.println("What is the id of the member? ");
                int memberId = Integer.parseInt(scanner.nextLine());
                Member member = memberRepository.findById(memberId);
                memberList.add(member);
                System.out.println("Do you want to add another member? Yes or No");
                String answer2 = scanner.nextLine();
                if("No".equals(answer2)){
                    flag = false;
                }
            }
            trainingSession.setMembers(memberList);
        }

        trainingSessionRepository.save(trainingSession);

    }
}