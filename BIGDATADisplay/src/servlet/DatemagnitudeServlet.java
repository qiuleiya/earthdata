package servlet;

import java.io.IOException;
import java.text.SimpleDateFormat;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;

import pojo.DateMagCount;
import service.DateMagnitudeService;
import service.impl.DateMagnitudeServiceImpl;

/**
 * Servlet implementation class DatemagnitudeServlet
 */
@WebServlet("/DatemagnitudeServlet")
public class DatemagnitudeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private DateMagnitudeService service=new DateMagnitudeServiceImpl();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String sdate= request.getParameter("startDate");
		String edate= request.getParameter("endDate");
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd"); 
		System.out.println(edate);
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
		System.out.println(endDate);
		DateMagCount dc=null;
		//Map<String, String> map=null;
		try {
			dc = service.getDateMagnitude(startDate, endDate);
			//map = service.getMagnitudeData(startDate,endDate);
		} catch (Exception e) {

			e.printStackTrace();
		}
		System.out.println(dc.toString());
		String jst = JSON.toJSONString(dc);
		response.getWriter().write(jst);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
