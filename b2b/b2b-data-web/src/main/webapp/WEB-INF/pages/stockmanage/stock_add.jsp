<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ include file="/WEB-INF/pages/comm/comm.jsp"%>
<script src="${context}/static/plugins/My97DatePicker/WdatePicker.js"></script>
<div id="student-bjcon" >
	<div class="modal-body">
		<form class="form-horizontal" id="stock" action="" accept-charset="UTF-8"
			method="post">
			<div class="form-body">
			    <input name="goodsNumber" ${null eq stock.goodsNumber?'disabled':''} value="${stock.goodsNumber}" type="hidden"/>
                <div class="form-group">
                    <label class="control-label col-xs-2"> <label >入库批号:</label> </label>
                    <div class="col-xs-10">
                        <input class="form-control"  value="${stock.batchNumber}" id="stbatchNumber" name="batchNumber" type="text">
                    </div>
                </div>
				<div class="form-group">
					<label class="control-label col-xs-2"> <label ><span
							class="red-text">*</span>商品编号:</label> </label>
					<div class="col-xs-4">
						<input class="form-control" ${null eq stock.goodsNumber?'':'disabled'} value="${stock.goodsNumber}" id="stgoodsNumber" name="goodsNumber" type="text">
					</div>
					<label class="control-label col-xs-2"> <label ><span
							class="red-text">*</span>库存:</label> </label>
					<div class="col-xs-4">
						<input class="form-control"  value="${stock.stockNum}" id="ststockNum" name="stockNum" type="number">
					</div>
				</div>

				<div class="form-group">
					<label class="control-label col-xs-2"> <label><span
							class="red-text">*</span>保质期(天):</label> </label>
					<div class="col-xs-4">
						<input class="form-control"  value="${stock.saveDays}" id="stsaveDays" name="saveDays" type="number">
					</div>
					<label class="control-label col-xs-2"> <label ><span
							class="red-text">*</span>生产日期:</label> </label>
					<div class="col-xs-4">
                            <input class="form-control" onFocus="WdatePicker()" value="${stock.productDate}"
                                   id="stproductDate" name="productDate" placeholder="" type="text">
					</div>
				</div>
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
			url:'${context}/stockmanage/addorupdate',
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
        var name=$("input[id=stgoodsNumber]").val();
        if(name == '' || name == null){
            layer.msg("商品编号不能为空");
            return false;
        }

        var name=$("input[id=ststockNum]").val();
        if(name == '' || name == null){
            layer.msg("库存不能为空");
            return false;
        }
        var name=$("input[id=stsaveDays]").val();
        if(name == '' || name == null){
            layer.msg("保质期不能为空");
            return false;
        }
        var name=$("input[id=stproductDate]").val();
        if(name == '' || name == null){
            layer.msg("生产日期不能为空");
            return false;
        }
        return true;
	}
</script>