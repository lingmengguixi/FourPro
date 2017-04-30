package useBean.entity;

public class Order {
	private String id;
	private String bookId;
    private int count=1;
	public String getId() {
		return id;
	} 
    /**
     * 不建议使用,直接用购物车操作类的add，它会直接为订单分配id;
     * @param id
     */
	public void setId(String id) {
		this.id = id;
	}

	public int getCount() {
		return count;
	}
    /**
     * 设置购物车订单放入到购物车的数量
     * 数量为0时无法加入到购物车
     * @param count
     */
	public void setCount(int count) {
		this.count = count;
	}
	public String toString(){
		return 
	 "    <bean id=\""+getId()+"\" class=\""+Order.class.getName()+"\">\n"+
	 "        <property name=\"id\" value=\""+getId()+"\"></property>\n"+
	 "        <property name=\"count\" value=\""+getCount()+"\"></property>\n"+
	 "        <property name=\"bookId\" value=\""+getBookId()+"\"></property>\n"+
	 "    </bean>\n";
	}

	public String getBookId() {
		return bookId;
	}
  /**
   * 设置订单所涉及到的书名
   * @param bookId
   */
	public void setBookId(String bookId) {
		this.bookId = bookId;
	}
}
