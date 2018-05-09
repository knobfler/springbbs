<%@include file="../common/header.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<table class="table table-hover table-bordered"
	style="margin-top: 3rem;">
	<tr>
		<td>글 번호</td>
		<td>${detail.bno }</td>
	</tr>
	<tr>
		<td>작성자</td>
		<td>${detail.writer }</td>
	</tr>
	<tr>
		<td>글 제목</td>
		<td>${detail.title }</td>
	</tr>
	<tr>
		<td>글 내용</td>
		<td>${detail.content }</td>
	</tr>
</table>
<a href="/board/write?bno=${detail.bno }" class="btn btn-primary">수정하기</a>
<button type="button" onclick="deleteAction(${detail.bno });" class="btn btn-danger">삭제하기</button>

<form id="bnoform" style="display: none;">
	<input name="bno">
</form> 
	
<script>
	function deleteAction(bno) {
		var form = document.getElementById("bnoform");
		form.action = "/board/";
		form.method = "post";
		document.getElementsByName("bno")[0].value = bno;
		form.submit();
	}
</script> 
<%@include file="../common/footer.jsp"%>