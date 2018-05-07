/**
 * 初始化 select 状态
 * @returns {Element}
 */
function initSelectStatus() {
    var select = document.getElementById("select");//读取select
    var auditStatus = document.getElementById("auditStatus");//读取审核状态
    for (var i = 0; i < select.options.length; i++) {
        if (select.options[i].value == auditStatus.value) {
            select.options[i].selected = true;
            break;
        }
    }
}

/**
 * 跳转到
 * @param newsId
 */
function toEditJsp(newsId) {
    window.open("/pages/back/edit.jsp?newsId="+newsId, "_blank", "height=400,width=400,resizable=false,left=300,top=300", false);
}

window.onload = function () {	// 在页面加载之后进行动态事件绑定
    //初始化 select 状态
    initSelectStatus();

    // select 添加监听
    document.getElementById("select").addEventListener("change", function () {
        var select = document.getElementById("select");//读取select选中的审核状态
        var lineSize = document.getElementById("lineSize");
        window.location.href = "/list?currentPage=1&lineSize=" + lineSize.value + "&auditStatus=" + select.value;
    }, false);

}
