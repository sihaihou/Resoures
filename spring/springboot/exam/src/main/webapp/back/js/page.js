//当前页
var pageNum = 0;
// 每页有多少条数据
pageSize = 3;
// 共多少条数据
var total = 0;
// 共多少页
var pages = 0;
//搜索参数
var pageNo = 1;
function page(pageNum,pages,total) {
      var laypageindex = laypage({
        cont: 'page', //容器。值支持id名、原生dom对象，jquery对象。
        skip: true, //是否开启跳页
        skin: '#fb771f',
        pages: pages, //通过后台拿到的总页数
        count: total,
        curr: pageNum, //初始化当前页
        groups: 4,
        prev: '<', //若不显示，设置false即可
        next: '>', //若不显示，设置false即可
        first: '首页', //将首页显示为数字1,。若不显示，设置false即可
        last: '尾页', //将尾页显示为总页数。若不显示，设置false即可
        jump: function (obj, first) { //触发分页后的回调
          if (!first) { //点击跳页触发函数自身，并传递当前页：obj.curr
        	  searchPage(obj.curr);
          }
        }
      });
}