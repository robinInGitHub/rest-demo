<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/page/common.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>PERSON</title>
<script type="text/javascript" src="${_currConText}/js/person/person.js"></script>
</head>
<body>
	<div id="content">
		<h3>Person</h3>
		<table cellpadding="1" cellspacing="1" width="60%">
			<tr bgcolor="#DBFAC2" align="center">
				<td width="8%">序号</td>
				<td width="20%">姓名</td>
				<td width="20%">年龄</td>
				<td width="30%">操作</td>
			</tr>
			<tr align="center">
				<td width="8%">${person.id}</td>
				<td width="20%">${person.name}</td>
				<td width="20%">${person.age}</td>
				<td width="30%"><a
					href="javascript:Person.modifyUserView('${person.id}');">修改</a> <a
					href="javascript:Person.deleteUser('${person.id}');">删除</a></td>
			</tr>
		</table>
	</div>
</body>
</html>