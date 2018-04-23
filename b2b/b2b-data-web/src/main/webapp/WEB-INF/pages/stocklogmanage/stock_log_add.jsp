<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ include file="/WEB-INF/pages/comm/comm.jsp"%>
<div id="student-bjcon" >
	<div class="modal-body">
		<form class="form-horizontal" id="stock" action="" accept-charset="UTF-8"
			method="post">
			<div class="form-body">
				<input name="batchNumber" ${null eq stock.batchNumber?'disabled':''} value="${stock.batchNumber}" type="hidden"/>
				<input name="goodsNumber" ${null eq stock.goodsNumber?'disabled':''} value="${stock.goodsNumber}" type="hidden"/>
				<div class="form-group">
					<label class="control-label col-xs-2"><span
                            class="red-text">*</span>批号:</label>
					<div class="col-xs-4">
						<input class="form-control" ${null eq stock.batchNumber?'':'disabled'} value="${stock.batchNumber}" id="logbatchNumber" name="batchNumber" type="text">
					</div>
					<label class="control-label col-xs-2"> <label ><span
							class="red-text">*</span>商品编号:</label> </label>
					<div class="col-xs-4">
						<input class="form-control" ${null eq stock.goodsNumber?'':'disabled'} value="${stock.goodsNumber}" id="loggoodsNumber" name="goodsNumber" type="text">
					</div>
				</div>

				<div class="form-group">
					<label class="control-label col-xs-2"> <label><span
							class="red-text">*</span>数量:</label> </label>
					<div class="col-xs-4">
						<input class="form-control" value="${stock.num}" id="lognum"  name="num" type="number">
					</div>
					<label class="control-label col-xs-2"> <label ><span
							class="red-text">*</span>类型:</label> </label>
					<div class="col-xs-4">
						<select class="form-control" name="stockCode">
							<c:forEach items="${types}" var="d">
								<option ${stock.stockCode ?'selected':''} value="${d.code}">${d.name}</option>
							</c:forEach>
						</select>
					</div>
				</div>
				<div class="form-group">
					<label class="control-label col-xs-2"> <label ><span
							class="red-text">*</span>原因:</label> </label>
					<div class="col-xs-10">
						<input class="form-control"  value="${stock.reason}" id="logreason" name="reason" type="text">
					</div>
				</div>
				<input name="logNumber"  value="${stock.logNumber}" type="hidden"/>
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
		if(!validate()){
			return false;
		}
		if(checksubmit == true){
			return false;
		}
		$.ajax({
			url:'${context}/stocklogmanage/add',
			type:'post',
			data:$("#stock").serialize(),
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

        var name = $("input[id=logbatchNumber]").val();
        if(name == '' || name == null){
            layer.msg("批号不能为空");
            return false;
        }
		var name1=$("input[id=loggoodsNumber]").val();
		if(name1 == '' || name1 == null){
			layer.msg("商品编号不能为空");
			return false;
		}

		var name=$("input[id=lognum]").val();
		if(name == '' || name == null){
			layer.msg("数量不能为空");
			return false;
		}
        var name=$("input[id=logreason]").val();
        if(name == '' || name == null){
            layer.msg("原因不能为空");
            return false;
        }
		return true;
	}
</script>