window.onload = function () {

    fillData("city", -1);

    document.getElementById("city").addEventListener("change", function (ev) {
        var pid = ev.srcElement.options[ev.srcElement.selectedIndex].getAttribute("id");
        clearData("area");
        clearData("community");
        fillData("area", pid);
    });
    document.getElementById("area").addEventListener("change", function (ev) {
        clearData("community");
        fillData("community", ev.srcElement.options[ev.srcElement.selectedIndex].getAttribute("id"));
    });
}

function clearData(fillDataSelectElementStr){
    while (document.getElementById(fillDataSelectElementStr).children.length > 1) {
        document.getElementById(fillDataSelectElementStr).removeChild(document.getElementById(fillDataSelectElementStr).children[1]);
    }
}

function fillData(fillDataSelectElementStr, pid) {
    var xmlhttp;
    if (window.XMLHttpRequest) {// code for IE7+, Firefox, Chrome, Opera, Safari
        xmlhttp = new XMLHttpRequest();
    }
    else {// code for IE6, IE5
        xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
    }
    xmlhttp.onreadystatechange = function () {
        if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
            var arr = eval(xmlhttp.responseText);
            for (var index = 0; index < arr.length; index++) {
                var item = arr[index];
                var option = document.createElement("option");
                option.setAttribute("id", item.mid);
                option.setAttribute("name", item.mid);
                option.innerText = item.title;
                document.getElementById(fillDataSelectElementStr).appendChild(option);
            }
        }
    }
    xmlhttp.open("POST", "/menu", true);
    xmlhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
    xmlhttp.send("id=" + pid);
}