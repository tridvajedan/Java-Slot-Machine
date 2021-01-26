/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaslotmachine;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Korisnik
 */
public class JavaSlotMachine {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws InterruptedException {
        String sign1 = "";
        String sign2 = "";
        String sign3 = "";
        String[] signs = {"Strawberry","Star","Orange","Grapes","Lemon","Orange","Orange","Strawberry","Strawberry","Strawberry","Grapes","Grapes","Lemon"};
        Random r = new Random();
        int coins = 500;
        int bet = 0;
        Scanner scanner = new Scanner(System.in);
        while(true)
        {
            boolean betvalid = false;
            while(betvalid == false)
            {
                System.out.println("\tCurrent coins - " + coins + "\n\n\n\n");
            System.out.print("\t\t\t\t\t\t\t\t\tHow much are you willing to bet? - ");
            bet = scanner.nextInt();
            if(bet > coins || bet < 0)
            {
                System.out.println("Invalid bet!");
            }
            else
            {
                betvalid = true;
            }
            }
            
        for(int i = 0; i < 3; i++)
        {
            int randomNumber = r.nextInt(signs.length);
            String chosenSign = signs[randomNumber];
            if(i == 0)
            {
                sign1 = chosenSign;
            }
            else if(i == 1)
            {
                sign2 = chosenSign;
            }
            else if(i == 2)
            {
                sign3 = chosenSign;
            }
            
        }
        clean();
        Thread.sleep(1000);
          String star = "Star";
          System.out.println("\t\t[ " + sign1 + " ] \t\t\t\t\t" + "\t\t[ " + sign2 + " ] \t\t\t\t\t" + "\t\t[ " + sign3 + " ] \t\t\t\t\t\n\n");
            if(sign1.equals(sign2) && sign2.equals(sign3) && !sign1.equals(star))
            {
                System.out.println("\t\t\t\t\t\t\t\t\tYou won with three " + sign1 + "!");
                coins += bet*3;
            }
            else if(sign1.equals(star) && sign2.equals(star) && sign3.equals(star))
            {
                System.out.println("\t\t\t\t\t\t\t\t\tThree star jackpot! Lucky!");
                coins += bet*5;
            }
            else if(sign1.equals(sign2) || sign2.equals(sign3) || sign3.equals(sign1) && isSame(sign1,sign2,sign3) == false)
            {
                System.out.println("\t\t\t\t\t\t\t\t\tYou won a minor Jackpot!");
                coins += bet*2;
            }
            
            else
                    {
                        System.out.println("\t\t\t\t\t\t\t\t\tWell,you lost. Better luck next time!");
                        coins -= bet;
                    }
            Thread.sleep(3000);
        }
    }
    public static boolean isSame(String one,String two,String three)
    {
        if(one.equals(two) && two.equals(three))
            {
                return true;
            }
        return false;
    }
    public static void clean()
    {
        for(int i = 0; i < 50; i++)
        {
            System.out.println("\n");
        }
    }
    
}
