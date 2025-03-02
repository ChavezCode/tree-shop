function changeImage(element) {
    var treeSelected = element.value;
    document.querySelector("#species").src = "/" + treeSelected + ".jpg"
}