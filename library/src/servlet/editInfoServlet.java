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
import entity.User;
import service.Service;

/**
 * Servlet implementation class editInfoServlet
 */
@WebServlet("/editInfoServlet")
public class editInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public editInfoServlet() {
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
		HttpSession session = request.getSession();
		User u=(User) session.getAttribute("user");
		System.out.print("这是修改信息的：");
//		int id=Integer.parseInt(request.getParameter("id"));
		int id=u.getId();
//		List<User> list=new ArrayList<User>();
		String uName=request.getParameter("uName");
		String uPwd=request.getParameter("uPwd");
		String uRealName=request.getParameter("uRealName");
		int uAge=Integer.parseInt(request.getParameter("uAge"));
		String uPhone=request.getParameter("uPhone");
		User user=new User();
		Service s=new Service();
		user.setId(id);
		user.setuName(uName);
		user.setuPwd(uPwd);
		user.setuRealName(uRealName);
		user.setuAge(uAge);
		user.setuPhone(uPhone);
		if(s.editInfo(user)) {
			response.sendRedirect("myInfo.jsp");
//			request.setAttribute("user", user);
//			request.getRequestDispatcher("myInfo.jsp").forward(request, response);
//			response.sendRedirect("myInfo.jsp");
		}
	}

}
