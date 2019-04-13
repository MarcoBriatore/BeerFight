package UTN.controller;

import UTN.dao.SaveGameMySql;
import UTN.model.Human;
import UTN.model.OwnerTavern;
import UTN.model.Spartan;
import UTN.model.Viking;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class MatchController {


    public List<Human> startGame(List<Human> vikingList ,List<Human> spartanList)
    {


        List<Human> winners = new ArrayList<>();
        if(vikingList.size() == spartanList.size())
        {
            for (int i=0; i< spartanList.size();i++)
            {
                Viking v = vikingList.get(i) instanceof Viking ? (Viking) vikingList.get(i) : null;
                Spartan s = spartanList.get(i) instanceof Spartan ? (Spartan) spartanList.get(i) : null;
                if(!Objects.isNull(v) && !Objects.isNull(s))
                {
                    winners.add(match(v,s));
                }
            }
        }
        else
            System.out.println("--- Hey!" + vikingList.size() + " VS " + spartanList.size() +
                    " tienen que estar igualados para que sea una competencia justa");


        return winners;
    }



    public Human match(Viking viking, Spartan spartan)
    {

        boolean inGame = true;
        int round = 1;
        int qBv = 0; // Quantity Beer Viking
        int qBs = 0; // Quantity Beer Spartan
        Human winner = null;
        System.out.println("-----"+viking.getName() +" VS " +spartan.getName() +"-----");
            while(inGame) {
                if (viking.getMetabolism() >= qBv && spartan.getMetabolism() >= qBs) {
                    System.out.println("-----Ronda " + (round++) +"º-----");
                    qBv+=viking.getDrink().toDrink();
                    qBs+=spartan.getDrink().toDrink();
                } else {
                    inGame = false;
                }
            }
        // GANO EL ESPARTANO
        if(viking.getMetabolism() >= qBv && spartan.getMetabolism() <= qBs)
        {
            winner = spartan;
            SaveGameMySql.getInstance().saveWinner(spartan,qBs);
            System.out.println(viking.getPee().toPee() + viking.getName());

            System.out.println("---------EL GANADOR ESTA RONDA ES "+spartan.getName()+ " CON " + qBs + " PINTAS A FAVOR---------\n");
        }
        // GANO EL VIKINGO
        else if(viking.getMetabolism() <= qBv && spartan.getMetabolism() >= qBs){

            winner = viking;
            SaveGameMySql.getInstance().saveWinner(viking,qBv);
            System.out.println(spartan.getPee().toPee() + spartan.getName());
            System.out.println("---------EL GANADOR ESTA RONDA ES "+viking.getName()+ " CON " + qBv + " PINTAS A FAVOR ---------\n");
        }
        // FUE UN EMPATE AMBOS PERDIERON
        else
        {
            System.out.println(viking.getPee().toPee() + viking.getName());
            System.out.println(spartan.getPee().toPee() + spartan.getName());
            System.out.println("---------HUUUUUBOOOO UUUUN EMPATEEEEEE---------");
        }
        return winner;
    }

    public void finalBattle(List<Human> winners, Human boss)
    {

        for (Human human : winners ) {
            if (!Objects.isNull(human)) {
                bossFight(human,(OwnerTavern) boss);
            }
            else
            {
                System.out.println("\n---- Wow! ¿Los que empataron siguen en el baño?.... Ah bueno que pase el siguiente------\n");
            }
        }
    }


    private void bossFight(Human winner, OwnerTavern boss)
    {

        int round = 1;
        int qBw = 0; // Quantity Beer Winner
        int qBb = 0; // Quantity Beer Boss
        boolean inGame = true;
        Viking v = winner instanceof Viking ? (Viking) winner : null;
        Spartan s = winner instanceof Spartan ? (Spartan) winner : null;
        if(!Objects.isNull(v))
        {
            System.out.println("-----"+v.getName() +" VS " +boss.getName() +"-----");
            while(inGame){
                if (v.getMetabolism() >= qBw && boss.getMetabolism() >= qBb) {
                    System.out.println("-----Ronda " + (round++) +"º PELEA FINAL!-----");
                    qBw+=v.getDrink().toDrink();
                    qBb+=boss.getDrink().toDrink();
                } else {
                    inGame = false;
                }
            }
            if(v.getMetabolism() <= qBw)
            {
                System.out.println("EL GANADOR ES:" + boss.getName() + " CON " + qBb + " PINTAS A FAVOR");
                System.out.println(v.getPee().toPee() + v.getName() +
                "\n Wow! estos vikingos dieron pelea! Pero al final siempre soy el ganador!\n");
            }
            else{
                SaveGameMySql.getInstance().saveWinner(v,qBw);
                System.out.println("EL GANADOR ES:" + v.getName() + " CON " + qBw + " PINTAS A FAVOR");
                System.out.println(boss.getPee().toPee() + boss.getName());
            }
        }
        else
        {
            System.out.println("-----"+s.getName() +" VS " +boss.getName() +"-----");
            while(inGame)
            {
                if (s.getMetabolism() != qBw && boss.getMetabolism() != qBb) {
                    System.out.println("-----Ronda " + (round++) +"º PELEA FINAL! -----");
                    qBw+=s.getDrink().toDrink();
                    qBb+=boss.getDrink().toDrink();
                } else {
                    inGame = false;
                }
            }
            if(s.getMetabolism() <= qBw)
            {

                System.out.println("EL GANADOR ES:" + boss.getName() + " CON " + qBb + " PINTAS A FAVOR");
                System.out.println(s.getPee().toPee() + s.getName() +
                "\n Jajaja! y pensar que fui facil contigo espartano.\n");
            }
            else
            {
                SaveGameMySql.getInstance().saveWinner(s,qBw);
                System.out.println("EL GANADOR ES:" + s.getName() + " CON " + qBw + " PINTAS A FAVOR");
                System.out.println(boss.getPee().toPee() + boss.getName());
            }

        }

    }





}
