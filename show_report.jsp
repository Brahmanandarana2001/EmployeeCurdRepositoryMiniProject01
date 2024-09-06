
<%@ page language="java"  isELIgnored="false"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:choose>
<c:when test="${!empty empList}">
<table border="1" align="center" bgcolor="cyan">
<tr>
<th>empno</th><th>ename</th><th>salary</th><th>deptno</th><th>deptname</th><th>Operations</th>
</tr>
<c:forEach var="emp" items="${empList}">
<tr>
<td>${emp.empno}</td>
<td>${emp.ename}</td>
<td>${emp.sal}</td>
<td>${emp.deptno}</td>
<td>${emp.job}</td>
<td><a href="edit?no=${emp.empno}"><img src="images/edit.jpeg" width="30" height="30"></a> &nbsp;&nbsp;&nbsp;
<a href="delete?no=${emp.empno}" onclick="return confirm('are you sure to delete it')"><img src="images/delete.jpeg" width="30" height="30"></a>
</td>
</tr>
</c:forEach>
</table>
</c:when>
<c:otherwise>
<h1 style="color:orange;text-align:center">Records are not found</h1>
</c:otherwise>
</c:choose>
<br><br><br>
<h2 style="color:orange;text-align:center">${result}</h2>
<center><a href="register">Register Employee<img  src="images/add.jpeg" width="30" height="30"></a><br><br><br>
<center><a href="./"><img src="images/home.jpeg">back to home</a>
 
 
 