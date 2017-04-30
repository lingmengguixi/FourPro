package servlet.administrator;

import java.io.File;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import search.Result;
import search.Search;
import sunYang.Mesage;
import sunYang.User;

/**
 * Servlet implementation class SearchServlet
 */
@WebServlet("/SearchServlet")
public class SearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		Search search = new Search();
		search.getSetLimit().price=false;
		search.getSetLimit().margin=false;
		search.getSetLimit().style=false;
		search.getSetLimit().name=true;
		Result s=new Result();
		String type=request.getParameter("type");
		String subString=request.getParameter("input1");
		String[] id=null;
		Mesage m1=new Mesage();
		if(type.equals("user")){
			if(new File("WebContent/user/user.xml").exists()) {
			  id=search.searchId("WebContent/user", "/user.xml", subString);
			}else{
				//new File("e:/FourLPro/WebContent/user/user1111111111111.xml").createNewFile();
				//m1.setMesage("4"+new File("WebContent/user/user.xml").getAbsolutePath());
			}
		 }else if(type.equals("order")){
			// m1.setMesage("findOrder"+subString);
			 search.getSetLimit().id=true;
			 search.getSetLimit().name=false;
			 if(new File("WebContent/data/order/productOrder.xml").exists()){
            id=search.searchId("WebContent/data/order", "/productOrder.xml", subString);
		     }
	     }
		if(id!=null)
		  for(int i=0;i<id.length;i++){
		      	s.getElement().add(id[i]);
		  }
		m1.setMesage(type);
		request.setAttribute("demo", m1);
		request.setAttribute("result", s);
		RequestDispatcher html=request.getRequestDispatcher("/adminSearch.jsp");
		html.forward(request, response);
	 }

}
