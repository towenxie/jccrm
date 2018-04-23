<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/pages/comm/comm.jsp" %>
<script src="${context}/static/plugins/My97DatePicker/WdatePicker.js"></script>
<script type="text/javascript" src="${context}/static/nice-validator/jquery.validator.js"></script>
<script type="text/javascript" src="${context}/static/nice-validator/local/zh_CN.js"></script>
<section class="content">
    <form id="uform">
    <div class="clearfix"></div>
    <div class="row">
        <div class="col-md-12">
            <div class="box box-primary">
                <div class="box-body">
                    <table class="table table-bordered">
                        <thead>
                        <tr>
                            <td colspan="11" align="center"><h2>${depotGoodsModel.depotName}</h2></td>
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

                        <c:forEach items="${depotGoodsModel.items }" var="item" varStatus="status">
                            <input type="hidden" name="ids" value="${item.id}">
                            <tr align="center">
                                <td>${ status.index + 1}</td>
                                <td>${item.name}</td>
                                <td>${item.packingCount}/${item.packing}</td>
                                <td>${item.shelfLife}</td>
                                <td>${item.maxStock}</td>
                                <td>${item.minStock}</td>
                                <td>${item.stockNum}</td>
                                <td><font color="#FF0000">告急</font></td>
                                <td><input class="form-control" onFocus="WdatePicker()"
                                           value=""
                                           name="makeTime"
                                           placeholder="" type="text"></td>
                                <td><input class="form-control" type="text" name="batch"></td>
                                <td><input class="form-control" type="text" name="transportNum"></td>
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
                    <table class="table table-bordered">
                        <tbody>
                        <tr align="center">
                            <th width="200px">配货单号</th>
                            <td colspan="6"><input class="form-control" name="transportNo" placeholder=""
                                                   type="text"></td>
                        </tr>
                        <tr>
                            <th width="200px">配送云库</th>
                            <td colspan="6">
                                <input value="${depotGoodsModel.depotId}" name="depotId" type="hidden">
                                <p class="form-control-static">${depotGoodsModel.depotName}</p>
                            </td>
                        </tr>
                        <tr>
                            <th width="200px">配送日期</th>
                            <td colspan="6"><input class="form-control" onFocus="WdatePicker({dateFmt:'yyyy-MM-dd'})"
                                                   name="transportTime"
                                                   placeholder="" type="text"></td>
                        </tr>
                        <tr>
                            <th width="200px">预计入库日期</th>
                            <td colspan="6"><input class="form-control" onFocus="WdatePicker()"
                                                   name="comeInTime"
                                                   placeholder="" type="text"></td>
                        </tr>
                        <tr align="center">
                            <th width="200px">配送司机</th>
                            <th width="200px">车牌号</th>
                            <th width="100px">姓名</th>
                            <th width="200px">手机号</th>
                            <th width="200px">车型</th>
                            <th width="200px">装货(件)</th>
                            <th width="200px">
                                <button type="button" class="btn btn-primary" onclick="add()">添加</button>
                            </th>
                        </tr>
                        <tbody id="tb">
                        <tr>
                            <td>1</td>
                            <td><input class="form-control" type="text" name="carNo"></td>
                            <td><input class="form-control" type="text" name="driverName"></td>
                            <td><input class="form-control" type="mobile" name="driverPhone"></td>
                            <td><input class="form-control" type="text" name="carType"></td>
                            <td><input class="form-control" type="number" name="num"></td>
                            <td>
                                <button type="button" class="btn btn-default" onclick="del(this)">删除</button>
                            </td>
                        </tr>
                        </tbody>
                    </table>
                </div>
                <!-- /.box-body -->
            </div>
            <!-- /.col -->
        </div>
    </div>
    </form>
    <div class="modal-footer">
        <button type="button" class="btn btn-primary"
                onclick="$('#uform').trigger('validate')">提交
        </button>
        <button type="button" class="btn btn-default" onclick="result()">取消</button>
    </div>
</section>
<script type="text/javascript">
    $(function () {
        $("#uform").validator({
            stopOnError: false, // 关闭此开关，以便一次性显示所有消息
            msgMaker: false,
            valid: function () {
                if (checksubmit == true) {
                    return false;
                }
                checksubmit = true;
                editinfo();
            },
            invalid: function (form, error) {
                var msg = '';
                $(error).each(function () {
                    msg += this + '</br>';
                });
                layer.msg(msg);
                checksubmit = false;
            }
        })
    });
    var checksubmit = false;
    function editinfo() {
        $.ajax({
            url: '${context}/vender/delivery/add',
            type: 'post',
            data: $("#uform").serialize(),
            dataType: 'json',
            success: function (data) {
                layer.msg(data.msg);
                checksubmit = false;
                if (data.code == 200) {
                    setTimeout(
                        function () {
                            top.layer.closeAll();
                            queryResult()
                        }, 1500)
                }
            }
        })
    }
    function result() {
        top.layer.closeAll();
    }

    function add() {
        var n=$("#tb").find("tr:last").find("td").eq(0).text();
        var trObj = document.createElement("tr");
        trObj.id = new Date().getTime();
        trObj.innerHTML = "<tr>" +
            "<td>"+(parseInt(n)+1)+"</td>" +
            "<td><input class='form-control' type='text' name='carNo'></td>" +
            "<td><input class='form-control' type='text' name='driverName'></td>" +
            "<td><input class='form-control' type='mobile' name='driverPhone'></td>" +
            "<td><input class='form-control' type='text' name='carType'></td>" +
            "<td><input class='form-control' type='number' name='num'></td>" +
            "<td><button type='button' class='btn btn-default' onclick='del(this)'>删除</button></td>" +
            "</tr>";
        document.getElementById("tb").appendChild(trObj);
    }
    function del(obj) {
        var trId = obj.parentNode.parentNode.id;
        var trObj = document.getElementById(trId);
        document.getElementById("tb").removeChild(trObj);
    }
</script>