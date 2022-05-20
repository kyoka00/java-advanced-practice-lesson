package jp.co.axiz.servlet;

import java.io.IOException;
import java.util.ArrayList;

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
@WebServlet("/updateServlet")
public class UpdateServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateServlet() {
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
    	request.setCharacterEncoding("UTF-8");
    	HttpSession session = request.getSession();
    	
    	Car myCar = (Car)session.getAttribute("latestCar");
    	String url ="";
    	String btn = request.getParameter("btn");
    	ArrayList<Car> history = new ArrayList<Car>();
    	String result ="";
    	
    	if(btn!= null && btn.equals("back")) {
    		session.invalidate();
    		url="input.jsp";
    		
    	}else {
    		String bodyColor = request.getParameter("bodyColor");
			String speedS = request.getParameter("speed");
			
			if (session.getAttribute("history") != null) {
				history = (ArrayList<Car>) session.getAttribute("history");
			}

				if (Utility.isNullOrEmpty(bodyColor) && Utility.isNullOrEmpty(speedS)) {
					result = "未入力項目があります";
					request.setAttribute("result", result);

				} else {
					Car newCar = new Car(myCar.getCarName(),myCar.getBodyColor(),myCar.getMaxSpeed(),myCar.getSpeed());
					if(!Utility.isNullOrEmpty(speedS)) {
					int speed = Utility.checkAndParseInt(speedS);
					
					newCar.setSpeed(speed);
					}
					
					newCar.setBodyColor(bodyColor);
					history.add(newCar);
					session.setAttribute("history", history);
					session.setAttribute("latestCar", newCar);
					result = "車の色と現在速度を変更しました";
				}
				url = "update.jsp";
			}
			request.getRequestDispatcher(url).forward(request, response);
		}

    }
