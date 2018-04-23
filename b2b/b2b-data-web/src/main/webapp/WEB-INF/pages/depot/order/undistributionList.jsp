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

                <form class="form-inline" id="searchForm">
                    <div class="box-body">

                        <div class="form-group">
                            <label>厂家名</label>
                            <input class="form-control" value="${page.params.firm}" name="firm" placeholder=""
                                   type="text">
                        </div>
                        &nbsp;&nbsp;
                        <div class="form-group">
                            <label>从</label>
                            <input class="form-control" onFocus="WdatePicker()" value="${page.params.startTime}"
                                   name="startTime" placeholder="" type="text">
                        </div>

                        <div class="form-group">
                            <label>至</label>
                            <input class="form-control" onFocus="WdatePicker()" value="${page.params.endTime}"
                                   name="endTime" placeholder="" type="text">
                        </div>
                        <button type="button" onclick="initResult()" class="btn btn-primary">搜索</button>
                        <button type="button" onclick="undistributionListDetail()" class="btn btn-danger">查看详单</button>
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
                    <table class="table table-bordered">
                        <thead>
                        <tr>
                            <th>序号</th>
                            <th>订单号</th>
                            <th>配发数量</th>
                            <th>配送时段</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach items="${page.results }" var="result" varStatus="status">
                            <tr>
                                <td>${status.index + 1}</td>
                                <td>${result.orderId}</td>
                                <td>${result.totalQty}</td>
                                <td>${result.timeType}</td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                </div>

            </div>
            <!-- /.col -->
        </div>

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
            url: "${context}/order/depot/list?distributionStatus=1&pageNo=" + $("#pageNo").val(),
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
            url: "${context}/order/depot/list?distributionStatus=1&pageNo=1",
            data: $("#searchForm").serialize(),
            type: "post",
            dataType: 'html',
            success: function (data) {
                $(".content-wrapper").html(data);
            }
        });
    }

    function undistributionListDetail() {
        $.ajax({
            url: "${context}/order/depot/list?distributionStatus=1&viewMode=detail&pageNo=1",
            type: "post",
            dataType: 'html',
            success: function (data) {
                $(".content-wrapper").html(data);
            }
        });
    }
</script>