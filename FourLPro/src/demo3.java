import java.io.IOException;
import java.util.Scanner;

import useBean.entity.UsedBook;


public class demo3 {
   public static void main(String[] args) throws IOException{
	   Scanner input =new Scanner(System.in);
	   
	   while(true){
		   System.out.println("1.add 2.remove");
		   int a=input.nextInt();
		   input.nextLine();
		   if(a==1){
			   UsedBook b=new UsedBook();
			   System.out.println("输入书名");
			   b.setName(input.nextLine());
			   System.out.println("输入价格");
			   b.setPrice(input.nextDouble());
			   input.nextLine();
			   System.out.println("输入类型");
			   b.setStyle(input.nextLine());
			   System.out.println("输入网站");
			   b.setWebPath(input.nextLine());
			   b.setRandId();
			   b.add();
		   }else if(a==2){
			   System.out.println("输入id");
			   UsedBook b=new UsedBook();
			   b.setId(input.nextLine());
			   b.remove();
		   }
	   }
	  // System.out.println("end");
   }
}
