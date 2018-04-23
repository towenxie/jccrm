<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ include file="/WEB-INF/pages/comm/comm.jsp"%>
<!--student-viewcon st-->
    <div class="modal-body">
        <form class="form-horizontal" id="" action=""
            accept-charset="UTF-8" method="post">
    <div class="clearfix"></div>
        <div class="form-body">
        <div class="form-group">
            <label class="control-label col-xs-2">订单编号:</label>
            <div class="col-xs-4">
                <p class="form-control-static">${order.orderNumber}</p>
            </div>
            <label class="control-label col-xs-2"> 状态:</label>
            <div class="col-xs-4">
                <p class="form-control-static">${order.orderStatus.name}</p>
            </div>
        </div>
        <div class="form-group">
            <label class="control-label col-xs-2">销售员:</label>
            <div class="col-xs-4">
                <p class="form-control-static">${order.user.username}</p>
            </div>
            <label class="control-label col-xs-2"> 销售科室:</label>
            <div class="col-xs-4">
                <p class="form-control-static">${order.dept.name}</p>
            </div>
        </div>
        <div class="form-group">
            <label class="control-label col-xs-2">收件人:</label>
            <div class="col-xs-4">
                <p class="form-control-static">${order.username}</p>
            </div>
            <label class="control-label col-xs-2">收件人电话:</label>
            <div class="col-xs-4">
                <p class="form-control-static">${order.phone}</p>
            </div>
        </div>
        <div class="form-group">
            <label class="control-label col-xs-2">物流公司:</label>
            <div class="col-xs-4">
                <p class="form-control-static">${order.express.name}</p>
            </div>
            <label class="control-label col-xs-2">快递号码:</label>
            <div class="col-xs-4">
             <p class="form-control-static">${order.expressNumber}</p>
            </div>
        </div>
        <div class="form-group">
            <label class="control-label col-xs-2">付款方式:</label>
            <div class="col-xs-4">
             <p class="form-control-static">${order.payment.name}</p>
            </div>
            <label class="control-label col-xs-2">下单时间:</label>
            <div class="col-xs-4">
                <p class="form-control-static"><fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss"
                                            value="${order.created}" /></p>
            </div>
        </div>
        <div class="form-group">
            <label class="control-label col-xs-2">收货地址:</label>
            <div class="col-xs-10">
                <p class="form-control-static">${order.address}</p>
            </div>
        </div>
        <div class="form-group">
            <label class="control-label col-xs-2">订单备注:</label>
            <div class="col-xs-10">
                <textarea class="form-control " readonly name="remark">${order.remark}</textarea>
            </div>
        </div>
        
    <div class="row">
        <div class="col-md-12">
            <div class="box box-primary">
                <div class="box-body">
                    <table class="table table-bordered">
                        <tbody>
                        <tr align="center">
                            <th width="200px">商品</th>
                            <th width="200px">单位</th>
                            <th width="200px">价格</th>
                            <th width="200px">数量</th>
                            <th width="200px">折扣(%)</th>
                            <th width="200px">总金额</th>
                        </tr>
                        <tbody id="tb">
                            <c:forEach items="${order.goods}" var="sys">
                                <tr>
                                    <td>${sys.goods.name}</td>
                                    <td>${sys.goods.unit}</td>
                                    <td>${sys.prePrice}</td>
                                    <td>${sys.qty}</td>
                                    <td>${sys.profit}</td>
                                    <td>${sys.totalPrice}</td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                </div>
                <!-- /.box-body -->
            </div>
            <!-- /.col -->
        </div>
    </div>
    <div style="text-align:right; color: #f00; margin-right: 50px;">总价格：${order.totalPrice}</div>
    </div>
    </form>
    <div class="modal-footer">
        <button type="button" class="btn btn-default" onclick="result()">取消</button>
    </div>
</div>
<script type="text/javascript">
    function result() {
        top.layer.closeAll();
    }
</script>