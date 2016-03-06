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
          <a class="navbar-brand" href="index.html">User Dashboard</a>
        </div> 
        
        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                <ul class="nav navbar-nav navbar-right">
                    <li class="page-scroll">
                        <s:url action="logoutclient" var="welcome" />
                	<s:a href="%{welcome}" >Logout</s:a>
                    </li>
                </ul>
            </div>
        </div>
    </div>
<section>
<div class="container">

<div class="row">
             <div class="col-md-8 col-md-offset-3">
            <div class="panel panel-default">
                <div class="panel-heading"> <strong class="">Application Status</strong>

                </div>
                <div class="panel-body">
      <form id="form1" method="post" action="applicationStatusBack" role="form" class="form-horizontal">
			<%boolean alreadyFiled=request.getAttribute( "filed" )!=null && !"".equals( request.getAttribute( "filed" ) )?true:false;
                        if(alreadyFiled){
                        %>
      <div class="form-group">
            <label for="id" class="col-sm-4 control-label">Status</label>
            <s:property value="status"/>
      </div>
      <div class="form-group">
            <label for="clientName" class="col-sm-4 control-label">Current Level:</label>
            <s:property value="level"/>	
      </div>
      <div class="progress">
			  				<div class="progress-bar progress-bar-striped active" role="progressbar"
			  								aria-valuenow="<s:property value="percentage"/>" aria-valuemin="0" aria-valuemax="100" style="width:<s:property value="percentage"/>%">
			    									<s:property value="percentage"/>%
			 				</div>
			</div>
			<%}else{ %>
			<div>You have not started the application. Please click new application tab to start the application from your dashboard.</div>
      						<%} %>
      <div class="text-center">
   							<button type="button" class="btn btn-success" onclick="go('applicationStatusBack')">Back</button>
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
