<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ include file="/WEB-INF/pages/comm/comm.jsp"%>
<section class="content-header">
	<h1>
		快递管理 <small></small>
	</h1>
	<ol class="breadcrumb">
		<li><a href="#"><i class="fa"><img
					src="${context}/static/dist/img/home_ico.png" width="10"
					height="10"></i>首页</a></li>
		<!--<li>快递管理</li>-->
		<li class="active">快递管理</li>
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

				<form class="form-inline" id="sysform" onkeydown="if(event.keyCode==13){return false;}">
					<div class="box-body">

						<div class="form-group">
							<label>快递：</label> <input class="form-control"
								value="${expressName}" name="expressName" id="" placeholder=""
								type="text">
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
						<a class="btn btn-primary" onclick="openwindow()" href="#"
							role="button" id="backuser-add">添加快递</a>
					</p>

					<table class="table table-bordered">
						<tbody>
							<tr>
								<th>编号</th>
								<th>代码</th>
								<th>快递</th>
								<th>网址</th>
								<th>状态</th>
								<th>操作</th>
							</tr>
							<c:forEach items="${page.results}" var="sys">
								<tr>
									<td>${sys.id}</td>
									<td>${sys.code}</td>
									<td>${sys.name}</td>
									<td><a href="${sys.link}" target="_blank" >${sys.link}</a></td>
									<td>${sys.isActive ? '启用':'禁用'}</td>
									<td style="width: 290px;">
										<a href="#" class="btn btn-primary btn-xs" onclick="${sys.isActive ? 'openFlagwindow':'editFlag'}('${sys.code}','${sys.isActive ? 2:1}')"	id="disabled">${sys.isActive ?'禁用':'启用'}</a>
<%-- 										<a href="#" class="btn btn-primary btn-xs" id="student-mm" onclick="openwindow('${sys.code}')">编辑</a> --%>
										 <!-- <a href="#" class="btn btn-primary btn-sm" id="delete">删除</a> -->
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
									<label class="control-label col-xs-4"> <label>代码:</label>
									</label>
									<div class="col-xs-8">
										<input class="form-control" name="addexpressCode" type="text">
									</div>
								</div>
								<div class="form-group">
									<label class="control-label col-xs-4"> <label>快递:</label>
									</label>
									<div class="col-xs-8">
										<input class="form-control" name="addexpressName" type="text">
									</div>
								</div>
								<div class="form-group">
									<label class="control-label col-xs-4"> <label>网址:</label>
									</label>
									<div class="col-xs-8">
										<input class="form-control" name="addexpressLink" type="text">
									</div>
								</div>
							</div>
						</form>

					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-primary" onclick="expressadd()">确定</button>
						<button type="button" class="btn btn-default"
							onclick="top.layer.closeAll()">取消</button>
					</div>

				</div>
				<!--student-mmcon end-->

				<!--disabled st-->
				<div id="disabledcon" style="display: none;">
					<div class="modal-body">
						<p style="text-align: center;">禁用用户以后，该用户将不能正常访问本系统。确定是否禁用？</p>

					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-primary">禁用</button>
						<button type="button" class="btn btn-default"
							onclick="top.layer.closeAll()">取消</button>
					</div>

				</div>
			</div>
		</div>
	</div>

</section>
<!-- /.content -->
<script type="text/javascript">
$(function() {
    document.onkeydown = function(e) {
        e = e || event;
        var code = -1;
        code = e.keyCode || e.which || e.charCode;
        if (code == 13) {
            queryResult();
        }
    };
});
	function queryResult(){
		$.ajax({
			url:'${context}/systemmanage/express/querybypage',
			type:'post',
			data:$("#sysform").serialize(),
			dataType:'html',
			success:function(data){
				$(".content-wrapper").html(data);
			}
		})
	}
	//打开
	function openwindow(){
		//初始化打开清空文本框
		 $("input[name=addexpressCode]").val('');
		 $("input[name=addexpressName]").val('');
		 $("input[name=addexpressLink]").val('');
		layer.open({
			title: '添加快递',
			type: 1,
			skin: 'layui-layer-rim', //加上边框
			area: ['400px', 'auto'], //宽高
			content: $('#student-mmcon')
		});
	}

	function expressadd(){
		var expressCode = $("input[name=addexpressCode]").val();
		var expressName = $("input[name=addexpressName]").val();
		var expressLink = $("input[name=addexpressLink]").val();
		$.ajax({
			url:'${context}/systemmanage/express/add',
			type:'post',
			data:{expressCode:expressCode,expressName:expressName,expressLink:expressLink},
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
	function openFlagwindow(id,flag){
			layer.open({
				title: '',
				type: 1,
				skin: 'layui-layer-rim', //加上边框
				area: ['300px', 'auto'], //宽高
				content: $('#disabledcon')
			});
			$("#disabledcon").find("button:first").attr("onclick","editFlag('"+id+"','"+flag+"')");
	}
	
	function editFlag(obj,flag){
		$.ajax({
			url:'${context}/systemmanage/express/editFlag',
			type:'post',
			data:{suId:obj,flag:flag},
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
	
</script>