package org.bedu.java.backend.test.interviewer;

import java.util.ArrayList;
import java.util.Scanner;

public class Menu {
    Scanner sc;

    public Menu() {
        sc = new Scanner(System.in);
        Interviewer.data = new ArrayList<Interviewer>();

        showMainMenu();
    }

    public void showMainMenu() {
        int option = 0;

        while (option != 4 ) {
            System.out.println("Seleccione la operacion a realizar:");
            System.out.println("1. Dar de alta un entrevistador");
            System.out.println("2. Consultar un entrevistador");
            System.out.println("3. Salir");

            option = sc.nextInt();
            sc.nextLine();

            switch (option) {
                case 1:
                    addInterviewer();
                    break;
                case 2:
                    searchInterviewer();
                    break;
                case 3:
                    modifyInterviewer();
                    break;
            }
        };

        System.out.println("Programa terminado");
    }

    public void addInterviewer() {
        System.out.println("Ingrese el nombre del entrevistador: ");
        String name = sc.nextLine();
        System.out.println("Ingrese el apellido del entrevistador: ");
        String lastName = sc.nextLine();
        System.out.println("Ingrese el email del entrevistador: ");
        String email = sc.nextLine();
        System.out.println("El entrevistador se encuentra activo? (1=Si/2=No)");
        Boolean isActive = sc.nextInt() == 1;
        sc.nextLine();

        Interviewer interviewer = new Interviewer(name, lastName, email, isActive);
        interviewer.add();

        System.out.println(interviewer.toString());
    }

    public void searchInterviewer() {
        System.out.println("Ingrese el email del entrevistador a consultar:");
        String email = sc.nextLine();

        Interviewer interviewer = Interviewer.getByEmail(email);

        if (interviewer != null) {
            System.out.println("Entrevistador encontrado:");
            System.out.println(interviewer.toString());
        } else {
            System.out.println("Entrevistador no encontrado");
        }
    }
    public void modifyInterviewer() {
        System.out.println("Ingrese el email del entrevistador a modificar:");
        String email = sc.nextLine();

        Interviewer interviewer = Interviewer.getByEmail(email);

        if (interviewer != null) {
            System.out.println("Entrevistador encontrado:");
            System.out.println(interviewer.toString());

            System.out.println("Ingrese el nuevo nombre del entrevistador (Presione Enter para mantener el valor actual):");
            String newName = sc.nextLine();
            if (!newName.isEmpty()) {
                interviewer.setName(newName);
            }

            System.out.println("Ingrese el nuevo apellido del entrevistador (Presione Enter para mantener el valor actual):");
            String newLastName = sc.nextLine();
            if (!newLastName.isEmpty()) {
                interviewer.setLastName(newLastName);
            }

            System.out.println("Ingrese el nuevo email del entrevistador (Presione Enter para mantener el valor actual):");
            String newEmail = sc.nextLine();
            if (!newEmail.isEmpty()) {
                interviewer.setEmail(newEmail);
            }

            System.out.println("El entrevistador se encuentra activo? (1=Si/2=No, Presione Enter para mantener el valor actual):");
            String isActiveInput = sc.nextLine();
            Boolean isActive = null;
            if (!isActiveInput.isEmpty()) {
                isActive = isActiveInput.equals("1");
                interviewer.setActive(isActive);
            }

            interviewer.save(newName, newLastName, newEmail, isActive);
            System.out.println("Entrevistador modificado exitosamente.");
        } else {
            System.out.println("Entrevistador no encontrado");
        }
    }


    public static void main(String[] args) {
        new Menu();
    }
}
