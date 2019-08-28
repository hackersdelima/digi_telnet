<%@ taglib prefix="ui" tagdir="/WEB-INF/tags"%>
<ui:header/>
<div class="row">
	<div class="col-lg-12">
		<section class="panel">
			<header class="panel-heading">
				<div class="panel-actions">
					<a href="#" class="fa fa-caret-down"></a>
				</div>

				<h2 class="panel-title">Enter Admin Details</h2>
			</header>
			<div class="panel-body">
				<form class="form-horizontal form-bordered" method="post"
					id="adminform">
					
					<input type="hidden" id="id" name="id" value="0">
					
					<div class="form-group">
						<label class="col-md-3 control-label" for="username">Username</label>
						<div class="col-md-6">
							<input type="text" class="form-control" id="username" name="username">
						</div>
					</div>

					<div class="form-group">
						<label class="col-md-3 control-label" for="password">Password</label>
						<div class="col-md-6">
							<input type="password" class="form-control" id="password" name="password">
						</div>
					</div>

					<div class="form-group">
						<label class="col-md-3 control-label" for="confirmpassword">Confirm Password</label>
						<div class="col-md-6">
							<input type="password" class="form-control" id="confirmpassword" name="confirmpassword">
						</div>
					</div>

					<div class="form-group">
						<label class="col-md-3 control-label" for="status">Status</label>
						<div class="col-md-6">
							<input type="radio" class="form-control status"
								name="status" value="true">True
								<input type="radio" class="form-control status"
								name="status" value="false">False
						</div>
					</div>
					<div class="form-group">
						<label class="col-md-3 control-label" for="role">Role</label>
						<div class="col-md-6">
							<select class="form-control" id="role" name="role">
								<option value="">Select Role</option>
								<option value="1">Admin</option>
								<option value="2">Other</option>
							</select>
						</div>
					</div>
					
					<br />
					<footer class="panel-footer">
						<div class="row">
							<div class="col-sm-9 col-sm-offset-3">
								<button type="submit" class="btn btn-primary">Save
									Admin</button>
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
	$("#adminform").submit(function(event) {
		// Prevent the form from submitting via the browser.

		event.preventDefault();
		var formData = {
				/* "id" : $("#id").val, */
			"username" : $("#username").val(),
			"password" : $("#password").val(),
			"confirmpassword" : $("#confirmpassword").val(),
			"status": $(".status:checked").val(),
			"roles" : {
				"id" : $("#role").val()
			}
		};
		var url = "${pageContext.request.contextPath }/admin";
		ajaxPost(url, formData);
	});
});

</script>