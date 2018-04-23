<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/pages/comm/comm.jsp" %>
<section class="content-header">
    <h1>
        商品入库
        <small></small>
    </h1>
    <ol class="breadcrumb">
        <li><a href="${context }/main">
            <i class="fa"><img src="${context }/static/dist/img/home_ico.png" width="10" height="10"></i>首页</a>
        </li>
        <li class="active">商品入库</li>
    </ol>
</section>
<section class="content">
    <div class="row">
        <!-- left column -->
        <div class="col-md-12">
            <!-- general form elements -->
            <div class="box box-primary">
                <!-- form start -->
                    <div class="box-body" align="center">
                        <div class="form-group">
                            <input id="transportNo" type="text" style="text-align:center;width:500px;height:80px;font-size:22px;" class="form-control" placeholder="请输入配货单号或使用扫描枪扫描配货单二维码"/>
                        </div>
                        <button type="button" onclick="intoStorage()" class="btn btn-primary">确认</button>
                    </div>
            </div>
            <!-- /.box -->
        </div>
        <!--/.col (left) -->
    </div>
</section>

    <script type="text/javascript">
        function intoStorage() {
            var transportNo = $('#transportNo').val();
            $.ajax({
                url: "${context}/goodsInside/intoPage?transportNo=" + transportNo,
                dataType: "html",
                success: function (data) {
                    layer.open({
                        title: '商品入库',
                        type: 1,
                        skin: 'layui-layer-rim', //加上边框
                        area: ['1024px', '800px'], //宽高
                        content: data
                    });
                }
            });
        }
    </script>