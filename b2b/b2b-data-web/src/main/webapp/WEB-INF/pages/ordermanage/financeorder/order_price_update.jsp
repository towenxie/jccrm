<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ include file="/WEB-INF/pages/comm/comm.jsp"%>
<div id="student-bjcon" >
	<div class="modal-body">
		<form class="form-horizontal" id="orderPrice" action="" accept-charset="UTF-8"
			method="post">
			<div class="form-body">
				<div class="form-group">
					<label class="control-label col-xs-2"> <label >订单号:</label>
					</label>
					<div class="col-xs-4">
						<p class="form-control-static">${orderPrice.orderNumber}</p>
					</div>
					<label class="control-label col-xs-2"> <label >价格:</label>
					</label>
					<div class="col-xs-4">
						<p class="form-control-static">${orderPrice.totalPrice}</p>
					</div>
				</div>
                <div class="form-group">
                    <label class="control-label col-xs-2"> <label >快递费:</label>
                    </label>
                    <div class="col-xs-4">
                        <input class="form-control"  value="${orderPrice.sendPrice}"  name="sendPrice" type="number">
                    </div>
                    <label class="control-label col-xs-2"> <label >代收费%:</label>
                    </label>
                    <div class="col-xs-4">
                        <input class="form-control"  value="${orderPrice.replaceProfit}"  name="replaceProfit" type="number">
                    </div>
                </div>
                <div class="form-group">
                    <label class="control-label col-xs-2"> <label >退货总额:</label>
                    </label>
                    <div class="col-xs-4">
                        <input class="form-control"  value="${orderPrice.refundPrice}"  name="refundPrice" type="number">
                    </div>
                    <label class="control-label col-xs-2"> <label >原因:</label>
                    </label>
                    <div class="col-xs-4">
                        <select class="form-control" name="reasonName">
                            <c:forEach items="${reasons}" var="d">
                                <option ${d.name eq orderPrice.reasonName?'selected':''} value="${d.name}">${d.name}</option>
                            </c:forEach>
                        </select>
                    </div>
                </div>
				<div class="form-group">
                    <label class="control-label col-xs-2"> <label >退货明细:</label> </label>
                    <div class="col-xs-10">
                        <textarea class="form-control " name="refundDetail">${orderPrice.refundDetail}</textarea>
                    </div>
				</div>
				<input name="orderNumber"  value="${orderPrice.orderNumber}" type="hidden"/>
			</div>

		</form>
	</div>
	<div class="modal-footer">
		<button type="button" class="btn btn-primary" onclick="fpoeditinfo()">保存</button>
		<button type="button" class="btn btn-default" onclick="top.layer.closeAll()">取消</button>
	</div>
</div>
<script type="text/javascript">
	var checksubmit = false; 
	function fpoeditinfo(){
		if(checksubmit == true){
			return false;
		}
		$.ajax({
			url:'${context}/ordermanage/financeorder/orderpriceupdate',
			type:'post',
			data:$("#orderPrice").serialize(),
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