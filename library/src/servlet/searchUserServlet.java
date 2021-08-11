package servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.User;
import service.Service;

/**
 * Servlet implementation class searchUserServlet
 */
@WebServlet("/searchUserServlet")
public class searchUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public searchUserServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		List<User> list=new ArrayList<User>();
		String search_item=request.getParameter("search_item");
		String name=request.getParameter("name");
		Service s=new Service();
		list=s.searchUserByName(search_item,name);
		System.out.print(list);
		if(list == null) {
			System.out.print("list¿Õ");
			request.getRequestDispatcher("user-list.jsp").forward(request, response);
			return;
		}else {
			request.setAttribute("user", list);
			System.out.print("servlet½áÊø");
			System.out.print(list);
			request.getRequestDispatcher("addUserSuccess.jsp").forward(request, response);
		}
	}

}
