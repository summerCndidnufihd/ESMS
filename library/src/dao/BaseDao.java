package dao;

import java.sql.*;
import java.util.*;

public class BaseDao {
	//存放connection对象的数组
	static ArrayList <Connection> list= new ArrayList<Connection>();
	/**
	 * 获取连接
	 * @return
	 */
	public synchronized static Connection getConnection() {
		Connection con = null;
		if(list!=null && list.size()>0) {
			return list.remove(0);
		}else {
					try {
						Class.forName("com.mysql.jdbc.Driver");
						System.out.println("数据库连接");
					} catch (ClassNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					try {
						con=DriverManager.getConnection("jdbc:mysql://localhost:3306/library?characterEncoding=utf-8&useSSL=false&serverTimezone=GMT%2B8","root","6669");
						System.out.println("数据库初始化成功!");
						list.add(con);
						} catch (SQLException e) {
						// TODO Auto-generated catch block
							System.out.println("数据库初始化失败");
						e.printStackTrace();
					}
		}
		return list.remove(0);
	}
	/**
	 * 关闭结果集
	 * @param rs
	 */
	public static void close(ResultSet rs) {
		if(rs!=null) {
			try {
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	/**
	 * 关闭预处理
	 * @param pst
	 */
	public static void close(PreparedStatement pst) {
		if(pst!=null) {
			try {
				pst.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	/**
	 * 关闭连接
	 * @param con
	 */
	public synchronized static void close(Connection con) {
		if(con!=null) {
			list.add(con);
		}
	}
	/**
	 * 关闭所有连接对象
	 * @param rs
	 * @param pst
	 * @param con
	 */
	public static void close(ResultSet rs,PreparedStatement pst,Connection con) {
		close(rs);
		close(pst);
		close(con);
	}
	/**
	 * 增、删、改，更新操作
	 * @param sql
	 * @param param
	 * @return
	 */
	public boolean update(String sql) {
		boolean flag=true;
		Connection con = getConnection();
		PreparedStatement ps=null;
		try {
			ps=con.prepareStatement(sql);
			int n=ps.executeUpdate();
			if(n>0) {
				flag=true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(null,ps,con);
		}
		return flag;
	}
	
	/**
	 * 查询操作
	 * @param sql
	 * @param param
	 * @return
	 */
	public static ResultSet select(String sql){
		Connection con=getConnection();
		PreparedStatement ps=null;
		try {
			ps=con.prepareStatement(sql);
			return ps.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
		
	}
	
	public static List<Map<String, Object>> select1(String sql) {
		Connection con=getConnection();
		PreparedStatement ps=null;
		ResultSet rs=null;
		List<Map<String, Object>> list=new ArrayList<Map<String, Object>>();
		try {
			ps=con.prepareStatement(sql);
			rs=ps.executeQuery();
			ResultSetMetaData rm=rs.getMetaData();
			int count=rm.getColumnCount();
			while(rs.next()) {
				Map<String,Object> map=new HashMap<String,Object>();
				for(int i=1;i<=count;i++) {
					map.put(rm.getColumnName(i), rs.getObject(rm.getColumnName(i)));
				}
				list.add(map);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
}
