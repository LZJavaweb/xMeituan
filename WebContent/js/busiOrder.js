function toLoad(){
    var curPage = r.GetQueryString(curPage);
    var data = {"curPage":curPage};
    $.ajax({
        url:"../MIndex/?",
        type:"post",
        data:curPage,
        contentType:"application/x-www-form-urlencoded; charset=UTF-8",
        datatype:"json",
        success: getCurPage,
        error: function() {
            alert("bug");
        }
    });
    var total,pageSize,totalPage;
}
function getCurPage(data){
    
}
function GetQueryString(name)
{
     var reg = new RegExp("(^|&)"+ name +"=([^&]*)(&|$)");
     var r = window.location.search.substr(1).match(reg);
     if(r!=null) 
        return unescape(r[2]); 
     return null;
}
function getPageBar(page){
    var data = {"pagaNum" : page - 1};
    $.ajax({
        url:"../MIndex/?",
        type:"post",
        data: data,
        contentType:"application/x-www-form-urlencoded; charset=UTF-8",
        datatype:"json",
        success:function(data){
            for (i in data){
                var total = data[i].total; //总记录数
                var pageSize = data[i].pageSize; //每页显示条数
                var curPage = page; //当前页
                var totalPage = data[i].totalPage; //总页数
            }
            $("#pageBar").find('*').remove();
            str="";
            if(curPage != 1) {
                str="<li class=\"page-item\"><a class=\"page-link\" href="+"\""+"..\\html\\MIndex.html?curPage="+curPage-1+"\""+">Previous</a></li>";
                $("#pageBar").append(str);
            }else{
                str="<li class=\"page-item\"><a class=\"page-link\" href="+"\""+curPage+"\""+">Previous</a></li>";
            }
            
            
            for(i=0;i<)
            $('.theme_body').append(string);     
        },
        complete:function(){ //生成分页条
            getPageBar();
        },
        error:function(){
            alert("数据加载失败");
        }
    });
}
