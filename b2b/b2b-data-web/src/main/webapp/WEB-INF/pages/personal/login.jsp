<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/pages/comm/comm.jsp"%>
<html>
	<head>
	
	
		<meta charset="utf-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<title>嘉辰管理平台</title>
		<meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
		<!-- Bootstrap 3.3.5 -->
		<link rel="stylesheet" href="${context}/static/bootstrap/css/bootstrap.min.css">
		<!-- Theme style -->
		<link rel="stylesheet" href="${context}/static/dist/css/AdminLTE.min.css">
<%-- 		<link rel="stylesheet" type="text/css" href="${context}/static/plugins/iCheck/square/blue.css"> --%>
		<!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
		<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
		<!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
        <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
    		<!-- jQuery 2.1.4 -->
	<script src="${context}/static/plugins/jQuery/jQuery-2.1.4.min.js"></script>
	<!-- Bootstrap 3.3.5 -->
	<script src="${context}/static/bootstrap/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="${context}/static/dist/js/layer/layer.js"></script>
    <script type="text/javascript" src="${context}/static/nice-validator/jquery.validator.js"></script>
	<script type="text/javascript" src="${context}/static/nice-validator/local/zh_CN.js"></script>
</head>

	<body class="hold-transition login-page" style=" background:#000 url(${context}/static/dist/img/bg.jpg) no-repeat center top">
		<div class="login-box">
			<div class="login-logo">
				<a href="#">嘉辰管理平台</a>
			</div>
			<!-- /.login-logo -->
			<div class="login-box-body">
				<div id="triangle"></div>
				<p class="login-box-msg">欢迎登录</p>
				<form class="login-form" id="sysform" method="post">
					<div class="form-group has-feedback">
						<input type="text" name="userName" class="form-control" data-rule="用户名:required" placeholder="请输入用户名">
					</div>
					<div class="form-group has-feedback">
						<input type="password" name="passWord" class="form-control" data-rule="密码:required" placeholder="请输入密码">
					</div>
					<div class="row">
						<!-- /.col -->
						<div class="col-xs-12">
							<button type="button" onclick="$('#sysform').trigger('validate')" class="btn btn-primary btn-block btn-flat">登录</button>
						</div>
						<!-- /.col -->
					</div>
				</form>

			</div>
			<!-- /.login-box-body -->
		</div>
		<!-- /.login-box -->
		<!-- ./wrapper -->
	</body>
	<script type="text/javascript">
	var checksubmit = false;
	$(function(){
		$("#sysform").validator({
			stopOnError : false, // 关闭此开关，以便一次性显示所有消息
			msgMaker : false,
			valid:function(){
				if(checksubmit == true){
					return false;
				}
				checksubmit = true;
				login();
			},
			invalid:function(form,error){
				checksubmit = false;
				var msg="";
				$(error).each(function(){
					msg += this +'<br>';
				})
				layer.msg(msg);
			}
		})
	})
	function login(){
        $.ajax({
            url:'${context}/personal/login',
            type:'post',
            data:$('#sysform').serialize(),
            dataType:'json',
            success:function(data){
                layer.msg(data.msg);
                if(data.code == 200){
                    window.location.href="${context}/main";
                }
                checksubmit = false;
            }
        })
    }
    	//回车登录
			$(function() {
				document.onkeydown = function(e) {
					e = e || event;
					var code = -1;
					code = e.keyCode || e.which || e.charCode;
					if (code == 13) {
						$('#sysform').trigger('validate');
					}
				};
			});
	</script>
</html>