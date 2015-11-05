(function(window){	
	if (window.PersonJs) {
		return;
	}
	var Person = {};
	window.Person = Person;
	Person.modifyPersonView=function(PersonID){
		window.location.href=_currConText+"/person/modifyPersonView/"+PersonID; 
	};	
	
	
	Person.modifyPerson=function(){
		var id=		$("#id").val();
		var name=  	$("#name").val();
		var age=  	$("#age").val();
		$.ajax({
			type : "POST",
			async : false,
			url : _currConText+"/person/modifyPerson",
			data : {"Person.name":name,"Person.age":age,"Person.id":id},
			success : function(data) {
				if(data[0].msg='success'){
					alert("操作成功！");
					window.location.href=_currConText+"/person/list.do"; 	
				}else{
					alert(data[0].msg);
				}
			}
		});
	};

	Person.addPerson=function(){
		var id=		$("#id").val();
		var name=  	$("#name").val();
		var age=  	$("#age").val();
		$.ajax({
			type : "POST",
			async : false,
			url : _currConText+"/person/add",
			data : {"person.name":name,"person.age":age,"person.id":id},
			success : function(data) {
				if(data[0].msg='success'){
					alert("操作成功！");
					window.location.href=_currConText+"/person/list.action"; 	
				}else{
					alert(data[0].msg);
				}
			}
		});
	};

	Person.deletePerson=function(PersonID){
		$.ajax({
			type : "POST",
			async : false,
			url : _currConText+"/pub/demo/json/Person_delPerson.action?PersonID="+PersonID,
			success : function(data) {
				if(data[0].msg='success'){
					alert("删除成功！");
					window.location.href=_currConText+"/pub/demo/Person_queryPersonList.action"; 	
				}else{
					alert(data[0].msg);
				}
			}
		});
	};
	
})(window);
