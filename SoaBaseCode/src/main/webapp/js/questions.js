function checkAll(checked) {
//	alert("IS THIS CHECKED?? == " + checked);
	$(".checkbx").prop('checked', checked);
}


function showAnswers(URLPath) {
	alert("THIS IS PATH " +URLPath);
	
	var data = $("#questionForm").serialize();
	alert("THIS IS DATA --> " + data);
	$.ajax({
		type: "GET",
		data: data,
		url: URLPath

	});
	
};