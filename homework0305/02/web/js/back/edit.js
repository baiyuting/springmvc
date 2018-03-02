window.onload = function () {	// 在页面加载之后进行动态事件绑定

    //初始化 子窗口 的值
    var newsId = document.getElementById("newsId").value;//获取 newsId Element 的value值
    document.getElementById("title").value = window.opener.document.getElementById(newsId + "title").innerHTML;
    document.getElementById("keyword").value = window.opener.document.getElementById(newsId + "keyword").innerHTML;
    document.getElementById("content").value = window.opener.document.getElementById(newsId + "content").innerHTML;
    document.getElementById("auditStatus").value = window.opener.document.getElementById(newsId + "content").innerHTML;
    document.getElementById("auditFailReason").innerHTML = window.opener.document.getElementById(newsId + "auditFailReason").innerHTML;

    document.getElementById("editForm").addEventListener("submit", function (e) {
        this.submit();	// 当前元素提交表单
        window.opener.location.href="/list?currentPage=1&lineSize=2&auditStatus="+document.getElementById("auditStatus").value;
        window.close();//关闭窗口
    }, false);


}
