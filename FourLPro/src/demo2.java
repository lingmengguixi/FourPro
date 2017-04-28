import java.io.File;
import java.io.IOException;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import useBean.entity.OperateShoppingCart;
import useBean.entity.Order;
import useBean.entity.ShoppingCart;
import useBean.entity.UsedBook;
import useBean.user.OperateUser;
import useBean.user.User;


public class demo2 {
	   public static void main(String[] args) throws IOException{
		      ApplicationContext ctx;
			   ctx= new FileSystemXmlApplicationContext("WebContent/data/usedbook/book.xml");
               UsedBook as= (UsedBook) ctx.getBean("@1736119238");
               if(ctx.containsBean("@1736119238"))
                System.out.println(as);
			  System.out.println("end");
   }
}
