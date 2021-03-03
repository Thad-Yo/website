<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/jsp/base/pageBase.jsp" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<tiles:insertDefinition name="lxView">
	<%-- 画面的标题 --%>
	<tiles:putAttribute name="pageTitle" value="招贤纳士"/>
	<%-- 画面主面板 --%>
	<tiles:putAttribute name="mainContentinner" type="string">
		<div class="recruit">
			<input id="recruitType" value="${recruitType }" hidden>
			<input id="positionType" value="" hidden>
			<input id="redisFlag" value="${redisFlag}" hidden>
			<div class="banner">
				<img src="${webRoot}/images/recruit/banner.jpg" width="100%">
			</div>
			<!--第一部分-->
			<div class="panel1">
				<div class="panel-title">
					<img src="${webRoot}/images/recruit/text3.png">
				</div>
				<div class="panel-text">招贤纳士</div>
				<p class="textCN">
					一个唯贤是用、回报丰厚、拥抱创新的环境，你喜欢吗？
				</p>
				<p class="textCN">世界那么大，大牛那么多，从优秀到卓越，你需要最好的同行者！</p>
				<p class="textEN">A team with the atmosphere of choosing the right talents, generous rewards and embracing innovation, wouldn't you like to join it?</p>
				<p class="textEN">It's a vast world full of talents. To be a better person, you gonna need the best fellow workers!</p>
			</div>
			<!--轮播图-->
			<div class="js-silder ws-slider">
				<div class="silder-scroll">
					<div class="silder-main">
						<c:forEach items="${attachmentRecord}" var="attachment" begin="0" step="1" varStatus="status">
							<div class="silder-main-img">
								<img src="${webRoot}${attachment.savePath}" alt="">
							</div>
						</c:forEach>
					</div>
				</div>
				<div class="js-silder-ctrl">
					<span class="silder-ctrl-prev spanBtn"><i class="iconfont icon-xiangzuo"></i></span>
					<span class="silder-ctrl-next spanBtn"><i class="iconfont icon-goRight"></i></span>
				</div>
			</div>
			<!--第二部分-->
			<div class="panel2">
				<div class="panel-top">
					<div class="panel-title">
						<img src="${webRoot}/images/recruit/text2.png">
					</div>
					<div class="panel-text">招聘类型</div>
					<div class="panel-type">
						<img src="${webRoot}/images/recruit/type.png"/>
						<div class="typeAll panel-type1 schoolRecruit">
							<div class="typeFlex">
								<img src="${webRoot}/images/recruit/panel2-con1.png" alt="" />
								<div class="typeFlexTop"></div>
							</div>
							<a class="textCN active" href="javascript:;" name="schoolRecruit">校园招聘</a>
							<a class="textEN" href="javascript:;" name="schoolRecruit">Campus Recruitment</a>
						</div>
						<div class="typeAll panel-type2 socialRecruit">
							<div class="typeFlex">
								<img src="${webRoot}/images/recruit/panel2-con2.png" alt="" />
								<div class="typeFlexTop"></div>
							</div>
							<a class="textCN" href="javascript:;" name="socialRecruit">社会招聘</a>
							<a class="textEN" href="javascript:;" name="socialRecruit">Society Recruitment</a>
						</div>
						<div class="typeAll panel-type3">
							<div class="typeFlex">
								<img src="${webRoot}/images/recruit/panel2-con3.png" alt="" />
								<div class="typeFlexTop"></div>
							</div>
							<a href="javascript:;" class="typePeople" name="typePeople">
								<span class="textCN">储备人才库</span>
								<span class="textEN">Talents Reserve</span>
								<div class="typeCircle"></div>
								<div class="typeCircle"></div>
								<div class="typeDown"><i class="iconfont icon-jiantou-down"></i></div>
							</a>
						</div>
						<div class="typeLeft">
							<img src="${webRoot}/images/recruit/typeLeft.png"/>
						</div>
						<div class="typeRight">
							<img src="${webRoot}/images/recruit/typeRight.png"/>
						</div>
					</div>
				</div>
				<div class="allContent">
					<div class="tabBox">
						<div class="menuBox">
							<div class="tabMenu o">
								<ul class="f">
									<li class="selectLi" value="">
										<span>全部</span>
										<div class="zhuangshi">
											<div class="line"></div>
											<div class="circle"></div>
										</div>
									</li>
									<c:forEach items="${configPosition}" var="position" begin="0" step="1" varStatus="status">
										<li class="" value="${position.id}">${position.positionName}
											<div class="zhuangshi hide">
												<div class="line"></div>
												<div class="circle"></div>
											</div>
										</li>
									</c:forEach>
								</ul>
							</div>
							<div class="tabContent">
								<div class="tabTitle">
									<div id="location">
										<select id="recruitCityName" name="recruitCityName" class="">
											<option value="">请选择城市</option>
											<c:forEach items="${cityList}" var="city" begin="0" step="1" varStatus="status">
												<option value="${city.recruitCityName}">${city.recruitCityName}</option>
											</c:forEach>
										</select>
									</div>
									<div id="rankName">
										<select id="recruitPosition" name="" class="">
											<option value="">请选择职位</option>
											<c:forEach items="${recruitPositionList}" var="position" begin="0" step="1" varStatus="status">
												<option value="${position.id}">${position.recruitPosition}</option>
											</c:forEach>
										</select>
									</div>
								</div>
							</div>
							<div class="tabInfor">
								<div class="row tabInforTop">
									<div class="col-sm-3">岗位信息</div>
									<div class="col-sm-3">薪资</div>
									<div class="col-sm-4">办公城市</div>
									<div class="col-sm-2">详情</div>
								</div>
								<div id="tabInforCon">
									<c:forEach items="${recruitPosition}" var="recruitPo" step="1" begin="0" varStatus="position">
										<div class="row">
											<div class="col-sm-3">${recruitPo.recruitPosition}</div>
											<input hidden class="recruitCity" value="${recruitPo.recruitCity}">
											<div class="col-sm-3 money">${recruitPo.salary}</div>
											<div class="col-sm-4">${recruitPo.recruitCityName}</div>
											<div class="col-sm-2 iconfont icon-jiantou-down"></div>
										</div>
										<div class="tabInforConRequire">
											<div class="requireCon">
												<div class="requireConTop">
														${recruitPo.positionIntroduce}
												</div>
												<div class="requireConBtm">
													<div class="requireConBtn">
														<button id="deliverSubmit" type="button">
															<i class="iconfont icon-icon"></i>
															<span>投递</span>
														</button>
													</div>
												</div>
											</div>
										</div>
									</c:forEach>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
			<form action="/webapp/recruit.jsp" method="get" id="form">
				<input hidden id="webResumeBasic" name="webResumeBasic">
				<input hidden id="webResumeEducationList" name="webResumeEducationList">
				<input hidden id="webResumeWorkList" name="webResumeWorkList">
				<input hidden id="webResumeProjectList" name="webResumeProjectList">
				<input hidden id="webResumeLanguageList" name="webResumeLanguageList">
				<input hidden id="webResumeDutyList" name="webResumeDutyList">
				<input hidden id="webResumeHonorList" name="webResumeHonorList">

				<div class="jianlitoudi" id="jianlitoudi">
					<div class="jltd-content">
						<div class="jltd-close">
							<i class="iconfont icon-guanbi"></i>
						</div>
						<div class="jltd-title">简历投递</div>
						<input id="jltd-recruitType" value="" hidden>
						<div class="jltd-line">
							<img src="${webRoot}/images/recruit/jltd.png"/>
						</div>
						<div class="jltd-top">
							<ul>
								<li>
									投递类型：<span></span>
								</li>
								<li>
									办公城市：<span></span>
									<select id="city">

									</select>
								</li>
								<li>
									投递岗位：<span></span>
									<select id="tdgw">

									</select>
								</li>
							</ul>
						</div>
						<div class="jltd-middle">
							<div class="jltd-midTop">
								<div class="row">
									<label class="col-sm-2"><span>*</span>姓名</label>
									<div class="col-sm-4">
										<input type="text" id="nameCn" placeholder="" />
									</div>
									<label class="col-sm-2"><span>*</span>手机号</label>
									<div class="col-sm-4">
										<input type="text" id="phoneMobile" placeholder="" />
									</div>
								</div>
								<div class="row">
									<label class="col-sm-2">性别</label>
									<div class="col-sm-4">
										<select id="gender">
											<option value="1">男</option>
											<option value="2">女</option>
										</select>
									</div>
									<label class="col-sm-2">婚姻状况</label>
									<div class="col-sm-4">
										<select id="marriage">
											<option value="2">未婚</option>
											<option value="1">已婚</option>
											<option value="3">离异</option>
										</select>
									</div>
								</div>
								<div class="row">
									<label class="col-sm-2">Email</label>
									<div class="col-sm-4">
										<input type="text" id="emailPerson" placeholder="" />
									</div>
								</div>
								<div class="row">
									<label class="col-sm-2">现住址</label>
									<div class="col-sm-9">
										<div id="addressDetail" style="">
											<select name="province" class="prov" onmousedown="if(this.options.length>6){this.size=10}" onblur="this.size=0" onchange="this.size=0"></select>
											<select name="city" class="city" onmousedown="if(this.options.length>6){this.size=10}" onblur="this.size=0" onchange="this.size=0"></select>
											<select name="district" class="dist" onmousedown="if(this.options.length>6){this.size=10}" onblur="this.size=0" onchange="this.size=0"></select>
										</div>
									</div>
								</div>
								<div class="row">
									<label class="col-sm-2">照片</label>
									<div class="col-sm-4" style="position: relative;">
										<input type="file" id="photoPath" placeholder="" />
										<input id="photoSavePath" value="" hidden>
										<button type="button" class="fileBtn" onclick="uploadPhoto();"><i class="iconfont icon-tupian"></i>上传照片</button>
										<p class="errorPic">*请上传jpg/jpeg/png格式的照片！</p>
									</div>
									<div class="col-sm-4">
										<ul id="report"></ul>
									</div>
								</div>
							</div>
							<div class="allLine jyjl">
								<div class="allTitle">教育经历</div>
								<div class="jyjlCon">
									<div class="jyjlModal">
										<div class="row">
											<label class="col-sm-2">起止日期</label>
											<div class="col-sm-4">
												<input type="" class="rowJyjlTime" placeholder="选择起止日期" />
											</div>
											<label class="col-sm-2">院校名称</label>
											<div class="col-sm-4">
												<input type="text" class="school" placeholder="" />
											</div>
											<div class="remove"><i class="iconfont icon-shanchu"></i></div>
										</div>
										<div class="row">
											<label class="col-sm-2">专业</label>
											<div class="col-sm-4">
												<input type="text" class="rowMajor" placeholder="" />
											</div>
											<label class="col-sm-2">学历</label>
											<div class="col-sm-4">
												<select class="degreeName">
													<option value="">请选择</option>
													<option value="大专">大专</option>
													<option value="本科">本科</option>
													<option value="本科以上">本科以上</option>
												</select>
											</div>
										</div>
									</div>
								</div>
								<div class="jyjlBtn">
									<div class="row">
										<label class="col-sm-2"></label>
										<div class="col-sm-4">
											<button type="button" class="" id="jyjlBtn"><i class="iconfont icon-new"></i>添加教育经历</button>
										</div>
									</div>
								</div>
							</div>
							<div class="allLine gzjl">
								<div class="allTitle">工作经历</div>
								<div class="gzjlCon">
									<div class="gzjlModal">
										<div class="row">
											<label class="col-sm-2">起止日期</label>
											<div class="col-sm-4">
												<input type="" class="rowGzjlTime" placeholder="选择起止日期" />
											</div>
											<label class="col-sm-2">工作单位</label>
											<div class="col-sm-4">
												<input type="text" class="company" placeholder="" />
											</div>
											<div class="remove"><i class="iconfont icon-shanchu"></i></div>
										</div>
										<div class="row">
											<label class="col-sm-2">职务</label>
											<div class="col-sm-4">
												<input type="text" class="job" placeholder="" />
											</div>
										</div>
									</div>
								</div>
								<div class="gzjlBtn">
									<div class="row">
										<label class="col-sm-2"></label>
										<div class="col-sm-4">
											<button type="button" class="" id="gzjlBtn"><i class="iconfont icon-new"></i>添加工作经历</button>
										</div>
									</div>
								</div>
							</div>
							<div class="allLine xmName">
								<div class="allTitle">培训/项目名称</div>
								<div class="xmNameCon">
									<div class="xmNameModal">
										<div class="row">
											<label class="col-sm-2">起止日期</label>
											<div class="col-sm-4">
												<input type="" class="rowXmNameTime" placeholder="选择起止日期" />
											</div>
											<label class="col-sm-2 onlyName">培训/项目名称</label>
											<div class="col-sm-4">
												<input type="text" class="projectName" placeholder="" />
											</div>
											<div class="remove"><i class="iconfont icon-shanchu"></i></div>
										</div>
										<div class="row">
											<label class="col-sm-2">描述</label>
											<div class="col-sm-10">
												<textarea class="projectRemark" rows="" cols=""></textarea>
											</div>
										</div>
									</div>
								</div>
								<div class="xmNameBtn">
									<div class="row">
										<label class="col-sm-2"></label>
										<div class="col-sm-4">
											<button type="button" class="" id="xmNameBtn"><i class="iconfont icon-new"></i>添加培训/项目经历</button>
										</div>
									</div>
								</div>
							</div>
							<div class="allLine xnry">
								<div class="allTitle">校内荣誉</div>
								<div class="xnryCon">
									<div class="xnryModal">
										<div class="row">
											<label class="col-sm-2">起止日期</label>
											<div class="col-sm-4">
												<input type="" class="rowXnryTime" placeholder="选择起止日期" />
											</div>
											<label class="col-sm-2">荣誉名称</label>
											<div class="col-sm-4">
												<input type="text" class="honorName" placeholder="" />
											</div>
											<div class="remove"><i class="iconfont icon-shanchu"></i></div>
										</div>
									</div>
								</div>
								<div class="xnryBtn">
									<div class="row">
										<label class="col-sm-2"></label>
										<div class="col-sm-4">
											<button type="button" class="" id="xnryBtn"><i class="iconfont icon-new"></i>添加校内荣誉</button>
										</div>
									</div>
								</div>
							</div>
							<div class="allLine xnzw">
								<div class="allTitle">校内职务</div>
								<div class="xnzwCon">
									<div class="xnzwModal">
										<div class="row">
											<label class="col-sm-2">起止日期</label>
											<div class="col-sm-4">
												<input type="" class="rowXnzwTime" placeholder="选择起止日期" />
											</div>
											<label class="col-sm-2">职务名称</label>
											<div class="col-sm-4">
												<input type="text" class="dutyName" placeholder="" />
											</div>
											<div class="remove"><i class="iconfont icon-shanchu"></i></div>
										</div>
										<div class="row">
											<label class="col-sm-2">描述</label>
											<div class="col-sm-10">
												<textarea class="dutyDescription" rows="" cols=""></textarea>
											</div>
										</div>
									</div>
								</div>
								<div class="xnzwBtn">
									<div class="row">
										<label class="col-sm-2"></label>
										<div class="col-sm-4">
											<button type="button" class="" id="xnzwBtn"><i class="iconfont icon-new"></i>添加校内职务</button>
										</div>
									</div>
								</div>
							</div>
							<div class="allLine yydj">
								<div class="allTitle">语言能力</div>
								<div class="row">
									<label class="col-sm-2">语种</label>
									<div class="col-sm-4">
										<input type="text" class="languageName" placeholder="" />
									</div>
									<label class="col-sm-2">读写能力</label>
									<div class="col-sm-4">
										<select id="readAbli">
											<option value="">请选择</option>
											<option value="听说能力 精通">精通</option>
											<option value="听说能力 熟练">熟练</option>
											<option value="听说能力 良好">良好</option>
											<option value="听说能力 一般">一般</option>
										</select>
									</div>
								</div>
								<div class="row">
									<label class="col-sm-2">听说能力</label>
									<div class="col-sm-4">
										<select id="hearAbli">
											<option value="">请选择</option>
											<option value="听说能力 精通">精通</option>
											<option value="听说能力 熟练">熟练</option>
											<option value="听说能力 良好">良好</option>
											<option value="听说能力 一般">一般</option>
										</select>
									</div>
								</div>
							</div>
							<div class="allLine zwpj">
								<div class="row">
									<label class="col-sm-2">自我评价</label>
									<div class="col-sm-4" style="position: relative;">
										<input id="selfEvaluation" placeholder="" />
									</div>
									<label class="col-sm-2">期望薪资</label>
									<div class="col-sm-4" style="position: relative;">
										<input id="expectSalary" placeholder="" />
									</div>
								</div>
							</div>
							<div class="allLine file">
								<div class="row">
									<label class="col-sm-2">附件简历</label>
									<div class="col-sm-4" style="position: relative;">
										<input type="file" id="attachmentPath" placeholder="" />
										<input id="attachmentSavePath" value="" hidden>
										<input id="attachmentFileName" value="" hidden>
										<button type="button" class="fileBtn" onclick="uploadFile();"><i class="iconfont icon-unie123"></i>上传文件</button>
										<p class="errorWJ">*上传成功！</p>
									</div>
									<label class="col-sm-2">验证码</label>
									<div class="col-sm-4" style="positon:relative;">
										<input type="text" id="rowYZM" placeholder=""/>
										<div class="imgYZM" id="v_container"></div>
										<p class="error">*验证码错误！</p>
									</div>
								</div>
							</div>
							<div class="jltd-bottom">
								<button type="button" id="jltdBtn">确认投递</button>
								<p class="jltd-alt">*请输入正确的姓名/手机号/验证码</p>
								<p class="jltd-altPeople">*请输入正确的姓名/手机号/验证码/办公城市/投递岗位</p>
							</div>
						</div>
					</div>
					<div class="jltd-success">
						<div class="success-con">
							<div class="success-close">
								<i class="iconfont icon-guanbi"></i>
							</div>
							<div class="success-icon">
								<i class="iconfont icon-success"></i>
							</div>
							<div class="success-title">
								提交成功
							</div>
						</div>
					</div>
				</div>
			</form>
		</div>
		<!--教育经历 模板-->
		<div class="jyjlModal" style="display: none;">
			<div class="row">
				<label class="col-sm-2">起止日期</label>
				<div class="col-sm-4">
					<input type="" class="rowJyjlTime" placeholder="选择起止日期" />
				</div>
				<label class="col-sm-2">院校名称</label>
				<div class="col-sm-4">
					<input type="text" class="school" placeholder="" />
				</div>
				<div class="remove"><i class="iconfont icon-shanchu"></i></div>
			</div>
			<div class="row">
				<label class="col-sm-2">专业</label>
				<div class="col-sm-4">
					<input type="text" class="rowMajor" placeholder="" />
				</div>
				<label class="col-sm-2">学历</label>
				<div class="col-sm-4">
					<select class="degreeName">
						<option value="0">大专</option>
						<option value="1">本科</option>
						<option value="2">本科以上</option>
					</select>
				</div>
			</div>
		</div>
		<!--工作经历 模板-->
		<div class="gzjlModal" style="display: none;">
			<div class="row">
				<label class="col-sm-2">起止日期</label>
				<div class="col-sm-4">
					<input type="" class="rowGzjlTime" placeholder="选择起止日期" />
				</div>
				<label class="col-sm-2">工作单位</label>
				<div class="col-sm-4">
					<input type="text" class="company" placeholder="" />
				</div>
				<div class="remove"><i class="iconfont icon-shanchu"></i></div>
			</div>
			<div class="row">
				<label class="col-sm-2">职务</label>
				<div class="col-sm-4">
					<input type="text" class="job" placeholder="" />
				</div>
			</div>
		</div>
		<!--培训/项目经历 模板-->
		<div class="xmNameModal" style="display: none;">
			<div class="row">
				<label class="col-sm-2">起止日期</label>
				<div class="col-sm-4">
					<input type="" class="rowXmNameTime" placeholder="选择起止日期" />
				</div>
				<label class="col-sm-2 onlyName">培训/项目名称</label>
				<div class="col-sm-4">
					<input type="text" class="projectName" placeholder="" />
				</div>
				<div class="remove"><i class="iconfont icon-shanchu"></i></div>
			</div>
			<div class="row">
				<label class="col-sm-2">描述</label>
				<div class="col-sm-10">
					<textarea class="projectRemark" rows="" cols=""></textarea>
				</div>
			</div>
		</div>
		<!--校内荣誉 模板-->
		<div class="xnryModal" style="display: none;">
			<div class="row">
				<label class="col-sm-2">起止日期</label>
				<div class="col-sm-4">
					<input type="" class="rowXnryTime" placeholder="选择起止日期" />
				</div>
				<label class="col-sm-2">荣誉名称</label>
				<div class="col-sm-4">
					<input type="text" class="honorName" placeholder="" />
				</div>
				<div class="remove"><i class="iconfont icon-shanchu"></i></div>
			</div>
		</div>
		<!--校内职务 模板-->
		<div class="xnzwModal" style="display: none;">
			<div class="row">
				<label class="col-sm-2">起止日期</label>
				<div class="col-sm-4">
					<input type="" class="rowXnzwTime" placeholder="选择起止日期" />
				</div>
				<label class="col-sm-2">职务名称</label>
				<div class="col-sm-4">
					<input type="text" class="dutyName" placeholder="" />
				</div>
				<div class="remove"><i class="iconfont icon-shanchu"></i></div>
			</div>
			<div class="row">
				<label class="col-sm-2">描述</label>
				<div class="col-sm-10">
					<textarea class="dutyDescription" rows="" cols=""></textarea>
				</div>
			</div>
		</div>
	</tiles:putAttribute>
	<%-- 画面的CSS (ignore) --%>
	<tiles:putAttribute name="pageCss" type="string">
		<link rel="stylesheet" href="${webRoot}/css/recruit.min.css" />
		<link rel="stylesheet" href="http://cache.amap.com/lbs/static/main.css?v=1.0?v=1.0" />
		<link rel="stylesheet" href="${webRoot}/js/plugins/wow/animate1.css" />
		<link rel="stylesheet" type="text/css" href="${webRoot}/js/plugins/bootstrap/css/bootstrap.min.css"/>
		<link rel="stylesheet" type="text/css" href="${webRoot}/js/plugins/laydate/theme/laydate.css"/>
		<style type="text/css">
		</style>
	</tiles:putAttribute>
	<tiles:putAttribute name="pageJavaScript" type="string">
		<script type="text/javascript" src="${webRoot}/js/plugins/laydate/laydate.js"></script>
		<script type="text/javascript" src="${webRoot}/js/mobileFix.mini.js"></script>
		<script type="text/javascript" src="${webRoot}/js/exif.min.js"></script>
		<script type="text/javascript" src="${webRoot}/js/lrz.js"></script>
		<script type="text/javascript" src="${webRoot}/js/gVerify.js"></script>
		<script type="text/javascript" src="${webRoot}/js/DD_belatedPNG.min.js"></script>
		<script type="text/javascript" src="${webRoot}/js/index-lb.min.js"></script>
		<script type="text/javascript" src="${webRoot}/js/distpicker.data.min.js"></script>
		<script type="text/javascript" src="${webRoot}/js/distpicker.min.js"></script>
		<script type="text/javascript" src="${webRoot}/js/recruit.js"></script>
		<script type="text/javascript">
			new WySlider(document.querySelectorAll(".ws-slider"),{auto: true,time: 3000});
			window.onload = function(){
				$('#addressDetail').distpicker();
			}
		</script>
	</tiles:putAttribute>
</tiles:insertDefinition>
