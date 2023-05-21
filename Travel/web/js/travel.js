function jump(pageNo){
    window.location.href="?pageNo="+pageNo;
}

function delfood(fno) {
    if (confirm("是否删除？")){
        window.location.href='delfood?fno='+fno;
    }
}
function dellon(lno) {
    if (confirm("是否删除？")){
        window.location.href="/dellon?lno="+lno;
    }
}
function delhotel(hno) {
    if (confirm("是否删除？")){
        window.location.href="/delhotel?hno="+hno;
    }
}
function deltran(tno) {
    if (confirm("是否删除？")){
        window.location.href="/deltran?tno="+tno;
    }
}