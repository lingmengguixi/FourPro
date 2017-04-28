import java.util.Scanner;

import useBean.user.User;


public class demo4 {
	public static void main(String[] args){
	   Scanner input = new Scanner(System.in);
	   User user =new User();
	   while(true){
		   System.out.println("输入名字");
		   user.setName(input.nextLine());
		   user.setId(user.getName());
		   System.out.println("输入密码");
		   user.setPassword(input.nextLine());
	   }
   }
}
