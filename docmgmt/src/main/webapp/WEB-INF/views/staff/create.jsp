<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ taglib prefix="ui" tagdir="/WEB-INF/tags"%>

<ui:header />
<div class="row">
	<div class="col-lg-12">
		<section class="panel">
			<header class="panel-heading">
				<div class="panel-actions">
					<a href="#" class="fa fa-caret-down"></a>
				</div>

				<h2 class="panel-title">Enter Staff Details</h2>
			</header>
			<div class="panel-body">
				<form class="form-horizontal form-bordered" method="post"
					 id="staffform">
					<div class="form-group">
						<label class="col-md-3 control-label" for="code"> Code</label>
						<div class="col-md-6">
							<input type="text" class="form-control" id="code" name="code">
						</div>
					</div>

					<div class="form-group">
						<label class="col-md-3 control-label" for="fname">First
							Name</label>
						<div class="col-md-6">
							<input type="text" class="form-control" id="fname" name="fname">
						</div>
					</div>

					<div class="form-group">
						<label class="col-md-3 control-label" for="lname">Last
							Name</label>
						<div class="col-md-6">
							<input type="text" class="form-control" id="lname" name="lname">
						</div>
					</div>

					<div class="form-group">
						<label class="col-md-3 control-label" for="phone">Phone
							Number</label>
						<div class="col-md-6">
							<input type="text" class="form-control" id="phone" name="phone">
						</div>
					</div>

					<div class="form-group">
						<label class="col-md-3 control-label" for="post">Post</label>
						<div class="col-md-6">
							<input type="text" class="form-control" id="post" name="post">
						</div>
					</div>

					<div class="form-group">
						<label class="col-md-3 control-label" for="office">Office</label>
						<div class="col-md-6">
							<select class="form-control" id="office" name="office">
							<option value="1">Select Office</option>
							
							
							</select>
						</div>
					</div>
					<br />
					<footer class="panel-footer">
						<div class="row">
							<div class="col-sm-9 col-sm-offset-3">
								<button type="submit" class="btn btn-primary">Save Staffs</button>
								<button type="reset" class="btn btn-default">Reset</button>
							</div>
						</div>
					</footer>
				</form>
			</div>
		</section>
	</div>
</div>
<div class="row">
	<div class="col-lg-12">
		<section class="panel">
			<header class="panel-heading">
				<div class="panel-actions">
					<a href="#" class="fa fa-caret-down"></a>
				</div>

				<h2 class="panel-title">Enter Staffs Family Details</h2>
			</header>
			<div class="panel-body">
				<form class="form-horizontal form-bordered" method="post"
					 id="familyform">
					<input type="hidden" id="fid" value="0">

					<div class="form-group">
						<label class="col-md-3 control-label" for="ffname">First
							Name</label>
						<div class="col-md-6">
							<input type="text" class="form-control" id="ffname" name="ffname">
						</div>
					</div>

					<div class="form-group">
						<label class="col-md-3 control-label" for="flname">Last
							Name</label>
						<div class="col-md-6">
							<input type="text" class="form-control" id="flname" name="flname">
						</div>
					</div>

					<div class="form-group">
						<label class="col-md-3 control-label" for="fphone">Phone
							Number</label>
						<div class="col-md-6">
							<input type="text" class="form-control" id="fphone" name="fphone">
						</div>
					</div>

					<div class="form-group">
						<label class="col-md-3 control-label" for="foccupation">Occupation</label>
						<div class="col-md-6">
							<input type="text" class="form-control" id="foccupation"
								name="foccupation">
						</div>
					</div>

					<div class="form-group">
						<label class="col-md-3 control-label" for="relation">Relation</label>
						<div class="col-md-6">
							<input type="text" class="form-control" id="relation"
								name="relation">
						</div>
					</div>
					
					<br />
					<footer class="panel-footer">
						<div class="row">
							<div class="col-sm-9 col-sm-offset-3">
								<button type="submit" class="btn btn-primary">Save Family</button>
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
<!-- manage script to save values -->
<script>
$( document ).ready(function() {
	  
	  // SUBMIT FORM
	    $("#staffform").submit(function(event) {
	    // Prevent the form from submitting via the browser.
	    
	    event.preventDefault();
	    var formData = {
				"code":$('#code').val(),
	        "firstName" : $("#fname").val(),
	        "lastName" :  $("#lname").val(),
	        "phoneNumber" : $("#phone").val(),
	        "post" : $("#post").val(),
	        "office": {
	        	"id":$("#office").val()
	        }
	    };
	    var url="${pageContext.request.contextPath }/staffs";
	    ajaxPost(url, formData);
	  });
	    $("#familyform").submit(function(event) {
		    // Prevent the form from submitting via the browser.
		    
		    event.preventDefault();
		    var formData = {
					"id":$('#id').val(),
					"firstName":$('#ffname').val(),
					"lastName":$('#flname').val(),
					"occupation":$('#foccupation').val(),
					"phoneNumber":$('#fphone').val(),
					"relation":$('#relation').val(),
					"staffs":{
						"code":$('#code').val()
					}
			};
		    var url="${pageContext.request.contextPath }/staffsFamily";
		    ajaxPost(url, formData);
		  });
});
</script>