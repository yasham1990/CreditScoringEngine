<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html>
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Admin Home Page</title>
<jsp:include page="/common.jsp"/>



<script type="text/javascript">
window.history.forward(1);
</script>
</head>
<body>

<div class="container">
<div class="row">
             <div class="col-md-5 col-md-offset-4">
            <div class="panel panel-default">
                <div class="panel-heading"> <strong class="">Application Request</strong>

                </div>
                <div class="panel-body">

      <form id="form1" method="post" action="accept" role="form">
      <div class="form-group">
            <label for="id" class="col-sm-4 control-label">Application id</label>
            <s:textfield name="appno" value="%{#session.app_no}"  readonly="true" />
      </div>
      <div class="form-group">
            <label for="clientName" class="col-sm-4 control-label">Client Name:</label>
            <div class="col-sm-10">
        <p class="form-control-static"><s:property value="name"/></p></div>	
      </div>
      <div class="form-group">
            <label for="score" class="col-sm-4 control-label">Score Generated:</label>
             <div class="col-sm-10"> <p class="form-control-static"><s:property value="score"/></p></div>
      </div>
                        
   <div class="form-group">   
   <div class="col-sm-offset-2 col-sm-10">     
  <s:submit value="accept" cssClass="btn btn-success btn-sm" /> 
  <s:submit action="reject" cssClass="btn btn-success btn-sm"  value="reject" /> </div>  </div>
  </form>   
</div></div></div></div></div>

</body>
</html>

