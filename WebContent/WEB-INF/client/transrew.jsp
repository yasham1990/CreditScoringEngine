<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
<script type="text/javascript">
function decision(){
<s:if test="%{out}">
                   alert("Successfull.You will be confirmed through mail."); 
                   </s:if>
        <s:else> 
        alert("Sorry you do not have sufficient points"); 
        </s:else>
}

window.history.forward(1);

</script>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <link rel="stylesheet" type="text/css" href="/WebApplication7/clientcss/fundtrans.css" />
    <title>Transaction Rewards</title>
</head>
<body onload="decision()">
<!-- end of templatemo_header_wrapper -->   

<div id="templatemo_banner_wrapper">

	<div id="templatemo_banner">
    <p><img src="/WebApplication7/userimages/banner.jpg"  alt="banner" height="120" width="130"/> </p>
    	<h2>SAHARA BANK</h2>
     
    </div> <!-- end of templatemo_banner -->
    
</div> <!-- end of templatemo_banner_wrapper -->

  
    
    <div id="templatemo_content">
    <form action="Gobackemp" method="post">
    <fieldset class="main">
     <legend>Info Message</legend>
     <h1>Click here to go back...</h1>
      <s:submit value="Back" action="transrewback"  cssClass="button" />
    </fieldset>        
 </form>
   </div> <!-- end of templatemo_content -->
    
<div id="templatemo_footer_wrapper">
<div id="templatemo_footer">
   
    <center>Copyright © 2012 |  SAHARA BANK</center>
   
</div> <!-- end of footer -->
</div>
</body>
</html>

