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
          <a class="navbar-brand" href="index.html"> Admin Dashboard</a>
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
                <div class="panel-heading"> <strong class="">Change Password</strong>

                </div>
				 <div>
     			Password(minimum length 6 characters) must contain one digit,one 
     			lowercase character,one uppercase character and special symbol(@#$%)
	           </div>
	                <div class="panel-body">
                	<form method="post" action="adminpassword" role="form" id="form1" class="form-horizontal">
                        <div class="form-group">
                            <label for="id" class="col-sm-4 control-label">Employee Id</label>
							<s:textfield name="id" value="%{id}" readonly="true"/>
                        </div>
                        <div class="form-group">
                            <label for="name" class="col-sm-4 control-label">Old Password</label>
                            <s:password name="oldpassword"/>
                        </div>
                        <div class="form-group">
                            <label for="gen" class="col-sm-4 control-label">New Password</label>
                            <s:password name="password"/>
                        </div>
                        <div class="form-group">
                            <label for="address" class="col-sm-4 control-label">Confirm Password</label>
                            <s:password name="confirmpassword"/>
                        </div>
                       <div class="text-center">
   							<button type="button" class="btn btn-success" onclick="go('adminpassword')">Reset</button>
   							<button type="button" class="btn btn-success" onclick="go('adminpasswordback')">Back</button>
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
 