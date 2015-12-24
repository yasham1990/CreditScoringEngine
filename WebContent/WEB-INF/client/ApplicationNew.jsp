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
             <div class="col-md-5">
            <div class="panel panel-default">
                <div class="panel-heading"> <strong class="">New Application</strong>

                </div>
				<div class="container">
				 <!-- <legend>Change Password</legend>
     <p class="pass">Password(minimum length 6 characters) must contain one digit,one lowercase character,one uppercase character and special symbol(@#$%)</p> -->
	           
	                <div class="panel-body">
                	<form id="form1" method="post" action="registerClick" role="form">
                        <div class="form-group">   
   							<div class="col-sm-4">
      						<button type="button" class="btn btn-success" onclick="go('registerClick')">Click Here To Apply</button>
   							<button type="button" class="btn btn-success" onclick="go('registerClickNewBack')">Back</button>
  						</div>
  						</div>
  </form>
            </div></div></div>
            
</div>
</div>
</div>
</body>
</html>
