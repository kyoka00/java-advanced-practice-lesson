
import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Animal.Animal;
import Animal.Cat;
import Animal.Rabbit;

/**
 * Servlet implementation class StartAppServlet
 */
@WebServlet("/importServlet")
public class ImportServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ImportServlet() {
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
        /*
         * 下記のコメントを参考に、必要な処理を実装してください
         */

        // todo:入力値取得
    	String data = request.getParameter("data");

        // 取り込んだ内容を保持するための変数(オブジェクト)
    	Animal animal = null;
        String result = "";
        // todo:
        // オブジェクトを作成し、上記の変数にセット
        if (data.equals("cat")) { 
        		animal = new Cat();
        		
        }else if(data.equals("rabbit")) {
        		 animal = new Rabbit();
        }
        // 取り込むファイル先用の変数
        Path file = Paths.get(animal.getFilePath());

        // 読み込んだファイル用の変数
        BufferedReader br = null;

        try {
            // ファイルを開く
            br = Files.newBufferedReader(file);

            // ファイル内の最初の1行を読み込み
            String text = br.readLine();

            int count = 0;

            while (text != null) {
                count ++;
            	if (count == 1) {
            		animal.name= text;
            		
            	}else if(count == 2){
            		
            		int age = Integer.parseInt(text);
            		animal.age = age;
            	}
                // ファイル内の次の1行を読み込み
                text = br.readLine();
            }

           
            	result = animal.introduce();

        } catch (IOException e) {
            
        	result = "ファイルの読み込みに失敗しました";

        } finally {
            
            if (br != null) {
                br.close();
            }
        }

        // todo:結果画面に表示するメッセージをセット
        request.setAttribute("result", result);
        // 結果画面へ遷移
        request.getRequestDispatcher("result.jsp").forward(request, response);
    }
}

