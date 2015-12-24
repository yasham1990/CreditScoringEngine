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

<div class="container">
<div class="row">
             <div class="col-md-5 col-md-offset-4">
            <div class="panel panel-default">
                <div class="panel-heading"> <strong class="">Information</strong>

                </div>
                <div class="panel-body">

                <form id="form1" method="post" action="Clickmeback" role="form">
                        <div class="form-group">
                            <s:url action="manager/internalinfo" var="welc"/><s:a href="%{welc}">Internal info</s:a>
                        </div>
                         <div class="form-group">
                             <s:url action="manager/externalinfo" var="welc"/><s:a href="%{welc}">External info</s:a>
                        </div>
                         <div class="form-group">
                            <s:url action="manager/Generate" var="welc"/><s:a href="%{welc}">Generate Score</s:a>
                        </div>
                       
                        <div class="form-group">   
   							<div class="col-sm-4">
   							<button type="button" class="btn btn-success" onclick="go('Clickmeback')">Back</button>
   							</div>
   							</div>
  </form>   
</div></div></div></div></div>

</body>
</html>
