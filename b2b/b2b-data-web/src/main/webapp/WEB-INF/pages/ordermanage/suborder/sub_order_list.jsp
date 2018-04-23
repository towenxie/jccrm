<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ include file="/WEB-INF/pages/comm/comm.jsp"%>
<script src="${context}/static/plugins/My97DatePicker/WdatePicker.js"></script>
<section class="content-header">
	<h1>
		下属订单 <small></small>
	</h1>
	<ol class="breadcrumb">
		<li><a href="#"><i class="fa"><img
					src="${context}/static/dist/img/home_ico.png" width="10"
					height="10"></i>首页</a></li>
		<!--<li>我的订单</li>-->
		<li class="active">下属订单</li>
	</ol>
</section>
<!-- Main content -->
<section class="content">
	<div class="row">
		<!-- left column -->
		<div class="col-md-12">
			<!-- general form elements -->
			<div class="box box-primary">
				<!-- form start -->

				<form class="form-inline" id="sysform">
					<div class="box-body">

						<div class="form-group">
							<label>订单号：</label> <input class="form-control"
								value="${orderNumber}" name="orderNumber" id="" placeholder=""
								type="text">
						</div>
                        <div class="form-group">
                            <label>销售：</label> <input class="form-control"
                                value="${createdBy}" name="createdBy" id="" placeholder=""
                                type="text">
                        </div>
                        <div class="form-group">
                            <label>客户：</label> <input class="form-control"
                                value="${customer}" name="customer" id="" placeholder=""
                                type="text">
                        </div>
						<div class="form-group">
							<label>科室：</label> <select class="form-control" name="orderDept">
								<option selected="" value="">科室</option>
								<c:forEach items="${depts}" var="d">
									<option ${d.code eq orderDept?'selected':''} value="${d.code}">${d.name}</option>
								</c:forEach>
							</select>
						</div>
						<div class="form-group">
							<label>付款方式：</label> <select class="form-control" name="orderPayment">
								<option selected="" value="">付款方式</option>
								<c:forEach items="${payments}" var="r">
									<option ${r.code eq orderPayment?'selected':''} value="${r.code}">${r.name}</option>
								</c:forEach>
							</select>
						</div>
						<div class="form-group">
							<label>订单状态：</label> <select class="form-control" name="orderStatus">
								<option selected="" value="">订单状态</option>
								<c:forEach items="${status}" var="r">
									<option ${r.code eq orderStatus?'selected':''} value="${r.code}">${r.name}</option>
								</c:forEach>
							</select>
						</div>
                        <div class="form-group">
                            <label >下单时间：从</label>
                            <input class="form-control" onFocus="WdatePicker()" value="${startDate}" name="startDate"  placeholder="" type="text">
                        </div>

                        <div class="form-group">
                            <label >至</label>
                            <input class="form-control" onFocus="WdatePicker()" value="${endDate}" name="endDate"  placeholder="" type="text">
                        </div>
						<input name="pageNo" type="hidden" id="pageNo"
							value="${page.pageNo}" />
						<button type="button" onclick="queryResult()"
							class="btn btn-primary">搜索</button>
					</div>
				</form>

			</div>
			<!-- /.box -->
		</div>
		<!--/.col (left) -->
	</div>

	<div class="clearfix"></div>
	<div class="row">
		<div class="col-md-12">
			<div class="box box-primary">
				<div class="box-body">
<!-- 					<p> -->
<!-- 						<a class="btn btn-primary" onclick="addorder()" href="#" -->
<!-- 							role="button" id="backuser-add">新增订单</a> -->
<!-- 						<a class="btn btn-primary" onclick="exportorder()" href="#" -->
<!-- 							role="button" id="backuser-add">导出订单</a> -->
<!-- 					</p> -->
					<table class="table table-bordered" style="table-layout: fixed;">
						<tbody>
							<tr>
                                <th style="width: 175px;">订单号</th>
                                <th style="width: 70px;">销售员</th>
                                <th style="width: 80px;">部门</th>
                                <th style="width: 60px;">金额</th>
                                <th style="width: 80px;">收件人</th>
                                <th>收货地址</th>
                                <th style="width: 130px;">快递单号</th>
                                <th style="width: 80px;">快递公司</th>
                                <th style="width: 90px;">付款方式</th>
                                <th style="width: 60px;">状态</th>
                                <th style="width: 140px;">下单时间</th>
							</tr>
							<c:forEach items="${page.results}" var="sys">
								<tr>
                                    <td>
                                       <a onclick="orderinfo('${sys.orderNumber}')" href="#" role="button" id="backuser-add">${sys.orderNumber}</a>
                                    </td>
									<td>${sys.user.username}</td>
									<td>${sys.dept.name}</td>
									<td>${sys.totalPrice}</td>
									<td>${sys.username}</td>
                                    <td style="overflow: hidden;white-space:nowrap;text-overflow:ellipsis;-o-text-overflow:ellipsis;-moz-text-overflow: ellipsis;-webkit-text-overflow: ellipsis;">
                                      <a style="color: #333;" href ="javascript:volid(0);" data-toggle="tooltip" title="${sys.fullAddress}">${sys.fullAddress}</a>
                                    </td>
									<td><a href="https://www.kuaidi100.com/chaxun?com=${sys.expressCompanyCode}&nu=${sys.expressNumber}" target="_blank" >${sys.expressNumber}</a></td>
									<td>${sys.express.name}</td>
									<td>${sys.payment.name}</td>
                                    <td>
                                        <c:if test="${'pending' eq sys.orderStatusCode}">
                                            <span style="color:#000000">${sys.orderStatus.name}</span>
                                        </c:if>
                                        <c:if test="${'paid' eq sys.orderStatusCode }">
                                            <span style="color:#fa8c35">${sys.orderStatus.name}</span>
                                        </c:if>
                                        <c:if test="${'shipped' eq sys.orderStatusCode}">
                                            <span style="color:#0000ff">${sys.orderStatus.name}</span>
                                        </c:if>
                                        <c:if test="${'completed' eq sys.orderStatusCode}">
                                            <span style="color:#00e500">${sys.orderStatus.name}</span>
                                        </c:if>
                                        <c:if test="${'rejecting' eq sys.orderStatusCode || 'rejected' eq sys.orderStatusCode}">
                                            <span style="color:#FF0000">${sys.orderStatus.name}</span>
                                        </c:if>
                                        <c:if test="${'refunding' eq sys.orderStatusCode || 'refunded' eq sys.orderStatusCode}">
                                            <span style="color:#8d4bbb">${sys.orderStatus.name}</span>
                                        </c:if>
                                        <c:if test="${'expired' eq sys.orderStatusCode}">
                                            <span style="color:#808080">${sys.orderStatus.name}</span>
                                        </c:if>
                                    </td>
									<td><fmt:formatDate pattern="yy-MM-dd HH:mm:ss"
											value="${sys.created}" />
									</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
				<div style="text-align:right; color: #f00; margin-right: 50px;">总销售额：${totalPrice}</div>
				<!-- /.box-body -->
				<div class="clearfix"></div>
				<div class="clearfix"></div>
				<%@include file="/WEB-INF/pages/comm/page.jsp"%>

				<!--用户信息-->
				<div id="student-viewcon" style="display: none;"></div>

			</div>
			<!-- /.box -->
		</div>
		<!-- /.col -->
	</div>

</section>
<script type="text/javascript">
	function queryResult(){
		$.ajax({
			url:'${context}/ordermanage/suborder/querybypage',
			type:'post',
			data:$("#sysform").serialize(),
			dataType:'html',
			success:function(data){
				$(".content-wrapper").html(data);
			}
		})
	}
	// 导出订单
	function exportorder(){
		var ele = document.createElement("iframe");
		ele.src = '${context}/ordermanage/myorder/export';
		ele.style.display = "none";
		document.body.appendChild(ele);
	}
	// 新增订单
	function addorder(){
		 $.ajax({
			url:'${context}/ordermanage/myorder/addinit',
			type:'post',
			dataType:'html',
			success:function(data){
				layer.open({
					title: '新增订单',
					type: 1,
					skin: 'layui-layer-rim', //加上边框
					area: ['1100px', '500'], //宽高
					content:data
				});
			}
		})
	}
    // 订单信息
    function orderinfo(orderNum){
         $.ajax({
            url:'${context}/ordermanage/detail',
            type:'post',
            data:{orderNum:orderNum},
            dataType:'html',
            success:function(data){
                layer.open({
                    title: '订单信息',
                    type: 1,
                    skin: 'layui-layer-rim', //加上边框
                    area: ['800px', 'auto'], //宽高
                    content:data
                });
            }
        })
    }
</script>