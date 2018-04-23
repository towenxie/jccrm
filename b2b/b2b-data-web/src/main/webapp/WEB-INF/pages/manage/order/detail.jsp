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
										<th>货品名称</th>
										<th>数量</th>
										<th>单位</th>
										<th>促销信息</th>
										<th>实出数</th>
									</tr>

									<c:forEach items="${orderGoods}" var="orderGoods">
										<tr>
											<td>${orderGoods.goods.name}</td>
											<td>${orderGoods.qty}</td>
											<td>${orderGoods.goods.unit}</td>
											<td></td>
											<td>${orderGoods.qty}</td>
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