package test1030;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
@RequestMapping("/testctrl")
public class TestCtrl{
//	@ExceptionHandler({ArithmeticException.class,NullPointerException.class})
//	@ExceptionHandler(Exception.class)
//	public String handleException(Exception ex) {
//		ex.printStackTrace();
//		
//		//错误页面
//		return "error";
//	}
	
	

	@RequestMapping("/test1.do")
	public String test1() {
		String str=null;
		String s=str.substring(2);
		
		return "hello";
	}
	
	@RequestMapping("/test2.do")
	public String test2() {
		int a=10/0;
		
		return "hello";
	}
	
	
}
