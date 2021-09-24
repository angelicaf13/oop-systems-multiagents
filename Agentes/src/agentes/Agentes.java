/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agentes;

import java.util.Scanner;

/**
 *
 * @author Angelica Figueroa Muñiz
 */
public class Agentes {

    public static void main(String[] args) {
        // TODO code application logic here

        Scanner scan = new Scanner(System.in);
        int option;
        do {
            System.out.println("Systèmes Multiagents");
            System.out.println("[1] Conway");
            System.out.println("[2] Immigration");
            System.out.println("[3] Schelling");
            System.out.println("[4] Boids");
            System.out.println("[5] Finir");
            System.out.println("Selectionnez une option: ");
            option = scan.nextInt();

            switch (option) {
                case 1:
                    ConwaySimulator c = new ConwaySimulator();
                    break;
                case 2:
                    ImmigrationSimulator i = new ImmigrationSimulator();
                    break;
                case 3:
                    SchellingSimulator s = new SchellingSimulator();
                    break;
                case 4:
                     FlockSimulator f = new FlockSimulator();
                    break;
                case 5:
                    System.out.println("Bye");
                    break;
                default:
                    System.out.println("Option invalide");
            }
        } while (option != 5);

    }

}
