<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<form action="/springmvcTest/test/picUpload.do" method="post" enctype="multipart/form-data">
		选择图片：<input type="file" name="myPic"/><br/>
		<input type="submit" value="提交"/>
	</form>
	
	<form action="/springmvcTest/test/picUpload2.do" method="post" enctype="multipart/form-data">
		选择图片：<input type="file" name="myPic2"/><br/>
		选择图片：<input type="file" name="myPic2"/><br/>
		<input type="submit" value="提交"/>
	</form>
	
	<br/>
	<a href="/springmvcTest/test/download.do?photo=6.jpg">下载图片1</a>
	
	
	

</body>
</html>