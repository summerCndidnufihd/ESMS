package servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.Book;
import entity.User;
import service.Service;

/**
 * Servlet implementation class addUser
 */
@WebServlet("/addUser")
public class addUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public addUser() {
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
		System.out.print("Ìí¼Ó¶ÁÕßµÄ");
		List<User> list=new ArrayList<User>();
		//int id=Integer.parseInt(request.getParameter("id"));
		String uName=request.getParameter("uName");
		String uPwd=request.getParameter("uPwd");
		String uRealName=request.getParameter("uRealName");
		String uSex=request.getParameter("uSex");
		int uAge=Integer.parseInt(request.getParameter("uAge"));
		String uPhone=request.getParameter("uPhone");
		int actor=Integer.parseInt(request.getParameter("actor"));
		User user=new User();
		//user.setId(id);
		user.setuName(uName);
		user.setuPwd(uPwd);
		user.setuRealName(uRealName);
		user.setuSex(uSex);
		user.setuAge(uAge);
		user.setuPhone(uPhone);
		user.setActor(actor);
		Service s=new Service();
		list=s.addUser(user);
		if(list!=null) {
			System.out.print(list);
			request.setAttribute("user", list);
			request.getRequestDispatcher("addUserSuccess.jsp").forward(request, response);
		}else {
			request.getRequestDispatcher("addUser.jsp").forward(request, response);
		}
	}

}
