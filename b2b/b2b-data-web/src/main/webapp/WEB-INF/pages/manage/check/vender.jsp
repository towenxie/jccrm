<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ include file="/WEB-INF/pages/comm/comm.jsp"%>
<script src="${context}/static/plugins/My97DatePicker/WdatePicker.js"></script>
<section class="content-header">
	<h1>
		厂家注册信息 <small></small>
	</h1>
	<ol class="breadcrumb">
		<li><a href="${context }/main"><i class="fa"><img src="${context }/static/dist/img/home_ico.png" width="10"
														  height="10"></i>首页</a></li>
		<li class="active">厂家注册信息</li>
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
							<label >厂家名</label>
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
							<th>序号</th>
							<th>企业全称</th>
							<th>注册资金</th>
							<th>法人姓名</th>
							<th>联系电话</th>
							<th>操作</th>
						</tr>
						<c:forEach items="${page.results }" var="result" varStatus="status">
							<tr>
								<td>${status.index+1}</td>
								<td>${result.venderName}</td>
								<td>${result.capital}</td>
								<td>${result.corporate}</td>
								<td>${result.emergencyPhone}</td>
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
            url: "${context}/check/detail/vender?id=" + id,
            dataType: "html",
            success: function (data) {
                $("#detail-bjcon").html(data);
                layer.open({
                    title: '厂家信息审核',
                    type: 1,
                    skin: 'layui-layer-rim', //加上边框
                    area: ['800px', '800px'], //宽高
                    content: $("#detail-bjcon")
                });
            }
        });
    }
    function queryResult() {
        $.ajax({
            url : "${context}/check/vender?pageNo=" + $("#pageNo").val(),
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
            url : "${context}/check/vender?pageNo=1",
            data : $("#searchForm").serialize(),
            type : "post",
            dataType : 'html',
            success : function(data) {
                $(".content-wrapper").html(data);
            }
        });
    }
</script>