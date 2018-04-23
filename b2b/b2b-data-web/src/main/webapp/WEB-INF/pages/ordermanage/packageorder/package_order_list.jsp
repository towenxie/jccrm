<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ include file="/WEB-INF/pages/comm/comm.jsp"%>
<script src="${context}/static/plugins/My97DatePicker/WdatePicker.js"></script>
<section class="content-header">
	<h1>
		发货部订单发货列表 <small></small>
	</h1>
	<ol class="breadcrumb">
		<li><a href="#"><i class="fa"><img
					src="${context}/static/dist/img/home_ico.png" width="10"
					height="10"></i>首页</a></li>
		<!--<li>我的订单</li>-->
		<li class="active">发货部订单发货列表</li>
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
                            <label>快递单号：</label> <input class="form-control"
                                value="${expressNumber}" name="expressNumber" id="" placeholder=""
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
                    <p>
                        <a class="btn btn-primary" onclick="pexportOrder()" href="#"
                            role="button" id="backuser-add">导出订单</a>
                    </p>
					<table class="table table-bordered" style="table-layout: fixed;">
						<tbody>
							<tr>
                                <th style="min-width: 125px;">订单号</th>
								<th style="width: 80px;">销售员</th>
								<th style="width: 80px;">部门</th>
								<th style="width: 60px;">金额</th>
								<th style="width: 80px;">收件人</th>
								<th>收货地址</th>
                                <th style="min-width: 90px;">快递单号</th>
                                <th style="width: 80px;">快递公司</th>
								<th style="width: 60px;">状态</th>
								<th style="min-width: 85px;">打包人</th>
								<th style="min-width: 85px;">录入人</th>
								<th style="width: 50px;">退货签收</th>
								<th style="width: 140px;">下单时间</th>
                                <th style="width: 60px;">授权发货</th>
								<th style="width: 95px;">操作</th>
							</tr>
							<c:forEach items="${page.results}" var="sys">
								<tr>
                                    <td style="font-size: 10px">
                                       <a onclick="orderinfo('${sys.orderNumber}')" href="#" role="button" id="backuser-add">${sys.orderNumber}</a>
                                    </td>
									<td>${sys.user.username}</td>
									<td>${sys.dept.name}</td>
									<td>${sys.totalPrice}</td>
									<td>${sys.username}</td>
                                    <td style="overflow: hidden;white-space:nowrap;text-overflow:ellipsis;-o-text-overflow:ellipsis;-moz-text-overflow: ellipsis;-webkit-text-overflow: ellipsis;">
                                      <a style="color: #333;" href ="javascript:volid(0);" data-toggle="tooltip" title="${sys.fullAddress}">${sys.fullAddress}</a>
                                    </td>
									<td style="font-size: 10px"><a href="https://www.kuaidi100.com/chaxun?com=${sys.expressCompanyCode}&nu=${sys.expressNumber}" target="_blank" >${sys.expressNumber}</a></td>
									<td>${sys.express.name}</td>
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
									<td>${sys.packageBy}</td>
									<td>${sys.deliverBy}</td>
									<td>
										<c:if test="${!sys.hasRund}"><a href="#" class="btn btn-primary btn-xs" onclick="peditFlag('${sys.orderNumber}')">否</a>
										</c:if>
										<c:if test="${sys.hasRund}">是
	                                    </c:if>
<%--                                         <a href="#" class="btn btn-primary btn-xs" onclick="${sys.hasRund? '':'peditFlag'}('${sys.orderNumber}')">${sys.hasRund?'是':'否'}</a> --%>
                                    </td>
									<td><fmt:formatDate pattern="yy-MM-dd HH:mm:ss"
											value="${sys.created}" />
									</td>
                                    <td>
                                        <c:if test="${'paid' eq sys.orderStatusCode}">
                                            <span style="color:#FF0000">待办</span>
                                        </c:if>
                                        <c:if test="${'paid' != sys.orderStatusCode}">
                                            <span style="color:#0000ff">已处理</span>
                                        </c:if>
                                    </td>
									<td style="width: 100px;">
										<a href="#" class="btn btn-primary btn-xs" id="student-bj" onclick="peditOrder('${sys.orderNumber}')">发货</a>
										<a href="#" class="btn btn-primary btn-xs" id="student-dc" onclick="porderinfo('${sys.orderNumber}')">打印</a>
									</td>
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
			url:'${context}/ordermanage/packageorder/querybypage',
			type:'post',
			data:$("#sysform").serialize(),
			dataType:'html',
			success:function(data){
				$(".content-wrapper").html(data);
			}
		})
	}
// 	// 导出订单
// 	function pexportOrder(){
// 		var ele = document.createElement("iframe");
// 		ele.src = '${context}/ordermanage/packageorder/export';
// 		ele.style.display = "none";
// 		document.body.appendChild(ele);
// 	}

	function peditOrder(orderNum){
		 $.ajax({
			url:'${context}/ordermanage/packageorder/updateinit',
			type:'post',
			data:{orderNum:orderNum},
			dataType:'html',
			success:function(data){
				layer.open({
					title: '发货信息',
					type: 1,
					skin: 'layui-layer-rim', //加上边框
					area: ['800px', '400'], //宽高
					content:data
				});
			}
		})
	}

	function porderinfo(orderNum){
		 $.ajax({
			url:'${context}/ordermanage/packageorder/info',
			type:'post',
			data:{orderNum:orderNum},
			dataType:'html',
			success:function(data){
				layer.open({
					title: '打印订单信息',
					type: 1,
					skin: 'layui-layer-rim', //加上边框
					area: ['1200px', 'auto'], //宽高
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
	function pexportOrder(){
		var createdBy = $("input[name=createdBy]").val();
		var customer = $("input[name=customer]").val();
        var orderNumber = $("input[name=orderNumber]").val();
        var expressNumber = $("input[name=expressNumber]").val();
        var startDate = $("input[name=startDate]").val();
        var endDate = $("input[name=endDate]").val();
        var orderDept = $("select[name=orderDept]").val();
        var orderPayment = $("select[name=orderPayment]").val();
        var orderStatus = $("select[name=orderStatus]").val();
		
		var ele = document.createElement("iframe");
		ele.src = '${context}/ordermanage/packageorder/export?orderNumber='+orderNumber+'&expressNumber='+expressNumber+'&createdBy='+createdBy+'&customer='+customer+'&startDate='+startDate+'&endDate='+endDate+'&orderDept='+orderDept+'&orderPayment='+orderPayment+'&orderStatus='+orderStatus;
		ele.style.display = "none";
		document.body.appendChild(ele);
	}

    function peditFlag(obj){
        $.ajax({
            url:'${context}/ordermanage/hasrefund',
            type:'post',
            data:{orderNumber:obj},
            dataType:'json',
            success:function(data){
                layer.msg(data.msg);
                if(data.code == 200){
                setTimeout(
                    function(){
                    queryResult();
                    },1500);
                }
            }
        })
    }
</script>