<%@ taglib prefix="ui" tagdir="/WEB-INF/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<ui:header />
<section class="panel">
	<header class="panel-heading">
		<div class="panel-actions">
			<a href="#" class="fa fa-caret-down"></a> <a href="#"
				class="fa fa-times"></a>
		</div>

		<h2 class="panel-title">Basic</h2>
	</header>
	<div class="panel-body">
		<table class="table table-bordered table-striped mb-none"
			id="datatable-default">
			<thead>
				<tr>
					<th>RO CODE</th>
					<th>NAME</th>
					<th>ADDRESS</th>
					<th>OFFICE LEVEL</th>

				</tr>
			</thead>
			<tbody>
				<tr class="gradeX">
					<td></td>
					<td></td>
					<td></td>
					<td></td>
				</tr>

			</tbody>
		</table>
	</div>
</section>

<ui:footer />