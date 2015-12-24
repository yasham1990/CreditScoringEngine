<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html>
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Admin Home Page</title>
<jsp:include page="/common.jsp"/>
</head>
<body>
<div class="container">
<%-- <div class="navbar-nav navbar-inverse navbar-fixed-top">
        <div class="container">
        <div class="navbar-header">
          <a class="navbar-brand" href="index.html"> User Dashboard</a>
        </div> 
        
        <%-- <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                <ul class="nav navbar-nav navbar-right">
                    <li class="page-scroll">
                        <s:url action="logoutclient" var="welcome" />
                	<s:a href="%{welcome}" >Logout</s:a>
                    </li>
                </ul>
            </div>
        </div>
    </div> --%>
    <section class="no-padding" id="portfolio">
			<div class="progress">
			  				<div class="progress-bar progress-bar-striped active" role="progressbar"
			  								aria-valuenow="40" aria-valuemin="0" aria-valuemax="100" style="width:40%">
			    									40%
			 				</div>
			</div>
             <div class="col-md-5">
                	<form id="form1" method="post" action="applicationStatusBack" role="form">
                        <div class="form-group">   
      						<s:submit cssClass="btn btn-success btn-sm" value="Back" />
  						</div>
  					</form>
			</div>
</section>
</div>
</body>
</html>
