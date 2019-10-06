package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;

import cn.pojo.MagCount;
import cn.service.impl.ValueStrengthServiceImpl;
import service.ValueStrengthService;


/**
 * Servlet implementation class ValueStrengthServlet
 */
@WebServlet("/ValueStrengthServlet")
public class ValueStrengthServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ValueStrengthService service =new ValueStrengthServiceImpl();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String la= request.getParameter("lati");
		String lo= request.getParameter("longi");
		double lati=Double.parseDouble(la);
		double longi=Double.parseDouble(lo);
		
		MagCount dc=null;
		try {
			dc = service.getMagnitude(lati, longi);
		} catch (Exception e) {
			// TODO Auto-generated catch block
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
