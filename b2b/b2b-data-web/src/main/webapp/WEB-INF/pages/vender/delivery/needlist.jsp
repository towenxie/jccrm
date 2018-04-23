<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/pages/comm/comm.jsp" %>
<script src="${context}/static/plugins/My97DatePicker/WdatePicker.js"></script>
<section class="content-header">
    <h1>
        告急商品
        <small></small>
    </h1>
    <ol class="breadcrumb">
        <li><a href="${context }/main"><i class="fa"><img src="${context }/static/dist/img/home_ico.png" width="10"
                                                          height="10"></i>首页</a></li>
        <li class="active">告急商品</li>
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
        <c:forEach items="${results }" var="result">
            <div class="col-md-12">
                <div class="box box-primary">
                    <div class="box-body">
                        <table class="table table-bordered">
                            <thead>
                            <tr>
                                <td colspan="9" align="center"><b>${result.depotName}</b></td>
                            </tr>
                            </thead>
                            <tbody>
                            <tr>
                                <th>入库批号</th>
                                <th>货品名称</th>
                                <th>包装形式</th>
                                <th>生产日期</th>
                                <th>保质期(天)</th>
                                <th>最高库存</th>
                                <th>最低库存</th>
                                <th>剩余库存</th>
                                <th>库存状态</th>
                                    <%-- <th>入库区</th>--%>
                            </tr>

                            <c:forEach items="${result.items }" var="item">
                                <tr>
                                    <td><fmt:formatDate pattern="yyyyMMdd" value="${item.productDate}"/>-${item.id}</td>
                                    <td>${item.name}</td>
                                    <td>${item.packingCount}/${item.packing}</td>
                                    <td><fmt:formatDate pattern="yyyy-MM-dd HH:mm" value="${item.productDate}"/></td>
                                    <td>${item.shelfLife}</td>
                                    <td>${item.maxStock}</td>
                                    <td>${item.minStock}</td>
                                    <td>${item.stockNum}</td>
                                    <td><font color="#FF0000">告急</font></td>
                                        <%--<td>&lt;%&ndash;${item.goodsLocation}&ndash;%&gt;</td>--%>
                                </tr>
                            </c:forEach>
                            </tbody>
                            <tfoot>
                            <tr>
                                <td colspan="9" align="right">
                                    <button class="btn btn-danger" onclick="detailFun('${result.depotId}')">立即配送
                                    </button>
                                </td>
                            </tr>
                            </tfoot>
                        </table>
                    </div>
                    <!-- /.box-body -->
                        <%--<%@ include file="/WEB-INF/pages/comm/page.jsp" %>--%>
                    <div id="detail-bjcon" style="display: none">
                    </div>
                </div>
                <!-- /.col -->
            </div>
        </c:forEach>
    </div>
</section>
<input type="hidden" id="pageNo" name="pageNo" value="${page.pageNo }">
<script type="text/javascript">
    function detailFun(depotId) {
        $.ajax({
            url: "${context}/vender/delivery/needPage?depotId=" + depotId,
            dataType: "html",
            success: function (data) {
                $("#detail-bjcon").html(data);
                layer.open({
                    title: '告急商品配货',
                    type: 1,
                    skin: 'layui-layer-rim', //加上边框
                    area: ['1024px', '800px'], //宽高
                    content: $("#detail-bjcon")
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