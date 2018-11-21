import java.io.IOException;
import java.util.*;


//对表达式进行计算
public class ExpressionOperation {
	String expr;//表达式字符串
	Stack operationStack=new Stack();//操作符栈
	Stack priorityStack=new Stack();//优先级栈
	Stack numStack=new Stack();//数据栈
	boolean isOx;//用于判断当前输入是否为十六进制数字
	
	//读取字符串，且将字符串所有字符均转换为大写，方便处理
	public void enterExpr(String str) {
		expr=str;
		expr=expr.toUpperCase();//将字符串转换成大写
		expr=expr.replaceAll("&LT&LT", "<<");//将转义符变成实际操作符
		expr=expr.replaceAll("&GT&GT", ">>");//将转义符变成实际操作符
		System.out.println(expr);
	}
	
	//表达式计算入口
	public int exprOperation() {
		int tempVal, currentVal=-1;
		int len=expr.length();
		isOx=false;
		
		for (int index=0; index<len; ++index) {
			char currentC=expr.charAt(index);
			if ((tempVal=isVal(currentC))>-1) {	//判断当前字符是否是数字
				if (currentVal==-1)currentVal=0;
				if(isOx) currentVal=currentVal*16+tempVal;	//按进制来获得数字大小
				else currentVal=currentVal*10+tempVal;
			}
			else {
				if(currentC=='X') isOx=true;	//当前字符为X，则之后输入的数值是十六进制方式
				else {
					//当前字符为操作符，将前一个数值存入数据栈，对当前操作符进行操作
					//并将当前值与十六进制判断标记赋为默认值
					if(currentVal>=0)numStack.push(currentVal);
					index+=OperationProcess(currentC);
					currentVal=-1;
					isOx=false;
				}
			}
		}
		
		//将最后一个数值压入数据栈
		numStack.push(currentVal);
		//将剩余操作符全部出栈进行处理
		while(!operationStack.empty()){
			calculate((char)operationStack.pop());
		}
		
		//返回最后的结果值
		return (int)numStack.pop();
	}
	
	//判断当前输入字符是否是数值
	//若是数值，则返回对应的十进制值
	public int isVal(char chr) {
		if (isBetw(chr,'0','9')) return chr-'0';
		else {
			if (isOx && isBetw(chr,'A','F')) return chr-'A'+10;
			else return -1;
		}
	}
	
	//判断字符是否落在对应区间内
	public boolean isBetw(char val, char bound1, char bound2 ) {
		if (val>=bound1 && val<=bound2)return true;
		else return false;
	}
	
	//对操作符进行处理
	public int OperationProcess(char opr) {
		int priority=0;
		int len=0;
		//给不同的操作符赋予不同的优先级权值，用于之后的计算
		//前一个操作符优先级高于或等于当前操作符的优先级时，
		//将前一个操作符出栈并计算
		switch(opr) {
		case '+':
		case '-':
			priority=1;
			while(judgePrio(priority)) {
				calculate((char)operationStack.pop());
				priorityStack.pop();
			}
			priorityStack.push(1);
			break;
		case '*':
		case '/':
			priority=2;
			while(judgePrio(priority)) {
				calculate((char)operationStack.pop());
				priorityStack.pop();
			}
			priorityStack.push(2);
			break;
		case '<':
		case '>':
			priority=3;
			while(judgePrio(priority)) {
				calculate((char)operationStack.pop());
				priorityStack.pop();
			}
			priorityStack.push(3);
			len=1;
			break;
		case 'H':
		case 'L':
			priority=4;
			while(judgePrio(priority)) {
				calculate((char)operationStack.pop());
				priorityStack.pop();
			}
			priorityStack.push(4);
			len=3;
			break;
		//左括号直接压栈，等待右括号出现
		case '(':
			priority=0;
			priorityStack.push(priority);
			break;
		//将操作符不停出栈进行计算直到遇到左括号
		case ')':
			while(!operationStack.empty() && (char)operationStack.lastElement()!='(') {
				calculate((char)operationStack.pop());
				priorityStack.pop();
			}
			operationStack.pop();
			priorityStack.pop();
			break;
		
		default:break;
		}
		
		//若当前操作符非右括号，则将操作符压入操作符栈
		if (opr!=')'&&opr!='&') operationStack.push(opr);
		
		return len;
	}
	
	//在操作符栈非空的情况下，判断前一个操作符的优先级是否高于自己
	public boolean judgePrio(int currentPrio) {
		return (!operationStack.empty() && (int)priorityStack.lastElement()>=currentPrio);
	}
	
	public void calculate(char opr) {
		//取出前两个操作数
		int num1,num2=0;
		num1=(int)numStack.pop();
		//若操作符是单目运算符，则不需要取出两个数值
		if (opr!='H' && opr!='L') num2=(int)numStack.pop();
		
		//根据操作符进行相应运算后再存入数据堆栈
		switch(opr) {
		case '+':
			numStack.push(num2+num1);break;
		case '-':
			numStack.push(num2-num1);break;
		case '*':
			numStack.push(num2*num1);break;
		case '/':
			numStack.push(num2/num1);break;
		case '<':
			numStack.push(num2<<num1);break;
		case '>':
			numStack.push(num2>>num1);break;
		case 'H':
			numStack.push(num1 & 0xffff0000);break;
		case 'L':
			numStack.push(num1 & 0x0000ffff);break;
		default:
			break;
		}
	}
	
}
