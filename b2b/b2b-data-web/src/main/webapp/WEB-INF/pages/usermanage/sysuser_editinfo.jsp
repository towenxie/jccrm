<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ include file="/WEB-INF/pages/comm/comm.jsp"%>
<div id="student-bjcon" >
	<div class="modal-body">
		<form class="form-horizontal" id="sysuser" action="" accept-charset="UTF-8"
			method="post">
			<div class="form-body">
				<div class="form-group">
					<label class="control-label col-xs-2"> <label ><span
							class="red-text">*</span>姓名:</label> </label>
					<div class="col-xs-4">
						<input class="form-control" value="${sysuser.username}" id="ueusername" name="username" type="text">
					</div>
					<label class="control-label col-xs-2"> <label ><span
							class="red-text">*</span>性别:</label> </label>
					<div class="col-xs-4">
						<select class="form-control" name="sex">
							<option ${sysuser.sex eq '男'?'selected':''} value="男">男</option>
							<option ${sysuser.sex eq '女' ?'selected':''} value="女">女</option>
						</select>
					</div>
				</div>

				<div class="form-group">
					<label class="control-label col-xs-2"> <label><span
							class="red-text">*</span>科室:</label> </label>
					<div class="col-xs-4">
						<select class="form-control" name="deptCode">
							<c:forEach items="${depts}" var="d">
								<option ${d.code eq sysuser.deptCode ?'selected':''} value="${d.code}">${d.name}</option>
							</c:forEach>
						</select>
					</div>
					<label class="control-label col-xs-2"> <label ><span
							class="red-text">*</span>上级领导:</label> </label>
					<div class="col-xs-4">
						<input class="form-control"  value="${sysuser.parentWorkId}" id="ueparentWorkId" name="parentWorkId" type="text">
					</div>
					</div>
					
				<div class="form-group">
					<label class="control-label col-xs-2"> <label>用户角色:</label>
					</label>
					<div class="col-xs-4">
						<select class="form-control" name="roleCodes" multiple="multiple" id="ueroleCodes">
							<c:forEach items="${roles}" var="r">
								<option ${r.isSelected ?'selected':''} value="${r.code}">${r.name}</option>
							</c:forEach>
						</select>								
					</div>
				</div>
				<input name="workId"  value="${sysuser.workId}" type="hidden"/>
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
			url:'${context}/usermanage/addorupdate',
			type:'post',
			data:$("#sysuser").serialize(),
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
		var name=$("input[id=ueusername]").val();
		if(name == '' || name == null){
			layer.msg("姓名不能为空");
			return false;
		}
        var name=$("input[id=ueparentWorkId]").val();
        if(name == '' || name == null){
            layer.msg("上级领导不能为空");
            return false;
        }
        var name=$("select[id=ueroleCodes]").val();
        if(name == '' || name == null){
            layer.msg("用户角色不能为空");
            return false;
        }
		return true;
	}
</script>