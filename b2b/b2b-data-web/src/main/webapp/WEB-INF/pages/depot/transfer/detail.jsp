<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ include file="/WEB-INF/pages/comm/comm.jsp"%>
<script src="${context}/static/plugins/My97DatePicker/WdatePicker.js"></script>
<section class="content-header">
	<h1>
		本月转账 <small></small>
	</h1>
	<ol class="breadcrumb">
		<li><a href="${context }/main"><i class="fa"><img src="${context }/static/dist/img/home_ico.png" width="10"
														  height="10"></i>首页</a></li>
		<li class="active">本月转账</li>
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
							<th>编号</th>
							<th>汇款日期</th>
							<th>汇款账户</th>
							<th>汇款金额</th>
							<th>收款账户</th>
							<th>收款银行</th>
							<th>收款帐号</th>
							<th>操作</th>
						</tr>

						<c:forEach items="${page.results }" var="result" varStatus="status">
							<tr>
								<td>${status.index+1}</td>
								<td><fmt:formatDate pattern="yyyy-MM-dd HH:mm" value="${result.depotInTime}"/></td>
								<td></td>
								<td>${result.sum}</td>
								<td>${result.sum}</td>
								<td></td>
								<td></td>
								<td>确认收款 配发货详情</td>
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
            url : "${context}/goodsInside/detail?transportNo="+transportNo,
            dataType : "html",
            success : function(data) {
                layer.open({
                    title : '入库详情',
                    type : 1,
                    skin : 'layui-layer-rim', //加上边框
                    area : [ '800px', '500px' ], //宽高
                    content : data
                });
            }
        });
    }

    function queryResult() {
        $.ajax({
            url : "${context}/goodsInside/list?pageNo=" + $("#pageNo").val(),
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
            url : "${context}/goodsInside/list?pageNo=1",
            data : $("#searchForm").serialize(),
            type : "post",
            dataType : 'html',
            success : function(data) {
                $(".content-wrapper").html(data);
            }
        });
    }
</script>