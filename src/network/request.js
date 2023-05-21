import axios from "axios";
import router from "@/router";
// import {ElMessage} from "@element-plus/icons-vue"
import { ElMessage } from 'element-plus'

const request =axios.create({
    baseURL:"/api",
})

router.beforeEach((to,from,next)=>{
    const token =localStorage.getItem('Authorization')
    if(to.name!='Login'&&!token) next({name:'Login'})
    else next()
})


request.interceptors.request.use(
    (config)=>{
        const token =localStorage.getItem('Authorization')
        if(token) config.headers.Authorization = 'Bearer ${token}';
        return config
    },
    (error)=> Promise.reject(error)
)

request.interceptors.response.use(
    (response)=> response,
    ({response})=>{
        const {status,data}=response
        const {message}=data
        ElMessage(message)
        if (status ===401) router.push({name:'Login'})
        return Promise.reject(error)
    }
)

export default request