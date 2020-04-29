package com.example.springbootdubboprivider.interceptor;

import com.sergei.entity.User;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.AsyncHandlerInterceptor;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author sergei
 * @create 2020-03-17
 */
//@Component
public class LoginHandlerInterceptor{
//    public class LoginHandlerInterceptor implements HandlerInterceptor {


//    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        response.setHeader("progma","no-cache");
        response.setHeader("Cache-Control","no-cache");
        response.setDateHeader("Expires",0);
        String uri = request.getRequestURI();
        String uriPrefix = request.getContextPath();
        if(uri.equals("/login")||uri.equals("/user/login")){
//                || StringUtils.startsWith(uri,uriPrefix+"/images/")
//                || StringUtils.startsWith(uri,uriPrefix+"/baidu_verify_zvMtYL19pL.html")
//                || StringUtils.startsWith(uri,uriPrefix+"/static")
//                || StringUtils.startsWith(uri,uriPrefix+"/style/")
//                || StringUtils.startsWith(uri,uriPrefix+"/servlet/")
//                || StringUtils.startsWith(uri,uriPrefix+"/favicon.ico")
//                || StringUtils.startsWith(uri,uriPrefix+"/login")
//                || StringUtils.startsWith(uri,uriPrefix+"/a/login")
//                || StringUtils.startsWith(uri,uriPrefix+"/register")
//                || StringUtils.startsWith(uri,uriPrefix+"/memberBidInfo/bidInfoList")
//                || StringUtils.startsWith(uri,uriPrefix+"/memberBidInfo/xsInfoList")
//                || StringUtils.startsWith(uri,uriPrefix+"/memberBidInfo/zrInfoList")
//                || StringUtils.startsWith(uri,uriPrefix+"/memberPwdModify/memberResetPwd")
//                || StringUtils.startsWith(uri,uriPrefix+"/memberBidInfo/bidInfoDetail")
//                || StringUtils.startsWith(uri,uriPrefix+"/memberBidInfo/zrInfoDetail")
//                || StringUtils.startsWith(uri,uriPrefix+"/memberBidInfo/xsInfoDetail")
//                || StringUtils.startsWith(uri,uriPrefix+"/app/download")
//                || StringUtils.startsWith(uri, uriPrefix+"/member/doValidateEmail")
//                || StringUtils.startsWith(uri,uriPrefix+"/f/")
//                || StringUtils.startsWith(uri,uriPrefix+"/f/memberBidInfo/zrBidInfo")
//                || StringUtils.startsWith(uri,uriPrefix+"/ftp/")
//                || StringUtils.startsWith(uri,uriPrefix+"/tjRegister")
//                || StringUtils.startsWith(uri,uriPrefix+"/ftp/")
//                || StringUtils.startsWith(uri,uriPrefix+"/zclip")
//                || StringUtils.startsWith(uri,uriPrefix+"/myBorrow")

        } else {
            User u = (User) request.getSession().getAttribute("user");
            if(u == null) {
                response.sendRedirect(uriPrefix+"/");
                return false;
            }
        }
        return true;
    }


//    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }


//    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
