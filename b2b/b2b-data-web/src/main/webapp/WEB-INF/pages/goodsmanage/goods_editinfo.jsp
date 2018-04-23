<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ include file="/WEB-INF/pages/comm/comm.jsp"%>
<div id="student-bjcon" >
	<div class="modal-body">
		<form class="form-horizontal" id="goods" action="" accept-charset="UTF-8"
			method="post">
			<div class="form-body">
				<div class="form-group">
					<label class="control-label col-xs-2"> <label >编号:</label> </label>
					<div class="col-xs-4">
						<input class="form-control" ${null eq goods.goodsNumber?'':'disabled'}  value="${goods.goodsNumber}" id="gdgoodsNumber" name="goodsNumber" type="text">
					</div>
                    <label class="control-label col-xs-2"> <label ><span
                            class="red-text">*</span>名称:</label> </label>
                    <div class="col-xs-4">
                        <input class="form-control"  value="${goods.name}" id="gdname" name="name" type="text">
                    </div>
				</div>

				<div class="form-group">
                    <label class="control-label col-xs-2"> <label ><span
                            class="red-text">*</span>价格:</label> </label>
                    <div class="col-xs-4">
                        <input class="form-control"  value="${goods.price}" id="gdprice" name="price" type="number">
                    </div>
					<label class="control-label col-xs-2"> <label ><span
							class="red-text">*</span>单位:</label> </label>
					<div class="col-xs-4">
						<input class="form-control"  value="${goods.unit}" id="gdunit" name="unit" type="text">
					</div>

				</div>
					
				<div class="form-group">
                    <label class="control-label col-xs-2"> <label ><span
                            class="red-text">*</span>产地:</label> </label>
                    <div class="col-xs-4">
                        <input class="form-control"  value="${goods.location}" id="gdlocation" name="location" type="text">
                    </div>
					<label class="control-label col-xs-2"> <label><span
                            class="red-text">*</span>生产商:</label>
					</label>
					<div class="col-xs-4">
						<input class="form-control"  value="${goods.producter}" id="gdproducter" name="producter" type="text">
					</div>
				</div>
				
				<div class="form-group">
					<label class="control-label col-xs-2"> <label>备注:</label>
					</label>
					<div class="col-xs-10">
					    <textarea class="form-control " name="remark">${goods.remark}</textarea>
<%-- 						<input class="form-control"  value="${goods.producter}"  name="producter" type="text"> --%>
					</div>
				</div>
				<input ${null eq goods.goodsNumber?'disabled':''}  value="${goods.goodsNumber}" name="goodsNumber" type="hidden">
				<input name="id"  value="${goods.id}" type="hidden"/>
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
			url:'${context}/goodsmanage/addorupdate',
			type:'post',
			data:$("#goods").serialize(),
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
		var name=$("input[id=gdname]").val();
		if(name == '' || name == null){
			layer.msg("名称不能为空");
			return false;
		}
        var name=$("input[id=gdprice]").val();
        if(name == '' || name == null){
            layer.msg("价格不能为空");
            return false;
        }
        var name=$("input[id=gdunit]").val();
        if(name == '' || name == null){
            layer.msg("单位不能为空");
            return false;
        }
        var name=$("input[id=gdlocation]").val();
        if(name == '' || name == null){
            layer.msg("产地不能为空");
            return false;
        }
        var name=$("input[id=gdproducter]").val();
        if(name == '' || name == null){
            layer.msg("生产商不能为空");
            return false;
        }
		return true;
	}
</script>