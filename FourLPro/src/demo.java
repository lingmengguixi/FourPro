import java.io.IOException;
import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import search.Search;
import search.SetLimit;
import useBean.user.OperateUser;
import useBean.user.User;


public class demo {
   public static void main(String[] args) throws IOException{
      String subString;
       Scanner input = new Scanner(System.in);
       while(true){
    	   System.out.println("输入搜索字符");
    	   subString=input.nextLine();
    	   Search a=new Search();
           SetLimit lim=a.getSetLimit();
           lim.price=true;

    	   String[] answer=a.searchId("WebContent/data/usedbook", "/book.xml",subString);
           for(int i=0;i<answer.length;i++){
        	   System.out.println(answer[i]);
           }
       }
     }
}
