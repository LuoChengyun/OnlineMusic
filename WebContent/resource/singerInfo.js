function postSinger(){
	let singerForm=document.singerForm;
	let name=singerForm.name.value;
	let sex=singerForm.sex.value;
	let introduct=singerForm.introduct.value;
	let picture=singerForm.pictureURL.vlue;
	if(name===""){
        alert("歌手名不能为空");
        return false;
    }
	if(sex===""){
        alert("歌手性别不能为空");
        return false;
       
    }
	if(introduct===""){
        alert("介绍不能为空");
        return false;
    }
    if(picture===""){
        alert("图片不能为空");
        return false;
    }
	
	 return true;
}