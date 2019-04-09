<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<head>  
<style>  
.error{color:red}  
</style>  
</head>  
<h1>Student Registration Form</h1>

<form:form method="POST" commandName="studCmd">
<%-- <form:errors path="*" cssClass="error"/><br> --%>
Name ::<form:input path="sname"/><form:errors path="sname" cssClass="error"/><br>
Address ::<form:input path="address"/><form:errors path="address" cssClass="error"/><br>
Mobile ::<form:input path="mobile"/><form:errors path="mobile" cssClass="error"/><br>
Email ::<form:input path="email"/><form:errors path="email" cssClass="error"/><br>
<input type="submit" value="Register"/>
</form:form>