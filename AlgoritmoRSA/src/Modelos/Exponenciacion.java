package Modelos;
public class Exponenciacion {
    public int CalcularExp(int a,int k,int z)
    {
        int exp=1;
        int xp=a%z;
        while(k>0)
        {
            if((k%2)!=0)
            {
                exp=(exp*xp)%z;
            }
            xp=(xp*xp)%z;
            k=k/2;
        }
        return exp;
    }
}
