<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>InfoSec: 登录</title>
</head>
<body>
${sessionScope.SPRING_SECURITY_LAST_EXCEPTION.message} 
<div class="row-fluid">
		<div class="span12">
			<form class="form-horizontal" action ="j_spring_security_check" method="post">
				<div class="control-group">
					 <label class="control-label" for="inputEmail">用户名</label>
					<div class="controls">
						<input name='username' type="text" />
					</div>
				</div>
				<div class="control-group">
					 <label class="control-label" for="inputPassword">密码</label>
					<div class="controls">
						<input name="password" type="password" />
					</div>
				</div>
				<div class="control-group">
					<div class="controls">
						 <label class="checkbox"><input type="checkbox" /> Remember me</label> <button type="submit" class="btn">登陆</button>
					</div>
				</div>
			</form>
		</div>
	</div>
</body>
</html>