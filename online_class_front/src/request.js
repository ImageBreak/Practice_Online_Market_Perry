import axios from "axios";

const service = axios.create({
    //url = base url + request url
    baseURL : "http://127.0.0.1:8081",

    //配置请求超时时间
    timeout : 5000
})

export default service