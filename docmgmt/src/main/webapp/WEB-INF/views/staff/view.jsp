<%@ taglib prefix="ui" tagdir="/WEB-INF/tags"%>
<ui:header />

<div class="row">
	<div class="col-md-12">
		<div class="tabs">
			<ul class="nav nav-tabs">
				<li class="active"><a href="#popular" data-toggle="tab"><i
						class="fa fa-star"></i> Staff</a></li>
				<li><a href="#recent" data-toggle="tab">Staff Family</a></li>
			</ul>

			<div class="tab-content">
				<!-- Display staff -->
				<div id="popular" class="tab-pane active">
					<section class="panel">
						<header class="panel-heading">
							<div class="panel-actions">
								<a href="#" class="fa fa-caret-down"></a>
							</div>

							<h2 class="panel-title">Staff Details</h2>
						</header>
						<div class="panel-body">
							<table class="table table-bordered table-striped mb-none"
								id="staffTable">
								<thead>
									<tr>
										<th>Code</th>
										<th>First Name</th>
										<th>Last Name</th>
										<th>Gender</th>
										<th>Phone Number</th>
										<th>Post</th>
										<th>Office</th>		
									</tr>
								</thead>
							</table>
						</div>
					</section>
				</div>
				<!-- Display staff family -->
				<div id="recent" class="tab-pane">
					<section class="panel">
						<header class="panel-heading">
							<div class="panel-actions">
								<a href="#" class="fa fa-caret-down"></a>
							</div>

							<h2 class="panel-title">Staff Family Details</h2>
							<br>
							<div class="form-group">
						<div class="col-md-4">
							<input type="text" class="form-control input-sm" id="staffcode"
								name="staffcode" placeholder="Enter Staff Code...">
						</div>
					</div>
						</header>
						<div class="panel-body">
							<table class="table table-bordered table-striped mb-none"
								id="staffFamilyTable">
								<thead>
									<tr>
										<th>First Name</th>
										<th>Last Name</th>
										<th>Gender</th>
										<th>Occupation</th>
										<th>Phone Number</th>	
										<th>Relation</th>
									</tr>
								</thead>
							</table>
						</div>
					</section>
				</div>
			</div>
		</div>
	</div>
</div>

<ui:footer />
<script>
$(document).ready(function(){
	$('#staffFamilyTable').DataTable();
	var url="${pageContext.request.contextPath }/staffs/";
	$.get(url, function(data, status){
	    var json=data.datas;
	    var table = $('#staffTable').DataTable({
	        "data":json,
	        "columns": [
	            {data:"code"},
	            {data:"firstName"},
	            {data:"lastName"},
	            {data:"gender"},
	            {data:"phoneNumber"},
	            {data:"post"},
	            {data:"office.name"},
	  		]
	 	}); 
	  })        
	  .done(function (data) { })
      .fail(function (jqxhr,settings,ex) { alert('No Data Found!'); 
      });
	//staff family
	$('#staffcode').keyup(function(){
		var staffcode=$(this).val();
		getfamily(staffcode);
	});
	function getfamily(staffcode){
		var familytable='#staffFamilyTable';
	var url="${pageContext.request.contextPath }/staffsFamily/findByStaff/"+staffcode;
	$.get(url, function(data, status){
	    var json=data.datas;
	    
	    var table = $(familytable).DataTable({
	        "data":json,
	        "columns": [
	            {data:"firstName"},
	            {data:"lastName"},
	            {data:"gender"},
	            {data:"occupation"},
	            {data:"phoneNumber"},
	            {data:"relation"},
	  		],
	  		 "destroy": true
	 	}); 
	  })        
	  .done(function (data) { })
      .fail(function (jqxhr,settings,ex) {
    	  $(familytable).empty();
      });
	}
});



</script>