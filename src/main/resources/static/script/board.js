
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
						"<td><a href=/board/details/"+item.board_id+">"+ item.title+"</a></td>"+
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

	async function getLoginMember(){
		try{
			const data = await $.ajax({
				"type": "GET",
				"url": "/member/getLoginMember",
				"dataType": "json",
			})//end ajax
			loginMember = {
				"member_id" : data.member_id,
				"email" : data.email,
				"role" : "",  //role추가하게 되면 여기에 추가하면 됨
			}			
		}
		catch(e){
			console.log("로그인 정보를 가져오는 중 에러 발생",e)
		}
	}

	async function getBoardDetails(board_id) {
				try {
					 board = await $.ajax({
						type: "get",
						url: "/board/"+board_id,
						dataType:"json",
					})//end ajax
				}
				catch(e) {
					console.log("게시글 정보를 가져오는 중 에러 발생:", e);
				}
			}//end getBoardDetails


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

	
