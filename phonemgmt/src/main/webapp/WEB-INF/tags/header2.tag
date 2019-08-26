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
				<!-- start: search & user box -->
				<div class="header-right">
					<span class="separator"></span>
					<div id="userbox" class="userbox">
						<a href="#" data-toggle="dropdown">
							<div class="profile-info" data-lock-name="First Last" data-lock-email="username">
 								    <span class="">${username }</span><br />
							</div>
			
							<i class="fa custom-caret"></i>
						</a>
			
						<div class="dropdown-menu">
							<ul class="list-unstyled">
								<li class="divider"></li>
								<li>
									<a role="menuitem" tabindex="-1" href="<c:url value="/login-page"/>"><i class="fa fa-user"></i> LogIn</a>
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
							Usage Details
						</div>
						<div class="sidebar-toggle hidden-xs" data-toggle-class="sidebar-left-collapsed" data-target="html" data-fire-event="sidebar-left-toggle">
							<i class="fa fa-bars" aria-label="Toggle sidebar"></i>
						</div>
					</div>
				
					<div class="nano">
						<div class="nano-content">
							<hr>
							<h3>Find information on anyone you want!</h3>
							<hr>
							<h3>Search is optimized for your ease!</h3>
							<hr>
							<h3>Only know the first name?</h3>
							<hr>
							<h3>Or Address?</h3>
							<hr>
							<h3>Or Gender?</h3>
							<hr>
							<h3>It's fine!</h3>
							<hr>
							<h3><b><u>WE ARE HERE!!!</u></b></h3>
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
				
			