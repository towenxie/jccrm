<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/pages/comm/comm.jsp" %>
<script src="${context}/static/plugins/My97DatePicker/WdatePicker.js"></script>
<section class="content-header">
    <h1>
        核准出库
        <small></small>
    </h1>
    <ol class="breadcrumb">
        <li><a href="${context }/main"><i class="fa"><img src="${context }/static/dist/img/home_ico.png" width="10"
                                                          height="10"></i>首页</a></li>
        <li class="active">核准出库</li>
    </ol>
</section>
<section class="content">
    <div class="row">
        <!-- left column -->
        <div class="col-md-12">
            <!-- general form elements -->
            <div class="box box-primary">
                <!-- form start -->

                <form class="form-inline" id="searchForm">
                    <div class="box-body">

                        <div class="form-group">
                            <label>订单号</label>
                            <input class="form-control" value="${page.params.orderId}" name="orderId" placeholder=""
                                   type="text">
                        </div>
                        &nbsp;&nbsp;
                        <button type="button" onclick="initResult()" class="btn btn-primary">搜索</button>
                    </div>
                </form>

            </div>
            <!-- /.box -->
        </div>
        <!--/.col (left) -->
    </div>
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
                                            color="#f0f8ff">序号 ${ status.index + 1}</font></th>
                                    <th style="background-color: #0097bc;font-weight:normal"><font
                                            color="#f0f8ff">订单号 ${result.orderId}</font></th>
                                    <th style="background-color: #0097bc;font-weight:normal"><font
                                            color="#f0f8ff">配发数量 ${result.totalQty}</font></th>
                                    <th style="background-color: #0097bc;font-weight:normal"><font
                                            color="#f0f8ff">配送时段 ${result.timeType}</font></th>
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
                                        <td>${orderGoods.goods.location}</td>
                                        <td></td>
                                    </tr>
                                </c:forEach>
                                </tbody>
                            </table>
                        </div>
                        <div class="box-body">
                            <table class="table table-bordered">
                                <thead>
                                <tr>
                                    <td colspan="5" align="center"><b>签收情况</b></td>
                                </tr>
                                </thead>
                                <tbody>
                                <tr>
                                    <th>提货人姓名</th>
                                    <th>提货人身份证</th>
                                    <th>出库人签名</th>
                                    <th>出库时间</th>
                                </tr>
                                <tr>
                                    <td><input name="seller" type="text" class="form-control" style="text-align:center"  data-rule="提货人名字:required" placeholder="请输入提货人名字"/></td>
                                    <td><input name="seller" type="text" class="form-control" style="text-align:center"  data-rule="提货人身份证:required" placeholder="请输入提货人身份证"/></td>
                                    <td><input name="seller" type="text" class="form-control" style="text-align:center"  data-rule="出库人名字:required" placeholder="请输入出库人名字"/></td>
                                    <td><input name="receiptTime" onFocus="WdatePicker({dateFmt:'yyyy年MM月dd日 HH时mm分'})" type="text" class="form-control" style="text-align:center"  data-rule="出库时间:required" placeholder="请输入出库时间"/></td>
                                </tr>
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
    </div>
</section>
<input type="hidden" id="pageNo" name="pageNo" value="${page.pageNo }">
<script type="text/javascript">

    function queryResult() {
        $.ajax({
            url: "${context}/order/depot/list?distributionStatus=2&viewMode=check&pageNo=" + $("#pageNo").val(),
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
            url: "${context}/order/depot/list?distributionStatus=2&viewMode=check&pageNo=1",
            data: $("#searchForm").serialize(),
            type: "post",
            dataType: 'html',
            success: function (data) {
                $(".content-wrapper").html(data);
            }
        });
    }
</script>