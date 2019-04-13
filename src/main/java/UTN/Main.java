package UTN;

import UTN.controller.MatchController;
import UTN.model.*;

import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class Main {

    public static void main(String [] args)
    {
        Random r = new Random();
        List<Human> vikingList = Arrays.asList(
                new Viking("Vikingo1",r.nextInt(60) +18,r.nextInt(250)+60,new PeeViking(),new DrinkViking()),
                new Viking("Vikingo2",r.nextInt(60) +18,r.nextInt(250)+60,new PeeViking(),new DrinkViking()),
                new Viking("Vikingo3",r.nextInt(60) +18,r.nextInt(250)+60,new PeeViking(),new DrinkViking()),
                new Viking("Vikingo4",r.nextInt(60) +18,r.nextInt(250)+60,new PeeViking(),new DrinkViking()),
                new Viking("Vikingo5",r.nextInt(60) +18,r.nextInt(250)+60,new PeeViking(),new DrinkViking()),
                new Viking("Vikingo6",r.nextInt(60) +18,r.nextInt(250)+60,new PeeViking(),new DrinkViking()),
                new Viking("Vikingo7",r.nextInt(60) +18,r.nextInt(250)+60,new PeeViking(),new DrinkViking())
        );

        List<Human> spartanList = Arrays.asList(
                new Spartan("Spartano1",r.nextInt(60)+18,r.nextInt(250)+60,new PeeSpartan(),new DrinkSpartan()),
                new Spartan("Spartano2",r.nextInt(60)+18,r.nextInt(250)+60,new PeeSpartan(),new DrinkSpartan()),
                new Spartan("Spartano3",r.nextInt(60)+18,r.nextInt(250)+60,new PeeSpartan(),new DrinkSpartan()),
                new Spartan("Spartano4",r.nextInt(60)+18,r.nextInt(250)+60,new PeeSpartan(),new DrinkSpartan()),
                new Spartan("Spartano5",r.nextInt(60)+18,r.nextInt(250)+60,new PeeSpartan(),new DrinkSpartan()),
                new Spartan("Spartano6",r.nextInt(60)+18,r.nextInt(250)+60,new PeeSpartan(),new DrinkSpartan()),
                new Spartan("Spartano7",r.nextInt(60)+18,r.nextInt(250)+60,new PeeSpartan(),new DrinkSpartan())
        );

        Human ownerTavern = new OwnerTavern("Dueño1",34,100,new PeeSpartan(),new DrinkViking());


        System.out.println("ORIGINALES SIN ORDENAR ");
        System.out.println(spartanList);
        System.out.println(vikingList);

        // mi dni termina en 9 es impar debo ordenar por peso y sacar el primero

        System.out.println("\nMODIFICADOS ORDENADOS POR PESO Y SACANDO EL PRIMERO ");
        List<Human> vikingList1 = vikingList.stream().sorted(Comparator.comparing(Human::getWeight)).skip(1).collect(Collectors.toList());
        List<Human> spartanList1 = spartanList.stream().sorted(Comparator.comparing(Human::getWeight)).skip(1).collect(Collectors.toList());

        System.out.println(spartanList1);
        System.out.println(vikingList1 + "\n");

        MatchController game = new MatchController();

        game.finalBattle(game.startGame(vikingList1,spartanList1),ownerTavern);

        System.out.println("GAME OVER!");

    }



}
