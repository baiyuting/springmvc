window.onload = function () {	// 在页面加载之后进行动态事件绑定

    //初始化 子窗口 的值
    var newsId = document.getElementById("newsId").value;//获取 newsId Element 的value值
    document.getElementById("title").value = window.opener.document.getElementById(newsId + "title").innerHTML;
    document.getElementById("keyword").value = window.opener.document.getElementById(newsId + "keyword").innerHTML;
    document.getElementById("content").value = window.opener.document.getElementById(newsId + "content").innerHTML;
    document.getElementById("auditStatus").value = window.opener.document.getElementById(newsId + "auditStatus").innerHTML;
    document.getElementById("auditFailReason").innerHTML = window.opener.document.getElementById(newsId + "auditFailReason").innerHTML;

    document.getElementById("button").addEventListener("click", function () {
        alert("hi");
        var xmlhttp;
        if (window.XMLHttpRequest) {// code for IE7+, Firefox, Chrome, Opera, Safari
            xmlhttp = new XMLHttpRequest();
        }
        else {// code for IE6, IE5
            xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
        }
        xmlhttp.onreadystatechange = function () {
            if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
                // window.opener.location.reload();
                // window.close();//关闭窗口
                alert(xmlhttp.responseText);
            }
        }
        var title = document.getElementById("title").value;
        var keyword = document.getElementById("keyword").value;
        var content = document.getElementById("content").value;
        var auditStatus = document.getElementById("auditStatus").value;
        var auditFailReason = document.getElementById("auditFailReason").innerHTML;
        xmlhttp.open("POST", "/edit", true);
        xmlhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
        xmlhttp.send("newsId="+newsId+"&auditStatus="+auditStatus+"&auditFailReason="+auditFailReason);
    }, false);


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

}
