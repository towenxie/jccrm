<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ include file="/WEB-INF/pages/comm/comm.jsp"%>
<script src="${context}/static/plugins/My97DatePicker/WdatePicker.js"></script>
<section class="content-header">
	<h1>
		${pageTitle} <small></small>
	</h1>
	<ol class="breadcrumb">
		<li><a href="${context }/main"><i class="fa"><img src="${context }/static/dist/img/home_ico.png" width="10"
														  height="10"></i>首页</a></li>
		<li class="active">库存盘点</li>
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
							<th>入库批号</th>
							<th>货品名称</th>
							<th>生产日期</th>
							<th>保质期</th>
							<th>最高库存</th>
							<th>最低库存</th>
							<th>剩余库存</th>
							<th>入库区</th>
						</tr>

						<c:forEach items="${page.results }" var="result">
							<tr>
								<td>${result.transportNo}</td>
								<td></td>
								<td><fmt:formatDate pattern="yyyy-MM-dd HH:mm" value="${result.depotInTime}"/></td>
								<td>${result.sum}</td>
								<td>${result.sum}</td>
								<td></td>
								<td></td>
								<td></td>
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