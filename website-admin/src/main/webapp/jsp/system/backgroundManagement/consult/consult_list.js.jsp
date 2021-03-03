<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<script>
    var layerIndex,
    /* 事件 */
            Events = {
                // 序号格式化
                indexFormat: function (value, row, index) {
                    return index + 1;
                },

                // 查询数据
                searchAction: function () {
                    //初始化table上面的工具组
                    Page.Table.bootstrapTable('refreshOptions', {pageNumber:1, pageSize:20});
                },
                //得到查询的参数
                tableParams: function (params) {
                    return params;
                },
                getHeight: function () {
                    return $(window).height() - 100;
                }
            },
            ActionEvents = {
            },
    /* 画面对象 */
            Page = {
                // 表格
                Table: $("#listTable"),

                // 初始化Validator
                initValidator: function () {

                },

                // 事件初期化
                initEvents: function () {
                    // 查询按钮按下事件
                    $(".fn-search").click(Events.searchAction);
                },

                // 画面初始化
                initialize: function () {
                    Page.Table.bootstrapTable({
                    	cache:false,
                        height: Events.getHeight(),
                        method: 'get', //这里要设置为get，不知道为什么 设置post获取不了
                        url: "searchAction.json",
                        dataType: "json",
                        search: false,
                        iconSize: 'outline',
                        sortable: true,
                        pagination: true,
                        pageSize: 20,
                        pageNumber: 1,
                        sidePagination: 'server',//设置为服务器端分页
                        queryParams: Events.tableParams, //参数
                        queryParamsType: 'limit',
                        //toolbar: '#TableEventsToolbar',  //将div exampleTableEventsToolbar的内容作为该table的工具栏
                        onSort: function (name, order) {
                            Page.Table.bootstrapTable('refreshOptions', {pageNumber:1, pageSize:20});
                        }
                    });

                    $(window).resize(function () {
                        Page.Table.bootstrapTable("resetView", {
                            height: TableCommon.getHeight()
                        });
                    });
                },

                init: function () {
                    Page.initialize();
                    Page.initEvents();
                    Page.initValidator();
                }
            };

    jQuery(document).ready(function () {
        Page.init();
    });
    document.onkeydown = function(event) {
    	if(event.keyCode == 13){ //$("#searchForm").hasClass("active") && 
    		// 执行的方法
    		$("#searchForm").attr("target", "");
    		//$("#paginator-page").val(1);
    		Events.searchAction();
    	}
    }
</script>