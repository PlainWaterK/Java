import java.util.*;
import java.util.Scanner;

class test{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        Solution s = new Solution();
        Vector v = new Vector<>();
        while(sc.hasNextInt()){
            v.add(sc.nextInt());
        }
        int[] n = new int[v.size()];
        for(int i=0;i<v.size();++i) n[i] = (int)v.elementAt(i);
        System.out.println(s.maxProfit(n));
        sc.close();
    }
}

class Solution {
    public int maxProfit(int[] prices) {
        return MaxProfit(prices,prices.length,0,0);
    }
    
    public int MaxProfit(int[] prices, int index, int earned,int lastMaxCur){
        if(index<0)return 0;
        int res1=0,res2=0;
        int MaxCur = lastMaxCur;
        
        for(int i=index-1;i>0;--i){
            if(prices[i]>prices[i-1]){
                MaxCur+=prices[i]-prices[i-1];
                res1 = earned + MaxCur + MaxProfit(prices, index-2, earned+MaxCur, 0);
            }else{
                res2 = earned + MaxCur + MaxProfit(prices, index-1, earned+MaxCur, 0);
            }
        }
        
        return Math.max(res1, res2);
    }
}