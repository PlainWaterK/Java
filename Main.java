public class Main{
    private int balance;
    public static void main(String args[]){
        Main m1 = new Main(2,3);
        Main m2 = new Main();
        m1.setbalance(10);
        m2.setbalance(20);
        m1.showbalance();
        m2.showbalance();
    }
    void setbalance(int amount){
        this.balance = amount;
    }
    void showbalance(){
        System.out.println(this.balance);
    }

    Main(){
        this.balance=5;
    }

    Main(int amount){
        this.balance=amount;
    }
}

class A{
	A(/*variables*/){
		//…code
	}
}



// import java.util.*;

// public class Main{
//     public static void main(String args[]){
//         Scanner sc = new Scanner(System.in);
//         while(sc.hasNextLine()){
//             String str = sc.nextLine();
//             int index=0;
//             int len = str.length();
//             List<String> strs = new ArrayList<String>();
//             List<Integer> nums = new ArrayList<Integer>();
//             int num=0;
//             String currentStr = "";
//             while(index<len){
//                 char c = str.charAt(index);
//                 if(c>='0'&&c<='9'){
//                     num=num*10+c-'0';
//                     ++index;
//                 }
//                 else{
//                     switch(c){
//                         case'(':{
//                             strs.add(currentStr);
//                             currentStr="";
//                             nums.add(num);
//                             num=0;
//                             strs.add("(");
//                             ++index;
//                             break;
//                         }
//                         case'[':{
//                             strs.add(currentStr);
//                             currentStr="";
//                             nums.add(num);
//                             num=0;
//                             strs.add("[");
//                             ++index;
//                             break;
//                         }
//                         case'{':{
//                             strs.add(currentStr);
//                             currentStr="";
//                             nums.add(num);
//                             num=0;
//                             strs.add("{");
//                             ++index;
//                             break;
//                         }
//                         case'}':{

//                             while(strs.get(strs.size()-1)!="{"){
//                                 currentStr=strs.get(strs.size()-1)+currentStr;
//                                 strs.remove(strs.size()-1);
//                             }
//                             strs.remove(strs.size()-1);
//                             int repeatNum=nums.get(nums.size()-1);
//                             nums.remove(nums.size()-1);
//                             String originStr = currentStr;
//                             for(int k=0;k<repeatNum-1;++k){
//                                 currentStr = currentStr + originStr;
//                             }
//                             strs.add(currentStr);
//                             currentStr="";
//                             ++index;
//                             break;
//                         }
//                         case']':{
//                             while(strs.get(strs.size()-1)!="["){
//                                 currentStr=strs.get(strs.size()-1)+currentStr;
//                                 strs.remove(strs.size()-1);
//                             }
//                             strs.remove(strs.size()-1);
//                             int repeatNum=nums.get(nums.size()-1);
//                             nums.remove(nums.size()-1);
//                             String originStr = currentStr;
//                             for(int k=0;k<repeatNum-1;++k){
//                                 currentStr = currentStr + originStr;
//                             }
//                             strs.add(currentStr);
//                             currentStr="";
//                             ++index;
//                             break;
//                         }
//                         case')':{
//                             while(strs.get(strs.size()-1)!="("){
//                                 currentStr=strs.get(strs.size()-1)+currentStr;
//                                 strs.remove(strs.size()-1);
//                             }
//                             strs.remove(strs.size()-1);
//                             int repeatNum=nums.get(nums.size()-1);
//                             nums.remove(nums.size()-1);
//                             String originStr = currentStr;
//                             for(int k=0;k<repeatNum-1;++k){
//                                 currentStr = currentStr + originStr;
//                             }
//                             strs.add(currentStr);
//                             currentStr="";
//                             ++index;
//                             break;
//                         }
//                         default:{
//                             currentStr=currentStr+c;
//                             ++index;
//                             break;
//                         }
//                     }
//                 }
//             }
//             if(currentStr.length()!=0){
//                 strs.add(currentStr);
//                 currentStr="";
//             }
//             for(int i=strs.size()-1;i>=0;--i){
//                 String temp = strs.get(i);
//                 for(int j=temp.length()-1;j>=0;--j){
//                     System.out.print(temp.charAt(j));
//                 }
//             }
//             System.out.println();
//             // while(!strs.isEmpty()){
//             //     currentStr = strs.lastElement();
//             //     System.out.print(currentStr.);
//             //     strs.remove(strs.size()-1);
//             // }
//         }
//     }
// }



// import java.util.*;


// public class Main{
//     public static void main(String args[]){
//         Scanner sc = new Scanner(System.in);
//         Solution s = new Solution();
//         while(sc.hasNextInt()){
//             int N=sc.nextInt();
//             int M=sc.nextInt();
//             int height[][] = new int[N][M];
//             for(int i=0;i<N;++i){
//                 for(int j=0;j<M;++j){
//                     height[i][j]=sc.nextInt();
//                 }
//             }
//             int X,Y,Z,W;
//             X=sc.nextInt();
//             Y=sc.nextInt();
//             Z=sc.nextInt();
//             W=sc.nextInt();
//             boolean climbed[][] = new boolean[N][M];
//             System.out.println(s.climb(climbed, height, X,Y,Z,W,N,M)/1000000000);
//         }

//     }


// }

// class Solution{
//     public long climb(boolean climbed[][], int height[][],int x,int y,int x1,int y1,int N,int M){
//         if(x==x1&&y==y1)return 1;
//         int res=0;
//         if(x>0 && height[x-1][y]>height[x][y]){
//             climbed[x-1][y]=true;
//             res+=climb(climbed,height,x-1,y,x1,y1,N,M);
//             climbed[x-1][y]=false;
//         }
//         if(y>0 && height[x][y-1]>height[x][y]){
//             climbed[x][y-1]=true;
//             res+=climb(climbed,height,x,y-1,x1,y1,N,M);
//             climbed[x][y-1]=false;
//         }
//         if(x<N-1 && height[x+1][y]>height[x][y]){
//             climbed[x+1][y]=true;
//             res+=climb(climbed,height,x+1,y,x1,y1,N,M);
//             climbed[x+1][y]=false;
//         }
//         if(y<M-1 && height[x][y+1]>height[x][y]){
//             climbed[x][y+1]=true;
//             res+=climb(climbed,height,x-1,y,x1,y1,N,M);
//             climbed[x][y+1]=false;
//         }
//         return res;
//     }
// }




// import java.util.*;
// import java.util.Scanner;

// class Main{
//     public static void main(String[] args){
//         Scanner sc = new Scanner(System.in);
//         Solution s = new Solution();
//         Vector v = new Vector<>();
//         while(sc.hasNextInt()){
//             v.add(sc.nextInt());
//         }
//         int[] n = new int[v.size()];
//         for(int i=0;i<v.size();++i) n[i] = (int)v.elementAt(i);
//         System.out.println(s.maxProfit(n));
//         sc.close();
//     }
// }

// class Solution {
//     public int maxProfit(int[] prices) {
//         return MaxProfit(prices,prices.length-1,0,0);
//     }
    
//     public int MaxProfit(int[] prices, int index, int earned,int lastMaxCur){
//         if(index<0)return 0;
//         int res1=0,res2=0;
//         int MaxCur = lastMaxCur;
//         for(int i=index;i>0;--i){
//             if(prices[i]>prices[i-1]){
//                 MaxCur+=prices[i]-prices[i-1];
//                 res1 = Math.max(res1,MaxCur + MaxProfit(prices, index-3, earned+MaxCur, 0));
//                 MaxCur-=prices[i]-prices[i-1];
//             }else{
//                 res2 = Math.max(res2,MaxCur + MaxProfit(prices, index-2, earned+MaxCur, 0));
//                 MaxCur = 0;
//             }
//         }
//         return Math.max(res1, res2);
//     }
// }


// import java.util.*;
// public class Main{
//     public static void main(String args[]){
//         Scanner sc = new Scanner(System.in);

//         while(sc.hasNextInt()){
//             List<String> strs = new ArrayList<String>();
//             int N = sc.nextInt();
//             String str = sc.nextLine();
//             //System.out.println(str);
//             int cnt=0;
//             int index=1;
//             int len = str.length();
//             String temp="";
//             int spaceNum=0;
//             //System.out.println(len);
//             while(index<len){
//                 if(spaceNum==N)break;
//                 if(cnt==8){
//                     strs.add(temp);
//                     //System.out.println(temp);
//                     temp="";
//                     cnt=0;
//                 }else   if(str.charAt(index)==' '){
//                             if(cnt==0){
//                                 ++index;
//                                 ++spaceNum;
//                                 continue;
//                             }
//                             if(cnt<8){
//                                 for(int i=0;i<8-cnt;++i){
//                                     temp = temp + '0';
//                                 }
//                             }   
//                             strs.add(temp);
//                             //System.out.println(temp);
//                             temp="";
//                             ++index;
//                             cnt=0;
//                             ++spaceNum;
//                 }else{
//                     temp = temp + str.charAt(index);
//                     ++cnt;
//                     ++index;
                    
//                 }
//             }
//             if (cnt>0){
//                 for(int i=0;i<8-cnt;++i){
//                     temp=temp+'0';
//                 }
//                 strs.add(temp);
//                 //System.out.println(temp);
//                 cnt=0;
//                 temp="";
//             }
//             strs.sort(null);
//             //System.out.println(strs);
            
            
//             for(int i=0;i<strs.size()-1;++i){
//                 System.out.print(strs.get(i)+' ');
//             }
//             System.out.println(strs.get(strs.size()-1));
//         }
//     }
// }


