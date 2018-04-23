<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ include file="/WEB-INF/pages/comm/comm.jsp"%>
<script src="${context}/static/plugins/My97DatePicker/WdatePicker.js"></script>
<section class="content-header">
    <h1>
        往月利润 <small></small>
    </h1>
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
                            <label >从</label>
                            <input class="form-control" onFocus="WdatePicker()" value="${start}" name="start"  placeholder="" type="text">
                        </div>

                        <div class="form-group">
                            <label >至</label>
                            <input class="form-control" onFocus="WdatePicker()" value="${end}" name="end"  placeholder="" type="text">
                        </div>
                        <button type="button" onclick="queryResult()" class="btn btn-primary">查看</button>
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
                        <tbody>
                        <tr>
                            <th>货号</th>
                            <th>货品名称</th>
                            <th>进货价(元/件)</th>
                            <th>卖货价(元/件)</th>
                            <th>配送费(元/件)</th>
                            <th>利润</th>
                            <th>销售量</th>
                            <th>单位</th>
                            <th>小计(元)</th>
                        </tr>
                        <c:forEach items="${list }" var="result">
                            <tr>
                                <td>${result.goodsNumber}</td>
                                <td>${result.name}</td>
                                <td>${result.cbPrice}</td>
                                <td>${result.price}</td>
                                <td>${result.psPrice}</td>
                                <td>${result.profit}</td>
                                <td>${result.saleCount}</td>
                                <td>${result.unit}</td>
                                <td>${result.total}</td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>
            <!-- /.col -->
        </div>
    </div>
</section>
<script type="text/javascript">
    function queryResult() {
        $.ajax({
            url: "${context}/manage/profit/list",
            data: $("#searchForm").serialize(),
            type: "post",
            dataType:"html",
            success: function (data) {
                $(".content-wrapper").html(data);
            }
        });
    }
</script>