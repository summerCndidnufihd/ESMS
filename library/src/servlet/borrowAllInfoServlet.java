package servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.Borrow;
import entity.User;
import service.Service;

/**
 * Servlet implementation class borrowAllInfoServlet
 */
@WebServlet("/borrowAllInfoServlet")
public class borrowAllInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public borrowAllInfoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		List<Borrow> list=new ArrayList<Borrow>();
		Service s=new Service();
		list=s.borrowAllInfo();
		System.out.print(list);
		if(list == null) {
			System.out.print("list¿Õ");
			request.getRequestDispatcher("borrowAllInfo.jsp").forward(request, response);
			return;
		}else {
			request.setAttribute("borrow", list);
			System.out.print("servlet½áÊø");
			System.out.print(list);
			request.getRequestDispatcher("borrowAllInfo.jsp").forward(request, response);
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
