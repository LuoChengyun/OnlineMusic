function postSongType(){
	let songTypeForm=document.songTypeForm;
	let name=songTypeForm.name.value;
	let picture=songTypeForm.picture.value;
	if(name===""){
        alert("分类名不能为空");
        return false;
    }
	if(picture===""){
        alert("分类图不能为空");
        return false;
       
    }
	 return true;
}