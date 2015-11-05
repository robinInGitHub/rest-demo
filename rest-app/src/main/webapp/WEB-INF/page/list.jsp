<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/page/common.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>PERSONS</title>
<style type="text/css">
tr,td{border:solid #add9c0; border-width:0px 1px 1px 0px;}
table{border:solid #add9c0; border-width:1px 0px 0px 1px; }
</style>
<script type="text/javascript" src="${_currConText}/js/person/person.js"></script>
<script type="text/javascript">
function addPersonView(){
	window.location.href=_currConText+"/person/add.do"; 
}
</script>
</head>
<body>
	<div id="content">
		<h3>Person List</h3>
		<p>
			<input type="button" value="新增 用户" onclick="addPersonView();" />
		<p>
		<table cellpadding="1" cellspacing="1" width="60%">
			<tr bgcolor="#DBFAC2" align="center">
				<td width="8%">序号</td>
				<td width="20%">姓名</td>
				<td width="20%">年龄</td>
				<td width="30%">操作</td>
			</tr>
			<c:forEach items="${persons}" var="person" varStatus="vstatus">
				<tr align="center">
					<td width="8%">${person.id}</td>
					<td width="20%">${person.name}</td>
					<td width="20%">${person.age}</td>
					<td width="30%">
						<a href="javascript:Person.modifyPersonView('${person.id}');">修改</a>
						<a href="javascript:Person.deletePerson('${person.id}');">删除</a>
					</td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>