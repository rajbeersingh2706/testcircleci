package com.salido.labor.logic.impl;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;

import com.salido.labor.logic.AuthenticationLogic;
import com.salido.labor.util.ServiceClientGet;

import net.sf.json.JSONObject;
import net.sf.json.util.JSONTokener;

@Component
public class AuthenticationLogicImpl implements AuthenticationLogic {

    @Autowired
    ServiceClientGet authService;

    @Value("${AUTH_SERVICE_URL}")
    private String authServiceUrl;
    private static final String[] SERVICE_BASE = { "labor" };

    private static final Logger LOGGER = LogManager.getLogger(AuthenticationLogicImpl.class.getName());

    @Override
    public boolean validate(HttpServletRequest request) {
        LOGGER.debug("Pre-handle" + request.getRemoteAddr() + " : " + request.getRequestURI());
        boolean isTokenValid = false;
        try {
            String encodedAuth = request.getHeader("Authorization");
            LOGGER.debug(":token-  :" + encodedAuth);
            if (StringUtils.isNotBlank(encodedAuth)) {
                isTokenValid = validateToken(encodedAuth);
            }
        } catch (Exception exception) {
            isTokenValid = false;
            LOGGER.error("Excception in service intercepter...", exception);
        }
        LOGGER.debug("Token valid-" + isTokenValid);
        return isTokenValid;
    }

    private HttpHeaders createHttpHeaders(String encodedAuth) {
        HttpHeaders headers = new HttpHeaders();
        headers.set("Content-Type", MediaType.APPLICATION_JSON_VALUE);
        headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
        headers.add("Authorization", encodedAuth);
        return headers;
    }

    private boolean validateToken(String encodedAuth) {
        boolean isTokenValid = false;
        HttpHeaders headers = createHttpHeaders(encodedAuth);
        String response = authService.callService(headers, null, authServiceUrl);
        LOGGER.debug("validateToken auth service result==> " + response);
        if (StringUtils.isNotBlank(response)) {
            JSONTokener jsonTokener = new JSONTokener(response);
            JSONObject jsonObject = (JSONObject) jsonTokener.nextValue();
            if (jsonObject.has("success")) {
                isTokenValid = jsonObject.getBoolean("success");
            }

        }

        return isTokenValid;
    }

    /**
     * @param requestURI
     * @return
     */
    @SuppressWarnings("unused")
    private boolean verifySkipService(String requestURI) {
        for (String serviceURI : SERVICE_BASE) {
            if (requestURI.contains(serviceURI)) {
                return true;
            }
        }
        return false;
    }
}
