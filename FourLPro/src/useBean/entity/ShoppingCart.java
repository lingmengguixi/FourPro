package useBean.entity;

import java.util.List;

public class ShoppingCart {
	private String id;
    private List<Order> orderCount;
	public List<Order> getOrderCount() {
		return orderCount;
	}
	/**
	 * 不建议使用该方法新建购物车类，应使用用户操作类，新建时会自动绑定构建该对象
	 * 通过用户操作类的getUserShoppingCart()可以获得用户的购物车对象
	 * 如果第一次获得的，则对象id默认与用户一致，订单清单列表为0
	 */
    public ShoppingCart(){
    }
	public void setOrderCount(List<Order> orderCount) {
		this.orderCount = orderCount;
	}
   /**
    * 购物车的id为用户的id，将id与用户id进行绑定，该方法即使返回用户且是购物车的id
    * @return
    */
	public String getId() {
		return id;
	}
    /**
     * 构建购物车时，必须将id设置为用户id，进行绑定
     * @param id
     */
	public void setId(String id) {
		this.id = id;
	}
	/**
	 * 返回购物车的的内容，以xml格式返回，因此可以直接写入xml里面
	 * 
	 */
	public String toString(){
		String subOrder="",subOrder1="";
		if(orderCount!=null&&orderCount.size()>0)
		for(Order order:orderCount){
			subOrder=subOrder+"<ref bean=\""+order.getId()+"\" />\n";
			subOrder1+=order;
		}
		
		return 	
    "    <bean id=\""+getId()+"\" class=\""+ShoppingCart.class.getName()+"\">\n"+
	"        <property name=\"orderCount\">\n"+
	"        <list>\n"+
             subOrder+
	"        </list>\n"+
	"        </property>\n"+
	"        <property name=\"id\" value=\""+getId()+"\"></property>\n"+
    "    </bean>\n"+
	subOrder1;
	}
}
