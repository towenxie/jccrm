<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/pages/comm/comm.jsp" %>
<script src="${context}/static/plugins/My97DatePicker/WdatePicker.js"></script>
<section class="content-header">
    <h1>
        入库清单
        <small></small>
    </h1>
    <ol class="breadcrumb">
        <li><a href="${context }/main"><i class="fa"><img src="${context }/static/dist/img/home_ico.png" width="10"
                                                          height="10"></i>首页</a></li>
        <li class="active">入库清单</li>
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
                    </div>
                </form>

            </div>
            <!-- /.box -->
        </div>
        <!--/.col (left) -->
    </div>
    <div class="clearfix"></div>
    <c:forEach items="${page.results }" var="result">
        <div class="row">
            <div class="col-md-12">
                <div class="box box-primary">
                    <div class="box-body">
                        <table class="table table-bordered">
                            <thead>
                            <tr>
                                <td colspan="8" align="center"><b>配货单号：${obj.transportNo}</b></td>
                            </tr>
                            <tr>
                                <th colspan="1">配送厂家</th>
                                <td colspan="3">${obj.firm}</td>
                                <th colspan="1">总件数</th>
                                <td colspan="3">${obj.sum}</td>
                            <tr>
                            </thead>
                            <tbody>
                            <tr>
                                <th>货号</th>
                                <th>货品名称</th>
                                <th>数量</th>
                                <th>单位</th>
                                <th>生产日期</th>
                                <th width="100">保质期</th>
                                <th>实际入库</th>
                                <th>入库区</th>
                            </tr>
                            <input name="transportNo" value="${obj.transportNo}" type="hidden"/>
                            <c:forEach items="${depotIns }" var="depotIn">
                                <input name="ids" value="${depotIn.id}" type="hidden"/>
                                <tr>
                                    <td>${depotIn.goodsDetailEntity.goodsNumber}</td>
                                    <td>${depotIn.goodsDetailEntity.name}</td>
                                    <td>${depotIn.transportNum}</td>
                                    <td>${depotIn.goodsDetailEntity.unit}</td>
                                    <td><fmt:formatDate pattern="yyyy-MM-dd" value="${depotIn.makeTime}"/></td>
                                    <td>${depotIn.goodsDetailEntity.shelfLife}</td>
                                    <td>${depotIn.inNum}</td>
                                    <td>${depotIn.goodsLocation}</td>
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
                                <th>云库收货员</th>
                                <th>签收时间</th>
                                <th>云库入库员</th>
                                <th>云库入库时间</th>
                            </tr>
                            <tr>
                                <td>${depotIn.seller}</td>
                                <td><fmt:formatDate pattern="yyyy-MM-dd HH:mm" value="${depotIn.receiptTime}"/></td>
                                <td>${depotIn.keeper}</td>
                                <td><fmt:formatDate pattern="yyyy-MM-dd HH:mm" value="${depotIn.depotInTime}"/></td>
                            </tr>
                            </tbody>
                        </table>
                    </div>
                </div>
                <!-- /.col -->
            </div>
        </div>
    </c:forEach>

    <%--<div class="row">--%>
    <%--<div class="col-md-12">--%>
    <%--<div class="box box-primary">--%>
    <%--<div class="box-body">--%>
    <%--<table class="table table-bordered">--%>
    <%--<tbody>--%>
    <%--<tr>--%>
    <%--<th>入库批号</th>--%>
    <%--<th>配送厂家</th>--%>
    <%--<th>入库时间</th>--%>
    <%--<th>总件数</th>--%>
    <%--<th>操作</th>--%>
    <%--</tr>--%>

    <%--<c:forEach items="${page.results }" var="result">--%>
    <%--<tr>--%>
    <%--<td>${result.transportNo}</td>--%>
    <%--<td>${result.firm}</td>--%>
    <%--<td><fmt:formatDate pattern="yyyy-MM-dd HH:mm" value="${result.depotInTime}"/></td>--%>
    <%--<td>${result.sum}件</td>--%>
    <%--<td><a href="#" class="btn btn-primary btn-xs" id="student-bj"--%>
    <%--onclick="detailFun('${result.transportNo}')">查看详情</a></td>--%>
    <%--</tr>--%>
    <%--</c:forEach>--%>
    <%--</tbody>--%>
    <%--</table>--%>
    <%--</div>--%>
    <%--<!-- /.box-body -->--%>
    <%--<%@ include file="/WEB-INF/pages/comm/page.jsp" %>--%>
    <%--</div>--%>
    <%--<!-- /.col -->--%>
    <%--</div>--%>
    <%--</div>--%>
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
            url: "${context}/goodsInside/list?pageNo=" + $("#pageNo").val(),
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
            url: "${context}/goodsInside/list?pageNo=1",
            data: $("#searchForm").serialize(),
            type: "post",
            dataType: 'html',
            success: function (data) {
                $(".content-wrapper").html(data);
            }
        });
    }
</script>