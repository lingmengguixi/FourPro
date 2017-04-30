package useBean.cart;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import useBean.entity.Order;
import useBean.write.UseBean;
import useBean.write.Write;

public class ProductOrder extends Order implements UseBean{

	private String orderStatus;
    private String userId;
    private String name;
    private String start;
    private String end;
    private static String dir="WebContent/data",fileName="/productOrder.xml"; 
    /**
     * 订单状态
     * @author lenovo
     *
     */
    public class OrderStatus{
    	public final static String start="start";//下单
    	public final static String getProduct="getProduct";//收货
    	public final static String backProduct="backProduct";//退货
    	public final static String end_yes="end_yes";//成功结束
    	public final static String end_no="end_no";//失败结束
    }
    /**
     * 返回当前订单的状态
     * @return
     */
	public String getOrderStatus() {
		return orderStatus;
	}
	/**
	 * 设置订单的状态
	 * @param orderStatus
	 */
	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}
	/**
	 * 返回开始时间
	 * @return
	 */
	public String getStart() {
		return start;
	}
	/**
	 * set开始时间
	 * @param start
	 */
	public void setStart(String start) {
		this.start = start;
	}
	/**
	 * 获得结束时间
	 * @return
	 */
	public String getEnd() {
		return end;
	}
	/**
	 * set 订单状态为结束时的时间
	 * @param end
	 */
	public void setEnd(String end) {
		this.end = end;
	}
	/**
	 * 获得当前的时间
	 * @return
	 */
	public String getData(){
		   Date date=new Date();
		   Calendar calendar=Calendar.getInstance();
		   calendar.setTime(date);
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.CHINA);
         return format.format(calendar.getTime());
		    
	}
	/**
	 * 得到订单名字，一般为书名
	 */ 
	@Override
	public String getName() {
		// TODO Auto-generated method stu
		return this.name;
	}
	/**
	 * 移除该订单从数据库，永久删除
	 */
	@Override
	public void remove() throws IOException {
		// TODO Auto-generated method stub
		Write.remove(dir, fileName, this);
	}
	/**
	 * 添加订单到数据库
	 */
	@Override
	public void add() throws IOException {
		// TODO Auto-generated method stub
		Write.toSaveInAll(dir, fileName, this);
	}
	@Override
	/**
	 * 产品订单的状态，以xml形式描述
	 */
	public String toString(){
		return
		 "    <bean id=\""+getId()+"\" class=\""+ProductOrder.class.getName()+"\">\n"+
				 "        <property name=\"id\" value=\""+getId()+"\"></property>\n"+
				 "        <property name=\"count\" value=\""+getCount()+"\"></property>\n"+
				 "        <property name=\"bookId\" value=\""+getBookId()+"\"></property>\n"+
				 "        <property name=\"name\" value=\""+getName()+"\"></property>\n"+
				 "        <property name=\"userId\" value=\""+getUserId()+"\"></property>\n"+
				 "        <property name=\"start\" value=\""+getStart()+"\"></property>\n"+
				 "        <property name=\"end\" value=\""+getEnd()+"\"></property>\n"+
				 "        <property name=\"orderStatus\" value=\""+getOrderStatus()+"\"></property>\n"+
				 "    </bean>\n";
	}
	/**
	 * 为该订单设置名字
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * 用户建立该订单时，会保存该用户id，通过该方法可以得到这个用户的id
	 * @return
	 */
	public String getUserId() {
		return userId;
	}
	/**
	 * 建立订单时，会保存用户的id
	 * @param userId
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}
}
