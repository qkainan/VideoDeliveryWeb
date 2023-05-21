import request from "@/network/request";

export const login = (data)=>{
    return request({
        methods:"POST",
        url:"/login",
        data
    })
};
export const register0 = (data)=>{
    return request({
        methods:"POST",
        url:"/register0",
        data
    })
};

export const mailregister = (data)=>{
    return request({
        methods:"POST",
        url:"/mailregister",
        data
    })
};
export const register1 = (data)=>{
    return request({
        methods:"POST",
        url:"/register1",
        data
    })
};
export const getUser = ()=> {
    return request({
      method:'POST',
      url:"/perinfo"
    });
  };