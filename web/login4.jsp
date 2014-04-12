<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<link rel="stylesheet" type="text/css" href="ExtJS/resources/css/ext-all.css"/>
<script type="text/javascript" src="ExtJS/ext-all.js"></script>
<script type="text/javascript" src="ExtJS/ext-lang-zh_CN.js"></script>
<script type="text/javascript" src="JavaScript/helloworld.js"></script>
<title><s:text name="loginPage"/></title>
</head>
<body>
<s:form action="login">
            <s:textfield name="username" key="user"/>
            <s:textfield name="password" key="pass"/>
            <s:submit value="submit" key="login"/>
</s:form>

</body>
</html>

