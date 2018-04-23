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
					<label class="control-label col-xs-2"> <label ><span
							class="red-text">*</span>物流公司:</label> </label>
					<div class="col-xs-4">
						<select class="form-control" ${'paid' eq order.orderStatusCode?'':'disabled'} name="expressCompanyCode">
							<c:forEach items="${express}" var="d">
								<option ${d.code eq order.expressCompanyCode?'selected':''} value="${d.code}">${d.name}</option>
							</c:forEach>
						</select>
					</div>
					<label class="control-label col-xs-2"> <label><span
                            class="red-text">*</span>快递号:</label>
					</label>
					<div class="col-xs-4">
						<input class="form-control" ${'paid' eq order.orderStatusCode?'':'disabled'} value="${order.expressNumber}" id="poexpressNumber" name="expressNumber" type="text">
					</div>
				</div>
                <div class="form-group">
                    <label class="control-label col-xs-2"> <label >打包人工号:</label> </label>
                    <div class="col-xs-4">
                        <input class="form-control" value="${order.packageBy}" name="packageBy" type="text">
                    </div>
                    <label class="control-label col-xs-2"> <label>录入人工号:</label>
                    </label>
                    <div class="col-xs-4">
                        <input class="form-control" value="${order.deliverBy}" name="deliverBy" type="text">
                    </div>
                </div>
<!-- 				<div class="form-group"> -->
<!-- 					<label class="control-label col-xs-2"> <label><span -->
<!-- 							class="red-text">*</span>订单状态:</label> </label> -->
<!-- 					<div class="col-xs-4"> -->
<!-- 						<select class="form-control" name="orderStatusCode"> -->
<%-- 							<c:forEach items="${status}" var="d"> --%>
<%-- 								<option ${order.orderStatusCode ?'selected':''} value="${d.code}">${d.name}</option> --%>
<%-- 							</c:forEach> --%>
<!-- 						</select> -->
<!-- 					</div> -->
<!-- 				</div> -->
				<input name="orderStatusCode" value="shipped" type="hidden"/>
				<input name="orderNumber"  value="${order.orderNumber}" type="hidden"/>
			</div>

		</form>
	</div>
	<div class="modal-footer">
		<button type="button" class="btn btn-primary" ${'paid' eq order.orderStatusCode?'':'disabled'} onclick="sendUpdate()">发货</button>
		<button type="button" class="btn btn-primary" ${'paid' eq order.orderStatusCode?'disabled':''} onclick="infoUpdate()">更新</button>
		<button type="button" class="btn btn-default" onclick="top.layer.closeAll()">取消</button>
	</div>
</div>
<script type="text/javascript">
	var checksubmit = false; 
	function sendUpdate(){
        if(!validate()){
            return false;
        }
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
    function infoUpdate(){
        if(checksubmit == true){
            return false;
        }
        $.ajax({
            url:'${context}/ordermanage/orderupdate',
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
    function validate(){
        var name=$("input[id=poexpressNumber]").val();
        if(name == '' || name == null){
            layer.msg("快递号不能为空");
            return false;
        }

        return true;
    }
</script>