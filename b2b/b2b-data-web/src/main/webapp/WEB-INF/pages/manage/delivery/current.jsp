<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ include file="/WEB-INF/pages/comm/comm.jsp"%>
<script src="${context}/static/plugins/My97DatePicker/WdatePicker.js"></script>
<section class="content-header">
    <h1>
        本月盘点 <small></small>
    </h1>
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
    <label for="depotId" class="control-label">盘点云库</label>
            <select id="depotId" name="depotId" class="form-control"
                                onchange="bao(this.options[this.options.selectedIndex].value)">
            <option selected="selected">--选择云库--</option>

            <c:forEach items="${depots }" var="item">
            <option name="id" value="${item.id}">${item.depotName}</option>
            </c:forEach>
        </select>
        </div>
  </div>&nbsp;&nbsp;
                        <button type="button" onclick="queryResult()" class="btn btn-primary">查找</button>
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
                    <c:forEach items="${result}" var="result">
                    <div>配送厂家：${item.venderName}</div>
                    <table class="table table-bordered">
                        <tbody>
                        <tr>
                            <th>货品名称</th>
                            <th>生产日期</th>
                            <th>保质期</th>
                            <th>剩余保质期</th>
                            <th>最高库存</th>
                            <th>最低库存</th>
                            <th>上月库盘数</th>
                            <th>本月入库数</th>
                            <th>本月实销数</th>
                            <th>本月应存数</th>
                            <th>库存性质</th>
                            <th>单位</th>
                            <th>商品性质</th>
                        </tr>
                        <c:forEach items="${result.items }" var="item">
                            <tr>
                                <td>${item.name}</td>
                                <td>${item.makeTime}</td>
                                <td></td>
                                <td>${item.maxStockNum}</td>
                                <td>${item.minStockNum}</td>
                                <td>${item.stockNum}</td>
                                <td>${item.stockNum}</td>
                                <td>${item.stockNum}</td>
                                <td>${item.stockNum}</td>
                                <td>安全</td>
                                <td>${item.unit}</td>
                                <td>安全</td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                    </c:forEach>
                </div>
            </div>
            <!-- /.col -->
        </div>
    </div>

</section>