<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/pages/comm/comm.jsp" %>
<script src="${context}/static/plugins/My97DatePicker/WdatePicker.js"></script>
<section class="content-header">
    <h1>
        各云库入库情况
        <small></small>
    </h1>
    <ol class="breadcrumb">
        <li><a href="${context }/main"><i class="fa"><img src="${context }/static/dist/img/home_ico.png" width="10"
                                                          height="10"></i>首页</a></li>
        <li class="active">各云库入库情况</li>
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
                            <div class="col-sm-12">
                                <label for="depot" class="control-label">配送云库</label>
                                <select id="depot" value="${userName}" class="form-control">
                                    <option selected="selected">--所有云库--</option>
                                    <option>河南周口沈丘县云库</option>
                                    <option>河南南阳邓州市云库</option>
                                    <option>河南新乡封丘县云库</option>
                                    <option>河南平顶山石龙区云库</option>
                                    <option>河南郑州金水区云库</option>
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
        <c:if test="${results.size()>0 }">
        <c:forEach items="${results }" var="result">
            <div class="col-md-12">
                <div class="box box-primary">
                    <div class="box-body">
                        <table class="table table-bordered">
                            <thead>
                            <tr>
                                <td colspan="10" align="center"><b>${result.depotName}</b></td>
                            </tr>
                            </thead>
                            <tbody>
                            <tr>
                                <th>配货日期</th>
                                <th>配送单号</th>
                                <th>入库日期</th>
                                <th>配送数量(件)</th>
                                <th>操作</th>
                            </tr>
                            <c:forEach items="${result.items }" var="item" >
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
                        <%--<%@ include file="/WEB-INF/pages/comm/page.jsp" %>--%>
                </div>
                <!-- /.col -->
            </div>
        </c:forEach>
        </c:if>
        <c:if test="${results.size()<=0 }">
            <div class="col-md-12">
                <div class="box box-primary">
                    <div class="box-body">
                        <table class="table table-bordered">
                            <tbody>
                            <tr>
                                <td colspan="5" align="center">很抱歉，暂时没有数据</td>
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