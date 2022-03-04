<%@ include file="common/header.jsp" %>

<a type="button" href="/add-todo">Add ToDo</a><br>
<hr>
<h1>List of ToDos</h1><br>

<table>
	<thead>
		<tr>
			<th>description</th>
			<th>Target Date</th>
			<th></th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${todos}" var="todo">
			<tr>
				<td>${todo.description}</td>
				<td>${todo.targetDate}</td>
				<td><a type="button" href="/edit-todo?id=${todo.id}">Edit</a>
				<td><a type="button" href="/delete-todo?id=${todo.id}">Delete</a></td>
			</tr>
		</c:forEach>
	</tbody>		
</table>

<%@ include file="common/footer.jsp" %>