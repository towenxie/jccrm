<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ include file="/WEB-INF/pages/comm/comm.jsp"%>
				<!--student-viewcon st-->
					<div class="modal-body">
						<form class="form-horizontal" id="" action=""
							accept-charset="UTF-8" method="post">
							<div class="form-body">
								<div class="form-group">
									<label class="control-label col-xs-2"> <label >批号:</label>
									</label>
									<div class="col-xs-4">
										<p class="form-control-static">${stock.batchNumber}</p>
									</div>
									<label class="control-label col-xs-2"> <label >商品编号:</label>
									</label>
									<div class="col-xs-4">
										<p class="form-control-static">${stock.goodsNumber}</p>
									</div>
								</div>
								<div class="form-group">
									<label class="control-label col-xs-2"> <label >名称:</label>
									</label>
									<div class="col-xs-4">
										<p class="form-control-static">${stock.goodsName}</p>
									</div>
									<label class="control-label col-xs-2"> <label >数量:</label>
									</label>
									<div class="col-xs-4">
										<p class="form-control-static">${stock.num}</p>
									</div>
								</div>
								<div class="form-group">
									<label class="control-label col-xs-2"> <label >类型:</label>
									</label>
									<div class="col-xs-4">
										<p class="form-control-static">${stock.stockType.name}</p>
									</div>
									<label class="control-label col-xs-2"> <label >原因:</label>
									</label>
									<div class="col-xs-4">
										<p class="form-control-static">${stock.reason}</p>
									</div>
								</div>
								<div class="form-group">
									<label class="control-label col-xs-2"> <label >操作员:</label>
									</label>
									<div class="col-xs-4">
										<p class="form-control-static">${stock.createdBy}</p>
									</div>
									<label class="control-label col-xs-2"> <label >操作时间:</label>
									</label>
									<div class="col-xs-4">
										<p class="form-control-static"><fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss" value="${stock.created}"/></p>
									</div>
								</div>
							</div>
						</form>
					</div>
					<div class="modal-footer">
						<button type="button" onclick="top.layer.closeAll()" class="btn btn-default">返回</button>
					</div>

				<!--student-viewcon end-->