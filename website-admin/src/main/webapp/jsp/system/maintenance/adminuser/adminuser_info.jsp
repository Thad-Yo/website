<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/jsp/base/pageBase.jsp" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<tiles:insertTemplate template="/jsp/layout/mainLayout.jsp" flush="true">
    <%-- 画面的标题 --%>
    <tiles:putAttribute name="pageTitle" value="用户管理"/>

    <%-- 画面主面板 --%>
    <tiles:putAttribute name="mainContentinner" type="string">
        <div class="wrapper wrapper-content animated fadeInRight">
            <div class="row">
                <div class="col-sm-12">
                    <div class="ibox float-e-margins m0 mt10 mb10">
                        <div class="ibox-content">
                            <form method="post" class="form-horizontal registerform" id="mainForm">
                                <input type="hidden" id="userId" name="userId" value='<c:out value="${record.userId}"></c:out>'/>
                                <input type="hidden" name="departmentCd" value=''/>

                                <div class="row">
                                    <div class="col-sm-6">
                                        <div class="form-group">
                                            <label class="col-sm-2 control-label"><span class="need">*</span>用户名</label>

                                            <div class="col-sm-9">
                                                <input type="text" class="form-control" name="userName" maxlength="50"
                                                       ajaxurl="ajaxCheckAction?id=<c:out value="${record.userId}"></c:out>"
                                                       <c:if test="${not empty record.userId}">readonly</c:if>
                                                       datatype="username"
                                                       errormsg="由3-20位的字母下划线和数字组成,不能以数字或下划线开头。"
                                                       value='<c:out value="${record.userName}"></c:out>'/>

                                                <div class="Validform_checktip">由3-50位的字母下划线和数字组成,不能以数字或下划线开头。</div>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="col-sm-2 control-label"><span
                                                    class="need">*</span>真实姓名</label>

                                            <div class="col-sm-9">
                                                <input type="text" class="form-control" name="realName" maxlength="20"
                                                       datatype="*"
                                                       errormsg="请输入真实姓名。"
                                                       value='<c:out value="${record.realName}"></c:out>'/>

                                                <div class="Validform_checktip">请输入真实姓名。</div>
                                            </div>
                                        </div>
                                        <%--<c:if test="${empty record.userId}">--%>
                                            <%--<div class="form-group">--%>
                                                <%--<label class="col-sm-2 control-label"><span--%>
                                                        <%--class="need">*</span>新密码</label>--%>

                                                <%--<div class="col-sm-9">--%>
                                                    <%--<input type="password" class="form-control" id="password"--%>
                                                           <%--name="password"--%>
                                                           <%--maxlength="50"--%>
                                                           <%--datatype="pwd"--%>
                                                           <%--errormsg="密码长度为6-16，由字母下划线和数字组成。"/>--%>

                                                    <%--<div class="Validform_checktip">密码长度为6-16，由字母下划线和数字组成。</div>--%>
                                                <%--</div>--%>
                                            <%--</div>--%>
                                            <%--<div class="form-group">--%>
                                                <%--<label class="col-sm-2 control-label"><span--%>
                                                        <%--class="need">*</span>确认密码</label>--%>

                                                <%--<div class="col-sm-9">--%>
                                                    <%--<input type="password" class="form-control" id="confirmPassword"--%>
                                                           <%--name="confirmPassword" maxlength="50"--%>
                                                           <%--datatype="*" recheck="password" nullmsg="请再输入一次密码！"--%>
                                                           <%--errormsg="您两次输入的密码不一致。"/>--%>

                                                    <%--<div class="Validform_checktip">请再输入一次密码。</div>--%>
                                                <%--</div>--%>
                                            <%--</div>--%>
                                        <%--</c:if>--%>
                                        <div class="form-group">
                                            <label class="col-sm-2 control-label">性别</label>

                                            <div class="col-sm-9">
                                                <div class="radio clip-radio radio-primary ">
                                                    <input type="radio" id="sexOn" name="sex" value="1" ${record.sex eq '1' ? 'checked' : ''}> 
                                                    <label for="sexOn">男 </label>
                                                    <input type="radio" id="sexOff" name="sex" value="0" ${record.sex eq '0' ? 'checked' : ''}>
                                                    <label for="sexOff">女 </label>
                                                </div>
                                                <div class="Validform_checktip">请选择性别。</div>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="col-sm-2 control-label"><span class="need">*</span>手机号</label>

                                            <div class="col-sm-9">
                                                <input type="text" class="form-control" name="mobileNumber"
                                                       maxlength="11"
                                                       datatype="n11-11"
                                                       <%-- ajaxurl="ajaxCheckAction?id=<c:out value="${record.userId}"></c:out>" --%>
                                                       errormsg="请输入正确的手机号。"
                                                       value='<c:out value="${record.mobileNumber}"></c:out>'/>

                                                <div class="Validform_checktip">请输入正确的手机号。</div>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="col-sm-2 control-label">固话</label>

                                            <div class="col-sm-9">
                                                <input type="text" class="form-control" name="extensionNumber" ignore="ignore"
                                                       maxlength="15"
                                                       datatype="tel"
                                                       errormsg="请输入固话（区号-座机号码-分机号码）。"
                                                       value='<c:out value="${record.extensionNumber}"></c:out>'/>

                                                <div class="Validform_checktip">请输入固话（区号-座机号码-分机号码）。</div>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="col-sm-2 control-label">邮箱</label>

                                            <div class="col-sm-9">
                                                <input type="text" class="form-control" name="emailAddress"
                                                       maxlength="150"
                                                       datatype="/^(\w+([-+.']\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*){0,1}$/"
                                                       <%-- ajaxurl="ajaxCheckAction?id=<c:out value="${record.userId}"></c:out>" --%>
                                                       errormsg="请输入正确的邮箱。"
                                                       value='<c:out value="${record.emailAddress}"></c:out>'/>

                                                <div class="Validform_checktip">请输入正确的邮箱。</div>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="col-sm-6">
                                        <div class="form-group">
                                            <label class="col-sm-2 control-label"><span
                                                    class="need">*</span>用户角色</label>

                                            <div class="col-sm-9">
                                                <select id="roleId" name="roleId" class="form-control required" datatype="*" errormsg="请选择用户角色！" nulmsg="请选择用户角色！">
                                                    <option value=""></option>
                                                    <c:if test="${!empty listRole}">
                                                        <c:forEach items="${listRole }" var="role" begin="0" step="1" varStatus="status">
                                                            <c:choose>
                                                                <c:when test="${record.roleId == role.roleId }">
                                                                    <option value="${role.roleId }" data-role="${role.role }" selected="selected">${role.roleName }</option>
                                                                </c:when>
                                                                <c:when test="${record.roleId != role.roleId }">
                                                                    <option value="${role.roleId }" data-role="${role.role }">${role.roleName }</option>
                                                                </c:when>
                                                                <c:otherwise>
                                                                </c:otherwise>
                                                            </c:choose>
                                                        </c:forEach>
                                                    </c:if>
                                                </select>
                                                <div class="Validform_checktip">请选择用户角色。</div>
                                            </div>
                                        </div>
                                        <div id="departmentDiv">
                                        	<%-- 当用户没有关联部门信息时 --%>
                                            <c:if test="${empty userDepartmentModelList}">
	                                            <div class="form-group">
	                                                <div class="form-inline">
	                                                    <label class="col-sm-2 control-label">部门</label>
	                                                    <div class="col-sm-9">
	                                                        <select name="departmentTopCd" class="form-control" style="width: 150px;">
									                            <option value="">请选择</option>
									                            <c:if test="${not empty branchDepartmentList}">
									                                <c:forEach items="${branchDepartmentList}" var="branchDepartment" begin="0" step="1" varStatus="status">
									                                    <option value="${branchDepartment.departmentCd}" >
									                                    	${branchDepartment.departmentName}
									                                 	</option>
									                                </c:forEach>
									                            </c:if>
									                        </select>
									                        <input type="hidden" name="departmentCd" value="">
									                        <button type="button" title="添加" class="btn btn-warning btn-xs fn-addRow">加</button>
	                                                    </div>
	                                                </div>
	                                            </div>
                                            </c:if>
                                            <%-- 当用户关联部门信息时 --%>
                                            <c:if test="${not empty userDepartmentModelList}">
                                            	<!-- 遍历部门队列列表 -->
	                                            <c:forEach items="${userDepartmentModelList}" var="userDepartmentModelList" begin="0" step="1" varStatus="status">
	                                                <c:if test="${status.index == 0}">
	                                                    <div class="form-group">
	                                                        <div class="form-inline">
	                                                            <label class="col-sm-2 control-label">部门</label>
	                                                            <div class="col-sm-9">
	                                                            	<!-- 遍历部门队列 -->
		                                                        	<c:forEach items="${userDepartmentModelList}" var="userDepartmentModel" begin="0" step="1" varStatus="userDepartmentModelStatus">
		                                                        		<c:if test="${userDepartmentModelStatus.index eq 0}">
			                                                        		<select name="departmentTopCd" style="width: 150px;" class="form-control">
			                                                                    <option value="">请选择</option>
			                                                                    <c:if test="${not empty branchDepartmentList}">
			                                                                        <c:forEach items="${branchDepartmentList}" var="branchDepartment" begin="0" step="1" varStatus="status">
			                                                                            <option value="${branchDepartment.departmentCd}"
			                                                                            	<c:if test="${branchDepartment.departmentCd eq userDepartmentModel.departmentCd}">selected</c:if> >
			                                                                            	${branchDepartment.departmentName}
			                                                                         	</option>
			                                                                        </c:forEach>
			                                                                    </c:if>
			                                                                </select>
		                                                        		</c:if>  
																		<c:if test="${userDepartmentModelStatus.index gt 0}">
																			<select name="departmentPCd" class="form-control" style="width: 150px; cursor:pointer;" readonly="readonly" title="点击可以修改下拉值">
		                                                                        <option value="${userDepartmentModel.departmentCd}">
	                                                                            	${userDepartmentModel.departmentName}
	                                                                         	</option>
		                                                                	</select>
																		</c:if>
																		<!-- 部门的ID隐藏域 -->
		                                                                <c:if test="${userDepartmentModelStatus.last}">
		                                                        			<input type="hidden" name="listDepartmentCd" value="${userDepartmentModel.departmentCd}">
		                                                        		</c:if> 
		                                                            </c:forEach>
	                                                                <button type="button" title="添加" class="btn btn-warning btn-xs fn-addRow">加</button>
	                                                            </div>
	                                                        </div>
	                                                    </div>
	                                                </c:if>
	                                                <c:if test="${status.index > 0}">
	                                                    <div class="form-group">
	                                                        <div class="form-inline">
	                                                            <label class="col-sm-2 control-label"></label>
	                                                            <div class="col-sm-9">
	                                                                <!-- 遍历部门队列 -->
		                                                        	<c:forEach items="${userDepartmentModelList}" var="userDepartmentModel" begin="0" step="1" varStatus="userDepartmentModelStatus">
		                                                        		<c:if test="${userDepartmentModelStatus.index eq 0}">
			                                                        		<select name="departmentTopCd" style="width: 150px;" class="form-control">
			                                                                    <option value="">请选择</option>
			                                                                    <c:if test="${not empty branchDepartmentList}">
			                                                                        <c:forEach items="${branchDepartmentList}" var="branchDepartment" begin="0" step="1" varStatus="status">
			                                                                            <option value="${branchDepartment.departmentCd}"
			                                                                            	<c:if test="${branchDepartment.departmentCd eq userDepartmentModel.departmentCd}">selected</c:if> >
			                                                                            	${branchDepartment.departmentName}
			                                                                         	</option>
			                                                                        </c:forEach>
			                                                                    </c:if>
			                                                                </select>
		                                                        		</c:if>  
																		<c:if test="${userDepartmentModelStatus.index gt 0}">
																			<select name="departmentPCd" class="form-control" style="width: 150px; cursor:pointer;" readonly="readonly" title="点击可以修改下拉值">
		                                                                        <option value="${userDepartmentModel.departmentCd}">
	                                                                            	${userDepartmentModel.departmentName}
	                                                                         	</option>
		                                                                	</select>
																		</c:if>
																		<!-- 部门的ID隐藏域 -->
		                                                                <c:if test="${userDepartmentModelStatus.last}">
		                                                        			<input type="hidden" name="listDepartmentCd" value="${userDepartmentModel.departmentCd}">
		                                                        		</c:if> 
		                                                            </c:forEach>
	                                                                <button type="button" title="添加" class="btn btn-warning btn-xs fn-addRow">加</button>
	                                                                <button type="button" title="删除" class="btn btn-danger btn-xs fn-removeRow">删</button>
	                                                            </div>
	                                                        </div>
	                                                    </div>
	                                                </c:if>
	                                            </c:forEach>
                                            </c:if>
                                        </div>
                                    </div>
                                    <div class="form-group mb10">
                                        <div class="col-sm-12 text-center">
                                            <button type="button" class="btn btn-add btn-lg btn-danger fn-Save" style="margin-bottom: 15px;" title="保存">
                                                <i class="fa fa-save" aria-hidden="true"> 保存</i>
                                            </button>
                                        </div>
                                    </div>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        
        <div id="rowTemplts2" type="text/x-tmpl" style="display:none">
            <div class="form-group">
                <div class="form-inline">
                    <label class="col-sm-2 control-label"></label>
                    <div class="col-sm-9">
                        <select name="departmentTopCd" class="form-control" style="width: 150px;">
                            <option value="">请选择</option>
                            <c:if test="${not empty branchDepartmentList}">
                                <c:forEach items="${branchDepartmentList}" var="branchDepartment" begin="0" step="1" varStatus="status">
                                    <option value="${branchDepartment.departmentCd}" >
                                    	${branchDepartment.departmentName}
                                 	</option>
                                </c:forEach>
                            </c:if>
                        </select>
                        <input type="hidden" name="listDepartmentCd" value="">
                        <button type="button" title="添加" class="btn btn-warning btn-xs fn-addRow">加</button>
                        <button type="button" title="删除" class="btn btn-danger btn-xs fn-removeRow">删</button>
                    </div>
                </div>
            </div>
        </div>
    </tiles:putAttribute>

    <%-- 画面的CSS (ignore) --%>
    <tiles:putAttribute name="pageCss" type="string">
    </tiles:putAttribute>

    <%-- JS全局变量定义、插件 (ignore) --%>
    <tiles:putAttribute name="pageGlobalImport" type="string">
        <link href="${webRoot}/css/plugins/jsTree/style.min.css" rel="stylesheet">
        <link href="${webRoot}/js/plugins/validform/css/style.css" rel="stylesheet">
    </tiles:putAttribute>

    <%-- Javascripts required for this page only (ignore) --%>
    <tiles:putAttribute name="pageJavaScript" type="string">
        <script type='text/javascript' src="${webRoot}/js/plugins/jsTree/jstree.min.js"></script>
        <script type='text/javascript' src="${webRoot}/js/plugins/validform/js/Validform_v5.3.2.js"></script>
        <script type='text/javascript' src="${webRoot}/js/plugins/layer/laydate/laydate.js"></script>
        <script type='text/javascript' src="${webRoot}/jsp/system/maintenance/adminuser/adminuser_info.js"></script>
    </tiles:putAttribute>

</tiles:insertTemplate>


