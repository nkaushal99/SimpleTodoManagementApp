<%@ include file="common/header.jsp" %>

<h1>Add ToDo</h1><br>
<form action="/add-todo" method="post">
	description: <input type="text" name="description"><br>
	Target Date: <input type="date" name="date"><br>
	<button type="submit">Save</button>
</form>

<%@ include file="common/footer.jsp" %>