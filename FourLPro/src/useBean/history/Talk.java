package useBean.history;

import java.io.IOException;


public class Talk {
    private long date;
    private String content;
    private String id;
	public long getDate() {
		return date;
	}
	public void setDate(long date) {
		this.date = date;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content="";
		for(int i=0;i<content.length();i++){
			if(content.charAt(i)=='\"'||content.charAt(i)=='\\'){
				this.content+="\\";
			}
			this.content+=content.charAt(i);
		}
		this.content = content;
	}
	public String getId() {
		// TODO Auto-generated method stub
		return this.id;
	}


	public void setId(String id){
		this.id=id;
	}
	public String toString(){
		String content1="\"";
		content1+=this.id+"\"\n\"";
		content1+=this.getDate()+"\"\n\"";
		content1+=this.getContent()+"\"\n";
		return content1;
		
	}
}
