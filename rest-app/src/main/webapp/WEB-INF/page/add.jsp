<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/page/common.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="${_currConText}/js/person/person.js"></script>

</head>
<body>
<form action="/person/add.do" method="post">
 <table cellpadding="0" cellspacing="0" width="100%" >
      <tr>
        <td width="8%">姓名：</td>
        <td width="20%"><input type="text" id="name" name="name" value="" /></td>
      </tr>
     <tr>
        <td width="8%">年龄：</td>
        <td width="20%"><input type="text" id="age" name="age" value="" /></td>
     </tr>
 	 <tr>
        <td width="30%" colspan="2"><input type="submit" value="确定"/></td>
     </tr>
</table>
</form>
</body>
</html>