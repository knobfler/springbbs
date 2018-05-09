<%@include file="../common/header.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<form name="writeForm" method="post" action="/board/${action }"
	style="margin-top: 3rem;">
	<input type="hidden" name="bno" value="${detail.bno }"/> 
	<div class="form-group">
		<label for="title">제목을 입력해주세요.</label> <input type="text"
			class="form-control" id="title" name="title" value="${detail.title }">
	</div>
	<div class="form-group">
		<label for="username">이름을 입력해주세요.</label> <input type="text"
			class="form-control" id="username" name="writer"
			value="${detail.writer }">
	</div>
	<div class="form-group">
		<label for="content">내용을 입력해주세요</label>
		<textarea class="form-control" id="content" name="content" rows="3">${detail.content }</textarea>
	</div>

	<c:choose>
		<c:when test="${empty detail}">
        	<button type="submit" class="btn btn-primary">작성하기</button>
    	</c:when>
		<c:otherwise>
        	<button type="submit" class="btn btn-primary">수정하기</button>
    	</c:otherwise>
	</c:choose>



	
</form>
<%@include file="../common/footer.jsp"%>