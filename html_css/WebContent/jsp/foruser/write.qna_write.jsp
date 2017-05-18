<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>	

<c:set var="myPath" value="${pageContext.request.contextPath}" />

<c:import url="/jsp/common/header.jsp" />
<c:import url="/jsp/common/gnb.jsp" />
<c:import url="/jsp/common/lnb.jsp" />

<script type="text/javascript">
	function qna_write() {
		var form = document.getElementById('writeForm');
		var title = form.TITLE;
		var cont = form.CONT;

		if(!required(form)) {
			alert("필수사항을 입력해주시기 바랍니다.");
			return;
		}

		form.method = 'post';
		form.action = '${myPath}/service/foruser/qna_write.do';
		form.submit();

		console.log(form);
	}

	function required(form) {
		var arrs = form.getElementsByTagName('input');

		for (var i = 0; i < arrs.length; i++) {
			if (arrs[i].value.length == 0) {
				return false;
			}
		}

		return true;
	}

	function cancel() {
		var elements = document.getElementsByClassName('bitTxt');
		
		for(var i=0;  i < elements.length; i++) {
			 elements[i].value = '';
		}
	}
</script>

<style type="text/css">
#left, #center, #right {
	display: inline-block;
	zoom: 1;
	padding: 5px;
	vertical-align: middle;
}

#left {
	width: 0px;
}

#center {
	width: 696px;
}

#right {
	width: 0px;
}

td {
	font-size: 12px;
	padding: 5px;
	margin:5px 5px;	
	vertical-align: middle;
} 

tr:NTH-CHILD(odd) {
	font-size: 12px;
	padding: 0px;
	margin:0px;
	border-radius: 5px;
	border-left: 10px solid #1c64d1;
	border-right: 10px solid #5ba3e0;
	vertical-align: middle;
/* 	background-color: #2586d7; */
} 

tr:NTH-CHILD(even) {
	font-size: 12px;
	padding: 0px;
	margin:0px;
	border-radius: 5px;
	border-left: 10px solid #ffffff;
	border-right: 10px solid #ffffff;
	vertical-align: middle;
/* 	background-color: #2586d7; */
}

img {
    border: 1px solid #ddd;
    border-radius: 2px;
    padding: 2px;
}

img:hover {
    box-shadow: 0 0 1px 1px rgba(0, 140, 186, 0.5);
}

textarea {
	width: 572px;
	height: 400px;
}
::-webkit-input-placeholder {
   font-size: 12px;
    line-height: 15px;
}

:-moz-placeholder { /* Firefox 18- */
   font-size: 12px;
    line-height: 15px;
}

::-moz-placeholder {  /* Firefox 19+ */
    font-size: 12px;
    line-height: 15px;
}

:-ms-input-placeholder {  
    font-size: 12px;
    line-height: 15px;
}

#TITLE {
	width: 572px;
}

</style>
<div id="contentwrap">
	<div id="content">
		<div id="left" class="over_container"></div>
		<div id="center" class="over_container" align="center">
			<h1 style="font-size: 16px;">질문하기</h1>
			<hr style="display:inline-block;width:600px;">
		</div>
		<div id="right" class="over_container">
		</div>
	</div>
	<div id="content">
		<div id="left" class="over_container"></div>
		<div id="center" class="over_container">
			<form id="writeForm"  name="writeForm" enctype="multipart/form-data">				
				<table>
					<colgroup>
					<!-- 번호 , 내용 696px-->
					<col width="10px">
					<col width="102px">
					<col width="574px">
					<col width="10px">
					</colgroup>
					
					<tbody>
					<tr>
						<td></td>
						<td>제목</td>
						<td><input class="bitTxt" type="text" name="TITLE"
							id="TITLE" placeholder="제목을 입력하세요" required maxlength="200" required/></td>
						<td></td>
					</tr>
					<tr>
						<td></td>
						<td>파일첨부</td>
						<td><input class="bitTxt" type="file" name="UPLOADFILE" id="UPLOADFILE" 
							required /></td>
						<td></td>	
					</tr>
					<tr>
						<td></td>
						<td>내용</td>
						<td><textarea class="bitTxt" name="CONT" id="CONT" placeholder="내용을 입력해주세요" required></textarea></td>
						<td></td>
					</tr>
					</tbody>
				</table>
			</form>
			<table>
				<colgroup>
					<!-- 번호 , 내용 696px-->
					<col width="20px">
					<col width="102px">
					<col width="572px">
					<col width="20px">
				</colgroup>
				<tr>
					<td colspan="4" style="text-align: center;">
						<input class="bitBtn" type="button" id="WRITEBTN" value="등록" onclick="qna_write();" /> 
						<input class="bitBtn" type="button" id="CANCELBTN" value="취소" onclick="cancel();" />
					</td>
				</tr>
			</table>
		</div>
		<div id="right" class="over_container"></div>
	</div>
</div>
<c:import url="/jsp/common/footer.jsp" />