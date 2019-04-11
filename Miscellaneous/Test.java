import java.util.Scanner;

class Test{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();
		String t = sc.nextLine();
		System.out.println(func(s, t));
		return;

	}

	public static char func(String s, String t){
		int num1[] = new int[26];
		int num2[] = new int[26];
		for(int i=0; i<s.length(); ++i){
			++num1[s.charAt(i)-'a'];
		}
		for(int i=0; i<t.length(); ++i){
			++num2[t.charAt(i)-'a'];
		}
		for(int i=0; i<26; ++i){
			if(num1[i]!=num2[i])return (char)('a'+i);
		}
		return 'a';
	}
}