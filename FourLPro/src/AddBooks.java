import java.io.IOException;
import java.util.Scanner;

import useBean.entity.UsedBook;


public class AddBooks {
   public static void main(String[] args) throws IOException{
	   UsedBook book =new UsedBook();
	   Scanner input =new Scanner(System.in);
	   while(true){
		   book.setRandId();
		   System.out.println("输入书名");
		   book.setName(input.nextLine());
		   System.out.println("输入价格");
		   book.setPrice(input.nextInt());
		   System.out.println("输入余量");
		   book.setMargin(input.nextInt());
		   input.nextLine();
		   System.out.println("输入类型");
		   book.setStyle(input.nextLine());
		   System.out.println("输入网站");
		   book.setWebPath(input.nextLine());
		   book.add();
	   }
   }
}
