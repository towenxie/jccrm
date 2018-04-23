<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ include file="/WEB-INF/pages/comm/comm.jsp"%>
<script src="${context}/static/plugins/My97DatePicker/WdatePicker.js"></script>
<section class="content-header">
	<h1>
		预入库信息 <small></small>
	</h1>
	<ol class="breadcrumb">
		<li><a href="${context }/main"><i class="fa"><img src="${context }/static/dist/img/home_ico.png" width="10"
														  height="10"></i>首页</a></li>
		<li class="active">预入库信息</li>
	</ol>
</section>
<section class="content">
	<div class="clearfix"></div>
	<div class="row">
		<div class="col-md-12">
			<div class="box box-primary">
				<div class="box-body">
					<table class="table table-bordered">
						<tbody>
							<tr>
								<th>配货单号</th>
								<th>配送厂家</th>
								<th>预计到达时间</th>
								<th>发车时间</th>
								<th>总件数</th>
								<th>商品立方数</th>
								<th>配送车辆</th>
								<th>配送详情</th>
							</tr>
							<c:forEach items="${page.results }" var="result">
								<tr>
									<td>${result.transportNo}</td>
									<td>${result.firm}</td>
									<td><fmt:formatDate pattern="yyyy-MM-dd HH:mm" value="${result.transportTime}"/></td>
									<td><fmt:formatDate pattern="yyyy-MM-dd HH:mm" value="${result.departureTime}"/></td>
									<td>${result.sum}件</td>
									<td>${result.size}立方米</td>
									<td>${result.carCount}辆</td>
									<td>
										<button class="btn btn-primary btn-xs" onclick="detailFun('${result.transportNo}')">查看详情</button>
									</td>

								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
				<!-- /.box-body -->
				<%@ include file="/WEB-INF/pages/comm/page.jsp"%>
			</div>
			<!-- /.col -->
		</div>
	</div>
</section>
<input type="hidden" id="pageNo" name="pageNo" value="${page.pageNo }">
<script type="text/javascript">
	function detailFun(transportNo) {
		$.ajax({
			url : "${context}/prepareIntoStorage/detail?transportNo="+transportNo,
			dataType : "html",
			success : function(data) {
				layer.open({
					title : '配送详情',
					type : 1,
					skin : 'layui-layer-rim', //加上边框
					area : [ '1024px', '800px' ], //宽高
					content : data
				});
			}
		});
	}

	function queryResult() {
		$.ajax({
			url : "${context}/prepareIntoStorage/list?pageNo=" + $("#pageNo").val(),
			data : $("#searchForm").serialize(),
			type : "post",
			dataType : 'html',
			success : function(data) {
				$(".content-wrapper").html(data);
			}
		});
	}
</script>