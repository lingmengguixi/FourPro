package search;

import java.io.File;
import java.util.ArrayList;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import useBean.entity.UsedBook;
import useBean.write.UseBean;

public class Search {
	SetLimit setLimit;
	 public class SetLimit{
	 public boolean name=true;
	 public boolean style=true;
	 public boolean price=false;
	 public boolean margin=true;
	 public boolean hasMargin=true;
	 public double startPrice=0;
	 public double endPrice=1e20;
	}
	 public Search(){
		 setLimit = this.new SetLimit();
	 }
     public  String[] searchId(String dir,String fileName,String subString){
     	File file=new File(dir+fileName);
     	if(!file.exists()) return new String[0];
     	ArrayList<String> idS=new ArrayList<String>();
    	String[] sub=subString.split("(,|\\s)+");
    	int space=0;
        for(int i=0;i<sub.length;i++){
        	if(sub[i].length()==0) {
        		space++;
        		continue;
        	}
        	sub[i-space]=sub[i].toLowerCase();
        	//System.out.println(sub[i-space]);
        }
    	ApplicationContext ctx=new FileSystemXmlApplicationContext(dir+fileName);
		String[] id=ctx.getBeanDefinitionNames();
		if(sub.length==space) return id;
		boolean find=false;
		for(int i=0;i<id.length;i++){
			find=false;
			if(!find&setLimit.name){
			  find=true;
			  String p=ctx.getBean(id[i],UseBean.class).getName().toLowerCase();
		      int j=0;
			  for(j=0;j<sub.length-space;j++){
		    	if(p.contains(sub[j])) {
		    		break;
		    	}
		      }
			  if(j>=sub.length-space) find=false;
			}
			if(!find&setLimit.style){
				find=true;
				  String p=ctx.getBean(id[i],UsedBook.class).getStyle().toLowerCase();
			      int j=0;
				  for(j=0;j<sub.length-space;j++){
			    	if(p.contains(sub[j])) {
			    		break;
			    	}
			      }
				  if(j>=sub.length-space) find=false;
			}
           if(find&setLimit.price){
        	   double price1=ctx.getBean(id[i],UsedBook.class).getPrice();
        	   if(price1>=setLimit.startPrice&&price1<=setLimit.endPrice){
        		   
        	   }else find=false;
           }
           if(find&setLimit.margin){
        	   int margin=ctx.getBean(id[i],UsedBook.class).getMargin();
        	   if(margin>0&&setLimit.hasMargin||margin<=0&&!setLimit.hasMargin){
        		   
        	   }else find=false;
           }
           if(find){
        	   idS.add(id[i]);
           }
		}
	   id=new String[idS.size()];
		for(int i=0;i<idS.size();i++){
			id[i]=idS.get(i);
		}
        return id;
     }
     public SetLimit getSetLimit(){
    	 return this.setLimit;
     }
}