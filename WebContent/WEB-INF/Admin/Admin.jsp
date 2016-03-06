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
<div class="navbar-nav navbar-inverse navbar-fixed-top">
        <div class="container">
        <div class="navbar-header">
          <a class="navbar-brand" href="index.html"> Admin Dashboard</a>
        </div> 
        
        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                <ul class="nav navbar-nav navbar-right">
                    <li class="page-scroll">
                        <s:url action="logoutmanager" var="welcome" />
                	<s:a href="%{welcome}" >Logout</s:a>
                    </li>
                </ul>
            </div>
        </div>
    </div>

<%-- Welcome   <s:property value="namedis"/> --%>
<section>
    <section class="no-padding" id="portfolio">
        <div class="container-fluid">
            <div class="row no-gutter">
            <div class="col-lg-4 col-sm-6">
                <s:url action="adminpassview" var="welcome" />
                <s:a href="%{welcome}" class="portfolio-box">
	                        <img src="img/portfolio/13.png" class="img-responsive" alt="">
                        <div class="portfolio-box-caption">
                            <div class="portfolio-box-caption-content">
                                <div class="project-category text-faded">
                                    Change Password
                                </div>
                                <div class="project-name">
                                    Change Profile Password.
                                </div>
                            </div>
                        </div>
                    </s:a>
                </div>
                <div class="col-lg-4 col-sm-6">
                <s:url action="bankinfo" var="welc1"/>
                <s:a href="%{welc1}" class="portfolio-box">
                        <img src="img/portfolio/13.png" class="img-responsive" alt="">
                        <div class="portfolio-box-caption">
                            <div class="portfolio-box-caption-content">
                                <div class="project-category text-faded">
                                    Bank Information
                                </div>
                                <div class="project-name">
                                    View Information Regarding Bank Here
                                </div>
                            </div>
                        </div>
                    </s:a>
                </div>
                <div class="col-lg-4 col-sm-6">
                <s:url action="managephoto" var="welc"/>
				<s:a href="%{welc}" class="portfolio-box">
                        <img src="img/portfolio/13.png" class="img-responsive" alt="">
                        <div class="portfolio-box-caption">
                            <div class="portfolio-box-caption-content">
                                <div class="project-category text-faded">
                                    Employee Information
                                </div>
                                <div class="project-name">
                                    Update Employee Information
                                </div>
                            </div>
                        </div>
                    </s:a>
                </div>
                <div class="col-lg-4 col-sm-6">
                <s:url action="admininsert" var="welc" />
				 <s:a href="%{welc}" class="portfolio-box">
                        <img src="img/portfolio/13.png" class="img-responsive" alt="">
                        <div class="portfolio-box-caption">
                            <div class="portfolio-box-caption-content">
                                <div class="project-category text-faded">
                                    Add Employee
                                </div>
                                <div class="project-name">
                                    Add new Bank Employee Information 
                                </div>
                            </div>
                        </div>
                    </s:a>
                </div>
                <div class="col-lg-4 col-sm-6">
                <s:url action="adminapprovephoto" var="welc"  /> 
                <s:a href="%{welc}" disabled="true" class="portfolio-box">
                        <img src="img/portfolio/13.png" class="img-responsive" alt="">
                        <div class="portfolio-box-caption">
                            <div class="portfolio-box-caption-content">
                                <div class="project-category text-faded">
                                    Applications Approval
                                </div>
                                <div class="project-name">
                                    Accept/Reject Application
                                </div>
                            </div>
                        </div>
                    </s:a>
                </div>
                <div class="col-lg-4 col-sm-6">
                <s:url action="logoutmanager" var="welcome" />
                	<s:a href="%{welcome}" class="portfolio-box" >
                        <img src="img/portfolio/13.png" class="img-responsive" alt="">
                        <div class="portfolio-box-caption">
                            <div class="portfolio-box-caption-content">
                                <div class="project-category text-faded">
                                    Logout
                                </div>
                                <div class="project-name">
                                    Logout From Profile
                                </div>
                            </div>
                        </div>
                    </s:a>
                </div>
            </div>
        </div>
    </section></section>
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
