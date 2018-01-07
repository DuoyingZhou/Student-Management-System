var jsCommonCp = 1;
var jsCommonLs = 3;
var jsCommonPageSize;

function createSplitBar(allRecorders) {
    clearBar();
    calcPageSize(allRecorders);
    if (jsCommonPageSize > 1) {
        previousPage() ;
        addBar(1) ;
    }
    var seed = 3 ;
    if (jsCommonCp > seed * 2) {
        addDetailPage() ;
        var startPage = jsCommonCp - seed ;
        for (var x = startPage ; x <= jsCommonCp + seed ; x ++) {
            if (x < jsCommonPageSize) {
                addBar(x) ;
            }
        }
        if (jsCommonCp + seed * 2 < jsCommonPageSize) {
            addDetailPage() ;
        }
    } else {
        for (var x = 2 ; x <= jsCommonCp + seed ; x ++) {
            if (x < jsCommonPageSize) {
                addBar(x) ;
            }
        }
        if (jsCommonCp + seed <= jsCommonPageSize) {
            addDetailPage() ;
        }
    }

    addBar(jsCommonPageSize) ;
    if (jsCommonPageSize > 1) {
        nextPage() ;
    }
}
function addDetailPage() {
    var liObj = $("<li><span>...</span></li>") ;
    $("#pagecontrol").append(liObj) ;
}
function previousPage() {
    var liObj = $("<li></li>");
    var aObj = $("<a style='cursor:pointer;'>Last Page</a>");
    if (jsCommonCp == 1) {
        liObj.addClass("disabled") ;
    } else {
        aObj.on("click",function(){
            if (jsCommonCp > 1) {
                jsCommonCp -- ;
                loadData();
            }
        })
    }
    liObj.append(aObj) ;
    $("#pagecontrol").append(liObj) ;
}
function nextPage() {
    var liObj = $("<li></li>");
    var aObj = $("<a style='cursor:pointer;'>Next Page</a>");
    if (jsCommonCp == jsCommonPageSize) {
        liObj.addClass("disabled") ;
    } else {
        aObj.on("click",function(){
            if (jsCommonCp < jsCommonPageSize) {
                jsCommonCp ++ ;
                loadData();
            }
        })
    }
    liObj.append(aObj) ;
    $("#pagecontrol").append(liObj) ;
}
function clearBar() {
    $("#pagecontrol li").remove();
}
function addBar(index) {
    var liObj = $("<li></li>");
    var aObj = $("<a style='cursor:pointer;'>" + index + "</a>");
    if (jsCommonCp == index) {
        liObj.addClass("active") ;
    } else {
        aObj.on("click",function(){
            jsCommonCp = index ;
            loadData() ;
        })
    }
    liObj.append(aObj) ;
    $("#pagecontrol").append(liObj) ;
}
function calcPageSize(allRecorders) {
    if (allRecorders == 0) {
        jsCommonPageSize = 1;
    } else {
        jsCommonPageSize = parseInt((allRecorders + jsCommonLs - 1) / jsCommonLs);
    }
}

function setSelectAll(eleA,eleB) {
    eleA.on("click",function () {
        eleB.each(function () {
            this.checked = eleA.prop("checked");
        })
    })
}

function  setDelete(btn,ele,url) {
    btn.on("click",function () {
        var data = "";
        ele.each(function () {
            if(this.checked){
                data += this.value + "|";
            }
        });
        if (data == ""){
            alert("Please select items!")
        }else{
            $.post(url,{"ids":data},function(obj){
                if(obj.trim() == "true"){
                    $("#alertDiv").attr("class","alert alert-success");
                    $("#alertText").text("Delete Success!");
                    loadData();
                }else{
                    $("#alertDiv").attr("class","alert alert-danger");
                    $("#alertText").text("Delete Failure!");
                }
                $("#alertDiv").fadeIn(2000,function () {
                    $("#alertDiv").fadeOut(2000);
                });
            },"text");
        }
    })
}