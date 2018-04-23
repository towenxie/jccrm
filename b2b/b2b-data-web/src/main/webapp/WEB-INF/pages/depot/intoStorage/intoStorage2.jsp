<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/pages/comm/comm.jsp" %>
<script type="text/javascript" src="${context}/static/plugins/My97DatePicker/WdatePicker.js"></script>
<script type="text/javascript" src="${context}/static/nice-validator/jquery.validator.js"></script>
<script type="text/javascript" src="${context}/static/nice-validator/local/zh_CN.js"></script>
<div id="student-viewcon">
    <div class="modal-body">
        <section class="content">
            <div class="clearfix"></div>
            <div class="row">
                <div class="col-md-12">
                    <div class="box box-primary">
                        <div class="box-body">
                            <form id="myform">
                            <table class="table table-bordered">
                                <thead>
                                <tr>
                                    <td colspan="8" align="center"><b>配货单号：${obj.transportNo}</b></td>
                                </tr>
                                <tr>
                                    <th colspan="1">配送厂家</th>
                                    <td colspan="3">${obj.firm}</td>
                                    <th colspan="1">总件数</th>
                                    <td colspan="3">${obj.sum}</td>
                                <tr>
                                </thead>
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
                                    <input name="transportNo" value="${obj.transportNo}" type="hidden"/>
                                <c:forEach items="${depotIns }" var="depotIn">
                                    <input name="ids" value="${depotIn.id}" type="hidden"/>
                                    <tr>
                                        <td>${depotIn.goodsDetailEntity.goodsNumber}</td>
                                        <td>${depotIn.goodsDetailEntity.name}</td>
                                        <td>${depotIn.transportNum}</td>
                                        <td>${depotIn.goodsDetailEntity.unit}</td>
                                        <td><fmt:formatDate pattern="yyyy-MM-dd" value="${depotIn.makeTime}"/></td>
                                        <td>${depotIn.goodsDetailEntity.shelfLife}</td>
                                        <td><input name="inNums" value="${depotIn.transportNum}" type="text" class="form-control" style="text-align:center"  data-rule="实际入库数量:required" placeholder="请输入实际入库数量"/></td>
                                        <td><input name="goodsLocations" type="text" class="form-control" style="text-align:center"  data-rule="入库区:required" placeholder="请输入入库区"/></td>
                                    </tr>
                                </c:forEach>
                                </tbody>
                            </table>
                            </form>
                        </div>
                        <div class="box-body">
                            <table class="table table-bordered">
                                <thead>
                                    <tr>
                                        <td colspan="5" align="center"><b>签收情况</b></td>
                                    </tr>
                                </thead>
                                <tbody>
                                    <tr>
                                        <th>云库收货员</th>
                                        <th>签收时间</th>
                                        <th>云库入库员</th>
                                        <th>云库盖章</th>
                                    </tr>
                                    <tr>
                                        <td><input name="seller" type="text" class="form-control" style="text-align:center"  data-rule="云库收货员:required" placeholder="请输入云库收货员"/></td>
                                        <td><input name="receiptTime" onFocus="WdatePicker({dateFmt:'yyyy年MM月dd日 HH时mm分'})" type="text" class="form-control" style="text-align:center"  data-rule="签收时间:required" placeholder="请输入签收时间"/></td>
                                        <td><input name="keeper" type="text" class="form-control" style="text-align:center"  data-rule="云库入库员:required" placeholder="请输入云库入库员"/></td>
                                        <td><input type="text" class="form-control" style="text-align:center"  /></td>
                                    </tr>
                                </tbody>
                            </table>
                        </div>
                        <div class="modal-footer">
                            <button type="button" onclick="$('#myform').trigger('validate')" class="btn btn-primary submit">确定</button>
                            <button type="button" class="btn btn-default cancel">取消</button>
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
    $(function(){
        $('.btn.cancel').click(function () { layer.closeAll(); });
        $("#myform").validator({
            stopOnError : false, // 关闭此开关，以便一次性显示所有消息
            msgMaker : false,
            valid : function() {
                if(checksubmit == true){
                    return false;
                }
                checksubmit = true;
                submitIntoStorage();
            },
            invalid : function(form,error) {
                var msg = '';
                $(error).each(function(){
                    msg += this +'</br>';
                });
                layer.msg(msg);
                checksubmit = false;
            }
        })
    });
    var checksubmit = false;
    function submitIntoStorage(){
        $.ajax({
            url:'/goodsInside/intoStorage',
            type:'get',
            data:$('#myform').serialize(),
            dataType:'json',
            success:function(data){
                layer.msg(data.msg);
                if(data.code == 200){
                    setTimeout(
                        function(){
                            top.layer.closeAll();
                        },1500);
                }
            }
        });
    }

</script>