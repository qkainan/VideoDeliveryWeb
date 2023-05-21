import request from "./request";

// 检查登录
export const isToken =() =>{
    return request({
        method:'POST',
        url:"/info"
    });
}

/* 注册用户 */
export const register = (data) => {
    return request({
      method: "POST",
      url: "/register",
      data
    },);
  };
  