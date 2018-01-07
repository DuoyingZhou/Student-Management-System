$(function () {
    loadDate();
})

function loadDate() {
    $.post("pages/back/classes/classes_list.action",{},function (obj) {
        $("#classesTable tr:gt(0)").remove();
        for (var x = 0;x <obj.allClasses.length;x++){
            addRow(obj.allClasses[x].CLASSID,obj.allClasses[x].CLASSNAME,obj.allClasses[x].DESCRIPTION);
        }
    },"json");
}

function addRow(CLASSID,CLASSNAME,DESCRIPTION) {
    var str = "<tr>" +
        "<td>"+CLASSID+"</td>"+
        "<td>"+CLASSNAME+"</td>"+
        "<td>"+DESCRIPTION+"</td>"
    "</tr>";
    $("#classesTable").append($(str));
}