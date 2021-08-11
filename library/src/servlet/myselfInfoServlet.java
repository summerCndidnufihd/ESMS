package servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import entity.Book;
import entity.Borrow;
import entity.User;
import service.Service;

/**
 * Servlet implementation class myselfInfoServlet
 */
@WebServlet("/myselfInfoServlet")
public class myselfInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public myselfInfoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		HttpSession session = request.getSession();
		User u=(User) session.getAttribute("user");
		System.out.print("������ʾ������Ϣ�ģ�");
		int id=u.getId();
		List<Book> list=new ArrayList<Book>();
		Service s=new Service();
		list=s.myselfInfo(id);
		if(list!=null) {
			System.out.print("�û���Ϣ�б�");
			System.out.print(list);
			request.setAttribute("book", list);
			request.getRequestDispatcher("myInfo.jsp").forward(request, response);
		}else {
			System.out.print("-----�б�");
			request.setAttribute("book", list);
			request.getRequestDispatcher("myInfo.jsp").forward(request, response);
		}
	}
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
           // doGet();
		
	}
}
