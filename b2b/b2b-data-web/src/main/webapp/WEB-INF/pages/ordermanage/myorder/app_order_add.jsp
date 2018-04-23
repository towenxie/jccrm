<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/pages/comm/comm.jsp" %>
<script src="${context}/static/plugins/My97DatePicker/WdatePicker.js"></script>
<script type="text/javascript" src="${context}/static/nice-validator/jquery.validator.js"></script>
<script type="text/javascript" src="${context}/static/nice-validator/local/zh_CN.js"></script>
<script type="text/javascript" src="${context}/static/tree/js/distpicker.data.js"></script>
<script type="text/javascript" src="${context}/static/tree/js/distpicker.js"></script>
<script type="text/javascript" src="${context}/static/tree/js/main.js"></script>
<style type="text/css">
  table {
    border: 1px solid #ccc;
    width: 80%;
    margin:0;
    padding:0;
    border-collapse: collapse;
    border-spacing: 0;
    margin: 0 auto;
  }

  table tr {
    border: 1px solid #ddd;
    padding: 5px;
  }

  table th, table td {
    padding: 10px;
    text-align: center;
  }

  table th {
    text-transform: uppercase;
    font-size: 14px;
    letter-spacing: 1px;
  }

  @media screen and (max-width: 600px) {

    table {
      border: 0;
    }

    table thead {
      display: none;
    }

    table tr {
      margin-bottom: 10px;
      display: block;
      border-bottom: 2px solid #ddd;
    }

    table td {
      display: block;
      text-align: right;
      font-size: 13px;
      border-bottom: 1px dotted #ccc;
    }

    table td:last-child {
      border-bottom: 0;
    }

    table td:before {
      content: attr(data-label);
      float: left;
      text-transform: uppercase;
      font-weight: bold;
    }
  }

.note{max-width: 80%; margin: 0 auto;}
</style>
<section class="content-header">
	<h1>
		我的订单 <small></small>
	</h1>
	<ol class="breadcrumb">
		<li><a href="#"><i class="fa"><img
					src="${context}/static/dist/img/home_ico.png" width="10"
					height="10"></i>首页</a></li>
		<!--<li>我的订单</li>-->
		<li class="active">新增订单</li>
	</ol>
</section>
<!-- Main content -->
<section class="content">
    <form id="uform" class="form-horizontal" >
    <div class="clearfix"></div>
        <div class="form-body">
        <div class="form-group">
            <label class="control-label col-md-2"> <label ><span
                    class="red-text">*</span>收件人:</label> </label>
            <div class="col-md-6">
                <input class="form-control" id="odusername" name="username" type="text">
            </div>
        </div>
        <div class="form-group">
            <label class="control-label col-md-2"> <label ><span
                    class="red-text">*</span>手机号:</label> </label>
            <div class="col-md-6">
                <input class="form-control" id="odphone" name="phone" type="text">
            </div>
        </div>
        <div class="form-group">
            <label class="control-label col-md-2"> <label ><span
                    class="red-text">*</span>付款方式:</label> </label>
            <div class="col-md-6">
                <select class="form-control" name="paymentCode">
                    <c:forEach items="${payments}" var="d">
                        <option value="${d.code}">${d.name}</option>
                    </c:forEach>
                </select>
            </div>
        </div>
        <div class="form-group">
            <label class="control-label col-md-2"> <label ><span
                    class="red-text">*</span>物流公司:</label> </label>
            <div class="col-md-6">
                <select class="form-control" name="expressCompanyCode">
                    <c:forEach items="${express}" var="d">
                        <option value="${d.code}">${d.name}</option>
                    </c:forEach>
                </select>
            </div>
        </div>
        <div class="form-group">
            <label class="control-label col-md-2"> <label ><span
                    class="red-text">*</span>省市区:</label> </label>
                  <div id="distpicker4" class=" form-inline col-sm-6">
                      <div class="form-group col-sm-4">
<!--                           <label class="sr-only" for="province9">Province</label> -->
                          <select class="form-control" id="province9" name="locationId1"></select>
                      </div>
                      <div class="form-group col-sm-4">
<!--                           <label class="sr-only" for="city9">City</label>  -->
                          <select class="form-control" id="city9" name="locationId2"></select>
                      </div>
                      <div class="form-group col-sm-4">
<!--                           <label class="sr-only" for="district9">District</label>  -->
                          <select class="form-control" id="district9" name="locationId"></select>
                      </div>
                  </div>
        </div>
        <div class="form-group">
            <label class="control-label col-md-2"> <label ><span
                    class="red-text">*</span>收货地址:</label> </label>
            <div class="col-md-6">
                <input class="form-control" id="odaddress" name="address" type="text">
            </div>
        </div>
        <div class="form-group">
            <label class="control-label col-md-2"> <label >订单备注:</label> </label>
            <div class="col-md-6">
                <textarea class="form-control " name="remark"></textarea>
<!--                 <input class="form-control" name="remark" type="text"> -->
            </div>
        </div>
        <div class="form-group">
            <label class="control-label col-xs-2"> <label ><span
                    class="red-text">*</span>定金金额:</label> </label>
            <div class="col-xs-4">
                <input class="form-control" id="depositPrice" value="0" oninput='calReplacePrice(this)' name="depositPrice" type="number">
            </div>
            <label class="control-label col-xs-2"> <label ><span
                    class="red-text"></span>代收金额:</label> </label>
            <div class="col-xs-4">
                <input class="form-control" id="replacePrice" value="0" name="replacePrice" type="text" disabled="disabled" style="color: red;">
            </div>
        </div>
        <div class="form-group">
            <label class="control-label col-md-2"> <label >订单总价格:</label> </label>
            <div class="col-md-6">
                <input class="form-control" id="totalPrice" value="0" name="totalPrice" type="text" disabled="disabled" style="color: red;">
            </div>
        </div>
        
    <div class="row">
        <div class="col-md-12">
            <div class="box box-primary">
                <div class="box-body">
                    <table class="table table-bordered">
                        <thead>
                        <tr align="center">
                            <th width="200px">序号</th>
                            <th width="200px">产品</th>
                            <th width="200px">计量单位</th>
                            <th width="200px">价格</th>
                            <th width="200px">数量</th>
                            <th width="200px">折扣(%)</th>
                            <th width="200px">总金额</th>
                            <th width="200px">
                                                                操作
<!--                                 <button type="button" class="btn btn-primary" onclick="add()">添加</button> -->
                            </th>
                        </tr>
                        </thead>
                        <tbody id="tb">
                        </tbody>
                    </table>
                </div>
                <!-- /.box-body -->
            </div>
            <!-- /.col -->
        </div>
    </div>
    </div>
    </form>
    <div class="modal-footer">
        <button type="button" class="btn btn-primary"
                onclick="add()">添加商品
        </button>
        <button type="button" class="btn btn-primary"
                onclick="editinfo()">提交
        </button>
    </div>
</section>
<script type="text/javascript">

function btnChange(obj, value) {
    var pntNode = obj.parentNode.parentNode;
    if(value == ''){
        pntNode.children[2].firstChild.value='';
        pntNode.children[3].firstChild.value='0';
        pntNode.children[6].firstChild.value='0';
        return;
    }
    var group = value.split("-");
    pntNode.children[1].firstChild.value=group[0];
    pntNode.children[2].firstChild.value=group[1];
    pntNode.children[3].firstChild.value=group[2];
    pntNode.children[6].firstChild.value=group[2];
    calTotalPrice();
}

$(function () {
    $("#uform").validator({
        stopOnError: true, // 关闭此开关，以便一次性显示所有消息
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
    if(!validate()){
        return false;
    }
    if(checksubmit == true){
        return false;
    }
    var jsonGoods = [];
    $("#uform").find("tr").each(function(){
        var json = {};
        var flag = false;
        $(this).find("[value]").each(function(){
            flag = true;
            if($(this).attr("name")!=null){
                json[$(this).attr("name")] = $(this).val();
            }
        });
        if (flag) {
            jsonGoods.push(json);
        }
    });

    var parms = {
            username: $("input[name=username]").val(),
            phone: $("input[name=phone]").val(),
            address: $("input[name=address]").val(),
            remark: $("textarea[name=remark]").val(),
            locationId1: $("select[name=locationId1]").val(),
            locationId2: $("select[name=locationId2]").val(),
            locationId: $("select[name=locationId]").val(),
            expressCompanyCode: $("select[name=expressCompanyCode]").val(),
            paymentCode: $("select[name=paymentCode]").val(),
            totalPrice: $("input[name=totalPrice]").val(),
            depositPrice: $("input[name=depositPrice]").val(),
            goods: jsonGoods
        };
    $.ajax({
        url: '${context}/ordermanage/myorder/app/add',
        type: 'post',
        data: JSON.stringify(parms),
        dataType: 'json',
        contentType: 'application/json', 
        success: function (data) {
            layer.msg(data.msg);
            checksubmit = false;
            if (data.code == 200) {
                setTimeout(
                    function () {
//                         top.layer.closeAll();
//                         queryResult()
                      reload();
                    }, 1500)
            }
        }
    })
}
function reload(){
    $("input[name=username]").val('');
    $("input[name=phone]").val('');
    $("input[name=address]").val('');
    $("textarea[name=remark]").val('');
    $("select[name=locationId1]").val('');
    $("select[name=locationId2]").val('');
    $("select[name=locationId]").val('');
    $("select[name=expressCompanyCode]").val('');
    $("select[name=paymentCode]").val('');
    $("input[name=totalPrice]").val('0');
    $("input[name=depositPrice]").val('0'),
    document.getElementById("tb").innerHTML='';
}
function validate(){
    var name=$("input[id=odusername]").val();
    if(name == '' || name == null){
        layer.msg("收件人不能为空");
        return false;
    }
    var name=$("input[id=odphone]").val();
    if(name == '' || name == null){
        layer.msg("手机号不能为空");
        return false;
    }
    var name=$("select[name=locationId1]").val();
    if(name == '' || name == null){
        layer.msg("地区不能为空");
        return false;
    }
    var name=$("input[id=odaddress]").val();
    if(name == '' || name == null){
        layer.msg("地址不能为空");
        return false;
    }
    var name=$("input[name=totalPrice]").val();
    if(name == '' || name == null || name == 0){
        layer.msg("订单商品不能为空");
        return false;
    }
    return true;
}

function add() {
    var n=$("#tb").find("tr:last").find("td").eq(0).text();
    if(n==""){
        n="0";
    }
    var trObj = document.createElement("tr");
    trObj.id = new Date().getTime();
    trObj.innerHTML = "<tr>" +
        "<td data-label='序号'>"+(parseInt(n)+1)+"</td>" +
        "<td data-label='产品'><input type='hidden' name='goodsNumber'><select class='form-control' onchange='btnChange(this, this[selectedIndex].id);'><option selected='' value=''>选择产品</option><c:forEach items='${goods}' var='d'><option id='${d.group}' value='${d.goodsNumber}'>${d.name}</option></c:forEach></select></td>" +
        "<td data-label='单位'><input class='form-control' type='text' name='unit'></td>" +
        "<td data-label='价格'><input class='form-control' type='number' value='0' name='prePrice' oninput='calPrice(this)'></td>" +
        "<td data-label='数量'><input class='form-control' type='number' value='1' name='qty' oninput='calQty(this)' ></td>" +
        "<td data-label='折扣(%)'><input class='form-control' type='number' value='100' name='profit' oninput='calProfit(this)'></td>" +
        "<td data-label='总金额'><input class='form-control' type='number' value='0' name='totalPrice' oninput='calPreTotalPrice(this)'></td>" +
        "<td data-label='操作'><button type='button' class='btn btn-danger' onclick='del(this)'>删除</button></td>" +
        "</tr>";
    document.getElementById("tb").appendChild(trObj);
}
function calQty(obj){
    var pntNode = obj.parentNode.parentNode;
    var prePrice = pntNode.children[3].firstChild.value;
    var preProfit = pntNode.children[5].firstChild.value;
    var totalPrice = obj.value * prePrice * preProfit / 100;
    pntNode.children[6].firstChild.value=totalPrice.toFixed(2);
    calTotalPrice();
}
function calProfit(obj){
    var pntNode = obj.parentNode.parentNode;
    var prePrice = pntNode.children[3].firstChild.value;
    var preQty = pntNode.children[4].firstChild.value;
    var totalPrice = obj.value * prePrice * preQty / 100;
    pntNode.children[6].firstChild.value=totalPrice.toFixed(2);
    calTotalPrice();
}
function calPrice(obj){
    var pntNode = obj.parentNode.parentNode;
    var preQty = pntNode.children[4].firstChild.value;
    var preProfit = pntNode.children[5].firstChild.value;
    var totalPrice = obj.value * preProfit * preQty / 100;
    pntNode.children[6].firstChild.value= totalPrice.toFixed(2);
    calTotalPrice();
}
function calPreTotalPrice(obj){
    var pntNode = obj.parentNode.parentNode;
    var preQty = pntNode.children[4].firstChild.value;
    var preProfit = pntNode.children[5].firstChild.value;
    var prePrice=(obj.value * 100) /(preProfit * preQty);
    var totalPrice = obj.value;
    pntNode.children[3].firstChild.value=prePrice.toFixed(2);
    calTotalPrice();
}

function calTotalPrice(){
    var totalPrice = 0;
    $("#uform").find("tr").each(function(){
        $(this).find("[value]").each(function(){
            if($(this).attr("name")=='totalPrice'){
                totalPrice = (totalPrice * 100 + $(this).val() * 100) / 100;
            }
        });
    });
    
    $("input[id=totalPrice]").val(totalPrice.toFixed(2));
    calReplacePrice();
}
function calReplacePrice(){
    var totalPrice = $("input[id=totalPrice]").val();
    var depositPrice = $("input[id=depositPrice]").val();
    $("input[id=replacePrice]").val((totalPrice-depositPrice).toFixed(2));
}
function del(obj) {
    var trId = obj.parentNode.parentNode.id;
    var trObj = document.getElementById(trId);
    document.getElementById("tb").removeChild(trObj);
    calTotalPrice();
}
</script>