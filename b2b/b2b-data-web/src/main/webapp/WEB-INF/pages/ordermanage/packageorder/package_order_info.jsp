<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ include file="/WEB-INF/pages/comm/comm.jsp"%>
<!--student-viewcon st-->
<div class="modal-body" id="dy">
	<table class="table table-bordered">
		<tbody>
			<tr>
				<th>订单号</th>
				<th>收件人</th>
				<th>收件人电话</th>
				<th>收货地址</th>
				<th>收货内容</th>
				<th>付款方式</th>
				<th>付款金额</th>
				<th>寄件人</th>
				<th>寄件人电话</th>
			</tr>
			<c:forEach items="${orders}" var="sys">
				<tr>
					<td width="180px">${sys.orderNumber}</td>
					<td width="100px">${sys.username}</td>
					<td width="130px">${sys.phone}</td>
					<td width="200px">${sys.fullAddress}</td>
					<td width="200px">${sys.remark}</td>
<%-- 					<td width="200px"><c:forEach items="${sys.goods}" var="goods"> --%>
<%-- 							<p>${goods.goods.name}${goods.qty}${goods.goods.unit};</p> --%>
<%-- 						</c:forEach></td> --%>
					<td width="100px">${sys.payment.name}</td>
					<td width="60px">${sys.totalPrice}</td>
					<td width="100px">${sys.user.username}</td>
					<td width="130px">${sys.user.phone}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</div>
<div class="modal-footer">
	<button type="button" onclick="return PrintTable(dy)"
		class="btn btn-primary">打印</button>
	<button type="button" onclick="top.layer.closeAll()"
		class="btn btn-default">返回</button>
</div>

<!--student-viewcon end-->
、
<script type="text/javascript">
		function PrintTable(Id){
		     var mStr;
		     mStr = window.document.body.innerHTML ;
		     var mWindow = window;               
		     window.document.body.innerHTML =Id.innerHTML;
		     mWindow.print();
		     window.document.body.innerHTML = mStr;
		     top.layer.closeAll();
		}
</script>