<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/pages/comm/comm.jsp" %>
<script src="${context}/static/plugins/My97DatePicker/WdatePicker.js"></script>
<section class="content-header">
    <h1>
        未配发订单
        <small></small>
    </h1>
    <ol class="breadcrumb">
        <li><a href="${context }/main"><i class="fa"><img src="${context }/static/dist/img/home_ico.png" width="10"
                                                          height="10"></i>首页</a></li>
        <li class="active">未配发订单</li>
    </ol>
</section>
<section class="content">
    <div class="row">
        <!-- left column -->
        <div class="col-md-12">
            <!-- general form elements -->
            <div class="box box-primary">
                <!-- form start -->
                    <div class="box-body">
                        <button type="button" onclick="undistributionListDetail()" class="btn btn-danger">打印配货</button>
                    </div>
            </div>
            <!-- /.box -->
        </div>
        <!--/.col (left) -->
    </div>
    <div class="clearfix"></div>
    <div class="row">
        <c:forEach items="${page.results }" var="result" varStatus="status">
            <div class="col-md-12">
                <div class="box box-primary">
                    <div class="box-body">
                        <table class="table table-bordered">
                            <thead>
                            <tr>
                                <th style="background-color: #0097bc;font-weight:normal"><font color="#f0f8ff">序号${ status.index + 1}</font></th>
                                <th style="background-color: #0097bc;font-weight:normal"><font color="#f0f8ff">订单号${result.orderId}</font></th>
                                <th style="background-color: #0097bc;font-weight:normal"><font color="#f0f8ff">配发数量 ${result.totalQty}</font></th>
                                <th style="background-color: #0097bc;font-weight:normal"><font color="#f0f8ff">配送时段${result.timeType}</font></th>
                            </tr>
                            </thead>
                            <tbody>
                            <tr>
                                <th colspan="2">配发商品</th>
                                <th colspan="2">配货数量(件)</th>
                            </tr>

                            <c:forEach items="${result.goods }" var="orderGoods">
                                <tr>
                                    <td colspan="2">${orderGoods.goods.name} ${orderGoods.goods.packingCount}/${orderGoods.goods.packing}</td>
                                    <td colspan="2">${orderGoods.qty}</td>
                                </tr>
                            </c:forEach>
                            </tbody>
                        </table>
                    </div>

                </div>
                <!-- /.col -->
            </div>
        </c:forEach>
        <!-- /.box-body -->
        <%@ include file="/WEB-INF/pages/comm/page.jsp" %>
    </div>
</section>
<input type="hidden" id="pageNo" name="pageNo" value="${page.pageNo }">
<script type="text/javascript">
    function detailFun(transportNo) {
        $.ajax({
            url: "${context}/goodsInside/detail?transportNo=" + transportNo,
            dataType: "html",
            success: function (data) {
                layer.open({
                    title: '入库详情',
                    type: 1,
                    skin: 'layui-layer-rim', //加上边框
                    area: ['800px', '500px'], //宽高
                    content: data
                });
            }
        });
    }

    function queryResult() {
        $.ajax({
            url: "${context}/order/depot/list?distributionStatus=0&pageNo=" + $("#pageNo").val(),
            data: $("#searchForm").serialize(),
            type: "post",
            dataType: 'html',
            success: function (data) {
                $(".content-wrapper").html(data);
            }
        });
    }

    function initResult() {
        $.ajax({
            url: "${context}/order/depot/list?distributionStatus=0&pageNo=1",
            data: $("#searchForm").serialize(),
            type: "post",
            dataType: 'html',
            success: function (data) {
                $(".content-wrapper").html(data);
            }
        });
    }
</script>