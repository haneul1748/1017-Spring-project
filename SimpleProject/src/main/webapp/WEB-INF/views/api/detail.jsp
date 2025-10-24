<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>식당 상세보기</title>
</head>
<body>

	<jsp:include page="../include/header.jsp"/>

	<div class="innerOuter">
		<div>
			<h1 id="title">${food.MAIN_TITLE}</h1>
			<br /><br />
			<p id="descript">${food.ITEMCNTNTS}</p>
			<br /><br />
			<p id="avail">${food.USAGE_DAY_WEEK_AND_TIME}</p>
			<br /><br />
			<p id="address">${food.ADDR1}</p>
			<br /><br />
			<img id="img" width="100%" height="240px"/>
		</div>
		<div id="map" style="width:100%; height:400px">
			
		</div>
		<button class="btn btn-sm btn-secondary" onclick="history.back();">뒤로가기</button>
	</div>
	
	<script>
		
		$(function(){
			$.ajax({
				url : `/spring/api/busan/detail/${num}`,
				success : response => {
					const food = response.getFoodKr.item[0];
					document.getElementById("title").innerText = food.MAIN_TITLE;
					document.getElementById("descript").innerText = food.ITEMCNTNTS;
					document.getElementById("avail").innerText = food.USAGE_DAY_WEEK_AND_TIME;
					document.getElementById("address").innerText = food.ADDR1;
					document.getElementById("img").src = food.MAIN_IMG_NORMAL;
				}
			})
		})
		
	</script>
	
	<jsp:include page="../include/footer.jsp"/>

</body>
</html>