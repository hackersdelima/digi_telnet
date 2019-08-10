<%@ taglib prefix="ui" tagdir="/WEB-INF/tags"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<ui:header />
<div class="row">
	<div class="col-lg-12">
		<section class="panel">
			<header class="panel-heading">
				<div class="panel-actions">
					<a href="#" class="fa fa-caret-down"></a>
				</div>

				<h2 class="panel-title">Create User</h2>
			</header>
			<div class="panel-body">
				<form class="form-horizontal form-bordered" method="post" name="userform" id="userform">
					<input type="hidden" id="id" value="0">
					<div class="form-group">
						<label class="col-md-3 control-label" for="staffid">Staff ID</label>
						<div class="col-md-6">
							<select class="form-control" id="staffid" name="staffid" required>
							<c:forEach items="${staffs }" var="s">
							<option value="${s.code }">${s.code }-${s.firstName } ${s.lastName }</option>
							</c:forEach>
							</select>
						</div>
					</div>

					<div class="form-group">
						<label class="col-md-3 control-label" for="uname">User Name</label>
						<div class="col-md-6">
							<input type="text" class="form-control" id="uname" name="uname">
						</div>
					</div>
					
					<div class="form-group">
						<label class="col-md-3 control-label" for="password">Password</label>
						<div class="col-md-6">
							<input type="password" class="form-control" id="password" name="password">
						</div>
					</div>
					
					 <div class="form-group">
						<label class="col-md-3 control-label" for="repass">Confirm Password</label>
						<div class="col-md-6">
							<input type="password" class="form-control" id="repass" name="repass">
						</div>
					</div>
					
					<br />
					
					<footer class="panel-footer">
										<div class="row">
											<div class="col-sm-9 col-sm-offset-3">
												<button type="submit" class="btn btn-primary">Submit</button>
												<button type="reset" class="btn btn-default">Reset</button>
											</div>
										</div>
									</footer>



				</form>
			</div>
		</section>
	</div>
</div>

<ui:footer />
<script src="${pageContext.request.contextPath }/resources/assets/externalJs/ajaxStatus.js"></script>
<script>
$(document).ready(function() {
	$('#staffid').select2();
	  
	  // SUBMIT FORM
	    $("#userform").submit(function(event) {
	    // Prevent the form from submitting via the browser.
	    
	    event.preventDefault();
	    var password=$('#password').val();
	    var repass=$('#repass').val();
	    //pass values only when the passwords match
	    if(password==repass){
	    var formData = {
	        "username" : $("#uname").val(),
	        "name" :  $("#name").val(),
	        "password" : password,
	        "confirmpassword" : repass,
	        "status" : true,
	        "staffs":{
	        	"code":$('#staffid').val()
	        }
	      };
	    var url="${pageContext.request.contextPath }/users";
	    ajaxPost(url, formData);
	     }
	    else{
	    	alert('Password Mismatch!');
	    } 
	  });
	
});
</script> 
