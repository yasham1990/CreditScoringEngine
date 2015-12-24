<!DOCTYPE html>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s" %>
<html lang="en">

<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Creative - Start Bootstrap Theme</title>

    <!-- Bootstrap Core CSS -->
    <link rel="stylesheet" href="css/bootstrap.min.css" type="text/css">

    <!-- Custom Fonts -->
    <link href='http://fonts.googleapis.com/css?family=Open+Sans:300italic,400italic,600italic,700italic,800italic,400,300,600,700,800' rel='stylesheet' type='text/css'>
    <link href='http://fonts.googleapis.com/css?family=Merriweather:400,300,300italic,400italic,700,700italic,900,900italic' rel='stylesheet' type='text/css'>
    <link rel="stylesheet" href="font-awesome/css/font-awesome.min.css" type="text/css">

    <!-- Plugin CSS -->
    <link rel="stylesheet" href="css/animate.min.css" type="text/css">

    <!-- Custom CSS -->
    <link rel="stylesheet" href="css/creative.css" type="text/css">

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->

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
                <a class="navbar-brand page-scroll" href="#page-top">Start Bootstrap</a>
            </div>

            <!-- Collect the nav links, forms, and other content for toggling -->
            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                <ul class="nav navbar-nav navbar-right">
                    <li>
                        <a class="page-scroll" href="#about">About Us</a>
                    </li>
                    <li>
                        <a class="page-scroll" href="#services">Privacy Policy</a>
                    </li>
                    <li>
                        <a class="page-scroll" href="#portfolio">Term & Conditions</a>
                    </li>
                    <li>
                        <a class="page-scroll" href="#contact">Contact Us</a>
                    </li>
                </ul>
            </div>
            <!-- /.navbar-collapse -->
        </div>
        <!-- /.container-fluid -->
    </nav>

    <header>
        <div class="header-content">
            <div class="header-content-inner">
                <h1>Your Favorite Source of Free Bootstrap Themes</h1>
                <hr>
                <p>Start Bootstrap can help you build better websites using the Bootstrap CSS framework! Just download your template and start going, no strings attached!</p>
                <a href="#about" class="btn btn-primary btn-xl page-scroll">Find Out More</a>
            </div>
        </div>
    </header>

    <section class="bg-primary" id="about">
        <div class="container">
            <div class="row">
            <form id="form1" method="post" action="loginclient">
          <fieldset>
          <legend>Sign-In</legend>
          <table>
          <tr>
            <td><s:textfield cssClass="mytextfield" name="userName" label="Username" value="" /></td>
            </tr>
            <tr>
                <td><s:password cssClass="mytextfield" name="password" label="Password" value="" /></td> 
            </tr>
          </table>
            <s:submit  value="Login" cssClass="buttonlog" />
          </fieldset></form>
            
                <div class="col-lg-8 col-lg-offset-2 text-center">
                    <h2 class="section-heading">We've got what you need!</h2>
                    <hr class="light">
                    <p class="text-faded">Start Bootstrap has everything you need to get your new website up and running in no time! All of the templates and themes on Start Bootstrap are open source, free to download, and easy to use. No strings attached!</p>
                    <a href="#" class="btn btn-default btn-xl">Get Started!</a>
                </div>
            </div>
        </div>
    </section>

    <section id="services">
        <div class="container">
            <div class="row">
                <div class="col-lg-12 text-center">
                    <h2 class="section-heading">At Your Service</h2>
                    <hr class="primary">
                </div>
            </div>
        </div>
        <div class="container">
            <div class="row">
                <div class="col-lg-3 col-md-6 text-center">
                    <div class="service-box">
                        <i class="fa fa-4x fa-diamond wow bounceIn text-primary"></i>
                        <h3>Sturdy Templates</h3>
                        <p class="text-muted">Our templates are updated regularly so they don't break.</p>
                    </div>
                </div>
                <div class="col-lg-3 col-md-6 text-center">
                    <div class="service-box">
                        <i class="fa fa-4x fa-paper-plane wow bounceIn text-primary" data-wow-delay=".1s"></i>
                        <h3>Ready to Ship</h3>
                        <p class="text-muted">You can use this theme as is, or you can make changes!</p>
                    </div>
                </div>
                <div class="col-lg-3 col-md-6 text-center">
                    <div class="service-box">
                        <i class="fa fa-4x fa-newspaper-o wow bounceIn text-primary" data-wow-delay=".2s"></i>
                        <h3>Up to Date</h3>
                        <p class="text-muted">We update dependencies to keep things fresh.</p>
                    </div>
                </div>
                <div class="col-lg-3 col-md-6 text-center">
                    <div class="service-box">
                        <i class="fa fa-4x fa-heart wow bounceIn text-primary" data-wow-delay=".3s"></i>
                        <h3>Made with Love</h3>
                        <p class="text-muted">You have to make your websites with love these days!</p>
                    </div>
                </div>
            </div>
        </div>
    </section>

    <section class="no-padding" id="portfolio">
        <div class="container-fluid">
            <div class="row no-gutter">
                <div class="col-lg-4 col-sm-6">
                    <a href="#" class="portfolio-box">
                        <img src="img/portfolio/1.jpg" class="img-responsive" alt="">
                        <div class="portfolio-box-caption">
                            <div class="portfolio-box-caption-content">
                                <div class="project-category text-faded">
                                    Category
                                </div>
                                <div class="project-name">
                                    Project Name
                                </div>
                            </div>
                        </div>
                    </a>
                </div>
                <div class="col-lg-4 col-sm-6">
                    <a href="#" class="portfolio-box">
                        <img src="img/portfolio/2.jpg" class="img-responsive" alt="">
                        <div class="portfolio-box-caption">
                            <div class="portfolio-box-caption-content">
                                <div class="project-category text-faded">
                                    Category
                                </div>
                                <div class="project-name">
                                    Project Name
                                </div>
                            </div>
                        </div>
                    </a>
                </div>
                <div class="col-lg-4 col-sm-6">
                    <a href="#" class="portfolio-box">
                        <img src="img/portfolio/3.jpg" class="img-responsive" alt="">
                        <div class="portfolio-box-caption">
                            <div class="portfolio-box-caption-content">
                                <div class="project-category text-faded">
                                    Category
                                </div>
                                <div class="project-name">
                                    Project Name
                                </div>
                            </div>
                        </div>
                    </a>
                </div>
                <div class="col-lg-4 col-sm-6">
                    <a href="#" class="portfolio-box">
                        <img src="img/portfolio/4.jpg" class="img-responsive" alt="">
                        <div class="portfolio-box-caption">
                            <div class="portfolio-box-caption-content">
                                <div class="project-category text-faded">
                                    Category
                                </div>
                                <div class="project-name">
                                    Project Name
                                </div>
                            </div>
                        </div>
                    </a>
                </div>
                <div class="col-lg-4 col-sm-6">
                    <a href="#" class="portfolio-box">
                        <img src="img/portfolio/5.jpg" class="img-responsive" alt="">
                        <div class="portfolio-box-caption">
                            <div class="portfolio-box-caption-content">
                                <div class="project-category text-faded">
                                    Category
                                </div>
                                <div class="project-name">
                                    Project Name
                                </div>
                            </div>
                        </div>
                    </a>
                </div>
                <div class="col-lg-4 col-sm-6">
                    <a href="#" class="portfolio-box">
                        <img src="img/portfolio/6.jpg" class="img-responsive" alt="">
                        <div class="portfolio-box-caption">
                            <div class="portfolio-box-caption-content">
                                <div class="project-category text-faded">
                                    Category
                                </div>
                                <div class="project-name">
                                    Project Name
                                </div>
                            </div>
                        </div>
                    </a>
                </div>
            </div>
        </div>
    </section>

    <aside class="bg-dark">
        <div class="container text-center">
            <div class="call-to-action">
                <h2>Free Download at Start Bootstrap!</h2>
                <a href="#" class="btn btn-default btn-xl wow tada">Download Now!</a>
            </div>
        </div>
    </aside>

    <section id="contact">
        <div class="container">
            <div class="row">
                <div class="col-lg-8 col-lg-offset-2 text-center">
                    <h2 class="section-heading">Let's Get In Touch!</h2>
                    <hr class="primary">
                    <p>Ready to start your next project with us? That's great! Give us a call or send us an email and we will get back to you as soon as possible!</p>
                </div>
                <div class="col-lg-4 col-lg-offset-2 text-center">
                    <i class="fa fa-phone fa-3x wow bounceIn"></i>
                    <p>123-456-6789</p>
                </div>
                <div class="col-lg-4 text-center">
                    <i class="fa fa-envelope-o fa-3x wow bounceIn" data-wow-delay=".1s"></i>
                    <p><a href="mailto:your-email@your-domain.com">feedback@startbootstrap.com</a></p>
                </div>
            </div>
        </div>
    </section>

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













<%-- <html>
<head>
<title>Home Page</title>
<meta http-equiv="content-type" content="text/html; charset=utf-8" />
<link href="/CreditScoring/homecss/default.css" rel="stylesheet" type="text/css" />
<link href="/CreditScoring/homecss/rewards.css" rel="stylesheet" type="text/css" />
<link href="/CreditScoring/homecss/cards.css" rel="stylesheet" type="text/css" />

<script type="text/javascript">
    {

        function home() {
            document.getElementById("home").style.display = 'block';
            document.getElementById("cards").style.display = 'none';
            document.getElementById("rewards").style.display = 'none';
            document.getElementById("offi").style.display = 'none';
        };
        
        function cards() {
            document.getElementById("home").style.display = 'none';
            document.getElementById("cards").style.display = 'block';
            document.getElementById("rewards").style.display = 'none';
            document.getElementById("offi").style.display = 'none';
        };
        
        function rewards() {
            document.getElementById("home").style.display = 'none';
            document.getElementById("cards").style.display = 'none';
            document.getElementById("rewards").style.display = 'block';
            document.getElementById("offi").style.display = 'none';
        };
        
        function offi() {
            document.getElementById("home").style.display = 'none';
            document.getElementById("cards").style.display = 'none';
            document.getElementById("rewards").style.display = 'none';
            document.getElementById("offi").style.display = 'block';
        };
        
        function appi() {
            document.getElementById("home").style.display = 'none';
            document.getElementById("cards").style.display = 'none';
            document.getElementById("rewards").style.display = 'none';
            document.getElementById("offi").style.display = 'none';
        }
    } 
window.history.forward(1);

</script>

</head>
<body>

<div id="header">
  <div id="logo">
    <img src="homeimages/logo.jpg" alt=""  />
     <h1>SAHARA BANK</h1> 
     <h2>Online Credit Card Offering Solution</h2>    
  </div>
  <!-- <div id="menu">
    <ul>
    
      <li><a href="#" onclick="home()" class="active">Home</a></li>
      <li><a href="#" onclick="cards()">Cards For You</a></li>
      <li><a href="#" onclick="rewards()">Rewards</a></li>
      <li><a href="#" onclick="offi()">Official Login</a></li>
  </ul></div> -->
  
</div>
<div id="content">
  <div id="sidebar">
    <div id="login" class="boxed">
      <div class="title">
        <h2>Client Account</h2>
      </div>
      <div class="content1">
        </div>
    </div>
    <!-- end #login -->
    <div id="reachus"  class="boxed">
      <div class="title">
        <h2>Reach Us</h2>
      </div>
      <div class="content1">
       <form id="form2" method="post" action="Reach">
          <fieldset>
            <table>
              <tr>
                  <td><s:textfield cssClass="mytextfield" name="myname" label="Name"  /></td>
              </tr>
              <tr>
                  <td><s:textfield  cssClass="mytextfield" name="myemail" label="Email" /></td>
              </tr>
              <tr>
               <td><s:textfield  cssClass="mytextfield" name="mytelephone" label="Mobile" /></td>
              </tr>
              <tr>
               <td><s:textarea name="message" label="Comment" rows="6" cols="20" ></s:textarea></td>
              </tr>
                      
              </table>
               <s:submit  cssClass="button" value="Submit" />
               <s:submit cssClass="button" action="clear" value="Cancel" /> 
          </fieldset>
        </form>
      </div>
     
    </div>
          <div id="reachus"  class="boxed">
      <div class="title">
        <h2>Application Status</h2>
      </div>
      <div class="content1">
       <form id="form2" method="post" action="Appstatus">
          <fieldset>
            <table>
              <tr>
                  <td><s:textfield cssClass="mytextfield" name="appid" label="App Id" /></td>
              </tr>
              </table>
               <s:submit  cssClass="buttoncheck" value="check" />
               
          </fieldset>
        </form>
      </div>
     
    </div>
    <!-- end #updates -->
  </div>
  
  <!-- end #sidebar -->
  
  <div class="main" style="display:block" id="home">
    <div class="post">
      <h2 class="title"><marquee><span> ....WELCOME TO SAHARA BANK....WE ARE HAPPY TO SERVE YOU....</span></marquee></h2>
        
      <p><img src="homeimages/bank1.jpg" alt="" width="600" height="500"  /></p>
       <p> <textarea name="infobank" id="infobank"  rows="10" cols="72" readonly >
SAHARA BANK CREDIT CARD is the most convenient and secure way to carry currency overseas and make payments to merchant outlets in any currency, anywhere in the world.
        
Worldwide acceptance:
Your SAHARA BANK CREDIT CARD is accepted at over 28 million merchant establishments around the world that display the Visa signage. Your card can be used in department stores, hotels, hospitals, restaurants, airlines, petrol pumps, paying for customs duty and even when you travel from one place to another.

Cashless convenience:
Your SAHARA BANK CREDIT CARD can be used to withdraw cash in the local currency of the country you are in. No longer queues to purchasemoney in different currencies in India for your oversea trip. And again, you don't have to run around looking for Money changers to exchange your travelers cheques in unfamiliar lands.
Locked-in exchange rates

With the SAHARA BANK CREDIT CARD, you will never have to worry about fluctuating exchange rates or unexpected fees since you lock in your exchange rate when youTotal Protect* is the first -of-its-kind security program that covers you for unauthorised transactions on your card at merchant establishments. 'Total Protect' covers you for a sum up to the limit loaded on your card (with a maximum limit of Rs. 100,000 per card). </textarea></p>

        

      
      <div class="data"></div>
    </div>
    </div>
    <!-- end #welcome -->
<div class="main" style="display:none" id="cards">
    <div class="post">
    <h2 class="title"><marquee><span> ....WELCOME TO SAHARA BANK....WE ARE HAPPY TO SERVE YOU....</span></marquee></h2>
        
      <!-- -----------cards div----------->

     
    
    <!--  --------- -->
      
        <div class="data"></div>
</div>

  </div>

   <!-- --------cards div end------------>

    <!-- -----------reward div----------->


   <!-- --------reward div end------------>

   
    <!-- -----------official div----------->
    

   <!-- --------offi div end------------>
 <!-- end #main -->

  <div style="clear: both;">&nbsp;</div>
</div>

<!-- end #content -->
<div id="templatemo_footer_wrapper">
<div id="footer">
   <p id="legal">&nbsp; </p>
  <p><a href ="home.jsp"> HOME </a>|<a href = "bottompages/Aboutus.html"> ABOUT US </a>| <a href = "bottompages/privacypolicy.html"> PRIVACY POLICY </a>|<a href ="bottompages/terms&cond.html"> TERMS CONDITIONS </a>|<a href = "bottompages/ouroffices.html"> CONTACT US </a>
  </p> 
  <p>Copyright 2012. All Rights Reserved</p></div>
</div> --%>

</body>
</html>









<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s" %>

<html>
<head>
<title>Home Page</title>
<meta http-equiv="content-type" content="text/html; charset=utf-8" />
<link href="/CreditScoring/homecss/default.css" rel="stylesheet" type="text/css" />
<link href="/CreditScoring/homecss/rewards.css" rel="stylesheet" type="text/css" />
<link href="/CreditScoring/homecss/cards.css" rel="stylesheet" type="text/css" />

<script type="text/javascript">
    {

        function home() {
            document.getElementById("home").style.display = 'block';
            document.getElementById("cards").style.display = 'none';
            document.getElementById("rewards").style.display = 'none';
            document.getElementById("offi").style.display = 'none';
        };
        
        function cards() {
            document.getElementById("home").style.display = 'none';
            document.getElementById("cards").style.display = 'block';
            document.getElementById("rewards").style.display = 'none';
            document.getElementById("offi").style.display = 'none';
        };
        
        function rewards() {
            document.getElementById("home").style.display = 'none';
            document.getElementById("cards").style.display = 'none';
            document.getElementById("rewards").style.display = 'block';
            document.getElementById("offi").style.display = 'none';
        };
        
        function offi() {
            document.getElementById("home").style.display = 'none';
            document.getElementById("cards").style.display = 'none';
            document.getElementById("rewards").style.display = 'none';
            document.getElementById("offi").style.display = 'block';
        };
        
        function appi() {
            document.getElementById("home").style.display = 'none';
            document.getElementById("cards").style.display = 'none';
            document.getElementById("rewards").style.display = 'none';
            document.getElementById("offi").style.display = 'none';
        }
    } 
window.history.forward(1);

</script>

</head>
<body>

<div id="header">
  <div id="logo">
    <img src="homeimages/logo.jpg" alt=""  />
     <h1>SAHARA BANK</h1> 
     <h2>Online Credit Card Offering Solution</h2>    
  </div>
  <div id="menu">
    <ul>
    
      <li><a href="#" onclick="home()" class="active">Home</a></li>
      <li><a href="#" onclick="cards()">Cards For You</a></li>
      <li><a href="#" onclick="rewards()">Rewards</a></li>
      <li><a href="#" onclick="offi()">Official Login</a></li>
  </ul></div>
  
</div>
<div id="content">
  <div id="sidebar">
    <div id="login" class="boxed">
      <div class="title">
        <h2>Client Account</h2>
      </div>
      <div class="content1">
        <form id="form1" method="post" action="loginclient">
          <fieldset>
          <legend>Sign-In</legend>
          <table>
          <tr>
            <td><s:textfield cssClass="mytextfield" name="userName" label="Username" value="" /></td>
            </tr>
            <tr>
                <td><s:password cssClass="mytextfield" name="password" label="Password" value="" /></td> 
            </tr>
          </table>
            <s:submit  value="Login" cssClass="buttonlog" />
          </fieldset></form></div>
    </div>
    <!-- end #login -->
    <div id="reachus"  class="boxed">
      <div class="title">
        <h2>Reach Us</h2>
      </div>
      <div class="content1">
       <form id="form2" method="post" action="Reach">
          <fieldset>
            <table>
              <tr>
                  <td><s:textfield cssClass="mytextfield" name="myname" label="Name"  /></td>
              </tr>
              <tr>
                  <td><s:textfield  cssClass="mytextfield" name="myemail" label="Email" /></td>
              </tr>
              <tr>
               <td><s:textfield  cssClass="mytextfield" name="mytelephone" label="Mobile" /></td>
              </tr>
              <tr>
               <td><s:textarea name="message" label="Comment" rows="6" cols="20" ></s:textarea></td>
              </tr>
                      
              </table>
               <s:submit  cssClass="button" value="Submit" />
               <s:submit cssClass="button" action="clear" value="Cancel" /> 
          </fieldset>
        </form>
      </div>
     
    </div>
          <div id="reachus"  class="boxed">
      <div class="title">
        <h2>Application Status</h2>
      </div>
      <div class="content1">
       <form id="form2" method="post" action="Appstatus">
          <fieldset>
            <table>
              <tr>
                  <td><s:textfield cssClass="mytextfield" name="appid" label="App Id" /></td>
              </tr>
              </table>
               <s:submit  cssClass="buttoncheck" value="check" />
               
          </fieldset>
        </form>
      </div>
     
    </div>
    <!-- end #updates -->
  </div>
  
  <!-- end #sidebar -->
  
  <div class="main" style="display:block" id="home">
    <div class="post">
      <h2 class="title"><marquee><span> ....WELCOME TO SAHARA BANK....WE ARE HAPPY TO SERVE YOU....</span></marquee></h2>
        
      <p><img src="homeimages/bank1.jpg" alt="" width="600" height="500"  /></p>
       <p> <textarea name="infobank" id="infobank"  rows="10" cols="72" readonly >
SAHARA BANK CREDIT CARD is the most convenient and secure way to carry currency overseas and make payments to merchant outlets in any currency, anywhere in the world.
        
Worldwide acceptance:
Your SAHARA BANK CREDIT CARD is accepted at over 28 million merchant establishments around the world that display the Visa signage. Your card can be used in department stores, hotels, hospitals, restaurants, airlines, petrol pumps, paying for customs duty and even when you travel from one place to another.

Cashless convenience:
Your SAHARA BANK CREDIT CARD can be used to withdraw cash in the local currency of the country you are in. No longer queues to purchasemoney in different currencies in India for your oversea trip. And again, you don't have to run around looking for Money changers to exchange your travelers cheques in unfamiliar lands.
Locked-in exchange rates

With the SAHARA BANK CREDIT CARD, you will never have to worry about fluctuating exchange rates or unexpected fees since you lock in your exchange rate when youTotal Protect* is the first -of-its-kind security program that covers you for unauthorised transactions on your card at merchant establishments. 'Total Protect' covers you for a sum up to the limit loaded on your card (with a maximum limit of Rs. 100,000 per card). </textarea></p>

        

      
      <div class="data"></div>
    </div>
    </div>
    <!-- end #welcome -->
<div class="main" style="display:none" id="cards">
    <div class="post">
    <h2 class="title"><marquee><span> ....WELCOME TO SAHARA BANK....WE ARE HAPPY TO SERVE YOU....</span></marquee></h2>
        
      <!-- -----------cards div----------->
<div id="main_content2">
<table width="600" border="0" align="center" cellpadding="0" cellspacing="0"  id="card">
  <tr>
    <td width="200"  valign="top">
     
    <div id="cd"><p><img src="cardimages/visa_electron.gif"  alt="silver" /></p></div>
   <div id="fortext"> <p><textarea name="caddress" id="caddress" cols="17" rows="20" readonly >Redeem your Reward Points for exciting gifts from our exclusive Rewards catalogue.

MyCity Benefit Program:
The My City benefit program comes with unmatched lifelong features like surcharge waiver across petrol pumps and cashback on utility bill payments.

Balance Transfer: 
You can transfer your outstanding balance on your existing Credit Card to Sahara Bank and start saving immediately.
Limit:A silver card comes with a limit of Rs.25000 per month and the interest rate on amount taken on this card is 8% .
</textarea></p></div>
   <div id="end"> <p><a href="register.jsp"><img src="cardimages/index_38.gif" alt="" width="170" height="107" border="0" /></a></p></div>
   
    </td>
    <td width="200" valign="top"  >
   
    <div id="cd"><p><img src="cardimages/visa_gold_chip.gif" alt="gold" /></p></div>
    <div id="fortext"><p> <textarea name="caddress1" id="caddress1" cols="17" rows="20" readonly >Earn 1 Reward Point for every Rs.150 for spends up to Rs. 20,000 per statement cycle. For incremental spends above Rs. 20,000 in a statement cycle, earn 50% more Reward Points i.e. 1.5 Reward Points per Rs. 150.
    
Redemption of Reward Points:
After earning all those reward points on your HDFC Bank Gold Credit Card, redeem them for exciting gifts and services! 

Accepted Worldwide:
Your Gold Credit Card is accepted at over 23 million Merchant Establishments around the world, including 110,000 in India.
Limit:A gold card comes with a limit of Rs.50000 per month and the interest rate on amount taken on this card is 5% .
    </textarea></p></div>
   <div id="end"> <p><a href="register.jsp"><img src="cardimages/index_38.gif" alt="" width="170" height="107" border="0" /></a></p></div>
    
    </td>
    <td width="200"  valign="top">
   
    <div id="cd"><p><img src="cardimages/visa_platinum.gif"  alt="platinum" /></p></div>
    <div id="fortext"><p>  
      <textarea name="caddress3" id="caddress3" cols="17" rows="20" readonly >
    
 </textarea></p></div>
   <div id="end"> <p><a href="register.jsp"><img src="cardimages/index_38.gif" alt="" width="170" height="107" border="0" /></a></p></div>
    
    
	
        </td>
  </tr>
  
</table>
</div>
     
    
    <!--  --------- -->
      
        <div class="data"></div>
</div>

  </div>

   <!-- --------cards div end------------>

    <!-- -----------reward div----------->
     <div class="main" style="display:none" id="rewards" >
    <div  class="post">
      <h1 class="title"><marquee><span> ....WELCOME TO SAHARA BANK....WE ARE HAPPY TO SERVE YOU....</span></marquee></h1>
    
     <!-- ----------------- -->
      <div id="main_content" style="overflow:scroll"> 
   <div class="center_content">
	<div class="center_title_bar">0 -- 2000 Points</div>
   	<div class="prod_box">
	<div class="top_prod_box"></div>
            <div class="center_prod_box">            
                 <div class="product_title">Parker Pens</div>
                 <div class="product_img"><img src="rewardimages/parker.jpg" alt="" title="" border="0" /></div>
                 <div class="prod_price"><span class="price">Item Code:AK001</span></div>                        
            </div>            
            <div class="prod_details_tab"> 500 Points</div>                     
        </div>
 
     	<div class="prod_box">
        	<div class="top_prod_box"></div>
            <div class="center_prod_box">            
                 <div class="product_title">Tupperware Gift Hamper</div>
                 <div class="product_img"><img src="rewardimages/tupperware.jpg" alt="" title="" border="0" /></div>
                 <div class="prod_price"><span class="price">Item Code:AK002</span></div>                        
            </div>
                         
            <div class="prod_details_tab">1000 Points</div>                     
        </div> 
 
     	<div class="prod_box">
        	<div class="top_prod_box"></div>
            <div class="center_prod_box">            
                 <div class="product_title">Titan Voucher Rs1000</div>
                 <div class="product_img"><img src="rewardimages/titan.jpg" alt="" title="" border="0" /></div>
                 <div class="prod_price"><span class="price">Item Code:AK003</span></div>                        
            </div>             
            <div class="prod_details_tab">2000 Points</div>                     
        </div>
    
    
	<div class="center_title_bar">2001---3000 Points</div>
     	<div class="prod_box">
        	<div class="top_prod_box"></div>
            <div class="center_prod_box">            
                 <div class="product_title">John Player Voucher Rs1199</div>
                 <div class="product_img"><img src="rewardimages/john.jpg" alt="" title="" border="0" /></div>
                 <div class="prod_price"><span class="price">Item Code:AK004</span></div>                        
            </div>             
            <div class="prod_details_tab">2300 Points</div>
		  </div> 
     	<div class="prod_box">
        	<div class="top_prod_box"></div>
            <div class="center_prod_box">            
                 <div class="product_title">Mobile Store Gift Hamper Rs1000</div>
                 <div class="product_img"><img src="rewardimages/mobile.jpg" alt="" title="" border="0" /></div>
                 <div class="prod_price"><span class="price">Item Code:AK005</span></div>                        
            </div>             
            <div class="prod_details_tab">2500 Points </div> 
		  </div>
			<div class="prod_box">
        	<div class="top_prod_box"></div>
            <div class="center_prod_box">            
                 <div class="product_title">Nokia Bluetooth Headset Rs1000</div>
                 <div class="product_img"><img src="rewardimages/bluetooth.jpg" alt="" title="" border="0" /></div>
                 <div class="prod_price"><span class="price">Item Code:AK006</span></div>                        
            </div>             
            <div class="prod_details_tab">3000 Points </div> 
            </div>
	
    <div class="center_title_bar">3001---4000 Points</div>
			
            <div class="prod_box">
        	<div class="top_prod_box"></div>
            <div class="center_prod_box">            
                 <div class="product_title">Hidesign Voucher Rs1500</div>
                 <div class="product_img"><img src="rewardimages/hidesign.jpg" alt="" title="" border="0" /></div>
                 <div class="prod_price"><span class="price">Item Code:AK007</span></div>                        
            </div>             
            <div class="prod_details_tab">3200 Points </div> 
            </div>
            
            <div class="prod_box">
        	<div class="top_prod_box"></div>
            <div class="center_prod_box">            
                 <div class="product_title">Sony Battery Charger</div>
                 <div class="product_img"><img src="rewardimages/charger.jpg" alt="" title="" border="0" /></div>
                 <div class="prod_price"><span class="price">Item Code:AK008</span></div>                        
            </div>             
            <div class="prod_details_tab">3500 Points </div> 
            </div>
            
            <div class="prod_box">
        	<div class="top_prod_box"></div>
            <div class="center_prod_box">            
                 <div class="product_title">Ipod 4GB</div>
                 <div class="product_img"><img src="rewardimages/ipod.jpg" alt="" title="" border="0" /></div>
                 <div class="prod_price"><span class="price">Item Code:AK009</span></div>                        
            </div>             
            <div class="prod_details_tab">4000 Points </div> 
            </div>
            
	<div class="center_title_bar">4001---5000 Points</div>

			<div class="prod_box">
        	<div class="top_prod_box"></div>
            <div class="center_prod_box">            
                 <div class="product_title">HCL Kids Learning Laptop</div>
                 <div class="product_img"><img src="rewardimages/kid.jpg" alt="" title="" border="0" /></div>
                 <div class="prod_price"><span class="price">Item Code:AK010</span></div>                        
            </div>             
            <div class="prod_details_tab">4200 Points </div>             
			</div>

			<div class="prod_box">
        	<div class="top_prod_box"></div>
            <div class="center_prod_box">            
                 <div class="product_title">Philips DVD Player</div>
                 <div class="product_img"><img src="rewardimages/dvd.jpg" alt="" title="" border="0" /></div>
                 <div class="prod_price"><span class="price">Item Code:AK011</span></div>                        
            </div>             
            <div class="prod_details_tab">4500 Points </div> 
            </div>
            
            
            <div class="prod_box">
        	<div class="top_prod_box"></div>
            <div class="center_prod_box">            
                 <div class="product_title">Sony Play Station</div>
                 <div class="product_img"><img src="rewardimages/sonyplay.jpg" alt="" title="" border="0" /></div>
                 <div class="prod_price"><span class="price">Item Code:AK012</span></div>                        
            </div>
            <div class="prod_details_tab">5000 Points </div> 
            </div>
            
	<div class="center_title_bar">5001---10000 Points</div>
            
            <div class="prod_box">
        	<div class="top_prod_box"></div>
            <div class="center_prod_box">            
                 <div class="product_title">Panasonic Camera DMC-L5</div>
                 <div class="product_img"><img src="rewardimages/panasonic.jpg" alt="" title="" border="0" /></div>
                 <div class="prod_price"><span class="price">Item Code:AK013</span></div>                        
            </div>
            <div class="prod_details_tab">6500 Points </div>
            </div>
            
            <div class="prod_box">
        	<div class="top_prod_box"></div>
            <div class="center_prod_box">            
                 <div class="product_title">Canon Power-Shot Camera A32</div>
                 <div class="product_img"><img src="rewardimages/canon.jpg" alt="" title="" border="0" /></div>
                 <div class="prod_price"><span class="price">Item Code:AK014</span></div>                        
            </div>             
            <div class="prod_details_tab">8000 Points </div>
            </div>
            
            
            <div class="prod_box">
        	<div class="top_prod_box"></div>
            <div class="center_prod_box">            
                 <div class="product_title">Sony Handy Cam Super SX-21</div>
                 <div class="product_img"><img src="rewardimages/handycam.jpg" alt="" title="" border="0" /></div>
                 <div class="prod_price"><span class="price">Item Code:AK015</span></div>                        
            </div>            
            <div class="prod_details_tab">10000 Points </div>
            </div>
            
            
	<div class="center_title_bar">More than 10000 Points</div>
            <div class="prod_box">
        	<div class="top_prod_box"></div>
            <div class="center_prod_box">            
                 <div class="product_title">Nano I-Pod 8GB</div>
                 <div class="product_img"><img src="rewardimages/nano.jpg" alt="" title="" border="0" /></div>
                 <div class="prod_price"><span class="price">Item Code:AK016</span></div>                        
            </div>    
            <div class="prod_details_tab">12000 Points </div>
            </div>
            
            <div class= "prod_box">
        	<div class="top_prod_box"></div>
            <div class="center_prod_box">            
                 <div class="product_title">Apple I-Pod 10GB</div>
                 <div class="product_img"><img src="rewardimages/apple.jpg" alt="" title="" border="0" /></div>
                 <div class="prod_price"><span class="price">Item Code:AK017</span></div>                        
            </div>             
            <div class="prod_details_tab">15000 Points </div>
            </div>
            
            <div class="prod_box">
        	<div class="top_prod_box"></div>
            <div class="center_prod_box">            
                 <div class="product_title">Mac Book Air</div>
                 <div class="product_img"><img src="rewardimages/mac.jpg" alt="" title="" border="0" /></div>
                 <div class="prod_price"><span class="price">Item Code:AK018</span></div>                        
            </div>             
            <div class="prod_details_tab">20000 Points </div>
            </div>
   </div><!-- end of center content -->
   </div>


</div>
  </div>

   <!-- --------reward div end------------>

   
    <!-- -----------official div----------->
     <div class="main" style="display:none" id="offi">
    <div  class="post">
      <h1 class="title"><marquee><span> ....WELCOME TO SAHARA BANK....WE ARE HAPPY TO SERVE YOU...</span></marquee></h1>
      <div id="main_content3">
    
   <div id="offpic">
   <img src="homeimages/offlog.png" />
   </div>
       <p> This section is for official login only.Officials like MANAGER,EMPLOYEE,ADMIN can login here. </p>
  <a href="offLogin.jsp">Click here</a>
  
  </div>
</div>
  </div>

   <!-- --------offi div end------------>
 <!-- end #main -->

  <div style="clear: both;">&nbsp;</div>
</div>

<!-- end #content -->
<div id="templatemo_footer_wrapper">
<div id="footer">
   <p id="legal">&nbsp; </p>
  <p><a href ="home.jsp"> HOME </a>|<a href = "bottompages/Aboutus.html"> ABOUT US </a>| <a href = "bottompages/privacypolicy.html"> PRIVACY POLICY </a>|<a href ="bottompages/terms&cond.html"> TERMS CONDITIONS </a>|<a href = "bottompages/ouroffices.html"> CONTACT US </a>
  </p> 
  <p>Copyright 2012. All Rights Reserved</p></div>
</div>

</body>
</html>