package org.example;

import org.example.entities.Member;
import org.example.repositories.MemberRepository;

import org.example.entities.Trainer;
import org.example.entities.TrainingSession;
import org.example.enums.Specialization;
import org.example.repositories.TrainerRepository;
import org.example.util.HibernateUtil;

import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    TrainerRepository trainerRepository = new TrainerRepository();

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




        boolean running = true;
        while (running) {
            showMenu();
            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline
            switch (choice) {
                case 1:
                    trainerRepository.save(trainer);
                    break;
                case 2:
                    memberRepository.save(member);
                    break;
                case 3:
                    trainerRepository.findById(scanner.nextInt());
                    break;
                case 4:

                    break;
                case 5:
                    removeUser();
                    break;
                case 6:
                    removeUser();
                    break;
                case 7:
                    removeUser();
                    break;
                case 8:
                    removeUser();
                    break;

                case 9:
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice. Try again.");
                    break;
            }
        }
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
        System.out.println("\n9. Exit application");

        System.out.print("Enter your choice: ");
    }

    private static void saveTrainer() {
        System.out.print("Enter Last Name: ");
        String lastName = scanner.nextLine();
        System.out.print("Enter First Name: ");
        String firstName = scanner.nextLine();
        String specialization = scanner.nextLine();

    }

    private static void removeUser() {
        System.out.print("Enter username: ");
        String username = scanner.nextLine();
        platform.deleteUser(username);
    }

    private static void loginUser() {
        System.out.print("Enter username: ");
        String username = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();
        platform.login(username, password);
    }

    private static void logoutUser() {
        System.out.print("Enter username: ");
        String username = scanner.nextLine();
        platform.logout(username);
    }

    private static void addAProduct() {
        System.out.print("Enter id of the product: ");
        String id = scanner.nextLine();
        System.out.print("Enter name: ");
        String name = scanner.nextLine();
        System.out.print("Enter price: ");
        double price = scanner.nextDouble();
        System.out.print("Enter quantity: ");
        int quantity = scanner.nextInt();
        platform.addProduct(id, name, price, quantity);
    }

    private static void removeProduct() {
        System.out.print("Enter product id: ");
        String id = scanner.nextLine();
        platform.deleteProduct(id);
    }

    private static void purchaseProduct() {
        System.out.print("Enter username: ");
        String username = scanner.nextLine();
        System.out.print("Enter id of the product: ");
        String id = scanner.nextLine();
        System.out.print("Enter quantity: ");
        int quantity = scanner.nextInt();
        platform.purchaseProduct(username, id, quantity);
    }

        HibernateUtil.getSessionFactory().

    close();


}
}