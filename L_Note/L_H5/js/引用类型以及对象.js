+引用类型
	Object类型:
		var o = new Object();
		var o = {};
	Array类型:
		var arr = new Array();
		var arr = new Array(1);
		var arr = ['1','2'];
	Date类型:
		var date = new Date();
	RegExp类型:
		/**
		 * g 全局模式， i 表示不区分大小写， m 表示多行模式
		 */
		var reg = /pattern/gim;
		var reg = new RegExp("","gim");
	Function类型:
		function fn(){};
		var fn = new Function("","","方法体");
	Math对象	
		var min = Math.max(1,2,3);
+全局对象
	