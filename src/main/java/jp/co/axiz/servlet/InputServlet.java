package jp.co.axiz.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jp.co.axiz.entity.Product;
import jp.co.axiz.util.Utility;

/**
 * Servlet implementation class StartAppServlet
 */
@WebServlet("/InputServlet")
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

        // 「input.jsp」からの入力値取得
        request.setCharacterEncoding("UTF-8");
        String productName = request.getParameter("productName");
        //修正　総合テストNo.1による修正------------------------
        //担当：前野 2020.05.21
        //String priceStr = request.getParameter("prise");
        String priceStr = request.getParameter("price");
        //修正終わり--------------------------------------------
        
        
        //修正　総合テストNo.3による修正------------------------
        //担当：前野 2020.05.21
        //Integer price = Integer.parseInt(priceStr);
        Integer price;
        if (Utility.isNullOrEmpty(priceStr)) {
        	price = null;
        }else {
        	price = Utility.checkAndParseInt(priceStr);
        }
        //修正終わり----------------------------------------------
        
        
        
        // 入力値が未入力かどうかの判定を行う
        // (商品名はUtilityクラスのisNullOrEmptyメソッドを使い、
        // 金額は上記で変換した値がnullかどうかで判定)
        // 未入力の場合は、リクエストにメッセージをセットし、
        // 登録画面へ遷移する
        if (Utility.isNullOrEmpty(productName) || price == null) {
            request.setAttribute("result", "登録できません。入力内容を見直してください。");

            request.getRequestDispatcher("input.jsp").forward(request, response);
            return;
        }

        // セッションを取得
        HttpSession session = request.getSession();

        // セッションより商品リストを取得
        // (警告が出るが、無視して良い)
        ArrayList<Product> productList = (ArrayList<Product>) session.getAttribute("productList");

        // 取得した商品リストが無い場合、ArrayListオブジェクトを新規作成
        if (productList == null) {
            productList = new ArrayList<>();
        }

        // productオブジェクトを作成し、入力値をセット
        Product product = new Product(null, productName, price);

        // productListに上記で作成したオブジェクトを追加
        productList.add(product);

        // セッションに商品リスト(productList)を登録
        session.setAttribute("productList", productList);

        // 結果画面へ遷移
        request.getRequestDispatcher("result.jsp").forward(request, response);

    }
}
