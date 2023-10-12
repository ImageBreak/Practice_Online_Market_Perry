package net.perry.online_class.interceptor;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.databind.ObjectMapper;

import io.jsonwebtoken.Claims;
import net.perry.online_class.utils.JWTUtils;
import net.perry.online_class.utils.JsonData;

@Component
public class LoginInterceptor implements HandlerInterceptor{

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
            throws Exception {
        // TODO Auto-generated method stub
        HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
            ModelAndView modelAndView) throws Exception {
        // TODO Auto-generated method stub
        HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
    }

    /**
     * 进入到Controller之前的方法
     * @param request
     * @param response
     * @param handler
     * @return
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        
                try {
                    
                    String accessToken = request.getHeader("token");
                    if (accessToken == null){
                        accessToken = request.getParameter("token");
                    }

                    if (StringUtils.isNotBlank(accessToken)){
                        Claims claims = JWTUtils.checkJWT(accessToken);
                        if (claims == null){
                            //登录过期，需要重新登录
                            sendJsonMessage(response, JsonData.buildError("登录过期，需要重新登录"));
                            return false;
                        }

                        Integer id = (Integer) claims.get("id");
                        String name = (String) claims.get("name");

                        request.setAttribute("id", id);
                        request.setAttribute("name", name);

                        return true;
                    }
                } catch (Exception e) {

                    e.printStackTrace();
                    // 登录失败
                }

        sendJsonMessage(response, JsonData.buildError("登录过期，需要重新登录"));
        return false;
    }
    
    /**
     * 响应Json数据给前端
     * @param response
     * @param obj
     */
    public static void sendJsonMessage(HttpServletResponse response, Object obj){

        try {
            ObjectMapper objectMapper = new ObjectMapper();
            response.setContentType("application/json; charset=utf-8");
            PrintWriter writer = response.getWriter();
            writer.print(objectMapper.writeValueAsString(obj));
            writer.close();
            response.flushBuffer();
        } catch (Exception e) {
            
            e.printStackTrace();
        }
    }
}
