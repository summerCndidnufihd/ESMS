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

import entity.Borrow;
import entity.User;
import service.Service;

/**
 * Servlet implementation class borrowInfoServlet
 */
@WebServlet("/borrowInfoServlet")
public class borrowInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public borrowInfoServlet() {
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
		System.out.print("������ʾ���ļ�¼��Ϣ�ģ�");
		int id=u.getId();
		//���ı��
		List<Borrow> list=new ArrayList<Borrow>();
		Service s=new Service();
		list=s.borrowInfo(id);
		if(list!=null) {
			System.out.print("���ļ�¼��Ϣ��");
			System.out.print(list);
			request.setAttribute("borrow", list);
			request.getRequestDispatcher("borrowInfo.jsp").forward(request, response);
		}else {
			System.out.print("-----�б�");
			request.setAttribute("borrow", list);
			request.getRequestDispatcher("borrowInfo.jsp").forward(request, response);
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
