function checkAll(checked) {
//	alert("IS THIS CHECKED?? == " + checked);
	$(".checkbx").prop('checked', checked);
}

function executeDelete(URLPath) {
//	alert("THIS IS PATH " +URLPath);
	
	var data = $("#examlistForm").serialize();
//	alert("THIS IS DATA --> " + data);
	$.ajax({
		type: "GET",
		data: data,
		url: URLPath,
		success: function(responseData){
//			alert("THIS IS RESPONSE " + $(responseData).find("#examTableDiv").html());
			
				$("#examTableDiv").html($(responseData).find("#examTableDiv").html());
			
//			alert("DONE");
		},
		beforeSend: function() {
//		    alert("BEFORE SENDING");
		},
		complete: function() {
//			alert("Completed");
		}
	});
	
};

function executeAdd(URLPath) {
//	alert("THIS IS PATH " +URLPath);
	
	
	var data = $("#examForm").serialize();
//	alert("THIS IS DATA --> " + data);
	$.ajax({
		type: "GET",
		data: data,
		url: URLPath,
		success: function(responseData){
//			alert("THIS IS RESPONSE " + $(responseData).find("#examTableDiv").html());
			
				$("#examTableDiv").html($(responseData).find("#examTableDiv").html());
			
//			alert("DONE");
		},
		beforeSend: function() {
//		    alert("BEFORE SENDING");
		},
		complete: function() {
//			alert("Completed");
		}
	});
	
};

function executeRename(URLPath){
	alert("THIS IS PATH " +URLPath);
	
	
	$.ajax({
		type: "GET",
		data: data,
		url: URLPath,
		success: function(responseData){
//			alert("THIS IS RESPONSE " + $(responseData).find("#examTableDiv").html());
			alert("response" + $(responseData));
				$("#rename").html($(responseData).find("#examTableDiv").html());
			
//			alert("DONE");
		},
		beforeSend: function() {
		    alert("BEFORE SENDING");
		},
		complete: function() {
			alert("Completed");
			$("#rename").append(
					"<input type=\"text\" name=\"newname\">"+
					"<input type=\"submit\" value\"go\">"+
					$(responseData)
			);
		}
	});
	
	

};
