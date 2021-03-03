<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/jsp/base/pageBase.jsp" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<tiles:insertTemplate template="/jsp/layout/mainLayout.jsp" flush="true">
    <%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
    <%-- 画面的标题 --%>
    <tiles:putAttribute name="pageTitle" value="招聘岗位"/>

    <%-- 画面主面板 --%>
    <tiles:putAttribute name="mainContentinner" type="string">
        <div class="wrapper wrapper-content animated fadeInRight">
            <div class="row">
                <div class="col-sm-12">
                    <div class="ibox m0 mt10">
                    	<!-- 搜索条件 -->
                        <div class="ibox-title">
                            <h5>搜索条件</h5> <span class="label label-primary">search</span>
                            <div class="ibox-tools">
                                <a class="collapse-link ui-sortable">
                                    <i class="fa fa-chevron-down"></i>
                                </a>
                            </div>
                        </div>
                        
                        <div class="ibox-content mb10 search-panel">
                            <form id="searchForm" class="form-inline m0 search-content">
                                <div class="pl10 pb10 form-group">
                                    <label class="control-label">类型名称</label>
                                    <div class="input-group" style="width: 200px;">
                                        <input type="text" class="form-control" id="cultureTypeName" name="cultureTypeName" value="" placeholder="">
                                    </div>
                                </div>
                                <div class="pl10 pb10 pull-right">
                                    <shiro:hasPermission name="stafftype:VIEW">
                                        <button type="button" class="btn btn-danger btn-sm fn-search">
                                        	<i class="fa fa-search" aria-hidden="true"></i>&nbsp;查询
                                        </button>
                                    </shiro:hasPermission>
                                    <shiro:hasPermission name="stafftype:ADD">
                                        <button type="button" class="btn btn-info btn-sm fn-add">
                                        	<i class="fa fa-plus" aria-hidden="true"></i>&nbsp;添加
                                        </button>
                                    </shiro:hasPermission>
                                    <button type="button" class="btn btn-warning btn-sm fn-reset">
										<i class="fa fa-refresh" aria-hidden="true"></i>&nbsp;重置
									</button>
                                </div>
                            </form>
                        </div>
					</div>

					<table id="listTable" data-height="505"
						data-mobile-responsive="true"
						style="width: 100%; table-layout: fixed; word-break: break-all; word-wrap: break-word;"
						data-sort-name="creat_date" data-height="100%"
						data-sort-order="desc">
						<thead>
							<tr>
								<th data-align="center" data-width="50px" data-field="number" data-formatter="Common.indexFormat">序号</th>
								<th data-align="center" data-width="150px" data-field="cultureTypeName" data-sortable="false">类型名称</th>
								<th data-align="center" data-width="150px" data-field="cultureTypeEnName" data-sortable="false">类型英文名称</th>
								<th data-align="center" data-width="300px" data-field="notes" data-sortable="false" >类型描述</th>
								<th data-align="center" data-width="150px" data-field="updateTime" data-formatter="Common.dateFormatYMDHMS">操作时间</th>
								<th data-align="center" data-width="80px" data-field="updateUser">操作人</th>
								<th data-align="center" data-width="200px" data-field="action" data-formatter="ActionEvents.actionFormatter" data-events="ActionEvents">操作</th>
							</tr>
						</thead>
					</table>

				</div>
            </div>
            <input type="hidden" id="delFlag" name="delFlag" value=""/>
        </div>
        <!-- End Panel Other -->
    </tiles:putAttribute>

    <%-- 画面的CSS (ignore) --%>
    <tiles:putAttribute name="pageCss" type="string">
        <link href="${webRoot}/js/plugins/select2/select2.css" rel="stylesheet">
        <link href="${webRoot}/js/plugins/select2/select2-lianxin.css" rel="stylesheet">
        <link href="${webRoot}/css/plugins/jsTree/style.min.css" rel="stylesheet">
        <style>
        	.table{white-space:nowrap;}
        	.table tr td{height: 36px;max-width: 230px;overflow: hidden;text-overflow: ellipsis;}
        	.table tr td:last-child{max-width: 500px;}
        	.positionStyle{max-width: 150px;}
        	.fixed-table-body{background-color: white;}
        
            .search-content {
                display: none;
            }
            #listTable{background:white;}
            #listTable .clip-check {
                margin-bottom: 0px!important;
                margin-top:0px!important;
                padding-left: 0;
            }
            #listTable	.checkbox{
                margin-bottom: 0px!important;
                margin-top:0px!important;
            }
            #menuTreeDepartment{
		        position: absolute;
			    background: white;
			    z-index: 666;
			    width: 200px;
			    top: 0;
			    max-height: 350px;
			    overflow-y: scroll;
			}
			
        </style>
    </tiles:putAttribute>

    <%-- JS全局变量定义、插件 (ignore) --%>
    <tiles:putAttribute name="pageGlobalImport" type="string">
    </tiles:putAttribute>

    <%-- Javascripts required for this page only (ignore) --%>
    <tiles:putAttribute name="pageJavaScript" type="string">
    	<script type='text/javascript' src="${webRoot}/js/plugins/select2/select2.js"></script>
        <script type='text/javascript' src="${webRoot}/js/plugins/layer/laydate/laydate.js"></script>
        <script type='text/javascript' src="${webRoot}/js/plugins/jsTree/jstree.min.js"></script>
        <script type='text/javascript' src="${webRoot}/js/plugins/clipboard/clipboard.js"></script>
        <script type='text/javascript' src="${webRoot}/js/common.js"></script>
        <jsp:include page="staff_type_list.js.jsp"/>
    </tiles:putAttribute>

</tiles:insertTemplate>


