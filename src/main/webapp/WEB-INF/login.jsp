<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path;
%>
<html>
<!DOCTYPE html>
<!--[if IE 8]> <html lang="en" class="ie8 no-js"> <![endif]-->
<!--[if IE 9]> <html lang="en" class="ie9 no-js"> <![endif]-->
<!--[if !IE]><!-->
<html lang="en" class="no-js">
<!--<![endif]-->
<!-- BEGIN HEAD -->
<head>
    <meta charset="utf-8"/>
    <title>经纪人核心报表系统</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge"/>
    <meta content="width=device-width, initial-scale=1.0" name="viewport"/>
    <meta content="" name="description"/>
    <meta content="" name="author"/>
    <meta name="robots" content="noarchive"/>
    <!-- BEGIN GLOBAL MANDATORY STYLES -->
    <link href="<%=basePath%>/assets/plugins/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css"/>
    <link href="<%=basePath%>/assets/plugins/bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
    <link href="<%=basePath%>/assets/plugins/uniform/css/uniform.default.css" rel="stylesheet" type="text/css"/>
    <!-- END GLOBAL MANDATORY STYLES -->
    <!-- BEGIN THEME STYLES -->
    <link href="<%=basePath%>/assets/css/style-metronic.css" rel="stylesheet" type="text/css"/>
    <link href="<%=basePath%>/assets/css/style.css" rel="stylesheet" type="text/css"/>
    <link href="<%=basePath%>/assets/css/style-responsive.css" rel="stylesheet" type="text/css"/>
    <link href="<%=basePath%>/assets/css/plugins.css" rel="stylesheet" type="text/css"/>
    <link href="<%=basePath%>/assets/css/themes/default.css" rel="stylesheet" type="text/css"/>
    <link href="<%=basePath%>/assets/css/custom.css" rel="stylesheet" type="text/css"/>

    <link rel="stylesheet" type="text/css" href="<%=basePath%>/easyui/themes/bootstrap/easyui.css">
    <link rel="stylesheet" type="text/css" href="<%=basePath%>/easyui/themes/icon.css">
    <link rel="stylesheet" type="text/css" href="<%=basePath%>/easyui/demo.css">
    <link href="<%=basePath%>/assets/css/pages/login.css" rel="stylesheet" type="text/css"/>
    <!-- END THEME STYLES -->
    <style type="text/css">
        body {
            font-family: "Microsoft YaHei";
        }
        .panel-header, .panel-body {border-width: 0px;}.datagrid,.combo-p{border:solid 1px #D4D4D4;}.datagrid *{-webkit-box-sizing: content-box;-moz-box-sizing: content-box;box-sizing: content-box;}
    </style>
</head>
<!-- BEGIN BODY -->
<body class="login">
<!-- BEGIN LOGO -->
<div class="logo" style="vertical-align: middle;">
    <span style="font-size: 18px;font-family: Microsoft YaHei;color: #ffffff">经纪人核心报表系统</span>
</div>
<!-- END LOGO -->
<!-- BEGIN LOGIN -->
<div class="content">
<!-- BEGIN LOGIN FORM -->
<form class="login-form" action="<%=basePath%>/login" method="post">
    <input type="hidden" name="action" value="login">
    <h3 class="form-title">输入用户名密码</h3>
    <div class="alert alert-danger display-hide">
        <button class="close" data-close="alert"></button>
			<span id="messageSpan">
                <%
                    String errMsg = (String)request.getAttribute("errMsg") ;
                    if(errMsg != null && errMsg != "") {
                %>
                <%=errMsg%>
                <% }  else { %>
                &nbsp;
                <% } %>
			</span>
    </div>
    <div class="form-group">
        <!--ie8, ie9 does not support html5 placeholder, so we just show field title for that-->
        <label class="control-label visible-ie8 visible-ie9">Username</label>
        <div class="input-icon">
            <i class="fa fa-user"></i>
            <input class="form-control placeholder-no-fix" type="text" autocomplete="off" placeholder="用户名" name="username"/>
        </div>
    </div>
    <div class="form-group">
        <label class="control-label visible-ie8 visible-ie9">Password</label>
        <div class="input-icon">
            <i class="fa fa-lock"></i>
            <input class="form-control placeholder-no-fix" type="password" autocomplete="off" placeholder="密码" name="password"/>
        </div>
    </div>
    <div class="form-actions">
        <button type="submit" class="btn green pull-right">
            登录 <i class="m-icon-swapright m-icon-white"></i>
        </button>
    </div>
</form>
<!-- END LOGIN FORM -->
<!-- END REGISTRATION FORM -->
</div>
<!-- END LOGIN -->
<!-- BEGIN COPYRIGHT -->
<div class="copyright">
    2014 &copy; 爱屋吉屋. All right reserved.
</div>
<!-- BEGIN JAVASCRIPTS(Load javascripts at bottom, this will reduce page load time) -->
<!-- BEGIN CORE PLUGINS -->
<!--[if lt IE 9]>
<script src="<%=basePath%>/assets/plugins/respond.min.js"></script>
<script src="<%=basePath%>/assets/plugins/excanvas.min.js"></script>
<![endif]-->
<script src="<%=basePath%>/easyui/jquery.min.js" type="text/javascript"></script>
<script src="<%=basePath%>/assets/plugins/jquery-migrate-1.2.1.min.js" type="text/javascript"></script>
<script src="<%=basePath%>/assets/plugins/jquery-ui/jquery-ui-1.10.3.custom.min.js" type="text/javascript"></script>
<script src="<%=basePath%>/assets/plugins/bootstrap/js/bootstrap.min.js" type="text/javascript"></script>
<script src="<%=basePath%>/assets/plugins/bootstrap-hover-dropdown/bootstrap-hover-dropdown.min.js"
        type="text/javascript"></script>
<script src="<%=basePath%>/assets/plugins/jquery-slimscroll/jquery.slimscroll.min.js" type="text/javascript"></script>
<script src="<%=basePath%>/assets/plugins/jquery.blockui.min.js" type="text/javascript"></script>
<script src="<%=basePath%>/assets/plugins/jquery.cokie.min.js" type="text/javascript"></script>
<script src="<%=basePath%>/scripts/noty/packaged/jquery.noty.packaged.min.js"></script>
<!--script src="/assets/plugins/uniform/jquery.uniform.min.js" type="text/javascript"></script-->
<!-- END CORE PLUGINS -->
<script src="<%=basePath%>/assets/scripts/core/iw-comp.js?ver=${staticVer}" type="text/javascript"></script>
<script src="<%=basePath%>/assets/scripts/core/app.js?ver=${staticVer}" type="text/javascript"></script>
<script>
    jQuery(document).ready(function () {
        App.init();
    });
    function dateFormatter(date){
        var y = date.getFullYear();
        var m = date.getMonth()+1;
        var d = date.getDate();
        return y+'-'+(m<10?('0'+m):m)+'-'+(d<10?('0'+d):d);
    }
    function dateParser(s){
        if (!s) return new Date();
        var ss = (s.split('-'));
        var y = parseInt(ss[0],10);
        var m = parseInt(ss[1],10);
        var d = parseInt(ss[2],10);
        if (!isNaN(y) && !isNaN(m) && !isNaN(d)){
            return new Date(y,m-1,d);
        } else {
            return new Date();
        }
    }
</script>
<script type="text/javascript" src="<%=basePath%>/easyui/jquery.easyui.min.js"></script>
<script type="text/javascript" src="<%=basePath%>/easyui/locale/easyui-lang-zh_CN.js"></script>
<script type="text/javascript" src="<%=basePath%>/easyui/jquery.easyui.patch.js"></script>
<!-- END JAVASCRIPTS -->
    <script src="<%=basePath%>/assets/plugins/jquery-validation/dist/jquery.validate.min.js" type="text/javascript"></script>
    <script>
        jQuery(document).ready(function () {
            $('.login-form').validate({
                errorElement: 'span', //default input error message container
                errorClass: 'help-block', // default input error message class
                focusInvalid: false, // do not focus the last invalid input
                rules: {
                    username: {
                        required: true
                    },
                    password: {
                        required: true
                    },
                    remember: {
                        required: false
                    }
                },

                messages: {
                    username: {
                        required: "用户名必填."
                    },
                    password: {
                        required: "密码必填."
                    }
                },

                invalidHandler: function (event, validator) { //display error alert on form submit
                    $('#messageSpan').html("请输入用户名密码");
                    $('.alert-danger', $('.login-form')).show();
                },

                highlight: function (element) { // hightlight error inputs
                    $(element)
                            .closest('.form-group').addClass('has-error'); // set error class to the control group
                },

                success: function (label) {
                    label.closest('.form-group').removeClass('has-error');
                    label.remove();
                },

                errorPlacement: function (error, element) {
                    error.insertAfter(element.closest('.input-icon'));
                },

                submitHandler: function (form) {
                    form.submit(); // form validation success, call ajax form submit
                }
            });

            $('.login-form input').keypress(function (e) {
                if (e.which == 13) {
                    if ($('.login-form').validate().form()) {
                        $('.login-form').submit(); //form validation success, call ajax form submit
                    }
                    return false;
                }
            });

	        <%
                if(errMsg != null && errMsg != "") {
            %>
	        $('.alert-danger', $('.login-form')).show();
	        <% }  else { %>
	        $('.alert-danger', $('.login-form')).hide();
	        <% } %>

        });
    </script>
</body>
<!-- END BODY -->
</html>