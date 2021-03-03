<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<tiles:insertTemplate template="/jsp/layout/mainLayout.jsp" flush="true">
    <%@ include file="/jsp/base/pageBase.jsp" %>
    <%-- 画面的标题 --%>
    <tiles:putAttribute name="pageTitle" value="新增编辑Banner图片"/>

        <%-- 画面主面板 --%>
    <tiles:putAttribute name="mainContentinner" type="string">
        <div class="wrapper wrapper-content animated fadeInRight">
            <div class="row">
                <div class="col-sm-12 ">
                    <div class="ibox float-e-margins m0 mt10 mb10">
                        <div class="ibox-content aaa"  style="width: 100%;">
							  	<div class="form-group">
							  		<div class="col-sm-12 markmodeloption" >
			                        	<div class="ibox float-e-margins">
				                            <div class="ibox-title">
				                              <!--   <h5>基础数据</h5> -->
				                            </div>
				                            <div class="ibox-content" >
				                             <form method="post" class="form-horizontal registerform" id="mainForm">
				                               	  <div class="form-group">
				                                    <label class="col-sm-2 control-label"><span class="need">*</span>企业介绍(中文)</label>
				                                    <div class="col-sm-8">
				                                        <script id="introduce" name="introduce" type="text/plain" ></script>
				                                        <div class="Validform_checktip">输入企业介绍！</div>
				                                    </div>
				                                </div>
				                                <div class="form-group">
				                                    <label class="col-sm-2 control-label"><span class="need">*</span>企业介绍(英文)</label>
				                                    <div class="col-sm-8">
				                                        <script id="introduceEng" name="introduceEng" type="text/plain" ></script>
				                                        <div class="Validform_checktip">输入企业介绍！</div>
				                                    </div>
				                                </div>
				                               </form>
				                               <div align="center">
				                     <shiro:hasPermission name="introduce:SAVE">
						            <button type="button"  class="btn btn-add btn-lg btn-info fn-modify" style="margin-bottom: 15px; width:106px; margin-right:20px;" title="保存" data-id="" onclick="Events.saveAction()">
						                <i class="fa fa-modify" aria-hidden="true">保存</i>
						            </button>
						            </shiro:hasPermission>
						            </div>
				                               <br/> <br/> <br/>
				                               
				                               <%-- <form method="post" class="form-horizontal registerform" id="mainFormSco">
				                               <input type="hidden" id="configVisitJson" name="configVisitJson" value=''/>

				                               <c:choose>
				                               <c:when test="${not empty websiteScopeList}">
				                                <c:forEach items="${websiteScopeList}" var="scope" begin="0" step="1" varStatus="status">
				                                  <div  class="table table-bordered1 titleModel">
				                                 <label class="col-sm-2 control-label">企业发展规模</label>
				                               <div class="col-sm-9" style="border:1px #000000   solid;">
				                                <input type="hidden"  class="idClass" value = "<c:out value="${scope.id}"></c:out>">
				                               <label class="col-sm-4 control-label"><span class="need">*</span>年份</label>
				                               <input type="text" id="year" class="form-control form-filter yearpicker yearClass"
				                                ajaxurl="ajaxCheckAction?id=<c:out value="${scope.id}"></c:out>" maxlength="22" placeholder="" showAllError="false"
                                                   nullmsg="请输入年份"  errormsg="请输入正确年份"
                                                   dataType="*" value="<c:out value="${scope.year}"/>" style="width:30%;"/>
				                               <br/><label class="col-sm-4 control-label"><span class="need">*</span>分公司数量</label>
				                               <input type="text" onkeyup="(this.v=function(){this.value=this.value.replace(/[^0-9-]+/,'');}).call(this)" onblur="this.v();"
				                              							   class="form-control val-userName fgsCountClass"
						                                                    maxlength="22"
						                                                     placeholder="" showAllError="false"
                                                   nullmsg="请输入分公司数量"  errormsg="请输入正确分公司数量"
                                                   dataType="*"
						                                                   value="<c:out value="${scope.fgsCount}"/>" style="width:30%;" />
				                               <br/><label class="col-sm-4 control-label"><span class="need">*</span>客户数量</label>
				                               <input type="text" onkeyup="(this.v=function(){this.value=this.value.replace(/[^0-9-]+/,'');}).call(this)" onblur="this.v();"
				                              							   class="form-control val-userName khCountClass"
						                                                   maxlength="22"
						                                                    placeholder="" showAllError="false"
                                                   nullmsg="请输入客户数量"  errormsg="请输入正确客户数量"
                                                   dataType="*"
						                                                   value="<c:out value="${scope.khCount}"/>" style="width:30%;" />
				                               <br/><label class="col-sm-4 control-label"><span class="need">*</span>人员数量</label>
				                               <input type="text" onkeyup="(this.v=function(){this.value=this.value.replace(/[^0-9-]+/,'');}).call(this)" onblur="this.v();"
				                              							   class="form-control val-userName ryCountClass"
						                                                    maxlength="22"
						                                                     placeholder="" showAllError="false"
                                                   nullmsg="请输入人员数量"  errormsg="请输入正确人员数量"
                                                   dataType="*"
						                                                   value="<c:out value="${scope.ryCount}"/>" style="width:30%;" />
				                               <input type='button' style="float:right" class='qualityPercentBt' onclick="Events.removeButtonAction(this);" value='删除'/>
				                               <input type='button' style="float:right" class='qualityPercentBt' onclick="Events.addButtonAction(this);" value='增加'/>
				                               <br/><br/><br/><br/></div>
				                           
				                                </div>
				                                </c:forEach>	
				                                </c:when>
				                                <c:otherwise>
				                                <div  class="table table-bordered1 titleModel">
				                                <label class="col-sm-2 control-label">企业发展规模</label>
				                               <div class="col-sm-9" style="border:1px #000000   solid;">
				                                <input type="hidden"  class="idClass" value = "<c:out value="${scope.id}"></c:out>">
				                               <label class="col-sm-4 control-label"><span class="need">*</span>年份</label>
				                               <input type="text" class="form-control form-filter yearpicker yearClass"
						                                                    maxlength="22"
						                                                     placeholder="" showAllError="false"
                                                   nullmsg="请输入年份"  errormsg="请输入正确年份"
                                                   dataType="*"
						                                                   value="<c:out value="${scope.year}"/>" style="width:30%;" placeholder="" />
				                               <br/><label class="col-sm-4 control-label"><span class="need">*</span>分公司数量</label>
				                               <input type="text" onkeyup="(this.v=function(){this.value=this.value.replace(/[^0-9-]+/,'');}).call(this)" onblur="this.v();"
				                              							   class="form-control val-userName fgsCountClass"
						                                                    maxlength="22"
						                                                     placeholder="" showAllError="false"
                                                   nullmsg="请输入分公司数量"  errormsg="请输入正确分公司数量"
                                                   dataType="*"
						                                                   value="<c:out value="${scope.fgsCount}"/>" style="width:30%;" />
				                               <br/><label class="col-sm-4 control-label"><span class="need">*</span>客户数量</label>
				                               <input type="text" onkeyup="(this.v=function(){this.value=this.value.replace(/[^0-9-]+/,'');}).call(this)" onblur="this.v();"
				                              							   class="form-control val-userName khCountClass"
						                                                   maxlength="22"
						                                                    placeholder="" showAllError="false"
                                                   nullmsg="请输入客户数量"  errormsg="请输入正确客户数量"
                                                   dataType="*"
						                                                   value="<c:out value="${scope.khCount}"/>" style="width:30%;" />
				                               <br/><label class="col-sm-4 control-label"><span class="need">*</span>人员数量</label>
				                               <input type="text" onkeyup="(this.v=function(){this.value=this.value.replace(/[^0-9-]+/,'');}).call(this)" onblur="this.v();"
				                              							   class="form-control val-userName ryCountClass"
						                                                    maxlength="22"
						                                                     placeholder="" showAllError="false"
                                                   nullmsg="请输入人员数量"  errormsg="请输入正确人员数量"
                                                   dataType="*"
						                                                   value="<c:out value="${scope.ryCount}"/>" style="width:30%;" />
				                               <input type='button' style="float:right" class='qualityPercentBt' onclick="Events.removeButtonAction(this);" value='删除'/>
				                               <input type='button' style="float:right" class='qualityPercentBt' onclick="Events.addButtonAction(this);" value='增加'/>
				                               <br/><br/><br/><br/></div></div>
				                                
				                                </c:otherwise>
				                                </c:choose>
				                                </form> --%>
											</div>
				                        </div>
							  		</div>
							  	</div>
							  	 <%-- <div class="row" style="text-align: center; position:fixed;  width:100%; left:21px; height:42px; bottom:0; background:#ffffff;">
						            <shiro:hasPermission name="introduce:SAVE_DEV">
						            <button type="button" class="btn btn-add btn-lg btn-info fn-modify" style="margin-bottom: 15px; width:106px; margin-right:20px;" title="保存" data-id="" onclick="Events.saveScoAction()">
						                <i class="fa fa-modify" aria-hidden="true">保存</i>
						            </button>
						            </shiro:hasPermission>
						        </div> --%>
                        </div>
                    </div>
                   						 <%-- <div  class="table table-bordered1 cloneModel" style='display:none'>
				                                 <label class="col-sm-2 control-label">企业发展规模</label>
				                               <div class="col-sm-9" style="border:1px #000000   solid;">
				                                <input type="hidden"  class="idClass" value = "<c:out value=""></c:out>">
				                               <label class="col-sm-4 control-label"><span class="need">*</span>年份</label>
				                               <input type="text" class="form-control form-filter yearpicker yearClass"
						                                                    maxlength="22"
						                                                     placeholder="" showAllError="false"
                                                   nullmsg="请输入年份"  errormsg="请输入正确年份"
                                                   dataType="*"
						                                                    style="width:30%;" placeholder="" />
				                               <br/><label class="col-sm-4 control-label"><span class="need">*</span>分公司数量</label>
				                               <input type="text" onkeyup="(this.v=function(){this.value=this.value.replace(/[^0-9-]+/,'');}).call(this)" onblur="this.v();"
				                              							   class="form-control val-userName fgsCountClass"
						                                                    maxlength="22" placeholder="" showAllError="false"
                                                   nullmsg="请输入分公司数量"  errormsg="请输入正确分公司数量"
                                                   dataType="*"
						                                                   value="<c:out value=""/>" style="width:30%;" />
				                               <br/><label class="col-sm-4 control-label"><span class="need">*</span>客户数量</label>
				                               <input type="text" onkeyup="(this.v=function(){this.value=this.value.replace(/[^0-9-]+/,'');}).call(this)" onblur="this.v();"
				                              							   class="form-control val-userName khCountClass"
						                                                   maxlength="22" placeholder="" showAllError="false"
                                                   nullmsg="请输入客户数量"  errormsg="请输入正确客户数量"
                                                   dataType="*"
						                                                   value="<c:out value=""/>" style="width:30%;" />
				                               <br/><label class="col-sm-4 control-label"><span class="need">*</span>人员数量</label>
				                               <input type="text" onkeyup="(this.v=function(){this.value=this.value.replace(/[^0-9-]+/,'');}).call(this)" onblur="this.v();"
				                              							   class="form-control val-userName ryCountClass"
						                                                    maxlength="22" placeholder="" showAllError="false"
                                                   nullmsg="请输入人员数量"  errormsg="请输入正确人员数量"
                                                   dataType="*"
						                                                   value="<c:out value=""/>" style="width:30%;" />
				                               <input type='button' style="float:right" class='qualityPercentBt' onclick="Events.removeButtonAction(this);" value='删除'/>
				                               <input type='button' style="float:right" class='qualityPercentBt' onclick="Events.addButtonAction(this);" value='增加'/>
				                               <br/><br/><br/><br/></div>
				                                </div> --%>
                </div>
                
            </div>
        </div>
       
        
        
    </tiles:putAttribute>

    <%-- 画面的CSS (ignore) --%>
    <tiles:putAttribute name="pageCss" type="string">
    	<link href="${webRoot}/css/plugins/iCheck/skins/square/red.css" rel="stylesheet">	
    	<link href="${webRoot}/js/plugins/laydate/theme/laydate.css" rel="stylesheet">	
    	<link href="${webRoot}/css/plugins/webuploader/webuploader.css" rel="stylesheet">
    	<link href="${webRoot}/js/plugins/validform/css/style.css" rel="stylesheet">
    	
        <style>
        </style>
    </tiles:putAttribute>

    <%-- JS全局变量定义、插件 (ignore) --%>
    <tiles:putAttribute name="pageGlobalImport" type="string">
    </tiles:putAttribute>

    <%-- Javascripts required for this page only (ignore) --%>
    <tiles:putAttribute name="pageJavaScript" type="string">
        <script type='text/javascript' src="${webRoot}/js/plugins/webuploader/webuploader.js"></script>
        <script type='text/javascript' src="${webRoot}/js/plugins/iCheck/icheck.min.js"></script>
        <script type='text/javascript' src="${webRoot}/js/plugins/validform/js/Validform_v5.3.2.js"></script>
        <!-- 配置文件 -->
        <script type="text/javascript" src="${webRoot}/js/plugins/ueditor/ueditor.config.js"></script>
        <!-- 编辑器源码文件 -->
        <script type="text/javascript" src="${webRoot}/js/plugins/ueditor/ueditor.all.js"></script>
         <script type="text/javascript" src="${webRoot}/js/plugins/laydate/laydate.js"></script>
        <!-- 实例化编辑器 -->
       <script type="text/javascript">
            var introduceEng = UE.getEditor('introduceEng',{wordCount:false,maximumWords:50000});
            var introduce = UE.getEditor('introduce',{wordCount:false,maximumWords:50000});
        </script>
        <script type="text/javascript">
        introduceEng.ready(function(){
        	introduceEng.setContent('${role.introduceEng}');//这里的{{$content}}是我的框架前端页面调用后端数据的方法，根据个人情况不同进行调整
            });
        introduce.ready(function(){
        	introduce.setContent('${role.introduce}');//这里的{{$content}}是我的框架前端页面调用后端数据的方法，根据个人情况不同进行调整
            });
        
        </script>
        <jsp:include page="introduce.js.jsp"/>
    </tiles:putAttribute>

</tiles:insertTemplate>
