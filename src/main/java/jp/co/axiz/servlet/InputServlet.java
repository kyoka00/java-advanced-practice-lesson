package jp.co.axiz.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jp.co.axiz.entity.Car;
import jp.co.axiz.util.Utility;
/**
 * Servlet implementation class StartAppServlet
 */
@WebServlet("/inputServlet")
public class InputServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public InputServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // TODO Auto-generated method stub
        response.getWriter().append("Served at: ").append(request.getContextPath());
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	HttpSession session = request.getSession();
    	request.setCharacterEncoding("UTF-8");
    	String carName = request.getParameter("carName");
    	String bodyColor = request.getParameter("bodyColor");
    	String maxSpeedS = request.getParameter("maxSpeed");
    	String url;
    	
    	if(Utility.isNullOrEmpty(carName) || Utility.isNullOrEmpty(bodyColor) || Utility.isNullOrEmpty(maxSpeedS)) {
    		String result =("未入力項目があります");
    		request.setAttribute("result", result);
    		url ="input.jsp";
    	}else {
    		int maxSpeed = Utility.checkAndParseInt(maxSpeedS);
    		Car myCar = new Car(carName,bodyColor, maxSpeed);
    		session.setAttribute("latestCar", myCar);
    		url = "update.jsp";
    	}
    	
        request.getRequestDispatcher(url).forward(request, response);
    }
}
