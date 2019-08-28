<%@ taglib prefix="ui" tagdir="/WEB-INF/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<ui:header2 />
<section class="panel">
	<header class="panel-heading">
		<div class="panel-actions">
			<a href="#" class="fa fa-caret-down"></a>
		</div>

		<h2 class="panel-title">Company Details</h2>
	</header>
	<div class="panel-body">
		<table class="table table-bordered table-striped mb-none"
			id="companyTable">
			<thead>
				<tr>
					<th>NAME</th>
					<th>ADDRESS</th>
					<th>PO Box</th>
					<th>PHONE-NUMBER</th>
				</tr>
			</thead>
		</table>
	</div>
</section>

<ui:footer />
<script src="${pageContext.request.contextPath }/resources/assets/externalJs/ajaxStatus.js"></script>
<script>
$(document).ready(function(){
	loaddatatable();
});
function loaddatatable(){
	var url="${pageContext.request.contextPath }/phonebook2/";
	$.get(url, function(data, status){
	    var json=data.datas;
	    var table = $('#companyTable').DataTable({
	        "data":json,
	        "columns": [
	            {data:"name"},
	            {data:"address"},
	            {data:"poBoxNumber"},
	            {data:"phoneNumber"}
	  		],
	  		"destroy": true
	 	}); 
	  })        
	  .done(function (data) { })
      .fail(function (jqxhr,settings,ex) { alert('No Data Found!'); 
      });
	}






</script>