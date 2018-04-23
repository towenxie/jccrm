<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ include file="/WEB-INF/pages/comm/comm.jsp"%>
<section class="content-header">
	<h1>
		库存管理 <small></small>
	</h1>
	<ol class="breadcrumb">
		<li><a href="#"><i class="fa"><img
					src="${context}/static/dist/img/home_ico.png" width="10"
					height="10"></i>首页</a></li>
		<!--<li>库存管理</li>-->
		<li class="active">库存管理</li>
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
							<label>批号：</label> <input class="form-control"
								value="${batchNumber}" name="batchNumber" id="" placeholder=""
								type="text">
						</div>
						<div class="form-group">
							<label>商品编号：</label> <input class="form-control" value="${goodsNumber}"
								name="goodsNumber" id="" placeholder="" type="text">
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
						<a class="btn btn-primary" onclick="addInit('')" href="#"
							role="button" id="backuser-add">登记入库</a>
					</p>

					<table class="table table-bordered">
						<tbody>
							<tr>
								<th>批号</th>
								<th>商品编号</th>
								<th>名称	</th>
								<th>库存</th>
								<th>保质期(天)</th>
								<th>生产日期</th>
<!-- 								<th>状态</th> -->
								<th>添加时间</th>
								<th>操作</th>
							</tr>
							<c:forEach items="${page.results}" var="sys">
								<tr>
									<td>${sys.batchNumber}</td>
									<td>
									<a onclick="goodsinfo('${sys.goodsNumber}')" href="#" role="button" id="backuser-add">${sys.goodsNumber}</a>
									</td>
									<td>${sys.goodsName}</td>
									<td>${sys.stockNum}</td>
									<td>${sys.saveDays}</td>
									<td>${sys.productDate}</td>
<%-- 									<td>${sys.isActive ? '启用':'禁用'}</td> --%>
									<td><fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss"
											value="${sys.created}" /></td>
									<td style="width: 100px;">
<%-- 										<a href="#" class="btn btn-primary btn-xs" onclick="${sys.isActive ? 'openFlagwindow':'editFlag'}('${sys.batchNumber}','${sys.isActive ? 2:1}')"	id="disabled">${sys.isActive ?'禁用':'启用'}</a> --%>
										<a href="#" class="btn btn-primary btn-xs" id="student-view" onclick="stockedit('${sys.batchNumber}', '${sys.goodsNumber}')">库存变更</a> 
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
			url:'${context}/stockmanage/querybypage',
			type:'post',
			data:$("#sysform").serialize(),
			dataType:'html',
			success:function(data){
				$(".content-wrapper").html(data);
			}
		})
	}

	//编辑用户
	function addInit(){
		 $.ajax({
			url:'${context}/stockmanage/addInit',
			type:'post',
			dataType:'html',
			success:function(data){
				layer.open({
					title: '登记入库',
					type: 1,
					skin: 'layui-layer-rim', //加上边框
					area: ['800px', '400'], //宽高
					content:data
				});
			}
		})
	}

	//库存变更
	function stockedit(batchNumber, goodsNumber){
		 $.ajax({
			url:'${context}/stocklogmanage/stockedit',
			type:'post',
			data:{batchNumber:batchNumber, goodsNumber:goodsNumber},
			dataType:'html',
			success:function(data){
				layer.open({
					title: '库存变更',
					type: 1,
					skin: 'layui-layer-rim', //加上边框
					area: ['800px', '400'], //宽高
					content:data
				});
			}
		})
	}
	function goodsinfo(objId){
		 $.ajax({
			url:'${context}/goodsmanage/details',
			type:'post',
			data:{id:objId},
			dataType:'html',
			success:function(data){
				$("#student-viewcon").html(data);
				layer.open({
					title: '商品信息',
					type: 1,
					skin: 'layui-layer-rim', //加上边框
					area: ['800px', 'auto'], //宽高
					content:$("#student-viewcon")
				});
			}
		})
	}
</script>