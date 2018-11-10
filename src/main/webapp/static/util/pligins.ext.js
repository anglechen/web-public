
/**
 * 所有jquery 插件的扩展,以及自定义插件的扩展, 按需扩充
 *  2016-01-27
 *  
 */
;(function(){
	//未引入jquery。js 的直接退出
	if(typeof jQuery == "undefined" || typeof jQuery != "function" )return;
	/**
	 * datatable 汉化处理
	 */
    if( $.isFunction($.fn.dataTable)){
    	  var oLanguage={
    		        "oAria": {
    		            "sSortAscending": ": 升序排列",
    		            "sSortDescending": ": 降序排列"
    		        },
    		        "oPaginate": {
    		            "sFirst": "首页",
    		            "sLast": "末页",
    		            "sNext": "下页",
    		            "sPrevious": "上页"
    		        },
    		        "sEmptyTable": "没有相关记录",
    		        "sInfo": "第 _START_ - _END_ 条，共 _TOTAL_ 条",
    		        "sInfoEmpty": "没有相关记录",
    		        "sInfoFiltered": "",
    		        "sInfoPostFix": "",
    		        "sDecimal": "",
    		        "sThousands": ",",
    		        "sLengthMenu": "每页显示： _MENU_",
    		        "sLoadingRecords": "正在载入...",
    		        "sProcessing": "正在载入...",
    		        "sSearch": "搜索:",
    		        "sSearchPlaceholder": "",
    		        "sUrl": "",
    		        "sZeroRecords": "没有相关记录"
    		    }
    	 $.extend($.fn.dataTable.defaults.oLanguage,oLanguage);
    	 $.fn.dataTable.ext.errMode = 'none';
//        $.fn.dataTable.defaults.oLanguage=oLanguage;
    	 $.extend(true, $.fn.dataTable.defaults, {
    	        "ajax":{type:"post"}
    	     });
    }
   
    
    
    //jquery validate  汉化， 扩展支持
    if($.isFunction($.validator)){
    	 jQuery.extend(jQuery.validator.messages, {
       	  required: "必填字段不能为空",
       	  remote: "请修正该字段",
       	  email: "请输入正确格式的电子邮件",
       	  url: "请输入合法的网址",
       	  date: "请输入合法的日期",
       	  dateISO: "请输入合法的日期 (ISO).",
       	  number: "请输入合法的数字",
       	  digits: "只能输入整数",
       	  creditcard: "请输入合法的信用卡号",
       	  equalTo: "请再次输入相同的值",
       	  accept: "请输入拥有合法后缀名的字符串",
       	  maxlength: jQuery.validator.format("请输入一个 长度最多是 {0} 的字符串"),
       	  minlength: jQuery.validator.format("请输入一个 长度最少是 {0} 的字符串"),
       	  rangelength: jQuery.validator.format("请输入 一个长度介于 {0} 和 {1} 之间的字符串"),
       	  range: jQuery.validator.format("请输入一个介于 {0} 和 {1} 之间的值"),
       	  max: jQuery.validator.format("请输入一个最大为{0} 的值"),
       	  min: jQuery.validator.format("请输入一个最小为{0} 的值")
       	});

       	//扩展支持 data-validate属性直接配置验证规则
       	jQuery.fn.extend(jQuery.validator, {
       		classRules:function(element){
       			var rules = {},
       			validate = $( element ).data( "validate"),
       			classes = $( element ).attr( "class" );
       			if ( classes ) {
       				$.each( classes.split( " " ), function() {
       					if ( this in $.validator.classRuleSettings ) {
       						$.extend( rules, $.validator.classRuleSettings[ this ]);
       					}
       				});
       			}
       			//处理自定义的提示
       			if(validate){
       				$.extend( true,rules, eval("(" + validate + ")"));
       			}
       			return rules;
       		
       		}
       	});
       	//扩展提示信息支持   data-msg+方法名、data-msg、data-messages配置
       	//例如  data-msgrequired="不能为空"， data-msg="不能为空" ，data-messages="{required:'不能为空'，minlength：‘长度不能少于5’}"
       	//优先级 data-msg+方法名 > data-msg > data-messages
       	$.validator.prototype.customDataMessage= function( element, method  ){
       		var msg =  $( element ).data( "msg" + method ) || $( element ).data( "msg" );
       		if(typeof msg !="undefined" && typeof msg !=""){
       			return msg;
       		}else{
       			var message = $( element ).data("messages");
       			var m =  eval("(" + message + ")");
       			return m && ( m.constructor === String ? m : m[ method ]);
       		}
       	}
       	jQuery.validator.addMethod("IntEqZero", function(value, element) { 
            value=parseInt(value);      
            return this.optional(element) || value==0;       
       }, "整数必须为0"); 
         
       // 判断整数value是否大于0
       jQuery.validator.addMethod("IntGtZero", function(value, element) { 
            value=parseInt(value);      
            return this.optional(element) || value>0;       
       }, "整数必须大于0"); 
         
       // 判断整数value是否大于或等于0
       jQuery.validator.addMethod("IntGteZero", function(value, element) { 
            value=parseInt(value);      
            return this.optional(element) || value>=0;       
       }, "整数必须大于或等于0");   
       
       // 判断整数value是否不等于0 
       jQuery.validator.addMethod("IntNEqZero", function(value, element) { 
            value=parseInt(value);      
            return this.optional(element) || value!=0;       
       }, "整数必须不等于0");  
       
       // 判断整数value是否小于0 
       jQuery.validator.addMethod("IntLtZero", function(value, element) { 
            value=parseInt(value);      
            return this.optional(element) || value<0;       
       }, "整数必须小于0");  
       
       // 判断整数value是否小于或等于0 
       jQuery.validator.addMethod("IntLteZero", function(value, element) { 
            value=parseInt(value);      
            return this.optional(element) || value<=0;       
       }, "整数必须小于或等于0");  
       
       // 判断浮点数value是否等于0 
       jQuery.validator.addMethod("FloatEqZero", function(value, element) { 
            value=parseFloat(value);      
            return this.optional(element) || value==0;       
       }, "浮点数必须为0"); 
         
       // 判断浮点数value是否大于0
       jQuery.validator.addMethod("FloatGtZero", function(value, element) { 
            value=parseFloat(value);      
            return this.optional(element) || value>0;       
       }, "浮点数必须大于0"); 
         
       // 判断浮点数value是否大于或等于0
       jQuery.validator.addMethod("FloatGteZero", function(value, element) { 
            value=parseFloat(value);      
            return this.optional(element) || value>=0;       
       }, "浮点数必须大于或等于0");   
       
       // 判断浮点数value是否不等于0 
       jQuery.validator.addMethod("FloatNEqZero", function(value, element) { 
            value=parseFloat(value);      
            return this.optional(element) || value!=0;       
       }, "浮点数必须不等于0");  
       
       // 判断浮点数value是否小于0 
       jQuery.validator.addMethod("FloatLtZero", function(value, element) { 
            value=parseFloat(value);      
            return this.optional(element) || value<0;       
       }, "浮点数必须小于0");  
       
       // 判断浮点数value是否小于或等于0 
       jQuery.validator.addMethod("FloatLteZero", function(value, element) { 
            value=parseFloat(value);      
            return this.optional(element) || value<=0;       
       }, "浮点数必须小于或等于0");  
       
       // 判断浮点型  
       jQuery.validator.addMethod("Float", function(value, element) {       
            return this.optional(element) || /^[-\+]?\d+(\.\d+)?$/.test(value);       
       }, "只能包含数字、小数点等字符"); 
        
       // 匹配integer
       jQuery.validator.addMethod("Integer", function(value, element) {       
            return this.optional(element) || (/^[-\+]?\d+$/.test(value) && parseInt(value)>=0);       
       }, "匹配integer");  
        
       // 判断数值类型，包括整数和浮点数
       jQuery.validator.addMethod("Number", function(value, element) {       
            return this.optional(element) || /^[-\+]?\d+$/.test(value) || /^[-\+]?\d+(\.\d+)?$/.test(value);       
       }, "匹配数值类型，包括整数和浮点数");  
       
       // 只能输入[0-9]数字
       jQuery.validator.addMethod("Digits", function(value, element) {       
            return this.optional(element) || /^\d+$/.test(value);       
       }, "只能输入0-9数字");  
       
       // 判断中文字符 
       jQuery.validator.addMethod("Chinese", function(value, element) {       
            return this.optional(element) || /^[\u0391-\uFFE5]+$/.test(value);       
       }, "只能包含中文字符。");   
    
       // 判断英文字符 
       jQuery.validator.addMethod("English", function(value, element) {       
            return this.optional(element) || /^[A-Za-z]+$/.test(value);       
       }, "只能包含英文字符。");   
    
        // 手机号码验证    
       jQuery.validator.addMethod("Mobile", function(value, element) {    
         var length = value.length;    
         return this.optional(element) || (length == 11 && /^(((13[0-9]{1})|(15[0-9]{1})|(18[0-9]{1}))+\d{8})$/.test(value));    
       }, "请正确填写您的手机号码。");

       // 电话号码验证    
       jQuery.validator.addMethod("Phone", function(value, element) {    
         var tel = /^(\d{3,4}-?)?\d{7,9}$/g;    
         return this.optional(element) || (tel.test(value));    
       }, "请正确填写您的电话号码。");

       // 联系电话(手机/电话皆可)验证   
       jQuery.validator.addMethod("Tel", function(value,element) {   
           var length = value.length;   
           var mobile = /^(((13[0-9]{1})|(15[0-9]{1})|(18[0-9]{1}))+\d{8})$/;   
           var tel = /^(\d{3,4}-?)?\d{7,9}$/g;       
           return this.optional(element) || tel.test(value) || (length==11 && mobile.test(value));   
       }, "请正确填写您的联系方式"); 
    
        // 匹配qq      
       jQuery.validator.addMethod("Qq", function(value, element) {       
            return this.optional(element) || /^[1-9]\d{4,12}$/;       
       }, "匹配QQ");   
    
        // 邮政编码验证    
       jQuery.validator.addMethod("ZipCode", function(value, element) {    
         var zip = /^[0-9]{6}$/;    
         return this.optional(element) || (zip.test(value));    
       }, "请正确填写您的邮政编码。");  
       
       // 匹配密码，以字母开头，长度在6-12之间，只能包含字符、数字和下划线。      
       jQuery.validator.addMethod("Pwd", function(value, element) {       
            return this.optional(element) || /^[a-zA-Z]\\w{6,12}$/.test(value);       
       }, "以字母开头，长度在6-12之间，只能包含字符、数字和下划线。");  
       
       // 身份证号码验证
       jQuery.validator.addMethod("IdCardNo", function(value, element) { 
         var isIdCardNO = /^(\d{6})()?(\d{4})(\d{2})(\d{2})(\d{3})(\w)$/;   
         return this.optional(element) || isIdCardNO.test(value);    
       }, "请输入正确的身份证号码。"); 

       // IP地址验证   
       jQuery.validator.addMethod("Ip", function(value, element) {    
         return this.optional(element) || /^((2[0-4]\d|25[0-5]|[01]?\d\d?)\.){3}(2[0-4]\d|25[0-5]|[01]?\d\d?)$/.test(value);    
       }, "请填写正确的IP地址。");
      
       // 字符验证，只能包含中文、英文、数字、下划线等字符。    
       jQuery.validator.addMethod("stringCheck", function(value, element) {       
            return this.optional(element) || /^[a-zA-Z0-9\u4e00-\u9fa5-_]+$/.test(value);       
       }, "只能包含中文、英文、数字、下划线等字符");   
      
       // 匹配english  
       jQuery.validator.addMethod("English", function(value, element) {       
            return this.optional(element) || /^[A-Za-z]+$/.test(value);       
       }, "匹配english");   
       
       // 匹配汉字  
       jQuery.validator.addMethod("Chinese", function(value, element) {       
            return this.optional(element) || /^[\u4e00-\u9fa5]+$/.test(value);       
       }, "匹配汉字");   
       
       // 匹配中文(包括汉字和字符) 
       jQuery.validator.addMethod("ChineseChar", function(value, element) {       
            return this.optional(element) || /^[\u0391-\uFFE5]+$/.test(value);       
       }, "匹配中文(包括汉字和字符) "); 
         
       // 判断是否为合法字符(a-zA-Z0-9-_)
       jQuery.validator.addMethod("RightfulString", function(value, element) {       
            return this.optional(element) || /^[A-Za-z0-9_-]+$/.test(value);       
       }, "判断是否为合法字符(a-zA-Z0-9-_)");   
       
       // 判断是否包含中英文特殊字符，除英文"-_"字符外
       jQuery.validator.addMethod("ContainsSpecialChar", function(value, element) {  
            var reg = RegExp(/[(\ )(\`)(\~)(\!)(\@)(\#)(\$)(\%)(\^)(\&)(\*)(\()(\))(\+)(\=)(\|)(\{)(\})(\')(\:)(\;)(\')(',)(\[)(\])(\.)(\<)(\>)(\/)(\?)(\~)(\！)(\@)(\#)(\￥)(\%)(\…)(\&)(\*)(\（)(\）)(\—)(\+)(\|)(\{)(\})(\【)(\】)(\‘)(\；)(\：)(\”)(\“)(\’)(\。)(\，)(\、)(\？)]+/);   
            return this.optional(element) || !reg.test(value);       
       }, "含有中英文特殊字符");   
       jQuery.validator.addMethod("isZipCode", function(value, element) {   
   	    var tel = /^[0-9]{6}$/;
   	    return this.optional(element) || (tel.test(value));
   	}, "非法邮政编码");
      jQuery.validator.addMethod("Fax", function(value, element) {   
	   	    var fax = /^[+]{0,1}(\d){1,3}[ ]?([-]?((\d)|[ ]){1,12})+$/i;
	   	    return this.optional(element) || (fax.test(value));
      }, "非法传真号码");
    }
    
    /**
     * $.ajax 增强处理 ，
     */
    if($.isFunction($.ajax)){
    	$.ajaxSetup({
    		type:"post",
    		cache:true,
    		beforeSend:function(e,xhr,o){
    			xhr.url =  encodeURI(xhr.url);   
    		},
    		  //错误方法增强处理
    		error:function(XMLHttpRequest, textStatus, errorThrown){
    			
    			if(typeof layer == "object" &&  typeof layer.open == "function" ){
    				if(XMLHttpRequest.responseText.indexOf('<meta name="description" content="B3A8EC22CB514BAC17F1B34BDF227838">') != -1){
    					window.location.href=basepath + "/login.jsp";
						return;
    				};
//            		layer.open({
//					    type: 1,
//					    title:"出错了",
//					    skin: 'layui-layer-rim', //加上边框
//					    area: ['600px','400px'], //宽高
//					    content:  XMLHttpRequest.responseText == undefined?errorThrown.stack:XMLHttpRequest.responseText,
//					    success:function(layero,index){
//					    	layero.find(".layui-layer-content").css("margin","0px");
//					    }
//					});
            	}else{
            		alert(XMLHttpRequest.responseText);
            	}
            },
            dataFilter:function(data,type){
            	
            	if(type == "jsonp")return data;
            	var strurl = this.url;
            	if(type!="json" && type )return data;
            	if( data.indexOf('<meta name="description" content="DCF56B04146DFFADC51E5B619EFEE5EC">') != -1){
//            		layer.open({
//            			type:1,
//            			title:"权限异常！",
//            			skin: 'layui-layer-rim', //加上边框
// 					    area: ['600px','400px'], //宽高
//            			content:data,
//            			success:function(layero,index){
//            				layero.find(".layui-layer-content").css("margin","0px");
//					    }
//            		});
            		console.error("您没有权限访问url："+strurl);
            		return data;
            	}
//            	if(data.indexOf('<meta name="description" content="B3A8EC22CB514BAC17F1B34BDF227838">') != -1){
//					window.location.href=basepath + "/login.jsp";
//					return;
//				};
            	var sdata = "";
            	try{
            		sdata = eval("("+data+")");
            	}catch(e){
            		return data;
            	}
            	
            	if(!sdata)return data;
            	if(sdata && sdata.resultCode == "OK_200"){
            		if(sdata.isOptData)return JSON.stringify(sdata.data.optData);
            		return  data;
            	}else if(sdata && sdata.resultCode == "EXCEPTION_501"){
            		layer.msg(sdata.resultDesc?sdata.resultDesc:"请求出错了，请检查网络配置或联系管理员！");
            		return data;
            	}else if(sdata && sdata.resultCode == "PARAM_ERR_401"){
            		layer.msg(sdata.resultDesc?sdata.resultDesc:"参数错误！");
            		return data;
            	}else{
//            		console.warn("警告：json数据格式不是标准的resultBean格式,有可能导致解析错误！"+"url:"+this.url);
//            		console.warn(sdata);
            		return data;
            	}
            	
            }

    	});
    }
    
//    (new Date()).Format("yyyy-MM-dd hh:mm:ss.S") ==> 2006-07-02 08:09:04.423 
 // (new Date()).Format("yyyy-M-d h:m:s.S")      ==> 2006-7-2 8:9:4.18 
    Date.prototype.Format = function (fmt) { //
        var o = {
            "M+": this.getMonth() + 1, //月份 
            "d+": this.getDate(), //日 
            "h+": this.getHours(), //小时 
            "m+": this.getMinutes(), //分 
            "s+": this.getSeconds(), //秒 
            "q+": Math.floor((this.getMonth() + 3) / 3), //季度 
            "S": this.getMilliseconds() //毫秒 
        };
        if (/(y+)/.test(fmt)) fmt = fmt.replace(RegExp.$1, (this.getFullYear() + "").substr(4 - RegExp.$1.length));
        for (var k in o)
        if (new RegExp("(" + k + ")").test(fmt)) fmt = fmt.replace(RegExp.$1, (RegExp.$1.length == 1) ? (o[k]) : (("00" + o[k]).substr(("" + o[k]).length)));
        return fmt;
    }
    
    
    
})();