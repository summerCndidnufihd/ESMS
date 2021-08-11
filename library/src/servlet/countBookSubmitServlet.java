package servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.Book;
import service.Service;

/**
 * Servlet implementation class countBookSubmitServlet
 */
@WebServlet("/countBookSubmitServlet")
public class countBookSubmitServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public countBookSubmitServlet() {
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
		request.setCharacterEncoding("utf-8");
		List<Map<String, Object>> list=new ArrayList<Map<String, Object>>();
		String count_item=request.getParameter("count_item");
		Service s=new Service();
		list=s.countBook(count_item);
		System.out.print(list);
		if(list == null) {
			System.out.print("list¿Õ");
			request.getRequestDispatcher("countBook.jsp").forward(request, response);
			return;
		}else {
			request.setAttribute("num", list);
			System.out.print("servlet½áÊø");
			System.out.print(list);
			request.getRequestDispatcher("countDetail.jsp").forward(request, response);
		}
	}

}
