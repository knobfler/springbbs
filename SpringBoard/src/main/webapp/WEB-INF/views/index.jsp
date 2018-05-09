<%@include file="./common/header.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<h3 style="margin-top: 1rem; text-align: center">게시판 리스트</h3>
<a href="/board/write?bno=-1" class="btn btn-primary">글 작성하기</a>
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
				<td>
					<a href="/board/detail/${BoardList.bno}">
						${BoardList.title }
					</a>
				</td>
				<td>${BoardList.regDate }</td>
				<td>${BoardList.writer }</td>
			</tr>
		</c:forEach>

	</tbody>
</table>
<%@include file="./common/footer.jsp"%>