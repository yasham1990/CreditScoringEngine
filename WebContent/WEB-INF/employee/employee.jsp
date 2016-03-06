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
          <a class="navbar-brand" href="index.html"> Employee Dashboard</a>
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
<%-- Welcome   <s:property value="namedis"/> --%>
    <section class="no-padding" id="portfolio">
        <div class="container-fluid">
            <div class="row no-gutter">
            
                <div class="col-lg-4 col-sm-6">
                <s:url action="passview" var="welcome" />
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
                <s:url action="employview" var="hi"  /> 
                <s:a href="%{hi}" disabled="true" class="portfolio-box">
                        <img src="img/portfolio/13.png" class="img-responsive" alt="">
                        <div class="portfolio-box-caption">
                            <div class="portfolio-box-caption-content">
                                <div class="project-category text-faded">
                                    View
                                </div>
                                <div class="project-name">
                                    Check your general profile information
                                </div>
                            </div>
                        </div>
                    </s:a>
                </div>
                <div class="col-lg-4 col-sm-6">
                <s:url action="applist" var="welc" />
				 <s:a href="%{welc}" class="portfolio-box">
                        <img src="img/portfolio/13.png" class="img-responsive" alt="">
                        <div class="portfolio-box-caption">
                            <div class="portfolio-box-caption-content">
                                <div class="project-category text-faded">
                                    Application List For Approval
                                </div>
                                <div class="project-name">
                                    Pending Application
                                </div>
                            </div>
                        </div>
                    </s:a>
                </div>
                <div class="col-lg-4 col-sm-6">
                <s:url action="employview" var="hi"  /> 
                <s:a href="%{hi}" disabled="true" class="portfolio-box">
                        <img src="img/portfolio/13.png" class="img-responsive" alt="">
                        <div class="portfolio-box-caption">
                            <div class="portfolio-box-caption-content">
                                <div class="project-category text-faded">
                                    Client Information
                                </div>
                                <div class="project-name">
                                    Check Client information
                                </div>
                            </div>
                        </div>
                    </s:a>
                </div>
                <div class="col-lg-4 col-sm-6">
                <s:url action="employview" var="hi"  /> 
                <s:a href="%{hi}" disabled="true" class="portfolio-box">
                        <img src="img/portfolio/13.png" class="img-responsive" alt="">
                        <div class="portfolio-box-caption">
                            <div class="portfolio-box-caption-content">
                                <div class="project-category text-faded">
                                    Client Queries
                                </div>
                                <div class="project-name">
                                    View client queries and doubts
                                </div>
                            </div>
                        </div>
                    </s:a>
                </div>
                <div class="col-lg-4 col-sm-6">
                <s:url action="logoutemp" var="welcome" />
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
    </section>
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
