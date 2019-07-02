public class turns
{
    boolean gameover = false;
    int turnNum = 0;
    String winner;
    float score1, score2, s1, s2;
    int c1, c2;

    public boolean proceedTurn(player p1, player p2){
        this.turnNum++;
        System.out.println("turn proceeds");
        this.s1 = 0;
        this.s2 = 0;
        this.c1 = 0;
        this.c2 = 0;
        for(int i=0; i<4;i++)
            {
                if (p1.owned[i] != null && p1.owned[i].hp > 0)
                    this.s1 += p1.owned[i].hp;
                    this.c1++;
                if (p2.owned[i] != null && p2.owned[i].hp > 0)
                    this.s2 += p2.owned[i].hp;
                    this.c2++;
            }
        this.score1 = this.s1;
        this.score2 = this.s2;
        if (this.c1 > this.c2)
            this.winner = p1.name;
        else if (this.c2 > this.c1)
            this.winner = p2.name;
        else {
                if(this.score1>this.score2)
                    this.winner = p1.name;
                else if (this.score2 > this.score1)
                    this.winner = p2.name;
                else
                    this.winner = "draw";
        }


        if (turnNum > 19)
            return true;
        else
            return false;
    }
}