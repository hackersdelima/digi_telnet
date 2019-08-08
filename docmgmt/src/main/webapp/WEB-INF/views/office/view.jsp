<%@ taglib prefix="ui" tagdir="/WEB-INF/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<ui:header />
<section class="panel">
	<header class="panel-heading">
		<div class="panel-actions">
			<a href="#" class="fa fa-caret-down"></a>
		</div>

		<h2 class="panel-title">Office Details</h2>
	</header>
	<div class="panel-body">
		<table class="table table-bordered table-striped mb-none"
			id="officeTable">
			<thead>
				<tr>
					<th>RO CODE</th>
					<th>NAME</th>
					<th>ADDRESS</th>
					<th>OFFICE LEVEL</th>
				</tr>
			</thead>
		</table>
	</div>
</section>

<ui:footer />
<script>
$(document).ready(function(){
	var url="${pageContext.request.contextPath }/office/";
	$.get(url, function(data, status){
	    var json=data.datas;
	    var table = $('#officeTable').DataTable({
	        "data":json,
	        "columns": [
	            {data:"ro_code"},
	            {data:"name"},
	            {data:"address"},
	            {data:"office_level"},
	  		]
	 	}); 
	  })        
	  .done(function (data) { })
      .fail(function (jqxhr,settings,ex) { alert('No Data Found!'); 
      });
	  ;
});

</script>