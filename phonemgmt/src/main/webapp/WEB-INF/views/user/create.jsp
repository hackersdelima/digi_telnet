<%@ taglib prefix="ui" tagdir="/WEB-INF/tags"%>
<ui:header/>
<div class="row">
	<div class="col-lg-12">
		<section class="panel">
			<header class="panel-heading">
				<div class="panel-actions">
					<a href="#" class="fa fa-caret-down"></a>
				</div>

				<h2 class="panel-title">Enter User Details</h2>
			</header>
			<div class="panel-body">
				<form class="form-horizontal form-bordered" method="post"
					id="userform">

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
						<label class="col-md-3 control-label" for="gender">Gender</label>
						<div class="col-md-6">
							<select class="form-control" id="gender" name="gender">
								<option value="">Select Gender</option>
								<option value="m">Male</option>
								<option value="f">Female</option>
								<option value="o">Other</option>
							</select>
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
						<label class="col-md-3 control-label" for="address">Address</label>
						<div class="col-md-6">
							<input type="text" class="form-control" id="address" name="address">
						</div>
					</div>

					<br />
					<footer class="panel-footer">
						<div class="row">
							<div class="col-sm-9 col-sm-offset-3">
								<button type="submit" class="btn btn-primary">Save
									User</button>
								<button type="reset" class="btn btn-default">Reset</button>
							</div>
						</div>
					</footer>
				</form>
			</div>
		</section>
	</div>
</div>
<ui:footer/>
<script
	src="${pageContext.request.contextPath }/resources/assets/externalJs/ajaxStatus.js"></script>
<script>

$(document).ready(function() {

	// SUBMIT First FORM
	$("#userform").submit(function(event) {
		// Prevent the form from submitting via the browser.

		event.preventDefault();
		var formData = {
			"firstName" : $("#fname").val(),
			"lastName" : $("#lname").val(),
			"gender" : $("#gender").val(),
			"phoneNumber" : $("#phone").val(),
			"address" : $("#address").val()
		};
		var url = "${pageContext.request.contextPath }/users";
		ajaxPost(url, formData);
	});
});

</script>