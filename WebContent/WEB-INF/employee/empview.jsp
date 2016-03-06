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
          <a class="navbar-brand" href="index.html"> Employee Dashboard</a>
        </div> 
        
        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                <ul class="nav navbar-nav navbar-right">
                    <li class="page-scroll">
                        <s:url action="logoutemp" var="welcome" />
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
                <div class="panel-heading"> <strong class="">Employee Details</strong>

                </div>
                <div class="panel-body">

      <form id="form1" method="post" action="empviewback" role="form" class="form-horizontal">
      <div class="form-group">
            <label for="id" class="col-sm-4 control-label">Employee id:</label>
            <s:property value="%{id}"/>
      </div>
      <div class="form-group">
            <label for="clientName" class="col-sm-4 control-label">Name:</label>
            <s:property value="name"/>	
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
            <label for="salary" class="col-sm-4 control-label">Salary:</label>
           <s:property value="salary"  />
      </div>
      <div class="form-group">
           <label for="dob" class="col-sm-4 control-label">Date Of Birth:</label>
           <s:property value="dob"/>
      </div>  
      <div class="form-group">
           <label for="doj" class="col-sm-4 control-label">Date Of Joining:</label>
           <s:property value="doj"/>
      </div>                
      <div class="text-center">
   							<button type="button" class="btn btn-success" onclick="go('empviewback')">Back</button>
   							</div>
  </form>   
</div></div></div></div></div></section>
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

