<%@ page language="java"  isELIgnored="false"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="frm"%>
<h1 style="color:red;text-align:center">Edit the record</h1>

<frm:form modelAttribute="emp">
<table align="center" bgcolor="green">
<tr>
<td>emp no::</td>
<td><frm:input path="empno" readonly="true"/></td>
</tr>
<tr>
<td>emp name::</td>
<td><frm:input path="ename" /></td>
</tr>
<tr>
<td>emp sal::</td>
<td><frm:input path="sal" /></td>
</tr>
<tr>
<td>emp job::</td>
<td><frm:input path="job" /></td>
</tr>
<tr>
<td>emp deptno::</td>
<td><frm:input path="deptno" /></td>
</tr>
<tr>
<td><input type="submit" value="edit emp"></td>
<td><input type="reset" value="cancel"></td>
</tr>
</table>
</frm:form>