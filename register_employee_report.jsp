<%@ page language="java"  isELIgnored="false"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="frm" %>
<h1 style="color:red;text-align:center">employee registration  form page</h1>
<frm:form action="register" method="POST" modelAttribute="emp">
<p style="color:red">
<frm:errors path="*"/>
</p>
<table align="center" bgcolor="wheat">
<tr>
<td>employee name::</td>
<td><frm:input path="ename"/></td>
</tr>
<tr>
<td>employee salary::</td>
<td><frm:input path="sal"/></td>
</tr>
<tr>
<td>employee job::</td>
<td><frm:input path="job"/></td>
</tr>
<tr>
<td>employee deptno::</td>
<td><frm:input path="deptno"/></td>
</tr>
<tr>
<td><input type="submit" value="register"></td>
<td><input type="reset" value="cancel"></td>
</tr>
</table>
</frm:form>
