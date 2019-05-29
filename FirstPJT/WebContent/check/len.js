//http://programmingsummaries.tistory.com/239

// 변수선언
var string = ""; //테스트할 문자열
  
// 문자열 초기화
for(var j=0; j<10000; j++) {
    string += "값";
}
var stringLength = string.length;
var stringByteLength = 0;
  
  
// 일반적인 FOR문으로 문자열 BYTE 계산
console.time("일반적인FOR방식"); 
for(var i=0; i<stringLength; i++) {
    if(escape(string.charAt(i)).length >= 4)
        stringByteLength += 3;
    else if(escape(string.charAt(i)) == "%A7")
        stringByteLength += 3;
    else
        if(escape(string.charAt(i)) != "%0D")
            stringByteLength++;
}
console.log(stringByteLength + " Bytes")
//http://programmingsummaries.tistory.com/239

console.timeEnd("일반적인FOR방식");
  
  
// 개선된 FOR문으로 문자열 BYTE 계산
console.time("개선된FOR방식");
stringByteLength = (function(s,b,i,c){
    for(b=i=0;c=s.charCodeAt(i++);b+=c>>11?3:c>>7?2:1);
    return b
})(string);
console.log(stringByteLength + " Bytes");
console.timeEnd("개선된FOR방식");
  
  
// encodeURI로 문자열 BYTE 계산
console.time("encodeURI방식");
stringByteLength = ~-encodeURI(string).split(/%..|./).length;
console.log(stringByteLength + " Bytes");
console.timeEnd("encodeURI방식");
  
  
// 정규식을 활용한 계산
console.time("정규식방식");
stringByteLength = string.replace(/[\0-\x7f]|([0-\u07ff]|(.))/g,"$&$1$2").length;
console.log(stringByteLength + " Bytes");
console.timeEnd("정규식방식");