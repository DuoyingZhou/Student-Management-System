$(function () {
    loadData();
    $("#alertDiv").fadeIn(0,function () {
        $("#alertDiv").fadeOut(0);
    });
    $("#updateForm").validate({ // 定义验证规则
        debug: true,  // 采用调试模式，表单不会自动提交
        submitHandler: function (form) {    // 当前表单对象
            // form.submit(); // 手工提交，如果不需要手工提交，可以在此处进行异步处理
            var STUDENTID = $("#SSTUDENTID").text();
            var NAME = $("#NAME").val();
            var AGE = $("#AGE").val();
            var ADDRESS = $("#ADDRESS").val();
            var GENDER = $("#GENDER").val();
            if (GENDER == "Male"){
                GENDER = 1;
            }else{
                GENDER = 0;
            }
            var CLASSID = $("#CLASSES").val()
            // alert(STUDENTID+","+NAME+","+AGE+","+ADDRESS+","+GENDER+","+CLASSID)
            $.post("pages/back/student/student_update.action",{"STUDENTID":STUDENTID,"NAME":NAME,"AGE":AGE,"ADDRESS":ADDRESS,"GENDER":GENDER,"CLASSES.CLASSID":CLASSID},function(obj){

                if(obj.trim() == "true"){
                    $("#alertDiv").attr("class","alert alert-success");
                    $("#alertText").text("Edit Success!");
                    $("#STUDENTID-"+STUDENTID).text(STUDENTID);
                    $("#NAME-"+STUDENTID).text(NAME);
                    $("#AGE-"+STUDENTID).text(AGE);
                    $("#ADDRESS-"+STUDENTID).text(ADDRESS);
                }else{
                    $("#alertDiv").attr("class","alert alert-danger");
                    $("#alertText").text("Edit Failure!");
                }
                $("#studentInfo").modal("hide");
                $("#alertDiv").fadeIn(2000,function () {
                    $("#alertDiv").fadeOut(2000);
                });
            },"text");
        },
        rules: {   // 为每一个表单编写验证规则

            "STUDENTID": {
                required: true  // 此字段不允许为空
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
})
function loadData() {   // 定义数据读取的操作函数
    $.post("pages/back/student/student_list.action", {"cp": jsCommonCp, "ls": jsCommonLs}, function (obj) {
        $("#studentTable tr:gt(0)").remove();
        for(var x=0;x < obj.allStudent.length;x++){
            var GENDER = obj.allStudent[x].GENDER;
            console.log("lskdfjsdklfjsdlkfs");
            console.log(obj);
            if (GENDER == "1"){
                GENDER = "Male";
            }else{
                GENDER = "Female";
            }
            addRow(obj.allStudent[x].STUDENTID,obj.allStudent[x].NAME,obj.allStudent[x].AGE,GENDER,obj.allStudent[x].ADDRESS, obj.allStudent[x].CLASSES.CLASSID);
        }
        createSplitBar(obj.allRecorders);
        setSelectAll($("#selall"),$("input[id='STUDENTID']"));
        setDelete($("#deleteBtn"),$("input[id='STUDENTID']"),"pages/back/student/student_delete.action");
    }, "json");
}

function addRow(STUDENTID,NAME,AGE,GENDER,ADDRESS, CLASSID) {
    var str = "<tr><td class='text-center'><input type='checkbox' class='text-center' name='STUDENTID' id='STUDENTID' value='"+STUDENTID+"'></td>" +
        "<td class='text-center' id='STUDENTID-"+STUDENTID+"'>"+STUDENTID+"</td>" +
        "<td class='text-center' id='NAME-"+STUDENTID+"'>"+NAME+"</td>" +
        "<td class='text-center' id='AGE-"+STUDENTID+"'>"+AGE+"</td>" +
        "<td class='text-center' id='GENDER-"+STUDENTID+"'>"+GENDER+"</td>" +
        "<td class='text-center' id='ADDRESS-"+STUDENTID+"'>"+ADDRESS+"</td>" +
        "<td class='text-center'><button type='button' class='btn btn-success btn-sm' data-toggle='modal' data-target='#studentInfo' id='"+ STUDENTID +"-"+ CLASSID +"'>Update</button> </td>" +
        "</tr>";
    $("#studentTable").append($(str));
    $("#"+STUDENTID+"-"+CLASSID).on("click",function () {
        console.log("where is classid")
        $("#SSTUDENTID").text(STUDENTID);
        $("#NAME").val(NAME);
        $("#AGE").val(AGE);
        $("#GENDER").val(GENDER);
        $("#ADDRESS").val(ADDRESS);
        loadClasses(CLASSID);
    });
}

function loadClasses(CLASSID) {
    $.post("pages/back/classes/classes_list.action",{},function (obj) {
        $("#CLASSES tr:gt(0)").remove();
        $("#CLASSES").empty();
        for (var x = 0;x <obj.allClasses.length;x++){
            if (obj.allClasses[x].CLASSID== CLASSID){
                $("#CLASSES").append($("<option value='"+obj.allClasses[x].CLASSID+"' selected>"+obj.allClasses[x].CLASSNAME+"</option>"));
            }else{
                $("#CLASSES").append($("<option value='"+obj.allClasses[x].CLASSID+"'>"+obj.allClasses[x].CLASSNAME+"</option>"));
            }

        }
    },"json");
}