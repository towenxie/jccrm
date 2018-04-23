<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ include file="/WEB-INF/pages/comm/comm.jsp"%>
<section class="content-header">
	<h1>
		科室管理 <small></small>
	</h1>
	<ol class="breadcrumb">
		<li><a href="#"><i class="fa"><img
					src="${context}/static/dist/img/home_ico.png" width="10"
					height="10"></i>首页</a></li>
		<!--<li>科室管理</li>-->
		<li class="active">科室管理</li>
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

				<form class="form-inline" id="sysform" method="post" onkeydown="if(event.keyCode==13){return false;}">
					<div class="box-body">

						<div class="form-group">
							<label>科室：</label> <input class="form-control"
								value="${deptName}" name="deptName" id="" placeholder=""
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
							role="button" id="backuser-add">添加科室</a>
					</p>

					<table class="table table-bordered">
						<tbody>
							<tr>
								<th>编号</th>
								<th>代码</th>
								<th>科室</th>
								<th>是否销售</th>
								<th>状态</th>
								<th>操作</th>
							</tr>
							<c:forEach items="${page.results}" var="sys">
								<tr>
									<td>${sys.id}</td>
									<td>${sys.code}</td>
									<td>${sys.name}</td>
									<td>${sys.canSale ? '是':'否'}</td>
									<td>${sys.isActive ? '启用':'禁用'}</td>
									<td style="width: 290px;">
                                       <a href="#" class="btn btn-primary btn-xs" onclick="openFlagwindow('${sys.id}')" id="disabled">删除</a> 
                                        <a href="#" class="btn btn-primary btn-xs" onclick="editFlag('${sys.code}','${sys.isActive ? 2:1}')">${sys.isActive ?'禁用':'启用'}</a>
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
										<input class="form-control" name="addDeptCode" type="text">
									</div>
								</div>
								<div class="form-group">
									<label class="control-label col-xs-4"> <label>科室:</label>
									</label>
									<div class="col-xs-8">
										<input class="form-control" name="addDeptName" type="text">
									</div>
								</div>
								<div class="form-group">
									<label class="control-label col-xs-4"> <label>所属科室:</label>
									</label>
									<div class="col-xs-8">
										<select class="form-control" name="addParentCode">
											<option selected="" value="">无</option>
											<c:forEach items="${deptParents}" var="r">
												<option value="${r.code}">${r.name}</option>
											</c:forEach>
										</select>								
									</div>
								</div>
                                <div class="form-group">
                                    <label class="control-label col-xs-4"> <label>是否可以销售:</label>
                                    </label>
                                    <div class="col-xs-8">
                                        <select class="form-control" name="addCanSale">
                                            <option selected="" value="1">是</option>
                                            <option value="0">否</option>
                                        </select>                               
                                    </div>
                                </div>
							</div>
						</form>

					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-primary" onclick="deptadd()">确定</button>
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
			url:'${context}/systemmanage/dept/querybypage',
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
		 $("input[name=addDeptCode]").val('');
		 $("input[name=addDeptName]").val('');
		 $("select[name=addParentCode]").val('');
		 $("select[name=addCanSale]").val('1');
		layer.open({
			title: '添加科室',
			type: 1,
			skin: 'layui-layer-rim', //加上边框
			area: ['400px', 'auto'], //宽高
			content: $('#student-mmcon')
		});
	}

	function deptadd(){
		var deptCode = $("input[name=addDeptCode]").val();
		var deptName = $("input[name=addDeptName]").val();
		var parentCode = $("select[name=addParentCode]").val();
		var canSale = $("select[name=addCanSale]").val();
		
		$.ajax({
			url:'${context}/systemmanage/dept/add',
			type:'post',
			data:{deptCode:deptCode,deptName:deptName,parentCode:parentCode,canSale:canSale},
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
    url:'${context}/systemmanage/dept/remove',
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
			url:'${context}/systemmanage/dept/editFlag',
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