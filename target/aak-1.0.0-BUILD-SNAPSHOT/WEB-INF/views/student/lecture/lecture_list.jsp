<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" info=""%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>lecture list</title>

<link rel="stylesheet" type="text/css"
	href="/all_about_knowledge/front/student/css/semantic.css">
<script src="https://code.jquery.com/jquery-3.1.1.min.js"
	integrity="sha256-hVVnYaiADRTO2PzUGmuLJr8BLUSjGIZsDYGmIJLv2b8="
	crossorigin="anonymous"></script>
<script src="/all_about_knowledge/front/student/js/semantic.js"></script>

<!-- Standard Meta -->
<meta charset="utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, maximum-scale=1.0">

<!-- Site Properties -->
<title>Fixed Menu Example - Semantic</title>

<!-- Semantic UI CSS -->
<link rel="stylesheet" type="text/css"
	href="https://cdnjs.cloudflare.com/ajax/libs/semantic-ui/2.4.1/semantic.min.css">
 <script type="text/javascript" src="<c:url value ="/resources/js/datatables.min.js"/>"></script>
<style type="text/css">
.search-container {
	display: flex;
	justify-content: flex-end;
	margin-bottom: 1em;
}

.ui.horizontal.menu .dropdown.item {
	width: auto; /* 기본 너비 설정 */
	min-width: 120px; /* 최소 너비 설정 */
	text-align: center; /* 텍스트 가운데 정렬 */
}

.ui.horizontal.menu .dropdown.item>.menu {
	min-width: 100%; /* 메뉴 너비 설정 */
	width: auto; /* 메뉴 너비 자동 설정 */
}

.ui.dropdown.item {
	text-align: center; /* 텍스트 가운데 정렬 */
}
</style>

<script type="text/javascript">
$(document).ready(function() {
    $('.ui.rating').rating({
        initialRating : 0,
        maxRating : 1
    });
    $('.ui.pointing.dropdown.link.item').dropdown();
    // 드롭다운 초기화
    /* $('.ui.pointing.dropdown.link.item').dropdown({
        on: 'hover',
        onChange: function(value, text, $choice) {
            if (text === '컴퓨터공학') {
                $('.ui.dropdown.item .menu .item').hide();
                $('.ui.dropdown.item .menu .item[data-value="0"], .ui.dropdown.item .menu .item[data-value="1"]').show();
                // 자료구조와 운영체제를 보여줄 경우
                fetchLectures(0);
            } else if (text === '프로그래밍 언어') {
                $('.ui.dropdown.item .menu .item').hide();
                $('.ui.dropdown.item .menu .item[data-value="2"], .ui.dropdown.item .menu .item[data-value="3"]').show();
                // JAVA와 C를 보여줄 경우
                fetchLectures(1);
            }
        }
    }); */

    // 각 항목 클릭 시 강의 데이터 요청
    $('.ui.dropdown.item.category .menu .item').on('click', function() {
        var cat_code = $(this).data('value');
        fetchLectures(cat_code);
    });

    function fetchLectures(cat_code) {
        $.ajax({
            url : "cat_code_lecture.do",
            type : "GET",
            dataType: "JSON",
            data : {cat_code: cat_code},
            success : function(jsonObj) {
                // 성공적으로 데이터를 받아온 경우
                var lectures = jsonObj.list;

                // 기존 강좌 카드들 삭제
                $('#lectureCards').empty();

                // 새로운 강좌 카드들 생성하여 추가
                $.each(lectures, function(index, lecture) {
                    var cardHtml = '<div class="card">';
                    cardHtml += '<a href="user_lecture_detail.do?sub_code=' + lecture.sub_code + '" class="image">';
                    cardHtml += '<img src="' + lecture.image + '">';
                    cardHtml += '</a>';
                    cardHtml += '<div class="content">';
                    cardHtml += '<div class="header">' + lecture.sub_title + '</div>';
                    cardHtml += '<div class="meta">';
                    cardHtml += '<a>' + lecture.inst_id + '</a>';
                    cardHtml += '</div>';
                    cardHtml += '</div>';
                    cardHtml += '<div class="extra content">';
                    cardHtml += '<span class="right floated">';
                    cardHtml += '<div class="ui heart rating"></div> 17 likes';
                    cardHtml += '</span>';
                    cardHtml += '<span><i class="user icon"></i> +100명</span>';
                    cardHtml += '</div>';
                    cardHtml += '</div>';

                    $('#lectureCards').append(cardHtml);
                });
            },
            error : function(xhr) {
                console.log(xhr.status + " : " + xhr.statusText);
                alert("서버 오류");
            }
        });
    } 

});
</script>

</head>
<body>

	<!-- 헤더 -->
	<jsp:include page="../site/main_header.jsp"></jsp:include>

	<div class="ui main container" style="padding-top: 20px; padding-bottom:300px">
		<h1 class="ui header">개설강좌</h1>

		<div class="ui menu">
		<!-- <form action="cat_code_lecture.do" id="frmCatCode"> -->
			<div class="ui pointing dropdown link item">
				<span class="text">카테고리</span> <i class="dropdown icon"></i>
				
				<!-- <div class="menu" name="cat_code" id="cat_code">
					<div class="item" data-value="0">
						<i class="dropdown icon"></i> <span class="text">컴퓨터공학</span>
						<div class="menu">
							<div class="item" value="0">자료구조</div>
							<div class="item" value="1">운영체제</div>
						</div>
					</div>
					<div class="item" data-value="1">
						<i class="dropdown icon"></i> <span class="text">프로그래밍 언어</span>
						<div class="menu">
							<div class="item" value="2">JAVA</div>
							<div class="item" value="3">C</div>
						</div>
					</div>
				</div> -->
				<div class="menu" name="cat_code" id="cat_code">
				<!-- <form action="" class="search-form" method="get"> -->
					<div class="item">
						<i class="dropdown icon"></i> <span class="text">컴퓨터공학</span>
						<div class="menu">
							<div class="item">자료구조</div>
							<div class="item">운영체제</div>
						</div>
					</div>
					<div class="item">
						<i class="dropdown icon"></i> <span class="text">프로그래밍 언어</span>
						<div class="menu">
							<div class="item">JAVA</div>
							<div class="item">C</div>
						</div>
					</div>
					<!-- </form> -->
				</div>
				
			</div>
			<!-- </form> -->
			<div class="search-container">
				<div class="ui icon input">
					<input type="text" placeholder="Search..."> <i
						class="search icon"></i>
				</div>
			</div>
		</div>


		<div
			style="display: flex; justify-content: space-between; align-items: center; margin-top: 10px; margin-bottom: 10px;">
			<div></div>
			<!-- 왼쪽 여백을 조절하기 위한 빈 div -->
			<select class="ui search dropdown">
				<option value="이름순">이름순</option>
				<option value="최신순">최신순</option>
				<option value="좋아요순">좋아요순</option>
				<option value="인기순">인기순</option>
			</select>
		</div>
		<div class="ui three stackable link cards" id="lectureCards">
			<c:forEach var="listLecture" items="${requestScope.listLecture }"
				varStatus="i">
				<div class="card" id="card">
					<a href="user_lecture_detail.do?sub_code=${listLecture.sub_code}"
						class="image"> 
						<%-- <img src="${pageContext.request.contextPath}/front/student/images/java.png"> --%>
						<img src="http://localhost/all_about_knowledge/upload/${ listLecture.image }"  class="card-img-top" alt="...">
					</a>
					<div class="content">
						<div class="header">
							<c:out value="${listLecture.sub_title}" />
						</div>
						<div class="meta">
							<a><c:out value="${listLecture.inst_id}" /></a> 강사님
						</div>
					</div>
					<div class="extra content">
						<span class="right floated">
							<div class="ui heart rating"></div>
						</span> <span> <i class="user icon"></i> +<c:out value="${listLecture.cnt}" />명 수강중
						</span>
					</div>
				</div>
			</c:forEach>
		</div>
		<%-- <div class="ui three stackable link cards" id="lectureCards">
			<c:forEach var="listLecture" items="${requestScope.listLecture }"
				varStatus="i">
				<div class="card" id="card">
					<a href="user_lecture_detail.do?sub_code=${listLecture.sub_code}"
						class="image"> <img
						src="${pageContext.request.contextPath}/front/student/images/java.png">
					</a>
					<div class="content">
						<div class="header">
							<c:out value="${listLecture.sub_title}" />
						</div>
						<div class="meta">
							<a><c:out value="${listLecture.inst_id}" /></a>
						</div>
					</div>
					<div class="extra content">
						<span class="right floated">
							<div class="ui heart rating"></div> 17 likes
						</span> <span> <i class="user icon"></i> +<c:out value="${listLecture.cnt}" />명
						</span>
					</div>
				</div>
			</c:forEach>
		</div> --%>
	</div>


	<!-- 푸터 -->
	<jsp:include page="../site/main_footer.jsp"></jsp:include>
</body>
<!-- jQuery -->
<script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
<!-- Semantic UI JavaScript -->
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/semantic-ui/2.4.1/semantic.min.js"></script>
</html>