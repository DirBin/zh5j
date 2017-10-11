package com.zh5j.common.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

/**
 * <pre>
 * Copy right information:
 * Project:zh5j-common
 * File Name:BaseInterceptor.java
 * JDK version used:1.8
 * Commends:拦截器基类
 *
 *
 * Modification history	:
 * date			ver.	author			what is modified
 * ---------	----	---------	---------------------------
 * 2017年9月20日		1.0		MengRuiZhi		        new
 * </pre>
 * 
 * @author MengRuiZhi
 * @version 1.0
 */
public class BaseInterceptor extends HandlerInterceptorAdapter {
    protected final Logger logger = LogManager.getLogger();
    private BaseInterceptor[] nextInterceptor;

    public void setNextInterceptor(BaseInterceptor... nextInterceptor) {
        this.nextInterceptor = nextInterceptor;
    }

    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
        throws Exception {
        if (nextInterceptor == null) {
            return true;
        }
        for (int i = 0; i < nextInterceptor.length; i++) {
            if (!nextInterceptor[i].preHandle(request, response, handler)) {
                return false;
            }
        }
        return true;
    }

    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
        ModelAndView modelAndView) throws Exception {
        if (nextInterceptor != null) {
            for (int i = 0; i < nextInterceptor.length; i++) {
                nextInterceptor[i].postHandle(request, response, handler, modelAndView);
            }
        }
    }

    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
        throws Exception {
        if (nextInterceptor != null) {
            for (int i = 0; i < nextInterceptor.length; i++) {
                nextInterceptor[i].afterCompletion(request, response, handler, ex);
            }
        }
    }

    public void afterConcurrentHandlingStarted(HttpServletRequest request, HttpServletResponse response, Object handler)
        throws Exception {
        if (nextInterceptor != null) {
            for (int i = 0; i < nextInterceptor.length; i++) {
                nextInterceptor[i].afterConcurrentHandlingStarted(request, response, handler);
            }
        }
    }
}
