<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ include file="/WEB-INF/pages/comm/comm.jsp"%>
<script src="${context}/static/plugins/My97DatePicker/WdatePicker.js"></script>
<section class="content-header">
	<h1>
		配送注册信息 <small></small>
	</h1>
	<ol class="breadcrumb">
		<li><a href="${context }/main"><i class="fa"><img src="${context }/static/dist/img/home_ico.png" width="10"
														  height="10"></i>首页</a></li>
		<li class="active">配送注册信息</li>
	</ol>
</section>
<section class="content">
	<div class="row">
		<!-- left column -->
		<div class="col-md-12">
			<!-- general form elements -->
			<div class="box box-primary">
				<!-- form start -->

				<form class="form-inline" id="searchForm">
					<div class="box-body">
						<div class="form-group">
							<label >姓名</label>
							<input class="form-control" value="${page.params.firm}" name="firm"  placeholder="" type="text">
						</div>&nbsp;&nbsp;
						<button type="button" onclick="initResult()" class="btn btn-primary">搜索</button>
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
					<table class="table table-bordered">
						<tbody>
						<tr>
							<th>姓名</th>
							<th>身份证号</th>
							<th>区域</th>
							<th>保证金</th>
							<th>电话</th>
							<th>操作</th>
						</tr>

						<c:forEach items="${page.results }" var="result" >
							<tr>
								<td>${result.realname}</td>
								<td>${result.idCard}</td>
								<td></td>
								<td>${result.bond}</td>
								<td>${result.phone}</td>
								<td><a href="#" class="btn btn-primary btn-xs" id="student-bj"
									   onclick="detailFun('${result.id}')">审核</a></td>
							</tr>
						</c:forEach>
						</tbody>
					</table>
				</div>
				<!-- /.box-body -->
				<%@ include file="/WEB-INF/pages/comm/page.jsp"%>
				<div id="detail-bjcon" style="display: none">
			</div>
			<!-- /.col -->
		</div>
	</div>

</section>
<input type="hidden" id="pageNo" name="pageNo" value="${page.pageNo }">
<script type="text/javascript">
    function detailFun(id) {
        $.ajax({
            url : "${context}/check/detail/transporter?id="+id,
            dataType : "html",
            success : function(data) {
                $("#detail-bjcon").html(data);
                layer.open({
                    title : '入库详情',
                    type : 1,
                    skin : 'layui-layer-rim', //加上边框
                    area : [ '1024px', '800px' ], //宽高
                    content : $("#detail-bjcon")
                });
            }
        });
    }

    function queryResult() {
        $.ajax({
            url : "${context}/check/transporter?pageNo=" + $("#pageNo").val(),
            data : $("#searchForm").serialize(),
            type : "post",
            dataType : 'html',
            success : function(data) {
                $(".content-wrapper").html(data);
            }
        });
    }

    function initResult() {
        $.ajax({
            url : "${context}/check/transporter?pageNo=1",
            data : $("#searchForm").serialize(),
            type : "post",
            dataType : 'html',
            success : function(data) {
                $(".content-wrapper").html(data);
            }
        });
    }
</script>