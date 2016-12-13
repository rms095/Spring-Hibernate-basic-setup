Snapshot : 

User user = userService.getUser(username, password)
if(user !== null){  
    if(user.getActStatus){
        switch(user.getRole().getId()){
            case 0 : return modelMap.add("result", user, "admin");
            case 1 : return modelMap.add("result", user, "owner");
            default : return modelMap.add("result", user, "student");
        }
    }else{
        return modelMap.add("error", "Act not activated yet, Kindly contact to admin - admin@sunbeam.com");    
    }
    }
}
else{
    return modelMap.add("error", "Invalid Username or Password");
}
