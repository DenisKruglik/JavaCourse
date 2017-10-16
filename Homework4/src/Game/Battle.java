package Game;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Battle {
    public static void main(String args[]){
        ArrayList<Creature> team1 = new ArrayList<>();
        ArrayList<Creature> team2 = new ArrayList<>();
        team1.add(new Wizard());
        team1.add(new Paladin());
        team1.add(new Berserk());
        team2.add(new Wizard());
        team2.add(new Paladin());
        team2.add(new Berserk());
        Thread battle = new Thread(new Runnable() {
            @Override
            public void run() {
                int count = 1;
                while(!team1.isEmpty() && !team2.isEmpty()){
                    switch (count){
                        case 1:
                            System.out.println("Team 1 move!");
                            this.round(team1, team2);
                            count = 2;
                            break;
                        case 2:
                            System.out.println("Team 2 move!");
                            this.round(team2, team1);
                            count = 1;
                            break;
                    }
                }
                if (team1.isEmpty()){
                    System.out.println("Team 2 won!");
                }else if(team2.isEmpty()){
                    System.out.println("Team 1 won!");
                }
            }

            public void round(ArrayList<Creature> team1, ArrayList<Creature> team2){
                for (Creature warrior:team1
                     ) {
                    int ind = (int)(Math.floor(Math.random() * team2.size()));
                    Creature enemy = team2.get(ind);
                    if (warrior.attack(enemy)){
                        team2.remove(ind);
                        if (team2.isEmpty()){
                            return;
                        }
                    }
                    switch (warrior.getSkill().getSkillType()){
                        case SELF:
                            warrior.getSkill().cast(warrior, warrior);
                            break;
                        case ENEMY:
                            ind = (int)(Math.floor(Math.random() * team2.size()));
                            enemy = team2.get(ind);
                            if (warrior.getSkill().cast(enemy, warrior)){
                                team2.remove(ind);
                                if (team2.isEmpty()){
                                    return;
                                }
                            }
                            break;
                        case FRIEND:
                            ind = (int)(Math.floor(Math.random() * team1.size()));
                            Creature friend = team1.get(ind);
                            warrior.getSkill().cast(friend, warrior);
                            break;
                    }
                    try{
                        Thread.sleep(2000);
                    }catch (InterruptedException e){
                        System.out.println(e.getMessage());
                    }
                }
            }
        });
        Thread UI = new Thread(new Runnable() {
            @Override
            public void run() {
                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                String str = "";
                int n = 0;
                while(true){
                    try{
                        str = br.readLine();
                    }catch(Exception e){
                        System.out.println(e.getMessage());
                    }
                    if (str == ""){
                        str = "0";
                    }
                    n = Integer.valueOf(str);
                    switch (n){
                        case 1:
                            Battle.addRandomWarrior(team1, n);
                            break;
                        case 2:
                            Battle.addRandomWarrior(team2, n );
                            break;
                        case 3:
                            System.out.println(team1.size());
                            break;
                        case 4:
                            System.out.println(team2.size());
                            break;
                    }
                }
            }
        });
        UI.setDaemon(true);
        battle.start();
        UI.start();
    }

    public static void addRandomWarrior(ArrayList<Creature> team, int m){
        int n = (int)(Math.random() * 3);
        switch (n){
            case 0:
                team.add(new Wizard());
                System.out.println("Wizard was added to the team " + m);
                break;
            case 1:
                team.add(new Paladin());
                System.out.println("Paladin was added to the team " + m);
                break;
            case 2:
                team.add(new Berserk());
                System.out.println("Berserk was added to the team " + m);
                break;
        }
    }
}
