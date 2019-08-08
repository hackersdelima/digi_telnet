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