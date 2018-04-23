<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ include file="/WEB-INF/pages/comm/comm.jsp"%>
<section class="content-header">
	<h1>
		修改密码 <small></small>
	</h1>
	<ol class="breadcrumb">
		<li><a href="#"><i class="fa"><img
					src="${context}/static/dist/img/home_ico.png" width="10" height="10">
			</i>首页</a></li>
		<li class="">个人中心</li>
		<li class="active">修改密码</li>
	</ol>
</section>
<!-- Main content -->
<section class="content">

	<div class="row">
		<div class="col-md-12">
			<div class="box box-primary">
				<div class="box-body" style="min-height: 600px;padding-top: 50px;">

					<form class="form-horizontal" id="" action=""
						accept-charset="UTF-8" method="post">
						<div class="form-body">
							<div class="form-group">
								<label class="control-label col-xs-2"> <label >旧密码:</label>
								</label>
								<div class="col-xs-6">
									<input class="form-control" value="" name="oldpwd" id="" type="password">
								</div>
							</div>
							<div class="form-group">
								<label class="control-label col-xs-2"> <label >新密码:</label>
								</label>
								<div class="col-xs-6">
									<input class="form-control" value="" name="password" id="" type="password">
								</div>
							</div>
							<div class="form-group">
								<label class="control-label col-xs-2"> <label >确认新密码:</label>
								</label>
								<div class="col-xs-6">
									<input class="form-control" value="" name="querenpwd" id="" type="password">
								</div>
							</div>
							<div class="modal-footer text-center">
								<button type="button" class="btn btn-primary"
									data-dismiss="modal" onclick="editpwd()">确认修改</button>
							</div>
						</div>
					</form>

				</div>
				<!-- /.box -->
			</div>
			<!-- /.col -->
		</div>
</section>
<script type="text/javascript">
	function editpwd(){
		var newpwd = $("input[name=password]").val();
		var qrpwd = $("input[name=querenpwd]").val();
		var oldpwd = $("input[name=oldpwd]").val();
// 		if(!/^(?!\D+$)(?![^a-zA-Z]+$)\S{10,20}$/.test(newpwd)){
// 			layer.msg("密码必须包含数字、字母、特殊字符且长度为10-20");
// 			return false
// 		}
		if(newpwd != qrpwd){
			layer.msg("两次输入密码不一致");
			return false;
		}
		$.ajax({
			url:'${context}/personal/updpwd',
			type:'post',
			data:{newpwd:newpwd,oldpwd:oldpwd},
			dataType:'json',
			success:function(data){
				layer.msg(data.msg);
				if(data.code == 200){
				setTimeout(
					function(){
					queryresult()
					top.layer.closeAll();
					},1500);
				}
			}
		})		
	}
</script>