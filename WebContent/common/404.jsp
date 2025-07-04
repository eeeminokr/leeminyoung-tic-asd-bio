<%@ page contentType="text/html;charset=UTF-8" %>
<%
	response.setStatus(HttpServletResponse.SC_OK); //200 
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>페이지를 찾을 수 없습니다</title>
</head>
<body>
<center>
<table border="0">
  <tr height="100">
    <td>
    </td>
  </tr>
  <tr height="100">
    <td>
      <a href="javascript:history.go(-1)"><img src="<%=request.getContextPath() %>/images/compliance/404.png" border="0'"></a>
    </td>
  </tr>
</table>
</center>
<p>
<!-- 
<a href="javascript:history.go(-1)">이전</a>
 -->
</body>
</html>