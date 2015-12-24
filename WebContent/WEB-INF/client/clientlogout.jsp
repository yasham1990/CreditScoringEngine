<%-- 
    Document   : clientlogout
    Created on : May 17, 2012, 2:58:34 PM
    Author     : yasham
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s" %>
<html >
<head>
<script type="text/javascript">
function decision(){
<s:if test="%{out}">
                   alert("Successfully Logged out"); 
                    window.location="/home.jsp";
                   </s:if>
}
</script>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Client Logout</title>
</head>
<body onload="decision()">
</body>
</html>
