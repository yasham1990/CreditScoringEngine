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
<%
boolean isOld=request.getAttribute( "isOld" )!=null?true:false;
String newOld=isOld?"Edit":"New";
%>
<div class="container">
<div class="row">
             <div class="col-md-7 col-md-offset-3">
            <div class="panel panel-default">
                <div class="panel-heading"> <strong class=""><%=newOld %> Employee Details</strong>

                </div>
	             <div class="panel-body">
                <form id="form1" method="post" action="manupdate" role="form" class="form-horizontal">
                <fieldset>
                <%if(isOld) {%>
                        <div class="form-group">
                            <label for="id" class="col-sm-2 control-label">Application ID</label>
                            <div class="col-sm-10">
                            <s:textfield class="form-control"  name="adminManagerInformationBean.id" value="%{adminManagerInformationBean.id}" readonly="true" />
                            </div>
                        </div>
                        <%} %>
                        <div class="form-group">
                            <label for="name" class="col-sm-2 control-label">Name*</label>
                            <div class="col-sm-10">
                            <s:textfield class="form-control"  name="adminManagerInformationBean.name" value="%{adminManagerInformationBean.name}" />
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="gen" class="col-sm-2 control-label">Gender</label>
                            <div class="col-sm-10">
                            <s:textfield class="form-control"  name="adminManagerInformationBean.gen" value="%{adminManagerInformationBean.gen}" />
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="address" class="col-sm-2 control-label">Address</label>
                            <div class="col-sm-10">
                            <s:textfield class="form-control"  name="adminManagerInformationBean.address" value="%{adminManagerInformationBean.address}" />
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="phone" class="col-sm-2 control-label">Mobile*</label>
                            <div class="col-sm-10">
                            <s:textfield class="form-control"  name="adminManagerInformationBean.phone" value="%{adminManagerInformationBean.phone}" />
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="email" class="col-sm-2 control-label">Email*</label>
                            <div class="col-sm-10">
                            <s:textfield class="form-control"  name="adminManagerInformationBean.email" value="%{adminManagerInformationBean.email}" />
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="salary" class="col-sm-2 control-label">Salary*</label>
                            <div class="col-sm-10">
                            <s:textfield class="form-control"  name="adminManagerInformationBean.salary" value="%{adminManagerInformationBean.salary}" />
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="dob" class="col-sm-2 control-label">Date Of Birth*</label>
                            <div class="col-sm-10">
                            <s:textfield class="form-control"  name="adminManagerInformationBean.dob" value="%{adminManagerInformationBean.dob}" />
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="doj" class="col-sm-2 control-label">Date of Joining</label>
                            <div class="col-sm-10">
                            <s:textfield class="form-control"  name="adminManagerInformationBean.doj" value="%{adminManagerInformationBean.doj}" />
                            </div>
                        </div>
                        <%if(!isOld) {%>
                        <div class="form-group">
   								<label for="type" class="col-sm-2 control-label">Employee Type</label>
   								<div class="col-sm-10">
                            	<s:radio name="adminManagerInformationBean.type" list="{'Manager','Employee'}" />
                            	</div>
                        	</div>
                        <%} %>
                        <div class="text-center">
   							<%if(isOld) {%>
   							<button type="button" class="btn btn-success" onclick="go('manupdate')">Update</button>
   							<button type="button" class="btn btn-success" onclick="go('mandelete')">Delete</button>
   							<%}else{ %>
   							<button type="button" class="btn btn-success" onclick="go('maninsert')">Insert</button>
   							<%} %>
   							<button type="button" class="btn btn-success" onclick="go('manback')">back</button>
   							</div>
   							</fieldset>
   							
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

