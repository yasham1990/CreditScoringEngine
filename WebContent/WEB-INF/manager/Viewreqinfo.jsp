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
                <div class="panel-heading"> <strong class="">Information</strong>

                </div>
                <div class="panel-body">

                <form id="form1" method="post" action="Clickmeback" role="form" class="form-horizontal">
                        <div class="form-group">
                            <s:url action="manager/internalinfo" var="welc"/><s:a href="%{welc}">Internal info</s:a>
                        </div>
                         <div class="form-group">
                             <s:url action="manager/externalinfo" var="welc"/><s:a href="%{welc}">External info</s:a>
                        </div>
                         <div class="form-group">
                            <s:url action="manager/Generate" var="welc"/><s:a href="%{welc}">Generate Score</s:a>
                        </div>
                       <div class="text-center">
   							<button type="button" class="btn btn-success" onclick="go('Clickmeback')">Back</button>
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
