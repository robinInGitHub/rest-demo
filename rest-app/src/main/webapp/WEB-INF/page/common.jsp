<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%
response.setHeader("Pragma","No-cache");
response.setHeader("Cache-Control","no-cache");
response.setDateHeader("Expires", 0);
%>
<c:set var="_currConText" value="${pageContext.request.contextPath }"></c:set>
<c:set var="_cssUrl" value="${pageContext.request.contextPath }"></c:set>
<c:set var="_jsUrl" value="${pageContext.request.contextPath }"></c:set>
<c:set var="_imageUrl" value="${pageContext.request.contextPath }"></c:set>
<c:set var="_version" value="0.1.0"></c:set>
<script type="text/javascript">
 	var _currConText = "${_currConText}";
</script>

<script type="text/javascript" src="${_currConText}/js/jquery/jquery-1.7.2.min.js"></script>
<script type="text/javascript" src="${_currConText}/js/jquery/jquery.pack.js"></script>
<script type="text/javascript" src="${_currConText}/js/jquery/jquery.SuperSlide.js"></script>
<script type="text/javascript" src="${_currConText}/js/jquery/jquery.easing.min.js"></script>
