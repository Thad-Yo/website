$(function () {
	/*轮播图*/
	$('.spanBtn').hover(function(){
		$(this).css({
			'border':'1px solid #b90b2c',
			'background':'#b90b2c'
		});
		$(this).children('i').css({
			'color':'#fff'
		});
	},function(){
		$(this).css({
			'border':'1px solid #000',
			'background':'#fff'
		});
		$(this).children('i').css({
			'color':'#000'
		});
	});
	/*轮播图*/
	/*列表*/
    $(document).on("click","#tabInforCon .row",function(){
		if($(this).hasClass('active')){
			$(this).removeClass('active');
			$(this).children('div.iconfont').removeClass('rotate');
			$(this).next().slideUp(500);
		}
		else{
			$(this).addClass('active').siblings().removeClass('active');
			$(this).children('div.iconfont').addClass('rotate').removeClass('rotate1');
			$(this).siblings().children('div.iconfont').addClass('rotate1').removeClass('rotate');
			$('#tabInforCon').find('.tabInforConRequire').slideUp(500);
			$(this).next().slideDown(500);
		}	
	});
	/* tab 部分 */
    var minH = $('.tabMenu').height();
    $('.menuBox').css({
    	"minHeight":minH + 20
    })
	var menuli = $(".tabMenu ul>li");
    menuli.on('click',function() {
		//li添加点击时的样式
		$(this).addClass("selectLi").siblings().removeClass("selectLi");
		$(this).children(".zhuangshi").removeClass("hide");
		$(this).siblings().children(".zhuangshi").addClass("hide");
		var positionType = $(this).attr("value");
		$("#positionType").val(positionType);
        var recruitType = $("#recruitType").val();
        getProvinceRecord(positionType,recruitType);//获取城市列表
        getRecruitRecord(positionType,"",recruitType,"");
		
	});
	//左导航滚动事件
	/*var tabMenuTop = $(".tabMenu").offset().top;
	$(document).on("scroll",function(){
		var scrollTop = document.documentElement.scrollTop || document.body.scrollTop;;
		if(scrollTop > tabMenuTop){
			$(".tabMenu").css({
				"position":"fixed",
				"left":"20%",
				"top":"73px"
			})
		}
		else{
			$(".tabMenu").css({
				"position":"absolute",
				"left":"-230px",
				"top":0
			})
		}
	})*/
	/*招聘类型*/
	var zpObj = $('.typeAll a');
	zpObj.on('click',function(){
		$(this).addClass('active').parent('.typeAll').siblings().children('a').removeClass('active');
	})
	/*简历投递*/
	$(document).on('click','.requireConBtn button',function(){
		$('#city').hide();
		$('#tdgw').hide();
		$('.error').hide();
		$('.jltd-alt').hide();
		$('.jltd-altPeople').hide();
		$('.errorPic').hide();
    	$('.errorWJ').hide();
		var height1 = $('.recruit').height();
		var height2 = $('.footer').height();
		var activeObj = $('#tabInforCon').children('.active');
		var city = activeObj.children('div').eq(2).text();
		var infor = activeObj.children('div').eq(0).text();
		var zpType = $('#recruitType').val();
		var zpTypeText = '';
		if(zpType == 1){
			zpTypeText = '校园招聘';
		}
		else if(zpType == 2){
			zpTypeText = '社会招聘';
		}
		$('#jianlitoudi .jltd-top ul li').eq(0).children('span').text(zpTypeText);
		$('#jianlitoudi .jltd-top ul li').eq(1).children('span').text(city);
		$('#jianlitoudi .jltd-top ul li').eq(2).children('span').text(infor);
		$('.jianlitoudi').height(height1 + height2);
		$('.jianlitoudi').show();
		$(document).scrollTop(0);
	})
	var close = $('.jltd-close');
	close.on('click',function(){
		$('.jianlitoudi').hide();
		init();
	})
	/*教育经历*/
	var jyjlBtn = $('#jyjlBtn');
	var jyjlNum = 1;
	jyjlBtn.on('click',function(){
		var obj = $('body').children('.jyjlModal').clone(true);
		$('.jyjlCon').append(obj);
		$('.jyjlCon').find('.jyjlModal').show();
		$('.jyjlCon').find('.jyjlModal:last-child').find('.rowJyjlTime').attr('id','rowJyjlTime'+jyjlNum);
		laydate.render({
		    elem: '#rowJyjlTime'+jyjlNum
			,range: true
		});
		jyjlNum++;
	})
	/*工作经历*/
	var gzjlBtn = $('#gzjlBtn');
	var gzjlNum = 1;
	gzjlBtn.on('click',function(){
		var obj = $('body').children('.gzjlModal').clone(true);
		$('.gzjlCon').append(obj);
		$('.gzjlCon').find('.gzjlModal').show();
		$('.gzjlCon').find('.gzjlModal:last-child').find('.rowGzjlTime').attr('id','rowGzjlTime'+gzjlNum);
		laydate.render({
		    elem: '#rowGzjlTime'+gzjlNum
			,range: true
		});
		gzjlNum++;
	})
	/*培训/项目经历*/
	var xmNameBtn = $('#xmNameBtn');
	var xmNameNum = 1;
	xmNameBtn.on('click',function(){
		var obj = $('body').children('.xmNameModal').clone(true);
		$('.xmNameCon').append(obj);
		$('.xmNameCon').find('.xmNameModal').show();
		$('.xmNameCon').find('.xmNameModal:last-child').find('.rowXmNameTime').attr('id','rowXmNameTime'+xmNameNum);
		laydate.render({
		    elem: '#rowXmNameTime'+xmNameNum
			,range: true
		});
		xmNameNum++;
	})
	/*校内荣誉*/
	var xnryBtn = $('#xnryBtn');
	var xnryNum = 1;
	xnryBtn.on('click',function(){
		var obj = $('body').children('.xnryModal').clone(true);
		$('.xnryCon').append(obj);
		$('.xnryCon').find('.xnryModal').show();
		$('.xnryCon').find('.xnryModal:last-child').find('.rowXnryTime').attr('id','rowXnryTime'+xnryNum);
		laydate.render({
		    elem: '#rowXnryTime'+xnryNum
			,range: true
		});
		xnryNum++;
	})
	/*校内职务*/
	var xnzwBtn = $('#xnzwBtn');
	var xnzwNum = 1;
	xnzwBtn.on('click',function(){
		var obj = $('body').children('.xnzwModal').clone(true);
		$('.xnzwCon').append(obj);
		$('.xnzwCon').find('.xnzwModal').show();
		$('.xnzwCon').find('.xnzwModal:last-child').find('.rowXnzwTime').attr('id','rowXnzwTime'+xnzwNum);
		laydate.render({
		    elem: '#rowXnzwTime'+xnzwNum
			,range: true
		});
		xnzwNum++;
	})
	
	//删除经历
	$(document).on('click','.remove',function(){
		$(this).parent().parent().remove();
	})
	
	/*简历提交*/
	$(document).on('click','#jltdBtn',function(){
		var name = $('#nameCn').val();
		var phone = $('#phoneMobile').val();
		var str = /^((13[0-9])|(14[5,7])|(15[0-3,5-9])|(17[0,3,5-8])|(18[0-9])|166|198|199)\d{8}$/;
		var yzm = $('#rowYZM').val();
		var city = $('#city option:selected').attr('value');
		var tdgw = $('#tdgw option:selected').attr('value');
		var tdType =  $('.jianlitoudi .jltd-top ul li').eq(0).children('span').text();
		if(name != '' && str.test(phone) && yzm != '' && city != '' && tdgw != ''){
            //后台接口获取数据
            $('.jltd-alt').hide();
			$('.jltd-altPeople').hide();
            var activeObj = $('#tabInforCon').children('.active');
            var infor = activeObj.children('div').eq(0).text();
            var city = activeObj.children('div').eq(2).text();
            var recruitCity = activeObj.children('input').val();
            var hrResumeBasic = [];
            var nameCn = $("#nameCn").val();
            var phoneMobile = $("#phoneMobile").val();
            var gender = $("#gender").val();
            var marriage = $("#marriage").val();
            var emailPerson = $("#emailPerson").val();
            var addressDetail = $("#addressDetail .prov").val()+$("#addressDetail .city").val()+$("#addressDetail .dist").val();
            var photoPath = $("#photoSavePath").val();
            var selfEvaluation = $("#selfEvaluation").val();
            var expectSalary = $("#expectSalary").val();
            var attachmentPath = $("#attachmentSavePath").val();
            
            var recruitType = $('#jltd-recruitType').val();
            var resumeStatus;
            if(recruitType == 'typePeople'){
            	resumeStatus = '70';
            	city = $("#city").find("option:selected").text();
            	recruitCity = $("#city").find("option:selected").val();
            	infor = $("#tdgw").find("option:selected").text();
            }
            hrResumeBasic.push({
                "companyId":recruitCity,
                "expectWorkplace":city,
                "applyPosition": infor,
                "nameCn":nameCn,
                "phoneMobile": phoneMobile,
                "gender": gender,
                "marriage": marriage,
                "emailPerson": emailPerson,
                "addressDetail":addressDetail,
                "photoPath": photoPath,
                "selfEvaluation": selfEvaluation,
                "expectSalary": expectSalary,
                "attachmentPath": attachmentPath,
                "resumeStatus": resumeStatus,
                "getType": "3",
                "resumeChannelId": "14"
            });
            var hrResumeEducationList = JSON.stringify(getEducation());
            var hrResumeWorkList = JSON.stringify(getWork());
            var hrResumeProjectList = JSON.stringify(getProject());
            var hrResumeLanguageList = JSON.stringify(getLanguage());
            var hrResumeDutyList = JSON.stringify(getDuty());
            var hrResumeHonorList = JSON.stringify(getHonor());
            var webResumeBasic = JSON.stringify(hrResumeBasic);
            $("#webResumeBasic").val(webResumeBasic);
            $("#webResumeEducationList").val(hrResumeEducationList);
            $("#webResumeWorkList").val(hrResumeWorkList);
            $("#webResumeProjectList").val(hrResumeProjectList);
            $("#webResumeLanguageList").val(hrResumeLanguageList);
            $("#webResumeDutyList").val(hrResumeDutyList);
            $("#webResumeHonorList").val(hrResumeHonorList);

            $.post("postHrResumeAction.json", $("#form").serializeArray(), function (ret) {
                var result = ret.serviceResult;
                if (result.success) {
                    $('body').css('overflow','hidden');
                    $('.jltd-success').show();
                }else{
                	//alert("发送失败，请稍后再试");
                }
            });
		}
		else if(tdType == '校园招聘' || tdType == '社会招聘'){
			$('.jltd-alt').show();
		}
		else if(tdType == '储备人才库'){
			$('.jltd-altPeople').show();
		}
	});
	var _close = $('.success-close');
	_close.on('click',function(){
		$('.jltd-success').hide();
		$('.jianlitoudi').hide();
		$('body').css('overflow','auto');
		init();
	})
	
});
function init(){
	$('#form')[0].reset();
	$('#report').html('');
	$('.jyjlCon .jyjlModal').each(function(){
		if($(this).index() > 0){
			$(this).remove();
		}
	});
	$('.gzjlCon .gzjlModal').each(function(){
		if($(this).index() > 0){
			$(this).remove();
		}
	});
	$('.xmNameCon .xmNameModal').each(function(){
		if($(this).index() > 0){
			$(this).remove();
		}
	});
	$('.xnryCon .xnryModal').each(function(){
		if($(this).index() > 0){
			$(this).remove();
		}
	});
	$('.xnzwCon .xnzwModal').each(function(){
		if($(this).index() > 0){
			$(this).remove();
		}
	});
}
//日期范围
myLaydate();
function myLaydate(){
	laydate.render({
	    elem: '#jianlitoudi .rowJyjlTime'
		,range: true
	});
	laydate.render({
	    elem: '#jianlitoudi .rowGzjlTime'
		,range: true
	});
	laydate.render({
	    elem: '#jianlitoudi .rowXmNameTime'
		,range: true
	});
	laydate.render({
	    elem: '#jianlitoudi .rowXnryTime'
		,range: true
	});
	laydate.render({
	    elem: '#jianlitoudi .rowXnzwTime'
		,range: true
	});
}
//上传照片
var photoInput = document.querySelector('#photoPath');
photoInput.onchange = function () {
	var fileObj = this.files[0];
	var fileName = fileObj.name;
	var type = (fileName.substr(fileName.lastIndexOf("."))).toLowerCase();
	if(type!=".jpg"&&type!=".jpeg"&& type!=".png"){
		$('.errorPic').show();
		//alert("请上传jpg/jpeg/png格式的照片");
		return false;
	}
	var formFile = new FormData();
    formFile.append("file", fileObj); //加入文件对象
    var data = formFile;
    $.ajax({
        url: webRoot + '/system/recruit/uploadAction',
        data: data,
        type: "Post",
        dataType: "json",
        cache: false,//上传文件无需缓存
        processData: false,//用于对data参数进行序列化处理 这里必须false
        contentType: false, //必须
        success: function (ret) {
        	$("#photoSavePath").val(ret.result.savePath);
    		$('.errorPic').hide();
            //alert("上传完成!");
        },
    })
    lrz(this.files[0], {width: 400}, function (results) {
        var type = results.origin.type.split('/')[0];
        var report = document.querySelector('#report');
        report.innerHTML =  '';     
        if(type == 'image'){
        	demo_report('原始图片', results.blob, results.origin.size);
        }
    });
};
function demo_report(title, src, size) {
    var img = new Image(),
        li = document.createElement('li'),
        size = (size / 1024).toFixed(2) + 'KB';
    img.onload = function () {
        var content = '<ul>' +
            '<li>' + title + '(' + img.width + ' X ' + img.height + ')</li>' +
            '<li class="text-cyan">' + size + '</li>' +
            '</ul>';
        li.className = 'item';
        //li.innerHTML = content;
        li.appendChild(img);
        document.querySelector('#report').appendChild(li);
    };
    img.src = src;
}
function uploadPhoto(){
	return $('#photoPath').click();
}
//上传文件
function uploadFile(){
	return $('#attachmentPath').click();
}
var attachmentInput = document.querySelector('#attachmentPath');
attachmentInput.onchange = function () {
	var fileObj = this.files[0];
	var fileName = fileObj.name;
	var formFile = new FormData();
    formFile.append("file", fileObj); //加入文件对象
    var data = formFile;
    $.ajax({
        url: webRoot + '/system/recruit/uploadAction',
        data: data,
        type: "Post",
        dataType: "json",
        cache: false,//上传文件无需缓存
        processData: false,//用于对data参数进行序列化处理 这里必须false
        contentType: false, //必须
        success: function (ret) {
        	/*console.log(ret.result.fileName);*/
        	$("#attachmentSavePath").val(ret.result.savePath);
        	$("#attachmentFileName").val(ret.result.savePath);
        	$('.errorWJ').show();
            //alert("上传完成!");
        },
    })
};
//验证码
var verifyCode = new GVerify({
	id:"v_container",
	type:"number"
});
var inputObj = $('#rowYZM');
inputObj.on('keyup',function(){
	var val = $(this).val();
	if(val.length == 4){
		var res = verifyCode.validate(val);
		if(res){
			$('.error').hide();
		}else{
			$('.error').show();
			$(this).val('');
		}
	}
	else if(val.length > 4){
		$('.error').show();
		$(this).val('');
	}
});
inputObj.on('blur',function(){
	var val = $(this).val();
	if(val.length < 4){
		$('.error').show();
		$(this).val('');
	}
});
$(function(){
	//储备人才库
	$('.panel-type3 a').on('click',function(){
		$('.error').hide();
		$('.jltd-alt').hide();
		$('.jltd-altPeople').hide();
		$('.errorPic').hide();
    	$('.errorWJ').hide();
		var height1 = $('.recruit').height();
		var height2 = $('.footer').height();
		$('.jianlitoudi').height(height1 + height2);
		$('.jianlitoudi .jltd-top ul li').eq(0).children('span').text('储备人才库');
		$('.jianlitoudi .jltd-top ul li').eq(1).children('span').text('');
		$('.jianlitoudi .jltd-top ul li').eq(2).children('span').text('');
		$('.jianlitoudi').show();
		$(document).scrollTop(0);
		$('#city').css('display','inline-block');
		$('#jltd-recruitType').val('typePeople');
		$('#tdgw').css('display','inline-block');
		getProvinceRecord2("2");
		getRecruitRecord2();
	});
	
	var _recruitType = $('#recruitType').val();
	if(_recruitType == 1){
		$('.panel-type1').find('a.textCN').addClass('active');
		$('.panel-type2').find('a.textCN').removeClass('active');
	}
	else if(_recruitType == 2){
		$('.panel-type2').find('a.textCN').addClass('active');
		$('.panel-type1').find('a.textCN').removeClass('active');
	}
	//校园招聘
	$(".schoolRecruit").click(function(){
        $("#recruitType").val("1");
        var positionType =$("#positionType").val();
        getProvinceRecord(positionType,"1");//获取城市列表
        getRecruitRecord(positionType,"","1",'');
	});
	//社会招聘
    $(".socialRecruit").click(function(){
        $("#recruitType").val("2");
        var positionType =$("#positionType").val();
        getProvinceRecord(positionType,"2");//获取城市列表
        getRecruitRecord(positionType,"","2",'');//获取数据
    });
    //城市查询
    $("#recruitCityName").change(function(){
        var recruitType = $("#recruitType").val();
    	var recruitCityName = $("#recruitCityName").val();
        var positionType =$("#positionType").val();
        getRecruitRecord(positionType,recruitCityName,recruitType,'');
	});
    //职位查询
    $("#recruitPosition").change(function(){
        var recruitType = $("#recruitType").val();
        var recruitCityName = $("#recruitCityName").val();
        var id= $("#recruitPosition").val();
        var positionType =$("#positionType").val();
        getRecruitRecord(positionType,recruitCityName,recruitType,id);
    });
    /*$("#city").change(function(){
    	var recruitCityName = $("#city").find("option:selected").text();
        getRecruitRecord2(recruitCityName,'2');
	});*/

});
//获取后台招聘数据
function getRecruitRecord(positionType,recruitCityName,recruitType,id){
    //后台接口获取数据
    $.post("getRecordAction.json", {"positionType":positionType,"recruitCityName": recruitCityName,"recruitType": recruitType,"id": id}, function (ret) {
        var result = ret.serviceResult;	
        if (result.success) {
            $("#tabInforCon").empty();
            var html= '';
            var positionOption='<option value="">请选择职位</option>';
            var record = result.result;
            var arr = [];
            if(record.length>0){
                for(var i=0;i<record.length;i++){
                    //职位去重
                    if(id==''){
                        var addFlag = true;
                        for(var j=0;j<arr.length;j++){
                            if(arr[j].id==record[i].id){
                                addFlag = false;
                            }
                        }
                        arr.push(record[i]);
                        if(addFlag){
                            positionOption+='<option value="'+record[i].id+'">'+record[i].recruitPosition+'</option>';
                        }
                    }
                    html+='<div class="row"><div class="col-sm-3">'+record[i].recruitPosition+'</div><div class="col-sm-3 money">'+record[i].salary+'</div>'+
                        '<div class="col-sm-4">'+record[i].recruitCityName+'</div><input hidden class="recruitCity" value="'+record[i].recruitCity+'"><div class="col-sm-2 iconfont icon-jiantou-down"></div></div>'+
                        '<div class="tabInforConRequire"><div class="requireCon"><div class="requireConTop">'
                        +record[i].positionIntroduce+'</div>'+
                        '<div class="requireConBtm"><div class="requireConBtn"><button  type="button"><i class="iconfont icon-icon"></i><span>投递</span></button></div></div></div></div>'
                }
            }
            if(id==''){
                $("#recruitPosition").empty();
                $("#recruitPosition").append(positionOption);
            }

            $("#tabInforCon").append(html);
            $("#tabInforCon").show();
        }
    });
}
//获取后台招聘数据
function getRecruitRecord2(){
	//后台接口获取数据
	$.post("getPositionList.json", {}, function (ret) {
		/* console.log(JSON.stringify(ret))*/
        /*alert(json.stringify(ret))*/
		if (ret.success) {
			var positionOption='<option value="">请选择职位</option>';
			var record = ret.result;
			if(record.length>0){
				for(var i=0;i<record.length;i++){
					/*var id=record[i].matchingPositionIds.split(";");
					var name=record[i].matchingPosition.split(",");
					for(var j=0;j<name.length-1;j++){*/
					positionOption+='<option value="'+record[i].id+'">'+record[i].positionName+'</option>';
					
				}
			}
			$("#tdgw").empty();
			$("#tdgw").append(positionOption);
		}
	});
}
//获取城市列表
function getProvinceRecord(positionType,recruitType){
    //后台接口获取数据
    $.post('getProvinceRecordAction.json', {"positionType":positionType,"recruitType": recruitType}, function (ret) {
    	var result = ret.serviceResult;
        if (ret.serviceResult.success) {
            $("#recruitCityName").empty();
            var html= '<option value="">请选择城市</option>';
            var record = result.result;
            if(record.length>0){
                for(var i=0;i<record.length;i++){
                    html+='<option value="'+record[i].recruitCityName+'">'+record[i].recruitCityName+'</option>';
                }
            }
            $("#recruitCityName").append(html);
        }
    });
}
//获取城市列表
function getProvinceRecord2(recruitType){
	//后台接口获取数据
	$.post('getDepartmentByDepartmentPCd.json', {/*"recruitType": recruitType*/}, function (ret) {
		if (ret.success) {
			$("#city").empty();
			$("#tdgw").empty();
			var html= '<option value="">请选择城市</option>';
			var html2= '<option value="">请选择职位</option>';
			var record = ret.result;
			if(record.length>0){
				for(var i=0;i<record.length;i++){
					html+='<option value="'+record[i].id+'">'+record[i].areas+'</option>';
				}
			}
			$("#city").append(html);
			$("#tdgw").append(html2);
		}
	});
}
//教育经历
function getEducation(){
    var arr = [];
    $(".jltd-middle .jyjlModal").each(function(i){
        var date = $(this).find(".rowJyjlTime").val();//起止时间
        var startDate = '';//开始时间
        var endDate ='';//结束时间
        if(date.length>10){
            startDate = date.substring(0,10);//开始时间
            endDate = date.substring(date.length-10,date.length);//结束时间
        }
        var school= $(this).find(".school").val();//学校
        var major= $(this).find(".rowMajor").val();//专业
        var degreeName= $(this).find(".degreeName").val();//学历
        arr.push({
            "startDate":startDate,
            "endDate": endDate,
            "school": school,
            "major": major,
            "degreeName": degreeName,
            "delFlag": "0"
        });
    });
    return arr;
}
//工作经历
function getWork(){
    var arr = [];
    $(".jltd-middle .gzjlModal").each(function(i){
        var date = $(this).find(".rowGzjlTime").val();//起止时间
        var startDate = '';//开始时间
        var endDate ='';//结束时间
        if(date.length>10){
            startDate = date.substring(0,10);//开始时间
            endDate = date.substring(date.length-10,date.length);//结束时间
        }
        var company= $(this).find(".company").val();//公司
        var job= $(this).find(".job").val();//职位
        arr.push({
            "startDate":startDate,
            "endDate": endDate,
            "company": company,
            "job": job,
            "delFlag": "0"
        });
    });
    return arr;
}
//项目经历
function getProject(){
    var arr = [];
    $(".jltd-middle .xmNameModal").each(function(i){
        var date = $(this).find(".rowXmNameTime").val();//起止时间
        var startDate = '';//开始时间
        var endDate ='';//结束时间
        if(date.length>10){
            startDate = date.substring(0,10);//开始时间
            endDate = date.substring(date.length-10,date.length);//结束时间
        }
        var projectName= $(this).find(".projectName").val();//项目名称
        var projectRemark= $(this).find(".projectRemark").val();//描述
        arr.push({
            "startDate":startDate,
            "endDate": endDate,
            "projectName": projectName,
            "projectRemark": projectRemark,
            "delFlag": "0"
        });
    });
    return arr;
}
//校内荣誉
function getHonor(){
    var arr = [];
    $(".jltd-middle .xnryModal").each(function(i){
        var date = $(this).find(".rowXnryTime").val();//起止时间
        var startDate = '';//开始时间
        var endDate ='';//结束时间
        if(date.length>10){
            startDate = date.substring(0,10);//开始时间
            endDate = date.substring(date.length-10,date.length);//结束时间
        }
        var honorName= $(this).find(".honorName").val();//校内荣誉
        arr.push({
            "startDate":startDate,
            "endDate": endDate,
            "honorName": honorName,
            "delFlag": "0"
        });
    });
    return arr;
}
//校内职务
function getDuty(){
    var arr = [];
    $(".jltd-middle .xnzwModal").each(function(i){
        var date = $(this).find(".rowXnzwTime").val();//起止时间
        var startDate = '';//开始时间
        var endDate ='';//结束时间
        if(date.length>10){
            startDate = date.substring(0,10);//开始时间
            endDate = date.substring(date.length-10,date.length);//结束时间
        }
        var dutyName= $(this).find(".dutyName").val();//职位
        var dutyDescription= $(this).find(".dutyDescription").val();//描述
        arr.push({
            "startDate":startDate,
            "endDate": endDate,
            "dutyName": dutyName,
            "dutyDescription": dutyDescription,
            "delFlag": "0"
        });
    });
    return arr;
}
//语言能力
function getLanguage(){
    var arr = [];
    $(".jltd-middle .yydj").each(function(i){
    	var languageName = $(this).find(".languageName").val();//语种
        var hearAbli= $(this).find("#hearAbli").val();//听写能力
        var readAbli= $(this).find("#readAbli").val();//读写能力
		var languageEvaluate = readAbli+'|'+hearAbli;
		if(languageName != "" && languageName != null && languageName != undefined){
			arr.push({
	            "languageName":languageName,
	            "languageEvaluate": languageEvaluate,
	            "delFlag": "0"
	        });
		}
        
    });
    return arr;
}








