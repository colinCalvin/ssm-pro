<%@page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<body>
<%--访问index.jsp页面会直接跳转到对应页面--%>
<%--<jsp:forward page="/pages/main.jsp"></jsp:forward>--%>
<a href="${pageContext.request.contextPath}/product/findAll">查询所有产品信息</a>
</body>
</html>
