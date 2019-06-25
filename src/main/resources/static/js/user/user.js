/**
 * 
 */
    	/** 员工表单提交 */
		function insertUser(){
			var username = $("#username");
			var status = $("#status");
			var loginname = $("#loginname");
			var password = $("#password");
			var msg = "";
			if ($.trim(username.val()) == ""){
				msg = "姓名不能为空！";
				username.focus();
			}else if ($.trim(loginname.val()) == ""){
				msg = "登录名不能为空！";
				loginname.focus();
			}else if($.trim(loginname.val()).length < 6 || $.trim(loginname.val()).length > 20){
				msg = "登录名需要大于6位小于20位！";
				loginname.focus();
			}else if ($.trim(password.val()) == ""){
				msg = "密码不能为空！";
				password.focus();
			}
			if (msg != ""){
				$.ligerDialog.error(msg);
				return false;
			}
			$("#insertUserForm").submit();
		}
		
		function cancleInsertUser(){
			window.location.replace("user");
		}
