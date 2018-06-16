function enableUpdate(){
    $("#enableUp").attr("id","updateI");
    $("#updateI").attr("onlick","updateInfo()").attr("value","确认修改");
    $("#busiName").removeAttr("disabled");
    $("#busiPhone").removeAttr("disabled");
    $("#busiAddr").removeAttr("disabled");
    $("#busiShopName").removeAttr("disabled");
}
function updateInfo(){
    var options={
        url:"../merchant/?",
        type:"post",
        dataType:"json",
        success:updateInfoNext
    };
    $("#infoForm").ajaxSubmit(options);
    return false;
}
function updateInfoNext(){
    $("#updateI").attr("id","enableUp");
    $("#enableUp").attr("onlick","enableUpdate()").attr("value","修改");
    $("#busiName").attr("disabled");
    $("#busiPhone").attr("disabled");
    $("#busiAddr").attr("disabled");
    $("#busiShopName").attr("disabled");
}
function toSwitch(){
    var tmp = $("#switch").attr("value");
    var data=""
    if(tmp==="继续营业"){
        data={"switch":"true"};
    }else{
        data={"swtich":"false"};
    }
    var options={
        url:"../merchant/?",
        type:"post",
        data:data,
        dataType:"json",
        success:toSwitchNext
    };
    $("#switch").ajaxSubmit(options);
}
function toSwitchNext(){
    var tmp = $("#switch").attr("value");
    if(tmp==="继续营业"){
        $("#switch").attr("value","暂停营业").attr("class","btn btn-danger");
    }else{
        $("#switch").attr("value","继续营业").attr("class","btn btn-warning");
    }
}
