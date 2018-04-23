<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ include file="/WEB-INF/pages/comm/comm.jsp"%>
<script src="${context}/static/plugins/My97DatePicker/WdatePicker.js"></script>
<section class="content-header">
	<h1>
		财务报表 <small></small>
	</h1>
	<ol class="breadcrumb">
		<li><a href="#"><i class="fa"><img
					src="${context}/static/dist/img/home_ico.png" width="10"
					height="10"></i>首页</a></li>
		<!--<li>我的订单</li>-->
		<li class="active">财务报表</li>
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
                            <label >下单时间：从</label>
                            <input class="form-control" onFocus="WdatePicker()" value="${startDate}" name="startDate"  placeholder="" type="text">
                        </div>

                        <div class="form-group">
                            <label >至</label>
                            <input class="form-control" onFocus="WdatePicker()" value="${endDate}" name="endDate"  placeholder="" type="text">
                        </div>
                        <div class="form-group">
                            <label>欠款原因：</label> <select class="form-control" name=reasonName>
                                <option selected="" value="">原因</option>
                                <c:forEach items="${reasons}" var="r">
                                    <option ${r.name eq reasonName?'selected':''} value="${r.name}">${r.name}</option>
                                </c:forEach>
                            </select>
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
					<p>
<!-- 						<a class="btn btn-primary" onclick="addorder()" href="#" -->
<!-- 							role="button" id="backuser-add">新增订单</a> -->
						<a class="btn btn-primary" onclick="opexportorder()" href="#"
							role="button" id="backuser-add">导出订单</a>
					</p>
					<table class="table table-bordered">
						<tbody>
							<tr>
								<th>订单号</th>
								<th>销售员</th>
								<th>客户名称</th>
								<th>下单时间</th>
								<th>原价总额</th>
								<th>订单总额</th>
								<th>预收定金</th>
								<th>快递费</th>
								<th>代收费%</th>
								<th>代收手续费</th>
								<th>实收总额</th>
								<th>欠款总额</th>
								<th>原因</th>
								<th>退货明细</th>
								<th>退货总额</th>
							</tr>
							<c:forEach items="${page.results}" var="sys">
								<tr>
									<td>
									<a onclick="orderinfo('${sys.orderNumber}')" href="#" role="button" id="backuser-add">${sys.orderNumber}</a>
									</td>
									<td>${sys.user.username}</td>
									<td>${sys.username}</td>
                                    <td><fmt:formatDate pattern="yy-MM-dd HH:mm:ss"
                                            value="${sys.created}" />
                                    </td>
									<td>${sys.orlTotalPrice}</td>
									<td>${sys.totalPrice}</td>
									<td>${sys.depositPrice}</td>
									<td>${sys.sendPrice}</td>
									<td>${sys.replaceProfit}</td>
									<td>${sys.replacePrice}</td>
									<td>${sys.hasDaikuang? sys.totalPrice - sys.replacePrice - sys.sendPrice - sys.refundPrice :sys.depositPrice}</td>
									<td>${sys.hasDaikuang? 0 :sys.totalPrice - sys.depositPrice}</td>
									<td>${sys.reasonName}</td>
									<td>${sys.refundDetail}</td>
									<td>${sys.refundPrice}</td>

								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
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
			url:'${context}/reportmanage/orderpricelist',
			type:'post',
			data:$("#sysform").serialize(),
			dataType:'html',
			success:function(data){
				$(".content-wrapper").html(data);
			}
		})
	}
	// 导出订单
	function opexportorder(){
	    var startDate = $("input[name=startDate]").val();
	    var endDate = $("input[name=endDate]").val();
	    var reasonName = $("select[name=reasonName]").val();
	    
		var ele = document.createElement("iframe");
		ele.src = '${context}/reportmanage/priceexport?reasonName='+reasonName+'&startDate='+startDate+'&endDate='+endDate;
		ele.style.display = "none";
		document.body.appendChild(ele);
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