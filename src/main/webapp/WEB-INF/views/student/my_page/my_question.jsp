<!-- 
Desc : 사용자(학생)의 마이페이지 나의문의 화면
작성자 : 고한별
작성일 : 2024.06.12
 -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" info=""%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>마이페이지 - 나의문의</title>
<link rel="icon" href="/all_about_knowledge/favicon.png">
<link rel="stylesheet" type="text/css"
	href="/all_about_knowledge/front/student/css/semantic.css">
<script src="https://code.jquery.com/jquery-3.1.1.min.js"
	integrity="sha256-hVVnYaiADRTO2PzUGmuLJr8BLUSjGIZsDYGmIJLv2b8="
	crossorigin="anonymous"></script>
<script src="/all_about_knowledge/front/student/js/semantic.js"></script>
<style type="text/css">
</style>
<script type="text/javascript">
	$(function() {
		$('.tabular.menu .item').tab();
		/* initializeTabs(); */

		$(".clickable-row").click(function() {
			var title = $(this).data('title');
			var date = $(this).data('date');
			var content = $(this).data('content');
			var status = $(this).data('status');
			$('#modalTitle').text(title);
			$('#modalContent').text(content);
			/* $('#modalInfo').text('작성자: ' + std_id + ' | 상태: ' + status); */
			$('#myModal').modal('show');
		});
		// 모달 열기 버튼 클릭 이벤트
		$('#openModalBtn').click(function() {
			$('#myModal').modal('show'); // 모달을 보이도록 설정
		});
		// 글자 수 세기
		$('#content').on('input', function() {
			var textLength = $(this).val().length;
			$('#charCount').text(textLength + '/300자');
		});

	}); // ready
	/* function initializeTabs() {
		$('.tabular.menu .item').tab({
			onVisible : function(tabPath) {
				loadDataForTab(tabPath);
			}
		});
	} */
</script>
</head>
<body class="mypage">
	<!-- 사이드 네비게이션 바 -->
	<jsp:include page="mypage_side_nav.jsp"></jsp:include>

	<!-- 탑 네비게이션 바 -->
	<jsp:include page="mypage_top_nav.jsp"></jsp:include>

	<!-- 컨텐츠 영역 -->
	<article class="my_article">
		<div class="mypage_content_div">
			<!-- breadcrumb 표시 -->
			<div class="ui small breadcrumb div_margin">
				<a class="section">나의강의실</a> <i class="right chevron icon divider"></i>
				<div class="active section">나의문의</div>
			</div>

			<!-- menu tab 표시 -->
			<div class="ui top attached tabular menu">
				<a class="item active" data-tab="first"> 강의 문의 </a> <a class="item"
					data-tab="second"> AAK 문의 </a>
			</div>

			<!-- 강의 문의 -->
			<div class="ui bottom attached tab segment active" data-tab="first">
				<table class="ui celled padded table center aligned">
					<thead>
						<tr>
							<th class="center-aligned narrow-column">번호</th>
							<th class="center-aligned">제목</th>
							<th class="center-aligned narrow-column">작성자</th>
							<th class="center-aligned narrow-column">작성일</th>
							<th class="center-aligned narrow-column">답변상태</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="list" items="${requestScope.list }" varStatus="i">
							<tr class="clickable-row" data-href="my_question.do">
								<!-- <td class="center-aligned"></td>
								<td class="center-aligned"></td>
								<td class="center-aligned"></td>
								<td class="center-aligned"></td>
								<td class="center-aligned"></td> -->
								<td class="center-aligned"><c:out value="${i.count }" /></td>
								<td class="left-aligned"><c:out value="${list.question_title}" /></td>
								<td class="center-aligned"><c:out value="${list.q_std_id}" /></td>
								<td class="center-aligned"><fmt:formatDate pattern="yyyy-MM-dd" value="${list.q_date}" /></td>
								<td class="center-aligned">완료</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>

			<div class="ui bottom attached tab segment" data-tab="second">
				<table class="ui celled padded table center aligned">
					<thead>
						<tr>
							<th class="one wide">번호</th>
							<th class="single line">제목</th>
							<!-- <th class="one wide">시험</th>
							<th class="three wide">진도율</th> -->
							<th class="one wide">작성자</th>
							<th class="one wide">작성일</th>
							<th class="one wide">답변상태</th>
						</tr>
					</thead>
					<tbody>
					</tbody>
				</table>
			</div>

			<!-- 문의사항 테이블  active -->
			<!-- <div class="div_margin">
				강의 문의 테이블
				<div class="content ui tab active" data-tab="강의 문의" item="first">
					<h5>*강의와 관련된 문의는 문의하고 싶은 강의의 상세 페이지에서 작성해주세요</h5>
					<table class="ui celled selectable very basic table">
						<thead>
							<tr>
								<th>No</th>
								<th>제목</th>
								<th>과목명</th>
								<th>답변상태</th>
								<th>작성일</th>
							</tr>
						</thead>
						<tbody>
							<tr class="clickable-row" data-id="1" data-title="강의 문의 제목 1"
								data-date="2024-06-08" data-status="답변완료">
								<td>1</td>
								<td>강의 문의 제목 1</td>
								<td>과목명1</td>
								<td>답변완료</td>
								<td>2024-06-08</td>
							</tr>
							<tr class="clickable-row" data-id="2" data-title="강의 문의 제목 2"
								data-date="2024-06-07" data-status="대기중">
								<td>2</td>
								<td>강의 문의 제목 2</td>
								<td>과목명2</td>
								<td>대기중</td>
								<td>2024-06-08</td>
							</tr>
							<tr class="clickable-row" data-id="3" data-title="강의 문의 제목 3"
								data-date="2024-06-06" data-status="대기중">
								<td>3</td>
								<td>강의 문의 제목 3</td>
								<td>과목명3</td>
								<td>대기중</td>
								<td>2024-06-08</td>
							</tr>
						</tbody>
					</table>

				</div>

				<div class="content ui tab" data-tab="AAK 문의" item="second">
						<div style="text-align: right;">
							<button id="openModalBtn" class="ui button">문의 작성</button>
						</div>
						<div class="ui modal" id="myModal">
						<i class="close icon"></i>
						<div class="header">문의사항 작성</div>
						<div class="content">
							<div class="ui form">
								<div class="field">
									<label>작성자: userId | 작성일: 2024-06-18</label>
								</div>
								<div class="field">
									<label>제목</label> <input type="text" name="title"
										placeholder="제목을 입력하세요">
								</div>
								<div class="field">
									<label>내용</label>
									<textarea rows="5" name="content" id="content"
										placeholder="문의사항을 입력하세요"></textarea>
									<div class="ui message" id="charCount">0/300자</div>
								</div>
							</div>
						</div>
						<div class="actions">
							<div class="ui positive button">전송</div>
						</div>
					</div>
					<table class="ui celled selectable very basic table">
						<thead>
							<tr>
								<th>No</th>
								<th>Title</th>
								<th>Date</th>
								<th>답변</th>
							</tr>
						</thead>
						<tbody>
							<tr class="clickable-row">
								<td>1</td>
								<td>AAK 문의 제목 1</td>
								<td>2024-06-08</td>
								<td>답변완료</td>
							</tr>
							<tr>
								<td>2</td>
								<td>AAK 문의 제목 2</td>
								<td>2024-06-07</td>
								<td>답변완료</td>
							</tr>
							<tr>
								<td>3</td>
								<td>AAK 문의 제목 3</td>
								<td>2024-06-06</td>
								<td>대기중</td>
							</tr>
						</tbody>
					</table>
				</div>
			</div> -->

			<!-- 문의사항 상세보기 모달창 -->
			<div class="ui modal" id="myModal">
				<i class="close icon"></i>
				<div class="header">문의사항</div>
				<div class="content">
					<div class="ui form">
						<div class="field" style="text-align: left;">
							<h4>과목명 : 자바란 무엇인가?</h4>
						</div>
						<div class="field">
							<label>제목</label>
							<div class="content-box" id="modalTitle"></div>
						</div>
						<div class="field">
							<label>내용</label>
							<div class="content-box" id="modalContent">
								<p id="modalContent">강의와 관련된 문의입니다. 강의와 관련된 문의입니다. 강의와 관련된
									문의입니다. 강의와 관련된 문의입니다. 강의와 관련된 문의입니다. 강의와 관련된 문의입니다. 강의와 관련된
									문의입니다. 강의와 관련된 문의입니다.</p>
							</div>
						</div>
						<div class="field" style="text-align: right;">
							<label id="modalInfo">작성자: std_id | 작성일: 2024-06-18</label>
						</div>
						<div class="divider"></div>
						<div class="field">
							<label>강사의 답변</label>
							<div class="content-box" id="modalReply">
								<p>강사의 답변입니다. 강사의 답변입니다. 강사의 답변입니다. 강사의 답변입니다. 강사의 답변입니다.
									강사의 답변입니다. 강사의 답변입니다. 강사의 답변입니다. 강사의 답변입니다. 강사의 답변입니다.</p>
							</div>
							<div class="field" style="text-align: right;">
								<label id="modalInfo">작성자: std_id | 작성일: 2024-06-18</label>
							</div>
						</div>
					</div>
				</div>
			</div>

		</div>

	</article>

</body>
</html>