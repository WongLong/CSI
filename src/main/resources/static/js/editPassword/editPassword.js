/**
 * 
 */
function subPassword() {
			var newPassword = $("#newPassword").val();
			var newPasswordCon = $("#newPasswordCon").val();
			var oldPassword = $("#oldPassword").val();
			if (newPassword.trim().length == 0) {
				$("#tishi").html("新密码不能为空");
				return;
			}
			if (newPassword.trim().length < 6 || newPassword.trim().length > 20) {
				$("#tishi").html("新密码必须大于6位小于20位");
				return;
			}
			if (typeof (newPasswordCon) == 'undefined'
					|| newPasswordCon.trim() == "") {
				$("#tishi").html("确认密码不能为空");
				return;
			}
			if (newPassword.trim() != newPasswordCon.trim()) {
				$("#tishi").html("新密码与确认密码必须保持一致");
				return;
			}

			if (typeof (oldPassword) == 'undefined'.toString() || oldPassword.trim() == "".toString()) {
				$("#tishi").html("当前密码不能为空");
				return;
			}
			$("#changePassword").submit();
			/*
			
			 $.ajax({
			 type: "POST",
			 url: "/hrm/user/editPassword",
			 async: true,
			 data:{
			 oldPassword:oldPassword.trim(),
			 newPassword:newPassword.trim(),
			 },
			 dataType: "json",
			 error: function (XMLHttpRequest, textStatus, errorThrown) {
			 alert("消息","出错了，请于管理员联系");
			 },
			 success: function (json) {

			 if(json.message!=""){
			 $("#tishi").html(json.message);
			 }else{
			
			 window.parent.location.replace("/hrm/");
			 //alert(JSON.stringify(json));
			 }
			 }
			 });
			 */
		}