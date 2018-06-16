<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="zh-cn">
    <!--顾客订单-->
    <head>
        <title>米团商家版</title>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="../../css/bootstrap-4.1.1.min.css">
        <script src="../../js/jquery-2.2.4.js"></script>
        <script src="../../js/jquery.form.js"></script>
        <script>
            window.onload = toLoad();
        </script>
    </head>
    <body>
        <nav class="navbar navbar-expand-sm bg-warning navbar-dark">
            <ul class="navbar-nav">
                <li class="nav-item active">
                    <div class="dropdown">
                        <button type="button" class="btn btn-primary dropdown-toggle" data-toggle="dropdown">
                            顾客订单
                        </button>
                        <div class="dropdown-menu">
                            <a class="dropdown-item" href="#">顾客订单</a>
                            <a class="dropdown-item" href="#">历史订单</a>
                        </div>
                    </div>
                </li>
                <li class="nav-item">
                <a class="nav-link" href="#">美食上架</a>
                </li>
                <li class="nav-item">
                <a class="nav-link" href="#">店铺信息</a>
                </li>
            </ul>
        </nav>
        <ul id="pageBar" class="pagination">
                <li class="page-item"><a class="page-link" href="#">Previous</a></li>
                <li class="page-item active"><a class="page-link" href="#">1</a></li>
                <li class="page-item"><a class="page-link" href="#">2</a></li>
                <li class="page-item"><a class="page-link" href="#">3</a></li>
                <li class="page-item"><a class="page-link" href="#">Next</a></li>
        </ul>
        <script src="../../js/popper-1.14.3.min.js"></script>
        <script src="../../js/bootstrap-4.1.1.min.js"></script>
        <script src="../../js/busiOrder.js"></script>
    </body>
</html>
