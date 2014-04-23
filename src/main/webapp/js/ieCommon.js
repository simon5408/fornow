var IECommon = function() {
	return {
		ajaxCall : function(args) {
			var defaults = {
				"success": function() {
				},
				"erorr": function() {
				},
				"data": {},
				"timeout": 30000,
				"headers": {
					"Content-Type": "application/json",
					"Accept": "application/json"
				}
			};

			args = $.extend(true, defaults, args);
			
			return $.ajax({
				url : args.uri,
				type : args.type,
				headers : args.headers,
				timeout: args.timeout,
				data : JSON.stringify(args.data),
				success : args.success,
				error : args.error,
			});
		},

		getCheckboxVals : function(ckName) {
			var ckValAry = [];
			$("input[name='" + ckName + "']:checkbox").each(function() {
				if ($(this).attr("checked")) {
					ckValAry.push(parseInt($(this).val()));
				}
			});

			return ckValAry;
		},
		
		doHref: function(url) {
			window.location.href = url;
		},
		
		doPush: function(args) {
			$IEC.ajaxCall({
	 			success: function(data){
	 				 alert(args.sucMsg); 
	 			},
	            error: function(data) {
	            	 alert(args.eroMsg); 
	            },
	            uri: args.uri,
	            type: args.type
	 		});
		}
	};
}();
window.$IEC = IECommon;