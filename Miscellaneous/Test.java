import java.util.Scanner;

public class Test {
	public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int cnt=0;
        while(n>1){
            if(n%2==1){
                n=n*3+1;
            }
            else{
                n/=2;
            }
            ++cnt;
        }

        System.out.println(cnt);
	}
}