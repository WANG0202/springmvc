package test1030;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.AbstractHandlerExceptionResolver;

public class CtrlException extends AbstractHandlerExceptionResolver{

	@Override
	protected ModelAndView doResolveException(HttpServletRequest request, HttpServletResponse response, Object obj,
			Exception e) {
		System.out.println("---");
		
		if(e instanceof NullPointerException) {
			return new ModelAndView("error");
		}else if(e instanceof ArithmeticException) {
			return new ModelAndView("error2");
		}
		
//		ModelAndView view=new ModelAndView("error");
//		view.setViewName("error");
		
		return new ModelAndView("error");
	}

}
