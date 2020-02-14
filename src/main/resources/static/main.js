layui.use(['layer', 'form','element','table'], function(){
    //无需再执行layui.use()方法加载模块，直接使用即可
    var form = layui.form
        ,layer = layui.layer
        ,element=layui.element
        ,table=layui.table;
    //…
});

function refresh() {
    document.getElementById('iframe').contentWindow.location.reload();
}