<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Result</title>
</head>
<body>
<table border="1">
    <tr>
        <th>First name</th>
        <th>Last name</th>
        <th>Middle name</th>
        <th>Date of birth</th>
        <th>Gender</th>
    </tr>
    <c:forEach items="${list}" var="person">
        <c:if test="${person.getFirstName() != null &&
                person.getLastName() != null &&
                person.getMiddleName() != null}">
            <tr>
                <td>${person.getFirstName()}</td>
                <td>${person.getLastName()}</td>
                <td>${person.getMiddleName()}</td>
                <td>${person.getDateOfBirth()}</td>
                <td>${person.getGender()}</td>
            </tr>
        </c:if>
    </c:forEach>
</table>
<p><a href="/">Get back</a></p>
</body>
</html>
