<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ include file="/WEB-INF/pages/comm/comm.jsp"%>
<script type="text/javascript" src="${context}/static/nice-validator/jquery.validator.js"></script>
<script type="text/javascript" src="${context}/static/nice-validator/local/zh_CN.js"></script>
<!--student-bjcon st-->
<div class="modal-body">
    <form class="form-horizontal" id="uform" action=""
          accept-charset="UTF-8" method="post">
        <div class="form-body">
            <div class="form-group">
                <label class="control-label col-xs-2"> <label>仓库全称:</label>
                </label>
                <div class="col-xs-8">
                    <p class="form-control-static">${depot.depotName}</p>
                </div>
            </div>
            <div class="form-group">
                <label class="control-label col-xs-2"> <label>仓库详细地址:</label>
                </label>
                <div class="col-xs-8">
                    <p class="form-control-static">${depot.depotAddress}</p>
                </div>
            </div>
            <div class="form-group">
                <label class="control-label col-xs-2"> <label>仓库面积:</label>
                </label>
                <div class="col-xs-8">
                    <p class="form-control-static">${depot.area}</p>
                </div>
            </div>
            <div class="form-group">
                <label class="control-label col-xs-2"> <label>仓库照片:</label>
                </label>
                <div class="col-xs-8">
                    <p class="form-control-static"></p>
                </div>
            </div>
            <div class="form-group">
                <label class="control-label col-xs-2"> <label>仓库营业执照:</label>
                </label>
                <div class="col-xs-8">
                    <p class="form-control-static"><img class="img-responsive" src="${depot.businessImg}"></p>
                </div>
            </div>
            <div class="form-group">
                <label class="control-label col-xs-2"> <label>仓库负责人姓名:</label>
                </label>
                <div class="col-xs-8">
                    <p class="form-control-static">${depot.managerName}</p>
                </div>
            </div>
            <div class="form-group">
                <label class="control-label col-xs-2"> <label>仓库负责人手机号:</label>
                </label>
                <div class="col-xs-8" >
                    <p class="form-control-static">${depot.managerPhone}</p>
                </div>
            </div>
            <div class="form-group">
                <label class="control-label col-xs-2"> <label>仓库负责人身份证号:</label>
                </label>
                <div class="col-xs-8">
                    <p class="form-control-static">${depot.phone}</p>
                </div>
            </div>
            <div class="form-group">
                <label class="control-label col-xs-2"> <label>仓库负责人正面持身份证照片:</label>
                </label>
                <div class="col-xs-8">
                    <p class="form-control-static"><img class="img-responsive" src="${depot.managerPhoto}"></p>
                </div>
            </div>
            <div class="form-group">
                <label class="control-label col-xs-2"> <label>仓库保证金额:</label>
                </label>
                <div class="col-xs-8">
                    <p class="form-control-static">${depot.bond}</p>
                </div>
            </div>
            <div class="form-group">
                <label class="control-label col-xs-2"> <label>审核结果:</label>
                </label>
                <div class="col-xs-8">
                    <select class="form-control" name="status">
                        <option  value="verified">通过</option>
                        <option  value="rejected">不通过</option>
                    </select>
                </div>
            </div>
            <div class="form-group">
                <label class="control-label col-xs-2"> <label>审核通知:</label>
                </label>
                <div class="col-xs-8">
                    <input class="form-control " name="" type="text">
                </div>
            </div>
            <input type="hidden" value="${depot.id}" name="id">
        </div>
    </form>
</div>
<div class="modal-footer">
    <button type="button" class="btn btn-primary"
            onclick="$('#uform').trigger('validate')">提交
    </button>
    <button type="button" class="btn btn-default" onclick="depot()">取消</button>
</div>
<!--student-bjcon end-->
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
                })
                layer.msg(msg);
                checksubmit = false;
            }
        })
    })
    var checksubmit = false;
    function editinfo() {
        $.ajax({
            url: '${context}/check/update/depot',
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
    function depot() {
        top.layer.closeAll();
    }
</script>