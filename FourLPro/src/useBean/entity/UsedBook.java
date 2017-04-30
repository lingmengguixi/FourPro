package useBean.entity;

import java.io.File;
import java.io.IOException;

import useBean.write.UseBean;
import useBean.write.Write;

public class UsedBook implements UseBean{
    private String webPath;
    private String id;//商品代号
    private String style;
    private double price;
    private String name; 
    private int margin;
    private static final String bookFilePathRoot="WebContent/data/usedbook";
    private static final String bookFileName="/book.xml";
    public UsedBook(){
    }
	public String getWebPath() {
		return webPath;
	}
	public void setRandId(){
		id=Write.getRandId(bookFilePathRoot, bookFileName);
	}
	public void setWebPath(String webPath) {
		this.webPath = webPath;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getStyle() {
		return style;
	}
	public void setStyle(String style) {
		this.style = style;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String toString(){
	   	return 	
	   		   "    <bean id=\""+getId()+"\" class=\""+UsedBook.class.getName()+"\">\n"+
	   		
	   		   "        <property name=\"webPath\" value=\""+getWebPath()+"\"></property>\n"+
	   		   "        <property name=\"id\" value=\""+getId()+"\"></property>\n"+
	   		   "        <property name=\"style\" value=\""+getStyle()+"\"></property>\n"+
	   		   "        <property name=\"price\" value=\""+getPrice()+"\"></property>\n"+
	   		   "        <property name=\"name\" value=\""+getName()+"\"></property>\n"+
	   		   "        <property name=\"margin\" value=\""+getMargin()+"\"></property>\n"+
	   		   "    </bean>\n";
	}
	public void add() throws IOException{
        Write.toSaveInAll(bookFilePathRoot, bookFileName, this);
	}
	public void remove() throws IOException{
		Write.remove(bookFilePathRoot, bookFileName, this);
	}
	public int getMargin() {
		return margin;
	}
	public void setMargin(int margin) {
		this.margin = margin;
	}
}
