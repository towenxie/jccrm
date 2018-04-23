<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/pages/comm/comm.jsp" %>
<script src="${context}/static/plugins/My97DatePicker/WdatePicker.js"></script>
<section class="content">
    <div class="clearfix"></div>
    <div class="row">
        <div class="col-md-12">
            <div class="box box-primary">
                <div class="box-body">
                    <table class="table table-bordered">
                        <thead>
                        <tr>
                            <td colspan="11" align="center"><h2>${deliveryOrder.depotId}</h2></td>
                        </tr>
                        </thead>
                        <tbody>
                        <tr align="center">
                            <th width="80px">序号</th>
                            <th width="120px">货品名称</th>
                            <th width="120px">包装形式</th>
                            <th width="160px">保质期(天)</th>
                            <th width="120px">最高库存</th>
                            <th width="120px">最低库存</th>
                            <th width="120px">剩余库存</th>
                            <th width="120px">库存状态</th>
                            <th width="200px">生产日期</th>
                            <th width="120px">产品批号</th>
                            <th width="180px">本次配送(件)</th>
                        </tr>

                        <c:forEach items="${goods}" var="good" varStatus="status">
                            <input type="hidden" name="ids" value="${item.id}">
                            <tr align="center">
                                <td>${status.index + 1}</td>
                                <td>${good.goodsDetailEntity.name}</td>
                                <td>${good.goodsDetailEntity.packingCount}/${good.goodsDetailEntity.packing}</td>
                                <td>${good.goodsDetailEntity.shelfLife}</td>
                                <td>${good.goodsDetailEntity.maxStock}</td>
                                <td>${good.goodsDetailEntity.minStock}</td>
                                <td>${good.goodsDetailEntity.stockNum}</td>
                                <td>
                                    <c:if test="${good.goodsDetailEntity.stockNum<good.goodsDetailEntity.minStock}"><font color="#FF0000">告急</font></c:if>
                                    <c:if test="${good.goodsDetailEntity.stockNum==0}"><font color="#FF0000">断货</font></c:if>
                                    <c:if test="${good.goodsDetailEntity.stockNum>good.goodsDetailEntity.maxStock}"><font color="#FF0000">溢仓</font></c:if>
                                    <c:if test="${good.goodsDetailEntity.minStock<good.goodsDetailEntity.stockNum}">
                                        <c:if test="${good.goodsDetailEntity.maxStock>good.goodsDetailEntity.stockNum}">
                                            <font color="green">充足</font>
                                        </c:if>
                                    </c:if>
                                </td>
                                <td><fmt:formatDate pattern="yyyy-MM-dd" value="${good.makeTime}"/></td>
                                <td>${good.batch}</td>
                                <td>${good.inNum}</td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                </div>
                <!-- /.box-body -->
            </div>
            <!-- /.col -->
        </div>
    </div>

    <div class="row">
        <div class="col-md-12">
            <div class="box box-primary">
                <div class="box-body">
                    <table class="table table-bordered"  align="center">
                        <tbody>
                        <tr>
                            <th width="200px">配货单号</th>
                            <td colspan="6">${deliveryOrder.transportNo}</td>
                        </tr>
                        <tr>
                            <th width="200px">配送云库</th>
                            <td colspan="6">
                                ${deliveryOrder.depotId}
                            </td>
                        </tr>
                        <tr>
                            <th width="200px">配送日期</th>
                            <td colspan="6"><fmt:formatDate pattern="yyyy年MM月dd日" value="${deliveryOrder.departureTime}"/></td>
                        </tr>
                        <tr>
                            <th width="200px">预计入库日期</th>
                            <td colspan="6"><fmt:formatDate pattern="yyyy年MM月dd日" value="${deliveryOrder.comeInTime}"/></td>
                        </tr>
                        <tr align="center">
                            <th width="200px">配送司机</th>
                            <th width="200px">车牌号</th>
                            <th width="100px">姓名</th>
                            <th width="200px">手机号</th>
                            <th width="200px">车型</th>
                            <th width="200px">装货(件)</th>
                        </tr>
                        <tbody id="tb">
                        <c:forEach items="${cars }" var="car" varStatus="status">
                        <tr>
                            <td>${status.index + 1}</td>
                            <td>${car.carNo}</td>
                            <td>${car.driverName}</td>
                            <td>${car.driverPhone}</td>
                            <td>${car.carModel}</td>
                            <td>${car.loading}</td>
                        </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                </div>
                <!-- /.box-body -->
            </div>
            <!-- /.col -->
        </div>
    </div>
</section>
<script type="text/javascript">
    function closeFun() {
        layer.closeAll();
    }
</script>