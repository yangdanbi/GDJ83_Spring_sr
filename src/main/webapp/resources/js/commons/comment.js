const commentButton = document.getElementById("commentButton");
const commentContents = document.getElementById("commentContents");
const commentClose = document.getElementById("commentClose");
const commentList = document.getElementById("commentList");
const dels = document.getElementById("dels");
const openModal = document.getElementById("openModal");

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
//flag가 true라면 댓글등록, false라면 댓글수정
let flag=true;
let item_id=0;


//openModal (댓글등록)
//댓글 등록을 처음 누르면 버튼 텍스트는 댓글등록/ 내용은 빈칸
openModal.addEventListener("click",()=>{
    flag=true;
    commentButton.innerHTML="댓글등록";
    commentContents.value="";

})



commentList.addEventListener("click",(e)=>{
    e.preventDefault();
    
   if(e.target.classList.contains("pn")){
        let p = e.target.getAttribute("data-page-num");
        getList(p);
       // alert(p);
   }
 
})

//수정버튼을 누르면 save 텍스트가 댓글 수정으로 변함
commentList.addEventListener("click",(e)=>{
    //ups 라는 class가 있으면 ups버튼을 클릭한 것
    if(e.target.classList.contains("ups")){
        flag=false;
        item_id = e.target.getAttribute("data-del-id");
        let c = e.target.getAttribute("data-update-con");
       c = document.getElementById(c).innerHTML;
       commentContents.value=c;
        commentButton.innerHTML="댓글수정";
    
        //console.log(c);
       // commentButton.click();
       // alert(id);
    }
})

//등록,수정
commentButton.addEventListener("click",()=>{
    let msg = "댓글 추가 성공";
    let contents = commentContents.value;

    if(contents==null || contents==""){
        alert("댓글을 입력하세요.")
        return;

    }
    //flag가 true면 등록
    //false 면 수정
    let url="commentAdd";

    const form = new FormData(); //<form></form>
    form.append("boardContents",contents); //<input type="text" name="boardContents", vlaue ="content"값>
    form.append("item_id",commentButton.getAttribute("data-id"));
    form.append("boardNum",item_id);
    //등록할때 필요한 변수
    //let param="boardContents=" + contents + "&item_id=" + commentButton.getAttribute("data-id");

    //false일때
    if(!flag){
        url="commentUpdate";
       // param="boardContents=" + contents + "&boardNum=" + boardNum;
        msg ="댓글 수정 성공";
    }
    //console.log(url);
    //console.log(param);

    //save누르면 댓글창 강제닫기
    commentClose.click();
   
    //Ajax 파라미터 보내기
    fetch(url,{
        method:"POST",
        // headers:{
        //     "Content-type":"application/x-www-form-urlencoded"
        // },
        body:form
    })
    .then(r=>r.text())
    .then(r=>{
        r=r.trim();
        if(r>0){
            alert(msg);
            getList(1);
        }
    })

    //

    commentContents.value="";
})

//댓글삭제
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


