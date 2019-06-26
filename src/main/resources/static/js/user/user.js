/**
 * 
 */
/** 员工表单提交 */
function insertAndUpdateUser() {
	var username = $("#username");
	var status = $("#status");
	var loginname = $("#loginname");
	var password = $("#password");
	var flag = $("#flag");
	var msg = "";
	if ($.trim(username.val()) == "") {
		msg = "姓名不能为空！";
		username.focus();
	} else if ($.trim(loginname.val()) == "") {
		msg = "登录名不能为空！";
		loginname.focus();
	} else if ($.trim(loginname.val()).length < 6
			|| $.trim(loginname.val()).length > 20) {
		msg = "登录名需要大于6位小于20位！";
		loginname.focus();
	} else if (flag == 1) {
		if ($.trim(password.val()) == "") {
			msg = "密码不能为空！";
			password.focus();
		}
	}
	if (msg != "") {
		$.ligerDialog.error(msg);
		return false;
	}
	$("#insertAndUpdateForm").submit();
}

function cancleInsertUser() {
	window.location.replace("user");
}

function lastPage(obj) {
	if (obj.className == 'disabled') {
		return;
	}
	$("#type").val(1);
	$("#searchUser").submit();
}

function nextPage(obj) {
	if (obj.className == 'disabled') {
		return;
	}
	$("#type").val(2);
	$("#searchUser").submit();
}

$(function() {
	/** 获取上一次选中的部门数据 */
	var boxs = $("input[type='checkbox'][id^='box_']");

	/** 给数据行绑定鼠标覆盖以及鼠标移开事件 */
	$("tr[id^='data_']").hover(function() {
		$(this).css("backgroundColor", "#eeccff");
	}, function() {
		$(this).css("backgroundColor", "#ffffff");
	})

	/** 删除员工绑定点击事件 */
	$("#delete").click(function() {
		/** 获取到用户选中的复选框 */
		var checkedBoxs = boxs.filter(":checked");
		if (checkedBoxs.length < 1) {
			$.ligerDialog.error("请选择一个需要删除的用户！");
		} else {
			/** 得到用户选中的所有的需要删除的ids */
			var ids = checkedBoxs.map(function() {
				return this.value;
			})

			$.ligerDialog.confirm("确认要删除吗?", "删除用户", function(r) {
				if (r) {
					var form = document.createElement('form');
					form.action = 'removeUser';
					form.method = 'post';
					var input = document.createElement('input');
					input.type = 'hidden';
					input.name = 'ids';
					input.value = ids.get();
					form.appendChild(input);
					form.submit();
				}
			});
		}
	})

	$("#pager_jump_btn").click(function() {
		var jumpPage = $("#pager_jump_page_size");
		var msg = "";
		if ($.trim(jumpPage.val()) == "") {
			msg = "页码不能为空！";
			jumpPage.focus();
		}else{
			if(!/^\+?[1-9][0-9]*$/.test(jumpPage.val())){
				msg = "页码必须为正整数！";
				jumpPage.val("");
				jumpPage.focus();
			}else if(Number(jumpPage.val()) > Number($("#totalPage").text())){
				msg = "页码必须小于等于总页数！";
				jumpPage.val("");
				jumpPage.focus();
			}
		}

		if (msg != "") {
			$.ligerDialog.error(msg);
			return false;
		}
		var form = document.createElement('form');
		form.action = 'jumpPage';
		form.method = 'post';
		var input = document.createElement('input');
		input.type = 'hidden';
		input.name = 'page';
		input.value = jumpPage.val();
		form.appendChild(input);
		$(document.body).append(form);
		form.submit();
	})
})
		    
		    
