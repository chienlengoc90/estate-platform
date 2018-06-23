<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
	<%@include file="/common/taglib.jsp" %>

		<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
		<html lang="en">

		<head>
			<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
			<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
			<title>
				<dec:title default="Admin Page" />
			</title>

			<meta name="description" content="overview &amp; stats" />
			<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0" />
			<!-- jquery -->
			<script type='text/javascript' src='<c:url value="/template/admin/js/2.1.4/jquery.min.js" />'></script>
			<script type='text/javascript' src='<c:url value="/template/admin/js/jquery.validate.min.js" />'></script>

			<link rel="stylesheet" href="<c:url value='/template/admin/assets/font-awesome/4.2.0/css/font-awesome.min.css' />" />
			<link rel="stylesheet" href="<c:url value='/template/admin/assets/fonts/fonts.googleapis.com.css' />" />

			<link rel="stylesheet" href="<c:url value='/template/admin/assets/css/bootstrap.min.css' />" />
			<link rel="stylesheet" href="<c:url value='/template/admin/font-awesome/4.5.0/css/font-awesome.min.css' />" />
			<link rel="stylesheet" href="<c:url value='/template/admin/assets/css/ace.min.css' />" class="ace-main-stylesheet" id="main-ace-style"/>
			<link rel="stylesheet" href="https://ajax.googleapis.com/ajax/libs/jqueryui/1.11.4/themes/smoothness/jquery-ui.css">
			<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">

			<%--datatable css--%>
			<link href="<c:url value=" /template/admin/data-table/media/css/dataTables.bootstrap4_v4.6.1.min.css "/>" rel="stylesheet">

			<%--ckeditor plugin--%>
			<script type="text/javascript" src="<c:url value=" /ckeditor/ckeditor.js "/>"></script>

			<%--ckfinder--%>
			<script type="text/javascript" src="<c:url value=" /ckfinder/ckfinder.js "/>"></script>

			<%--sweetalert css--%>
			<link rel="stylesheet" href="<c:url value=" /template/admin/assets/sweetalert2/sweetalert2.min.css "/>">

		</head>

		<body class="no-skin">
			<!-- Header -->
			<%@ include file="/common/admin/header.jsp" %>
			<!-- End Header -->

			<div class="main-container ace-save-state" id="main-container">

			<script type="text/javascript">
				try {
					ace.settings.loadState('main-container')
				} catch (e) {}
			</script>

			<!-- Begin menu -->
			<%@ include file="/common/admin/menu.jsp" %>
			<!-- End menu -->

			<!-- Begin body -->
			<dec:body/>
			<!-- End body -->

			<!-- Begin footer -->
			<%@ include file="/common/admin/footer.jsp" %>
			<!-- end footer -->

			<a href="#" id="btn-scroll-up" class="btn-scroll-up btn btn-sm btn-inverse">
				<i class="ace-icon fa fa-angle-double-up icon-only bigger-110"></i>
			</a>

			</div>

			<script src="<c:url value='/template/admin/assets/js/ace-extra.min.js' />"></script>
			<script src="<c:url value='/template/admin/assets/js/jquery-ui.custom.min.js' />"></script>
			<script src="<c:url value='/template/admin/assets/js/jquery.ui.touch-punch.min.js' />"></script>
			<script src="<c:url value='/template/admin/assets/js/jquery.easypiechart.min.js' />"></script>
			<script src="<c:url value='/template/admin/assets/js/jquery.sparkline.min.js' />"></script>
			<script src="<c:url value='/template/admin/assets/js/jquery.flot.min.js' />"></script>
			<script src="<c:url value='/template/admin/assets/js/jquery.flot.pie.min.js' />"></script>
			<script src="<c:url value='/template/admin/assets/js/jquery.flot.resize.min.js' />"></script>
			<script src="<c:url value='/template/admin/assets/js/bootstrap.min.js' />"></script>
			<script src="<c:url value='/template/admin/assets/js/ace-elements.min.js' />"></script>
			<script src="<c:url value='/template/admin/assets/js/ace.min.js' />"></script>
			<%--sweetalert js--%>
			<script type='text/javascript' src='<c:url value="/template/admin/assets/sweetalert2/sweetalert2.min.js"/>'></script>

			<%--datatable js--%>
			<script type="text/javascript" src="<c:url value=" /template/admin/data-table/data_table-1.0.0.js "/>"></script>
			<script type="text/javascript" src="<c:url value=" /template/admin/data-table/data-table-bootstrap4-1.0.0.js "/>"></script>

			<script type="text/javascript">
			function showAlertBeforeDelete(callback) {
				swal({
						title: "Bạn có chắc chắn?",
						text: "Một khi đã xóa thì không thể khôi phục lại!",
						type: "cảnh báo",
						//timer: 2000,
						showCancelButton: true,
						confirmButtonText: "Yes",
						cancelButtonText: "No",
						confirmButtonClass: "btn btn-success",
						cancelButtonClass: "btn btn-danger"
					})
					.then((result) => {
						if (result.value) {
							callback();
						}
					})
					.catch(swal.noop)
			}
			</script>
		</body>
	</html>