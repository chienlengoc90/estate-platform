<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@include file="/common/taglib.jsp"%>
		<c:url var="formUrl" value="/admin/user/list" />
		<c:url var="formAjax" value="/ajax/users" />
		<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
		<html>

		<head>
			<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
			<title>
				<spring:message code="Label.NewsList" text="News List" />
			</title>
		</head>

		<body>
			<div class="main-content">
				<form:form commandName="model" action="${formUrl}" id="listForm" method="GET">
					<div class="main-content-inner">
						<div class="breadcrumbs" id="breadcrumbs">
							<script type="text/javascript">
								try {
									ace.settings.check('breadcrumbs', 'fixed')
								} catch (e) {}
							</script>

							<ul class="breadcrumb">
								<li>
									<i class="ace-icon fa fa-home home-icon"></i>
									<a href="<c:url value="/admin/home"/>">
										<spring:message code="Label.Home" text="Home" />
									</a>
								</li>
								<li class="active">
									<spring:message code="Label.NewsList" text="News List" />
								</li>
							</ul>
							<!-- /.breadcrumb -->
						</div>
						<div class="page-content">
							<div class="row">
								<div class="col-xs-12">
									<c:if test="${messageResponse!=null}">
										<div class="alert alert-block alert-${alert}">
											<button type="button" class="close" data-dismiss="alert">
												<i class="ace-icon fa fa-times"></i>
											</button>
											${messageResponse}
										</div>
									</c:if>
									<!-- PAGE CONTENT BEGINS -->
									<div class="row">
										<div class="col-xs-12">
											<div class="widget-box table-filter">
												<div class="widget-header">
													<h4 class="widget-title">
														<spring:message code="Label.Search" text="Search" />
													</h4>
													<div class="widget-toolbar">
														<a href="#" data-action="collapse">
															<i class="ace-icon fa fa-chevron-up"></i>
														</a>
													</div>
												</div>
												<div class="widget-body">
													<div class="widget-main">
														<div class="form-horizontal">
															<div class="form-group">
																<label class="col-sm-2 control-label">
																	<spring:message code="Label.Search.UserName" text="User Name" />
																</label>
																<div class="col-sm-8">
																	<div class="fg-line">
																		<form:input path="userName" cssClass="form-control input-sm" />
																	</div>
																</div>
															</div>
															<div class="form-group">
																<label class="col-sm-2 control-label"></label>
																<div class="col-sm-8">
																	<button id="btnSearch" type="button" class="btn btn-sm btn-success">
																		<spring:message code="Label.Search" text="Search" />
																		<i class="ace-icon fa fa-arrow-right icon-on-right bigger-110"></i>
																	</button>
																</div>
															</div>
														</div>
													</div>
												</div>
											</div>
											<div class="table-btn-controls">
												<div class="pull-right tableTools-container">
													<div class="dt-buttons btn-overlap btn-group">
														<a flag="info" class="dt-button buttons-colvis btn btn-white btn-primary btn-bold" data-toggle="tooltip" title='<spring:message code="Label.New.Add" text="Add new post"/>'
														    href='<c:url value="/admin/user/edit"/>'>
															<span>
																<i class="fa fa-plus-circle bigger-110 purple"></i>
															</span>
														</a>
														<button id="btnDelete" type="button" disabled class="dt-button buttons-html5 btn btn-white btn-primary btn-bold" data-toggle="tooltip"
														    title="Xóa bài viết" onclick="warningBeforeDelete()">
															<span>
																<i class="fa fa-trash-o bigger-110 pink"></i>
															</span>
														</button>
													</div>
												</div>
											</div>
										</div>
									</div>
									<div class="row">
										<div class="col-xs-12">
											<div class="table-responsive">
												<display:table name="model.listResult" cellspacing="0" cellpadding="0" requestURI="${formUrl}" partialList="true" sort="external"
												    size="${model.totalItems}" defaultsort="2" defaultorder="ascending" id="tableList" pagesize="${model.maxPageItems}"
												    export="false" class="table table-fcv-ace table-striped table-bordered table-hover dataTable no-footer" style="margin: 3em 0 1.5em;">
													<display:column title="<fieldset class='form-group'>
												        <input type='checkbox' id='checkAll' class='check-box-element'>
												        </fieldset>" class="center select-cell" headerClass="center select-cell">
														<fieldset>
															<input type="checkbox" name="checkList" value="${tableList.id}" id="checkbox_${tableList.id}" class="check-box-element" />
														</fieldset>
													</display:column>
													<display:column headerClass="text-left" property="userName" title="Tên" />

													<display:column headerClass="text-left" property="fullName" title="full name" />
													<display:column headerClass="text-left" property="email" title="email" />
													<display:column headerClass="text-left" property="phoneNumber" title="phone Number" />
													<display:column headerClass="text-left" property="status" title="status" />
													<display:column headerClass="col-actions" title="Thao tác" >
														<a class="btn btn-sm btn-primary btn-edit" data-toggle="tooltip" title="Cập nhật user" href='<c:url value="/admin/user/edit/${tableList.id}"/>'>
															<i class="fa fa-pencil-square-o" aria-hidden="true"></i>
														</a>
														<!--  PHIỀN QUÁ NÊN BỎ LUÔN :D:D:D
														<a class="btn btn-sm btn-danger btn-cancel" data-toggle="tooltip" title='<spring:message code="Label.User.Delete" text="Delete User"/>'>
															<i class="fa fa-trash" aria-hidden="true"></i>
														</a>
														-->
													</display:column>
												</display:table>
											</div>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
				</form:form>
			</div>

			<script type="text/javascript">
				$(document).ready(function () {
					var someJsVar = "<c:out value='${addOrEditNews}'/>";
					$('#btnSearch').click(function () {
						$('#listForm').submit();
					});
					bindEventCheckAllCheckBox('checkAll');
					enableOrDisableDeleteAll();
					autoCheckCheckboxAll('checkAll');
				});

				function warningBeforeDelete() {
					showAlertBeforeDelete(function () {
						event.preventDefault();
						var totalchecked = $('input[type=checkbox]:checked').length;
						var dataArray = $('tbody input[type=checkbox]:checked').map(function () {
							return $(this).val();
						}).get();
						deleteNews(dataArray);
					});
				}

				function bindEventCheckAllCheckBox(id) {
					$('#' + id).on('change', function () {
						if ((this).checked) {
							$(this).closest('table').find('input[type=checkbox]').prop('checked', true);
						} else {
							$(this).closest('table').find('input[type=checkbox]').prop('checked', false);
							$('#btnDelete').prop('disabled', true);
						}
					});
				}

				function enableOrDisableDeleteAll() {
					$('input[type=checkbox]').click(function () {
						if ($('input[type=checkbox]:checked').length > 0) {
							$('#btnDelete').prop('disabled', false);
						} else {
							$('#btnDelete').prop('disabled', true);
						}
					});
				}

				function autoCheckCheckboxAll(id) {
					var totalCheckbox = $('#' + id).closest('table').find('tbody input[type=checkbox]').length;
					$('#' + id).closest('table').find('tbody input[type=checkbox]').each(function () {
						var tableObj = $('#' + id).closest('table');
						$(this).on('change', function () {
							var totalCheckboxChecked = $(tableObj).find('tbody input[type=checkbox]:checked').length;
							if (totalCheckboxChecked == totalCheckbox) {
								$('#' + id).prop('checked', true);
							} else {
								$('#' + id).prop('checked', false);
							}
						});
					});
				}

				function deleteNews(data) {
					$.ajax({
						url: '${formAjax}/',
						type: 'DELETE',
						dataType: 'json',
						contentType: 'application/json',
						data: JSON.stringify(data),
						success: function (res) {
							location.reload();
						},
						error: function (res) {
							console.log(res);
							$('#listForm').submit();
						}
					});
				}
			</script>
		</body>

		</html>