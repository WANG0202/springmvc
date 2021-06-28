package test1030;

import org.springframework.web.bind.annotation.ExceptionHandler;

public class BaseCtrl {
	
	
	

	@ExceptionHandler(Exception.class)
	public String handleException(Exception ex) {
		ex.printStackTrace();
		
		//错误页面
		return "error";
	}
	
	
	
	
	
	
}
