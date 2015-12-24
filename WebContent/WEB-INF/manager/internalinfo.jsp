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
                <div class="panel-heading"> <strong class="">Internal Information By User</strong>

                </div>
                <div class="panel-body">

      <form id="form1" method="post" action="internalback" role="form">
      <fieldset>
	    <div id="legend">
	     <legend>Personal Details</legend>
	    </div>
      <div class="form-group">
            <label for="id" class="col-sm-4 control-label">Application Id:</label>
            <div class="col-sm-10">
            <p class="form-control-static"><s:property value="%{#session.app_no}"/></p>
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
            <label for="mobile" class="col-sm-4 control-label">Mobile:</label>
             <div class="col-sm-10"> <p class="form-control-static"><s:property value="mobile"/></p></div>
      </div>
      <div class="form-group">
            <label for="email" class="col-sm-4 control-label">Email:</label>
           <div class="col-sm-10"> <p class="form-control-static"><s:property value="email"/></p></div>
      </div>
      <div class="form-group">
            <label for="birth" class="col-sm-4 control-label">Date Of Birth:</label>
           <div class="col-sm-10"> <p class="form-control-static"><s:property value="birth"  /></p></div>
      </div>
      <div class="form-group">
            <label for="status" class="col-sm-4 control-label">Maritul Status:</label>
           <div class="col-sm-10"> <p class="form-control-static"><s:property value="status"  /></p></div>
      </div>
      <div class="form-group">
            <label for="sex" class="col-sm-4 control-label">Sex:</label>
           <div class="col-sm-10"> <p class="form-control-static"><s:property value="sex"  /></p></div>
      </div>
      <div class="form-group">
           <label for="pan" class="col-sm-4 control-label">Pan:</label>
           <div class="col-sm-10"> <p class="form-control-static"><s:property value="pan"/></p></div>
      </div>  
      <div class="form-group">
           <label for="mobile" class="col-sm-4 control-label">Mobile:</label>
           <div class="col-sm-10"> <p class="form-control-static"><s:property value="mobile"/></p></div>
      </div>
       <div class="form-group">
           <label for="email" class="col-sm-4 control-label">Email:</label>
           <div class="col-sm-10"> <p class="form-control-static"><s:property value="email"/></p></div>
      </div>      
      <div class="form-group">
           <label for="annual" class="col-sm-4 control-label">Annual Salary:</label>
           <div class="col-sm-10"> <p class="form-control-static"><s:property value="annual"/></p></div>
      </div>   
      <div class="form-group">
           <label for="monthly" class="col-sm-4 control-label">Monthly Salary:</label>
           <div class="col-sm-10"> <p class="form-control-static"><s:property value="monthly"/></p></div>
      </div> 
      </fieldset>
      <fieldset>
	    <div id="legend">
	     <legend>Contact Details</legend>
	    </div>
      
      <div class="form-group">
           <label for="door" class="col-sm-4 control-label">Door No:</label>
           <div class="col-sm-10"> <p class="form-control-static"><s:property value="door"/></p></div>
      </div>  
      <div class="form-group">
           <label for="street" class="col-sm-4 control-label">Street:</label>
           <div class="col-sm-10"> <p class="form-control-static"><s:property value="street"/></p></div>
      </div>
       <div class="form-group">
           <label for="landmark" class="col-sm-4 control-label">LandMark:</label>
           <div class="col-sm-10"> <p class="form-control-static"><s:property value="landmark"/></p></div>
      </div>      
      <div class="form-group">
           <label for="nationality" class="col-sm-4 control-label">Nationality:</label>
           <div class="col-sm-10"> <p class="form-control-static"><s:property value="nationality"/></p></div>
      </div>   
      <div class="form-group">
           <label for="city" class="col-sm-4 control-label">City:</label>
           <div class="col-sm-10"> <p class="form-control-static"><s:property value="city"/></p></div>
      </div> 
       <div class="form-group">
           <label for="state" class="col-sm-4 control-label">State:</label>
           <div class="col-sm-10"> <p class="form-control-static"><s:property value="state"/></p></div>
      </div> 
       <div class="form-group">
           <label for="zip" class="col-sm-4 control-label">Zip Code:</label>
           <div class="col-sm-10"> <p class="form-control-static"><s:property value="zip"/></p></div>
      </div> 
      <div class="form-group">
           <label for="resino" class="col-sm-4 control-label">Resident Number:</label>
           <div class="col-sm-10"> <p class="form-control-static"><s:property value="resino"/></p></div>
      </div> 
      </fieldset>
      <fieldset>
	    <div id="legend">
	     <legend>Employment Details</legend>
	    </div>
      <div class="form-group">
           <label for="profession" class="col-sm-4 control-label">Profession:</label>
           <div class="col-sm-10"> <p class="form-control-static"><s:property value="profession"/></p></div>
      </div>       
       <div class="form-group">
           <label for="ename" class="col-sm-4 control-label">Employee Name:</label>
           <div class="col-sm-10"> <p class="form-control-static"><s:property value="ename"/></p></div>
      </div> 
      
      <div class="form-group">
           <label for="eid" class="col-sm-4 control-label">Employee Id:</label>
           <div class="col-sm-10"> <p class="form-control-static"><s:property value="eid"/></p></div>
      </div> 
      <div class="form-group">
           <label for="join" class="col-sm-4 control-label">Date Of Join:</label>
           <div class="col-sm-10"> <p class="form-control-static"><s:property value="join"/></p></div>
      </div>    
       <div class="form-group">
           <label for="comaddress" class="col-sm-4 control-label">Company Address:</label>
           <div class="col-sm-10"> <p class="form-control-static"><s:property value="comaddress"/></p></div>
      </div> 
       <div class="form-group">
           <label for="officeno" class="col-sm-4 control-label">Office No:</label>
           <div class="col-sm-10"> <p class="form-control-static"><s:property value="officeno"/></p></div>
      </div> 
       <div class="form-group">
           <label for="officeemail" class="col-sm-4 control-label">Official Email:</label>
           <div class="col-sm-10"> <p class="form-control-static"><s:property value="officeemail"/></p></div>
      </div>  
      </fieldset>
      <fieldset>
	    <div id="legend">
	     <legend>Further Details</legend>
	    </div>
      <div class="form-group">
           <label for="salaccount" class="col-sm-4 control-label">Salary Account:</label>
           <div class="col-sm-10"> <p class="form-control-static"><s:property value="salaccount"/></p></div>
      </div>  
      <div class="form-group">
           <label for="salbankname" class="col-sm-4 control-label">Bank Name:</label>
           <div class="col-sm-10"> <p class="form-control-static"><s:property value="salbankname"/></p></div>
      </div>
      <div class="form-group">
           <label for="accountno" class="col-sm-4 control-label">Account Number:</label>
           <div class="col-sm-10"> <p class="form-control-static"><s:property value="accountno"/></p></div>
      </div> 
      <div class="form-group">
           <label for="accountname" class="col-sm-4 control-label">Account Name:</label>
           <div class="col-sm-10"> <p class="form-control-static"><s:property value="accountname"/></p></div>
      </div> 
      <div class="form-group">
           <label for="othercard" class="col-sm-4 control-label">Other Bank Card:</label>
           <div class="col-sm-10"> <p class="form-control-static"><s:property value="othercard"/></p></div>
      </div> 
      <div class="form-group">
           <label for="cardbank" class="col-sm-4 control-label">Bank Name:</label>
           <div class="col-sm-10"> <p class="form-control-static"><s:property value="cardbank"/></p></div>
      </div> 
      <div class="form-group">
           <label for="cardhold" class="col-sm-4 control-label">Other Bank Card:</label>
           <div class="col-sm-10"> <p class="form-control-static"><s:property value="cardhold"/></p></div>
      </div>
      <div class="form-group">
           <label for="cardlimit" class="col-sm-4 control-label">Card Limit:</label>
           <div class="col-sm-10"> <p class="form-control-static"><s:property value="cardlimit"/></p></div>
      </div>
      <div class="form-group">
           <label for="regdate" class="col-sm-4 control-label">Registration date:</label>
           <div class="col-sm-10"> <p class="form-control-static"><s:property value="regdate"/></p></div>
      </div>   
      </fieldset>    
   <div class="form-group">   
   <div class="col-sm-offset-2 col-sm-10">     
  <s:submit action="internalback" cssClass="btn btn-success btn-sm"  value="Back" /> </div>  </div>
  </form>   
</div></div></div></div></div>

</body>
</html>


