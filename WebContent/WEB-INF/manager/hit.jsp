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
      <form id="form1" method="post" action="Datatoadmin" role="form">
      <div class="form-group">
            <label for="id" class="col-sm-4 control-label">Application No. id:</label>
            <div class="col-sm-10">
            <p class="form-control-static"><s:property value="%{#session.app_no}"/></p>
            </div>
      </div>
      <div class="form-group">
            <label for="income1" class="col-sm-4 control-label">Income:</label>
            <div class="col-sm-10">
        <p class="form-control-static"><s:property value="income1"/></p></div>	
      </div>
      <div class="form-group">
            <label for="taxpay" class="col-sm-4 control-label">Tax Default:</label>
            <div class="col-sm-10">
        <p class="form-control-static"><s:property value="taxpay"/></p></div>	
      </div>
      <div class="form-group">
            <label for="billpay" class="col-sm-4 control-label">Bill Pay On Time:</label>
             <div class="col-sm-10"> <p class="form-control-static"><s:property value="billpay"  /></p></div>
      </div>
      <div class="form-group">
            <label for="otherbank" class="col-sm-4 control-label">Other Bank Cards:</label>
             <div class="col-sm-10"> <p class="form-control-static"><s:property value="otherbank"/></p></div>
      </div>
      <div class="form-group">
            <label for="nfd" class="col-sm-4 control-label">No. Of Fds:</label>
           <div class="col-sm-10"> <p class="form-control-static"><s:property value="nfd"/></p></div>
      </div>
      <div class="form-group">
            <label for="bankdefault" class="col-sm-4 control-label">Bank Default:</label>
           <div class="col-sm-10"> <p class="form-control-static"><s:property value="bankdefault"  /></p></div>
      </div>
      <div class="form-group">
           <label for="loanpaidhome" class="col-sm-4 control-label">House Loan Paid On Time:</label>
           <div class="col-sm-10"> <p class="form-control-static"><s:property value="loanpaidhome"/></p></div>
      </div>   
      <div class="form-group">
           <label for="loanpaidcar" class="col-sm-4 control-label">Car Loan:</label>
           <div class="col-sm-10"> <p class="form-control-static"><s:property value="loanpaidcar"/></p></div>
      </div>   
      <div class="form-group">
           <label for="criminalrecord" class="col-sm-4 control-label">Criminal Record:</label>
           <div class="col-sm-10"> <p class="form-control-static"><s:property value="criminalrecord"/></p></div>
      </div> 
      <div class="form-group">
           <label for="lic" class="col-sm-4 control-label">No.of Lic:</label>
           <div class="col-sm-10"> <p class="form-control-static"><s:property value="lic"/></p></div>
      </div>       
      <div class="form-group">
           <label for="aggland" class="col-sm-4 control-label">Agricultural Land:</label>
           <div class="col-sm-10"> <p class="form-control-static"><s:property value="aggland"/></p></div>
      </div>       
      <div class="form-group">
           <label for="otherinc" class="col-sm-4 control-label">OtherIncome:</label>
           <div class="col-sm-10"> <p class="form-control-static"><s:property value="otherinc"/></p></div>
      </div>       
      <div class="form-group">
           <div class="col-sm-10"> 
           <p class="form-control-static">Min Score:60</p>
           <p class="form-control-static">Gold:80 </p>
           <p class="form-control-static">Platinum:92 </p>
      </div>  
      </div>     
      <div class="form-group">
           <label for="otherinc" class="col-sm-4 control-label">Total Score:</label>
           <div class="col-sm-10"> <p class="form-control-static"><s:property value="totscore"/></p></div>
      </div>       
   <div class="form-group">   
   <div class="col-sm-offset-2 col-sm-10"> 
   	<button type="button" class="btn btn-success" onclick="go('Datatoadmin')">Forward</button>
   	<button type="button" class="btn btn-success" onclick="go('generateback')">Back</button>    
   	</div></div>
  </form>   
</div></div></div></div></div>

</body>
</html>
