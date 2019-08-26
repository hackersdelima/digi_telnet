<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<nav id="menu" class="nav-main" role="navigation">
	<ul class="nav nav-main">
		<li class="nav-active"><a href="<c:url value="/phonebook/view-page"/>">
				<i class="fa fa-home" aria-hidden="true"></i> <span>Phonebook</span>
		</a></li>

		<li class="nav-parent"><a> <i class="fa fa-cogs"
				aria-hidden="true"></i> <span>Settings</span>
		</a> <!-- office settings -->
			<ul class="nav nav-children">

				<li class="nav-parent"><a><i class="fa fa-users"
						aria-hidden="true"></i> User Details</a>
					<ul class="nav nav-children">

						<li><a href="<c:url value="/users/create-page"/>"><i
								class="fa fa-edit" aria-hidden="true"></i> Add/Update User Details</a></li>
						<li><a href="<c:url value="/users/view-page"/>"><i
								class="fa fa-search" aria-hidden="true"></i> View User Details</a></li>
					</ul></li>
			</ul>
			
			<!-- Company detail settings -->
			<ul class="nav nav-children">

				<li class="nav-parent"><a><i
								class="fa fa-users" aria-hidden="true"></i> Company</a>
					<ul class="nav nav-children">

						<li><a href="<c:url value="/company/create-page"/>"><i
								class="fa fa-edit" aria-hidden="true"></i> Add/Update
								Company</a></li>
						<li><a href="<c:url value="/company/view-page"/>"><i
								class="fa fa-search" aria-hidden="true"></i> View
								Company</a></li>
					</ul></li>
			</ul>
			
			 <!-- user settings -->
			<ul class="nav nav-children">

				<li class="nav-parent"><a><i
								class="fa fa-users" aria-hidden="true"></i> Admin</a>
					<ul class="nav nav-children">

						<li><a href="<c:url value="/admin/create-page"/>"><i
								class="fa fa-edit" aria-hidden="true"></i> Add/Update
								Admin</a></li>
						<li><a href="<c:url value="/admin/view-page"/>"><i
								class="fa fa-search" aria-hidden="true"></i> View
								Admin</a></li>
					</ul></li>
			</ul>
			
	</ul>
</nav>