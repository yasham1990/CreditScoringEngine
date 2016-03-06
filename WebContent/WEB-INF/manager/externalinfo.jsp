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
                <div class="panel-heading"> <strong class="">Employment Details</strong>

                </div>
                <div class="panel-body">

      <form id="form1" method="post" action="externalback" role="form" class="form-horizontal">
      <div class="form-group">
            <label for="id" class="col-sm-4 control-label">Application No. id:</label>
            <s:property value="appno"/>
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
            <label for="phone" class="col-sm-4 control-label">Mobile:</label>
             <s:property value="phone"/>
      </div>
      <div class="form-group">
            <label for="email" class="col-sm-4 control-label">Email:</label>
           <s:property value="email"/>
      </div>
      <div class="form-group">
            <label for="member" class="col-sm-4 control-label">Family Members:</label>
           <s:property value="member"  />
      </div>
      <div class="form-group">
           <label for="area" class="col-sm-4 control-label">House Area:</label>
           <s:property value="area"/>
      </div>  
      <div class="form-group">
           <label for="hloan" class="col-sm-4 control-label">House Loan:</label>
           <s:property value="hloan"/>
      </div>   
      <div class="form-group">
           <label for="hpaid" class="col-sm-4 control-label">House Loan Paid:</label>
           <s:property value="hpaid"/>
      </div>   
      <div class="form-group">
           <label for="billpay" class="col-sm-4 control-label">Bill Pay:</label>
           <s:property value="billpay"/>
      </div> 
      <div class="form-group">
           <label for="cars" class="col-sm-4 control-label">No. Of Cars Pay:</label>
           <s:property value="cars"/>
      </div>       
       <div class="form-group">
           <label for="cloan" class="col-sm-4 control-label">Car Loan:</label>
           <s:property value="cloan"/>
      </div> 
      
      <div class="form-group">
           <label for="cpaid" class="col-sm-4 control-label">Car Loan Pay:</label>
           <s:property value="cpaid"/>
      </div> 
      <div class="form-group">
           <label for="income" class="col-sm-4 control-label">Net Income:</label>
           <s:property value="income"/>
      </div>    
       <div class="form-group">
           <label for="nfd" class="col-sm-4 control-label">No Of Fds:</label>
           <s:property value="nfd"/>
      </div> 
       <div class="form-group">
           <label for="fdamount" class="col-sm-4 control-label">Net Fds Amount:</label>
           <s:property value="fdamount"/>
      </div> 
       <div class="form-group">
           <label for="agland" class="col-sm-4 control-label">Agriculture Land Value:</label>
           <s:property value="agland"/>
      </div>  
      <div class="form-group">
           <label for="lic" class="col-sm-4 control-label">Lic:</label>
           <s:property value="lic"/>
      </div>  
      <div class="form-group">
           <label for="bankdefault" class="col-sm-4 control-label">Bank Defaults:</label>
           <s:property value="bankdefault"/>
      </div>
      <div class="form-group">
           <label for="tax" class="col-sm-4 control-label">Tax Defaults:</label>
           <s:property value="tax"/>
      </div> 
      <div class="form-group">
           <label for="crime" class="col-sm-4 control-label">Crime Commited:</label>
           <s:property value="crime"/>
      </div> 
      <div class="form-group">
           <label for="otherinc" class="col-sm-4 control-label">Other Income Source:</label>
           <s:property value="otherinc"/>
      </div>
      <div class="form-group">
           <label for="otherbankcard" class="col-sm-4 control-label">Other Bank Card:</label>
           <s:property value="otherbankcard"/>
      </div>     
      <div class="text-center">  
      <button type="button" class="btn btn-success" onclick="go('externalback')">Back</button>
  </div>
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

