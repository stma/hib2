package com.progmatic.hibernate;


import com.progmatic.hibernate.model.CountryE;

import java.util.List;
import java.util.Scanner;

public class Main {

    private Controller controller;


    private void mainMenu(Scanner sc) {
        String option = "ghyt";
        do {
            switch (option) {
                case "i" -> controller.initStudentsAndCourses();
                case "ls" -> controller.listStudent();
                case "lc" -> controller.listCourses();
                case "s2c" -> {
                    System.out.println("Student id");
                    Integer sid = sc.nextInt();
                    sc.nextLine();

                    System.out.println("Course Id");
                    Integer cid = sc.nextInt();
                    sc.nextLine();

                    controller.connectS2C(sid, cid);
                }
                case "l" -> controller.getAllPizza();
                case "c" -> {
                    System.out.println("Add meg a pizza nevet: ");
                    String name = sc.nextLine();

                    System.out.println("Add meg a pizza arat: ");
                    Integer price = sc.nextInt();
                    sc.nextLine();

                    controller.addPizza(name, price);
                }
                case "d" -> {
                    System.out.println("Add meg a pizza azonositot: ");
                    Integer pid = sc.nextInt();
                    sc.nextLine();

                    controller.deletePizza(pid);
                }
                case "ttcar" -> {
                    List<CountryE> cc = controller.getCountryByCarSign("TT");
                    for (var c: cc) {
                        System.out.println(c);
                    }
                }
                default -> {
                    if (!option.equalsIgnoreCase("ghyt")) {
                        System.out.println("Nem ismert opcio...");
                    }
                }
            }

            printMenu();
            System.out.println("Mit lepsz?");
        } while (!"q".equalsIgnoreCase(option = sc.nextLine()));
    }

    private void printMenu() {
        System.out.println("=".repeat(30));
        System.out.println("\tInit course - (i)");
        System.out.println("\tStudents - (ls)");
        System.out.println("\tconnect s to c - (s2c)");
        System.out.println("\tPizzak - (l)");
        System.out.println("\tUj Pizza - (c)");
        System.out.println("\tTorol Pizza - (d)");
        System.out.println("\tKilepes - (q)");
        System.out.println("=".repeat(30));
    }

    public static void main(String[] args) throws Exception {
        Main m = new Main();

        try (
                Scanner sc = new Scanner(System.in);
                Controller c = new Controller()
        ) {
            m.controller = c;
            m.mainMenu(sc);
        }
    }

}
