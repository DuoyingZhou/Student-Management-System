$(function() {
    loadClasses();
    $("#insertForm").validate({
        debug: true,
        submitHandler: function (form) {
            form.submit();
        },
        rules: {

            "STUDENTID": {
                required: true
            },
            "NAME":{
                required: true
            },
            "AGE":{
                required: true,
                number: true
            },
            "ADDRESS":{
                required: true
            }
        }
    });
});

function loadClasses() {
    $.post("pages/back/classes/classes_list.action",{},function (obj) {
        $("#CLASSES\\.CLASSID tr:gt(0)").remove();
        for (var x = 0;x <obj.allClasses.length;x++){
            $("#CLASSES\\.CLASSID ").append($("<option value='"+obj.allClasses[x].CLASSID+"'>"+obj.allClasses[x].CLASSNAME+"</option>"));
        }
    },"json");
}