function postAlbum(){
	let albumForm=document.albumForm;
	let name=albumForm.name.value;
	if(name===""){
        alert("专辑名不能为空");
        return false;
    }
	 return true;
}