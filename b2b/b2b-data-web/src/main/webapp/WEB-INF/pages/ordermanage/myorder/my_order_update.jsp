<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ include file="/WEB-INF/pages/comm/comm.jsp"%>
<div id="student-bjcon" >
	<div class="modal-body">
		<form class="form-horizontal" id="order" action="" accept-charset="UTF-8"
			method="post">
			<div class="form-body">
				<div class="form-group">
					<label class="control-label col-xs-2"> <label >订单号:</label>
					</label>
					<div class="col-xs-4">
						<p class="form-control-static">${order.orderNumber}</p>
					</div>
					<label class="control-label col-xs-2"> <label >收件人:</label>
					</label>
					<div class="col-xs-4">
						<p class="form-control-static">${order.username}</p>
					</div>
				</div>
				<div class="form-group">
					<label class="control-label col-xs-2"> <label >快递公司:</label>
					</label>
					<div class="col-xs-4">
						<p class="form-control-static">${order.express.name}</p>
					</div>
					<label class="control-label col-xs-2"> <label >快递号:</label>
					</label>
					<div class="col-xs-4">
						<p class="form-control-static">${order.expressNumber}</p>
					</div>
				</div>

				<div class="form-group">
					<label class="control-label col-xs-2"> <label><span
							class="red-text">*</span>订单状态:</label> </label>
					<div class="col-xs-4">
						<select class="form-control" name="orderStatusCode">
							<c:forEach items="${status}" var="d">
								<option ${d.code eq order.orderStatusCode?'selected':''} value="${d.code}">${d.name}</option>
							</c:forEach>
						</select>
					</div>
				</div>
				<input name="orderNumber"  value="${order.orderNumber}" type="hidden"/>
			</div>

		</form>
	</div>
	<div class="modal-footer">
		<button type="button" class="btn btn-primary" onclick="editinfo()">保存</button>
		<button type="button" class="btn btn-default" onclick="top.layer.closeAll()">取消</button>
	</div>
</div>
<script type="text/javascript">
	var checksubmit = false; 
	function editinfo(){
		if(checksubmit == true){
			return false;
		}
		$.ajax({
			url:'${context}/ordermanage/update',
			type:'post',
			data:$("#order").serialize(),
			dataType:'json',
			success:function(data){
				layer.msg(data.msg);
				checksubmit = false;
				if(data.code == 200){
					setTimeout(
						function(){
						top.layer.closeAll()
						queryResult()
						},1500)
				}
			}
		})
	}
</script>