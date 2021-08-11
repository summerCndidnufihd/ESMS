package util;

import javax.servlet.http.Part;

public class MyUtil {
	public static String getFileName(Part part) {
		 String head = part.getHeader("Content-Disposition");
	     String fileName = head.substring(head.indexOf("filename=\"")+10, head.lastIndexOf("\""));
	     System.out.println(fileName);
	     return fileName;
	}
}
