const commentButton = document.getElementById("commentButton");
const commentContents = document.getElementById("commentContents");
const commentClose = document.getElementById("commentClose");
const commentList = document.getElementById("commentList");
const dels = document.getElementById("dels");

getList(1);

//리스트불러와서 innerHTML 쓰는거
//getList 호출할때 page번호 줘야함
function getList(page){
    fetch("commentList?item_id="+ commentButton.getAttribute("data-id")+"&page="+page,{
        method:"GET"
    })
    .then(r=>r.text())
    .then(r=>commentList.innerHTML=r)
}

// for(let c of cn){
//     c.addEventListener("click",()=>{
        
//         alert("click");
//     })
// }

commentList.addEventListener("click",(e)=>{
    e.preventDefault();
    
   if(e.target.classList.contains("pn")){
        let p = e.target.getAttribute("data-page-num");
        getList(p);
       // alert(p);
   }
 
})

commentList.addEventListener("click",(e)=>{
    if(e.target.classList.contains("dels")){
        let id =e.target.getAttribute("data-del-id");
        //server 삭제요청
    
        //option
        fetch("commentDelete",{
            method:"POST",
            headers:{
                "Content-type":"application/x-www-form-urlencoded"
            },
            body:"boardNum=" + id
        })
        .then((r)=>{return r.text()})
        .then((r)=>{
           r= r.trim();
            if(r>0){
                alert('삭제 성공');
                getList(1);
            }else{
                alert('삭제 실패');
            }
        })
       }


})

commentButton.addEventListener("click",()=>{
    //save누르면 댓글창 강제닫기
    commentClose.click();
    let contents = commentContents.value;
    //Ajax 파라미터 보내기
    fetch("commentAdd",{
        method:"POST",
        headers:{
            "Content-type":"application/x-www-form-urlencoded"
        },
        body:"boardContents=" + contents + "&item_id=" + commentButton.getAttribute("data-id")
    })
    .then(r=>r.text())
    .then(r=>{
        r=r.trim();
        if(r>0){
            alert('댓글추가');
            getList(1);
        }
    })

    //

    commentContents.value="";
})


