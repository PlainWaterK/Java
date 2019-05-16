import java.util.ArrayList;
import java.util.Scanner;

public class Main{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int m,n;
        
        while(sc.hasNextInt()){
            m = sc.nextInt();
            n = sc.nextInt();
            int heights[] = new int[5000];
            int h;
            int max=0;
            int res=Integer.MAX_VALUE;
            ArrayList<Integer> list = new ArrayList<Integer>();
            for(int i=0;i<m;++i){
                h = sc.nextInt();
                ++heights[h];
                max = h>max?h:max;
                if(list.indexOf(h)==-1)list.add(h);
            }
            list.sort(null);
            //System.out.println(list);
            for(int i=0;i<list.size();++i){
                int temp = 0;
                int count = heights[list.get(i)];
                if(count<n){
                    for(int j=i-1;j>=0;--j){
                        if(count+heights[list.get(j)]>=n){
                            temp += (list.get(i)-list.get(j))*(n-count);
                            count=n;
                            break;
                        }else{
                            temp += (list.get(i)-list.get(j))*heights[list.get(j)];
                            count += heights[list.get(j)];
                        }
                    }
                }
                res = count>=n&&temp<res?temp:res;
            }
            System.out.println(res);
        }
        return;
    }
}

// public  class Main{
//     public static void main(String args[]){
//         Scanner sc = new Scanner(System.in);
//         int n,k;

//         while(sc.hasNextInt()){
//             n = sc.nextInt();
//             k = sc.nextInt();
//             int left,right;
//             int nums[] = new int[50000];
//             ArrayList<Integer> list = new ArrayList<Integer>();
//             int max = 0;
//             int count = 0;
//             for(int i=0;i<n;++i){
//                 left = sc.nextInt();
//                 right = sc.nextInt();
//                 for(int j=left*2;j<=right*2;++j) ++nums[j];
//                 max = right>max?right:max;
//             }
//             boolean flag = false;
//             for(int i=0;i<=max*2;++i){
//                 if(nums[i]>=k && !flag){
//                     ++count;
//                     flag = true;
//                     list.add(i);
//                 } 
//                 else if(flag && nums[i]<k){
//                     flag =false;
//                     list.add(i-1);
//                 }
//             }
//             if(flag)list.add(max*2);
//             System.out.println(count);
//             for(int i=0;i<list.size();i+=2){
//                 System.out.println(Integer.toString(list.get(i)/2)+' '+Integer.toString(list.get(i+1)/2));
//             }
//         }
//         return;
//     }
// }


// public class Main{
//     public static void main(String args[]){
//         Scanner sc = new Scanner(System.in);
//         long n,k;
//         long nums[] = new long[30];
//         while(sc.hasNextInt()){
//             n = sc.nextInt();
//             k = sc.nextInt();
//             for(int i=0;i<k;++i){
//                 nums[i] = sc.nextInt();
//             }
//             long res = n;
//             for(int i=0;i<k;++i){
//                 res -= n-nums[i];
//             }
//             res = res<0?0:res;
//             System.out.println(res);
//         }
//     }
// }




// public class Main{
//     public static void main(String args[]){
//         Scanner sc = new Scanner(System.in);
//         String str;
//         while(sc.hasNextLine()){
//             str = sc.nextLine();
//             int count = 0;
//             for(int i=0; i < str.length()-1;++i){
//                 if(str.charAt(i)==str.charAt(i+1)){
//                     int left = i-1;
//                     int right = i+2;
//                     //--i;
//                     ++count;
//                     while(left>=0&&right<str.length()&&(str.charAt(left)==str.charAt(right))){
//                         --left;
//                         ++right;
//                         ++count;
//                         //--i;
//                     }
//                     if (left>=0&&right<=str.length()-1){
//                         str= str.substring(0, left+1)+str.substring(right,str.length());
//                     } else if(left<0){
//                         str = str.substring(right,str.length());
//                     }else {
//                         str= str.substring(0, left+1);
//                     }
//                     i=(left<0)?-1:left-1;
//                 }
//             }
//             System.out.println(count);
//         }
//     }
// }

// class Solution{

// }



// public class Main{


//     public static void main(String args[]){
//         Solution s = new Solution();
//         Scanner sc = new Scanner(System.in);
//         int[][] image = new int[2][3];
//         int r,c,newColor;
//         for(int i=0;i<2;++i){
//             for(int j=0;j<3;++j){
//                 image[i][j] = sc.nextInt();
//             }
//         }
//         r = sc.nextInt();
//         c = sc.nextInt();
//         newColor = sc.nextInt();
//         s.floodFill(image, r, c, newColor);
//         return;
//     }
// }

// class Solution {
//     public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
//         int color = image[sr][sc];
//         image[sr][sc] = newColor;
//         addColor(image,sr,sc,newColor,color);
//         return image;
//     }
    
//     public void addColor(int[][] image, int x, int y, int newColor, int color ){
//         if(x>0 && image[x-1][y]==color){
//             image[x-1][y] = newColor;
//             addColor(image,x-1,y,newColor,color);
//         }
//         if(y>0 && image[x][y-1]==color){
//             image[x][y-1] = newColor;
//             addColor(image,x,y-1,newColor,color);
//         }
//         if(x<image.length-1 && image[x+1][y]==color){
//             image[x+1][y] = newColor;
//             addColor(image,x+1,y,newColor,color);
//         }
//         if(y<image[0].length-1 && image[x][y+1]==color){
//             image[x][y+1] = newColor;
//             addColor(image,x,y+1,newColor,color);
//         }
//         return;
        
//     }
// }



// public class Main{
//     private Display hour = new Display(24);
//     private Display minute = new Display(60);
//     public static void main(String args[]){
//         int nums[] = new int[20];
//         nums.i
//     }
// }

// class Display{
//     private int value = 0;
//     private int limit =0;

//     public Display(int limit){
//         this.limit = limit;
//     }

    
// }

// public class Main{
//     private int balance;
//     public static void main(String args[]){
//         Main m1 = new Main(2,3);
//         Main m2 = new Main();
//         m1.setbalance(10);
//         m2.setbalance(20);
//         m1.showbalance();
//         m2.showbalance();
//     }
//     void setbalance(int amount){
//         this.balance = amount;
//     }
//     void showbalance(){
//         System.out.println(this.balance);
//     }

//     Main(){
//         this.balance=5;
//     }

//     Main(int amount){
//         this.balance=amount;
//     }
// }

// class A{
// 	A(/*variables*/){
// 		//…code
// 	}
// }


// import java.util.Scanner;
// public class Main{
//     public static void main(String[] args) {
// 		Scanner in = new Scanner(System.in);
// 		Fraction a = new Fraction(in.nextInt(), in.nextInt());
// 		Fraction b = new Fraction(in.nextInt(),in.nextInt());
// 		a.print();
// 		b.print();
// 		a.plus(b).print();
// 		a.multiply(b).plus(new Fraction(5,6)).print();
// 		a.print();
// 		b.print();
// 		in.close();
// 	}
// }

// class Fraction{
//     private int a;
//     private int b;

//     Fraction(int a, int b){
//         this.a = a;
//         this.b = b;
//     }

//     double toDouble(){
//         return (double)a/b;
//     }

//     Fraction plus(Fraction r){
//         int tempa = this.a*r.b+this.b*r.a;
//         int tempb = this.b*r.b;
//         return standarlize(tempa,tempb);
//     }

//     Fraction multiply(Fraction r){
//         int tempa = this.a*r.a;
//         int tempb = this.b*r.b;
//         return standarlize(tempa, tempb);
//     }

//     void print(){
//         Fraction finalFrac = standarlize(a, b);
//         if(finalFrac.a==finalFrac.b){
//             System.out.println(1);
//         }else{
            
//             System.out.println(finalFrac.a+"/"+finalFrac.b);
//         }
//     }

//     Fraction standarlize(int tempa,int tempb){
//         int divisor=tempa;
//         int dividend=tempb;
//         int temp=tempb;
//         while(divisor % dividend!=0){
//             temp = divisor % dividend;
//             divisor = dividend;
//             dividend = temp;
//         }
//         tempa/=temp;
//         tempb/=temp;
//         return new Fraction(tempa,tempb);
//     }
// }


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
//         while(sc.hasNextInt()){//             v.add(sc.nextInt());
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


