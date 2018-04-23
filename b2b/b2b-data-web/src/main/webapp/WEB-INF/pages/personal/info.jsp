<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ include file="/WEB-INF/pages/comm/comm.jsp"%>
<!-- Content Header (Page header) -->
<section class="content-header">
	<h1>
		个人资料 <small></small>
	</h1>
	<ol class="breadcrumb">
		<li><a href="#"><i class="fa"><img
					src="${context}/static/dist/img/home_ico.png" width="10"
					height="10"></i>首页</a></li>
		<li class="">个人中心</li>
		<li class="active">个人资料</li>
	</ol>
</section>
<!-- Main content -->
<section class="content">

	<div class="row">
		<div class="col-md-12">
			<div class="box box-primary">
				<div class="box-body" style="min-height: 600px; padding-top: 50px;">

					<form class="form-horizontal" id="sysuser" action=""
						accept-charset="UTF-8" method="post">
						<div class="form-body">
							<div class="form-group">
								<label class="control-label col-xs-2"> <label>工号:</label>
								</label>
								<div class="col-xs-6">
									<%-- 												<input class="form-control" value="${sysuser.workId}" name="name" id="" type="text"> --%>
									<p class="form-control-static">${sysuser.workId}</p>
								</div>
							</div>
							<div class="form-group">
								<label class="control-label col-xs-2"> <label>姓名:</label>
								</label>
								<div class="col-xs-6">
									<%-- 												<input class="form-control" value="${sysuser.username}" name="name" id="" type="text"> --%>
									<p class="form-control-static">${sysuser.username}</p>
								</div>
							</div>
							<div class="form-group">
								<label class="control-label col-xs-2"> <label>性别:</label>
								</label>
								<div class="col-xs-6">
									<%-- 												<input class="form-control" value="${sysuser.sex}" name="name" id="" type="text"> --%>
									<p class="form-control-static">${sysuser.sex}</p>
								</div>
							</div>
							<div class="form-group">
								<label class="control-label col-xs-2"> <label>手机号码（可修改）:</label>
								</label>
								<div class="col-xs-6">
									<input class="form-control" value="${sysuser.phone}"
										name="phone" id="" type="text">
									<%-- 												<p class="form-control-static">${sysuser.phone}</p> --%>
								</div>
							</div>
							<div class="form-group">
								<label class="control-label col-xs-2"> <label>邮件（可修改）:</label>
								</label>
								<div class="col-xs-6">
									<input class="form-control" value="${sysuser.email}"
										name="email" id="" type="text">
									<%-- 												<p class="form-control-static">${sysuser.email}</p> --%>
								</div>
							</div>
							<div class="form-group">
								<label class="control-label col-xs-2"> <label>科室:</label>
								</label>
								<div class="col-xs-6">
									<p class="form-control-static">${sysuser.dept.name}</p>
								</div>
							</div>
							<div class="form-group">
								<label class="control-label col-xs-2"> <label>上级领导:</label>
								</label>
								<div class="col-xs-6">
									<p class="form-control-static">${sysuser.parentWorkId}</p>
								</div>
							</div>
							<div class="form-group">
								<label class="control-label col-xs-2"> <label>用户角色:</label>
								</label>
								<div class="col-xs-6">
									<p class="form-control-static">
										<c:forEach items="${sysuser.roles}" var="rol">
											<span> ${rol.name} </span>
										</c:forEach>
									</p>
								</div>
							</div>
							<div class="modal-footer text-center">
								<button type="button" class="btn btn-primary"
									onclick="editperson()" data-dismiss="modal">保存</button>
							</div>
						</div>
						<input name="id" value="${sysuser.id}" type="hidden" />
					</form>


				</div>
				<!-- /.box -->
			</div>
			<!-- /.col -->
		</div>
</section>
<script type="text/javascript">
	function editperson(){
		var email = $("input[name=email]").val();
		var phone = $("input[name=phone]").val();
		if(email == null || email == ''){
			layer.msg('邮件不能为空');
			return false;
		}
		if(phone == null || phone == ''){
			layer.msg('手机号不能为空');
			return false;
		}
		if(!/^1[3-9]\d{9}$/.test(phone)){
			layer.msg("手机号格式不正确");
			return false;
		}
		$.ajax({
			url:'${context}/personal/update',
			type:'post',
			data:$("#sysuser").serialize(),
			dataType:'json',
			success:function(data){
				layer.msg(data.msg);
				if(data.code == 200){
				setTimeout(
					reload()
					,1500);
				}
			}
		})	
	}
		function reload(){
			$.ajax({
				url:'${context}/personal/info',
				type:'post',
				data:{},
				dataType:'html',
				success:function(data){
					 $(".content-wrapper").html(data);
				}
			})
		
		}
</script>