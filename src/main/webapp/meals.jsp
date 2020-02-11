<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Its a meals!</title>
</head>
<body>
<h3><a href="index.html">Home</a></h3>
<hr>
<h2>Meals</h2>

<table border="1" width="100%" cellspacing="2" cellpadding="0" align="center" bgcolor="#A0ADB4">
    <tr>
      <td style="text-align: center;"><span style="color: #ffffff;">Date/time</span></td>
      <td style="text-align: center;"><span style="color: #ffffff;">Description</span></td>
      <td style="text-align: center;"><span style="color: #ffffff;">Calories</span></td>
    </tr>
    <c:forEach var="mealTo" items="${list}">
    <c:set var="varExcess" value="${mealTo.excess}"/>
        <c:if test="${(varExcess == true)}">
            <c:set var="varBgColor" value="#e33e2b"/>
        </c:if>
        <c:if test="${(varExcess == false)}">
            <c:set var="varBgColor" value="#5de05c"/>
        </c:if>
    <tr bgcolor = ${varBgColor}>
          <td align = center><c:out value="${mealTo.dateTime}"/></td>
          <td><c:out value="${mealTo.description}"/></td>
          <td align = center><c:out value="${mealTo.calories}"/></td>
     </tr>
    </c:forEach>
</table>

</body>
</html>