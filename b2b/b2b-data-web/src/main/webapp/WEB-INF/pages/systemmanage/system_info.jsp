<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ include file="/WEB-INF/pages/comm/comm.jsp"%>
				<!--student-viewcon st-->
					<div class="modal-body">
						<form class="form-horizontal" id="" action=""
							accept-charset="UTF-8" method="post">
							<div class="form-body">
								<div class="form-group">
									<label class="control-label col-xs-2"> <label >账号:</label>
									</label>
									<div class="col-xs-4">
										<p class="form-control-static">${sysuser.workId}</p>
									</div>
									<label class="control-label col-xs-2"> <label >姓名:</label>
									</label>
									<div class="col-xs-4">
										<p class="form-control-static">${sysuser.username}</p>
									</div>
								</div>
								<div class="form-group">
									<label class="control-label col-xs-2"> <label >手机号:</label>
									</label>
									<div class="col-xs-4">
										<p class="form-control-static">${sysuser.phone}</p>
									</div>
									<label class="control-label col-xs-2"> <label >邮件:</label>
									</label>
									<div class="col-xs-4">
										<p class="form-control-static">${sysuser.email}</p>
									</div>
								</div>
								<div class="form-group">
									<label class="control-label col-xs-2"> <label >科室:</label>
									</label>
									<div class="col-xs-4">
										<p class="form-control-static">${sysuser.dept.name}</p>
									</div>
									<label class="control-label col-xs-2"> <label >角色:</label>
									</label>
									<div class="col-xs-4">
										<p class="form-control-static"><c:forEach items="${sysuser.roles}" var="rol">
											<span> ${rol.name}, </span>
										</c:forEach></p>
									</div>
								</div>
								<div class="form-group">
									<label class="control-label col-xs-2"> <label >添加时间:</label>
									</label>
									<div class="col-xs-4">
										<p class="form-control-static"><fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss" value="${sysuser.created}"/></p>
									</div>
									<label class="control-label col-xs-2"> <label >用户状态:</label>
									</label>
									<div class="col-xs-4">
										<p class="form-control-static">${sysuser.isActive ?'启用':'禁用'}</p>
									</div>
								</div>
							<div class="form-group">
								<label class="control-label col-xs-2"> <label >上级领导:</label>
								</label>
									<div class="col-xs-4">
										<p class="form-control-static">
											${sysuser.parentWorkId}
										</p>
									</div>
							</div>
						</div>
						</form>
					</div>
					<div class="modal-footer">
						<button type="button" onclick="top.layer.closeAll()" class="btn btn-default">返回</button>
					</div>

				<!--student-viewcon end-->