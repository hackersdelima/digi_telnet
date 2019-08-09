<%@ taglib prefix="ui" tagdir="/WEB-INF/tags" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>

<html class="fixed">
	<head>
		<title>${pagetitle }</title>
		<ui:meta/>
		<ui:styles/>
		
	</head>
	<body>
		<section class="body">

			<!-- start: header -->
			<header class="header">
				<div class="logo-container">
					<a href="../" class="logo">
						<img src="${pageContext.request.contextPath }/resources/assets/images/logo.png" height="35" alt="JSOFT Admin" />
					</a>
					<div class="visible-xs toggle-sidebar-left" data-toggle-class="sidebar-left-opened" data-target="html" data-fire-event="sidebar-left-opened">
						<i class="fa fa-bars" aria-label="Toggle sidebar"></i>
					</div>
				</div>
			
				<!-- start: search & user box -->
				<div class="header-right">
			
					<form action="pages-search-results.html" class="search nav-form">
						<div class="input-group input-search">
							<input type="text" class="form-control" name="q" id="q" placeholder="Search...">
							<span class="input-group-btn">
								<button class="btn btn-default" type="submit"><i class="fa fa-search"></i></button>
							</span>
						</div>
					</form>
			
					<span class="separator"></span>
					<div id="userbox" class="userbox">
						<a href="#" data-toggle="dropdown">
							<figure class="profile-picture">
								<img src="${pageContext.request.contextPath }/resources/assets/images/!logged-user.jpg" alt="Joseph Doe" class="img-circle" data-lock-picture="${pageContext.request.contextPath }/resources/assets/images/!logged-user.jpg" />
							</figure>
							<div class="profile-info" data-lock-name="John Doe" data-lock-email="johndoe@JSOFT.com">
								<span class="name">${pageContext["request"].userPrincipal.principal.username}</span>
								<span class="role">${pageContext["request"].userPrincipal.principal.staffs.post}</span>
							</div>
			
							<i class="fa custom-caret"></i>
						</a>
			
						<div class="dropdown-menu">
							<ul class="list-unstyled">
								<li class="divider"></li>
								<li>
									<a role="menuitem" tabindex="-1" href="pages-user-profile.html"><i class="fa fa-user"></i> My Profile</a>
								</li>
								<li>
									<a role="menuitem" tabindex="-1" href="#" data-lock-screen="true"><i class="fa fa-lock"></i> Lock Screen</a>
								</li>
								<li>
									<a role="menuitem" tabindex="-1" href="/logout"><i class="fa fa-power-off"></i> Logout</a>
								</li>
							</ul>
						</div>
					</div>
				</div>
				<!-- end: search & user box -->
			</header>
			<!-- end: header -->

			<div class="inner-wrapper">
				<!-- start: sidebar -->
				<aside id="sidebar-left" class="sidebar-left">
				
					<div class="sidebar-header">
						<div class="sidebar-title" style="color:white">
							Navigation
						</div>
						<div class="sidebar-toggle hidden-xs" data-toggle-class="sidebar-left-collapsed" data-target="html" data-fire-event="sidebar-left-toggle">
							<i class="fa fa-bars" aria-label="Toggle sidebar"></i>
						</div>
					</div>
				
					<div class="nano">
						<div class="nano-content">
							<nav id="menu" class="nav-main" role="navigation">
								<ul class="nav nav-main">
									<li class="nav-active">
										<a href="<c:url value="/dashboard"/>">
											<i class="fa fa-home" aria-hidden="true"></i>
											<span>Dashboard</span>
										</a>
									</li>
									
									<li class="nav-parent">
										<a>
											<i class="fa fa-cogs" aria-hidden="true"></i>
											<span>Settings</span>
										</a>
										<!-- office settings -->
										<ul class="nav nav-children">
											
											<li class="nav-parent">
											
												<a><i class="fa fa-briefcase" aria-hidden="true"></i> Office</a>
												<ul class="nav nav-children">
													
													<li>
													
														<a href="<c:url value="/office/create-page"/>"><i class="fa fa-edit" aria-hidden="true"></i>  Add/Update Office</a>
													</li>
													<li>
														<a href="<c:url value="/office/view-page"/>"><i class="fa fa-search" aria-hidden="true"></i>  View Office</a>
													</li>
												</ul>
											</li>
										</ul>
										
										<!-- staff settings -->
										<ul class="nav nav-children">
											
											<li class="nav-parent">
												<a>Staff</a>
												<ul class="nav nav-children">
													
													<li>
														<a href="<c:url value="/staffs/create-page"/>">Add/Update Staff</a>
													</li>
													<li>
														<a href="<c:url value="/staffs/view-page"/>">View Staff</a>
													</li>
												</ul>
											</li>
										</ul>
										
										<!-- User settings -->
										<ul class="nav nav-children">
											
											<li class="nav-parent">
												<a>User</a>
												<ul class="nav nav-children">
													
													<li>
														<a href="<c:url value="/users/create-page"/>">Add/Update User</a>
													</li>
													<li>
														<a href="<c:url value="/users/view-page"/>">View User</a>
													</li>
												</ul>
											</li>
										</ul>
									</li>
									
								</ul>
							</nav>
				
				</div>
				</div>
				</aside>
				<!-- end: sidebar -->

				<section role="main" class="content-body">
					<header class="page-header">
						<h2>${pagetitle }</h2>
					
						<div class="right-wrapper pull-right">
							<ol class="breadcrumbs">
								<li>
									<a href="index.html">
										<i class="fa fa-home"></i>
									</a>
								</li>
								<li><span>${pagetitle }</span></li>
							</ol>
					
							<a class="sidebar-right-toggle" data-open="sidebar-right"><i class="fa fa-chevron-left"></i></a>
						</div>
					</header>
				
			