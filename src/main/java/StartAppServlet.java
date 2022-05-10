

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import app.CardGameApp;

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
	    if (name != null && !name.isEmpty()) {
	    	switch (app) {
	    	case "card":
	    		app.GameApp card = new CardGameApp("トランプ");
	    		result = card.start(name);
	    		request.setAttribute("result",result);
	    		break;
	    		
	    	case "game":
	    		app.GameApp game= new app.GameApp ("ゲーム");
		    	result = game.start(name);
		    	request.setAttribute("result",result);
		    	break;
	    	}
	    
	    }
	    request.getRequestDispatcher("/appStart.jsp").forward(request, response);

	}

}
