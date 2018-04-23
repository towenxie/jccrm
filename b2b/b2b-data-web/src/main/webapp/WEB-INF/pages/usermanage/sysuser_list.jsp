<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ include file="/WEB-INF/pages/comm/comm.jsp"%>
<section class="content-header">
	<h1>
		员工管理 <small></small>
	</h1>
	<ol class="breadcrumb">
		<li><a href="#"><i class="fa"><img
					src="${context}/static/dist/img/home_ico.png" width="10"
					height="10"></i>首页</a></li>
		<!--<li>员工管理</li>-->
		<li class="active">员工管理</li>
	</ol>
</section>
<!-- Main content -->
<section class="content">
	<div class="row">
		<!-- left column -->
		<div class="col-md-12">
			<!-- general form elements -->
			<div class="box box-primary">
				<!-- form start -->

				<form class="form-inline" id="sysform">
					<div class="box-body">

						<div class="form-group">
							<label>姓名：</label> <input class="form-control"
								value="${userName}" name="userName" id="" placeholder=""
								type="text">
						</div>
						<div class="form-group">
							<label>账号：</label> <input class="form-control" value="${workId}"
								name="workId" id="" placeholder="" type="text">
						</div>
						<div class="form-group">
							<label>科室：</label> <select class="form-control" name="deptCode">
								<option selected="" value="">科室</option>
								<c:forEach items="${depts}" var="d">
									<option ${d.code eq deptCode?'selected':''} value="${d.code}">${d.name}</option>
								</c:forEach>
							</select>
						</div>
						<div class="form-group">
							<label>角色：</label> <select class="form-control" name="roleCode">
								<option selected="" value="">角色</option>
								<c:forEach items="${roles}" var="r">
									<option ${r.code eq roleCode?'selected':''} value="${r.code}">${r.name}</option>
								</c:forEach>
							</select>
						</div>

						<input name="pageNo" type="hidden" id="pageNo"
							value="${page.pageNo}" />
						<button type="button" onclick="queryResult()"
							class="btn btn-primary">搜索</button>
					</div>
				</form>

			</div>
			<!-- /.box -->
		</div>
		<!--/.col (left) -->
	</div>

	<div class="clearfix"></div>
	<div class="row">
		<div class="col-md-12">
			<div class="box box-primary">
				<div class="box-body">
					<p>
						<a class="btn btn-primary" onclick="edituser('')" href="#"
							role="button" id="backuser-add">添加员工</a>
					</p>

					<table class="table table-bordered">
						<tbody>
							<tr>
								<th>工号</th>
								<th>姓名</th>
								<th>科室</th>
								<th>角色</th>
								<th>用户状态</th>
								<th>添加时间</th>
								<th>操作</th>
							</tr>
							<c:forEach items="${page.results}" var="sys">
								<tr>
									<td>${sys.workId}</td>
									<td>${sys.username}</td>
									<td>${sys.dept.name}</td>
									<td><c:forEach items="${sys.roles}" var="rol">
											<span> ${rol.name} </span>
										</c:forEach></td>

									<td>${sys.isActive ? '启用':'禁用'}</td>
									<td><fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss"
											value="${sys.created}" /></td>
									<td style="width: 290px;">
									   <a href="#" class="btn btn-primary btn-xs" onclick="openFlagwindow('${sys.id}')" id="disabled">删除</a> 
										<a href="#" class="btn btn-primary btn-xs" onclick="editFlag('${sys.workId}','${sys.isActive ? 2:1}')">${sys.isActive ?'禁用':'启用'}</a>
										 <a href="#"
										class="btn btn-primary btn-xs" id="student-view"
										onclick="userinfo('${sys.workId}')">查看</a> <a href="#"
										class="btn btn-primary btn-xs" id="student-bj"
										onclick="edituser('${sys.workId}')">编辑</a> <a href="#"
										class="btn btn-primary btn-xs" id="student-mm"
										onclick="openwindow('${sys.workId}')">重置密码</a> <!-- <a href="#" class="btn btn-primary btn-sm" id="delete">删除</a> -->
									</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
				<!-- /.box-body -->
				<div class="clearfix"></div>
				<div class="clearfix"></div>
				<%@include file="/WEB-INF/pages/comm/page.jsp"%>

				<!--用户信息-->
				<div id="student-viewcon" style="display: none;"></div>
				<!--student-viewcon end-->
				<!--student-mmcon st-->
				<div id="student-mmcon" style="display: none;">
					<div class="modal-body">
						<form class="form-horizontal" id="" action=""
							accept-charset="UTF-8" method="post">
							<div class="form-body">
								<div class="form-group">
									<label class="control-label col-xs-4"> <label>新密码:</label>
									</label>
									<div class="col-xs-8">
										<input class="form-control" name="password" type="password">
									</div>
									<input name="userId" id="userId" type="hidden" />
								</div>
								<div class="form-group">
									<label class="control-label col-xs-4"> <label>确认新密码:</label>
									</label>
									<div class="col-xs-8">
										<input class="form-control" name="querenpwd" type="password">
									</div>
								</div>
							</div>
						</form>

					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-primary" onclick="resetpwd()">确定</button>
						<button type="button" class="btn btn-default"
							onclick="top.layer.closeAll()">取消</button>
					</div>

				</div>
				<!--student-mmcon end-->

				<!--disabled st-->
				<div id="disabledcon" style="display: none;">
					<div class="modal-body">
						<p style="text-align: center;">是否删除？</p>

					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-primary">删除</button>
						<button type="button" class="btn btn-default"
							onclick="top.layer.closeAll()">取消</button>
					</div>

				</div>
				<!--delete end-->
				<!--backuser-addcon st-->
				<div id="backuser-addcon" style="display: none;">
					<div class="modal-body">
						<form class="form-horizontal" id="" action=""
							accept-charset="UTF-8" method="post">
							<div class="form-body">
								<div class="form-group">
									<label class="control-label col-xs-2"> <label><span
											class="red-text">*</span>账号:</label>
									</label>
									<div class="col-xs-4">

										<input class="form-control" value="" type="text">

									</div>
									<label class="control-label col-xs-2"> <label><span
											class="red-text">*</span>姓名:</label>
									</label>
									<div class="col-xs-4">
										<input class="form-control" id="" value="" type="text">
									</div>
								</div>

								<div class="form-group">
									<label class="control-label col-xs-2"> <label><span
											class="red-text">*</span>用户状态:</label>
									</label>
									<div class="col-xs-4">
										<select class="form-control">
											<option selected="" value="已启用">已启用</option>
											<option value="已禁用">已禁用</option>
										</select>
									</div>
									<label class="control-label col-xs-2"> <label>用户角色:</label>
									</label>
									<div class="col-xs-4">

										<select class="form-control">
											<option selected="" value="选择角色">选择角色</option>
										</select>
									</div>
								</div>

							</div>

						</form>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-primary">保存</button>
						<button type="button" class="btn btn-default">取消</button>
					</div>

				</div>
				<!--backuser-addcon end-->

			</div>
			<!-- /.box -->
		</div>
		<!-- /.col -->
	</div>

</section>
<!-- /.content -->
<script type="text/javascript">
	function queryResult(){
		$.ajax({
			url:'${context}/usermanage/querybypage',
			type:'post',
			data:$("#sysform").serialize(),
			dataType:'html',
			success:function(data){
				$(".content-wrapper").html(data);
			}
		})
	}
	//打开重置密码窗口
	function openwindow(objId){
		$('#userId').val(objId);
		//初始化打开清空文本框
		 $("input[name=password]").val('');
		 $("input[name=querenpwd]").val('');
		layer.open({
			title: '重置密码',
			type: 1,
			skin: 'layui-layer-rim', //加上边框
			area: ['400px', 'auto'], //宽高
			content: $('#student-mmcon')
		});
	}

	function resetpwd(){
		var newpwd = $("input[name=password]").val();
		var qrpwd = $("input[name=querenpwd]").val();
		var userId = $("#userId").val();
// 		if(!/^(?!\D+$)(?![^a-zA-Z]+$)\S{10,20}$/.test(newpwd)){
// 			layer.msg("密码必须包含数字、字母、特殊字符且长度为10-20");
// 			return false
// 		}
		if(newpwd != qrpwd){
			layer.msg("两次输入密码不一致");
			return false;
		}
		$.ajax({
			url:'${context}/usermanage/updpwd',
			type:'post',
			data:{workId:userId,newPassword:newpwd},
			dataType:'json',
			success:function(data){
				layer.msg(data.msg);
				if(data.code == 200){
				setTimeout(
					function(){
					 $("#userId").val('');
					top.layer.closeAll();
					},1500);
				}
			}
		})
	}
	function openFlagwindow(uid){
			layer.open({
				title: '',
				type: 1,
				skin: 'layui-layer-rim', //加上边框
				area: ['300px', 'auto'], //宽高
				content: $('#disabledcon')
			});
			$("#disabledcon").find("button:first").attr("onclick","removeRow('"+uid+"')");
	}
	function removeRow(uid){
	$.ajax({
		url:'${context}/usermanage/remove',
		type:'post',
		data:{uid:uid},
		dataType:'json',
		success:function(data){
		    layer.msg(data.msg);
		    if(data.code == 200){
		    setTimeout(
		        function(){
		        queryResult();
		        top.layer.closeAll();
		        },1500);
		    }
		}
	})
	}
	function editFlag(obj,flag){
		$.ajax({
			url:'${context}/usermanage/editFlag',
			type:'post',
			data:{suId:obj,flag:flag},
			dataType:'json',
			success:function(data){
				layer.msg(data.msg);
				if(data.code == 200){
				setTimeout(
					function(){
					queryResult();
					},1500);
				}
			}
		})
	}
	//编辑用户
	function edituser(objId){
		 $.ajax({
			url:'${context}/usermanage/updateInit',
			type:'post',
			data:{workId:objId},
			dataType:'html',
			success:function(data){
				layer.open({
					title: '员工信息',
					type: 1,
					skin: 'layui-layer-rim', //加上边框
					area: ['800px', '400'], //宽高
					content:data
				});
			}
		})
	}
	//用户信息
	function userinfo(objId){
		 $.ajax({
			url:'${context}/usermanage/details',
			type:'post',
			data:{id:objId},
			dataType:'html',
			success:function(data){
				$("#student-viewcon").html(data);
				layer.open({
					title: '员工信息',
					type: 1,
					skin: 'layui-layer-rim', //加上边框
					area: ['800px', 'auto'], //宽高
					content:$("#student-viewcon")
				});
			}
		})
	}
</script>