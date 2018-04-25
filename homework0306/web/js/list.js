window.onload = function () {

}

function haveVoted(e, voted, itemId) {
    if (1 == voted) {//已经投过票了
        alert("已经投过票了");
        e.srcElement.checked = false;
    } else {//没有投过票，调用投票接口
        var xmlhttp;
        if (window.XMLHttpRequest) {// code for IE7+, Firefox, Chrome, Opera, Safari
            xmlhttp = new XMLHttpRequest();
        }
        else {// code for IE6, IE5
            xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
        }
        xmlhttp.onreadystatechange = function () {
            if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
                if (xmlhttp.responseText == "1")
                    alert("投票成功");
            }
        }
        xmlhttp.open("POST", "/vote", true);
        xmlhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
        xmlhttp.send("itemId=" + itemId);
    }
}