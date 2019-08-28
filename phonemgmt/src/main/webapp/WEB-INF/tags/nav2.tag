<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<nav id="menu" class="nav-main" role="navigation">
	<ul class="nav nav-main">
		<li class="nav-active"><a href="<c:url value="/phonebook/view-page"/>">
				<i class="fa fa-home" aria-hidden="true"></i> <span>Phonebook</span>
		</a></li>

		<li class="nav-parent"><a> <i class="fa fa-cogs"
				aria-hidden="true"></i> <span>Choose Phonebook</span>
		</a> <!-- office settings -->
			<ul class="nav nav-children">

				<li class="nav-parent"><a><i class="fa fa-users"
						aria-hidden="true"></i> Personal Phonebook</a>
					<ul class="nav nav-children">
						<li><a href="<c:url value="/users/view-page"/>"><i
								class="fa fa-search" aria-hidden="true"></i> View Personal Details</a></li>
					</ul></li>
			</ul>
			
			<!-- Company detail settings -->
			<ul class="nav nav-children">

				<li class="nav-parent"><a><i
								class="fa fa-users" aria-hidden="true"></i> Company Phonebook</a>
					<ul class="nav nav-children">
						<li><a href="<c:url value="/phonebook2/view-page"/>"><i
								class="fa fa-search" aria-hidden="true"></i> View
								Company</a></li>
					</ul></li>
			</ul>
	</ul>
</nav>