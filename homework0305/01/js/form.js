window.onload = function () {	// 在页面加载之后进行动态事件绑定

    document.getElementById("email").addEventListener("blur", function () {
        validateEmail();
    }, false);

    document.getElementById("conf").addEventListener("blur", function () {
        validateConf();
    }, false);

    document.getElementById("city").addEventListener("change", function () {
        return validateCity();
    }, false);

    // document.getElementById("test").addEventListener("click", function () {
    //     return validateHabbit();
    // }, false);

    document.getElementById("loginForm").addEventListener("submit", function (e) {
        if (validateEmail() && validateConf() && validateCity() && validateHabbit()) {
            // alert("validateEmail:" + validateEmail() + ";validateConf:" + validateConf() + ";validateCity" + validateCity() + ";validateHabbit:" + validateHabbit());
            this.submit();	// 当前元素提交表单	
        } else {
            // alert("formstop");
            formStop(e);
        }
    }, false);

}


function validateEmail() {
    var emailObj = document.getElementById("email");
    if (emailObj.value == "") {
        alert("您还没有输入信息，无法登录！");
        return false;
    } else {	// 输入正确，理论上可以进行提交
        if (/^\w+@\w+\.\w+$/.test(emailObj.value) || /^\d{11}$/.test(emailObj.value)) {
            return true;
        } else {	// 验证不通过
            alert("请输入合法的EMAIL地址或者手机号！");
            return false;
        }
    }
}

function validateConf() {
    return validateRepeat("password", "conf");
}

function validateCity() {
    var city = document.getElementById("city");
    if (city.value == '--') {
        alert("请选择一个城市！");
        return false;
    }
    return true;
}


function validateHabbit() {
    var habbits = document.getElementsByName("habbit")
    var count = 0;
    for (let index = 0; index < habbits.length; index++) {
        var element = habbits[index];
        if (element.checked) {
            count++;
        }
    }
    if (count < 2) {
        alert("选择爱好数量不足2个！");
    }
    return count >= 2;
}



/**
  * 本方法主要是验证指定元素的内容是否为空
*/
function validateEmpty(eleId) {
    var obj = document.getElementById(eleId);	// 取得一个表单元素
    if (obj != null) {
        if (obj.value == "") {	// 数据错误
            setFailureStyle(obj);
            return false;	// 验证失败
        } else {
            setSuccesStyle(obj);
            return true;	// 验证成功
        }
    }
    return false;
}
// src要比较的原始数据，dist要设置比较的字段ID
function validateRepeat(srcId, distId) {
    if (validateEmpty(srcId) && validateEmpty(distId)) {
        var srcObj = document.getElementById(srcId);
        var distObj = document.getElementById(distId);
        if (srcObj.value != distObj.value) {	// 失败
            setFailureStyle(distObj);
            return false;	// 验证失败
        } else {	// 成功
            setSuccesStyle(distObj);
            return true;	// 验证成功
        }
    }
    return false;
}
function setSuccesStyle(obj) {	// 设置成功
    obj.className = "success";	// 设置正确的样式
    var spanObj = document.getElementById(obj.id + "Span");	// 取得提示信息元素
    if (spanObj != null) {
        spanObj.innerHTML = "<font color='green'>√</font>";	// 设置元素内部内容
    }
}
function setFailureStyle(obj) {	// 设置失败
    obj.className = "failure";	// 设置错误的样式
    var spanObj = document.getElementById(obj.id + "Span");	// 取得提示信息元素
    if (spanObj != null) {
        spanObj.innerHTML = "<font color='red'>×</font>";	// 设置元素内部内容
    }
}

/**
	阻止表单在出现问题时进行提交
*/
function formStop(e) {
    if (e && e.preventDefault) {	// 现在是在W3C标准下执行
        e.preventDefault();	// 阻止浏览器的动作
    } else {	// 专门针对于IE浏览器的处理
        window.event.returnValue = false;
    }
}
