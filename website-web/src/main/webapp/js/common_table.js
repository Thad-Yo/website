var TableCommon = {
        // 序号格式化
        indexFormat: function (value, row, index) {
            return index + 1;
        },

        // 日期格式化
        dateFormat: function (value, type) {
            var dateStr = (value && value.indexOf("-") > 0 && new Date(value).format(type || 'yyyy-MM-dd hh:mm:ss'))
                || (value && new Date(parseInt(value)).format(type || 'yyyy-MM-dd hh:mm:ss')) || "";
            return dateStr;
        },

        // 日期格式化
        dateFormatYYYYMMDD: function (value) {
            var dateStr = (value && value.toString().indexOf("-") > 0 && new Date(value).format('yyyy-MM-dd'))
                || (value && new Date(parseInt(value)).format('yyyy-MM-dd')) || "";
            return dateStr;
        },

        // 日期格式化
        dateFormatYMDHMS: function (value) {
            var dateStr = (value && value.toString().indexOf("-") > 0 && new Date(value).format('yyyy-MM-dd hh:mm:ss'))
                || (value && new Date(parseInt(value)).format('yyyy-MM-dd hh:mm:ss')) || "";
            return dateStr;
        },

        // 性别格式化
        genderFormat: function (value) {
            var genderStr = (value && value == 0 ? "男" : "女") || "";
            return genderStr;
        },

        // 婚姻状况格式化
        marryFormat: function (value) {
            var marryStr = (value && value == 0 ? "未婚" : "已婚") || "";
            return marryStr;
        },

        // 金额格式化
        amountFormat: function (num) {
            num = num && num.toString().replace(/\$|\,/g, '');
            if (isNaN(num))
                num = "0";
            sign = (num == (num = Math.abs(num)));
            num = Math.floor(num * 100);
            cents = num % 100;
            num = Math.floor(num / 100).toString();
            if (cents < 10)
                cents = "0" + cents;
            for (var i = 0; i < Math.floor((num.length - (1 + i)) / 3); i++)
                num = num.substring(0, num.length - (4 * i + 3)) + ',' +
                    num.substring(num.length - (4 * i + 3));
            if (num == "0") {
                return "<span class='red'>未报价</span>";
            }
            return "￥" + (((sign) ? '' : '-') + num + '.' + cents);
        },

        // 附件格式化
        attachmentFormat: function (attachment) {
            var attachmentStr = (attachment && "<a href='" + publishRoot + attachment.path + "'>" + attachment.name + "</a>") || "";
            return attachmentStr;
        },

        // 附件格式化
        agreementFormat: function (agreement) {
            var agreementStr = (agreement && "<a href='" + imageRoot + agreement + "'> 下载附件 </a>") || "";
            return agreementStr;
        },

        // 图片格式化
        imageFormat: function (value, row) {
            if (value != null && value.length > 0) {
                var imageStr = '<div class="lightBoxGallery">';
                imageStr += '<img alt="image" class="feed-photo" src="' + value + '">';
                imageStr += '</div>';
                return imageStr;
            } else {
                return "";
            }
        },

        // 图片格式化
        imageLinkFormat: function (value, row) {
            if (value != null && value.length > 0) {
                var imageStr = '<div class="lightBoxGallery"><a href="' + value + '" data-gallery="">';
                imageStr += '<img alt="image" class="feed-photo" src="' + value + '">';
                imageStr += '</a></div>';
                return imageStr;
            } else {
                return "";
            }
        },

        // 内容格式化
        commentFormat:function(value, row, length){
            if (value != null && value.length > 0) {
                return value.length > length ? value.substring(0, length) + "..." : value;
            } else {
                return "";
            }
        },

        // 显示图片的DIV
        getShowImageDiv: function () {
            var divStr = '<div id="blueimp-gallery" class="blueimp-gallery">';
            divStr += '  <div class="slides"></div>';
            divStr += ' <h3 class="title"></h3>';
            divStr += ' <a class="prev">‹</a>';
            divStr += ' <a class="next">›</a>';
            divStr += ' <a class="close">×</a>';
            divStr += ' <a class="play-pause"></a>';
            divStr += ' <ol class="indicator"></ol>';
            divStr += ' </div>';
            return divStr;
        },

        // 取得服务器url
        getRootPath: function () {
            var strFullPath = window.document.location.href;
            var strPath = window.document.location.pathname;
            var pos = strFullPath.indexOf(strPath);
            var prePath = strFullPath.substring(0, pos);
            var postPath = strPath.substring(0, strPath.substr(1).indexOf('/') + 1);
            return (prePath + postPath);
        },

        // 取得服务器虚拟目录
        getPostPath: function () {
            var strPath = window.document.location.pathname;
            var postPath = strPath.substring(0, strPath.substr(1).indexOf('/') + 1);
            return postPath;
        },

        publishFormatter: function (value, row) {
            if (value == 1) {
                return "未发布";
            }
            return "已发布"
        },
        useFormatter: function (value, row) {
            if (value == 2 || value == 1) {
                return "<i class='fa fa-close'></i>";
            }
            return "<i class='fa fa-check'></i>"
        },
        formatterAmount: function (obj) {
            //先把非数字的都替换掉，除了数字和.
            obj.value = obj.value.replace(/[^\d.]/g,"");
            //必须保证第一个为数字而不是.
            obj.value = obj.value.replace(/^\./g,"");
            //保证只有出现一个.而没有多个.
            obj.value = obj.value.replace(/\.{2,}/g,".");
            //只能输入小数点后两位
            obj.value = obj.value.replace(".", "$#$").replace(/\./g, "").replace("$#$", ".").replace(/^(\-)*(\d+)\.(\d\d).*$/, '$1$2.$3');
            if(obj.value == "00") {
                obj.value = obj.value * 1;
            }
        },
        formatterInteger: function (obj) {
            //先把非数字的都替换掉，除了数字和.
            obj.value = obj.value.replace(/\D/g, "");
            if(obj.value * 1 == 0) {
                obj.value = "";
            }
        },
        formatterIntegerWithZero: function (obj) {
            //先把非数字的都替换掉，除了数字和.
            obj.value = obj.value.replace(/\D/g, "");
            if (obj.value != '') {
                obj.value = obj.value * 1;
            }
            if(obj.value * 1 == 0) {
                obj.value = 0;
            }
        },
        ratingFormat: function (value,row) {
            var ratingStr = [];
            ratingStr.push('<input type="hidden" class="rating" readonly="readonly" value="'+value+'" data-stop="5"/>');
            ratingStr.push('<span class="label label-success"></span>');
            return ratingStr.join('');
        },
        // 刷新按钮的单击动作事件
        refreshClkAct: function () {
            window.location.reload();
        },

        getHeight: function() {
            return $(window).height() - ($(".search-panel").outerHeight() || 60) - 45;
        },
    
        // 详细信息格式化
        detailFormatter: function (index, row, displayLists) {
            var html = [];
            for(var idx in displayLists) {
                var name = displayLists[idx].name;
                var column = displayLists[idx].column;
                html.push('<b> ' + name + ':</b> <br/><p style="word-break:break-all;">');
                $.each(row, function (key, value) {
                    if (key == column) {
                        html.push(value);
                    }
                });
                html.push('</p>');
            }
            return html.join('');
        }
    };

Date.prototype.format =function(format)
{
    var o = {
        "M+" : this.getMonth()+1, //month
        "d+" : this.getDate(), //day
        "h+" : this.getHours(), //hour
        "m+" : this.getMinutes(), //minute
        "s+" : this.getSeconds(), //second
        "q+" : Math.floor((this.getMonth()+3)/3), //quarter
        "S" : this.getMilliseconds() //millisecond
    }
    if(/(y+)/.test(format)) format=format.replace(RegExp.$1,
        (this.getFullYear()+"").substr(4- RegExp.$1.length));
    for(var k in o)if(new RegExp("("+ k +")").test(format))
        format = format.replace(RegExp.$1,
            RegExp.$1.length==1? o[k] :
                ("00"+ o[k]).substr((""+ o[k]).length));
    return format;
}