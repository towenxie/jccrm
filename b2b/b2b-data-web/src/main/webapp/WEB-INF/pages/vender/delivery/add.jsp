<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/pages/comm/comm.jsp" %>
<section class="content-header">
    <h1>添加配送单
        <small></small>
    </h1>
    <ol class="breadcrumb">
        <li>
            <a href="#"><i class="fa"><img src="${context}/static/dist/img/home_ico.png" width="10"
                                           height="10"></i>首页</a>
        </li>
        <li class="active">添加配送单</li>
    </ol>
</section>
<br>
<script type="text/javascript" src="${context}/static/datetimepicker/js/bootstrap-datetimepicker.min.js"
        charset="UTF-8"></script>
<script type="text/javascript" src="${context}/static/datetimepicker/js/bootstrap-datetimepicker.zh-CN.js"
        charset="UTF-8"></script>
<link rel="stylesheet" href="${context}/static/datetimepicker/css/bootstrap-datetimepicker.min.css" rel="stylesheet">
<script src="${context}/static/plugins/My97DatePicker/WdatePicker.js"></script>
<div id="student-viewcon">
    <div class="container">
        <form class="form-horizontal" role="form" id="uform" action="" accept-charset="UTF-8" method="post">
            <div class="form-group">
                <div class="col-sm-12">
                    <label for="transportNo" class="col-sm-2 control-label">配送单号</label>
                    <div class="col-sm-10">
                        <label id="transportNo" name="transportNo" value="${transportNo}"
                               class="col-sm-2 form-control">${transportNo}</label>
                    </div>
                </div>
            </div>

            <div class="form-group">
                <div class="col-sm-12">
                    <label class="col-sm-2 control-label">请选择配送云库</label>
                    <div class="col-sm-10">
                        <select id="depotId" name="depotId1" class="form-control"
                                onchange="bao(this.options[this.options.selectedIndex].value)">
                            <option value="" selected="selected">--配送云库--</option>
                            <c:forEach items="${depots }" var="item">
                                <option value="${item.depotAddress}">${item.depotName}</option>
                            </c:forEach>
                        </select>
                    </div>
                </div>
            </div>

            <div class="form-group">
                <div class="col-sm-12">
                    <label for="dtime" class="col-sm-2 control-label">配送日期</label>
                    <div class="col-sm-10">
                        <input type="text" class="form-control" id="dtime" onFocus="WdatePicker()" value="${dtime}"
                               name="dtime" placeholder="">
                    </div>
                </div>
            </div>
            <div class="form-group">
                <div class="col-sm-12">
                    <label class="col-sm-2 control-label">配送地址</label>
                    <div class="col-sm-10">
                        <input type="text" class="form-control" value="" name="address" id="address"
                               placeholder="请输入配送地址">
                    </div>
                </div>
            </div>
            <div class="form-group">
                <div class="col-sm-12">
                    <label class="col-sm-2 control-label">配送司机</label>
                    <div class="col-sm-10">
                        <table class="table table-bordered">
                            <thead>
                            <tr>
                                <td>车牌号</td>
                                <td>姓名</td>
                                <td>手机号</td>
                                <td>车型</td>
                                <td>装货</td>
                                <td><input type="button" value="添加" onclick="add()"></td>
                            </tr>
                            <thead>
                            <tbody id="tb">
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>

            <div class="form-group">
                <div class="col-sm-12">
                    <table class="table table-bordered">
                        <tbody>
                        <tr>
                            <th>ID</th>
                            <th>商品名称</th>
                            <th>单位</th>
                            <th>配送数</th>
                            <th>生产日期</th>
                        </tr>
                        <c:forEach items="${list.items }" var="result">
                            <tr>
                                <td>
                                    <div class="checkbox">
                                        <label>
                                            <input type="checkbox" name="ids">${result.id}
                                        </label>
                                    </div>
                                </td>
                                <td>${result.name}</td>
                                <td>${result.unit}</td>
                                <td><input type="hidden" class="form-control" value="${result.id}">
                                    <input type="number" class="form-control" value="${result.stockNum}" placeholder="0">
                                </td>
                                <td>
                                    <input name="productDate"  type="text" class="form-control"  onFocus="WdatePicker()">
                                </td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>
        </form>
        <div class="modal-footer">
            <button type="button" class="btn btn-primary"
                    onclick="editinfo()">提交
            </button>
            <button type="button" class="btn btn-danger col-md-3" >打印</button>
        </div>

    </div>

</div>
<script>
    function add() {
        var trObj = document.createElement("tr");
        trObj.id = new Date().getTime();
        trObj.innerHTML = "<td><input name='number'/></td><td><input name='username'/></td><td><input name='phone'/></td><td><input name='type'/></td><td><input name='loading'/></td><td><input type='button' value='删除' onclick='del(this)'></td>";
        document.getElementById("tb").appendChild(trObj);
    }

    function del(obj) {
        var trId = obj.parentNode.parentNode.id;
        var trObj = document.getElementById(trId);
        document.getElementById("tb").removeChild(trObj);
    }

    function bao(adrs) {
        console.log(adrs);
        $("#address").val(adrs);
        console.log($("#address").val())
    }

    $('.form_datetime').datetimepicker({
        //language:  'fr',
        weekStart: 1,
        todayBtn: 1,
        autoclose: 1,
        todayHighlight: 1,
        startView: 2,
        forceParse: 0,
        showMeridian: 1
    });

</script>
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
</script>
