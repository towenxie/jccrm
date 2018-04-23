<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/pages/comm/comm.jsp" %>
<script src="${context}/static/plugins/My97DatePicker/WdatePicker.js"></script>
<script type="text/javascript" src="${context}/static/nice-validator/jquery.validator.js"></script>
<div id="student-viewcon">
    <div class="modal-body">
        <section class="content">
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
                                    <th>数量</th>
                                    <th>单位</th>
                                    <th>生产日期</th>
                                    <th width="100">保质期</th>
                                    <th>实际入库</th>
                                    <th>入库区</th>
                                </tr>

                                <c:forEach items="${dataList }" var="depotIn">
                                    <tr>
                                        <td>${depotIn.goodsDetailEntity.goodsNumber}</td>
                                        <td>${depotIn.goodsDetailEntity.name}</td>
                                        <td>${depotIn.transportNum}</td>
                                        <td>${depotIn.goodsDetailEntity.unit}</td>
                                        <td><fmt:formatDate pattern="yyyy-MM-dd" value="${depotIn.makeTime}"/></td>
                                        <td><fmt:formatDate pattern="yyyy-MM-dd" value="${depotIn.goodsDetailEntity.shelfLife}"/></td>
                                        <td>${depotIn.inNum}</td>
                                        <td>${depotIn.goodsLocation}</td>
                                    </tr>
                                </c:forEach>
                                </tbody>
                            </table>
                        </div>
                    </div>
                    <!-- /.col -->
                </div>
                <div class="col-md-12">
                    <div class="box box-primary">
                        <div class="box-body">
                            <table class="table table-bordered">
                                <tbody>
                                <tr>
                                    <th class="col-md-2">配货单号</th>
                                    <td></td>
                                </tr>
                                <tr>
                                    <th>配送云库</th>
                                    <td></td>
                                </tr>
                                <tr>
                                    <th>配送日期</th>
                                    <td></td>
                                </tr>
                                <tr>
                                    <th>预计入库日期</th>
                                    <td></td>
                                </tr>
                                </tbody>
                            </table>
                        </div>
                    </div>
                    <!-- /.col -->
                </div>
                <div class="col-md-12">
                    <div class="box box-primary">
                        <div class="box-body">
                            <table class="table table-bordered">
                                <tbody>
                                <tr>
                                    <th>车牌号</th>
                                    <th>姓名</th>
                                    <th>手机号</th>
                                    <th>车型</th>
                                    <th>装货</th>
                                </tr>

                                <tr>
                                    <td></td>
                                    <td></td>
                                    <td></td>
                                    <td></td>
                                    <td></td>
                                </tr>
                                </tbody>
                            </table>
                        </div>
                    </div>
                    <!-- /.col -->
                </div>
                <div class="col-md-12">
                    <div class="box box-primary">
                        <div class="box-body">
                            <table class="table table-bordered">
                                <tbody>
                                <tr>
                                    <th class="col-md-2">签收人</th>
                                    <td></td>
                                </tr>
                                <tr>
                                    <th >签收时间</th>
                                    <td></td>
                                </tr>
                                </tbody>
                            </table>
                        </div>
                    </div>
                    <!-- /.col -->
                </div>
            </div>

        </section>
    </div>
    <!--student-viewcon end-->
</div>
<script type="text/javascript">
    function closeFun() {
        layer.closeAll();
    }
</script>