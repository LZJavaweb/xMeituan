<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
    <link href="src/zhku.ico" rel="shortcut icon">
	<link rel="stylesheet" type="text/css" href="../../css/userPage/reset.css">
	<link rel="stylesheet" type="text/css" href="../../css/userPage/main.css">
	<link rel="stylesheet" type="text/css" href="../../css/userPage/style.css">
	<link rel="stylesheet" type="text/css" href="../../css/userPage/adBar.css">
	<title>米团外卖</title>
</head>
<body>
	<header>
		<div class="commnWidth clearfix">
			<h1><a href="#" class="topbar-logo"><img src="../../resources/pagePics/topbar-logo-x.png" alt="导航栏LOGO"></a></h1>
			<div class="topbar-nav-list ">
		    	<a href="#" class="topbar-nav" id="topbar-home">首页</a>
				<a href="" class="topbar-nav"><i class="hot"></i>品牌商家</a>
				<a href="" class="topbar-nav">我的订单</a>
				<a href="" class="topbar-nav">加盟合作</a>
			</div><!-- topbar-nav-list end -->
		</div><!-- commnWidth end -->
	</header><!-- header end -->

	<div class="right-bar">
		<div class="right-bar-middle">
			<div class="right-bar-menu">
				<a href="" class="icon-buy-menu"><span class="icon-file-text"></span></a>
				<div class="rightbar-menu-multi">
					<div class="rightbar-menu-arrow"></div>
					<div class="rightbar-menu clearfix">
						<span>我的订单</span>
					</div>
				</div>
			</div><!-- right-bar-menu end -->
			
            <hr>
			<a href="" class="icon-shop-car"><span class="icon-cart"></span><span id="text-shop-car">购物车</span></a>
			<hr/>
			<a href="" class="icon-email"><span class="icon-envelop"></span></a>
			<a href="" class="icon-timeclock"><span class="icon-clock"></span></a>
		</div><!-- right-bar-middle end -->

        <div class="right-bar-bottom">
            <a href="javascript:void(0);" id="icon-moveup" onclick="moveTop(1)"><span class="icon-move-up"></span></a>
            <a href="javascript:void(0);" id="icon-movedown" onclick="moveDown(1);"><span class="icon-move-up"></span></a>
        </div><!-- right-bar-bottom end -->
	</div><!-- right-bar end -->

	<div class="main">
		<div class="main-top-bar commnWidth clearfix">
			<div class="top-bar-location">
				<span>当前位置: </span>
				<span class="top-bar-addr">
					<a href="" > &nbsp;仲恺农业工程学院8幢学生宿舍(东南门)</a>
				</span>
				
				<a href="" class="top-bar-change">[切换地址]</a>
			</div><!-- top-bar-location end -->
			<div class="top-bar-search">
				<input type="text" class="top-bar-searchText " placeholder="搜索商家，美食...">
				<a href="" class="top-bar-searchBtn"><span class="icon-search"></span></a>
			</div><!-- top-bar-search end-->
		</div><!-- main-top-bar end -->

		<div class="main-top-ad commnWidth" id="main-top-ad">
			<div id="top-ad-img">
				<a href=""><img src="../../resources/pagePics/ad-1.jpg" alt="广告图片"></a>
				<a href=""><img src="../../resources/pagePics/ad-2.jpg" alt="广告图片"></a>
				<a href=""><img src="../../resources/pagePics//ad-1.jpg" alt="广告图片"></a>
				<a href=""><img src="../../resources/pagePics/ad-2.jpg" alt="广告图片"></a>
				<a href=""><img src="../../resources/pagePics/ad-1.jpg" alt="广告图片"></a>
				<a href=""><img src="../../resources/pagePics/ad-2.jpg" alt="广告图片"></a>
			</div>
		</div><!-- main-top-ad end -->

		<div class="main-top-title commnWidth">
			<a href="" id="takeaway-shop">外卖商家</a>
			<a href="">文具打印速递</a>
		</div><!-- main-top-title end -->

		<div class="main-mid-class commnWidth">
			<a href="javascript:void(0);" id="mid-all-shop" onclick="showClassMenu(-1);">全部商家</a>
			<a href="javascript:void(0);" id="mid-band-shop" >品牌商家</a>
			<a href="javascript:void(0);" onclick="showClassMenu(1);">快餐类</a>
			<a href="javascript:void(0);" onclick="showClassMenu(2);">正餐类</a>
			<a href="javascript:void(0);" onclick="showClassMenu(3);">小吃零食</a>
			<a href="javascript:void(0);" onclick="showClassMenu(4);">甜品饮品</a>
			<a href="javascript:void(0);" onclick="showClassMenu(5);">果蔬生鲜</a>
			<a href="javascript:void(0);" onclick="showClassMenu(6);">鲜花蛋糕</a>
			<a href="javascript:void(0);" onclick="showClassMenu(7);">超市便利店</a>
			<div class="mid-all-class">
				<div class="mid-all">
					<a href="" id="mid-all-class-specific">全部快餐类</a>
					<a href="">盖浇饭</a>
					<a href="">品牌快餐</a>
					<a href="">中式炒菜</a>
					<a href="">米粉面馆</a>
					<a href="">汉堡</a>
					<a href="">麻辣烫</a>
					<a href="">饺子馄饨</a>
					<a href="">烧烤</a>
					<a href="">披萨意面</a>
					<a href="">香锅</a>
					<a href="">包子粥店</a>
					<a href="">生煎锅贴</a>
				</div>

				<div class="mid-all">
					<a href="" id="mid-all-class-specific">全部正餐类</a>
					<a href="">川湘菜</a>
					<a href="">日韩料理</a>
					<a href="">西餐</a>
					<a href="">江浙菜</a>
					<a href="">火锅</a>
					<a href="">东北菜</a>
					<a href="">西北菜</a>
					<a href="">海鲜</a>
					<a href="">粤菜</a>
					<a href="">云南菜</a>
					<a href="">鲁菜</a>
				</div>

				<div class="mid-all">
					<a href="" id="mid-all-class-specific">全部小吃零食</a>
					<a href="">地方小吃</a>
					<a href="">炸鸡炸串</a>
					<a href="">鸭脖卤味</a>
					<a href="">零食</a>
					<a href="">小龙虾</a>
					
				</div>

				<div class="mid-all">
					<a href="" id="mid-all-class-specific">全部甜品饮品</a>
					<a href="">饮品</a>
					<a href="">甜品</a>
					<a href="">点心</a>
					<a href="">咖啡</a>
				</div>

				<div class="mid-all">
					<a href="" id="mid-all-class-specific">全部果蔬生鲜</a>
					<a href="">水果</a>
					<a href="">蔬菜</a>
					<a href="">生鲜</a>
				</div>

				<div class="mid-all">
					<a href="" id="mid-all-class-specific">全部鲜花蛋糕</a>
					<a href="">鲜花</a>
					<a href="">蛋糕</a>
					<a href="">面包</a>
				</div>
				
				<div class="mid-all">
					<a href="" id="mid-all-class-specific">全部超市便利店</a>
					<a href="">便利店</a>
					<a href="">超市</a>
					<a href="">水站</a>
				</div>
			</div><!-- mid-all-class end -->
		</div><!-- main-mid-class end -->

		<div class="main-mid-sort commnWidth">
			<ul>
				<li class="auto-sort sort-btn"><a href="">默认排序</a></li>
				<li class="sort-btn"><a href="" >销量高</a></li>
				<li class="sort-btn"><a href="" >评价好</a></li>
				<li id="other-sort-btn" class="sort-btn"><a href=""  >其他排序
					<span class="icon-chevron-down"></span>
					<span class="icon-chevron-up"></span>
					</a>
					<ul class="other-sort">
						<li><a href="" >距离最近</a></li>
						<li><a href="" >配送速度</a></li>
						<li><a href="" >起送金额</a></li>
					</ul>
				</li>
				<li id="other-sort-btn"  class="sort-btn">
					<a href="">起送价格: 不限 
						<span class="icon-chevron-down"></span>
						<span class="icon-chevron-up"></span>
						
					</a>
					<ul class="other-sort pay-sort">
						<li><a href="" class="linked">不限</a></li>
						<li><a href="" >15元以下</a></li>
						<li><a href="" >20元以下</a></li>
						<li><a href="" >30元以下</a></li>
						<li><a href="" >40元以下</a></li>
					</ul><!-- other-sort end -->

				</li>
			</ul>
					
		</div><!-- main-mid-sort end -->

		<div class="main-fix-sort commnWidth">
			<ul>
				<li class="auto-sort sort-btn"><a href="">默认排序</a></li>
				<li class="sort-btn"><a href="" >销量高</a></li>
				<li class="sort-btn"><a href="" >评价好</a></li>
				<li id="other-sort-btn" class="sort-btn"><a href=""  >其他排序
					<span class="icon-chevron-down"></span>
					<span class="icon-chevron-up"></span>
					</a>
					<ul class="other-sort">
						<li><a href="" >距离最近</a></li>
						<li><a href="" >配送速度</a></li>
						<li><a href="" >起送金额</a></li>
					</ul>
						
				</li>
				<li id="other-sort-btn"  class="sort-btn">
					<a href="">起送价格: 不限 
						<span class="icon-chevron-down"></span>
						<span class="icon-chevron-up"></span>
						
					</a>
					<ul class="other-sort pay-sort">
						<li><a href="" class="linked">不限</a></li>
						<li><a href="" >15元以下</a></li>
						<li><a href="" >20元以下</a></li>
						<li><a href="" >30元以下</a></li>
						<li><a href="" >40元以下</a></li>
					</ul><!-- other-sort end -->

				</li>
			</ul>
						
			<div class="top-bar-search fr">
				<input type="text" class="mid-bar-searchText " placeholder="搜索商家，美食...">
				<a href="" class="top-bar-searchBtn"><span class="icon-search"></span></a>
			</div><!-- top-bar-search end-->

		</div><!-- main-mid-sort end -->

		<div class="main-content commnWidth">
			<div class="main-content-menu clearfix">
				<div class="menu-content-item">
					<a href="" class="menu-item clearfix">
						<div class="item-img">
							<img src="../../resources/BusiPic/item-1.jpg" alt="商家商标">
							<span id="item-img-time">10分钟</span>
						</div><!-- item-img end -->
						<div class="item-info">
							<div class="item-info-title">熙苑</div>
							<div class="item-info-star" id="item-info-star">
								<span id="top-star" class="top-star"></span>
								<span id="bottom-star" class="bottom-star"></span>
							</div>
							<span class="item-info-amounts">月售373单</span>
							<div class="item-info-sendm">10元起送 / 配送费1元</div>
							<div class="item-info-icons">
								<i class="icons-sale icons">折</i>
								<i class="icons-reduce icons">减</i>
								<i class="icons-payol icons">付</i>
							</div>
						</div><!-- item-info end -->
					</a><!-- menu-item end -->

					<div class="item-detail">
						<div class="item-detail-arrow"></div>
						<div class="item-detail-content">
							<div class="item-title">
								熙苑
							</div>
							<div class="item-icons-detail">
								<div class="sale-detail icons-detail">
									<i class="icons-sale icons">折</i>
									九折优惠<span>（微信下单专享）</span>
								</div>
								
								<div class="reduce-detail">
									<i class="icons-reduce icons">减</i>
									满10减2 惠<span>（微信下单专享）</span>
								</div>
								
								<div class="payol-detail">
									<i class="icons-payol icons">付</i>
									可用支付宝、微信、手机QQ进行在线支付
								</div>
								
							</div>
							<div class="item-sendm-detail clearfix">
								<ul>
									<li><span>10</span>元起送</li>
									<li>配送费<span>1</span>元</li>
									<li>平均<span>10</span>分钟抵达</li>
								</ul>
							</div>
							<div class="item-shop-article">
								商家输入信息
							</div>
						</div><!-- item-detail-content end -->
					</div><!-- item-detail end -->
				</div><!-- menu-content-item end -->

                <div class="menu-content-item">
                    <a href="" class="menu-item clearfix">
                        <div class="item-img">
                            <img src="../../resources/BusiPic/item-1.jpg" alt="商家商标">
                            <span id="item-img-time">16分钟</span>
                        </div><!-- item-img end -->
                        <div class="item-info">
                            <div class="item-info-title">意粉|扒饭</div>
                            <div class="item-info-star" id="item-info-star">
                                <span id="top-star" class="top-star"></span>
                                <span id="bottom-star" class="bottom-star"></span>
                            </div>
                            <span class="item-info-amounts">月售547单</span>
                            <div class="item-info-sendm">15元起送 / 配送费2元</div>
                            <div class="item-info-icons">
                                <i class="icons-sale icons">折</i>
                                <i class="icons-reduce icons">减</i>
                                <i class="icons-payol icons">付</i>
                            </div>
                        </div><!-- item-info end -->
                    </a><!-- menu-item end -->

                    <div class="item-detail">
                        <div class="item-detail-arrow"></div>
                        <div class="item-detail-content">
                            <div class="item-title">
                                意粉|扒饭
                            </div>
                            <div class="item-icons-detail">
                                <div class="sale-detail icons-detail">
                                    <i class="icons-sale icons">折</i>
                                    九折优惠<span>（微信下单专享）</span>
                                </div>
                                
                                <div class="reduce-detail">
                                    <i class="icons-reduce icons">减</i>
                                    满10减2 惠<span>（微信下单专享）</span>
                                </div>
                                
                                <div class="payol-detail">
                                    <i class="icons-payol icons">付</i>
                                    可用支付宝、微信、手机QQ进行在线支付
                                </div>
                                

                            </div>
                            <div class="item-sendm-detail clearfix">
                                <ul>
                                    <li><span>15</span>元起送</li>
                                    <li>配送费<span>2</span>元</li>
                                    <li>平均<span>16</span>分钟抵达</li>
                                </ul>
                            </div>
                            <div class="item-shop-article"></div> 
                        </div><!-- item-detail-content end -->
                    </div><!-- item-detail end -->
                </div><!-- menu-content-item end -->
            </div><!-- main-content-menu end -->
        </div><!-- main-content end -->
	</div><!-- main end -->

	<footer>
		<div class="footer-container clearfix commnWidth">
			<div class="footer-items">
				<h3>用户帮助</h3>
				<ul>
					<li><a href="">服务中心</a></li>
					<li><a href="">常见问题</a></li>
				</ul>
			</div><!-- footer-items end -->

			<div class="footer-items">
				<h3>商务合作</h3>
				<ul>
					<li><a href="">我要开店</a></li>
					<li><a href="">加盟指南</a></li>
					<li><a href="">市场合作</a></li>
				</ul>
			</div><!-- footer-items end -->

			<div class="footer-items">
				<h3>关于我们</h3>
				<ul>
					<li><a href="">介绍</a></li>
					<li><a href="">加入我们</a></li>
					<li><a href="">联系我们</a></li>
					<li><a href="">服务协议</a></li>
				</ul>
			</div><!-- footer-items end -->

			<div class="footer-contact">
				<div class="contact-items">意见反馈 : <a href="">metaloe@outlook.com</a></div>
				<div class="contact-items">关注我们 : <span class="icon-wechat" id="icon-wechat"></span><span class="icon-renren"></span><span class="icon-sina-weibo"></span></div>
				<div class="wechat-items-multi" id="wechat-items-multi">
					<div class="wechat-items-arrow"></div>
					<div class="wechat-items">
						<img src="../../resources/pagePics/wechat.png" alt="二维码">
						<span>微信号</span>
					</div>
				</div>
			</div><!-- footer-contact end -->

			<div class="copyright">
			<footer>
				© 2018, Metaloe.
			</footer>
			</div><!-- footer-copyright end -->
		</div><!-- footer-container end -->
	</footer><!-- footer end -->

    <script type="text/javascript" src="../../js/adBar.js"></script>
    <script type="text/javascript" src="../../js/userPage.js"></script>
</body>
</html>
