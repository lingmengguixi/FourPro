package useBean.user;

public class User implements java.io.Serializable{
    private String name;
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
}
