<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html>
<html>
<head>
 <jsp:include page="/common.jsp"/>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
 
<title>Registration</title>
<script type="text/javascript">
    	function go(action)
    	{
    		if(action!='')
    		{
    			$('form#form1').attr('action',action);
    		}
    		$('form#form1').submit();
    	}
    </script>
</head>
<body>
<div class="container">
            <div class="row">
             <div class="col-md-11 col-md-offset-1">
            <div class="panel panel-default">
                <div class="panel-heading"> <strong class="">Registration Form</strong>

                </div>
                <div class="panel-body">
    <form   method="post" action="signupclientregister" class="form-horizontal" id="form1" role="form" >    
    <fieldset>
    <div id="legend">
     <legend>Registration Form</legend>
    </div>
    <div class="form-group">
      <label class="control-label col-sm-2"   for="fname">First Name*</label>
      <div class="col-sm-10">
        <s:textfield name="signUpBean.fname" class="form-control" />
    </div>
    </div>
    <div class="form-group">
      <label class="control-label col-sm-2"   for="lname">Last Name*</label>
      <div class="col-sm-10">
        <s:textfield name="signUpBean.lname" class="form-control" />
    </div>
    </div>
    <div class="form-group">
      <label class="control-label col-sm-2"   for="mobile">Mobile no.*</label>
       <div class="col-sm-10">
       <s:textfield name="signUpBean.mobile"  class="form-control"/>
    </div>
    </div>
    <div class="form-group">
      <label class="control-label col-sm-2"   for="email">Username/Email*</label>
      <div class="col-sm-10">
       <s:textfield name="signUpBean.email" class="form-control"/>
    </div>
    </div>
    <div class="form-group">
      <label for="pass" class="col-sm-2 control-label">Password</label>
       <div class="col-sm-10">
      <s:password name="signUpBean.pass" class="form-control"/>
    </div>
    </div>
    <div class="form-group">
      <label for="confirmpassword" class="col-sm-2 control-label">Confirm Password</label>
       <div class="col-sm-10"> 
      <s:password name="signUpBean.confirmpassword" class="form-control"/>
      </div>
    </div>
    <div>*Fields cannot be left empty</div>
    <button type="button" class="btn btn-success" onclick="go('')">Register</button>
   	<button type="button" class="btn btn-success" onclick="go('signupclientback')">Back</button>
</fieldset>
</form>
</div>
      </div></div></div></div>
</body>
</html>
