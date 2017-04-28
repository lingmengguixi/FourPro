package useBean.write;

import java.io.IOException;

public interface UseBean extends java.io.Serializable{
   public String getId();
   public String getName();
   public void remove() throws IOException;
   public void add() throws IOException;
   
}
