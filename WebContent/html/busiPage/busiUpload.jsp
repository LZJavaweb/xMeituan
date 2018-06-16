<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="zh-cn">
    <head>
        <title>米团商家版-美食上架</title>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="../../css/bootstrap-4.1.1.min.css">
        <script src="../../js/jquery-2.2.4.js"></script>
        <script src="../../js/jquery.form.js"></script>
        <style>#launch{height:720px;}</style>
    </head>
    <body> 
        <div class="container d-flex justify-content-center" id="launch">
            <div class="col-4 col align-self-center">
                <form id="launchForm" role="form">
                    <div class="form-group ">
                        <input onblur="checkInput()" name="SPname" id="SPname" type="text" class="form-control" maxLength="16" placeholder="商品名称">
                    </div>
                    <div class="form-group ">
                        <input onblur="checkInput()" name="SPdesc" id="SPdesc" type="text" class="form-control" placeholder="商品描述">
                    </div>
                    <div class="form-group ">
                        <input onblur="checkInput()" name="SPprice" id="SPprice" type="text" class="form-control" maxLength="16" placeholder="商品价格">
                    </div>
                    <div class="form-group ">
                        <input onblur="checkInput()" onclick="upPicBtn()" type="button" id="uploadPic" class="btn btn-defalut" value="上传照片">
                        <input name="SPpic" id="SPpic" class="form-control" type="file" accept="image/jpeg,image/png" style="opacity: 0">
                    </div>
                    <input onclick="toUpload()" id="upload" type="button" class="form-control btn btn-primary" disabled="disabled" value="上架">
                </form>
            </div>
        </div>
        <script src="../../js/popper-1.14.3.min.js"></script>
        <script src="../../js/bootstrap-4.1.1.min.js"></script>
        <script src="../../js/busiUpload.js"></script>
    </body>
</html>
