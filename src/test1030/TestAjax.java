package test1030;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import bean.Users;

@Controller
@RequestMapping("/testAjax")
public class TestAjax {
	@RequestMapping("/test1.do")
	@ResponseBody
	public String test1(String str) {
		System.out.println("数据："+str);
		return "ok";
	}
	@RequestMapping("/test2.do")
	@ResponseBody
	public String test2(@RequestBody Users u) {//jsonObject
		System.out.println(u.getLoginId()+u.getLoginPwd());
		return "ok";
	}
	
	@RequestMapping("/test3.do")
	@ResponseBody
	public Map test3(String loginId,String loginPwd) {
		System.out.println("数据："+loginId+" "+loginPwd);
		
		Users u=new Users();
		u.setLoginId(loginId);
		u.setLoginPwd(loginPwd);
		Map map=new HashMap();
		map.put("state", 100);
		map.put("users", u);
		
		return map;
	}

}
