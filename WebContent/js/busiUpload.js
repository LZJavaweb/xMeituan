function upPicBtn(){
    $("#uploadPic").click(function(){
        $("#SPpic").click();
    });
}
function checkInput(){
    var text0=$("#SPname").val();
    var text1=$("#SPdesc").val();
    var text2=$("#SPprice").val();
    var img0=$("#SPpic").val();
    if(text0==null||text0==""
        ||text1==null||text1==""
        ||text2==null||text2==""
        ||img0==null||img0==""){
        $("#upload").attr("disabled","disabled");
    }else{
        $("#upload").removeAttr("disabled");
    }
}
function toUpload(){
    var options={
		url:"../merchant/?",
		type:"post",
		dataType:"text",
		success: showResponse
    };
    $("#launchForm").ajaxSubmit(options);
    return false;
}
function showResponse(){
    //div局部刷新
    location.reload();
}
