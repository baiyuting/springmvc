window.onload = function (ev) {
    document.getElementById("addUploadComponent").addEventListener("click", function (ev1) {
        //图片：<input type="file" id="img" name="img"><br>
        document.getElementById("files").appendChild(document.createTextNode("图片："))
        var inputComponent = document.createElement("input");
        inputComponent.setAttribute("type", "file");
        var id = document.getElementById("files").children.length;
        inputComponent.setAttribute("id", "file" + id);
        inputComponent.setAttribute("name", "file" + id);
        document.getElementById("files").appendChild(inputComponent);
        document.getElementById("files").appendChild(document.createElement("br"));
    });
}