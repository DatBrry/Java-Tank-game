import java.util.Scanner;

public class match
{
    map map1 = new map();
    player p1 = new player(),
    p2 = new player();
    Scanner sc = new Scanner(System.in);
    turns turn = new turns();

    public match(){
        System.out.println("The Game has Started!");
        System.out.println("Input the player names!");
        p1.setName();
        p2.setName();
        p1.flag = " + ";
        p2.flag =  " o ";
        p1.setFlag();
        p2.setFlag();
        System.out.println("Name 1: "+p1.name+" Name 2: "+p2.name);

        System.out.println("Setting units!");

        for(int i=0; i<4; i++){
            map1.a[0][i+3] = p1.owned[i];
            p1.owned[i].y = 0; p1.owned[i].x = i+3;
            map1.a[9][i+3] = p2.owned[i];
            p2.owned[i].y = 9; p2.owned[i].x = i+3;
            
        }
        map1.printMap();
        boolean go = false;

        while(go == false)
        {   
            System.out.println(p1.name+"'s turn");
            for(int i=0; i<4;i++)
            {
                if (p1.owned[i] != null && p1.owned[i].hp > 0){
                System.out.println("Input movement order for unit "+ i);
                char x = sc.next().charAt(0);
                p1.owned[i].move(x, map1.a);
                map1.printMap();
                System.out.println("Input attack order for unit "+ i);
                char s = sc.next().charAt(0);
                p1.owned[i].attack(s, map1.a, p1);
                map1.printMap();
                }
            }

            System.out.println(p2.name+"'s turn");
            for(int i=0; i<4;i++)
            {
                if (p2.owned[i] != null && p2.owned[i].hp > 0){
                System.out.println("Input movement order for unit "+ i);
                char x = sc.next().charAt(0);
                p2.owned[i].move(x, map1.a);
                map1.printMap();
                System.out.println("Input attack order for unit "+ i);
                char s = sc.next().charAt(0);
                p2.owned[i].attack(s, map1.a, p2);
                map1.printMap();
                }

            }
            for(int i=0; i<4;i++)
            {   
                if (p1.owned[i] != null && p1.owned[i].hp > 0)
                System.out.print("unit "+i+": "+p1.owned[i].hp);
                
            }
            System.out.println();

            for(int i=0; i<4;i++)
            { 
            if (p2.owned[i] != null  && p2.owned[i].hp > 0)
                System.out.print("unit "+i+": "+p2.owned[i].hp);
            }
           go = turn.proceedTurn(p1, p2);
        }

        System.out.print("The winner is"+ turn.winner);

        
   
    }

}