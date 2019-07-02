public class tank{
    
    int hp = 100,
        att = 50,
        def = 30,
        rng = 2,
        exp = 0,
        level = 1,
        x,
        y,
        id;
        String flag;

    player owner;

    public tank(player p)
    {
        this.owner = p;
    }
    
    public void attack(char x, tank a[][], player j){
        boolean check;
        switch (x) {
            case 'w':
                if(a[this.y-1][this.x] != null && this.y-1 >0)
                {
                check = a[this.y - 1][this.x].defense(this.att);
                if (check==true)
                    {
                        j.owned[a[this.y - 1][this.x].id] = null;
                        a[this.y - 1][this.x] = null;
                    }
                }
                else System.out.println("illegal move");
                break;
            case 's':
                if(a[this.y+1][this.x] != null&& this.y < 9)
                {
                   check = a[this.y+1][this.x].defense(this.att);
                   if (check == true)
                   {
                        j.owned[a[this.y+1][this.x].id] = null;
                        a[this.y+1][this.x] = null;
                   }
                }
                else System.out.println("illegal move");
                break;

                case 'd':
                if(a[this.y][this.x+1] != null && this.x<9 )
                {
                    check = a[this.y][this.x+1].defense(this.att);
                    if (check == true)
                    {
                        j.owned[a[this.y][this.x+1].id] = null;
                        a[this.y][this.x+1] = null;
                    }
                }
                else System.out.println("illegal move");
                break;
                case 'a':
                if(a[this.y][this.x-1] != null && this.x > 0)
                {
                    check = a[this.y][this.x-1].defense(this.att);
                    if (check == true)
                    {
                        j.owned[a[this.y][this.x-1].id] = null;
                        a[this.y][this.x-1] = null;
                    }
                }
                else System.out.println("illegal move");
                break;
            
                case 'h':
                this.hp = this.hp + (this.hp/2);
                break;
                case 'j':
                this.hp = this.def + (this.def/2);
                break;
            default:
                break;
        }
    }
    public boolean defense(int x){
        this.hp = this.hp-(x-this.def);
        if(this.hp <= 0)
            return true;
        else
            return false;
    }

    public void move(char x, tank a[][])
    {
        switch (x) {
            case 'w':
                if(this.y>0 && a[this.y-1][this.x] == null)
                {
                    a[this.y][this.x] = null;
                    a[this.y-1][this.x] = this;
                    this.y--;
                }
                else System.out.println("illegal move");
                break;
            case 's':
                if(this.y<9 && a[this.y+1][this.x] == null)
                {
                    a[this.y][this.x] = null;
                    a[this.y+1][this.x] = this;
                    this.y++;
                }
                else System.out.println("illegal move");
                break;

                case 'd':
                if(this.x<9 && a[this.y][this.x+1] == null )
                {
                    a[this.y][this.x] = null;
                    a[this.y][this.x+1] = this;
                    this.x++;
                }
                else System.out.println("illegal move");
                break;
                case 'a':
                if(this.x>0 && a[this.y][this.x-1] == null)
                {
                    a[this.y][this.x] = null;
                    a[this.y][this.x-1] = this;
                    this.x--;
                }
                else System.out.println("illegal move");
                break;
            
        
            default:
                break;
        }
    }





}