<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html>
<html>
<head>
 <jsp:include page="/common.jsp"/>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
 
<title>Registration</title>
<script type="text/javascript">
    	function go(action)
    	{
    		if(action!='')
    		{
    			$('form#form1').attr('action',action);
    		}
    		$('form#form1').submit();
    	}
    </script>
</head>
<body>
<div class="container">
            <div class="row">
             <div class="col-md-11 col-md-offset-1">
            <div class="panel panel-default">
                <div class="panel-heading"> <strong class="">EXTERNAL VERIFICATON</strong>

                </div>
                <div class="panel-body">
    <form   method="post" action="forward" class="form-horizontal" id="form1" role="form" >    
    <fieldset>
    <div id="legend">
     <legend>Personal Details</legend>
    </div>
   <div class="form-group">
      <label class="control-label col-sm-2"   for="id">Application No</label>
      <div class="col-sm-10">
      	<s:textfield name="employeeVerificationBean.id" value= "%{#session.app_no}" readonly="true" class="form-control"/>
    </div>
    </div>
    <div class="form-group">
      <label class="control-label col-sm-2"   for="fname">First Name*</label>
      <div class="col-sm-10">
        <s:textfield name="employeeVerificationBean.fname" class="form-control" />
    </div>
    </div>
    <div class="form-group">
      <label class="control-label col-sm-2"   for="lname">Last Name*</label>
      <div class="col-sm-10">
        <s:textfield name="employeeVerificationBean.lname" class="form-control" />
    </div>
    </div>
    <div class="form-group">
      <label class="control-label col-sm-2"   for="mob">Mobile no.*</label>
       <div class="col-sm-10">
       <s:textfield name="employeeVerificationBean.mob" class="form-control"/>
    </div>
    </div>
    <div class="form-group">
      <label class="control-label col-sm-2"   for="email">Email*</label>
      <div class="col-sm-10">
       <s:textfield name="employeeVerificationBean.email" class="form-control"/>
    </div>
    </div>
    
    <div class="form-group">
      <label class="control-label col-sm-2"   for="members">Family Members</label>
      <div class="col-sm-10">
       <s:textfield name="employeeVerificationBean.members" class="form-control"/>
    </div>
    </div>
    <div class="form-group">
      <label class="control-label col-sm-2"   for="harea">House Area</label>
      <div class="col-sm-10">
       <s:textfield name="employeeVerificationBean.harea" class="form-control"/>
    </div>
    </div>
    <div class="form-group">
      <label class="control-label col-sm-2"   for="hloan">House Loan</label>
       <div class="col-sm-10">
       <s:radio name="employeeVerificationBean.hloan" list="{'Yes','No'}" value="%{employeeVerificationBean.hloan}" />
    </div>
    </div>
    <div class="form-group">
      <label class="control-label col-sm-2"   for="hinstal">Installments Paid</label>
       <div class="col-sm-10">
       <s:radio name="employeeVerificationBean.hinstal" list="{'Regular','Irregular','NotAvailable'}" value="%{employeeVerificationBean.hinstal}" />
    </div>
    </div>
    <div class="form-group">
      <label class="control-label col-sm-2"   for="bill">Bill Payments</label>
       <div class="col-sm-10">
       <s:radio name="employeeVerificationBean.bill" list="{'OnTime','Late'}" value="%{employeeVerificationBean.bill}" />
    </div>
    </div>
    <div class="form-group">
      <label class="control-label col-sm-2"  for="cars">Cars Own</label>
      <div class="col-sm-10">
      <s:textfield name="employeeVerificationBean.cars" class="form-control"/>
    </div>
    </div>
    <div class="form-group">
      <label class="control-label col-sm-2"   for="carloan">Car Loan</label>
       <div class="col-sm-10">
       <s:radio name="employeeVerificationBean.carloan" list="{'Yes','No'}" value="%{employeeVerificationBean.carloan}" />
    </div>
    </div>
	<div class="form-group">
      <label class="control-label col-sm-2"   for="cinstal">Installments Paid</label>
       <div class="col-sm-10">
       <s:radio name="employeeVerificationBean.cinstal" list="{'Regular','Irregular','NotAvailable'}" value="%{employeeVerificationBean.cinstal}" />
    </div>
    </div>
    <div class="form-group">
      <label class="control-label col-sm-2"  for="inc">Monthly Income</label>
      <div class="col-sm-10">
      <s:textfield name="employeeVerificationBean.inc" class="form-control"/>
    </div>
    </div>
    <div class="form-group">
      <label class="control-label col-sm-2"  for="fd">Fixed Deposit</label>
      <div class="col-sm-10">
      <s:textfield name="employeeVerificationBean.fd" class="form-control"/>
    </div>
    </div>
    <div class="form-group">
      <label class="control-label col-sm-2"  for="netfd">Net FD Amount</label>
      <div class="col-sm-10">
      <s:textfield name="employeeVerificationBean.netfd" class="form-control"/>
    </div>
    </div>
    <div class="form-group">
      <label class="control-label col-sm-2"  for="agland">Agricultural Land</label>
      <div class="col-sm-10">
      <s:textfield name="employeeVerificationBean.agland" class="form-control"/>
    </div>
    </div>
    <div class="form-group">
      <label class="control-label col-sm-2"  for="lic">Life Insurance Policy</label>
      <div class="col-sm-10">
      <s:textfield name="employeeVerificationBean.lic" class="form-control"/>
    </div>
    </div>
    <div class="form-group">
      <label class="control-label col-sm-2"  for="bdflt">Bank Default</label>
      <div class="col-sm-10">
      <s:textfield name="employeeVerificationBean.bdflt" class="form-control"/>
    </div>
    </div>
    <div class="form-group">
      <label class="control-label col-sm-2"  for="tax">Tax Default</label>
      <div class="col-sm-10">
      <s:textfield name="employeeVerificationBean.tax" class="form-control"/>
    </div>
    </div>
    <div class="form-group">
      <label class="control-label col-sm-2"   for="crime">Criminal Record</label>
       <div class="col-sm-10">
       <s:radio name="employeeVerificationBean.crime" list="{'Yes','No'}" value="%{employeeVerificationBean.crime}" />
    </div>
    </div>
    <div class="form-group">
      <label class="control-label col-sm-2"   for="othinc">Other Income Source</label>
       <div class="col-sm-10">
       <s:radio name="employeeVerificationBean.othinc" list="{'Yes','No'}" value="%{employeeVerificationBean.othinc}" />
    </div>
    </div>
    <div class="form-group">
      <label class="control-label col-sm-2"   for="othcard">Other Bank Card</label>
       <div class="col-sm-10">
       <s:radio name="employeeVerificationBean.othcard" list="{'Yes','No'}" value="%{employeeVerificationBean.othcard}" />
    </div>
    </div>
    <div>*Fields cannot be left empty</div>
    <button type="button" class="btn btn-success" onclick="go('forward')">Forward</button>
   	<button type="button" class="btn btn-success" onclick="go('extverifyback')">Back</button>
  </fieldset>
</form>
</div>
      </div></div></div></div>
</body>
</html>

