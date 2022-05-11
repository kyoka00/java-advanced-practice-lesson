

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import classes.American;
import classes.Human;
import classes.Japanese;

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
    	request.setCharacterEncoding("UTF-8");
        String name = request.getParameter("name");
        String language = request.getParameter("language");
        String birthPlace = request.getParameter("birthPlace");
        String btn = request.getParameter("btn");
        String info;
        
    	if (btn != null && btn.equals("simple")) {
    		if (birthPlace.equals("japan")) {
    			Human h1 = new Japanese(name, language);
    			info = h1.returnHumanInfo();
    			request.setAttribute("info", info);
    		}else if(birthPlace.equals("america")) {
    			Human h1 = new American(name, language);
    			info = h1.returnHumanInfo();
    			request.setAttribute("info", info);
    		}
    			
    		
    	}else if( btn != null && btn.equals("details")) {
    		switch (birthPlace) {
    		
    		case "japan":
    			Human japanese = new Japanese(name, language);
    			info = japanese.returnHumanInfo() ;
    			request.setAttribute("info",info);
    			break;
    			
    		case "america":
    			Human american = new American(name, language);
    			info = american.returnHumanInfo();
    			request.setAttribute("info", info);
    			break;
    			
    		default:
    			Human h2 = new Human(name, language);
    			info = h2.returnHumanInfo() + h2.returnBirthPlaceInfo();
    			request.setAttribute("info", info);
    			break;
    		}
    		
    		
    	}
        request.getRequestDispatcher("result.jsp").forward(request, response);
    }
}
