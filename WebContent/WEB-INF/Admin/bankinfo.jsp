<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html>
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Admin Home Page</title>
<jsp:include page="/common.jsp"/>



<script type="text/javascript">
window.history.forward(1);
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
             <div class="col-md-5 col-md-offset-4">
            <div class="panel panel-default">
                <div class="panel-heading"> <strong class="">Application Request</strong>

                </div>
                <div class="panel-body">

      <form id="form1" method="post" action="bankinfoback" role="form">
      
      <div class="form-group">
            <label for="clientName" class="col-sm-4 control-label">Total Cards:</label>
            <div class="col-sm-10">
        <p class="form-control-static"><s:property value="totalcards"/></p></div>	
      </div>
      <div class="form-group">
            <label for="clientName" class="col-sm-4 control-label">No. Of Employees:</label>
           <div class="col-sm-10"> <p class="form-control-static"><s:property value="employee"/></p></div>
      </div>
      
      <div class="form-group">
            <label for="clientName" class="col-sm-4 control-label">Date Of Start:</label>
           <div class="col-sm-10"> <p class="form-control-static"><s:property value="dos"/></p></div>
      </div>
                       
   <div class="form-group">   
   <div class="col-sm-offset-2 col-sm-10">     
  <s:submit value="back" cssClass="btn btn-success btn-sm" /> 
  </div>
  </div>
  </form>   
</div></div></div></div></div></section>

</body>
</html>

