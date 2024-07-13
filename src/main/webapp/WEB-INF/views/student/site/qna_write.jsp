<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" info=""%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>문의사항</title>
<link rel="stylesheet" type="text/css"
	href="/all_about_knowledge/front/student/css/semantic.css">
<script src="https://code.jquery.com/jquery-3.1.1.min.js"
	integrity="sha256-hVVnYaiADRTO2PzUGmuLJr8BLUSjGIZsDYGmIJLv2b8="
	crossorigin="anonymous"></script>
<script src="/all_about_knowledge/front/student/js/semantic.js"></script>
<!--bootstrap 시작-->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
	crossorigin="anonymous">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
	crossorigin="anonymous"></script>
<!--bootstrap 끝-->
<!-- summernote 시작 -->
<link
	href="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote-bs4.min.css"
	rel="stylesheet">
<script
	src="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote-bs4.min.js"></script>
<!-- summernote 끝 -->

<style type="text/css">
body {
	background-color: #FFFFFF;
}

.ui.menu .item img.logo {
	margin-right: 1.5em;
}

.main.container {
	margin-top: 7em;
}

.wireframe {
	margin-top: 2em;
}

.ui.footer.segment {
	margin: 5em 0em 0em;
	padding: 5em 0em;
}

.ui.fixed.menu {
	background-color: #FFFFFF !important;
	color: #000000 !important;
}

.ui.fixed.menu .item {
	color: #000000 !important;
}

.ui.fixed.menu .item:hover {
	background-color: #F0F0F0 !important;
}

.ui.vertical.footer.segment {
	background-color: #FFFFFF !important;
	color: #000000 !important;
}

.ui.vertical.footer.segment .header, .ui.vertical.footer.segment .item {
	color: #000000 !important;
}

.ui.vertical.footer.segment .item:hover {
	background-color: #F0F0F0 !important;
}

.search-container {
	display: flex;
	justify-content: flex-end;
}
</style>

<script type="text/javascript">
	$(document)
			.ready(
					function($) {
						$(".clickable-row").click(function() {
							window.location = $(this).data("href");
						});

						$('#content')
								.summernote(
										{
											placeholder : '${ sessionScope.loginData.id }문의사항을 작성해 주세요.',
											tabsize : 2,
											width : 700,
											height : 200,
											toolbar : [
													[ 'style', [ 'style' ] ],
													[
															'font',
															[
																	'bold',
																	'underline',
																	'clear' ] ],
													[ 'color', [ 'color' ] ],
													[
															'para',
															[ 'ul', 'ol',
																	'paragraph' ] ],
													[ 'table', [ 'table' ] ],
													[
															'insert',
															[ 'link',
																	'picture',
																	'video' ] ],
													[
															'view',
															[ 'fullscreen',
																	'codeview',
																	'help' ] ] ]
										});//summernote

					});
</script>

</head>
<body>

	<div class="ui fixed menu">
		<div class="ui container">
			<a href="#" class="header item"> <img class="logo"
				src="assets/images/logo.png"> Project Name
			</a> <a href="#" class="item">Home</a>
			<div class="ui simple dropdown item">
				Dropdown <i class="dropdown icon"></i>
				<div class="menu">
					<a class="item" href="#">Link Item</a> <a class="item" href="#">Link
						Item</a>
					<div class="divider"></div>
					<div class="header">Header Item</div>
					<div class="item">
						<i class="dropdown icon"></i> Sub Menu
						<div class="menu">
							<a class="item" href="#">Link Item</a> <a class="item" href="#">Link
								Item</a>
						</div>
					</div>
					<a class="item" href="#">Link Item</a>
				</div>
			</div>
		</div>
	</div>

	<div class="ui main container">
    <h1 class="ui header">문의사항</h1>
    <hr>
    <div id="boardContent">
    <div class="field">
        <label>작성자: userId | 작성일: 2024-06-18</label>
    </div>
    <div class="field" style="margin-top: 10px; margin-bottom: 10px;">
        <label>제목</label>
        <input type="text" name="title" style="width: 60.2%; box-sizing: border-box; border-color: #ddd;" placeholder="제목을 입력하세요">
    </div>
    <div class="field">
        <textarea rows="5" name="content" id="content" style="width: 100%; box-sizing: border-box;" placeholder="문의사항을 입력하세요"></textarea>
        <div id="charCount" style="width: 60.2%; box-sizing: border-box; text-align: left; background-color: transparent; border: none; padding: 0;">0/300자</div>
    </div>
</div>
    <div style="margin-top: 10px;">
        <a href="site_qna.do">
            <button class="ui button">취소</button>
        </a>
        <a href="site_qna.do">
            <button class="ui button">보내기</button>
        </a>
    </div>
</div>

	<div class="ui inverted vertical footer segment">
		<div class="ui center aligned container">
			<div class="ui stackable inverted divided grid">
				<div class="three wide column">
					<h4 class="ui inverted header">Group 1</h4>
					<div class="ui inverted link list">
						<a href="#" class="item">Link One</a> <a href="#" class="item">Link
							Two</a> <a href="#" class="item">Link Three</a> <a href="#"
							class="item">Link Four</a>
					</div>
				</div>
				<div class="three wide column">
					<h4 class="ui inverted header">Group 2</h4>
					<div class="ui inverted link list">
						<a href="#" class="item">Link One</a> <a href="#" class="item">Link
							Two</a> <a href="#" class="item">Link Three</a> <a href="#"
							class="item">Link Four</a>
					</div>
				</div>
				<div class="three wide column">
					<h4 class="ui inverted header">Group 3</h4>
					<div class="ui inverted link list">
						<a href="#" class="item">Link One</a> <a href="#" class="item">Link
							Two</a> <a href="#" class="item">Link Three</a> <a href="#"
							class="item">Link Four</a>
					</div>
				</div>
				<div class="seven wide column">
					<h4 class="ui inverted header">Footer Header</h4>
					<p>Extra space for a call to action inside the footer that
						could help re-engage users.</p>
				</div>
			</div>
			<div class="ui inverted section divider"></div>
			<img src="assets/images/logo.png" class="ui centered mini image">
			<div class="ui horizontal inverted small divided link list">
				<a class="item" href="#">Site Map</a> <a class="item" href="#">Contact
					Us</a> <a class="item" href="#">Terms and Conditions</a> <a
					class="item" href="#">Privacy Policy</a>
			</div>
		</div>
	</div>
</body>

</html>