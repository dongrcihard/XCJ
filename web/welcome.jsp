<%@ page language="java" contentType="text/html; charset=GBK"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<html>
    <head>
    <meta http-equiv="Content-Type" content="text/html; charset=GBK">
        <link rel="stylesheet" type="text/css" href="ExtJS/resources/css/ext-all.css"/>
        <script type="text/javascript" src="ExtJS/ext-all.js"></script>
        <script type="text/javascript" src="ExtJS/ext-lang-zh_CN.js"></script>
    <title><s:text name="succPage"/></title>
    </head>
    <body>
        <s:text name="succTip">
			<s:param>${sessionScope.user}</s:param>
		</s:text><br>
    </body>
</html>
