package com.company;

import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args)
    {
    	int HumanAll = 3,BotAll = 3,HumanChoice,PlayersSum,SumAll,HumanThink,BotThink;
        boolean game = true,
                Winner = true; // Чей ход true-human, false-bot
        Random rr = new Random();
        Scanner scan = new Scanner(System.in);
        do
        {
            SumAll=HumanAll + BotAll;  //for Bot
            System.out.println("You have " + HumanAll);
            do
            {
                System.out.println("Enter stone number(It can't be more than "+HumanAll+" or less than 0 ): ");
                String b = scan.nextLine();
                HumanChoice = Integer.parseInt(b);
            }while (HumanChoice > HumanAll || HumanChoice < 0);
            int BotChoice = rr.nextInt(BotAll+1);
            PlayersSum = BotChoice+HumanChoice;
                if (Winner == true)
                {
                    do
                    {
                        System.out.println("Enter stone sum(It can't be more than "+SumAll+" or less than 0 ): ");
                        String b = scan.nextLine();
                        HumanThink = Integer.parseInt(b);
                    }while (HumanThink > SumAll || HumanThink < 0);
                    do
                    {
                       int aa = rr.nextInt(HumanAll+1)+BotChoice;
                       BotThink=aa;
                    }while (BotThink==HumanThink);
                    System.out.println("Bot says " + BotThink);
                }
                else
                {
                    int aa = rr.nextInt(HumanAll+1)+BotChoice;
                    BotThink = aa;
                    System.out.println("Bot says " + BotThink);
                    do
                    {
                        System.out.println("Enter stone sum(It can't be more than " + SumAll + " or less than 0 ): ");
                        String b = scan.nextLine();
                        HumanThink = Integer.parseInt(b);
                    }while (HumanThink > SumAll || HumanThink < 0 || HumanThink==BotThink);
                }
                System.out.println();
            System.out.println("You have " + HumanChoice + " Bot have " + BotChoice);
            if (HumanThink == PlayersSum )
            {
                Winner = true;
                HumanAll = HumanAll -1;
                System.out.println("You win Part");
            }
            else if ( BotThink== PlayersSum )
            {
                Winner = false;
                BotAll = BotAll -1;
                System.out.println("Bot win Part");
            }
            else {System.out.println("Nobody win");}

            if (HumanAll == 0 || BotAll == 0)
            {
                if (HumanAll == 0)
                {
                    System.out.println("Winner ");
                }
                if (BotAll == 0)
                {
                    System.out.println("Lox ");
                }
                game = false;
            }
        }while (game == true);
    }
}
