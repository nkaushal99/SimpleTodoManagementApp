<%@ include file="common/header.jsp" %>

<h1>Edit ToDo</h1><br>
<form action="/edit-todo" method="post">
	<input type="hidden" name="id" value="${todo.id}">
	description: <input type="text" name="description" value="${todo.description}"><br>
	Target Date: <input type="date" name="targetDate" value="${todo.targetDate}"><br>
	<button type="submit">Save</button>
</form>

<%@ include file="common/footer.jsp" %>