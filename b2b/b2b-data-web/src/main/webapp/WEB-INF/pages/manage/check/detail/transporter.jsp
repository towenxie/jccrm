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
                <label class="control-label col-xs-2"> <label>姓名:</label>
                </label>
                <div class="col-xs-8">
                    <p class="form-control-static">${transporter.realname}</p>
                </div>
            </div>
            <div class="form-group">
                <label class="control-label col-xs-2"> <label>电话:</label>
                </label>
                <div class="col-xs-8">
                    <p class="form-control-static">${transporter.phone}</p>
                </div>
            </div>
            <div class="form-group">
                <label class="control-label col-xs-2"> <label>配送区域:</label>
                </label>
                <div class="col-xs-8">
                    <p class="form-control-static"></p>
                </div>
            </div>
            <div class="form-group">
                <label class="control-label col-xs-2"> <label>照片:</label>
                </label>
                <div class="col-xs-8">
                    <p class="form-control-static"><img class="img-responsive" src="${transporter.avatar}"></p>
                </div>
            </div>
            <div class="form-group">
                <label class="control-label col-xs-2"> <label>保证金:</label>
                </label>
                <div class="col-xs-8">
                    <p class="form-control-static">${transporter.bond}</p>
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
                    <input class="form-control " name="remark" type="text">
                </div>
            </div>
            <input type="hidden" value="${transporter.userId}" name="userId">
            <input type="hidden" value="${transporter.id}" name="id">
        </div>
    </form>
</div>
<div class="modal-footer">
    <button type="button" class="btn btn-primary"
            onclick="$('#uform').trigger('validate')">提交
    </button>
    <button type="button" class="btn btn-default" onclick="transporter()">取消</button>
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
            url: '${context}/check/update/transporter',
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
    function transporter() {
        top.layer.closeAll();
    }
</script>