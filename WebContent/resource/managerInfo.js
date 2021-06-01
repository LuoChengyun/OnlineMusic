function postManager(){
	let managerInformationForm=document.managerInformationForm;
	let firstName=managerInformationForm.firstName.value;
	let lastName=managerInformationForm.lastName.value;
	let userName=managerInformationForm.userName.value;
	let password=managerInformationForm.password.value;
	let sex=managerInformationForm.sex.value;
	let introduct=managerInformationForm.introduct.value;
	if(firstName===""){
        alert("名不能为空");
        return false;
    }
	if(lastName===""){
        alert("姓不能为空");
        return false;
    }
	if(userName===""){
        alert("用户名不能为空");
        return false;
    }
	if(password===""){
        alert("密码不能为空");
        return false;
    }
	if(sex===""){
        alert("性别不能为空");
        return false;
    }
	return true;
}