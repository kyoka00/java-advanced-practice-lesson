

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import app.CardGameApp;
import app.ClockApp;
import app.DartsGameApp;


/**
 * Servlet implementation class StartAppServlet
 */
@WebServlet("/StartAppServlet")
public class StartAppServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public StartAppServlet() {
        // TODO Auto-generated constructor stub
    	
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
	    String name = request.getParameter("name");
	    String app = request.getParameter("app");
	    String result;
	    int playTime;
	    
	    if (name != null && !name.isEmpty()) {
	    	
	    	switch(app) {
	 	    case "card":
	 	    	CardGameApp card = new CardGameApp("トランプ");
	 	    	result = card.start(name);
	 	    	request.setAttribute("result",result);
	 	    	playTime = card.getPlayTime();
	 	    	request.setAttribute("playTime",playTime);
	 	    	break;
	 	    	
	 	    case "darts":
	 	    	DartsGameApp darts = new DartsGameApp("ダーツ");
	 	    	result = darts.start(name);
	 	    	request.setAttribute("result",result);
	 	    	playTime = darts.getPlayTime();
	 	    	request.setAttribute("playTime",playTime);
	 	    	break;
	 	    	
	 	    case "clock":
	 	    	ClockApp clock = new ClockApp();
	 	    	result = clock.start(name);
	 	    	request.setAttribute("result",result);
	 	    	break;
	 	    	
	 	    case "others":
	 	    	result = "アプリの実行に失敗しました。";
	 	    	request.setAttribute("result",result);
	 	    	break;
	 	    	
	 	    	}
	    	}
	   
	    
	    request.getRequestDispatcher("/appStart.jsp").forward(request, response);

	}

}
