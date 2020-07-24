function checkLogin() {
    var name = $("#Username").val();
    var pwd = $("#Password").val();

    if(name.trim().length===0) {
        alert("用户名不能为空!");
        $("#Username").focus();
        return false;
    }

    if(pwd.trim().length===0){
        alert("密码不能为空!");
        $("#Password").focus();
        return false;
    }

    /*var md5info = name + pwd;
    $('#hidePwd').val(md5(md5info));
    $("#password").val();*/
    /*$('.msg').hide();*/
    return true;
}




