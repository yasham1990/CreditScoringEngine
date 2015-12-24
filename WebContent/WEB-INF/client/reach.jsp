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
    		$('form#form1').attr('action',action);
    		$('form#form1').submit();
    	}
    </script>
</head>
<body>
<div class="navbar-nav navbar-inverse navbar-fixed-top">
        <div class="container">
        <div class="navbar-header">
          <a class="navbar-brand" href="index.html">User Dashboard</a>
        </div> 
        
        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                <ul class="nav navbar-nav navbar-right">
                    <li class="page-scroll">
                        <s:url action="logoutclient" var="welcome" />
                	<s:a href="%{welcome}" >Logout</s:a>
                    </li>
                </ul>
            </div>
        </div>
    </div>
<section>


<div class="container">
            <div class="row">
             <div class="col-md-11 col-md-offset-1">
            <div class="panel panel-default">
                <div class="panel-heading"> <strong class="">Contact Form</strong>

                </div>
                <div class="panel-body">
    <form   method="post" action="reach" class="form-horizontal" id="form1" role="form" >    
    <fieldset>
    <div id="legend">
     <legend>Reach Out Form</legend>
    </div>
   <div class="form-group">
      <label class="control-label col-sm-2"   for="myname">Name</label>
      <div class="col-sm-10">
        <s:textfield name="myname" class="form-control" />
    </div>
    </div>
    <div class="form-group">
      <label class="control-label col-sm-2"   for="myemail">Email</label>
      <div class="col-sm-10">
        <s:textfield  name="myemail" class="form-control" />
    </div>
    </div>
    <div class="form-group">
      <label class="control-label col-sm-2"   for="mytelephone">Mobile</label>
       <div class="col-sm-10">
       <s:textfield name="mytelephone" class="form-control"/>
    </div>
    </div>
    <div class="form-group">
      <label class="control-label col-sm-2"   for="message">Comment</label>
      <div class="col-sm-10">
       <s:textarea name="message" rows="6" cols="20" class="form-control"/>
    </div>
    </div>

    <div>*Fields cannot be left empty</div>
    <div class="text-center">
    <button type="button" class="btn btn-success" onclick="go('reach')">Next</button>
   	<button type="button" class="btn btn-success" onclick="go('clear')">Cancel</button>
   	</div>
  </fieldset>

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

