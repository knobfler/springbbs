<%@include file="./common/header.jsp"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<h3 style="margin-top: 1rem; text-align: center">Board List</h3>
<table class="table" style="margin-top: 1rem">

	<thead>
		<tr>
			<th scope="col">Number</th>
			<th scope="col">Title</th>
			<th scope="col">RegDate</th>
			<th scope="col">Writer</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${AllList}" var="BoardList">
			<tr>
				<th scope="row">${BoardList.bno}</th>
				<td>${BoardList.title }</td>
				<td>${BoardList.regDate }</td>
				<td>${BoardList.writer }</td>
			</tr>
		</c:forEach>

	</tbody>
</table>
<%@include file="./common/footer.jsp"%>