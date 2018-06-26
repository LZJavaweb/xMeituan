function enableUpdate(){
    $("#enableUp").attr("id","updateI");
    $("#updateI").removeAttr("type").removeAttr("onclick");
    $("#busiName").removeAttr("disabled");
    $("#busiPhone").removeAttr("disabled");
    $("#busiAddr").removeAttr("disabled");
    $("#busiShopName").removeAttr("disabled");
    $("#busiNotice").removeAttr("disabled");
    $("#uploadPic").removeAttr("disabled");
    $("#busiLogo").removeAttr("disabled");
    $("#updateI").attr("value","确认修改").attr("type","button").attr("onclick","updateInfoNext()");
}
function updateInfoNext(){
    $("#updateI").attr("id","enableUp");
    $("#enableUp").attr("onlick","enableUpdate()").attr("value","修改");
    $("#busiName").attr("disabled");
    $("#busiPhone").attr("disabled");
    $("#busiAddr").attr("disabled");
    $("#busiShopName").attr("disabled");
    $("#busiNotice").attr("disabled");
    $("#uploadPic").attr("disabled");
    $("#busiLogo").attr("disabled");
    $("#enableUp").attr("type","submit");
}
function upPicBtn(){
    $("#busiLogo").click();
}
/*
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
*/
/*
function xToSwitch(){
    var tmp = $("#xSwitch").attr("value");
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
*/
/*
function toSwitchNext(){
    var tmp = $("#xSwitch").attr("value");
    if(tmp==="继续营业"){
        $("#switch").attr("value","暂停营业").attr("class","btn btn-danger");
    }else{
        $("#switch").attr("value","继续营业").attr("class","btn btn-warning");
    }
}
*/
