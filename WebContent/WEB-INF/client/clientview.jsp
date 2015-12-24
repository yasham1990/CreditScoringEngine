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
    		$('form#form1').attr('action',action);
    		$('form#form1').submit();
    	}
    </script>
</head>
<body>

<div class="container">
<div class="row">
             <div class="col-md-5 col-md-offset-4">
            <div class="panel panel-default">
                <div class="panel-heading"> <strong class="">Client Details</strong>

                </div>
                <div class="panel-body">

      <form id="form1" method="post" action="clientviewupdate" role="form">
      <div class="form-group">
            <label for="fname" class="col-sm-5 control-label">First Name:</label>
            <s:textfield name="registerBean.fname" value="%{fname}"/>
      </div>
      <div class="form-group">
            <label for="lname" class="col-sm-5 control-label">Last Name:</label>
            <s:textfield name="registerBean.lname" value="%{lname}"/>
      </div>
      <%-- <div class="form-group">
            <label for="name" class="col-sm-5 control-label">Last Name:</label>
            <div class="col-sm-10"><p class="form-control-static"><s:property value="lname"/></p></div>
      </div> --%>
      <div class="form-group">
            <label for="mobile" class="col-sm-5 control-label">Mobile No:</label>
              <s:textfield name="registerBean.mobile" value="%{mobile}"/>
      </div>
      <div class="form-group">
            <label for="email" class="col-sm-5 control-label">Email:</label>
           <s:textfield name="registerBean.email" value="%{email}"/>
      </div>
      <div class="form-group">
            <label for="cardtype" class="col-sm-5 control-label">Application:</label>
           <div class="col-sm-10"> <p class="form-control-static"><s:property value="app_no"  /></p></div>
      </div>
        <div class="form-group">   
   							<div class="col-sm-4">
   							<button type="button" class="btn btn-success" onclick="go('clientviewupdate')">Update</button>
   							<button type="button" class="btn btn-success" onclick="go('clientviewback')">Back</button>
  						</div>
  						</div>                 
  </form>   
</div></div></div></div></div>

</body>
</html>

