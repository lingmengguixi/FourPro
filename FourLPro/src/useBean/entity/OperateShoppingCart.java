package useBean.entity;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import useBean.cart.ProductOrder;
import useBean.cart.ProductOrder.OrderStatus;
import useBean.write.Write;


public class OperateShoppingCart {
	private ShoppingCart cart;
	private String filePathRoot;
	private static final String fileHeadMesage="<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n"+
			"<beans xmlns=\"http://www.springframework.org/schema/beans\"\n"+
			"    xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\"\n"+
			"    xsi:schemaLocation=\"http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd\">\n\n\n";
    private static final String fileTailMesage="</beans>";
	private static final String cartName="/cart.xml";
	private static final String cartNameTemp="/cartTemp.xml";
	public OperateShoppingCart(ShoppingCart cart){
	   if(cart==null) throw new NullPointerException();
	   this.cart=cart;
	   filePathRoot="WebContent/user/"+cart.getId();
   }
	/**
	 * 如果不使用本方法，可能出现再次加载时，数据不发生改变，造成错误
	 * 使用完操作类，需要及时关闭，以自动提交数据
	 * @throws IOException
	 */
   public void close() throws IOException{
	   //if(order==null) throw new NullPointerException();
	File userCartFileRoot=new File(filePathRoot);
	File userCartFile=new File(filePathRoot+cartName);
	File userCartFileTemp=new File(filePathRoot+cartNameTemp);
	if(!userCartFileRoot.exists()) userCartFileRoot.mkdirs();
	if(!userCartFileTemp.exists()) userCartFileTemp.createNewFile();
	FileWriter fileout = new FileWriter(filePathRoot+cartNameTemp);
		BufferedWriter out = new BufferedWriter(fileout);
		out.write(fileHeadMesage);
		out.write(cart.toString());
		out.write(fileTailMesage);
		out.close();
	if(!userCartFile.exists()){
		userCartFileTemp.renameTo(userCartFile);
	}else{
		if(userCartFile.delete()){
			userCartFileTemp.renameTo(userCartFile);
		}
	}
   }	
   /**
    *    订单的商品数量至少为1，否则无法把订单加入到购物车
    *    返回值为true表示成功加入，还需要close以确保数据库保存
    *    同时该方法也为订单给予一个以时间相关的id,你不需要定义订单的id，
    *    如果想要改变，请在使用该方法后再使用，应确保id唯一
    *    订单的id可以通过Order的getId查看
    * @param order
    */
   public boolean addOrder(Order order){
	   if(order.getCount()<1) return false;
	   Date date=new Date();
	   Calendar calendar=Calendar.getInstance();
	   calendar.setTime(date);
	   String id="$"+calendar.get(GregorianCalendar.YEAR);
	   if((calendar.get(GregorianCalendar.MONTH)+1)<10) id+="0";
	   id+=(calendar.get(GregorianCalendar.MONTH)+1);
	   if(calendar.get(GregorianCalendar.DAY_OF_MONTH)<10) id+="0";
	   id+=calendar.get(GregorianCalendar.DAY_OF_MONTH);
	   if(calendar.get(GregorianCalendar.HOUR)<10) id+="0";
	   id+=calendar.get(GregorianCalendar.HOUR);
	   if(calendar.get(GregorianCalendar.MINUTE)<10) id+="0";
	   id+=calendar.get(GregorianCalendar.MINUTE);
	   if(calendar.get(GregorianCalendar.SECOND)<10) id+="0";
	   id+=calendar.get(GregorianCalendar.SECOND);
	   if(cart.getOrderCount()==null) cart.setOrderCount((List<Order>)new ArrayList<Order>());
	   order.setId(id+(cart.getOrderCount().size()+10001));
     	cart.getOrderCount().add(order);
		return true;
	}
   public void removeOrder(Order order){
	    cart.getOrderCount().remove(order);
   }
   public Order getOrder(String id){
	   for(Order order:cart.getOrderCount()){
		   if(order.getId().equals(id)) return order;
	   }
	   return null;
   }
   /**
    * 将购物车的订单进行结算,该订单必须属于购物车里面的订单
    * 
    * <p>否则结算不成功，没有任何影响，返回值为是否结算成功，成功为true，不成功为false</p>
    * 商品得要存在，而且余量足够时，才可以结算
    * 本方法在结算时，不考虑用户余额是否足够，如需考虑用户余额时，本方法不可用
 * @throws IOException 
    */
   public boolean turnToShopping(Order order) throws IOException{
	    if(!cart.getOrderCount().contains(order)) return false;
	    File bookFile=new File("WebContent/data/usedbook/book.xml");
	    if(!bookFile.exists()) return false;
	    
	    cart.getOrderCount().remove(order);
	    ProductOrder productOrder=new ProductOrder();
	    ApplicationContext ctx=new FileSystemXmlApplicationContext("WebContent/data/usedbook/book.xml"); 
	    UsedBook book=ctx.getBean(order.getBookId(),UsedBook.class);
	    if(book==null||book.getMargin()<order.getCount()){
	    	productOrder=null;
	        return false;
	    }else {
            productOrder.setName(book.getName());
            productOrder.setOrderStatus(OrderStatus.start);
            productOrder.setUserId(cart.getId());
	    }
	    
	    productOrder.setStart(productOrder.getData());
	    productOrder.setBookId(order.getBookId());
	    productOrder.setCount(order.getCount());
	    productOrder.setId(Write.getRandId("WebContent/data/order", "/productOrder.xml"));
	    book.setMargin(book.getMargin()-order.getCount());
	    Write.toSaveInAll("WebContent/data/usedbook","/book.xml",book);
	    Write.toSaveInAll("WebContent/data/order", "/productOrder.xml", productOrder);
	     Write.toSaveInAll(filePathRoot,"/productOrder.xml",productOrder);
	     return true;
   }
}
