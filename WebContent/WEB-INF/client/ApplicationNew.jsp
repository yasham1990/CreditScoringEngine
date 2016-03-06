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
             <div class="col-md-6 col-md-offset-3">
            <div class="panel panel-default">
                <div class="panel-heading"> <strong class="">New Application</strong>

                </div>
	                <div class="panel-body">
                	<form id="form1" method="post" action="registerClick" role="form" class="form-horizontal">
                        <div class="text-center">
                        <%boolean alreadyFiled=request.getAttribute( "filed" )!=null && !"".equals( request.getAttribute( "filed" ) ) ?true:false;
                        if(alreadyFiled){
                        %>
                        <div>You have already started the application. Please check the status of your application from application status tab.</div>
                        <button type="button" class="btn btn-success" onclick="go('registerClickNewBack')">Back</button>
      						<%}else{ %>
      						<button type="button" class="btn btn-success" onclick="go('registerClick')">Click Here To Apply</button>
   							<button type="button" class="btn btn-success" onclick="go('registerClickNewBack')">Back</button>
   							<%} %>
  						</div>
  </form>
            </div></div></div>
            
</div>
</div>
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
