<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html>
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Credit Scoring Engine</title>
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
<div class="navbar-nav navbar-inverse navbar-fixed-top">
        <div class="container">
        <div class="navbar-header">
          <a class="navbar-brand" href="index.html"> Manager Dashboard</a>
        </div> 
        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                <ul class="nav navbar-nav navbar-right">
                    <li class="page-scroll">
                        <s:url action="logoutmanager" var="welcome" />
                	<s:a href="%{welcome}" >Logout</s:a>
                    </li>
                </ul>
            </div>
        </div>
    </div>
<section>
<div class="container">
<div class="row">
             <div class="col-md-6 col-md-offset-3">
            <div class="panel panel-default">
                <div class="panel-heading"> <strong class="">Internal Information By User</strong>

                </div>
                <div class="panel-body">

      <form id="form1" method="post" action="internalback" role="form" class="form-horizontal">
      <fieldset>
	    <div id="legend">
	     <legend>Personal Details</legend>
	    </div>
      <div class="form-group">
            <label for="id" class="col-sm-4 control-label">Application Id:</label>
            <s:property value="%{#session.app_no}"/>
      </div>
      <div class="form-group">
            <label for="clientName" class="col-sm-4 control-label">First Name:</label>
        	<s:property value="fname"/>	
      </div>
      <div class="form-group">
            <label for="clientName" class="col-sm-4 control-label">Last Name:</label>
            <s:property value="lname"/>	
      </div>
      <div class="form-group">
            <label for="address" class="col-sm-4 control-label">Address:</label>
             <s:property value="address"  />
      </div>
      <div class="form-group">
            <label for="mobile" class="col-sm-4 control-label">Mobile:</label>
             <s:property value="mobile"/>
      </div>
      <div class="form-group">
            <label for="email" class="col-sm-4 control-label">Email:</label>
           <s:property value="email"/>
      </div>
      <div class="form-group">
            <label for="birth" class="col-sm-4 control-label">Date Of Birth:</label>
           <s:property value="birth"  />
      </div>
      <div class="form-group">
            <label for="status" class="col-sm-4 control-label">Maritul Status:</label>
           <s:property value="status"  />
      </div>
      <div class="form-group">
            <label for="sex" class="col-sm-4 control-label">Sex:</label>
           <s:property value="sex"  />
      </div>
      <div class="form-group">
           <label for="pan" class="col-sm-4 control-label">Pan:</label>
           <s:property value="pan"/>
      </div>  
      <div class="form-group">
           <label for="mobile" class="col-sm-4 control-label">Mobile:</label>
           <s:property value="mobile"/>
      </div>
       <div class="form-group">
           <label for="email" class="col-sm-4 control-label">Email:</label>
           <s:property value="email"/>
      </div>      
      <div class="form-group">
           <label for="annual" class="col-sm-4 control-label">Annual Salary:</label>
           <s:property value="annual"/>
      </div>   
      <div class="form-group">
           <label for="monthly" class="col-sm-4 control-label">Monthly Salary:</label>
           <s:property value="monthly"/>
      </div> 
      </fieldset>
      <fieldset>
	    <div id="legend">
	     <legend>Contact Details</legend>
	    </div>
      
      <div class="form-group">
           <label for="door" class="col-sm-4 control-label">Door No:</label>
           <s:property value="door"/>
      </div>  
      <div class="form-group">
           <label for="street" class="col-sm-4 control-label">Street:</label>
           <s:property value="street"/>
      </div>
       <div class="form-group">
           <label for="landmark" class="col-sm-4 control-label">LandMark:</label>
           <s:property value="landmark"/>
      </div>      
      <div class="form-group">
           <label for="nationality" class="col-sm-4 control-label">Nationality:</label>
           <s:property value="nationality"/>
      </div>   
      <div class="form-group">
           <label for="city" class="col-sm-4 control-label">City:</label>
           <s:property value="city"/>
      </div> 
       <div class="form-group">
           <label for="state" class="col-sm-4 control-label">State:</label>
           <s:property value="state"/>
      </div> 
       <div class="form-group">
           <label for="zip" class="col-sm-4 control-label">Zip Code:</label>
           <s:property value="zip"/>
      </div> 
      <div class="form-group">
           <label for="resino" class="col-sm-4 control-label">Resident Number:</label>
           <s:property value="resino"/>
      </div> 
      </fieldset>
      <fieldset>
	    <div id="legend">
	     <legend>Employment Details</legend>
	    </div>
      <div class="form-group">
           <label for="profession" class="col-sm-4 control-label">Profession:</label>
           <s:property value="profession"/>
      </div>       
       <div class="form-group">
           <label for="ename" class="col-sm-4 control-label">Employee Name:</label>
           <s:property value="ename"/>
      </div> 
      
      <div class="form-group">
           <label for="eid" class="col-sm-4 control-label">Employee Id:</label>
           <s:property value="eid"/>
      </div> 
      <div class="form-group">
           <label for="join" class="col-sm-4 control-label">Date Of Join:</label>
           <s:property value="join"/>
      </div>    
       <div class="form-group">
           <label for="comaddress" class="col-sm-4 control-label">Company Address:</label>
           <s:property value="comaddress"/>
      </div> 
       <div class="form-group">
           <label for="officeno" class="col-sm-4 control-label">Office No:</label>
           <s:property value="officeno"/>
      </div> 
       <div class="form-group">
           <label for="officeemail" class="col-sm-4 control-label">Official Email:</label>
           <s:property value="officeemail"/>
      </div>  
      </fieldset>
      <fieldset>
	    <div id="legend">
	     <legend>Further Details</legend>
	    </div>
      <div class="form-group">
           <label for="salaccount" class="col-sm-4 control-label">Salary Account:</label>
           <s:property value="salaccount"/>
      </div>  
      <div class="form-group">
           <label for="salbankname" class="col-sm-4 control-label">Bank Name:</label>
           <s:property value="salbankname"/>
      </div>
      <div class="form-group">
           <label for="accountno" class="col-sm-4 control-label">Account Number:</label>
           <s:property value="accountno"/>
      </div> 
      <div class="form-group">
           <label for="accountname" class="col-sm-4 control-label">Account Name:</label>
           <s:property value="accountname"/>
      </div> 
      <div class="form-group">
           <label for="othercard" class="col-sm-4 control-label">Other Bank Card:</label>
           <s:property value="othercard"/>
      </div> 
      <div class="form-group">
           <label for="cardbank" class="col-sm-4 control-label">Bank Name:</label>
           <s:property value="cardbank"/>
      </div> 
      <div class="form-group">
           <label for="cardhold" class="col-sm-4 control-label">Other Bank Card:</label>
           <s:property value="cardhold"/>
      </div>
      <div class="form-group">
           <label for="cardlimit" class="col-sm-4 control-label">Card Limit:</label>
           <s:property value="cardlimit"/>
      </div>
      <div class="form-group">
           <label for="regdate" class="col-sm-4 control-label">Registration date:</label>
           <s:property value="regdate"/>
      </div>   
      </fieldset>    
	<div class="text-center">      
  <s:submit action="internalback" cssClass="btn btn-success btn-sm"  value="Back" /> </div>
  </form>   
</div></div></div></div></div>
</section>
	<div class="navbar-nav navbar-inverse navbar-fixed-bottom">
        <div class="container">
        <div class="nav">
        <ul class="nav navbar-nav navbar-right">
                    <li class="page-scroll">
          <a href="index.html"> Company Logo</a></li></ul>
        </div> 
        </div>
    </div>
</body>
</html>


