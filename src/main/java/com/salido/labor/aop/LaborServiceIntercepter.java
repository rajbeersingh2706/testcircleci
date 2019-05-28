/**
 * Parse request URI and validate request.
 */
package com.salido.labor.aop;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.salido.labor.logic.AuthenticationLogic;
import com.salido.labor.util.ResourceMsgUtil;

@Component
public class LaborServiceIntercepter implements HandlerInterceptor {

    private static final Logger LOGGER = LogManager.getLogger(LaborServiceIntercepter.class);

    @Resource
    ResourceMsgUtil resourceMsgUtil;

    @Autowired
    AuthenticationLogic authenticationLogic;

    @Value("${AUTH_SERVICE_URL}")
    private String authServiceUrl;

    /*
     * (non-Javadoc)
     * 
     * @see org.springframework.web.servlet.HandlerInterceptor#preHandle(javax.
     * servlet .http.HttpServletRequest, javax.servlet.http.HttpServletResponse,
     * java.lang.Object)
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        //TODO
       /* boolean isTokenValid = authenticationLogic.validate(request);
        if (!isTokenValid) {
            response.sendError(HttpServletResponse.SC_FORBIDDEN,
                    resourceMsgUtil.getMessage("unauthorized.service.access"));
        }
        return isTokenValid;*/
        return true;
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.springframework.web.servlet.HandlerInterceptor#postHandle(javax.
     * servlet .http.HttpServletRequest, javax.servlet.http.HttpServletResponse,
     * java.lang.Object, org.springframework.web.servlet.ModelAndView)
     */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
            ModelAndView modelAndView) throws Exception {
        LOGGER.debug("Intercepter Called after handler method request completion, before rendering the view");
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * org.springframework.web.servlet.HandlerInterceptor#afterCompletion(javax
     * .servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse,
     * java.lang.Object, java.lang.Exception)
     */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
            throws Exception {
        LOGGER.debug("Called after rendering the view");
    }

}
