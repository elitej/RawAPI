<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>

<link href="../resources/style/css/bootstrap.min.css" rel="stylesheet"/>"
    <%--<a href="<c:url value="/index.jsp"/>">TEST</a>--%>
</head>
<body>
<h2>Hello World!</h2>
<c:forEach begin="1" end="3" step="1" varStatus="loop">
    ${loop.index}
    <img src="<c:out value="/upload_screen/?imageId=${loop.current}.jpg"/>" alt="">
</c:forEach>
</body>
</html>
