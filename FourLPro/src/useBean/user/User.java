package useBean.user;

import java.io.IOException;

import useBean.write.UseBean;
import useBean.write.Write;

public class User implements UseBean{
    private String name="流量";
    private String password;
    private String id;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	} 
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
    public String toString(){
    	return 	
   "    <bean id=\""+getId()+"\" class=\""+User.class.getName()+"\">\n"+
   "        <property name=\"name\" value=\""+getName()+"\"></property>\n"+
   "        <property name=\"password\" value=\""+getPassword()+"\"></property>\n"+
   "        <property name=\"id\" value=\""+getId()+"\"></property>\n"+
   "    </bean>\n";
    }
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	/**
	 * 不允许使用
	 */
	@Override
	@Deprecated
	public void remove() throws IOException {
		// TODO Auto-generated method stub

	}
	/**
	 * 该方法过时，请使用用户操作类实现加入
	 */
	@Override
	@Deprecated
	public void add() throws IOException {
		// TODO Auto-generated method stub
		
	}
}
