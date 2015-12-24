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
                <div class="panel-heading"> <strong class="">Employee Details</strong>

                </div>
                <div class="panel-body">

      <form id="form1" method="post" action="empviewback" role="form">
      <div class="form-group">
            <label for="id" class="col-sm-4 control-label">Employee id:</label>
            <div class="col-sm-10">
            <p class="form-control-static"><s:property value="%{id}"/></p>
            </div>
      </div>
      <div class="form-group">
            <label for="clientName" class="col-sm-4 control-label">Name:</label>
            <div class="col-sm-10">
        <p class="form-control-static"><s:property value="name"/></p></div>	
      </div>
      <div class="form-group">
            <label for="address" class="col-sm-4 control-label">Address:</label>
             <div class="col-sm-10"> <p class="form-control-static"><s:property value="address"  /></p></div>
      </div>
      <div class="form-group">
            <label for="phone" class="col-sm-4 control-label">Mobile:</label>
             <div class="col-sm-10"> <p class="form-control-static"><s:property value="phone"/></p></div>
      </div>
      <div class="form-group">
            <label for="email" class="col-sm-4 control-label">Email:</label>
           <div class="col-sm-10"> <p class="form-control-static"><s:property value="email"/></p></div>
      </div>
      <div class="form-group">
            <label for="salary" class="col-sm-4 control-label">Salary:</label>
           <div class="col-sm-10"> <p class="form-control-static"><s:property value="salary"  /></p></div>
      </div>
      <div class="form-group">
           <label for="dob" class="col-sm-4 control-label">Date Of Birth:</label>
           <div class="col-sm-10"> <p class="form-control-static"><s:property value="dob"/></p></div>
      </div>  
      <div class="form-group">
           <label for="doj" class="col-sm-4 control-label">Date Of Joining:</label>
           <div class="col-sm-10"> <p class="form-control-static"><s:property value="doj"/></p></div>
      </div>                
   <div class="form-group">   
   <div class="col-sm-offset-2 col-sm-10">     
  <s:submit action="empviewback" cssClass="btn btn-success btn-sm"  value="Back" /> </div>  </div>
  </form>   
</div></div></div></div></div>

</body>
</html>

