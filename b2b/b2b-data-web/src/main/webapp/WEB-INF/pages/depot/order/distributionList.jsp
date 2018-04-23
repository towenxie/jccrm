<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/pages/comm/comm.jsp" %>
<script src="${context}/static/plugins/My97DatePicker/WdatePicker.js"></script>
<section class="content-header">
    <h1>
        已配发订单
        <small></small>
    </h1>
    <ol class="breadcrumb">
        <li><a href="${context }/main"><i class="fa"><img src="${context }/static/dist/img/home_ico.png" width="10"
                                                          height="10"></i>首页</a></li>
        <li class="active">已配发订单</li>
    </ol>
</section>
<section class="content">
    <div class="clearfix"></div>
    <div class="row">
        <c:if test="${page.results.size()>0 }">
            <c:forEach items="${page.results }" var="result" varStatus="status">
                <div class="col-md-12">
                    <div class="box box-primary">
                        <div class="box-body">
                            <table class="table table-bordered">
                                <thead>
                                <tr>
                                    <th style="background-color: #0097bc;font-weight:normal"><font
                                            color="#f0f8ff">序号${ status.index + 1}</font></th>
                                    <th style="background-color: #0097bc;font-weight:normal"><font
                                            color="#f0f8ff">订单号${result.orderId}</font></th>
                                    <th style="background-color: #0097bc;font-weight:normal"><font
                                            color="#f0f8ff">配发数量 ${result.totalQty}</font></th>
                                    <th style="background-color: #0097bc;font-weight:normal"><font
                                            color="#f0f8ff">配送时段${result.timeType}</font></th>
                                </tr>
                                </thead>
                                <tbody>
                                <tr>
                                    <th>配发商品</th>
                                    <th>配货数量(件)</th>
                                    <th>商品所在区域</th>
                                    <th>商品批号</th>
                                </tr>

                                <c:forEach items="${result.goods }" var="orderGoods">
                                    <tr>
                                        <td>${orderGoods.goods.name} ${orderGoods.goods.packingCount}/${orderGoods.goods.packing}</td>
                                        <td>${orderGoods.qty}</td>
                                        <td>${orderGoods.qty}</td>
                                        <td>${orderGoods.qty}</td>
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
            <div id="detail-bjcon" style="display: none"></div>
        </c:if>
        <c:if test="${page.results.size()==null }">
            <div class="col-md-12">
                <div class="box box-primary">
                    <div class="box-body">
                        <table class="table table-bordered">
                            <tbody>
                            <tr>
                                <td colspan="5" align="center">很抱歉，暂时没有记录</td>
                            </tr>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
        </c:if>
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
            url: "${context}/order/depot/list?distributionStatus=2&pageNo=" + $("#pageNo").val(),
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
            url: "${context}/order/depot/list?distributionStatus=2&pageNo=1",
            data: $("#searchForm").serialize(),
            type: "post",
            dataType: 'html',
            success: function (data) {
                $(".content-wrapper").html(data);
            }
        });
    }
</script>