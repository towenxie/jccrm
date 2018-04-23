<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/pages/comm/comm.jsp" %>
<script src="${context}/static/plugins/My97DatePicker/WdatePicker.js"></script>
<section class="content-header">
	<h1>
		投诉信息
		<small></small>
	</h1>
	<ol class="breadcrumb">
		<li><a href="${context }/main"><i class="fa"><img src="${context }/static/dist/img/home_ico.png" width="10"
														  height="10"></i>首页</a></li>
		<li class="active">投诉信息</li>
	</ol>
</section>
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
							<div class="col-sm-12">
								<label class="control-label">订单号</label>
								<input class="form-control" value="${orderId}" name="orderId"
									   placeholder="" type="text">
							</div>
						</div>
						&nbsp;&nbsp;
						<div class="form-group">
							<label>从</label>
							<input class="form-control" onFocus="WdatePicker()" value="${startTime}" name="accountNo"
								   placeholder="" type="text">
						</div>

						<div class="form-group">
							<label>至</label>
							<input class="form-control" onFocus="WdatePicker()" value="${endTime}" name="accountNo"
								   placeholder="" type="text">
						</div>
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
							<th>订单号</th>
							<th>投诉时间</th>
							<th>厂家</th>
							<th>投诉人</th>
							<th>操作</th>
						</tr>
						<c:forEach items="${page.results }" var="result" varStatus="status">
							<tr>
								<td>${status.index+1}</td>
								<td>${result.orderNo}</td>
								<td><fmt:formatDate pattern="yyyy-MM-dd HH:mm" value="${result.created}"/></td>
								<td>${result.venderId}</td>
								<td>${result.complainant}</td>
								<td><a href="#" class="btn btn-primary btn-xs" id="student-bj"
									   onclick="detailFun('${result.id}')">查看详情</a></td>
							</tr>
						</c:forEach>
						</tbody>
					</table>
				</div>
				<!-- /.box-body -->
				<%@ include file="/WEB-INF/pages/comm/page.jsp" %>
			</div>
			<!-- /.col -->
		</div>
	</div>
</section>
<input type="hidden" id="pageNo" name="pageNo" value="${page.pageNo }">
<script type="text/javascript">
    function detailFun(id) {
        $.ajax({
            url: "${context}/complain/detail?id=" + id,
            dataType: "html",
            success: function (data) {
                layer.open({
                    title: '投诉信息',
                    type: 1,
                    skin: 'layui-layer-rim', //加上边框
                    area: ['800px', '500px'], //宽高
                    content: data
                });
            }
        });
    }

    function queryResult() {
        $.ajax({
            url: "${context}/complain/list?complainStat=1&pageNo=" + $("#pageNo").val(),
            data: $("#searchForm").serialize(),
            type: "post",
            dataType: 'html',
            success: function (data) {
                $(".content-wrapper").html(data);
            }
        });
    }

    function initResult() {
        $.ajax({
            url : "${context}/complain/list?complainStat=1&pageNo=1",
            data : $("#searchForm").serialize(),
            type : "post",
            dataType : 'html',
            success : function(data) {
                $(".content-wrapper").html(data);
            }
        });
    }
</script>