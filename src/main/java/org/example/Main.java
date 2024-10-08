package org.example;

import org.example.entities.*;
import org.example.enums.MembershipType;
import org.example.enums.SessionName;
import org.example.repositories.*;

import org.example.enums.Specialization;
import org.example.util.HibernateUtil;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;



public class Main {

    public static Scanner scanner = new Scanner(System.in);

    public static TrainerRepository trainerRepository = new TrainerRepository();
    public static MemberRepository memberRepository = new MemberRepository();

    public static TrainingSession trainingSession = new TrainingSession();
    public static TrainingSessionRepository trainingSessionRepository = new TrainingSessionRepository();

    public static SubscriptionRepository subscriptionRepository = new SubscriptionRepository();
    public static ProgressRepository progressRepository = new ProgressRepository();

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
                    saveTrainingSession();
                    break;
                case 10:
                    viewTrainingSession();
                    break;
                case 11:
                    editTrainingSession();
                    break;
                case 12:
                    editSubscription();
                    break;
                case 13:
                    viewSubscription();
                    break;
                case 14:
                    renewSubscription();
                    break;
                case 15:
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
        System.out.println("\n9. Add Training Session");
        System.out.println("\n10. View Training Session");
        System.out.println("\n11. Edit Training Session");
        System.out.println("\n12. Edit Subscription");
        System.out.println("\n13. View Subscription");
        System.out.println("\n14. Renew Subscription");
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
        if (trainerRepository.findById(searchTrainerId) != null) {
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
        if (memberRepository.findById(searchMemberId) != null) {
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

    public static void saveTrainingSession() {
        TrainingSession trainingSession = new TrainingSession();
        System.out.print("Enter Session Name: \n");
        String sessionName = scanner.nextLine();
        trainingSession.setSessionName(SessionName.valueOf(sessionName.toUpperCase()));

        System.out.print("Enter Trainer id for this session training: ");
        int id = Integer.parseInt(scanner.nextLine());
        Trainer trainer = trainerRepository.findById(id);
        trainingSession.setTrainer(trainer);
        System.out.println("Enter Training Schedule ");
        String schedule = scanner.nextLine();
        trainingSession.setSchedule(schedule);
        List<Member> memberList = new ArrayList<>();
        System.out.println("Do you want to add member? Yes or No");
        String answer = scanner.nextLine();
        if ("Yes".equals(answer)) {
            boolean flag = true;
            while (flag) {
                System.out.println("What is the id of the member? ");
                int memberId = Integer.parseInt(scanner.nextLine());
                Member member = memberRepository.findById(memberId);
                memberList.add(member);
                System.out.println("Do you want to add another member? Yes or No");
                String answer2 = scanner.nextLine();
                if ("No".equals(answer2)) {
                    flag = false;
                }
            }
            trainingSession.setMembers(memberList);
        }
        trainingSessionRepository.save(trainingSession);
    }

    public static void viewTrainingSession() {
        System.out.println("What training session do you want to see? (Insert Trainer or Member) ");
        String answer = scanner.nextLine();
        if ("Trainer".equals(answer)) {
            System.out.println("What trainer do you want to see the schedule for? (Insert ID) ");
            int trainerId = Integer.parseInt(scanner.nextLine());
            List<TrainingSession> trainingSessionList = trainerRepository.findById(trainerId).getTrainingSessions();
            System.out.println("The trainer has the following schedule ");
            for (TrainingSession tr : trainingSessionList) {
                System.out.println("Session " + tr.getSessionName() + " has the following schedule " + tr.getSchedule());
            }
        } else if ("Member".equals(answer)) {
            System.out.println("What Member do you want to see the schedule for? (Insert ID) ");
            int memberId = Integer.parseInt(scanner.nextLine());
            List<TrainingSession> trainingSessions = memberRepository.findById(memberId).getTrainingSessions();
            System.out.println("The member has following schedule ");
            for (TrainingSession ms : trainingSessions) {
                System.out.println("Session " + ms.getSessionName() + " has the following schedule " + ms.getSchedule());
            }
        }
    }

    public static void editTrainingSession() {
        System.out.println("What training session do you want to edit? (Insert training session ID )");
        int sessionId = Integer.parseInt(scanner.nextLine());
        TrainingSession trainingSession1 = trainingSessionRepository.findById(sessionId);
    }

    public static void editSubscription() {
        Subscription subscription = new Subscription();
        System.out.println("Which member subscription do you want to renew (Insert ID)");
        int id = Integer.parseInt(scanner.nextLine());
        Member member = memberRepository.findById(id);
        if (member != null) {
            System.out.println("Insert new membership: (MONTHLY , ANNUALLY) \n");
            String membership = scanner.nextLine();
            subscription.setMembershipType(MembershipType.valueOf(membership.toUpperCase()));
            System.out.println("Insert Date when you want to start: (Format YYYY-MM-DD) \n");
            String date = scanner.nextLine();
            subscription.setStartDate(LocalDate.parse(date));
            System.out.println("Insert Date when you want to end subscription: (Format YYYY-MM-DD) \n");
            String date2 = scanner.nextLine();
            subscription.setEndDate(LocalDate.parse(date2));
            member.setMembershipType(subscription.getMembershipType());
            memberRepository.update(member);
            subscriptionRepository.save(subscription);

        } else {
            System.out.println("This member doesn't exists");
            editSubscription();
        }
    }

    public static void viewSubscription() {
        System.out.println("Enter member id to check his subscription (Insert ID) ");
        int id = Integer.parseInt(scanner.nextLine());
        Subscription subscription = memberRepository.findById(id).getSubscription();
        System.out.println("The membership type is following: ");
            System.out.println("id" + subscription.getId() + "MembershipType" + subscription.getMembershipType() +
                    " Members " + subscription.getMembers() + " Start Date: " + subscription.getStartDate() + " End Date:" + subscription.getEndDate());
        }


    public static void renewSubscription() {
        Subscription subscriptionType = new Subscription();
        System.out.println("Enter member id for renew his subscription (Insert ID)");
        int id = Integer.parseInt(scanner.nextLine());
        Member member = memberRepository.findById(id);
        if (memberRepository.findById(id) != null) {
            String fieldToAdd = scanner.nextLine();
            switch (fieldToAdd) {
                case "Membership Type": {
                    System.out.println("Insert new membership type write: (MONTHLY OR ANNUALLY) \n");
                    String membership = scanner.nextLine();
                    member.setMembershipType(MembershipType.valueOf(membership.toUpperCase()));
                    memberRepository.update(member);
                }
                break;
                case "Start Date": {
//                    System.out.println("Insert Date when you want to start: (Format YYYY,MM,DD) \n");
//                    String date = scanner.nextLine();
//                    subscriptionType.setStartDate(new Date(date));
//                    memberRepository.update(member);
                }
                break;
                case "End Date": {
//                    System.out.println("Insert Date when you want to end subscription: (Format YYYY,MM,DD) \n");
//                    String date = scanner.nextLine();
//                    subscriptionType.setEndDate(new Date(date));
//                    memberRepository.update(member);
                }
                break;
                default:
                    System.out.println("You didn't choose an option or you wrote it wrong");
                    break;
            }
        } else {
            System.out.println("This member doesn't exists");
            renewSubscription();
        }
    }
    public static void deleteSubscription(){
        System.out.println("Insert member do you want to delete subscription: (Insert ID) \n");
        int id = Integer.parseInt(scanner.nextLine());
        Member foundMember = memberRepository.findById(id);
        subscriptionRepository.delete(foundMember);
    }
}