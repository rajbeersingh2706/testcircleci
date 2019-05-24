package com.salido.labor.logic;

import javax.servlet.http.HttpServletRequest;

public interface AuthenticationLogic {

    boolean validate(HttpServletRequest request);

}
