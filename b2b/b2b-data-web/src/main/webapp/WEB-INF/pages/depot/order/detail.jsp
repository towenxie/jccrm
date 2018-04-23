<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/pages/comm/comm.jsp" %>
<script src="${context}/static/plugins/My97DatePicker/WdatePicker.js"></script>
<script type="text/javascript" src="${context}/static/nice-validator/jquery.validator.js"></script>
<div id="student-viewcon">
	<div class="modal-body">
		<section class="content">
			<div class="clearfix"></div>
			<div class="row">
				<div class="col-md-12">
					<div class="box box-primary">
						<div class="box-body">
								<table class="table table-bordered">
									<tbody>
									<tr>
										<th>货号</th>
										<th>货品名称</th>
										<th>数量</th>
										<th>单位</th>
										<th>生产日期</th>
										<th width="100">保质期</th>
										<th>实际入库</th>
										<th>入库区</th>
									</tr>

									<c:forEach items="${dataList }" var="depotIn">
										<tr>
											<td>${depotIn.goodsDetailEntity.goodsNumber}</td>
											<td>${depotIn.goodsDetailEntity.name}</td>
											<td>${depotIn.transportNum}</td>
											<td>${depotIn.goodsDetailEntity.unit}</td>
											<td><fmt:formatDate pattern="yyyy-MM-dd" value="${depotIn.makeTime}"/></td>
											<td><fmt:formatDate pattern="yyyy-MM-dd" value="${depotIn.goodsDetailEntity.shelfLife}"/></td>
											<td>${depotIn.inNum}</td>
											<td>${depotIn.goodsLocation}</td>
										</tr>
									</c:forEach>
									</tbody>
								</table>
						</div>
					</div>
					<!-- /.col -->
				</div>
			</div>
		</section>
	</div>
	<!--student-viewcon end-->
</div>
<script type="text/javascript">
    function closeFun() {
        layer.closeAll();
    }
</script>