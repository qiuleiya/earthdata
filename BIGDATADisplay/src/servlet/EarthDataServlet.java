package servlet;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;

import pojo.EarthData;
import service.EarthDataService;
import service.impl.EarthDataServiceImpl;

/**
 * Servlet implementation class EarthDataServlet
 */
@WebServlet("/EarthDataServlet")
public class EarthDataServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
  private EarthDataService service=new EarthDataServiceImpl();
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		
		String sdate= request.getParameter("startDate");
		String edate= request.getParameter("endDate");
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd"); 
		
		java.util.Date d1 = null;
		java.util.Date d2 =null;
		try { 
			  d1 = format.parse(sdate); 
			  d2 = format.parse(edate);
			 } catch (Exception e) { 
			  e.printStackTrace(); 
			 } 
		java.sql.Date startDate = new java.sql.Date(d1.getTime()); 
		java.sql.Date endDate=new java.sql.Date(d2.getTime());
		//System.out.println(endDate);
		List<EarthData> list=null;
		try {
			list = service.getEarthDate(startDate, endDate);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(list.toString());
		//将list对象转化为JSON
				String jsonStr=JSON.toJSONString(list);
				//System.out.println(list.size());
				//将站点信息返回前台
				response.getWriter().write(jsonStr);
	}
	

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
