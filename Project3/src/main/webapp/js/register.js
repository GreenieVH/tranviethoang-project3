
function register(){

		var formData = {
			'userAccount': $('#nameAccount').val(),
			'password': $('#password').val(),
			'repassword': $('#re_password').val(),
			'nameUser': $('#nameUser').val(),
			'emailUser': $('#emailUser').val(),
		};
		if (formData.password !== formData.repassword) {
			$('#errorSignup').text("Error: Mật khẩu không giống nhau");
			return;
		}
		$.ajax({
			type: 'POST',
			url: 'signup', // URL should match the servlet mapping
			contentType: 'application/json',
			data: JSON.stringify(formData),
			success: function(data, textStatus, xhr) {
				//location.reload(); // Tải lại trang nếu cần
				$('#errorSignup').text("Đăng ký thành công");
				console.log("ok")
			},
			error: function(xhr, textStatus, errorThrown) {
				var responseObj = JSON.parse(xhr.responseText);
				if (responseObj && responseObj.message) {
					$('#errorSignup').text("Error: " + responseObj.message); // Hiển thị lỗi từ JSON response
					console.log("loi")
				}
			}
		});

}