package servlet;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import entity.User;
import util.MyUtil;
import util.ReadExcelFile;
import dao.BaseDao;

/**
 * Servlet implementation class readExcelFileServlet
 */
@WebServlet("/readExcelFileServlet")
@MultipartConfig
public class readExcelFileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public readExcelFileServlet() {
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
		String savePath=request.getServletContext().getRealPath("/uploadFile");
		//如果目录不在则创建
		File f= new File(savePath);
		if(!f.exists()) {
			f.mkdirs();
		}
		Part part = request.getPart("filePath");
		//获得文件名
		String fileName = MyUtil.getFileName(part);
		System.out.print(fileName);
		String newFileName = null;
		//选择了上传文件
		if(fileName != null && fileName.length() > 0) {
			int lastIndex = fileName.lastIndexOf(".");
			String fileType = fileName.substring(lastIndex);
			Date now = new Date();
			SimpleDateFormat sdf=new SimpleDateFormat("YYYYMMDDHHmmssSSS");
			newFileName = sdf.format(now)+fileType;
			//上传文件
			part.write(savePath + File.separator + newFileName);
		}
		System.out.print(newFileName);
		ReadExcelFile ref = new ReadExcelFile();
		//读取文件内容存入list
		List<User> ls = ref.getExcelInfo(new File(savePath,newFileName));
		System.out.print(ls);
		//批量保存到数据库
		Connection con = BaseDao.getConnection();
		PreparedStatement ps=null;
		try {
		ps = con.prepareStatement("insert into tb_user(id,uName,uPwd,uRealName,uSex"
				+ "uAge,uPhone,actor,uBorrow,uMaxBorrow) values(null,?,?,?,?,?,?,?,?)");
		if(ls != null) {
			for(int i=0; i < ls.size(); i++) {//多条记录
				ps.setString(1, ls.get(i).getuName());
				ps.setString(2, ls.get(i).getuPwd());
				ps.setString(3, ls.get(i).getuRealName());
				ps.setString(4, ls.get(i).getuSex());
				ps.setInt(5, ls.get(i).getuAge());
				ps.setString(6, ls.get(i).getuPhone());
				ps.setInt(7, ls.get(i).getActor());
				ps.setInt(8, ls.get(i).getuBorrow());
				ps.setInt(9, ls.get(i).getuMaxBorrow());
				ps.addBatch();
			}
			//批量保存
			ps.executeBatch();
		}
//		ps.close();
//		con.close();
	}catch(SQLException e) {
		e.printStackTrace();
	}
		request.setCharacterEncoding("utf-8");
		PrintWriter printWriter = response.getWriter();
		printWriter.print("<script>alert('导入成功！');window.location='"+request.getContextPath()+"/success.jsp';</script>");
	}
}
