package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.User;
import service.Service;

/**
 * Servlet implementation class updateUserInfoServlet
 */
@WebServlet("/updateUserInfoServlet")
public class updateUserInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public updateUserInfoServlet() {
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
		response.setContentType("text/html;charset=utf-8");
		User user=new User();
		int id=Integer.parseInt(request.getParameter("id"));
		String uName=request.getParameter("uName");
		String uPwd=request.getParameter("uPwd");
		String uRealName=request.getParameter("uRealName");
		String uSex=request.getParameter("uSex");
		int uAge=Integer.parseInt(request.getParameter("uAge"));
		String uPhone=request.getParameter("uPhone");
		user.setId(id);
		user.setuName(uName);
		user.setuPwd(uPwd);
		user.setuRealName(uRealName);
		user.setuSex(uSex);
		user.setuAge(uAge);
		user.setuPhone(uPhone);
		Service s=new Service();
		int a=0;
		a=s.updateUserInfo(user);
		PrintWriter printWriter = response.getWriter();
		if(a>0) {//�޸ĳɹ�
			printWriter.print("<script>alert('�޸ĳɹ���');window.location='"+request.getContextPath()+"/success.jsp';</script>");
		}else {//ʧ��
			printWriter.print("<script>alert('�޸�ʧ�ܣ�');window.location='"+request.getContextPath()+"/success.jsp';</script>");
		}
	}

}
