

public class map 
{
    tank a[][] = new tank[10][10];

    public void printMap()
    {
        for(int i=0; i<10; i++)
        {
            for(int j=0; j<10;j++)
            {
                if(a[i][j]==null)
                    System.out.print(" - ");
                else
                    System.out.print(a[i][j].flag);
            }
            System.out.println();
        }
    }
    
    
}

