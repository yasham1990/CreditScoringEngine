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
                <div class="panel-heading"> <strong class="">Change Password</strong>

                </div>
				<div class="container">
				 <!-- <legend>Change Password</legend>
     <p class="pass">Password(minimum length 6 characters) must contain one digit,one lowercase character,one uppercase character and special symbol(@#$%)</p> -->
	           
	                <div class="panel-body">
                	<form method="post" action="emppassword" role="form" id="form1">
                        <div class="form-group">
                            <label for="id" class="col-sm-2 control-label">Employee Id</label>
							<s:textfield name="id" value="%{id}" readonly="true"/>
                        </div>
                        <div class="form-group">
                            <label for="name" class="col-sm-2 control-label">Old Password</label>
                            <s:password name="oldpassword"/>
                        </div>
                        <div class="form-group">
                            <label for="gen" class="col-sm-2 control-label">New Password</label>
                            <s:password name="password"/>
                        </div>
                        <div class="form-group">
                            <label for="address" class="col-sm-2 control-label">Confirm Password</label>
                            <s:password name="confirmpassword"/>
                        </div>
                        <div class="form-group">   
   							<div class="col-sm-4">
   							<button type="button" class="btn btn-success" onclick="go('emppassword')">Reset</button>
   							<button type="button" class="btn btn-success" onclick="go('passback')">Back</button>
   							<%-- <s:submit value="Reset" cssClass="btn btn-success btn-sm"  />
      						<s:submit cssClass="btn btn-success btn-sm" value="Back" action="clientpasschangeback" /> --%>
  						</div>
  						</div>
  </form>
            </div></div></div>
            
</div>
</div>
</div>
</body>
</html>
 