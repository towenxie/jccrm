<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/pages/comm/comm.jsp" %>
<script src="${context}/static/plugins/My97DatePicker/WdatePicker.js"></script>
<section class="content-header">
    <h1>
        商品管理
        <small></small>
    </h1>
    <ol class="breadcrumb">
        <li><a href="${context }/main"><i class="fa"><img src="${context }/static/dist/img/home_ico.png" width="10"
                                                          height="10"></i>首页</a></li>
        <li class="active">商品管理</li>
    </ol>
</section>
<section class="content">
    <div class="clearfix"></div>
    <div class="row">
        <div class="col-md-12">
            <div class="box box-primary">
                <div class="box-body">
                    <table class="table table-bordered">
                        <tbody id="tb">
                        <tr>
                            <th>编号</th>
                            <th>名称</th>
                            <th>出厂价</th>
                            <th>单位</th>
                            <th>品牌</th>
                            <th>保质期</th>
                            <th>操作</th>
                        </tr>
                        <c:forEach items="${list.items }" var="result">
                            <tr>
                                <td>
                                    <div class="checkbox">
                                        <label>
                                            <input type="checkbox">${result.id}
                                        </label>
                                    </div>
                                </td>
                                <td>${result.name}</td>
                                <td>${result.cbPrice}</td>
                                <td>${result.unit}</td>
                                <td>${result.brand}</td>
                                <td>${result.shelfLife}</td>
                                <td><a href="#" class="btn btn-primary btn-xs" id="student-bj"
                                       onclick="del('${result.id}')">删除</a></td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                </div>
                <!-- /.box-body -->
                <%@ include file="/WEB-INF/pages/comm/page.jsp" %>
            </div>
            <!-- /.col -->
        </div>
    </div>
</section>
<input type="hidden" id="pageNo" name="pageNo" value="${page.pageNo }">
<script type="text/javascript">
    function del(id) {
        $.ajax({
            url: baseurl + "/vender/goods/del",
            type: "post",
            data: {id: id},
            dataType: 'json',
            success: function (data) {
                layer.msg(data.msg);
                if (data.code == 200) {
                    setTimeout(
                        function () {
                            queryResult();
                            top.layer.closeAll();
                        }, 1500);
                }
            }
        });
        var trId = obj.parentNode.parentNode.id;
        var trObj = document.getElementById(trId);
        document.getElementById("tb").removeChild(trObj);
    }
    function queryResult() {
        $.ajax({
            url: baseurl + "/vender/goods/list?pageNo=" + $("#pageNo").val(),
            data: $("#searchForm").serialize(),
            type: "post",
            dataType: 'html',
            success: function (data) {
                $(".content-wrapper").html(data);
            }
        });
    }
</script>