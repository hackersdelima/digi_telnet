  function ajaxPost(url, formData){
		  
		// PREPARE FORM DATA
	      
		$.ajax({
			url:url,
			method:"post",
			data:JSON.stringify(formData),
			contentType: "application/json",
			success: function (data){
				alert('message:'+data.message);
		    },
		    error: function (err){
		    	alert(err.status);    
		    }
		});
  }
  
  function imagePost(url, data){
	  
		// PREPARE FORM DATA
	      
		$.ajax({
			url:url,
			method:"post",
			data:data,
			enctype: "multipart/form-data",
			processData:false,
			contentType:false,
			timeout:600000,
			cache:false,
			success: function (data){
				alert('message:'+data.message);
		    },
		    error: function (err){
		    	alert(err.status);    
		    }
		});
}