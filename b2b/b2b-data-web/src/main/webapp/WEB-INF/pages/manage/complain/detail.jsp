<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ include file="/WEB-INF/pages/comm/comm.jsp"%>
<script type="text/javascript" src="${context}/static/nice-validator/jquery.validator.js"></script>
<script type="text/javascript" src="${context}/static/nice-validator/local/zh_CN.js"></script>
<!--student-bjcon st-->
<div class="modal-body">
	<form class="form-horizontal" id="uform" action=""
		  accept-charset="UTF-8" method="post">
		<div class="form-body">
			<div class="form-group">
				<label class="control-label col-xs-2"> <label>订单号:</label>
				</label>
				<div class="col-xs-8">
					<p class="form-control-static">${result.orderNo}</p>
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-xs-2"> <label>投诉时间:</label>
				</label>
				<div class="col-xs-8">
					<p class="form-control-static"><fmt:formatDate pattern="yyyy-MM-dd HH:mm" value="${result.created}"/></p>
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-xs-2"> <label>被投诉商家:</label>
				</label>
				<div class="col-xs-8">
					<p class="form-control-static">${result.venderId}</p>
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-xs-2"> <label>投诉人:</label>
				</label>
				<div class="col-xs-8">
					<p class="form-control-static">${result.complainant}</p>
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-xs-2"> <label>投诉内容:</label>
				</label>
				<div class="col-xs-8">
					<p class="form-control-static">${result.content}</p>
				</div>
			</div>

			<div class="form-group">
				<label class="control-label col-xs-2"> <label>处理结果:</label>
				</label>
				<div class="col-xs-8">
					<p class="form-control-static">${result.result}</p>
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-xs-2"> <label>处理人:</label>
				</label>
				<div class="col-xs-8">
					<p class="form-control-static">${result.userId}</p>
				</div>
			</div>
		</div>
	</form>
</div>
<div class="modal-footer">
	<button type="button" class="btn btn-default" onclick="result()">关闭</button>
</div>
<!--student-bjcon end-->
<script type="text/javascript">
    function result() {
        top.layer.closeAll();
    }
</script>