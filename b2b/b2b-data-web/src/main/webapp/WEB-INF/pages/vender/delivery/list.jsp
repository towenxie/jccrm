<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/pages/comm/comm.jsp" %>
<script src="${context}/static/plugins/My97DatePicker/WdatePicker.js"></script>
<section class="content-header">
    <h1>
        已配送清单
        <small></small>
    </h1>
    <ol class="breadcrumb">
        <li><a href="${context }/main"><i class="fa"><img src="${context }/static/dist/img/home_ico.png" width="10"
                                                          height="10"></i>首页</a></li>
        <li class="active">已配送清单</li>
    </ol>
</section>
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
                            <div class="col-sm-12">
                                <label for="depot" class="control-label">配送云库</label>
                                <select id="depot" value="${userName}" class="form-control">
                                    <option selected="selected">--所有云库--</option>

                                    <c:forEach items="${areas }" var="item">
                                        <option name="id" value="${item.id}">${item.depotName}</option>
                                    </c:forEach>
                                </select>
                            </div>
                        </div>
                        &nbsp;&nbsp;
                        <div class="form-group">
                            <label>从</label>
                            <input class="form-control" onFocus="WdatePicker()" value="${accountNo}" name="accountNo"
                                   placeholder="" type="text">
                        </div>

                        <div class="form-group">
                            <label>至</label>
                            <input class="form-control" onFocus="WdatePicker()" value="${accountNo}" name="accountNo"
                                   placeholder="" type="text">
                        </div>
                        <input name="pageNo" type="hidden" id="pageNo" value="${page.pageNo}"/>
                        <button type="button" onclick="queryResult()" class="btn btn-primary">搜索</button>
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
                            <th>配送单号</th>
                            <th>配送云库</th>
                            <th>配送时间</th>
                            <th>总件数</th>
                            <th>查看详情</th>
                        </tr>
                        <c:forEach items="${page.results }" var="result">
                            <tr>
                                <td><fmt:formatDate pattern="yyyy年MM月dd日" value="${item.transportTime}"/></td>
                                <td>${item.transportNo}</td>
                                <td><fmt:formatDate pattern="yyyy年MM月dd日" value="${item.depotInTime}"/></td>
                                <td>${item.sum}</td>
                                <td><button class="btn btn-primary btn-xs" onclick="detailFun('${item.transportNo}')">查看详情</button></td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                </div>
                <!-- /.box-body -->
               <%-- <%@ include file="/WEB-INF/pages/comm/page.jsp" %>--%>
            </div>
            <!-- /.col -->
        </div>
    </div>

</section>
<input type="hidden" id="pageNo" name="pageNo" value="${page.pageNo }">
<script type="text/javascript">
    function detailFun(transprotNo) {
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
    function detailFun(transprotNo) {
        $.ajax({
            url: "${context}/prepareIntoStorage/intoStorage?transprotNo=" + transprotNo,
            dataType: "html",
            success: function (data) {
                layer.open({
                    title: '商品入库',
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
            url: "${context}/prepareIntoStorage/list?pageNo=" + $("#pageNo").val(),
            data: $("#searchForm").serialize(),
            type: "post",
            dataType: 'html',
            success: function (data) {
                $(".content-wrapper").html(data);
            }
        });
    }
</script>