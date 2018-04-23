<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ include file="/WEB-INF/pages/comm/comm.jsp"%>
<section class="content-header">
	<h1>
		商品管理 <small></small>
	</h1>
	<ol class="breadcrumb">
		<li><a href="#"><i class="fa"><img
					src="${context}/static/dist/img/home_ico.png" width="10"
					height="10"></i>首页</a></li>
		<!--<li>商品管理</li>-->
		<li class="active">商品管理</li>
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
							<label>商品名称：</label> <input class="form-control"
								value="${name}" name="name" id="" placeholder=""
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
						<a class="btn btn-primary" onclick="edituser('')" href="#"
							role="button" id="backuser-add">添加商品</a>
					</p>

					<table class="table table-bordered">
						<tbody>
							<tr>
								<th>编号</th>
								<th>名称</th>
								<th>价格</th>
								<th>单位</th>
								<th>产地</th>
								<th>生产商</th>
								<th>库存</th>
<!-- 								<th>添加时间</th> -->
								<th>商品状态</th>
								<th>操作</th>
							</tr>
							<c:forEach items="${page.results}" var="sys">
								<tr>
									<td>
									<a onclick="userinfo('${sys.goodsNumber}')" href="#" role="button" id="backuser-add">${sys.goodsNumber}</a>
									</td>
									<td>${sys.name}</td>
									<td>${sys.price}</td>
									<td>${sys.unit}</td>
									<td>${sys.location}</td>
									<td>${sys.producter}</td>
									<td>${sys.stockNum}</td>
<%-- 									<td><fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss" --%>
<%-- 											value="${sys.created}" /></td> --%>
									<td>${sys.isActive ? '启用':'禁用'}</td>
									<td style="width: 290px;">
<%--                                        <a href="#" class="btn btn-primary btn-xs" onclick="openFlagwindow('${sys.id}')" id="disabled">删除</a>  --%>
                                        <a href="#" class="btn btn-primary btn-xs" onclick="editFlag('${sys.goodsNumber}','${sys.isActive ? 2:1}')">${sys.isActive ?'禁用':'启用'}</a>
<%-- 										<a href="#" class="btn btn-primary btn-xs" id="student-view" onclick="userinfo('${sys.goodsNumber}')">查看</a>  --%>
										<a href="#" class="btn btn-primary btn-xs" id="student-bj" onclick="edituser('${sys.goodsNumber}')">编辑</a>
										<a href="#" class="btn btn-primary btn-xs" id="student-bj" onclick="stockadd('${sys.goodsNumber}')">入库</a>
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

				<!--商品信息-->
				<div id="student-viewcon" style="display: none;"></div>
				<!--student-viewcon end-->
				
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
			url:'${context}/goodsmanage/querybypage',
			type:'post',
			data:$("#sysform").serialize(),
			dataType:'html',
			success:function(data){
				$(".content-wrapper").html(data);
			}
		})
	}

	function openFlagwindow(uid,flag){
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
            url:'${context}/goodsmanage/remove',
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
			url:'${context}/goodsmanage/editFlag',
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
	//编辑商品
	function edituser(objId){
		 $.ajax({
			url:'${context}/goodsmanage/updateInit',
			type:'post',
			data:{goodsNumber:objId},
			dataType:'html',
			success:function(data){
				layer.open({
					title: '商品信息',
					type: 1,
					skin: 'layui-layer-rim', //加上边框
					area: ['800px', '400'], //宽高
					content:data
				});
			}
		})
	}
	//商品信息
	function userinfo(objId){
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

	//入库登记
	function stockadd(goodsNumber){
		 $.ajax({
			url:'${context}/stockmanage/stockadd',
			type:'post',
			data:{goodsNumber:goodsNumber},
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
</script>