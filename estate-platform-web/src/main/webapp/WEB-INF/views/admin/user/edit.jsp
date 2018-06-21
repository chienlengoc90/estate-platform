<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/common/taglib.jsp"%>
<c:url var="formUrl" value="/ajax/users"/>
<html>
<head>
    <title>Chỉnh sửa người dùng</title>
</head>
<body>
<div class="main-content">
    <div class="main-content-inner">
        <div class="breadcrumbs" id="breadcrumbs">
            <script type="text/javascript">
                try{ace.settings.check('breadcrumbs' , 'fixed')}catch(e){}
            </script>
            <ul class="breadcrumb">
                <li>
                    <i class="ace-icon fa fa-home home-icon"></i>
                    <a href="#">Trang chủ</a>
                </li>
                <li class="active">Chỉnh sửa người dùng</li>
            </ul><!-- /.breadcrumb -->
        </div>
        <div class="page-content">
            <div class="row">
                <div class="col-xs-12">
                    <c:if test="${not empty messageResponse}">
                        <div class="alert alert-block alert-${alert}">
                            <button type="button" class="close" data-dismiss="alert">
                                <i class="ace-icon fa fa-times"></i>
                            </button>
                                ${messageResponse}
                        </div>
                    </c:if>
                    <form:form id="formEdit" commandName="model">
                    	<div class="form-group">
                            <label class="col-sm-3 control-label no-padding-right">Vai trò</label>
                            <div class="col-sm-9">
                            <c:if test="${empty model.id}">
                            	<form:select path="roleCode" id="roleCode">                            	                   	
	    							<form:options items="${model.roleDTOs}" />
								</form:select>
                            </c:if>
                            <c:if test="${not empty model.id}">
	                            <form:select path="roleCode" id="roleCode">  
	                            	<form:option value="${model.roleName}"/>                          	
	    							<form:options items="${model.roleDTOs}" />
								</form:select>
                            </c:if>
                            </div>
                        </div>
                        <br/>
                        <br/>
                        <div class="form-group">
                            <label class="col-sm-3 control-label no-padding-right">User Name</label>
                            <div class="col-sm-9">
                            	<!-- path bao gồm name và value -->
                                <form:input path="userName" id="userName"/>
                            </div>
                        </div>
                        <br/>
                        <br/>
                        <div class="form-group">
                            <label class="col-sm-3 control-label no-padding-right">Password</label>
                            <div class="col-sm-9">
                                <form:password path="password" id="password"/>
                            </div>
                        </div>
                        <br/>
                        <br/>
                        <div class="form-group">
                            <label class="col-sm-3 control-label no-padding-right">Full Name</label>
                            <div class="col-sm-9">
                                <form:input path="fullName" id="fullName"/>
                            </div>
                        </div>
                        <br/>
                        <br/>
                        <div class="form-group">
                            <label class="col-sm-3 control-label no-padding-right">Email</label>
                            <div class="col-sm-9">
                                <form:input path="email" id="email"/>
                            </div>
                        </div>
                        <br/>
                        <br/>
                        <div class="form-group">
                            <label class="col-sm-3 control-label no-padding-right">Phone Number</label>
                            <div class="col-sm-9">
                                <form:input path="phoneNumber" id="phoneNumber"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="col-sm-12">
                            	<c:if test="${not empty model.id}">
                        			<input type="button" class="btn btn-white btn-warning btn-bold" value="Cập nhật người dùng" id="btnAddOrUpdateUsers"/>
                        		</c:if>
                        		<c:if test="${empty model.id}">
                        			<input type="button" class="btn btn-white btn-warning btn-bold" value="Thêm mới người dùng" id="btnAddOrUpdateUsers"/>
                        		</c:if>
                            </div>
                        </div>
                        <form:hidden path="id" id="userId"/>
                    </form:form>
                </div>
            </div>
        </div>
    </div>
</div>
<script>
	/* var editor = '';
	$(document).ready(function () {
	    editor = CKEDITOR.replace( 'newsDescription' );
	    CKFinder.setupCKEditor( editor, '${pageContext.request.contextPath}/ckfinder/' );
	    $('#uploadImage').change(function () {
            readURL(this, "viewImage");
        });
	});
	function readURL(input, imageId) {
        if (input.files && input.files[0]) {
            var reader = new FileReader();
            reader.onload = function (e) {
                $('#' +imageId).attr('src', reader.result);
            }
            reader.readAsDataURL(input.files[0]);
        }
    }
	 */
	$("#btnAddOrUpdateUsers").click(function (event) {     
		event.preventDefault();
        var dataArray = {};
        dataArray["roleCode"] = $('#roleCode').val();
        dataArray["userName"] = $('#userName').val();
        dataArray["password"] = $('#password').val();
        dataArray["fullName"] = $('#fullName').val();
        dataArray["email"] = $('#email').val();
        dataArray["phoneNumber"] = $('#phoneNumber').val();
        if ($('#userId').val() != "") {
        	updateNews(dataArray, $('#userId').val());
        }
        else{
        	addNews(dataArray);
        }
    });
    function addNews(data) {
        $.ajax({
            url: '${formUrl}',
            type: 'POST',
            dataType: 'json',
            contentType:'application/json',
            data: JSON.stringify(data),
            success: function(res) {
                window.location.href = "<c:url value='/admin/user/list'/>";
            },
            error: function(res) {
                console.log(res);                	
            }
        });
    }
    function updateNews(data, id) {
        $.ajax({
            url: '${formUrl}/'+id,
            type: 'PUT',
            dataType: 'json',
            contentType:'application/json',
            data: JSON.stringify(data),
            success: function(res) {
                window.location.href = "<c:url value='/admin/user/"+res.id+"'/>";
            },
            error: function(res) {
                console.log(res);                	
            }
        });
    }
</script>
</body>
</html>
