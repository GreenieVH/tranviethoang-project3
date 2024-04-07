
    $('#login-form').submit(function(event) {
        event.preventDefault();
        var formData = {
            userAccount: $('#userAccount').val(),
            password: $('#password').val()
          
        };
        console.log(formData)
        $.ajax({
            type: 'POST',
            url: 'login', // URL should match the servlet mapping
            contentType: 'application/json',
            data: JSON.stringify(formData),
            success: function(data, textStatus, xhr) {
                 // Chuyển hướng từ trang login sang trang home
				window.location.href = "/Project3/home";

            },
            error: function(xhr, textStatus, errorThrown) {
               $('#errorlogin').text("Error: Tài khoản hoặc mật khẩu không chính xác");
            }
        });
    });
