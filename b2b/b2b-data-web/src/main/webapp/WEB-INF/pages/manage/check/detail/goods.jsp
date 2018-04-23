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
                <label class="control-label col-xs-2"> <label></label>
                </label>
                <div class="col-xs-8">
                    <p class="form-control-static">
                        <c:if test="${empty (goods.image)}">暂无图片</c:if>
                        <c:if test="${not empty (goods.image)}"><img class="img-responsive" src="${goods.image}"></c:if>
                    </p>
                </div>
            </div>
            <div class="form-group">
                <label class="control-label col-xs-2"> <label>名称:</label>
                </label>
                <div class="col-xs-8">
                    <p class="form-control-static">${goods.name}</p>
                </div>
            </div>
            <div class="form-group">
                <label class="control-label col-xs-2"> <label>价格:</label>
                </label>
                <div class="col-xs-8">
                    <p class="form-control-static">${goods.price}元/${goods.packing}</p>
                </div>
            </div>
            <div class="form-group">
                <label class="control-label col-xs-2"> <label>规格:</label>
                </label>
                <div class="col-xs-8">
                    <p class="form-control-static">${goods.packingCount}/${goods.packing}</p>
                </div>
            </div>
            <div class="form-group">
                <label class="control-label col-xs-2"> <label>保质期:</label>
                </label>
                <div class="col-xs-8">
                    <p class="form-control-static">${goods.shelfLife}天</p>
                </div>
            </div>
            <div class="form-group">
                <label class="control-label col-xs-2"> <label>品牌:</label>
                </label>
                <div class="col-xs-8">
                    <p class="form-control-static">${goods.brand}</p>
                </div>
            </div>
            <div class="form-group">
                <label class="control-label col-xs-2"> <label>配料:</label>
                </label>
                <div class="col-xs-8">
                    <p class="form-control-static">${goods.dosing}</p>
                </div>
            </div>
            <div class="form-group">
                <label class="control-label col-xs-2"> <label>储存方法:</label>
                </label>
                <div class="col-xs-8">
                    <p class="form-control-static">${goods.store}</p>
                </div>
            </div>
            <div class="form-group">
                <label class="control-label col-xs-2"> <label>适用人群:</label>
                </label>
                <div class="col-xs-8">
                    <p class="form-control-static">${goods.group}</p>
                </div>
            </div>
            <div class="form-group">
                <label class="control-label col-xs-2"> <label>产地:</label>
                </label>
                <div class="col-xs-8">
                    <p class="form-control-static">${goods.location}</p>
                </div>
            </div>
            <div class="form-group">
                <label class="control-label col-xs-2"> <label>口味:</label>
                </label>
                <div class="col-xs-8">
                    <p class="form-control-static">${goods.taste}</p>
                </div>
            </div>
            <div class="form-group">
                <label class="control-label col-xs-2"> <label>包装材料:</label>
                </label>
                <div class="col-xs-8">
                    <p class="form-control-static">${goods.packing}</p>
                </div>
            </div>
            <div class="form-group">
                <label class="control-label col-xs-2"> <label>包装信息:</label>
                </label>
                <div class="col-xs-8">
                    <p class="form-control-static">${goods.packing}</p>
                </div>
            </div>
            <div class="form-group">
                <label class="control-label col-xs-2"> <label>商品图文详情:</label>
                </label>
                <div class="col-xs-8">
                    <p class="form-control-static">
                    <c:forEach items="${goods.images }" var="image">
                        <img src="${image}">
                    </c:forEach>
                    </p>
                </div>
            </div>
            <div class="form-group">
                <label class="control-label col-xs-2"> <label>审核结果:</label>
                </label>
                <div class="col-xs-8">
                    <select class="form-control" name="verifyStatus">
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
            <input type="hidden" value="${goods.id}" name="id">
        </div>
    </form>
</div>
<div class="modal-footer">
    <button type="button" class="btn btn-primary"
            onclick="$('#uform').trigger('validate')">提交
    </button>
    <button type="button" class="btn btn-default" onclick="result()">取消</button>
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
            url: '${context}/check/update/goods',
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
</script>