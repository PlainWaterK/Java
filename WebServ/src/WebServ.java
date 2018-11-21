import java.io.*;
import java.net.*;

public class WebServ {   
  
	public static void main(String[] args)
	{
		ServerSocket server;
		Socket client;
		//设置相对基础路径
		String base_url="D:/_JJT_Eclipse_Java/WebServ/src/";
		try{
			//约定端口号
			server = new ServerSocket(80); 
		} catch (Exception e){
			System.out.println( e );
			return;
		}
	
		//向服务器提供表单，进行处理
		while(true){
			try{
				System.out.println("\n\naccept…");
				//接受连接
				client = server.accept();   
				System.out.println("客户端信息已接收");
				//读取客户端信息输入流
				BufferedReader bs=
					new BufferedReader(
					new InputStreamReader(
					client.getInputStream()));
				
				//获取url
				String cmd = bs.readLine();
				System.out.println("--=>" + cmd);
				String url=cmd.substring(
					cmd.indexOf("/")+1, cmd.lastIndexOf(" "));
				System.out.println("--=>" + url);
				
				//获取实际文件输入流
				DataInputStream DatInS = 
					new DataInputStream(
					new BufferedInputStream(
					new FileInputStream(base_url+url)));
				//获取客户端输出流
				DataOutputStream DatOutS=
					new DataOutputStream(
					new BufferedOutputStream(
					client.getOutputStream()));
				
				//进行数据传输
				new SendData(DatInS,DatOutS).start();
				
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
};

//输出信息
//同时判断是否为嵌入式语句，若为嵌入式程序，则进行相应处理
//该程序仅处理表达式计算的嵌入式程序
class SendData extends Thread
{
	DataInputStream DatInS;
	DataOutputStream DatOutS;
	//表达式字符串
	String str="";
	//当前状态标量
	int state=0;
	
	SendData(DataInputStream DatInS, DataOutputStream DatOutS){
		this.DatInS=DatInS; this.DatOutS=DatOutS;
	}
	
	public void run(){
		try{
			try{
				while(true) {
					byte b=DatInS.readByte();
					char c=(char)b;
					
					//根据输入字符对状态标量进行修改
					switch(state) {
					case 0:
						if (c=='<') state=1; 
						break;
					case 1:
						if (c=='%') state=2;
						else {
							state=0;
							//补充输出，将之前未输出的<输出
							DatOutS.writeByte('<');
						}
						break;
					case 2:
						if (c=='%') state=3; break;
					case 3:
						if (c=='>') state=4; break;
					default:break;
					}
					
					//状态标量为0表示非嵌入式程序
					//否则为嵌入式程序，将空格略去后存入str字符串内
					if (state==0)DatOutS.writeByte(b);
					else if (c!=' ') {
						str=new String(str+c);
					}
					
					//表达式输入完成，进行计算
					if (state==4) {
						ExpressionOperation myExpress=new ExpressionOperation();
						//除去表达式两端<%和%>，进行表达式计算
						str=new String(str.substring(str.indexOf('%')+1,str.lastIndexOf('%')));
						System.out.println(str);
						myExpress.enterExpr(str);

						str=String.valueOf(myExpress.exprOperation());
						//输出计算结果
						DatOutS.writeBytes(str);
						//初始化状态标量和表达式字符串
						str="";
						state=0;
					}
				}
			} catch(EOFException e) {
				//关闭输入输出
				DatOutS.close(); DatInS.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
};


	
	