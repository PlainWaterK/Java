import java.util.Scanner;
import java.util.*;

public class CountAndSay{
    public static void main(String[] args){
        int n;
        System.out.println("please enter n: ");
        Scanner sc = new Scanner(System.in);
        n=sc.nextInt();
        System.out.println(Solution(n));
        sc.close();
    }

    public static String Solution(int n){
        StringBuilder result=new StringBuilder("1");
        char currentC;
        int count;
        StringBuilder tempStr;
        for(int i=1; i<n; ++i){
            count=1;
            currentC=result.charAt(0);
            tempStr=new StringBuilder();
            //Count the same chars and append number and char to tempStr
            for(int j=1; j<result.length(); ++j){
                if(currentC!=result.charAt(j)){
                    tempStr.append(count).append(currentC);
                    count=1;
                    currentC= result.charAt(j);
                }
                else{
                    ++count;
                }
            }
            tempStr.append(count).append(currentC);
            result=tempStr;
        }
        return result.toString();
    }
}