package useBean.write;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import useBean.user.User;

public  class Write {
    private static String fileHeadMesage="<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n"+
			"<beans xmlns=\"http://www.springframework.org/schema/beans\"\n"+
			"    xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\"\n"+
			"    xsi:schemaLocation=\"http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd\">\n\n\n";
    private static String fileTailMesage="</beans>";
    public static void toSaveInOnly(String dir,String fileName,UseBean bean) throws IOException{
    	File fileRoot=new File(dir);
    	File file=new File(dir+fileName);
    	File fileTemp=new File(dir+fileName+"temp");
    	if(!fileRoot.exists()) fileRoot.mkdirs();
    	if(!fileTemp.exists()) fileTemp.createNewFile();
    	String context=bean.toString();
    	FileWriter fileout = new FileWriter(dir+fileName+"temp");
		BufferedWriter out = new BufferedWriter(fileout);
		out.write(fileHeadMesage);
		out.write(context);
		out.write(fileTailMesage);
		out.close();
		if(!file.exists()){
			fileTemp.renameTo(file);
		}else{
			if(file.delete()){
				fileTemp.renameTo(file);
			}
		}
    }
    public static void toSaveInAll(String dir,String fileName,UseBean bean) throws IOException{
    	File fileRoot=new File(dir);
    	File file=new File(dir+fileName);
    	File fileTemp=new File(dir+fileName+"temp");
    	if(!fileRoot.exists()) fileRoot.mkdirs();
    	if(!fileTemp.exists()) fileTemp.createNewFile();
    	String context=bean.toString();
    	if(file.exists()) {
    		ApplicationContext ctx=new FileSystemXmlApplicationContext(dir+fileName);
    	    String[] id=ctx.getBeanDefinitionNames();
    	    for(String id1:id){
        	UseBean w=(UseBean) ctx.getBean(id1);
        	if(id1.equals(bean.getId())){
        		continue;
        	}
        	context+=w;
           }
    	}
    	FileWriter fileout = new FileWriter(dir+fileName+"temp");
		BufferedWriter out = new BufferedWriter(fileout);
		out.write(fileHeadMesage);
		out.write(context);
		out.write(fileTailMesage);
		out.close();
		if(!file.exists()){
			fileTemp.renameTo(file);
		}else{
			if(file.delete()){
				fileTemp.renameTo(file);
			}
		}
    }
    public static void remove(String dir,String fileName,UseBean bean) throws IOException{
    	File fileRoot=new File(dir);
    	File file=new File(dir+fileName);
    	File fileTemp=new File(dir+fileName+"temp");
    	if(!fileRoot.exists()) fileRoot.mkdirs();
    	if(!fileTemp.exists()) fileTemp.createNewFile();
    	String context="";
    	if(file.exists()) {
    		ApplicationContext ctx=new FileSystemXmlApplicationContext(dir+fileName);
    	    String[] id=ctx.getBeanDefinitionNames();
    	    for(String id1:id){
        	UseBean w=(UseBean) ctx.getBean(id1);
        	if(id1.equals(bean.getId())){
        		continue;
        	}
        	context+=w;
           }
    	}
    	FileWriter fileout = new FileWriter(dir+fileName+"temp");
		BufferedWriter out = new BufferedWriter(fileout);
		out.write(fileHeadMesage);
		out.write(context);
		out.write(fileTailMesage);
		out.close();
		if(!file.exists()){
			fileTemp.renameTo(file);
		}else{
			if(file.delete()){
				fileTemp.renameTo(file);
			}
		}
    }
    public static String getRandId(String dir,String fileName){
    	int newId=(int)(Math.random()*2147483647);
    	File file=new File(dir+fileName);
    	ApplicationContext ctx;
    	if(file.exists()) ctx=new FileSystemXmlApplicationContext(dir+fileName);
    	else return "@"+newId;
    	while(true){
    		if(ctx.containsBeanDefinition("@"+newId)){
    			newId=(int)(Math.random()*2147483647);
    		}else return "@"+newId;
        }
    }
  
}
