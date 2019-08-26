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

				<h2 class="panel-title">Enter Company Details</h2>
			</header>
			<div class="panel-body">
				<form class="form-horizontal form-bordered" method="post"
					id="companyform">

					<div class="form-group">
						<label class="col-md-3 control-label" for="name"> Name</label>
						<div class="col-md-6">
							<input type="text" class="form-control" id="name" name="name">
						</div>
					</div>

					<div class="form-group">
						<label class="col-md-3 control-label" for="address">Address</label>
						<div class="col-md-6">
							<input type="text" class="form-control" id="address"
								name="address">
						</div>
					</div>


					<div class="form-group">
						<label class="col-md-3 control-label" for="pob">P.O. Box
							Number</label>
						<div class="col-md-6">
							<input type="text" class="form-control" id="pob" name="pob">
						</div>
					</div>

					<div class="form-group">
						<label class="col-md-3 control-label" for="phone">Phone
							Number</label>
						<div class="col-md-6">
							<input type="text" class="form-control" id="phone" name="phone">
						</div>
					</div>


					<br />
					<footer class="panel-footer">
						<div class="row">
							<div class="col-sm-9 col-sm-offset-3">
								<button type="submit" class="btn btn-primary">Save
									Company</button>
								<button type="reset" class="btn btn-default">Reset</button>
							</div>
						</div>
					</footer>
				</form>
				
				<form action="<c:url value="/company/import"/>" method="post" enctype="multipart/form-data" target="_blank">

					<input type="file" name="file"> <input type="submit"
						value="Import" />
				</form>
			</div>
		</section>
	</div>
</div>
<ui:footer />
<script
	src="${pageContext.request.contextPath }/resources/assets/externalJs/ajaxStatus.js"></script>
<script>
	$(document).ready(function() {

		// SUBMIT First FORM
		$("#companyform").submit(function(event) {
			// Prevent the form from submitting via the browser.

			event.preventDefault();
			var formData = {
				"name" : $("#name").val(),
				"address" : $("#address").val(),
				"poBoxNumber" : $("#pob").val(),
				"phoneNumber" : $("#phone").val()

			};
			var url = "${pageContext.request.contextPath }/company";
			ajaxPost(url, formData);
		});
	});
</script>