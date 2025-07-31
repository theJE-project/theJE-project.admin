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
							<span class="text-muted fw-light">테이블</span> media
						</h4>
						
						<div class="row">
						<!-- Basic Buttons -->
							<div class="col-12">
								<div class="card mb-4">
									<div class="card-header">
									
									<form id="searchForm" name="searchForm" action="/table/media/list" method="post">
								
										<div style="width:auto; float: left;">
											<select id="searchType" name="searchType" class="select2 form-select">
												<option value="ID" selected="selected">ID</option>
												<option value="BOARD">BOARD</option>
												<option value="BOARD_TYPE">BOARD_TYPE</option>
												<option value="TYPE">TYPE</option>
												<option value="URL">URL</option>
												<option value="IS_MAIN">IS_MAIN</option>
												<option value="CREATED_AT">CREATED_AT</option>
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
												<option value="CREATED_AT">CREATED_AT</option>
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
										<button type="button" class="btn btn-secondary" id="searchClear" data-reset="media">
											<span class="tf-icons bx bx-reset"></span>&nbsp; 리셋
			                            </button>
			                            <button type="button" class="btn btn-info" data-url="/table/media/add" data-type="add"
			                            	data-bs-toggle="modal" data-bs-target="#modalData">
											<span class="tf-icons bx bx-plus"></span>&nbsp; 등록
			                            </button>
			                            <button type="button" class="btn btn-danger" data-url="/table/media/remove">
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
													<th class="center">board</th>
													<th class="center">board_type</th>
													<th class="center">type</th>
													<th class="center">url</th>
													<th class="center">is_main</th>
													<th class="center">created_at</th>
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
														<a href="#" class="link_modal green" data-url="/table/media/detail" data-modaltype="detail"
															data-detailkey="id" data-detailvalue="${entry.id}"
															data-bs-toggle="modal" data-bs-target="#modalData">${entry.id}</a>
													</td>
													<td class="center">${entry.board}</td>
													<td class="center">${entry.board_type}</td>
													<td class="center">${entry.type}</td>
													<td class="center">${entry.url}</td>
													<td class="center">${entry.is_main}</td>
													<td class="date">${entry.created_at}</td>
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
													<th class="center">BOARD</th>
													<th class="center">BOARD_TYPE</th>
													<th class="center">TYPE</th>
													<th class="center">URL</th>
													<th class="center">IS_MAIN</th>
													<th class="center">CREATED_AT</th>
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
													<td class="center">${entry.board}</td>
													<td class="center">${entry.board_type}</td>
													<td class="center">${entry.type}</td>
													<td class="center">${entry.url}</td>
													<td class="center">${entry.is_main}</td>
													<td class="date">${entry.created_at}</td>
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
															<h5 class="modal-title" id="modal-title"><sapn id="modalTitle">media</sapn></h5>
															<button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close" ></button>
														</div>
														<div class="modal-body">
															<div class="row g-2">
																<div class="col mb-0">
																	<label class="col-form-label" for="html5-text-input" >ID</label>
																	<input type="text" class="form-control" id="data_ID" name="data_ID" >
																</div>
																<div class="col mb-0">
																	<label class="col-form-label" for="html5-text-input" >BOARD</label>
																	<input type="text" class="form-control" id="data_BOARD" name="data_BOARD" >
																</div>
															</div>
															<div class="row g-2">
																<div class="col mb-0">
																	<label class="col-form-label" for="html5-text-input" >BOARD_TYPE</label>
																	<input type="text" class="form-control" id="data_BOARD_TYPE" name="data_BOARD_TYPE" >
																</div>
																<div class="col mb-0">
																	<label class="col-form-label" for="html5-text-input" >TYPE</label>
																	<input type="text" class="form-control" id="data_TYPE" name="data_TYPE" >
																</div>
															</div>
															<div class="row g-2">
																<div class="col mb-0">
																	<label class="col-form-label" for="html5-text-input" >URL</label>
																	<input type="text" class="form-control" id="data_URL" name="data_URL" maxlength="65535">
																</div>
																<div class="col mb-0">
																	<label class="col-form-label" for="html5-text-input" >IS_MAIN</label>
																	<input type="text" class="form-control" id="data_IS_MAIN" name="data_IS_MAIN" >
																</div>
															</div>
															<div class="row g-2">
																<div class="col mb-0">
																	<label class="col-form-label" for="html5-text-input" >CREATED_AT</label>
																	<input type="text" class="form-control date" id="data_CREATED_AT" name="data_CREATED_AT"  disabled="disabled">
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
	var castName = "media";
	
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
