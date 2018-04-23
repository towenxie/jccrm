<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ include file="/WEB-INF/pages/comm/comm.jsp"%>
				<!--student-viewcon st-->
					<div class="modal-body">
						<form class="form-horizontal" id="" action=""
							accept-charset="UTF-8" method="post">
							<div class="form-body">
								<div class="form-group">
									<label class="control-label col-xs-2"> <label >编号:</label>
									</label>
									<div class="col-xs-4">
										<p class="form-control-static">${goods.goodsNumber}</p>
									</div>
									<label class="control-label col-xs-2"> <label >名称:</label>
									</label>
									<div class="col-xs-4">
										<p class="form-control-static">${goods.name}</p>
									</div>
								</div>
								<div class="form-group">
									<label class="control-label col-xs-2"> <label >价格:</label>
									</label>
									<div class="col-xs-4">
										<p class="form-control-static">${goods.price}</p>
									</div>
									<label class="control-label col-xs-2"> <label >单位:</label>
									</label>
									<div class="col-xs-4">
										<p class="form-control-static">${goods.unit}</p>
									</div>
								</div>
								<div class="form-group">
									<label class="control-label col-xs-2"> <label >产地:</label>
									</label>
									<div class="col-xs-4">
										<p class="form-control-static">${goods.location}</p>
									</div>
									<label class="control-label col-xs-2"> <label >生产商:</label>
									</label>
									<div class="col-xs-4">
										<p class="form-control-static">${goods.producter}</p>
									</div>

								</div>
								<div class="form-group">
									<label class="control-label col-xs-2"> <label >库存:</label>
									</label>
									<div class="col-xs-4">
										<p class="form-control-static">${goods.stockNum}</p>
									</div>
									<label class="control-label col-xs-2"> <label >添加时间:</label>
									</label>
									<div class="col-xs-4">
										<p class="form-control-static"><fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss" value="${goods.created}"/></p>
									</div>
								</div>
								<div class="form-group">
									<label class="control-label col-xs-2"> <label >备注:</label>
									</label>
									<div class="col-xs-10">
									<textarea class="form-control " readonly name="remark">${goods.remark}</textarea>
<%-- 										<p class="form-control-static">${goods.isActive ?'启用':'禁用'}</p> --%>
									</div>


								</div>
							</div>
						</form>
					</div>
					<div class="modal-footer">
						<button type="button" onclick="top.layer.closeAll()" class="btn btn-default">返回</button>
					</div>

				<!--student-viewcon end-->