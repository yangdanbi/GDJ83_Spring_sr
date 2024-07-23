const wishDelete = document.getElementsByClassName("wishDelete");
const deleteParent = document.getElementsByClassName("deleteParent");

for(let w of wishDelete){

    w.addEventListener("click",()=>{
        let id =w.getAttribute("data-wish-delete");
        w.parentNode.parentNode.remove();
    })
}