(function(window){	
	if (window.PersonJs) {
		return;
	}
	var Person = {};
	window.Person = Person;
	Person.modifyPersonView=function(PersonID){
		window.location.href=_currConText+"/person/update.do?id=";+PersonID; 
	};	
	Person.addPersonView=function(){
		window.location.href=_currConText+"/person/update.do";
	};
	
	Person.deletePerson=function(PersonID){
		window.location.href=_currConText+"/person/delete.do?id="+PersonID;
	};
	
})(window);
