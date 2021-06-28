package test1027.ctrl;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/users")
public class UsersCtrl {
	@RequestMapping("/login.do")
	public String login(String userid,String userpwd) {//Users u  --name--Users的属性名
		System.out.println(userid+" "+userpwd);
		//dao selectById
		
		return "hello";
	}
	@RequestMapping("/insert.do")
	public String insert() {
		System.out.println("inse");
		return "";
	}


}
