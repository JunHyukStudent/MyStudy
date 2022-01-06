<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글(댓글 삽입,수정,삭제)</title>
<script src="jQuery/jquery-3.6.0.js"></script>
<style type="text/css">
	#content{
		height: 300px;
	}
</style>
</head>
<body>
	<h3>게시물 제목</h3>
	<p>작성자</p>
	<hr>
	<div id="content">게시물 내용</div>
	<hr>
	
	<table>
		<thead>
			<tr>
				<td>
					<form>
						<input type="button" value="댓글쓰기"><br>
						작성자 <input type="text" id="C_user"> 암호 <input type="password" id="C_password">
						<input type="button" value="댓글등록" onclick="insertComment()"><br>
						<textarea rows="5" cols="70" id="C_comment"></textarea>		
					</form>			
				</td>
			</tr>
		</thead>
		<tbody id="commentArea"></tbody>
	</table>
	
	<script>
		window.onload = selectAll();
	
		
		function insertComment(){
			let C_user = $('#C_user').val();
			let C_comment = $('#C_comment').val();
			let C_password = $('#C_password').val();
			
			let commentData = {
					"C_user":C_user,
					"C_comment":C_comment,
					"C_password":C_password
			}
			
			$.ajax({
				type:"POST",
				async:true,
				url:"writeComment",
				data:{
					"commentData":JSON.stringify(commentData)
				},
				dataType:"text",
				success:function(result){
					if(result == -1){
						alert('작성에 실패했습니다.');
					}else{
						alert('작성에 성공했습니다.');
					}
					selectAll();
				},
				error:function(){
					alert("작성중 에러가 발생했습니다.");
				}
			});	
		}

		function updatePassword(C_code){
			let C_password = document.getElementById("C_password"+C_code);
			let updateButton = document.getElementById("updateCommit"+C_code);
			let deleteButton = document.getElementById("deleteCommit"+C_code);
			let C_comment = document.getElementById("C_comment"+C_code);

			C_password.setAttribute("type","password");
			updateButton.setAttribute("type","button");
			deleteButton.setAttribute("type","hidden");
			C_comment.removeAttribute("readonly");
		}

		function deletePassword(C_code){
			let C_password = document.getElementById("C_password"+C_code);
			let updateButton = document.getElementById("updateCommit"+C_code);
			let deleteButton = document.getElementById("deleteCommit"+C_code);
			let C_comment = document.getElementById("C_comment"+C_code);

			C_password.setAttribute("type","password");
			deleteButton.setAttribute("type","button");
			updateButton.setAttribute("type","hidden");
			C_comment.setAttribute("readonly","readonly");
		}

		function updateComment(C_code){
			let C_comment = $('#C_comment'+C_code).val();
			let C_password = $("#C_password"+C_code).val();
			
			let commentData = {
					"C_code":C_code,
					"C_comment":C_comment,
					"C_password":C_password
			}
			
			$.ajax({
				type:"POST",
				async:true,
				url:"updateComment",
				data:{
					"commentData":JSON.stringify(commentData)
				},
				dataType:"text",
				success:function(result){
					if(result == -1){
						alert('비밀번호가 틀립니다.');
					}else{
						alert('수정이 완료되었습니다.');
					}
					selectAll();
				},
				error:function(){
					alert("수정중 에러가 발생했습니다.");
				}
			});	
		}

		function deleteComment(C_code){
			let C_password = $("#C_password"+C_code).val();
			
			let commentData = {
					"C_code":C_code,
					"C_password":C_password
			}
			
			$.ajax({
				type:"POST",
				async:true,
				url:"deleteComment",
				data:{
					"commentData":JSON.stringify(commentData)
				},
				dataType:"text",
				success:function(result){
					if(result == -1){
						alert('비밀번호가 틀립니다.');
					}else{
						alert('삭제가 완료되었습니다.');
					}
					selectAll();
				},
				error:function(){
					alert("삭제중 에러가 발생했습니다.");
				}
			});	
		}
		
		// 전체 목록 불러오기
		function selectAll(){
			$.ajax({
				type:"GET",
				async:true,
				url:"selectComment",
				dataType:"JSON",
				success:function(commentList){
					let cArea = document.getElementById('commentArea');
					cArea.innerHTML="";
					for(let i=0; i<commentList.length;i++){
						let tr = document.createElement('tr');
						let td = document.createElement('td');
						// 덧글 코드
						let C_code = commentList[i].C_code;
						// 작성자
						let C_user = commentList[i].C_user + " ";
						// 수정 버튼
						let updateButton = document.createElement('button');
						updateButton.setAttribute("type","button");
						updateButton.setAttribute("onclick","updatePassword(" + C_code + ")");
						updateButton.innerHTML="수정";
						// 삭제 버튼
						let deleteButton = document.createElement('button');
						deleteButton.setAttribute("type","button");
						deleteButton.setAttribute("onclick","deletePassword(" + C_code + ")");
						deleteButton.innerHTML="삭제";
						// 작성일
						let C_regdate = commentList[i].C_regDate + "<br>";
						// 내용
						let C_comment = document.createElement('textarea');
						C_comment.setAttribute("id","C_comment"+ C_code);
						C_comment.setAttribute("readonly","readonly");
						C_comment.innerHTML = commentList[i].C_comment;
						// 비밀번호(hidden) -> type password
						let C_password = document.createElement('input');
						C_password.setAttribute("type","hidden");
						C_password.setAttribute("id","C_password"+C_code);
						C_password.setAttribute("placeholder","password");

						// 수정버튼(hidden) -> type button
						let updateCommit = document.createElement('input');
						updateCommit.setAttribute("type","hidden");
						updateCommit.setAttribute("id","updateCommit"+C_code);
						updateCommit.setAttribute("onclick","updateComment("+C_code+")");
						updateCommit.setAttribute("value","확인");

						// 삭제버튼(hidden) -> type button
						let deleteCommit = document.createElement('input');
						deleteCommit.setAttribute("type","hidden");
						deleteCommit.setAttribute("id","deleteCommit"+C_code);
						deleteCommit.setAttribute("onclick","deleteComment("+C_code+")");
						deleteCommit.setAttribute("value","확인");
						
						
						// 댓글 넣기
						td.innerHTML = C_user;
						td.appendChild(updateButton);
						td.appendChild(deleteButton);
						td.innerHTML += C_regdate;
						td.appendChild(C_comment);
						td.innerHTML += "<br>";
						td.appendChild(C_password);
						td.appendChild(updateCommit);
						td.appendChild(deleteCommit);

						tr.appendChild(td);
						
						cArea.appendChild(tr);
					}
				},error:function(){
					alert("데이터를 불러오던중 에러가 발생했습니다.");
				}

			})
		}
	</script>
</body>
</html>