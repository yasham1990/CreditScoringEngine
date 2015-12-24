<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html>
<html>
<head>
 <jsp:include page="/common.jsp"/>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Credit Scoring Engine</title>
<script type="text/javascript">
    	function go(action)
    	{
    		if(action!='')
    		{
    			$('form#form1').attr('action',action);
    		}
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
                <div class="panel-heading"> <strong class="">Registration Form</strong>

                </div>
                <div class="panel-body">
    <form   method="post" action="register" class="form-horizontal" id="form1" role="form" >    
    <fieldset>
    <div id="legend">
     <legend>Personal Details</legend>
    </div>
   <div class="form-group">
      <label class="control-label col-sm-2"   for="fname">First Name*</label>
      <div class="col-sm-10">
        <s:textfield name="registerBean.fname"  value="%{fname}"  readonly="true" class="form-control" />
    </div>
    </div>
    <div class="form-group">
      <label class="control-label col-sm-2"   for="lname">Last Name*</label>
      <div class="col-sm-10">
        <s:textfield name="registerBean.lname" value="%{lname}" readonly="true" class="form-control" />
    </div>
    </div>
    <div class="form-group">
      <label class="control-label col-sm-2"   for="mobile">Mobile no.*</label>
       <div class="col-sm-10">
       <s:textfield name="registerBean.mobile" value="%{mobile}" readonly="true" class="form-control"/>
    </div>
    </div>
    <div class="form-group">
      <label class="control-label col-sm-2"   for="email">Email*</label>
      <div class="col-sm-10">
       <s:textfield name="registerBean.email" value="%{email}" readonly="true" class="form-control"/>
    </div>
    </div>
    <div class="form-group">
      <label class="control-label col-sm-2"  for="username">Salutation*</label>
      <div class="col-sm-10">
       <s:select  name="registerBean.salu" class="form-control" value="%{registerBean.salu}" headerValue="select" headerKey="" list= "# {'Mr.':'Mr.','Ms.':'Ms.'}"/>
    </div>
    </div>
    <div class="form-group">
      <label class="control-label col-sm-2"   for="dob">Date of Birth*(mm/dd/yyyy)</label>
      <div class="col-sm-10">
       <s:textfield name="registerBean.dob" value="%{registerBean.dob}" class="form-control"  />
    </div>
    </div>
    <div class="form-group">
      <label class="control-label col-sm-2"   for="status">Marital Status*</label>
       <div class="col-sm-10">
       <s:radio name="registerBean.status" list="{'Married','Unmarried'}" value="%{registerBean.status}" />
    </div>
    </div>
    <div class="form-group">
      <label class="control-label col-sm-2"   for="sex">Sex*</label>
      <div class="col-sm-10">
       <s:radio name="registerBean.sex" list="{'Male','Female'}" value="%{registerBean.sex}" />
    </div>
    </div>
    <div class="form-group">
      <label class="control-label col-sm-2"   for="username">PAN*</label>
      <div class="col-sm-10">
       <s:textfield name="registerBean.pan" value="%{registerBean.pan}" class="form-control" />
    </div>
    </div>
    <div class="form-group">
      <label class="control-label col-sm-2"  for="annualinc">Gross Annual Income*</label>
       <div class="col-sm-10">
       <s:textfield name="registerBean.annualinc" value="%{registerBean.annualinc}" class="form-control"/>
    </div></div>
     <div class="form-group">
      <label class="control-label col-sm-2"  for="monthlyinc">Monthly Income*</label>
       <div class="col-sm-10">
       <s:textfield name="registerBean.monthlyinc" value="%{registerBean.monthlyinc}" class="form-control" />
      </div>
      </div>
  </fieldset>

      <fieldset class="row2">
  <div id="legend"><legend>Contact Details</legend></div>
  
  <div class="form-group">
      <label class="control-label col-sm-2"   for="door">Door No.*</label>
      <div class="col-sm-10">
        <s:textfield name="registerBean.door" value="%{registerBean.door}" class="form-control"/>
        </div>
    </div>
    <div class="form-group">
      <label class="control-label col-sm-2"   for="street">Street</label>
      <div class="col-sm-10">
       <s:textfield name="registerBean.street" value="%{registerBean.street}" class="form-control"/>
    </div>
    </div>
    <div class="form-group">
      <label class="control-label col-sm-2"   for="lmark">Landmark*</label>
      <div class="col-sm-10">
        <s:textfield name="registerBean.lmark" value="%{registerBean.lmark}"  class="form-control"/>
    </div>
    </div>
    <div class="form-group">
      <label class="control-label col-sm-2"  for="country">Nationality*</label>
      <div class="col-sm-10">
        <s:select headerKey="" headerValue="-Select-" name="registerBean.country" list="# {'India':'India','Other':'Other'}"  class="form-control"/>
    </div>
    </div>
    <div class="form-group">
      <label class="control-label col-sm-2"   for="city">City*</label>
      <div class="col-sm-10">
       <s:select name="registerBean.city" headerKey=""  class="form-control" headerValue="select-city"  list="# {'Abohar':'Abohar','Ajmer':'Ajmer','Agra':'Agra',
              'Allahabad':'Allahabad','Aligarh':'Aligarh','Ahmedabad':'Ahmedabad','Amritsar':'Amritsar','Ambala':'Ambala','Aurangabad':'Aurangabad','Baddi':'Baddi',
              'Ballabgarh':'Ballabgarh','Bangalore':'Bangalore','Bareilly':'Bareilly','Bhagalpur':'Bhagalpur','Bhathinda':'Bhathinda','Bhilai':'Bhilai',
              'Bhopal':'Bhopal','Bhubaneshwar':'Bhubaneshwar','Bhuj':'Bhuj','Bijnore':'Bijnore','Bilaspur':'Bilaspur','Chandigarh':'Chandigarh',
              'Chennai':'Chennai','Coimbatore':'Coimbatore','Cuttack':'Cuttack','Dadri':'Dadri','Daman':'Daman and Diu','Darjeeling':'Darjeeling','Dehradun':'Dehradun',
              'Durgapur':'Durgapur','Faridabad':'Faridabad','Ferozpur':'Ferozpur','Firozabad':'Firozabad','Gangtok':'Gangtok','Ghandinagar':'Ghandinagar','Ghaziabad':'Ghaziabad',
              'Gwalior':'Gwalior','Gorakhpur':'Gorakhpur','Gurgaon':'Gurgaon','Guwahati':'Guwahati','Haldwani':'Haldwani','Haldia':'Haldia','Haridwar':'Haridwar',
              'Hazira':'Hazira','Hissar':'Hissar','Hoshiarpur':'Hoshiarpur','Howrah':'Howrah','Hyderabad':'Hyderabad','Imphal':'Imphal','Indore':'Indore',
              'Jabalpur':'Jabalpur','Jaipur':'Jaipur','Jalandhar':'Jalandhar','Jammu':'Jammu','Jamnagar':'Jamnagar','Jamshedpur':'Jamshedpur',
              'Jhansi':'Jhansi','Jodhpur':'Jodhpur','Kanpur':'Kanpur','Karnal':'Karnal','Kharagpur':'Kharagpur','Kolhapur':'Kolhapur','Kolkata':'Kolkata',
              'Kochi':'Kochi','Kota':'Kota','Kurnool':'Kurnool','Lucknow':'Lucknow','Ludhiana':'Ludhiana','Madurai':'Madurai','Manipal':'Manipal',
              'Mathura':'Mathura','Meerut':'Meerut','Mirzapur':'Mirzapur','Moradabad':'Moradabad','Mumbai':'Mumbai','Muzaffarnagar':'Muzaffarnagar',
              'Mysore':'Mysore','Nagpur':'Nagpur','Nainital':'Nainital','Nashik':'Nashik','Noida':'Noida','New Delhi':'New Delhi','Nizamabad':'Nizamabad',
              'Ooty':'Ooty','Patiala':'Patiala','Panchkula':'Panchkula','Panipat':'Panipat','Pathankot':'Pathankot','Patna':'Patna',
              'Pondicherry':'Pondicherry','Port Blair':'Port Blair','Pune':'Pune','Raigarh':'Raigarh','Raipur':'Raipur','Rajkot':'Rajkot',
              'Ranchi':'Ranchi','Raniganj':'Raniganj','Rewa':'Rewa','Rishikesh':'Rishikesh','Roorkee':'Roorkee','Rourkela':'Rourkela',
              'Secunderabad':'Secunderabad','Shahjahanpur':'Shahjahanpur','Shillong':'Shillong','Shimla':'Shimla','Silchar':'Silchar','Srinagar':'Srinagar',
              'Surat':'Surat','Thane':'Thane','Thiruvananthapuram':'Thiruvananthapuram','Tirunelveli':'Tirunelveli','Tirupati':'Tirupati','Tiruvalla':'Tiruvalla',
              'Udaipur':'Udaipur','Ujjain':'Ujjain','Vijayawada':'Vijayawada','Vishakapatnam':'Vishakapatnam','Vasco':'Vasco','Vadodara':'Vadodara',
              'Varanasi':'Varanasi','Virudhunagar':'Virudhunagar','Varindavan':'Varindavan','Warangal':'Warangal','Yamunanagar':'Yamunanagar'}"/>
    </div>
    </div>
    <div class="form-group">
      <label class="control-label col-sm-2"   for="state">State*</label>
      <div class="col-sm-10">
       <s:select name="registerBean.state" headerKey="" headerValue="select-state"  class="form-control"
                  list="# {'Arunachal Pradesh':'Arunachal Pradesh','Assam':'Assam','Andhra Pradesh':'Andhra Pradesh','Andaman & Nicobar':'Andaman & Nicobar',
                  'Bihar':'Bihar','Chandigarh':'Chandigarh','Chhatisgarh':'Chhatisgarh','Delhi':'Delhi','Daman & Diu':'Daman & Diu',
                  'Nagar Haveli':'Nagar Haveli','Gujarat':'Gujarat','Goa':'Goa','Himachal Pradesh':'Himachal Pradesh','Haryana':'Haryana',
                  'Jammu & Kashmir':'Jammu & Kashmir','Jharkhand':'Jharkhand','Karnataka':'Karnataka',
                  'Kerala':'Kerala','Lakshadweep':'Lakshadweep','Manipur':'Manipur','Mizoram':'Mizoram','Meghalaya':'Meghalaya','Madhya Pradesh':'Madhya Pradesh',
                  'Maharashtra':'Maharashtra','Nagaland':'Nagaland',
                  'Orissa':'Orissa','Punjab':'Punjab','Pondicherry':'Pondicherry','Rajasthan':'Rajasthan','Sikkim':'Sikkim','Tripura':'Tripura',
                  'Tamil Nadu':'Tamil Nadu','Uttaranchal':'Uttaranchal','Uttar Pradesh':'Uttar Pradesh','West Bengal':'West Bengal'}"/>
    </div>
    </div>
    <div class="form-group">
      <label class="control-label col-sm-2"   for="zip">Zip *</label>
      <div class="col-sm-10">
       <s:textfield  class="form-control" value="%{registerBean.zip}" name="registerBean.zip"/>
    </div>
    </div>
    <div class="form-group">
      <label class="control-label col-sm-2"   for="resi">Residence No.</label>
      <div class="col-sm-10">
       <s:textfield  class="form-control" value="%{registerBean.resi}" name="registerBean.resi"/>
    </div>
    </div>
    <div>*Fields cannot be left empty</div>
    <div class="text-center">
    <button type="button" class="btn btn-success" onclick="go('')">Next</button>
   	<button type="button" class="btn btn-success" onclick="go('regisback')">Back</button>
   	</div>
  </fieldset>

</form>
</div>
      </div></div></div></div>
      </section>
</body>
</html>
