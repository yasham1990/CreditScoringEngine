
<%@page contentType="text/html" pageEncoding="UTF-8"%>
 <%@taglib uri="/struts-tags" prefix="s" %>
<html>
<head>
<jsp:include page="/common.jsp" />
  <script type="text/javascript"> 
  function go(action)
	{
		//action='hello';
		$('form#form1').attr('action',action);
		
		//alert($('form#form1').attr('action'));
		$('form#form1').submit();
	}
        function enable(message){
            var dis=message;
            if(message=="no")
            {
                document.getElementById("bn1").disabled=false;
                document.getElementById("chn").disabled=false;
                document.getElementById("cl").disabled=false;
            }
           if(message=="yes")
            {
                document.getElementById("bn1").disabled=true;
                document.getElementById("chn").disabled=true;
                document.getElementById("cl").disabled=true;
            }
              if(message=="y")
                  {
                      document.getElementById("salbkname").disabled=false;
                    document.getElementById("acc").disabled=false;
                    document.getElementById("accname").disabled=false;
                  }
                   if(message=="n")
                  {
                      document.getElementById("salbkname").disabled=true;
                    document.getElementById("acc").disabled=true;
                    document.getElementById("accname").disabled=true;
                  }
        }
       
window.history.forward(1);

        </script>

<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
 <link rel="stylesheet" type="text/css" href="/CreditScoring/homecss/register1.css"/>
<title>Registration</title>
</head>
<body>
      
  
      <!-- <fieldset class="row3">
          <legend>Any Other Bank Card Detail(If Owned,Please Enter Details)</legend>
      <p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Other Bank Card*:&nbsp;&nbsp;&nbsp;&nbsp;</p>
    <tr><td>*Fields cannot be left empty</td></tr>
    </table> -->
     
    <div class="container">
            <div class="row">
             <div class="col-md-11 col-md-offset-1">
            <div class="panel panel-default">
                <div class="panel-heading"> <strong class="">Registration Form -2</strong>

                </div>
                <div class="panel-body">
    <form method="post" action="register1" id="form1" class="form-horizontal" role="form"> 
    <fieldset>
    <div id="legend">
     <legend>Employment Details</legend>
    </div>
    <div class="form-group">
      <label class="control-label col-sm-2" class="control-label col-sm-2" for="prof">Profession *</label>
      <div class="col-sm-10">
        <s:select headerKey="" headerValue="-Select Profession-" name="registerBean.prof" class="form-control"
        list="# {'Salaried':'Salaried','Self Employed':'Self Employed','Student':'Student','Retire/Pensioner':'Retire/Pensioner'}"/>
        </div>
    </div>
    <div class="form-group">
      <label class="control-label col-sm-2"  for="empName">Employee Name *</label>
      <div class="col-sm-10">
       <s:textfield name="registerBean.empName" class="form-control" value=""/>
    </div>
    </div>
    <div class="form-group">
      <label class="control-label col-sm-2"   for="empId">Employee id*</label>
      <div class="col-sm-10">
        <s:textfield name="registerBean.empId" class="form-control" value=""/>
    </div>
    </div>
    <div class="form-group">
      <label class="control-label col-sm-2"   for="dateJoin">Date Of Joining(mm/dd/yyyy)*</label>
      <div class="col-sm-10">
      <s:textfield name="registerBean.dateJoin" class="form-control" value=""/>
    </div>
    </div>
    <div class="form-group">
      <label class="control-label col-sm-2" for="compAdd">Company Address*</label>
      <div class="col-sm-10">
       <s:textfield name="registerBean.compAdd" class="form-control" value=""/>
    </div>
    </div>
    <div class="form-group">
      <label class="control-label col-sm-2" for="offNo">Office Phone no. *</label>
      <div class="col-sm-10">
       <s:textfield name="registerBean.offNo" class="form-control" value=""/>
    </div>
    </div>
    <div class="form-group">
      <label class="control-label col-sm-2" for="emailofficial">Official Email id *</label>
      <div class="col-sm-10">
      <s:textfield name="registerBean.emailofficial" class="form-control" value=""/>
    </div>
    </div>
  </fieldset>

      <fieldset class="row2">
  <div id="legend"><legend>Further Details</legend></div>
  
  <div class="form-group">
      <label class="control-label col-sm-2"   for="salbankacc">Salaried Bank Account*</label>
      <div class="col-sm-10">
         <s:radio  name="registerBean.salbankacc" list="{'Yes'}" value="%{salbankacc}" onclick="enable('y')" />
         <s:radio  name="registerBean.salbankacc" list="{'No'}" value="%{salbankacc}" onclick="enable('n')" />
        </div>
    </div>
    <div class="form-group">
      <label class="control-label col-sm-2" for="salbankname">Bank Name</label>
      <div class="col-sm-10">
       <s:textfield name="registerBean.salbankname" id="salbkname" class="form-control" value=""/>
    </div>
    </div>
    <div class="form-group">
      <label class="control-label col-sm-2"   for="accNo">Account no.</label>
      <div class="col-sm-10">
        <s:textfield name="registerBean.accNo" id="acc" class="form-control" value=""/>
    </div>
    </div>
    <div class="form-group">
      <label class="control-label col-sm-2"  for="accHoldrName">Account Holder Name</label>
      <div class="col-sm-10">
        <s:textfield name="registerBean.accHoldrName" id="accname" label="" value="" class="form-control"/>
    </div>
    </div>
    <div class="form-group">
      <label class="control-label col-sm-2" for="otherbankcard">Other Bank Card*</label>
      <div class="col-sm-10">
      <s:radio name="registerBean.otherbankcard"   list="{'Yes'}" value="%{otherbankcard}" onclick="enable('no')"/> 
      <s:radio name="registerBean.otherbankcard"   list="{'No'}" value="%{otherbankcard}" onclick="enable('yes')" /> 
    </div>
    </div>
    <div class="form-group">
      <label for="#">Any Other Bank Card Detail(If Owned,Please Enter Details)</label>
      </div>
    <div></div>
    <div class="form-group">
      <label class="control-label col-sm-2" for="bankName1">Bank Name</label>
      <div class="col-sm-10">
      <s:textfield name="registerBean.bankName1" class="form-control" id="bn1" value=""/>
    </div>
    </div>
    <div class="form-group">
      <label class="control-label col-sm-2" for="cardHoldrName">Card Holder Name</label>
      <div class="col-sm-10">
      <s:textfield name="registerBean.cardHoldrName" class="form-control" id="chn" label="Card Holder Name" value=""/>
      </div>
    </div>
    <div class="form-group">
      <label class="control-label col-sm-2" for="cardLimit">Card Limit</label>
      <div class="col-sm-10">
       <s:textfield name="registerBean.cardLimit" class="form-control" id="cl" label="Card Limit" value=""/>
    </div>
    </div>
    <div class="form-group">
      <label class="control-label col-sm-2"   for="appno">Application No.</label>
      <div class="col-sm-10">
       <s:textfield class="form-control" name="registerBean.appno" label="Application No." value="%{#session.appno}" readonly="true" />
    </div>
    </div>
    <div>*Fields cannot be left empty</div>
    <div class="form-group">   
   							<div class="col-sm-4">
   							<button type="button" class="btn btn-success" onclick="go('register1')">Register</button>
   							<button type="button" class="btn btn-success" onclick="go('regisbackform')">back</button>
  						</div></div>
  </fieldset>

</form>
</div>
      </div></div></div></div>
    
    
    
</body>
</html>
