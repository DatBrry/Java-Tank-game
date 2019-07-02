import java.util.Scanner;

public class player
{
    Scanner s1 = new Scanner(System.in);
    tank[] owned = new tank[4];
    String name;
    String flag;
    public player()
    {
        
        for (int i = 0; i<4; i++)
        {
            owned[i] = new tank(this);
            owned[i].id = i;
        }
    }
    public void setName()
    {
        name = s1.next();
    }
 
    public void setFlag()
    {
        for (int i = 0; i<4; i++)
        {
            owned[i].flag = this.flag;
        }
    }

}