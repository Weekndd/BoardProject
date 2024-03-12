
function boardListSetUp() {
	$.ajax({
		type: "get", //서버에 get/post방식 요청
		url: "/getBoardList",//서버 요청 주소
		dataType:"json",
		success: function(data) { //요청에 대한 응답이 성공했을 때 동작할 코드
			data.forEach(function(item){
				var listItem = 
					"<tr>"+
						"<td>"+ item.board_id+"</td>"+
						"<td><a href=/board/"+item.board_id+">"+ item.title+"<a/></td>"+
						"<td>"+ item.writer+"</td>"+
						"<td>"+ item.create_at+"</td>"+
						"<td>"+ item.modified_at+"</td>"+
					"</tr>";
				$("tbody").append(listItem);
			})
			$(".totalBoard .here").append(data.length);
			
		},
		error: function(e){ //요청에 대한 응답이 error인 경우에 동작할 코드
			console.log("에러발생");
		}//error
	})//end ajax
}


function getBoardDetails(board_id) {
	$.ajax({
		type: "get",
		url: "/getBoardDetails/"+board_id,
		dataType:"json",
		success: function(data) {
			$("#title").text(data.title);
			$("#writer").text(data.writer);
			content = data.content
		},
		error: function(e){ //요청에 대한 응답이 error인 경우에 동작할 코드
			console.log("에러발생");
		}//error
	})//end ajax
}


function postLoginData(callback){
	var user = {
		"member_id": $("#user_id").val(),
		"passwd": $("#psw").val()
	}
	
		$.ajax({
		type: "post",
		url: "/postLoginData",
		contentType: "application/json",
		data: JSON.stringify(user),
		
		dataType:"json",
		success: function(data) {
			callback(null,data)
			console.log("포스트로그인데이터 : "+data.accessToken);
			
		},
		error: function(e){ //요청에 대한 응답이 error인 경우에 동작할 코드
			console.log("에러발생");
		}//error
	})//end ajax
	
}

	
