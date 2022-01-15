<%@ page pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8" />
<title>Connection</title>
</head>
<body>
	<form method="get" action="user">
        <p>
            <input type="text" name="login" id="login" placeholder="Login..."/>
            <input type="submit" value="Log in"/>
        </p>
    </form> 
    
   	<form method="post" action="user">
        <p>
            <input type="text" name="login" id="login" placeholder="Login..."/>
            <input type="submit" value="Create a new account"/>
        </p>
    </form>  
</body>
</html>