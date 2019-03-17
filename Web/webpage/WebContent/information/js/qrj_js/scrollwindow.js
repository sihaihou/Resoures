var currentpos, timer;   
function initialize() {   
	timer = setInterval("scrollwindow()", 80);   
}   
function sc() {   
	clearInterval(timer);   
}   
function scrollwindow() {   
	var scrollPos;   
	if (typeof window.pageYOffset != 'undefined') {   
		scrollPos = window.pageYOffset;   
	} else if (typeof document.compatMode != 'undefined'   
			&& document.compatMode != 'BackCompat') {   
		scrollPos = document.documentElement.scrollTop;   
	} else if (typeof document.body != 'undefined') {   
		scrollPos = document.body.scrollTop;   
	}   

	currentpos = scrollPos;   
	window.scroll(0, ++currentpos);   
	if (currentpos == scrollPos) {   
		//sc();   
	}   
}   
document.onmousedown = sc;   
document.ondblclick = initialize; 
window.onload=initialize
