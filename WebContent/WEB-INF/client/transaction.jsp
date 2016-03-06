<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <title>Transaction</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <link rel="stylesheet" type="text/css" href="/WebApplication7/clientcss/transaction.css" />
    <script language="JavaScript" type="text/javascript">
window.history.forward(1);
</script>
</head>


    <body>
<!-- end of templatemo_header_wrapper -->   

<div id="templatemo_banner_wrapper">

	<div id="templatemo_banner">
    <p><img src="/WebApplication7/userimages/banner.jpg"  alt="banner" height="120" width="130"/> </p>
    	<h2>SAHARA BANK</h2>
     
    </div> <!-- end of templatemo_banner -->
    
</div> <!-- end of templatemo_banner_wrapper -->

  
    
    <div id="templatemo_content">
    
         <div class="content_section">
          <form id="form1" name="form1" method="post"  class="fund">
               
    <fieldset class="main">
        <p class="format">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Please Enter Date.Format dd/mm/yyyy</p>
       
   <table class="date">
       
       <tr><td><s:textfield name="transdate" cssClass="text1" label="Date"  /></td></tr>
       <tr></tr>
   </table>
           <s:submit value="submit" action="transcheck" cssClass="button1"   />
           <s:submit  action="translistback" value="back" cssClass="button1"/>
    </fieldset>
       <fieldset class="main1">
    <legend>Transactions </legend>
    <p class="tab">Transaction Type&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Date&Time&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Amount(Rs)</p>
           <table>
               
           <s:iterator value="h1" ><tr><td><s:property  /></td> </tr></s:iterator>
         </table>
     
              
  </fieldset>
  
    </form>
       </div>
       </div> <!-- end of templatemo_content -->
    
<div id="templatemo_footer_wrapper">
<div id="templatemo_footer">
   
    <center>Copyright © 2012 |  SAHARA BANK</center>
   
</div> <!-- end of footer -->
</div>
</body>
</html>

