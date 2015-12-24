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
<%
boolean isOld=request.getAttribute( "isOld" )!=null?true:false;
String newOld=isOld?"Edit":"New";
%>
<div class="container">
<div class="row">
             <div class="col-md-5">
            <div class="panel panel-default">
                <div class="panel-heading"> <strong class=""><%=newOld %> Manager Information</strong>

                </div>
				<div class="container">
	             <div class="panel-body">
                <form id="form1" method="post" action="manupdate" role="form">
                <%if(isOld) {%>
                        <div class="form-group">
                            <label for="id" class="col-sm-2 control-label">Application ID</label>
                            <s:textfield name="adminManagerInformationBean.id" value="%{adminManagerInformationBean.id}" readonly="true" />
                        </div>
                        <%} %>
                        <div class="form-group">
                            <label for="name" class="col-sm-2 control-label">Name</label>
                            <s:textfield name="adminManagerInformationBean.name" value="%{adminManagerInformationBean.name}" />
                        </div>
                        <div class="form-group">
                            <label for="gen" class="col-sm-2 control-label">Gender</label>
                            <s:textfield name="adminManagerInformationBean.gen" value="%{adminManagerInformationBean.gen}" />
                        </div>
                        <div class="form-group">
                            <label for="address" class="col-sm-2 control-label">Address</label>
                            <s:textfield name="adminManagerInformationBean.address" value="%{adminManagerInformationBean.address}" />
                        </div>
                        <div class="form-group">
                            <label for="phone" class="col-sm-2 control-label">Phone</label>
                            <s:textfield name="adminManagerInformationBean.phone" value="%{adminManagerInformationBean.phone}" />
                        </div>
                        <div class="form-group">
                            <label for="email" class="col-sm-2 control-label">Email</label>
                            <s:textfield name="adminManagerInformationBean.email" value="%{adminManagerInformationBean.email}" />
                        </div>
                        <div class="form-group">
                            <label for="salary" class="col-sm-2 control-label">Salary</label>
                            <s:textfield name="adminManagerInformationBean.salary" value="%{adminManagerInformationBean.salary}" />
                        </div>
                        <div class="form-group">
                            <label for="dob" class="col-sm-2 control-label">Date Of Birth</label>
                            <s:textfield name="adminManagerInformationBean.dob" value="%{adminManagerInformationBean.dob}" />
                        </div>
                        <div class="form-group">
                            <label for="doj" class="col-sm-2 control-label">Date of Joining</label>
                            <s:textfield name="adminManagerInformationBean.doj" value="%{adminManagerInformationBean.doj}" />
                        </div>
                        <%if(!isOld) {%>
                        <div class="form-group">
   								<label for="type" class="col-sm-2 control-label">Employee Type</label>
                            	<s:radio name="adminManagerInformationBean.type" list="{'Manager','Employee'}" />
                        	</div>
                        <%} %>
                        <div class="form-group">   
   							<div class="col-sm-4">
   							<%if(isOld) {%>
   							<button type="button" class="btn btn-success" onclick="go('manupdate')">Update</button>
   							<%}else{ %>
   							<button type="button" class="btn btn-success" onclick="go('maninsert')">Insert</button>
   							<%} %>
   							<button type="button" class="btn btn-success" onclick="go('mandelete')">Delete</button>
   							<button type="button" class="btn btn-success" onclick="go('manback')">back</button>
   							
  						</div></div>
  </form>
            </div></div></div>
            
</div>
</div>
</div>

</body>
</html>

