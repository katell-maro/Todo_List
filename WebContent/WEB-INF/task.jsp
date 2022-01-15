<%@ page pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8" />
		<title>Todo List</title>
	</head>
	<body>
		<h1>My Todo List</h1>
		
		<form method="get" action="main">
	       	<input type="submit" value="Return"/>
       	</form>
		
		<c:forEach var="task" items="${ tasks }">
	  		<label for="${ task.id }" <c:if test="${ task.checked }"> style="text-decoration: line-through" </c:if>> 
	  			<c:out value="${ task.name }"/> 
  			</label>
	  		
	  		<form method="post" action="task" style="display:inline">
				<input hidden type="text" name="action" value="checked" />
				<input hidden type="text" name="id" value="${ task.id }" />
				<input 	type="submit" 
						<c:if test="${ task.checked }">value="Restore" </c:if> 
						<c:if test="${ !task.checked }">value="Complete" </c:if>>
			</form>
	  		
	  		<form method="post" action="task" style="display:inline">
	       		<input hidden type="text" name="action" value="delete" />
	       		<input hidden type="text" name="id" value="${ task.id }" />
	            <input type="submit" value="x"/>
	       </form>
		   <br/>
        </c:forEach>
        
       <form method="post" action="task">
	       	<p>
	       		<input hidden type="text" name="action" value="create" />
	            <input type="text" name="name" />
	            <input type="submit" value="Create new task"/>
	        </p>
       </form>

	</body>
</html>