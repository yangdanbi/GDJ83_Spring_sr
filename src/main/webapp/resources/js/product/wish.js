const addWish = document.getElementById("addWish");
const wishResult = document.getElementById("wishResult");


addWish.addEventListener("click",(e)=>{
    let id = addWish.getAttribute("data-product-id")
    console.log(id)
    fetch("./addWish?item_id="+id,{
                method:"GET"
            })
    // 위 요청에 대한 응답을 텍스트로 꺼내겠다
    .then((res)=>{return res.text()})
    // 위에서 텍스트로 꺼낸 것을 어떻게 하겠다
    .then((res)=>{
        if(res>0){
            let check =confirm("위시리스트를 확인하시겠습니까")
                if(check){
                    location.href="./wishList";
                }
        }else{
            alert("위시리스트 추가 실패")
        }
    })
    // 예외(exception) 발생시 여기서도 처리 가능
    .catch(()=>{
        alert("오류 발생")
    })
})

// addWish.addEventListener("click",function(){
//     fetch("./addWish?num=15&name=sse",{
//         method:"GET"
//     })
// });