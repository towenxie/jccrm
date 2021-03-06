<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/pages/comm/comm.jsp" %>
<script src="${context}/static/plugins/My97DatePicker/WdatePicker.js"></script>
<section class="content-header">
    <h1>
        商品审核
        <small></small>
    </h1>
    <ol class="breadcrumb">
        <li><a href="${context }/main"><i class="fa"><img src="${context }/static/dist/img/home_ico.png" width="10"
                                                          height="10"></i>首页</a></li>
        <li class="active">商品审核</li>
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
        <div class="col-md-12">
            <div class="box box-primary">
                <div class="box-body">
                    <table class="table table-bordered">
                        <tbody>
                        <tr>
                            <th>序号</th>
                            <th>货品名称</th>
                            <th>货品编号</th>
                            <th>价格</th>
                            <th>厂家</th>
                            <th>操作</th>
                        </tr>

                        <c:forEach items="${page.results }" var="result" varStatus="status">
                            <tr>
                                <td>${status.index+1}</td>
                                <td>${result.name}</td>
                                <td>${result.goodsNumber}</td>
                                <td>${result.cbPrice}</td>
                                <td>${result.venderName}</td>
                                <td><a href="#" class="btn btn-primary btn-xs" id="student-bj"
                                       onclick="detailFun('${result.id}')">审核</a></td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                </div>
                <!-- /.box-body -->
                <%@ include file="/WEB-INF/pages/comm/page.jsp" %>
                <div id="detail-bjcon" style="display: none">
                </div>
                <!-- /.col -->
            </div>
        </div>
    </div>
</section>
<input type="hidden" id="pageNo" name="pageNo" value="${page.pageNo }">
<script type="text/javascript">
    function detailFun(id) {
        $.ajax({
            url: "${context}/check/detail/goods?id=" + id,
            dataType: "html",
            success: function (data) {
                $("#detail-bjcon").html(data);
                layer.open({
                    title: '商品审核',
                    type: 1,
                    skin: 'layui-layer-rim', //加上边框
                    area: ['800px', '800px'], //宽高
                    content: $("#detail-bjcon")
                });
            }
        });
    }

    function queryResult() {
        $.ajax({
            url: "${context}/check/goods?pageNo=" + $("#pageNo").val(),
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