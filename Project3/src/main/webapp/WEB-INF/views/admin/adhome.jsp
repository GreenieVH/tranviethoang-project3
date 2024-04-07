<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">

<head>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title>Admin</title>
<!-- plugins:css -->
<link rel="stylesheet" href="adFront/vendors/feather/feather.css">
<link rel="stylesheet"
	href="adFront/vendors/mdi/css/materialdesignicons.min.css">
<link rel="stylesheet"
	href="adFront/vendors/ti-icons/css/themify-icons.css">
<link rel="stylesheet" href="adFront/vendors/typicons/typicons.css">
<link rel="stylesheet"
	href="adFront/vendors/simple-line-icons/css/simple-line-icons.css">
<link rel="stylesheet" href="adFront/vendors/css/vendor.bundle.base.css">
<!-- endinject -->
<!-- Plugin css for this page -->
<link rel="stylesheet"
	href="adFront/vendors/datatables.net-bs4/dataTables.bootstrap4.css">
<link rel="stylesheet" href="adFront/js/select.dataTables.min.css">
<!-- End plugin css for this page -->
<!-- inject:css -->
<link rel="stylesheet"
	href="adFront/css/vertical-layout-light/style.css">

<!-- endinject -->
<link rel="shortcut icon" href="adFront/images/favicon.png" />
</head>
<body>
	<div class="container-scroller">
		<!-- partial:partials/_navbar.html -->
		<nav
			class="navbar default-layout col-lg-12 col-12 p-0 fixed-top d-flex align-items-top flex-row">
			<div
				class="text-center navbar-brand-wrapper d-flex align-items-center justify-content-start">
				<div class="me-3">
					<button class="navbar-toggler navbar-toggler align-self-center"
						type="button" data-bs-toggle="minimize">
						<span class="icon-menu"></span>
					</button>
				</div>
				<div>
					<a class="navbar-brand brand-logo" href="index.html"> <img
						src="adFront/images/logo.svg" alt="logo" />
					</a> <a class="navbar-brand brand-logo-mini" href="index.html"> <img
						src="adFront/images/logo-mini.svg" alt="logo" />
					</a>
				</div>
			</div>
		</nav>
		<!-- partial -->
		<div class="container-fluid page-body-wrapper">
			<!-- partial:partials/_settings-panel.html -->
			<div class="theme-setting-wrapper">
				<div id="settings-trigger">
					<i class="ti-settings"></i>
				</div>
				<div id="theme-settings" class="settings-panel">
					<i class="settings-close ti-close"></i>
					<p class="settings-heading">SIDEBAR SKINS</p>
					<div class="sidebar-bg-options selected" id="sidebar-light-theme">
						<div class="img-ss rounded-circle bg-light border me-3"></div>
						Light
					</div>
					<div class="sidebar-bg-options" id="sidebar-dark-theme">
						<div class="img-ss rounded-circle bg-dark border me-3"></div>
						Dark
					</div>
					<p class="settings-heading mt-2">HEADER SKINS</p>
					<div class="color-tiles mx-0 px-4">
						<div class="tiles success"></div>
						<div class="tiles warning"></div>
						<div class="tiles danger"></div>
						<div class="tiles info"></div>
						<div class="tiles dark"></div>
						<div class="tiles default"></div>
					</div>
				</div>
			</div>

			<!-- partial -->
			<!-- partial:partials/_sidebar.html -->
			<nav class="sidebar sidebar-offcanvas" id="sidebar">
				<ul class="nav">
					<li class="nav-item"><a class="nav-link" href="index.html">
							<i class="mdi mdi-grid-large menu-icon"></i> <span
							class="menu-title">Dashboard</span>
					</a></li>
					<li class="nav-item nav-category">Forms and Datas</li>
					<li class="nav-item"><a class="nav-link"
						data-bs-toggle="collapse" href="#form-elements"
						aria-expanded="false" aria-controls="form-elements"> <i
							class="menu-icon mdi mdi-card-text-outline"></i> <span
							class="menu-title">Form elements</span> <i class="menu-arrow"></i>
					</a></li>

					<li class="nav-item"><a class="nav-link"
						data-bs-toggle="collapse" href=" " aria-expanded="false"
						aria-controls="tables"> <i class="menu-icon mdi mdi-table"></i>
							<span class="menu-title">Tables</span> <i class="menu-arrow"></i>
					</a></li>

				</ul>
			</nav>
			<!-- partial -->
			<section class="intro">
				<div class="gradient-custom-1 h-100">
					<div class="mask d-flex align-items-center h-100">
						<div class="container">
							<div class="row justify-content-center">
								<div class="col-12">
									<div class="table-responsive bg-white">
										<table class="table mb-0">
											<thead>
												<tr>
													<th scope="col">EMPLOYEES</th>
													<th scope="col">POSITION</th>
													<th scope="col">CONTACTS</th>
													<th scope="col">AGE</th>
													<th scope="col">ADDRESS</th>
													<th scope="col">SALARY</th>
													<th scope="col">SALARY</th>
													<th scope="col">SALARY</th>
													<th scope="col">SALARY</th>
													<th scope="col">SALARY</th>
												</tr>
											</thead>
											<tbody>
												<tr>
													<th scope="row" style="color: #666666;">Tiger Nixon</th>
													<td>System Architect</td>
													<td>tnixon12@example.com</td>
													<td>61</td>
													<td>Edinburgh</td>
													<td>$320,800</td>
												</tr>
												<tr>
													<th scope="row" style="color: #666666;">Sonya Frost</th>
													<td>Software Engineer</td>
													<td>sfrost34@example.com</td>
													<td>23</td>
													<td>Edinburgh</td>
													<td>$103,600</td>
												</tr>
												<tr>
													<th scope="row" style="color: #666666;">Jena Gaines</th>
													<td>Office Manager</td>
													<td>jgaines75@example.com</td>
													<td>30</td>
													<td>London</td>
													<td>$90,560</td>
												</tr>
												<tr>
													<th scope="row" style="color: #666666;">Quinn Flynn</th>
													<td>Support Lead</td>
													<td>qflyn09@example.com</td>
													<td>22</td>
													<td>Edinburgh</td>
													<td>$342,000</td>
												</tr>
												<tr>
													<th scope="row" style="color: #666666;">Charde
														Marshall</th>
													<td>Regional Director</td>
													<td>cmarshall28@example.com</td>
													<td>36</td>
													<td>San Francisco</td>
													<td>$470,600</td>
												</tr>
												<tr>
													<th scope="row" style="color: #666666;">Haley Kennedy</th>
													<td>Senior Marketing Designer</td>
													<td>hkennedy63@example.com</td>
													<td>43</td>
													<td>London</td>
													<td>$313,500</td>
												</tr>
												<tr>
													<th scope="row" style="color: #666666;">Tatyana
														Fitzpatrick</th>
													<td>Regional Director</td>
													<td>tfitzpatrick00@example.com</td>
													<td>19</td>
													<td>Warsaw</td>
													<td>$385,750</td>
												</tr>
											</tbody>
										</table>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</section>
			<!-- page-body-wrapper ends -->
		</div>
		<!-- container-scroller -->

		<!-- plugins:js -->
		<script src="adFront/vendors/js/vendor.bundle.base.js"></script>
		<!-- endinject -->
		<!-- Plugin js for this page -->
		<script src="adFront/vendors/chart.js/Chart.min.js"></script>
		<script
			src="adFront/vendors/bootstrap-datepicker/bootstrap-datepicker.min.js"></script>
		<script src="adFront/vendors/progressbar.js/progressbar.min.js"></script>

		<!-- End plugin js for this page -->
		<!-- inject:js -->
		<script src="adFront/js/off-canvas.js"></script>
		<script src="adFront/js/hoverable-collapse.js"></script>
		<script src="adFront/js/template.js"></script>
		<script src="adFront/js/settings.js"></script>
		<script src="adFront/js/todolist.js"></script>
		<!-- endinject -->
		<!-- Custom js for this page-->
		<script src="adFront/js/dashboard.js"></script>
		<script src="adFront/js/Chart.roundedBarCharts.js"></script>
		<!-- End custom js for this page-->
</body>

</html>

