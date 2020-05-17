import java.util.Scanner;
public class coins {
    public static void FindMinCoins(int n,int[] values,int[]valuescounts,int money,int[] coinUsed){
        for(int i=1;i<=money;i++)
            coinUsed[i]=999;//给每种面值所需硬币数初始化一个很大的数值。当最后如果得出的结果是这个数时，说明凑不出来
        //遍历硬币面额数组，找到前边所能找到的最小硬币数加1
        for(int i=0;i<n;i++) {
            for(int j=0;j<valuescounts[i];j++) {
                for(int k=money;k>=values[i];k--) {
                    int temp=coinUsed[k-values[i]]+1;
                    /*找到几种情况中最小的硬币数 如使用1、2、5元 凑18元：
                     * 先用1元凑coinUsed[18-1]+1、
                     * 先用2元凑coinUsed[18-2]+1、
                     * 先用5元凑coinUsed[18-5]+1
                     */
                    if(temp<coinUsed[k])
                        coinUsed[k]=temp;
                }
            }
        }
        if(coinUsed[money]==999)//若面值所需硬币数还是初始化值，说明在输入的条件下凑不出来
            System.out.println("-1");
        else
            System.out.println(coinUsed[money]);
    }


    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        int n;//硬币面值的种类数
        n=input.nextInt();
        int[]T=new int[n];//T用来保存硬币面值
        int[]Coins=new int[n];//Coins用来保存每种硬币的个数
        for(int i=0;i<n;i++)
        {
            T[i]=input.nextInt();
            Coins[i]=input.nextInt();
        }
        // 需要找零的面值      
        int money = input.nextInt();
        // 保存每一个面值找零所需的最小硬币数，0号单元舍弃不用，所以要多加1      
        int[] coinsUsed = new int[money + 1];
        FindMinCoins(n,T,Coins,money,coinsUsed);
    }
}