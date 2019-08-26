<%@ taglib prefix="ui" tagdir="/WEB-INF/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<ui:header2 />
<section class="panel">
	<header class="panel-heading">
		<div class="panel-actions">
			<a href="#" class="fa fa-caret-down"></a>
		</div>

		<h2 class="panel-title">Personal Information</h2>
	</header>
	<div class="panel-body">
		<table class="table table-bordered "
			id="userTable">
			<thead>
				<tr>
					<th>NAME</th>
					<th>GENDER</th>
					<th>ADDRESS</th>
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
	var url="${pageContext.request.contextPath }/phonebook/";
	$.get(url, function(data, status){
	    var json=data.datas;
	    var table = $('#userTable').DataTable({
	        "data":json,
	        "columns": [
	            {data:"firstName",
	            	"render":function(data,type,row){
	                    return data+' '+row['lastName'];
	                 }
	            },
	            {data:"gender"},
	            {data:"address"},
	            {data:"phoneNumber"},
	  		],
	  		"destroy": true
	 	}); 
	  })        
	  .done(function (data) { })
      .fail(function (jqxhr,settings,ex) { alert('No Data Found!'); 
      });
	}
	
</script>