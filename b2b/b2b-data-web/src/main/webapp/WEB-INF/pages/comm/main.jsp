<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/pages/comm/comm.jsp"%>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">  
    <title>${title}</title>
    <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
    <!-- Bootstrap 3.3.5 -->
    <link href="//cdn.bootcss.com/bootstrap/3.3.5/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="${context}/static/dist/css/AdminLTE.min.css">
    <link rel="stylesheet" href="${context}/static/dist/css/skins/skin-blue.css">
    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
    <!-- jQuery 2.1.4 -->
    <script src="${context}/static/plugins/jQuery/jQuery-2.1.4.min.js"></script>
    <!-- Bootstrap 3.3.5 -->
<script src="//cdn.bootcss.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
<script src="//cdn.bootcss.com/bootstrap/3.3.5/js/npm.js"></script>
    <!--<script src="${context}/static/dist/js/jquery.js"></script>-->
    <!--<script src="${context}/static/bootstrap/js/bootstrap-modal.js"></script>-->
    <!-- Slimscroll -->
    <script src="${context}/static/plugins/slimScroll/jquery.slimscroll.min.js"></script>
    <!-- FastClick -->
    <script src="${context}/static/plugins/fastclick/fastclick.min.js"></script>
    <!-- AdminLTE App -->
    <script src="${context}/static/dist/js/app.min.js"></script>
    <!-- AdminLTE for demo purposes -->
    <script src="${context}/static/dist/js/demo.js"></script>
    <script type="text/javascript" src="${context}/static/dist/js/layer/layer.js"></script>

</head>

<body class="hold-transition skin-blue sidebar-mini">
<div class="wrapper">
    <header class="main-header">
        <!-- Logo -->
        <a href="${context}/main" class="logo">
            <!-- mini logo for sidebar mini 50x50 pixels -->
            <span class="logo-mini"><b>${title}</b></span>
            <!-- logo for regular state and mobile devices -->
            <span class="logo-lg"><b>${title}</b></span> </a>
        <!-- Header Navbar: style can be found in header.less -->
        <nav class="navbar navbar-static-top" role="navigation">
            <!-- Sidebar toggle button-->
            <a href="#" class="sidebar-toggle" data-toggle="offcanvas" role="button"> <img src="${context}/static/dist/img/sidebar_ico.png" width="16" height="16"> </a>
            <div class="navbar-custom-menu">
                <ul class="nav navbar-nav">
                    <li class="dropdown user user-menu">
                        <a href="javascript:;" class="dropdown-toggle" data-toggle="dropdown"> <img src="${context}/static/dist/img/user2-160x160.jpg" class="user-image" alt="User Image"> <span class="hidden-xs">${userInfo.name}</span> </a>
                    </li>
                    <!-- Control Sidebar Toggle Button -->
                    <li>
                        <a href="${context}/personal/outlogin">退出</a>
                    </li>
                </ul>
            </div>
        </nav>
    </header>
    <!-- Left side column. contains the logo and sidebar -->
    <aside class="main-sidebar">
        <!-- sidebar: style can be found in sidebar.less -->
        <section class="sidebar">
            <!-- sidebar menu: : style can be found in sidebar.less -->
            <ul class="sidebar-menu">
                <c:forEach items="${records}" var="item">
                    <li class="treeview">
                        <c:if test="${not empty item.action}">
                            <a href="javascript: getPage('${context}${item.action}');">
                        </c:if>
                        <c:if test="${empty item.action}">
                            <a href="javascript:;">
                        </c:if>
                                <i><img src="${context}${item.icon}" width="16" height="16"></i><span>${item.name}</span>
                                <c:if test="${not empty item.menus}">
                                    <i class="fa fa-angle-left pull-right"><img src="${context}/static/dist/img/sidebar_arrow1.png" width="9" height="9"></i>
                                </c:if>
                            </a>
                            <c:if test="${not empty item.menus}">
                            <ul class="treeview-menu">
                                <c:forEach items="${item.menus}" var="menu">
                                    <li>
                                        <a href="javascript: getPage('${context}${menu.action}');"><i class="fa fa-circle-o"></i>${menu.name}</a>
                                    </li>
                                </c:forEach>
                            </ul>
                            </c:if>
                    </li>
                </c:forEach>
            </ul>
        </section>
        <!-- /.sidebar -->
    </aside>
    <!-- Content Wrapper. Contains page content -->
    <div class="content-wrapper">
        <style>
            .content-wrapper{ background:#000 url(${context}/static/dist/img/bg.jpg) no-repeat center top ;  position: relative;}

            .index-con{    position: absolute;
                top: 50%;
                left: 50%;
                width: 600px;
                height: 100px;line-height:100px;
                margin-top: -50px;
                margin-left: -300px;font-size:40px; color:#333;text-align: center;color: #fff;text-shadow:0 0 8px rgb(0, 0, 0);
            }
        </style>
        <div class="index-con">

            欢迎登录${title}！
        </div>
    </div>
    <!-- /.content-wrapper -->
    <footer class="main-footer"> 2017 &copy;${title} </footer>
    <!-- Add the sidebar's background. This div must be placed
   immediately after the control sidebar -->
    <div class="control-sidebar-bg"></div>
</div>
<!-- ./wrapper -->
<script>
    var baseurl="${context}";
    var activeurl="/main";
    function getPage(url)
    {
        $.ajax({
            url: url,
            data: {},
            dataType:'html',
            success: function(data) {
                $(".content-wrapper").html(data);
            }
        });
        activeurl=url;
    }
    <%--<c:if test="${not empty lasturl and lasturl ne '/main'}">--%>
    <%--getPage('${lasturl}')--%>
    <%--</c:if>--%>
    function outlogin(){
        $.ajax({
            url:'${context}/personal/outlogin',
            type:'post',
            data:{},
            dataType:'json',
            success:function(data){
                layer.msg(data.msg);
                if(data.code == 200){
                    window.location.href="/";
                }
            }
        })
    }
//    window.onbeforeunload = function() {
//        var n = window.event.screenX - window.screenLeft;
//        var b = n > document.documentElement.scrollWidth-20;
//        if(b && window.event.clientY < 0 || window.event.altKey){
//            //alert("这是一个关闭操作而非刷新");
//            window.event.returnValue = ""; //此处放你想要操作的代码
//        }else{
//            console.info("这是一个刷新操作而非关闭");
//           // window.event.returnValue = false; //此处放你想要操作的代码
//            lasturl(activeurl);//存放历史uri
//            throw "终止后续js操作";
//        }
//    }
    //lasturl
    function lasturl(url){
        $.ajax({
            url:'${context}/lasturl?lasturl='+url,
            type:'post',
            data:{},
            dataType:'json',
            success:function(data){
                //layer.msg(data.msg);
            }
        })
    }
</script>
</body>
<!-- <script src="https://dn-bts.qbox.me/sdk/bugtags-1.0.3.js"></script> -->
<!-- <script> -->
<!-- //     // VERSION_NAME 替换为项目的版本，VERSION_CODE 替换为项目的子版本 -->
<!-- //     new Bugtags('3bc190dfe2308c85908f7a437319eb04','1.0.0','1.0.0'); -->
<!-- </script> -->
</html>