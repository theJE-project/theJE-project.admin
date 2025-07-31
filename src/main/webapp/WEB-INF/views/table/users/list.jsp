<%@page contentType="text/html; charset=UTF-8"%> 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>

<!-- =========================================================
* Sneat - Bootstrap 5 HTML Admin Template
==============================================================

* Product Page: https://themeselection.com/products/sneat-bootstrap-html-admin-template/
* Created by: ThemeSelection
* License: You must have a valid license purchased in order to legally use the theme for your project.
* Copyright ThemeSelection (https://themeselection.com)

=========================================================
 -->
<!-- beautify ignore:start -->
<html
	lang="en"
	class="light-style layout-menu-fixed"
	dir="ltr"
	data-theme="theme-default"
	data-assets-path="/assets/"
	data-template="vertical-menu-template-free"
>
<head>
	<c:import url="../../include/head.jsp" />
</head>

<body>
	<!-- Layout wrapper -->
	<div class="layout-wrapper layout-content-navbar">
		<div class="layout-container">
		
		<c:import url="../../include/aside.jsp" />
		
		<!-- Layout container -->
		<div class="layout-page">
			<!-- Navbar -->
			<c:import url="../../include/navbar.jsp" />
			<!-- / Navbar -->

			<!-- Content wrapper -->
			<div class="content-wrapper">
			<!-- Content -->
					
					<div class="container-fluid flex-grow-1 container-p-y">
						<h4 class="fw-bold">
							<span class="text-muted fw-light">테이블</span> users
						</h4>
						
						<div class="row">
						<!-- Basic Buttons -->
							<div class="col-12">
								<div class="card mb-4">
									<div class="card-header">
									
									<form id="searchForm" name="searchForm" action="/table/users/list" method="post">
								
										<div style="width:auto; float: left;">
											<select id="searchType" name="searchType" class="select2 form-select">
												<option value="ID" selected="selected">ID</option>
												<option value="ACCOUNT">ACCOUNT</option>
												<option value="PASSWORD">PASSWORD</option>
												<option value="LOCATIONS">LOCATIONS</option>
												<option value="ROLE">ROLE</option>
												<option value="NAME">NAME</option>
												<option value="EMAIL">EMAIL</option>
												<option value="IMG">IMG</option>
												<option value="IS_ALERT">IS_ALERT</option>
											</select>
										</div>
										<div style="width:auto; float: left;">
											<input class="form-control" type="text" id="searchValue" name="searchValue" value="" placeholder="검색어를 입력하세요."/>
										</div>
									</div>
									<div class="card-body p-3">
										<div style="width:auto; float: left;">
											<select id="searchDay" name="searchDay" class="select2 form-select flex-row">
												<option value=""></option>
											</select>
										</div>
										<div style="width:auto; float: left;">
											<input class="form-control nowDate" type="date" value="" id="beginDay" name="beginDay"/>
										</div>
										<div style="width:auto; float: left;">
											<input class="form-control nowDate" type="date" value="" id="endDay" name="endDay"/>
										</div>
										</div>
									<div class="card-footer">
										<!-- <button type="button" class="btn btn-primary" onclick="search(1)"> -->
										<button type="button" class="btn btn-primary" onclick="searchSubmit(1)" >
											<span class="tf-icons bx bx-search"></span>&nbsp; 검색
			                            </button>
										<button type="button" class="btn btn-secondary" id="searchClear" data-reset="users">
											<span class="tf-icons bx bx-reset"></span>&nbsp; 리셋
			                            </button>
			                            <button type="button" class="btn btn-info" data-url="/table/users/add" data-type="add"
			                            	data-bs-toggle="modal" data-bs-target="#modalData">
											<span class="tf-icons bx bx-plus"></span>&nbsp; 등록
			                            </button>
			                            <button type="button" class="btn btn-danger" data-url="/table/users/remove">
											<span class="tf-icons bx bx-minus"></span>&nbsp; 삭제
			                            </button>
									</div>
								</div>
							</div>
						</div>
							
						<div class="row">
							<div class="col-12">
								<div class="card mb-4">
									<div class="card-body">
										<div style="width: auto; float: left;">
											<input type="hidden" id="pageNo" name="pageNo" value="${PAGE.page }">
											<select id="pageSize" name="pageSize" class="select2 form-select flex-row" style="width: auto; float: left;">
												<option value="30" selected="selected">30개씩 보기</option>
												<option value="100">100개씩 보기</option>
												<option value="500">500개씩 보기</option>
												<option value="1000">1000개씩 보기</option>
												<option value="5000">5000개씩 보기</option>
												<option value="10000">10000개씩 보기</option>
											</select>
											<script type="text/javascript"> document.forms.searchForm.pageSize.value = '${PAGE.rows}' </script>
										</div>									</form>
										<div style="width: auto; float: left;">
												<span class="center fw-bold">&nbsp; TOTAL : ${PAGE.total } 건 &nbsp;</span>
												<button type="button" class="btn btn-success rounded-pill" onclick="getTableCSV()">
													<span class="tf-icons bx bxs-bank"></span>&nbsp; 엑셀
					                            </button>
				                            </div>
			                            </div>
									<div class="table-responsive text-nowrap">
										<table class="table table-bordered" id="tableList">
											<thead>
												<tr>
													<th class="ck-th">
														<input type="checkbox" id="check_all" name="check_all" class="checkbox-style" value="${entry.id}"/>
														<label for="check_all"></label>
													</th>
													<th class="center">No</th>
													<th class="center">id</th>
													<th class="center">account</th>
													<th class="center">password</th>
													<th class="center">locations</th>
													<th class="center">role</th>
													<th class="center">name</th>
													<th class="center">email</th>
													<th class="center">img</th>
													<th class="center">is_alert</th>
												</tr>
											</thead>
											<tbody id="searchResult">
											
										<c:if test="${TOTAL eq 0}">
												<tr>
													<td class="left">데이터가 없습니다.</td>
												</tr>
										</c:if>
										<c:if test="${TOTAL ne 0}">
											<c:forEach var="entry" items="${LIST}" varStatus="status">
												<c:set var="no" value="${no + 1 }" />
												<c:set var="pageNo" value="${PAGE.total - ( (PAGE.page-1) * PAGE.rows ) - no + 1 }" />
												
													<td><c:out value="${pageNo }"></c:out></td>
													<td class="center">
														<a href="#" class="link_modal green" data-url="/table/users/detail" data-modaltype="detail"
															data-detailkey="id" data-detailvalue="${entry.id}"
															data-bs-toggle="modal" data-bs-target="#modalData">${entry.id}</a>
													</td>
													<td class="center">${entry.account}</td>
													<td class="center">${entry.password}</td>
													<td class="center">${entry.locations}</td>
													<td class="center">${entry.role}</td>
													<td class="center">${entry.name}</td>
													<td class="center">${entry.email}</td>
													<td class="center">${entry.img}</td>
													<td class="center">${entry.is_alert}</td>
												</tr>
												
											</c:forEach>
										</c:if>
											</tbody>
										</table>
									</div>

									<div class="table-responsive text-nowrap">
										<table class="table table-bordered" id="tableCsv" style="display:none;">
											<thead>
												<tr>
													<th class="center">No</th>
													<th class="center">ID</th>
													<th class="center">ACCOUNT</th>
													<th class="center">PASSWORD</th>
													<th class="center">LOCATIONS</th>
													<th class="center">ROLE</th>
													<th class="center">NAME</th>
													<th class="center">EMAIL</th>
													<th class="center">IMG</th>
													<th class="center">IS_ALERT</th>
												</tr>
											</thead>
											<tbody id="searchResult">
											
										<c:if test="${TOTAL eq 0}">
												<tr>
													<td class="left">데이터가 없습니다.</td>
												</tr>
										</c:if>
										<c:if test="${TOTAL ne 0}">
											<c:forEach var="entry" items="${LIST}" varStatus="status">
												<c:set var="no" value="${no + 1 }" />
												<c:set var="pageNo" value="${PAGE.total - ( (PAGE.page-1) * PAGE.rows ) - no + 1 }" />
												
												<tr data-idx="${entry.id}">
													<td><c:out value="${pageNo }"></c:out></td>
													<td class="center">${entry.id}</td>
													<td class="center">${entry.account}</td>
													<td class="center">${entry.password}</td>
													<td class="center">${entry.locations}</td>
													<td class="center">${entry.role}</td>
													<td class="center">${entry.name}</td>
													<td class="center">${entry.email}</td>
													<td class="center">${entry.img}</td>
													<td class="center">${entry.is_alert}</td>
												</tr>
												
											</c:forEach>
										</c:if>
											</tbody>
										</table>
									</div>
								</div>
							</div>
						<div class="row">
							<div class="col-12">
								<div class="card mb-4">
									<div class="card-body">
										<!--  -->
										<!-- <div id="pgmate-modal" class="modal fade container" data-backdrop="static" data-keyboard="false" tabindex="-1" aria-hidden="true"></div> -->
										<!-- <div class="modal fade" id="smallModal" tabindex="-1" aria-hidden="true"> -->
										<div class="modal fade" id="modalData" tabindex="1050" aria-hidden="true">
											<!-- <div class="modal-dialog modal-dialog-scrollable" role="document" > -->
											<div class="modal-dialog modal-lg" role="document" >
											
							
												<form id="dataForm" name="dataForm" action="/table/pg_code/" method="post">
													<input type="hidden" class="form-control" id="ids" name="ids">
													
													<div class="modal-content">
														<div class="modal-header">
															<h5 class="modal-title" id="modal-title"><sapn id="modalTitle">users</sapn></h5>
															<button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close" ></button>
														</div>
														<div class="modal-body">
															<div class="row g-2">
																<div class="col mb-0">
																	<label class="col-form-label" for="html5-text-input" >ID</label>
																	<input type="text" class="form-control" id="data_ID" name="data_ID" >
																</div>
																<div class="col mb-0">
																	<label class="col-form-label" for="html5-text-input" >ACCOUNT</label>
																	<input type="text" class="form-control" id="data_ACCOUNT" name="data_ACCOUNT" maxlength="50">
																</div>
															</div>
															<div class="row g-2">
																<div class="col mb-0">
																	<label class="col-form-label" for="html5-text-input" >PASSWORD</label>
																	<input type="text" class="form-control" id="data_PASSWORD" name="data_PASSWORD" maxlength="100">
																</div>
																<div class="col mb-0">
																	<label class="col-form-label" for="html5-text-input" >LOCATIONS</label>
																	<input type="text" class="form-control" id="data_LOCATIONS" name="data_LOCATIONS" >
																</div>
															</div>
															<div class="row g-2">
																<div class="col mb-0">
																	<label class="col-form-label" for="html5-text-input" >ROLE</label>
																	<input type="text" class="form-control" id="data_ROLE" name="data_ROLE" >
																</div>
																<div class="col mb-0">
																	<label class="col-form-label" for="html5-text-input" >NAME</label>
																	<input type="text" class="form-control" id="data_NAME" name="data_NAME" maxlength="255">
																</div>
															</div>
															<div class="row g-2">
																<div class="col mb-0">
																	<label class="col-form-label" for="html5-text-input" >EMAIL</label>
																	<input type="text" class="form-control" id="data_EMAIL" name="data_EMAIL" maxlength="65535">
																</div>
																<div class="col mb-0">
																	<label class="col-form-label" for="html5-text-input" >IMG</label>
																	<input type="text" class="form-control" id="data_IMG" name="data_IMG" maxlength="65535">
																</div>
															</div>
															<div class="row g-2">
																<div class="col mb-0">
																	<label class="col-form-label" for="html5-text-input" >IS_ALERT</label>
																	<input type="text" class="form-control" id="data_IS_ALERT" name="data_IS_ALERT" >
																</div>
														</div>
														<div class="modal-footer">
															<button type="button" class="btn btn-outline-secondary" data-bs-dismiss="modal">Close</button>
															<button type="button" class="btn btn-primary" name="modalSubmit" id="modalSubmit" data-modalurl="">저장</button>
														</div>
													</div>
												</form>
											</div>
										</div>
									</div>
								</div>
							</div>
						</div>						</div>
						
						<!--/ Responsive Table -->
					</div>
						<nav aria-label="Page navigation">
							
							<ul class="pagination justify-content-center">
							
							<c:if test="${PAGE.existFirstPage eq true }">
								<li class="page-item prev">
									<a class="page-link" href="javascript:void(0);" onclick="searchSubmit(${PAGE.firstPage })">
										<i class="tf-icon bx bx-chevrons-left"></i>
									</a>
								</li>
							</c:if>
							<c:if test="${PAGE.existPrevPage eq true }">
								<li class="page-item prev">
									<a class="page-link" href="javascript:void(0);" onclick="searchSubmit(${PAGE.beginPage - 1 })">
										<i class="tf-icon bx bx-chevron-left"></i>
									</a>
								</li>
							</c:if>
							
							<c:forEach var="idx" begin="${PAGE.beginPage }" end="${PAGE.endPage }">
							
								<li class="page-item <c:out value="${PAGE.page eq idx ? 'active' : '' }"/>">
									<a class="page-link" href="javascript:void(0);" onclick="searchSubmit(${idx })">${idx }</a>
								</li>
							
							</c:forEach>
							
							<c:if test="${PAGE.existNextPage eq true }">
								<li class="page-item next">
									<a class="page-link" href="javascript:void(0);" onclick="searchSubmit(${PAGE.endPage + 1 })">
										<i class="tf-icon bx bx-chevron-right"></i>
									</a>
								</li>
							</c:if>
							<c:if test="${PAGE.existLastPage eq true }">
								<li class="page-item next">
									<a class="page-link" href="javascript:void(0);" onclick="searchSubmit(${PAGE.lastPage })">
										<i class="tf-icon bx bx-chevrons-right"></i>
									</a>
								</li>
							</c:if>
							</ul>
						</nav>
					
					
			<!-- / Content -->

					<c:import url="../../include/footer.jsp" />

					<div class="content-backdrop fade"></div>
					<div class="spinner-border spinner-border-lg text-primary" role="status"><span class="visually-hidden">Loading...</span></div>
				</div>
				<!-- Content wrapper -->
			</div>
			
			<!-- / Layout page -->
		</div>

		<!-- Overlay -->
		<div class="layout-overlay layout-menu-toggle"></div>
	</div>
	<!-- / Layout wrapper -->

	<script>
	var castName = "users";
	
	var listSum = 0;
	$(document).ready(function() {
		
		// 검색조건 저장
		setLocalStorage(castName);
		// 페이지 접근시 실행
		//var pageResult = "${result}";
		//console.log("pageResult : " + pageResult);
		//if("${result}" == "") searchSubmit(1);
		//search(1);

	});

// 검색	
	var total = "${TOTAL }";
	console.log("TOTAL : " + total);
	
	</script>
</body>
	
</html>
