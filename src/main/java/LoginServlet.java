

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Util.Utility;
/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
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
		String id = request.getParameter("id");
		String pass = request.getParameter("pass");
		String correctId= "axiz";
		String correctPass="axizuser";
		String idNull ="IDは必須です";
		String passNull = "PASSは必須です";
		request.setAttribute("idNull","");
		request.setAttribute("passNull","");
		request.setAttribute("unmatch","");
		
		if (Utility.isNullOrEmpty(id) && Utility.isNullOrEmpty(pass)) {
			
			request.setAttribute("idNull",idNull);
			request.setAttribute("passNull",passNull);
			
		}else if (Utility.isNullOrEmpty(id)) {
			
			request.setAttribute("idNull",idNull);

		}else if (Utility.isNullOrEmpty(pass)) {
			
			request.setAttribute("passNull",passNull);
			
		}else {
			if (!id.equals(correctId) && !pass.equals(correctPass)) {
				request.setAttribute("unmatch","IDまたはPASSが間違っています");
				
			}else {
				request.getRequestDispatcher("/result.jsp").forward(request, response);
			}
		}
		request.getRequestDispatcher("/input.jsp").forward(request, response);
	}

}
