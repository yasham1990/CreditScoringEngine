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
<div class="navbar-nav navbar-inverse navbar-fixed-top">
        <div class="container">
        <div class="navbar-header">
          <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <a class="navbar-brand" href="index.html"> Admin Dashboard</a>
        </div> 
         <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                <ul class="nav navbar-nav navbar-right">
                    <li class="page-scroll">
                        <s:url action="logoutadmin" var="welcome" />
                	<s:a href="%{welcome}" >Logout</s:a>
                    </li>
                </ul>
            </div>
        </div>
    </div>
    <section>
<div class="container">
<div class="row">
             <div class="col-sm-6 col-md-offset-3">
            <div class="panel panel-default">
            <div class="panel-heading"> 
            <strong class="">Bank Information</strong>
                </div>
                <div class="panel-body">

      <form id="form1" method="post" action="bankinfoback" role="form" class="form-horizontal">
      
      <div class="form-group">
            <label for="clientName" class="col-sm-4 control-label">Total Cards:</label>
        <s:property value="totalcards"/></div>	
      <div class="form-group">
            <label for="clientName" class="col-sm-4 control-label">No. Of Employees:</label>
           <s:property value="employee"/>
      </div>
      <div class="form-group">
            <label for="clientName" class="col-sm-4 control-label">Date Of Start:</label>
           <s:property value="dos"/>
      </div>
                       <div class="text-center">
   							<button type="button" class="btn btn-success" onclick="go('bankinfoback')">Back</button>
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

