function sysTime(clock) {
    var now=new Date();
    var year= now.getFullYear();
    var month=now.getMonth();
    var date=now.getDate();
    month=month+1;
    var time=date+"/"+month+"/"+year;
    clock.innerHTML=time;
}
window.onload=function () {
    window.setInterval("sysTime(clock)",1000);
}