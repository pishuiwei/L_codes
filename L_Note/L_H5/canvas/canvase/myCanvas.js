
	var canvas = document.getElementById("myCanvas");
	var context = canvas.getContext('2d');
	// toDataURL(type, quality)	
	// toBlob(callback, type, args...)
	
	context.font = '38pt Arial';			// 设置字体样式
	
	context.fillStyle = 'cornflowerblue';	// 设置填充颜色
	context.strokeStyle = 'blue';			// 
	
	context.fillText('Hello Canvas', canvas.width/2 - 150, canvas.width/2 - 150);	// 文字、横坐标、纵坐标
	context.strokeText('Hello Canvas', canvas.width/2 - 150, canvas.width/2 - 150);
	
	
	
	
