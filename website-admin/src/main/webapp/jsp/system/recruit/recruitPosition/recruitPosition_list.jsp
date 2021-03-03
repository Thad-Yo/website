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
                                    <label class="control-label">招聘岗位</label>
                                    <div class="input-group" style="width: 200px;">
                                        <input type="text" class="form-control" id="recruitPosition" name="recruitPosition" value="" placeholder="">
                                    </div>
                                </div>
                                <div class="pl10 pb10 form-group">
                                    <label class="control-label">状态</label>
                                    <div class="input-group" style="width: 200px;">
                                        <select id="status" name="status" class="form-control">
                                            <option value="">全部</option>
                                            <option value="y">已发布</option>
                                            <option value="n">未发布</option>
                                        </select>
                                    </div>
                                </div>
                                
                                <div class="pl10 pb10 form-group">
                                    <label class="control-label">办公城市</label>
                                    <div class="input-group" style="width: 200px;" overflow:auto>
                                        <input type="text" id="recruitDepartment" name="recruitDepartment" class="input form-control">
                                        <input type="hidden" name="departmentId" id="department_id" />
                                        <div id="menuTreeDepartment" class="menuDepartment"></div>
                                    </div>
                                </div>
                                
                                <div class="pl10 pb10 form-group">
                                    <label class="control-label">招聘类型</label>
                                    <div class="input-group" style="width: 200px;">
                                        <select id="recruitType" name="recruitType" class="form-control">
                                            <option value="">全部</option>
                                            <option value="1">校园招聘</option>
                                            <option value="2">社会招聘</option>
                                        </select>
                                    </div>
                                </div>
                                <div class="pl10 pb10 pull-right">
                                    <shiro:hasPermission name="recruitPosition:VIEW">
                                        <button type="button" class="btn btn-danger btn-sm fn-search">
                                        	<i class="fa fa-search" aria-hidden="true"></i>&nbsp;查询
                                        </button>
                                    </shiro:hasPermission>
                                    <shiro:hasPermission name="recruitPosition:NEW">
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
								<th data-align="center" data-width="50px" data-field="number"
									data-formatter="Common.indexFormat">序号</th>
								<th data-align="center" data-width="150px"
									data-field="recruitPosition" data-sortable="false">招聘岗位</th>
								<th data-align="center" data-width="150px"
									data-field="recruitCityName" data-sortable="false">办公城市</th>
								<th data-align="center" data-width="80px"
									data-field="recruitType" data-sortable="false" data-formatter="ActionEvents.recruitTypeFormatter">招聘类型</th>
								<th data-align="center" data-width="150px"
									data-field="positionTypeName" data-sortable="false">岗位类别</th>
								<th data-align="center" data-width="80px" data-field="status"
									data-sortable="false" data-formatter="ActionEvents.statusFormatter">状态</th>
								<th data-align="center" data-width="150px"
									data-field="updateTime" data-formatter="Common.dateFormatYMDHMS">操作时间</th>
								<th data-align="center" data-width="80px"
									data-field="updateUser">操作人</th>
								<th data-align="center" data-width="200px" data-field="action"
									data-formatter="ActionEvents.actionFormatter" data-events="ActionEvents">操作</th>
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
        <jsp:include page="recruitPosition_list.js.jsp"/>
    </tiles:putAttribute>

</tiles:insertTemplate>


