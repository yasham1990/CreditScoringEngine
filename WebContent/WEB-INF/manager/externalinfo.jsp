<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html>
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Admin Home Page</title>
<jsp:include page="/common.jsp"/>
<script type="text/javascript">
function go(action)
{
	//action='hello';
	$('form#form1').attr('action',action);
	
	//alert($('form#form1').attr('action'));
	$('form#form1').submit();
}
</script>
</head>
<body>

<div class="container">
<div class="row">
             <div class="col-md-5 col-md-offset-4">
            <div class="panel panel-default">
                <div class="panel-heading"> <strong class="">Employee Details</strong>

                </div>
                <div class="panel-body">

      <form id="form1" method="post" action="externalback" role="form">
      <div class="form-group">
            <label for="id" class="col-sm-4 control-label">Application No. id:</label>
            <div class="col-sm-10">
            <p class="form-control-static"><s:property value="appno"/></p>
            </div>
      </div>
      <div class="form-group">
            <label for="clientName" class="col-sm-4 control-label">First Name:</label>
            <div class="col-sm-10">
        <p class="form-control-static"><s:property value="fname"/></p></div>	
      </div>
      <div class="form-group">
            <label for="clientName" class="col-sm-4 control-label">Last Name:</label>
            <div class="col-sm-10">
        <p class="form-control-static"><s:property value="lname"/></p></div>	
      </div>
      <div class="form-group">
            <label for="address" class="col-sm-4 control-label">Address:</label>
             <div class="col-sm-10"> <p class="form-control-static"><s:property value="address"  /></p></div>
      </div>
      <div class="form-group">
            <label for="phone" class="col-sm-4 control-label">Mobile:</label>
             <div class="col-sm-10"> <p class="form-control-static"><s:property value="phone"/></p></div>
      </div>
      <div class="form-group">
            <label for="email" class="col-sm-4 control-label">Email:</label>
           <div class="col-sm-10"> <p class="form-control-static"><s:property value="email"/></p></div>
      </div>
      <div class="form-group">
            <label for="member" class="col-sm-4 control-label">Family Members:</label>
           <div class="col-sm-10"> <p class="form-control-static"><s:property value="member"  /></p></div>
      </div>
      <div class="form-group">
           <label for="area" class="col-sm-4 control-label">House Area:</label>
           <div class="col-sm-10"> <p class="form-control-static"><s:property value="area"/></p></div>
      </div>  
      <div class="form-group">
           <label for="hloan" class="col-sm-4 control-label">House Loan:</label>
           <div class="col-sm-10"> <p class="form-control-static"><s:property value="hloan"/></p></div>
      </div>   
      <div class="form-group">
           <label for="hpaid" class="col-sm-4 control-label">House Loan Paid:</label>
           <div class="col-sm-10"> <p class="form-control-static"><s:property value="hpaid"/></p></div>
      </div>   
      <div class="form-group">
           <label for="billpay" class="col-sm-4 control-label">Bill Pay:</label>
           <div class="col-sm-10"> <p class="form-control-static"><s:property value="billpay"/></p></div>
      </div> 
      <div class="form-group">
           <label for="cars" class="col-sm-4 control-label">No. Of Cars Pay:</label>
           <div class="col-sm-10"> <p class="form-control-static"><s:property value="cars"/></p></div>
      </div>       
       <div class="form-group">
           <label for="cloan" class="col-sm-4 control-label">Car Loan:</label>
           <div class="col-sm-10"> <p class="form-control-static"><s:property value="cloan"/></p></div>
      </div> 
      
      <div class="form-group">
           <label for="cpaid" class="col-sm-4 control-label">Car Loan Pay:</label>
           <div class="col-sm-10"> <p class="form-control-static"><s:property value="cpaid"/></p></div>
      </div> 
      <div class="form-group">
           <label for="income" class="col-sm-4 control-label">Net Income:</label>
           <div class="col-sm-10"> <p class="form-control-static"><s:property value="income"/></p></div>
      </div>    
       <div class="form-group">
           <label for="nfd" class="col-sm-4 control-label">No Of Fds:</label>
           <div class="col-sm-10"> <p class="form-control-static"><s:property value="nfd"/></p></div>
      </div> 
       <div class="form-group">
           <label for="fdamount" class="col-sm-4 control-label">Net Fds Amount:</label>
           <div class="col-sm-10"> <p class="form-control-static"><s:property value="fdamount"/></p></div>
      </div> 
       <div class="form-group">
           <label for="agland" class="col-sm-4 control-label">Agriculture Land Value:</label>
           <div class="col-sm-10"> <p class="form-control-static"><s:property value="agland"/></p></div>
      </div>  
      <div class="form-group">
           <label for="lic" class="col-sm-4 control-label">Lic:</label>
           <div class="col-sm-10"> <p class="form-control-static"><s:property value="lic"/></p></div>
      </div>  
      <div class="form-group">
           <label for="bankdefault" class="col-sm-4 control-label">Bank Defaults:</label>
           <div class="col-sm-10"> <p class="form-control-static"><s:property value="bankdefault"/></p></div>
      </div>
      <div class="form-group">
           <label for="tax" class="col-sm-4 control-label">Tax Defaults:</label>
           <div class="col-sm-10"> <p class="form-control-static"><s:property value="tax"/></p></div>
      </div> 
      <div class="form-group">
           <label for="crime" class="col-sm-4 control-label">Crime Commited:</label>
           <div class="col-sm-10"> <p class="form-control-static"><s:property value="crime"/></p></div>
      </div> 
      <div class="form-group">
           <label for="otherinc" class="col-sm-4 control-label">Other Income Source:</label>
           <div class="col-sm-10"> <p class="form-control-static"><s:property value="otherinc"/></p></div>
      </div>
      <div class="form-group">
           <label for="otherbankcard" class="col-sm-4 control-label">Other Bank Card:</label>
           <div class="col-sm-10"> <p class="form-control-static"><s:property value="otherbankcard"/></p></div>
      </div>       
   <div class="form-group">   
   <div class="col-sm-offset-2 col-sm-10">     
  <s:submit action="externalback" cssClass="btn btn-success btn-sm"  value="Back" /> </div>  </div>
  </form>   
</div></div></div></div></div>

</body>
</html>

