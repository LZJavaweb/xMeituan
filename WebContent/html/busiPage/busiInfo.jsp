<!DOCTYPE html>
<html lang="zh-cn">
    <head>
        <title>米团商家版-店铺信息</title>
        <meta charset="utf-8">
        <meta name="viewpoint" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="../css/bootstrap-4.1.1.min.css">
        <script src="../js/jquery-2.2.4.js"></script>
        <script src="../js/jquery.form.js"></script>
        <style>#info{height:720px;}#service{height:70px;}</style>
    </head>
    <body>
        <div class="container d-flex justify-content-center" id="info">
            <div class="col-6 col align-self-center">
                <form role="form" id="infoForm">
                    <div class="form-group">
                        <label>姓名：</label>
                        <input name="busiName" id="busiName" type="text" class="form-control" disabled>
                    </div>
                    <div class="form-group">
                        <label>电话：</label>
                        <input name="busiPhone" id="busiPhone" type="text" class="form-control" disabled>
                    </div>
                    <div class="form-group">
                        <label>地址：</label>
                        <input name="busiAddr" id="busiAddr" type="text" class="form-control" disabled>
                    </div>
                    <div class="form-group">
                        <label>店铺名：</label>
                        <input name="busiShopName" id="busiShopName" type="text" class="form-control" disabled>
                    </div>
                    <div class="form-group">
                        <input onclick="enableUpdate()" id="enableUp" type="button" class="form-control btn btn-primary" value="修改">
                    </div>
                </form>
            </div>
            <div class="col-4 col align-self-center">
                <form role="form" id="pswForm">
                    <div class="form-group">
                        <label>修改密码</label>
                    </div>
                    <div class="form-group">
                        <input name="oriPsw" id="oriPsw" type="password" class="form-control" maxLength="16" placeholder="输入原密码">
                    </div>
                    <div class="form-group">
                        <input name="newPsw" id="newPsw" type="password" class="form-control" maxlength="16" placeholder="输入新密码">
                    </div>
                    <div class="form-group">
                        <input name="xNewPsw" id="xNewPsw" type="password" class="form-control" maxlength="16" placeholder="再次输入新密码">
                    </div>
                    <div class="form-group">
                        <input onclick="updatePsw()" id="updateP" type="button" class="btn btn-primary" value="确认修改">
                    </div>
                </form>
                <br/>
                <br/>
                <br/>
                <br/>
                <form role="form-group" id="service">
                    <div class="form-group">
                        <input onclick="toSwitch()" id="switch" type="button" class="btn btn-danger" value="暂停营业">
                    </div>
                </form>
            </div>
        </div>
        <script src="../js/popper-1.14.3.min.js"></script>
        <script src="../js/bootstrap-4.1.1.min.js"></script>
        <script src="./MInfo.js"></script>
    </body>
</html>
