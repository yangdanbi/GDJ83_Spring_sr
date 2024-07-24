const wishDelete = document.getElementsByClassName("wishDelete");
const deleteParent = document.getElementsByClassName("deleteParent");
const selectAll = document.getElementById("selectAll");
const ch = document.getElementsByClassName("ch");
const del_btn = document.getElementById("del_btn");

del_btn.addEventListener("click",()=>{
    const e = [];
    let url ="./deleteWishList?";// 삭제할 url주소를 보내줘야함
    for(let c of ch){
        if(c.checked){
            let id = c.getAttribute("data-wish-id");
            url = url+"item_id="+id+"&";
            e.push(c.getAttribute("data-del-id"));//w0, w1
         }
    }
    
    url = url.substring(0,url.length-1);
    console.log(url);

    fetch(url,{
         method:"GET"
    })
    .then(r=>r.text())
    .then(r=>{
        r=r.trim();
        if(r>0){
            for(let ele of e){
                //c.parentNode.parentNode.remove();
                document.getElementById(ele).remove();
            }
        }else {
            alert('삭제 실패')
        }
    })
    .catch(()=>{alert('삭제 실패')});
})
     
for(let w of wishDelete){

    w.addEventListener("click",()=>{
        let id =w.getAttribute("data-wish-id");
        //server 삭제요청

        //option
        fetch("./deleteWishList?item_id="+id,{
            method:"GET"
        }).then((r)=>{return r.text()})
        .then((r)=>{
           r= r.trim();
            if(r>0){
               let i= w.getAttribute("data-del-id")
               document.getElementById(i).remove();
               // w.parentNode.parentNode.remove();
            }else{
                alert('삭제 실패');
            }
        }).catch(()=>(alert('삭제 실패')));
  
        //w.parentNode.parentNode.remove();
    })
}

     //체크박스에 click 이벤트 설정
    //  for(let i=0;i<ch.length;i++){
    //     ch[i].addEventListener("click", function(){
    //         //최종 결과물을 담을 변수
    //         let flag=true;

    //         //체크박스의 체크 유무를 판단
    //         for(let j=0;j<ch.length;j++){
    //             if(!ch[j].checked){
    //                 flag=false;
    //                 break;
    //             }
    //         }
    //         //최종 결과물을 selectAll에 대입
    //         selectAll.checked=flag;
            
    //     })
    // }


    for(let c of ch){
        c.addEventListener("click", ()=>{
    
            let flag=true;
            for(let check of ch){
                if(!check.checked){
                    flag =false;
                    break;
                }
            }
            selectAll.checked=flag;
        })
    }

// function info() {
//     //console.log("test");
//     for(let i=0;i<ch.length;i++){
//         ch[i].checked=selectAll.checked;
//     }
// }

selectAll.addEventListener("click", ()=>{
    for(let c of ch){
        c.checked=selectAll.checked;
    } 
    
})







