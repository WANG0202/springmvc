package test1027.ctrl;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

//控制器类
@Controller
@RequestMapping("/test")
public class Test2Ctrl {
	@Autowired
	private HttpSession session;
	@Autowired
	private HttpServletRequest request;
	@Autowired
	private ServletContext application;
	
	
	
	
	@RequestMapping("/admin/test1.do")
	public String test1() {
		System.out.println("test1()");
		
		return "hello";
		
	}
	
	@RequestMapping("/test2.do")
	public String test2(@RequestParam("uinfo") String info) {
		System.out.println("test2()");
		System.out.println("info:"+info);
		
		return "hello";
	}
	@RequestMapping("/test3.do")
	public String test3(@RequestParam(value="uinfo",required=false,defaultValue="default") String info,@RequestParam("uinfo2")String info2,@RequestParam(required=false,defaultValue="1")int page) {
		System.out.println("test3()");
		System.out.println("info:"+info);
		System.out.println("info2:"+info2);
		System.out.println("page:"+page);
		return "hello";
	}
	@RequestMapping(value="/test4.do",method=RequestMethod.POST)
	public String test4() {
		System.out.println("test4()");
		return "hello";
	}
	@RequestMapping(value="/test4.do",method=RequestMethod.GET)
	public String test42(HttpServletRequest request,HttpSession session) {
		System.out.println("test42()");
		
		request.setAttribute("info", "hello");
		session.setAttribute("info2", "zhangsan");
		
		return "hello";
	}
	@RequestMapping("/test5.do")
	public String test5(String info) {
		session.setAttribute("uname", info);
//		return "redirect:/hello.jsp";
		
//		return "hello";
//		return "forward:/hello.jsp";
		return "redirect:/users/insert.do";
	}
	@RequestMapping("/test6.do")
	public ModelAndView test6(String info) {
		//创建ModelAndView对象
		ModelAndView view=new ModelAndView();
		//存值  --request
		view.addObject("uid3", info);
		//设置跳转页面
		view.setViewName("hello");
		return view;
	}
	
	
//	@RequestMapping("/test6.do")
//	public String test6(String info,Model model) {
//		model.addAttribute("uid2", info);
//		
//		return "hello";
//	}
	
//	@RequestMapping("/test6.do")
//	public String test6(String info,Map map) {
//		map.put("uid", "abc");
//		return "hello";
//	}
//	
	@RequestMapping("/picUpload.do")
	public String upload(MultipartFile myPic,HttpSession session) {
		//上传的文件名及后缀
//		String name = myPic.getOriginalFilename(); 
//		System.out.println(name);
//		//文件的大小 字节为单位
//		long size = myPic.getSize();
//		System.out.println(size);
//		//true 空的  false 不为空
//		boolean b = myPic.isEmpty();
//		System.out.println(b);
		
		//获取服务器目录
		String path=session.getServletContext().getRealPath("/upload");
		System.out.println(path);
		//上传的文件名及后缀
		String name = myPic.getOriginalFilename(); 
		
		File file=new File(path,name);
		try {
			//上传文件
			myPic.transferTo(file);
			
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		return "hello";
	}
	
	@RequestMapping("/picUpload2.do")
	public String upload2(@RequestParam("myPic2")MultipartFile[] myPic2,HttpSession session) {
		//获取服务器目录
		String path=session.getServletContext().getRealPath("/upload");
		for(MultipartFile mf:myPic2) {
			String name=mf.getOriginalFilename();
			
			try {
				
				mf.transferTo(new File(path,name));
			} catch (IllegalStateException | IOException e) {
				e.printStackTrace();
			}
		}
		
		
		return "hello";
	}
	
	@RequestMapping("/download.do")
	public ResponseEntity<byte[]> download(HttpSession session, String photo) {  
        try {
		HttpHeaders headers = new HttpHeaders();  
		headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);  
		//filename=?  用户下载时默认文件名
		headers.set("Content-Disposition", "attachment; filename="+photo);  
		
		//要下载的文件     路径   文件名及后缀
		String path=session.getServletContext().getRealPath("/upload");
		File file=new File(path,photo);
			
		return new ResponseEntity<byte[]>(FileUtils.readFileToByteArray(file),
			                                  headers, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
		}  
		return null;
    } 

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
