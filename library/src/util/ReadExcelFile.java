package util;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import entity.User;

public class ReadExcelFile {
	//总行数
	private int totalRows=0;
	//总条数
	private int totalCells=0;
	//错误信息接收
	private String errorMsg;
	//构造方法
	public ReadExcelFile() {
		
	}
	//获取总行数
	public int getTotalRows() {
		return totalRows;
	}
	//获取总条数
	public int getTotalCells() {
		return totalCells;
	}

	//获取错误信息
	public String getErrorInfo() {
		return errorMsg;
	}
	/**
	 * 读取Excel文件，获取信息集合
	 */
	public List<User> getExcelInfo(File mFile){
		String fileName=mFile.getName();//获取文件名
		System.out.print(fileName);
		List<User> userList=null;
//		boolean isExcel2003=false;
		if(!validateExcel(fileName)) {//验证文件名是否合格
			return null;
		}
		boolean isExcel2003=true;
		if(isExcel2007(fileName)) {
			isExcel2003=false;
			
		}
		userList=createExcel(mFile,isExcel2003);
		return userList;
	}
	/**
	 * 根据excel里面的内容读取信息
	 * @param mFile
	 * @param isExcel2003 是2003还是2007
	 * @return
	 */
	private List<User> createExcel(File mFile, boolean isExcel2003) {
		List<User> userList=null;
		try {
			Workbook wb=null;
			if(isExcel2003) {//2003时，创建2003版本
				wb=new HSSFWorkbook(new FileInputStream(mFile));
			}else {//2007时，创建2007版本
				wb=new XSSFWorkbook(mFile);
			}
			userList=readExcelValue(wb);
	     }catch(Exception e) {
	    	 e.printStackTrace();
	     }
		return userList;
	}
	/**
	 * 读取Excel中的信息
	 * @param wb
	 * @return
	 */
	private List<User> readExcelValue(Workbook wb) {
		//得到第一个shell
		Sheet sheet=wb.getSheetAt(0);
		//得到Excel行数
		this.totalRows=sheet.getPhysicalNumberOfRows();
		//得到列数(前提时有行数，加if判断)
		if(totalRows>1&&sheet.getRow(0) != null) {
			this.totalCells=sheet.getRow(0).getPhysicalNumberOfCells();
		}
		List<User> userList=new ArrayList<User>();
		//循环Excel行数，第一行是表头，不读
		for(int r=1;r<totalRows;r++) {
			Row row=sheet.getRow(r);
			if(row ==null) {
				continue;
			}
			User user=new User();
			//循环列数
			for(int c=0;c<totalCells;c++) {
				Cell cell = row.getCell(c);
				if(cell != null) {
					if(c == 0) {
						user.setuName(cell.getStringCellValue());//用户名
					}else if(c==1) {
						user.setuPwd(cell.getStringCellValue());//密码
					}else if(c==2) {
						user.setuRealName(cell.getStringCellValue());//真实姓名
					}else if(c==3) {
						user.setuSex(cell.getStringCellValue());//性别
					}else if(c==4) {
						int uAge=Integer.parseInt(cell.getStringCellValue());
						user.setuAge(uAge);//年龄
					}else if(c==5) {
						user.setuPhone(cell.getStringCellValue());//电话
					}else if(c==6) {
						int actor=Integer.parseInt(cell.getStringCellValue());
						user.setActor(actor);//年龄
					}else if(c==7) {
						int uBorrow=Integer.parseInt(cell.getStringCellValue());
						user.setActor(uBorrow);//已借书多少本
					}else if(c==8) {
						int uMaxBorrow=Integer.parseInt(cell.getStringCellValue());
						user.setActor(uMaxBorrow);//最高可借多少本
					}
				}
			}
			userList.add(user);
		}
		System.out.print("Excel列表："+userList);
		return userList;
	}
	
	/**
	 * 验证Excel文件
	 * @param filePath
	 * @return
	 */
	private boolean validateExcel(String filePath) {
		if(filePath == null || !(isExcel2003(filePath) || isExcel2007(filePath))) {
			errorMsg="文件名不是Excel格式！";
			return false;
		}
		return true;
	}
	/**
	 * 验证是否2003版本
	 * @param filePath
	 * @return
	 */
	private boolean isExcel2003(String filePath) {
		return filePath.matches("^.+\\.(?i) (xls)$");
	}
	/**
	 * 判断文件是否2007版本，返回true是2007
	 * @param filePath
	 * @return
	 */
	private boolean isExcel2007(String filePath) {
		return filePath.matches("^.+\\.(?i) (xlsx)$");
	}
}
