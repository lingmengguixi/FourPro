package useBean.user;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.NullPointerException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import useBean.entity.OperateShoppingCart;
import useBean.entity.Order;
import useBean.entity.ShoppingCart;

public class OperateUser {
	private User user;
	private ShoppingCart cart;
	private String userFilePathRoot;
	private static final String cartName="/cart.xml";
	/**
	 * 在新建或初始化用户操作类时，会自动加载用户的购物车对象，如果历史存在
	 * 则加载历史的购物车对象，没有新建一个
	 * @param user
	 * @throws IOException
	 */
	public OperateUser(User user) throws IOException{
		if(user==null) throw new NullPointerException();
		this.user=user;
		userFilePathRoot="WebContent/user/"+user.getId();
		File userFilePathRootDir=new File(userFilePathRoot);
		if(!userFilePathRootDir.exists()) userFilePathRootDir.mkdirs();
		File cartFile=new File(userFilePathRoot+cartName);
		if(!cartFile.exists()){
			cart = new ShoppingCart();
			cart.setId(user.getId());
			cart.setOrderCount(new ArrayList());
			OperateShoppingCart opCart=new OperateShoppingCart(cart);
			opCart.close();
		}else {
			//System.out.println(userFilePathRoot+cartName);
			ApplicationContext userctx=new FileSystemXmlApplicationContext(userFilePathRoot+cartName);
		    cart=userctx.getBean(user.getId(),ShoppingCart.class);
		}
	}
    public void close() throws IOException{//close to save
		File userFilePathRootDir=new File(userFilePathRoot);
		if(!userFilePathRootDir.exists()) userFilePathRootDir.mkdirs();
		File allUserFile=new File("WebContent/user/user.xml");
    	ApplicationContext userctx;
    	String[] id;
    	String context=user.toString();
    	
    	if(allUserFile.exists()) {
    		userctx=new FileSystemXmlApplicationContext("WebContent/user/user.xml");
    	    id=userctx.getBeanDefinitionNames();
    	    for(String id1:id){
        	User user2=userctx.getBean(id1,User.class);
        	if(user.getId().equals(id1)){
        		continue;
        	}
        	context+=user2;
           }
    	}
        FileWriter fileout = new FileWriter("WebContent/user/usertemp.xml"); 
        BufferedWriter out = new BufferedWriter(fileout);
        out.write("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n"+
"<beans xmlns=\"http://www.springframework.org/schema/beans\"\n"+
"    xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\"\n"+
"    xsi:schemaLocation=\"http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd\">\n\n\n");
       

        out.write(context);
        out.write("</beans>");
        out.close();
        File fp =new File("WebContent/user/user.xml");
        File fp1=new File("WebContent/user/usertemp.xml");
        if(fp.exists()) {if(fp.delete()){
        	fp1.renameTo(fp);
           }
        }else {
        	fp1.renameTo(fp);
        }
        user=null;
    }
    public ShoppingCart getUserShoppingCart(){
         return cart;
    }
    public String getUserFilePathRoot(){
    	return userFilePathRoot;
    }
}
