<!DOCTYPE html>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s" %>
<%@ taglib prefix="sb" uri="/struts-bootstrap-tags" %>
<html lang="en">

<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

   <title>Credit Scoring Engine</title>

    <jsp:include page="/common.jsp"/>	
<script type="text/javascript">
		function go(action,formId)
		{
			var formIdSelector="form#"+formId;
			$(formIdSelector).attr('action',action);
			$(formIdSelector).submit();
		}
    	function openUrl()
    	{
    		window.location="register.jsp";
    	}
    </script>
</head>

<body id="page-top">

    <nav id="mainNav" class="navbar navbar-default navbar-fixed-top">
        <div class="container-fluid">
            <!-- Brand and toggle get grouped for better mobile display -->
            <div class="navbar-header">
                <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand page-scroll" href="#page-top">Credit Scoring Engine</a>
            </div>

            <!-- Collect the nav links, forms, and other content for toggling -->
            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                <ul class="nav navbar-nav navbar-right">
                    <li>
                        <a class="page-scroll" href="#about">Login</a>
                    </li>
                    <li>
                    <s:url action="signupclient" var="wel"  /> 
		                <s:a href="%{wel}" disabled="true">Sign Up</s:a>
                    </li>
                    <li>
                        <a class="page-scroll" href="#policy">Policy</a>
                    </li>
                    <li>
                        <a class="page-scroll" href="#terms">Terms & Conditions</a>
                    </li>
                    <!-- <li>
                        <a class="page-scroll" href="#contact">Reach Us</a>
                    </li> -->
                </ul>
            </div>
            <!-- /.navbar-collapse -->
        </div>
        <!-- /.container-fluid -->
    </nav>

    <header>
        <div class="header-content">
            <div class="header-content-inner">
                <p>SAHARA BANK CREDIT CARD is the most convenient and secure 
                way to carry currency overseas and make payments to merchant outlets in any currency, anywhere in the world.
        		Worldwide acceptance:
        		Your SAHARA BANK CREDIT CARD is accepted at over 28 million merchant establishments around the world that 
        		display the Visa signage. Your card can be used in department stores, hotels, hospitals, restaurants, airlines, 
        		petrol pumps, paying for customs duty and even when you travel from one place to another.
        		Cashless convenience:
        		Your SAHARA BANK CREDIT CARD can be used to withdraw cash in the local currency of the country you are in. 
        		No longer queues to purchasemoney in different currencies in India for your oversea trip. 
        		And again, you don't have to run around looking for Money changers to exchange your 
        		travelers cheques in unfamiliar lands.
        		Locked-in exchange rates
        		With the SAHARA BANK CREDIT CARD, you will never have to worry about fluctuating exchange rates or unexpected 
        		fees since you lock in your exchange rate when youTotal Protect* is the first -of-its-kind security program that 
        		covers you for unauthorised transactions on your card at merchant establishments. 'Total Protect' covers you for a 
        		sum up to the limit loaded on your card (with a maximum limit of Rs. 100,000 per card). 
				</p>
            </div>
        </div>
    </header>




    <section id="about">
        <div class="container">
	            <div class="row">
	             <div class="col-md-6 col-md-offset-3">
	            <div class="panel panel-default">
	                <div class="panel-heading"> <strong class="">Official Login</strong>
	
	                </div>
	                <div class="panel-body">
                	<form id="form1" method="post" action="loginclient" role="form" class="form-horizontal">
                	<fieldset>
                        <div class="form-group">
                            <label for="userName" class="col-sm-2 control-label">Username</label>
                            <div class="col-sm-10">
                            <s:textfield name="userName" value="" class="form-control"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="pass1" class="col-sm-2 control-label">Password</label>
                            <div class="col-sm-10">
                            <s:password name="pass1" value="" class="form-control"/>
                            </div>
                        </div>
                        <div class="form-group">
  						<label class="control-label col-sm-4"   for=""></label>
  						<div class="col-sm-10">
                            <s:radio name="official" list="{'Admin','Manager','Employee','Clients'}" />
                            </div>
                        </div>
		                <div class="text-right">
		                <button type="button" class="btn btn-success" onclick="go('loginclient','form1')">Login</button>
		                </div>
		                </fieldset>
  </form>
            </div></div></div>
            
</div>
</div>
</section>
<section id="policy">
        <div class="container">
            <div class="row">
                <div class="col-lg-12 text-center">
                    <h2 class="section-heading">Policy</h2>
                    <p class="text-muted">
                    SAHARACPSL respects the privacy rights and interests of each person and will observe the following 
                    principles when processing sensitive / personal data:
                    To further ensure enforcement of these Standards, Privacy Leader in consultation with the appropriate 
                    Legal Counsel, Regulatory Officer and Compliance officer will identify Provider and Employment Data procedures 
                    that should be audited on periodic basis.
                    SAHARACPSL respects the privacy rights and interests of each person and will observe the following 
                    principles when processing sensitive / personal data:
                    To further ensure enforcement of these Standards, Privacy Leader in consultation with the appropriate 
                    Legal Counsel, Regulatory Officer and Compliance officer will identify Provider and Employment Data procedures 
                    that should be audited on periodic basis.
                     SAHARACPSL respects the privacy rights and interests of each person and will observe the following 
                    principles when processing sensitive / personal data:
                    To further ensure enforcement of these Standards, Privacy Leader in consultation with the appropriate 
                    Legal Counsel, Regulatory Officer and Compliance officer will identify Provider and Employment Data procedures 
                    that should be audited on periodic basis.
                    SAHARACPSL respects the privacy rights and interests of each person and will observe the following 
                    principles when processing sensitive / personal data:
                    To further ensure enforcement of these Standards, Privacy Leader in consultation with the appropriate 
                    Legal Counsel, Regulatory Officer and Compliance officer will identify Provider and Employment Data procedures 
                    that should be audited on periodic basis.
						</p>
                </div>
            </div>
        </div>
       
    </section>
    
    <section id="terms">
        <div class="container">
            <div class="row">
                <div class="col-lg-12 text-center">
                    <h2 class="section-heading">Terms & Condition</h2>
                    <p class="text-muted">
                    SAHARACPSL respects the privacy rights and interests of each person and will observe the following 
                    principles when processing sensitive / personal data:
                    To further ensure enforcement of these Standards, Privacy Leader in consultation with the appropriate 
                    Legal Counsel, Regulatory Officer and Compliance officer will identify Provider and Employment Data procedures 
                    that should be audited on periodic basis.
                    SAHARACPSL respects the privacy rights and interests of each person and will observe the following 
                    principles when processing sensitive / personal data:
                    To further ensure enforcement of these Standards, Privacy Leader in consultation with the appropriate 
                    Legal Counsel, Regulatory Officer and Compliance officer will identify Provider and Employment Data procedures 
                    that should be audited on periodic basis.
                     SAHARACPSL respects the privacy rights and interests of each person and will observe the following 
                    principles when processing sensitive / personal data:
                    To further ensure enforcement of these Standards, Privacy Leader in consultation with the appropriate 
                    Legal Counsel, Regulatory Officer and Compliance officer will identify Provider and Employment Data procedures 
                    that should be audited on periodic basis.
                    SAHARACPSL respects the privacy rights and interests of each person and will observe the following 
                    principles when processing sensitive / personal data:
                    To further ensure enforcement of these Standards, Privacy Leader in consultation with the appropriate 
                    Legal Counsel, Regulatory Officer and Compliance officer will identify Provider and Employment Data procedures 
                    that should be audited on periodic basis.
                    </p>
                </div>
            </div>
        </div>
        
    </section>

   <%--  <section id="contact">
        <div class="container">
            <div class="row">
                <div class="col-lg-8 col-lg-offset-2 text-center">
                    <h2 class="section-heading">Let's Get In Touch!</h2>
                </div>
                </div>
                 <div class="row col-md-6 col-md-offset-3">
            <div class="panel panel-default">
                <div class="panel-heading"> <strong class="">Contact Form</strong>

                </div>
                <div class="panel-body">
   
                <form id="form2" method="post" action="Reach" class="form-horizontal">
                
                 		
                    </form>
            </div>
		</div>

            </div>
        </div>
    </section> --%>

    <!-- jQuery -->
    <script src="js/jquery.js"></script>

    <!-- Bootstrap Core JavaScript -->
    <script src="js/bootstrap.min.js"></script>

    <!-- Plugin JavaScript -->
    <script src="js/jquery.easing.min.js"></script>
    <script src="js/jquery.fittext.js"></script>
    <script src="js/wow.min.js"></script>

    <!-- Custom Theme JavaScript -->
    <script src="js/creative.js"></script>

</body>

</html>

