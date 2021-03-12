package com.ruoyi.framework.interceptor;

import com.alibaba.fastjson.JSONObject;
import com.ruoyi.constant.ShopConstant;
import com.ruoyi.domain.JcUser;
import com.ruoyi.utils.Base64Util;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationContext;
import org.springframework.core.MethodParameter;
import org.springframework.stereotype.Component;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.method.support.HandlerMethodReturnValueHandler;
import org.springframework.web.method.support.ModelAndViewContainer;
import org.springframework.web.servlet.AsyncHandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.ModelAndViewDefiningException;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter;
import org.springframework.web.servlet.mvc.method.annotation.RequestResponseBodyMethodProcessor;
import org.springframework.web.servlet.mvc.method.annotation.ViewNameMethodReturnValueHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.Map;
import java.util.Objects;

/**
 * TODO
 *
 * @author linhao Hu
 * @date 2020/10/14 11:09
 */
@Component
@Slf4j
public class WxAuthInterceptor extends HandlerInterceptorAdapter {
    
    private ApplicationContext applicationContext;
    protected InterceptorPreHandler interceptorPreHandler; 

    
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String token = request.getHeader(ShopConstant.APPLET_TOKEN);
        if (StringUtils.isEmpty(token)) {
            token = request.getParameter(ShopConstant.APPLET_TOKEN);
        }
        
        try{
            if (StringUtils.isEmpty(token)) {
                log.warn("【信息验证】用户未登录。");
                return false;
            }
            //解析token
            Map map = JSONObject.parseObject(Base64Util.decodeBase64String(token,ShopConstant.APPLET_TOKEN_SALT));
            JcUser user = new JcUser();
            user.setId(Long.parseLong(map.get("id").toString()));
            user.setName(map.get("name").toString());
            Long expiresTime = Long.parseLong(map.get("expiresTime").toString());
            if(new Date().getTime() > expiresTime){//登录超时
                log.warn("【信息验证】token已过期。");
                return false;
            }
            
            return super.preHandle(request, response, handler);
        }catch (Exception e){
            log.info("【信息验证】token解析错误：token=>{}", token);
            postInterceptor(request, response, handler);
            return false;
        }
    }

    /**
     * 拦截后处理
     */
    protected void postInterceptor(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // 如果被拦截，返回信息
        if (((HandlerMethod) handler).getMethodAnnotation(ResponseBody.class) != null ) {
            // 返回json
            HandlerMethod handlerMethod = new HandlerMethod(((HandlerMethod) handler).getBean(), ((HandlerMethod) handler).getMethod());
            Object returnValue = interceptorPreHandler.getResponseBody();
            MethodParameter returnValueType = handlerMethod.getReturnValueType(returnValue);
            applicationContext.getBean(RequestMappingHandlerAdapter.class).getReturnValueHandlers();
            RequestResponseBodyMethodProcessor requestResponseBodyMethodProcessor = findRequestResponseBodyMethodProcessor();
            requestResponseBodyMethodProcessor.handleReturnValue(returnValue, returnValueType, new ModelAndViewContainer(), new ServletWebRequest(request, response));
            // end
        } else {
            // 返回页面
            HandlerMethod handlerMethod = new HandlerMethod(((HandlerMethod) handler).getBean(), ((HandlerMethod) handler).getMethod());
            String viewName = interceptorPreHandler.getViewName();
            MethodParameter returnValueType = handlerMethod.getReturnValueType(viewName);
            ViewNameMethodReturnValueHandler viewNameMethodReturnValueHandler = findViewNameMethodReturnValueHandler();
            ModelAndViewContainer modelAndViewContainer = new ModelAndViewContainer();
            // viewNameMethodReturnValueHandler 内的实现非常简单，其实可以不用这个的，直接new ModelAndViewContainer()就好了。
            viewNameMethodReturnValueHandler.handleReturnValue(viewName, returnValueType, modelAndViewContainer, new ServletWebRequest(request, response));

            // 抛出异常由Spring处理
            ModelMap model = modelAndViewContainer.getModel();
            ModelAndView modelAndView = new ModelAndView(modelAndViewContainer.getViewName(), model, modelAndViewContainer.getStatus());
            throw new ModelAndViewDefiningException(modelAndView);
            // end
        }
    }

    private RequestResponseBodyMethodProcessor findRequestResponseBodyMethodProcessor() {
        RequestMappingHandlerAdapter requestMappingHandlerAdapter = applicationContext.getBean(RequestMappingHandlerAdapter.class);
        for (HandlerMethodReturnValueHandler value : Objects.requireNonNull(requestMappingHandlerAdapter.getReturnValueHandlers())) {
            if (value instanceof RequestResponseBodyMethodProcessor) {
                return (RequestResponseBodyMethodProcessor) value;
            }
        }
        // SpringMVC的环境下一定不会走到这里
        throw new UnsupportedOperationException("cannot find RequestResponseBodyMethodProcessor from RequestMappingHandlerAdapter by Spring Context.");
    }

    private ViewNameMethodReturnValueHandler findViewNameMethodReturnValueHandler() {
        RequestMappingHandlerAdapter requestMappingHandlerAdapter = applicationContext.getBean(RequestMappingHandlerAdapter.class);
        for (HandlerMethodReturnValueHandler value : Objects.requireNonNull(requestMappingHandlerAdapter.getReturnValueHandlers())) {
            if (value instanceof ViewNameMethodReturnValueHandler) {
                return (ViewNameMethodReturnValueHandler) value;
            }
        }
        // SpringMVC的环境下一定不会走到这里
        throw new UnsupportedOperationException("cannot find ViewNameMethodReturnValueHandler from RequestMappingHandlerAdapter by Spring Context.");
    }

    public void setApplicationContext(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }

    public void setInterceptorPreHandler(InterceptorPreHandler interceptorPreHandler) {
        this.interceptorPreHandler = interceptorPreHandler;
    }

    public interface InterceptorPreHandler {
        /**
         * preHandle(HttpServletRequest, HttpServletResponse, Object)
         */
        boolean check(HttpServletRequest request, HttpServletResponse response, Object handler);

        /**
         * 拦截后返回的视图名称
         *
         * @see ModelAndView
         * @see ViewNameMethodReturnValueHandler
         */
        String getViewName();

        /**
         * 拦截后返回的对象
         *
         * @see ResponseBody
         * @see RequestResponseBodyMethodProcessor
         */
        Object getResponseBody();
    }

}
