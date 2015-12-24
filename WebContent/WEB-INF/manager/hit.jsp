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
                <div class="panel-heading"> <strong class="">Calculated Scores</strong>

                </div>
                <div class="panel-body">
      <form id="form1" method="post" action="Datatoadmin" role="form" class="form-horizontal">
      <div class="form-group">
            <label for="id" class="col-sm-4 control-label">Application No. id:</label>
            <s:property value="%{#session.app_no}"/>
      </div>
      <div class="form-group">
            <label for="income1" class="col-sm-4 control-label">Income:</label>
        <s:property value="income1"/>	
      </div>
      <div class="form-group">
            <label for="taxpay" class="col-sm-4 control-label">Tax Default:</label>
        <s:property value="taxpay"/>	
      </div>
      <div class="form-group">
            <label for="billpay" class="col-sm-4 control-label">Bill Pay On Time:</label>
             <s:property value="billpay"  />
      </div>
      <div class="form-group">
            <label for="otherbank" class="col-sm-4 control-label">Other Bank Cards:</label>
             <s:property value="otherbank"/>
      </div>
      <div class="form-group">
            <label for="nfd" class="col-sm-4 control-label">No. Of Fds:</label>
           <s:property value="nfd"/>
      </div>
      <div class="form-group">
            <label for="bankdefault" class="col-sm-4 control-label">Bank Default:</label>
           <s:property value="bankdefault"  />
      </div>
      <div class="form-group">
           <label for="loanpaidhome" class="col-sm-4 control-label">House Loan Paid On Time:</label>
           <s:property value="loanpaidhome"/>
      </div>   
      <div class="form-group">
           <label for="loanpaidcar" class="col-sm-4 control-label">Car Loan:</label>
           <s:property value="loanpaidcar"/>
      </div>   
      <div class="form-group">
           <label for="criminalrecord" class="col-sm-4 control-label">Criminal Record:</label>
           <s:property value="criminalrecord"/>
      </div> 
      <div class="form-group">
           <label for="lic" class="col-sm-4 control-label">No.of Lic:</label>
           <s:property value="lic"/>
      </div>       
      <div class="form-group">
           <label for="aggland" class="col-sm-4 control-label">Agricultural Land:</label>
           <s:property value="aggland"/>
      </div>       
      <div class="form-group">
           <label for="otherinc" class="col-sm-4 control-label">OtherIncome:</label>
           <s:property value="otherinc"/>
      </div>
      <div class="form-group">
           <label for="otherinc" class="col-sm-4 control-label">Total Score Acheived:</label>
           <s:property value="totscore"/>
      </div>
      <div>*Scores Information For Acceptance</div>         
      <div class="form-group">
      <label for="otherinc" class="col-sm-4 control-label">Min Score:</label>60
      </div>
      <div class="form-group">
      <label for="otherinc" class="col-sm-4 control-label">Silver:</label>60
      </div>
      <div class="form-group">
      <label for="otherinc" class="col-sm-4 control-label">Gold:</label>80
      </div>
      <div class="form-group">
      <label for="otherinc" class="col-sm-4 control-label">Platinum:</label>92
      </div>
      <div class="text-center">  
   	<button type="button" class="btn btn-success" onclick="go('Datatoadmin')">Forward</button>
   	<button type="button" class="btn btn-success" onclick="go('generateback')">Back</button>    
   	</div>
  </form>   
</div></div></div></div></div>
</section>

</body>
</html>
