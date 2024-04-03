
function backToBoardList(){
	window.location.href="/boardList?pageNum=1";
}

async function getPageInfo(pageNum) {
	const data = await $.ajax({
			type : "GET",
			url : "/getPageInfo?pageNum="+pageNum+"&type="+type+"&keyword="+keyword,
			dataType: "json",
			success: function(data){
				console.log(data)
			},
			error: function(e){
				console.log(e)
			}
			});//end ajax
	page = data;
}
function boardListSetUpWithPaging(criteria) {
	$.ajax({
		"type": "GET",
		url: "/getBoardListWithPaging?pageNum="+criteria.pageNum+"&type="+criteria.type+"&keyword="+keyword,//서버 요청 주소
		dataType:"json",
		success: function(data) {
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
				
				$("#keyword").val(keyword);
				$(".totalBoard .here").append(page.total);
				if(type=="T"){
					$("#typeT").attr("selected", true);
				}
				else if(type=="C"){
					$("#typeC").attr("selected", true);
				}
				else if(type=="W"){
					$("#typeW").attr("selected", true);
				}
				else if(type=="TC"){
					$("#typeTC").attr("selected", true);
				}
				else {
					$("#typeA").attr("selected", true);
					$("#keyword").val("");
				}
				
				var pagination = "";
				for(var i=page.startPage; i<=page.endPage; i++){
					if(criteria.pageNum == i){
						pagination += "<Strong><a href=/boardList?pageNum="+ i+""+extraUrl+">&nbsp"+i+"&nbsp</a></Strong>"
					}
					else {
						pagination += "<a href=/boardList?pageNum="+ i +""+extraUrl+">&nbsp"+i+"&nbsp</a>";
					}
				}
				$(".page p").append(pagination);
				
				if(page.next) {
					$(".page .buttons #next").attr("onclick","location.href='/boardList?pageNum="+(page.startPage+10)+extraUrl+"'");
				}
				if(page.prev) {
					$(".page .buttons #prev").attr("onclick","location.href='/boardList?pageNum="+(page.startPage-10)+extraUrl+"'");
				}
		},
		error: function(e){
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
		});//end ajax
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

	
