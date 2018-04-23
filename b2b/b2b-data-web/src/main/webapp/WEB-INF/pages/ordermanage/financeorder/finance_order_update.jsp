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
					<label class="control-label col-xs-2"> <label >价格:</label>
					</label>
					<div class="col-xs-4">
						<p class="form-control-static">${order.totalPrice}</p>
					</div>
				</div>

				<div class="form-group">
                    <label class="control-label col-xs-2"> <label >定金金额:</label>
                    </label>
                    <div class="col-xs-4">
                        <p class="form-control-static">${order.depositPrice}</p>
                    </div>
                    <label class="control-label col-xs-2"> <label><span
                            class="red-text">*</span>定金确认:</label> </label>
                    <div class="col-xs-4">
                        <select class="form-control"  ${'pending' eq order.orderStatusCode?'':'disabled'} name="hasDingjin">
                            <option ${order.hasDingjin ?'selected':''} value="true">是</option>
                            <option ${order.hasDingjin ?'':'selected'} value="false">否</option>
                        </select>
                    </div>
				</div>
                <div class="form-group">
                    <label class="control-label col-xs-2"> <label><span
                            class="red-text">*</span>付款方式:</label> </label>
                    <div class="col-xs-4">
                        <select class="form-control"  ${'pending' eq order.orderStatusCode?'':'disabled'} name="paymentCode">
                            <c:forEach items="${payments}" var="d">
                                <option ${d.code eq order.paymentCode?'selected':''} value="${d.code}">${d.name}</option>
                            </c:forEach>
                        </select>
                    </div>
                    <label class="control-label col-xs-2"> <label ><span
                            class="red-text">*</span>授权发货:</label> </label>
                    <div class="col-xs-4">
                        <select class="form-control"  ${'pending' eq order.orderStatusCode?'':'disabled'} name="canSend">
                            <option ${order.canSend ?'selected':''} value="true">是</option>
                            <option ${order.canSend ?'':'selected'} value="false">否</option>
                        </select>
                    </div>

                </div>
                <div class="form-group">
                    <label class="control-label col-xs-2"> <label><span
                            class="red-text">*</span>货款到账:</label> </label>
                    <div class="col-xs-4">
                        <select class="form-control" ${order.hasDaikuang?'disabled':''} name="hasDaikuang">
                            <option ${order.hasDaikuang ?'selected':''} value="true">已</option>
                            <option ${order.hasDaikuang ?'':'selected'} value="false">未</option>
                        </select>
                    </div>
                    <label class="control-label col-xs-2"> <label ><span
                            class="red-text">*</span>开发票:</label> </label>
                    <div class="col-xs-4">
                        <select class="form-control" ${'pending' eq order.orderStatusCode || order.hasBill?'disabled':''} name="hasBill">
                            <option ${order.hasBill ?'selected':''} value="true">是</option>
                            <option ${order.hasBill ?'':'selected'} value="false">否</option>
                        </select>
                    </div>
                </div>
				<input name="orderStatusCode" value="paid" type="hidden"/>
				<input name="orderNumber" value="${order.orderNumber}" type="hidden"/>
			</div>

		</form>
	</div>
	<div class="modal-footer">
		<button type="button" class="btn btn-primary" ${'pending' eq order.orderStatusCode?'':'disabled'} onclick="feditinfo()">已付款</button>
		<button type="button" class="btn btn-primary" ${'pending' eq order.orderStatusCode || order.hasBill?'disabled':''} onclick="finfoUpdate()">更新</button>
		<button type="button" class="btn btn-default" onclick="top.layer.closeAll()">取消</button>
	</div>
</div>
<script type="text/javascript">
	var checksubmit = false; 
	function feditinfo(){
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
    function finfoUpdate(){
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
</script>