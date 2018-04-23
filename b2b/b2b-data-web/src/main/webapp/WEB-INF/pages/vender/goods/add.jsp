<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/pages/comm/comm.jsp" %>

<script type="text/javascript"
        src="${context}/static/datetimepicker/js/bootstrap-datetimepicker.min.js"
        charset="UTF-8"></script>
<script type="text/javascript"
        src="${context}/static/datetimepicker/js/bootstrap-datetimepicker.zh-CN.js"
        charset="UTF-8"></script>
<link rel="stylesheet"
      href="${context}/static/datetimepicker/css/bootstrap-datetimepicker.min.css"
      rel="stylesheet">
<script type="text/javascript"
        src="${context}/static/fileinput/js/fileinput.js"></script>
<script type="text/javascript"
        src="${context}/static/fileinput/js/locales/zh.js"></script>
<script type="text/javascript"
        src="${context}/static/fileinput/js/upload.js"></script>
<script type="text/javascript"
        src="${context}/static/fileinput/themes/gly/theme.js"></script>
<link rel="stylesheet"
      href="${context}/static/fileinput/css/fileinput.min.css"
      type="text/css"/>
<script type="text/javascript" src="${context}/static/tree/js/types.data.js"></script>
<script type="text/javascript" src="${context}/static/tree/js/types.js"></script>
<script type="text/javascript" src="${context}/static/tree/js/main.js"></script>
<section class="content-header">
    <h1>
        上传产品
        <small></small>
    </h1>
    <ol class="breadcrumb">
        <li><a href="#"><i class="fa"><img
                src="${context}/static/dist/img/home_ico.png" width="10"
                height="10"></i>首页</a></li>
        <li class="active">上传产品</li>
    </ol>
</section>
<br>
<div id="student-viewcon">
    <div class="container kv-main">

        <!-- 		<form class="form-horizontal" role="form" id="addgoods" action="vender/goods/add" accept-charset="UTF-8" method="post" enctype="multipart/form-data"> -->
        <form class="form-horizontal" role="form" id="addgoods">
            <div class="form-group col-sm-12">
                <input id="input-file" type="file" name="files" multiple
                       data-min-file-count="4">
            </div>

            <input type="hidden" name="id" value="${entity.id }">
            <div class="form-group">
                <div class="col-sm-12">
                    <input type="text" class="form-control" value="${entity.name }"
                           name="name" id="name" placeholder="请输入商品名称（例如：纯中纯矿泉水）">
                </div>
            </div>
            <div class="form-group">
                <div class="col-sm-12">
                    <input type="text" class="form-control" value="${entity.cbPrice }"
                           name="price"  placeholder="请输入商品出厂价格（例如：36.00RMB/箱）">
                </div>
            </div>
            <div class="form-group">
                <div class="col-sm-12">
                    <input type="text" class="form-control"
                           value="${entity.packingCount }" name="packingCount"
                           id="packing_count" placeholder="请输入商品规格（例如：510ml*24）">
                </div>
            </div>

            <div class="form-group">
                <div class="col-sm-12">
                    <input type="text" class="form-control" id="shelf_life"
                           placeholder="请输入保质期（例如：15天）">
                </div>
            </div>
            <div class="form-group">
                <div class="col-sm-12">
                    <input type="text" class="form-control" value="${entity.brand }"
                           name="brand" id="brand" placeholder="请输入商品品牌（例如：纯种纯）">
                </div>
            </div>

            <div class="form-group">
                <div class="col-sm-12">
                    <input type="text" class="form-control" value="${entity.dosing }"
                           name="dosing" id="dosing" placeholder="请输入产品配料（例如：水、矿物质、益生菌）">
                </div>
            </div>
            <div class="form-group">
                <div class="col-sm-12">
                    <input type="text" class="form-control" value="${entity.group }"
                           name="group" id="group" placeholder="请输入适用人群（例如：所有人）">
                </div>
            </div>
            <div class="form-group">
                <div class="col-sm-12">
                    <input type="text" class="form-control" value="${entity.location }"
                           name="location" id="location" placeholder="请输入产地（例如：固始）">
                </div>
            </div>
            <div class="form-group">
                <div class="col-sm-12">
                    <input type="text" class="form-control" value="${entity.taste }"
                           name="taste" id="taste" placeholder="请输入口味、非食品类可以不填（例如：无味）">
                </div>
            </div>
            <div class="form-group">
                <div class="col-sm-12">
                    <input type="text" class="form-control" value="${entity.unit }"
                           name="unit" id="unit" placeholder="请输入单位（例如：瓶）">
                </div>
            </div>
            <div class="form-group">
                <div class="col-sm-12">
                    <input type="text" class="form-control" value="${entity.packing }"
                           name="packing" id="packing" placeholder="请输入包装信息（例如：24瓶装1件）">
                </div>
            </div>
            <div class="form-group">
                <div class="col-sm-12">
                    <input type="text" class="form-control" value="${entity.store }"
                           name="store" id="store" placeholder="请输入储存方法">
                </div>
            </div>
            <div class="form-group">
                <div class="col-sm-12">
                    <input type="text" class="form-control" value="${entity.packing }"
                           name="manufacturer" id="manufacturer" placeholder="请输入包装单位">
                </div>
            </div>
            <div class="form-group">
                <div class="col-sm-12">
                    <input type="text" class="form-control" value="${entity.country }"
                           name="country" id="country" placeholder="请输入原产国家">
                </div>
            </div>
            <%--<div class="form-group">--%>
                <%--<div class="col-sm-12">--%>
                    <%--<label for="dtp_input2">请选择生产日期（例如：2016年10月1日）</label>--%>
                    <%--<div class="input-group date form_date col-md-5"--%>
                         <%--initialDate="new Date()" data-date-format="yyyy年mm月dd日"--%>
                         <%--data-link-field="dtp_input2" data-link-format="yyyy-mm-dd">--%>
                        <%--<input class="form-control" size="16" type="text" value=""--%>
                               <%--readonly> <span class="input-group-addon"><span--%>
                            <%--class="glyphicon glyphicon-remove"></span></span> <span--%>
                            <%--class="input-group-addon"><span--%>
                            <%--class="glyphicon glyphicon-calendar"></span></span>--%>
                    <%--</div>--%>
                    <%--<input type="hidden" id="dtp_input2" name="pDate"/><br/>--%>
                <%--</div>--%>
            <%--</div>--%>

            <div class="form-group">
                <div class="col-sm-12">
                    <label for="distpicker4">请选择该商品类别</label>
                    <div id="distpicker4" class=" form-inline">
                        <div class="form-group col-sm-2">
                            <label class="sr-only" for="province9">Province</label>
                            <select class="form-control" id="province9" name="typeId1"></select>
                        </div>
                        <div class="form-group col-sm-2">
                            <label class="sr-only" for="city9">City</label> <select
                                class="form-control" id="city9" name="typeId2"></select>
                        </div>
                        <div class="form-group col-sm-2">
                            <label class="sr-only" for="district9">District</label> <select
                                class="form-control" id="district9" name="typeId3"></select>
                        </div>
                    </div>
                </div>
            </div>
            <br/>
            <div class="form-group">
                <div class="col-sm-12">
                    <label for="area">请选择该商品配送区域</label>
                    <div class="box box-primary">
                        <div class="box-body">
                            <table id="area" class="table table-bordered">
                                <tbody>
                                <tr>
                                    <th>编号</th>
                                    <th>地区</th>
                                    <th>云库</th>
                                </tr>
                                <c:forEach items="${areas }" var="result">
                                    <tr>
                                        <td>
                                            <div class="checkbox">
                                                <label>
                                                    <input type="checkbox" name="locations"
                                                           value="${result.locationId}">${result.locationId}
                                                </label>
                                            </div>
                                        </td>
                                        <td>${result.locationName}</td>
                                        <td>${result.depotName}</td>
                                    </tr>
                                </c:forEach>
                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>
            </div>

            <div class="modal-footer">
                <div class="form-group">
                    <button type="button" class="btn btn-primary col-md-3" onclick="addImages()">提交</button>
                    <button type="reset" class="btn btn-warning col-md-3">重置</button>
                </div>
            </div>
        </form>
    </div>

</div>
<script type="text/javascript">

    $(function () {
        var path = "vender/goods/add";
        initFileInput("input-file", path);
    })
</script>

<script type="text/javascript">
    $('.form_date').datetimepicker({
        language: 'zh-CN',
        weekStart: 1,
        todayBtn: 1,
        autoclose: 1,
        todayHighlight: 1,
        startView: 2,
        minView: 2,
        forceParse: 0
    });
</script>
<script type="text/javascript">
    function addImages() {
        var formData = new FormData($("#addgoods")[0]);
        $.ajax({
            url: baseurl + "/vender/goods/add",
            type: 'POST',
            data: formData,
            async: false,
            cache: false,
            contentType: false,
            processData: false,
            dataType: 'json',
            success: function (data) {
                if (data.code == '200') {
                    layer.msg(data.msg);
                    $(':input', '#addOrder')
                        .not(':button, :submit, :reset')
                        .val('')
                        .removeAttr('checked')
                        .removeAttr('selected');
                    getPage('${context}/vender/goods/add');
                } else {
                    layer.msg(data.msg);
                }
            }
        });
    }
</script>
