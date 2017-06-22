/**
 * jquery 라이브러리의 일부 기능 구현
 */
function mlec(val) {
	
	// val 이 만약 function 이라면 window.onload에 callback 등록
	if (typeof(val) == "function") {
		window.onload = val;
		return;
	}
	
	// val = <img>
	var ch = val.charAt(0);
	
	console.log("tag Name", val.substring(1, val.length-1));
	
	var elements;
	switch(ch) {
		case "#":
			elements = document.querySelector(val);
			break;
		case "<":
			elements = document.createElement(
					val.substring(1, val.length-1)		
			);
			break;
		default:
			elements = document.querySelectorAll(val);
			break;
	}
	
	elements.attr = function (name, value) {
		// 만약, name 이 object 라면
		// 객체 안의 key와 value 값을 꺼내서 속성 설정해야 함
		if (typeof(name) == "object") {
			// 배열인 경우
			if (this.length) {
				for (var i = 0; i < this.length; i++) {
					for (var key in name) {
						this[i].setAttribute(key, name[key]);
					}
				}
			}
			// 배열이 아닌경우
			else {
				for (var key in name) {
					this.setAttribute(key, name[key]);
				}
			}
			return this;
		}
		// 객체가 아닌경우 
		else {
			// 배열인 경우
			if (this.length) {
				if (value != undefined) {
					for (var i = 0; i < this.length; i++) {
						this[i].setAttribute(name, value);
					}
					return this;
				}
				return this[0].getAttribute(name);
			}
			// 배열이 아닌경우
			else {
				if (value != undefined) {
					this.setAttribute(name, value);
					return this;
				}
				return this.getAttribute(name);
			}
		}
	};

	/*
	 *  html 이 undefined가 아니라면 innerHTML 설정
	 *  html 이 undefined 라면 innerHTML 추출
	 */
	elements.html = function (html) {
		if (this.length) {
			if (html != undefined) {
				for (var i = 0; i < this.length; i++) {
					this[i].innerHTML = html;
				}
				return this;
			}
			return this[0].innerHTML;
		}
		else {
			if (html != undefined) {
				this.innerHTML = html;
				return this;
			}
			return this.innerHTML;
		}
	};
	
	elements.text = function (text) {
		if (this.length) {
			if (text != undefined) {
				for (var i = 0; i < this.length; i++) {
					this[i].innerText = text;
				}
				return this;
			}
			return this[0].innerText;
		}
		else {
			if (text != undefined) {
				this.innerText = text;
				return this;
			}
			return this.innerText;
		}
	};
	elements.remove = function () {
		if (this.length) {
			for (var i = 0; i < this.length; i++) {
				this[i].parentNode.removeChild(this[i]);
			}
		}
		else {
			this.parentNode.removeChild(this);
		}
	};

	/*
	 *   $("#test").val("aaa");
	 *   
	 *   $("#test").val();
	 */
	elements.val = function (value) {
		if (this.length) {
			if (value != undefined) {
				for (var i = 0; i < this.length; i++) {
					this[i].value = value;
				}
				return this;
			}
			return this[0].value;
		}
		else {
			if (value != undefined) {
				this.value = value;
				return this;
			}
			return this.value;
		}
	};
	
	elements.focus = function () {
		if (this.length) {
			this[0].focus();
		}
		else {
			this.focus();
		}
		return this;
	};
	
	elements.select = function () {
		if (this.length) {
			this[0].select();
		}
		else {
			this.select();
		}
		return this;
	};
	
	elements.prop = function (name, value) {
		if (this.length) {
			for (var i = 0; i < this.length; i++) {
				this[i][name] = value;
			}
			return this;
		}
		else {
			this[name] = value;
			return this;
		}
	};
	
	// 이벤트 설정
	elements.on = function (eventType, callback) {
		if (this.length) {
			for (var i = 0; i < this.length; i++) {
				this[i].addEventListener(eventType, callback);
			}
			return this;
		}
		else {
			this.addEventListener(eventType, callback);
			return this;
		}			
	};

	elements.click = function (callback) {
		return this.on("click", callback);	
	};
	
	return elements;
}

var $ = mlec;

// ajax 처리 함수 등록
/*
$.ajax({
	type: "GET",   // 생략이 가능하고 생략시 GET 방식 호출
	url: "hello.jsp", 
	data: {msg: "aaa"}, 
	dataType: "json", // json, xml
	success: function () {}
}); 
 */
$.ajax = function (options) {
	/*
	console.log(options.type);
	console.log(options.url);
	console.log(options.data);
	console.log(options.dataType);
	console.log(options.success);
	*/
	
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function () {
		if (xhr.readyState == 4) {
			if (xhr.status == 200) {
				
				var result = xhr.responseText;
				switch(options.dataType) {
				case "json":
					result = JSON.parse(xhr.responseText);
					break;
				case "xml":
					result = xhr.responseXML;
					break;
				}
				
				// 성공 시 사용자가 success에 지정한 함수 실행
				options.success(result);
			}
		}
	};
	
	// 호출 방식 처리
	var method = options.type ? options.type : "GET";
	if (method != "GET" && method != "POST") {
		method = "GET";
	}
//	console.log("method : " + method);
	
	// 파라미터 처리
	console.log(options.data);
	console.log(typeof (options.data));
	var params = "";
	// 파라미터가 존재한다면 아래 수행
	if (options.data) {
		if (typeof (options.data) == "string") {
			params = options.data;
		}
		// 파라미터가 객체일 경우
		// {msg: "a", age: 11, name: "abc"}
		else {
			for (var key in options.data) {
				if (params != "") {
					params += "&";
				} 
				params += key + "=" + options.data[key];
			}
		}
	}
	console.log("params", params);
	
	// url 부분 처리
	// GET 방식일 경우에는 options.url + params
	var url = options.url;
	// GET 방식이고 파라미터가 존재하는 경우
	if (method == "GET" && params != "") {
		url += "?" + params;
	}
	
	xhr.open(method, url, true);
	
	// POST일 경우 헤더를 추가한다.
	if (method == "POST") {
		xhr.setRequestHeader(
				"Content-Type", 
				"application/x-www-form-urlencoded");
	}
	
	xhr.send(method == "POST" ? params : null);
};








