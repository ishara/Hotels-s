<%--<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core"%>--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <title>Welcome</title>
</head>
<body>
  <p>
  Search Hotels
  </p>
  <p>
    <form action="index" method="get">
        <input type="text" name="text" />
        <input type="submit" value="Search" />
    </form>
  </p>

  <p>
  <ul>
    <c:forEach var="hotel" items="${hotels}">
      <li>
        <div><c:out value="${hotel.hotel_name}"/></div>
        <%--<div><a href="index?id=<c:out value="${message.id}"/>">Delete</a></div>--%>
      </li>
    </c:forEach>
  </ul>
  </p>
</body>
</html>