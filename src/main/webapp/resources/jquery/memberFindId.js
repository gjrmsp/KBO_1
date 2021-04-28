/**
 * 
 */

$(member).on('click','#memberFindId',function(){
	var name = $('#name').val();
 	var email = $('#email').val();

	$.ajax({
        url:'./memberFindId',
        type:'POST',
        data: {'name' : name , 'email' : email},

        success: function(data){
			if(data != ''){
				alert('회원님의 아이디는 '+${dto.id}+' 입니다');
			} else {
				alert('일치하는 정보가 없습니다');
			}
			},
			error: function() {
        }
    });
});
