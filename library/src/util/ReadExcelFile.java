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
	//������
	private int totalRows=0;
	//������
	private int totalCells=0;
	//������Ϣ����
	private String errorMsg;
	//���췽��
	public ReadExcelFile() {
		
	}
	//��ȡ������
	public int getTotalRows() {
		return totalRows;
	}
	//��ȡ������
	public int getTotalCells() {
		return totalCells;
	}

	//��ȡ������Ϣ
	public String getErrorInfo() {
		return errorMsg;
	}
	/**
	 * ��ȡExcel�ļ�����ȡ��Ϣ����
	 */
	public List<User> getExcelInfo(File mFile){
		String fileName=mFile.getName();//��ȡ�ļ���
		System.out.print(fileName);
		List<User> userList=null;
//		boolean isExcel2003=false;
		if(!validateExcel(fileName)) {//��֤�ļ����Ƿ�ϸ�
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
	 * ����excel��������ݶ�ȡ��Ϣ
	 * @param mFile
	 * @param isExcel2003 ��2003����2007
	 * @return
	 */
	private List<User> createExcel(File mFile, boolean isExcel2003) {
		List<User> userList=null;
		try {
			Workbook wb=null;
			if(isExcel2003) {//2003ʱ������2003�汾
				wb=new HSSFWorkbook(new FileInputStream(mFile));
			}else {//2007ʱ������2007�汾
				wb=new XSSFWorkbook(mFile);
			}
			userList=readExcelValue(wb);
	     }catch(Exception e) {
	    	 e.printStackTrace();
	     }
		return userList;
	}
	/**
	 * ��ȡExcel�е���Ϣ
	 * @param wb
	 * @return
	 */
	private List<User> readExcelValue(Workbook wb) {
		//�õ���һ��shell
		Sheet sheet=wb.getSheetAt(0);
		//�õ�Excel����
		this.totalRows=sheet.getPhysicalNumberOfRows();
		//�õ�����(ǰ��ʱ����������if�ж�)
		if(totalRows>1&&sheet.getRow(0) != null) {
			this.totalCells=sheet.getRow(0).getPhysicalNumberOfCells();
		}
		List<User> userList=new ArrayList<User>();
		//ѭ��Excel��������һ���Ǳ�ͷ������
		for(int r=1;r<totalRows;r++) {
			Row row=sheet.getRow(r);
			if(row ==null) {
				continue;
			}
			User user=new User();
			//ѭ������
			for(int c=0;c<totalCells;c++) {
				Cell cell = row.getCell(c);
				if(cell != null) {
					if(c == 0) {
						user.setuName(cell.getStringCellValue());//�û���
					}else if(c==1) {
						user.setuPwd(cell.getStringCellValue());//����
					}else if(c==2) {
						user.setuRealName(cell.getStringCellValue());//��ʵ����
					}else if(c==3) {
						user.setuSex(cell.getStringCellValue());//�Ա�
					}else if(c==4) {
						int uAge=Integer.parseInt(cell.getStringCellValue());
						user.setuAge(uAge);//����
					}else if(c==5) {
						user.setuPhone(cell.getStringCellValue());//�绰
					}else if(c==6) {
						int actor=Integer.parseInt(cell.getStringCellValue());
						user.setActor(actor);//����
					}else if(c==7) {
						int uBorrow=Integer.parseInt(cell.getStringCellValue());
						user.setActor(uBorrow);//�ѽ�����ٱ�
					}else if(c==8) {
						int uMaxBorrow=Integer.parseInt(cell.getStringCellValue());
						user.setActor(uMaxBorrow);//��߿ɽ���ٱ�
					}
				}
			}
			userList.add(user);
		}
		System.out.print("Excel�б�"+userList);
		return userList;
	}
	
	/**
	 * ��֤Excel�ļ�
	 * @param filePath
	 * @return
	 */
	private boolean validateExcel(String filePath) {
		if(filePath == null || !(isExcel2003(filePath) || isExcel2007(filePath))) {
			errorMsg="�ļ�������Excel��ʽ��";
			return false;
		}
		return true;
	}
	/**
	 * ��֤�Ƿ�2003�汾
	 * @param filePath
	 * @return
	 */
	private boolean isExcel2003(String filePath) {
		return filePath.matches("^.+\\.(?i) (xls)$");
	}
	/**
	 * �ж��ļ��Ƿ�2007�汾������true��2007
	 * @param filePath
	 * @return
	 */
	private boolean isExcel2007(String filePath) {
		return filePath.matches("^.+\\.(?i) (xlsx)$");
	}
}
