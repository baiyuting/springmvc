window.onload=function () {
    document.getElementById("addItem").addEventListener("click", function (e) {
        alert(document.getElementById("itemContainer").childElementCount);
        formStop(e);
    });
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