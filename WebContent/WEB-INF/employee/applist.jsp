<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html>
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Credit Scoring Engine</title>
<jsp:include page="/common.jsp"/>
<script type="text/javascript">
function go(action,id)
{
	if(action!='')
	{
		$('form#form1').attr('action',action);
	}
	$('#idField').val(id);
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
             <div class="col-md-5 col-md-offset-4">
            <div class="panel panel-default">
                <div class="panel-heading"> <strong class="">Application Request</strong>

                </div>
                <div class="panel-body">

                <form id="form1" method="post" action="extveri" role="form" class="form-horizontal">
					   	<s:hidden name="id" id="idField"></s:hidden>
		                <s:iterator value="h1" >
		                	<div class="list-group">
							  <a href="javascript:void(0);" onclick="go('','<s:property/>')" class="list-group-item active">
							    <p class="list-group-item-text"><s:property/></p>
							  </a>
							</div>
							</s:iterator>
                        <div class="text-center">
					   		<button type="button" class="btn btn-success" onclick="go('applistback')">Back</button>   
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
