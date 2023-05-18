package com.feidian.resolver;

import com.feidian.utils.JwtUtil;
import io.jsonwebtoken.Claims;
import org.springframework.core.MethodParameter;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

@Component
public class UserIdArgumentResolver implements HandlerMethodArgumentResolver {
    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        //如果参数上有@CurretUserId注解则能被解析
        return parameter.hasParameterAnnotation(CurrentUserId.class);
    }

    @Override
    public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer, NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {
        //获取请求头中的token
        String token = webRequest.getHeader("token");
        if(StringUtils.hasText(token)){
            //解析token，获取userId
            Claims claims = JwtUtil.parseJWT(token);
            String userId = claims.getSubject();
            //返回结果
            return userId;
        }
        return null;
    }

}
