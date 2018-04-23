<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ include file="/WEB-INF/pages/comm/comm.jsp"%>
<script src="${context}/static/plugins/My97DatePicker/WdatePicker.js"></script>
<section class="content-header">
	<h1>
		未配发订单 <small></small>
	</h1>
	<ol class="breadcrumb">
		<li><a href="${context }/main"><i class="fa"><img src="${context }/static/dist/img/home_ico.png" width="10"
														  height="10"></i>首页</a></li>
		<li class="active">未配发订单</li>
	</ol>
</section>
<section class="content">
	<div class="clearfix"></div>
	<div class="row">
		<div class="col-md-12">
			<div class="box box-primary">
				<div class="box-body">
					<table class="table table-bordered">
						<tbody>
						<tr>
							<th>订单号</th>
							<th>下单时间</th>
							<th>配送仓库</th>
							<th>下单账户</th>
							<th>收货人</th>
							<th>实付金额</th>
							<th>操作</th>
						</tr>

						<c:forEach items="${page.results }" var="result">
							<tr>
								<td>${result.orderId}</td>
								<td><fmt:formatDate pattern="yyyy-MM-dd HH:mm" value="${result.created}"/></td>
								<td>${result.depot.depotName}</td>
								<td>${result.address.shopName}</td>
								<td>${result.address.fullname}</td>
								<td>${result.total}</td>
								<td>
									<a href="#" class="btn btn-primary btn-xs" onclick="detailFun('${result.orderId}')">订单详情</a>
									<a href="#" class="btn btn-primary btn-xs" onclick="distribution('${result.orderId}')">订单配发</a>
								</td>
							</tr>
						</c:forEach>
						</tbody>
					</table>
				</div>
				<!-- /.box-body -->
				<%@ include file="/WEB-INF/pages/comm/page.jsp"%>
			</div>
			<!-- /.col -->
		</div>
	</div>

</section>
<input type="hidden" id="pageNo" name="pageNo" value="${page.pageNo }">
<script type="text/javascript">
	function detailFun(orderId) {
		$.ajax({
			url : "${context}/order/detail?orderId="+orderId,
			dataType : "html",
			success : function(data) {
				layer.open({
					title : '订单详情',
					type : 1,
					skin : 'layui-layer-rim', //加上边框
					area : [ '800px', '500px' ], //宽高
					content : data
				});
			}
		});
	}
    function distribution(orderId) {
        layer.confirm('开始配发订单，配发后无法取消！', {
            btn: ['确定配发','再考虑一下'] //按钮
        }, function(){
            $.ajax({
                url:'${context}/order/distribution',
                type:'post',
                data:{orderId:orderId},
                dataType:'json',
                success:function(data){
                    layer.msg(data.msg);
                    if(data.code == 200){
                        setTimeout(
                            function(){
                                queryResult();
                                top.layer.closeAll();
                            },1500);
                    }
                }
            })
        }, function(){

        });

    }

	function queryResult() {
		$.ajax({
			url : "${context}/order/manage/list?distributionStatus=0&pageNo=" + $("#pageNo").val(),
			data : $("#searchForm").serialize(),
			type : "get",
			dataType : 'html',
			success : function(data) {
				$(".content-wrapper").html(data);
			}
		});
	}

    function initResult() {
        $.ajax({
            url : "${context}/goodsInside/list?pageNo=1",
            data : $("#searchForm").serialize(),
            type : "post",
            dataType : 'html',
            success : function(data) {
                $(".content-wrapper").html(data);
            }
        });
    }
</script>