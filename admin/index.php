<!DOCTYPE html>
<html>
<link rel="stylesheet" href="style.css">
<head>
	<title>Login system </title>
</head>
<body>
<div class="header">
	<h2>LOGIN</h2>
</div>
<form method="post" action="loginadmin.php">
	
	<div class="input-group">
		<label>Email</label>
		<input type="email" name="email" value="">
	</div>
	<div class="input-group">
		<label>Password</label>
		<input type="password" name="password_1">
	</div>
	
	<div class="input-group">
		<button type="submit" class="btn" name="submit_btn">Login</button>
	</div>
</form>
</body>
</html>
