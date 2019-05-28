package com.salido.labor.common;

public class Constants {

    private Constants() {
    }

    public static final String CODE_SUCCESS = "200";

    public static final String CODE_KEY_NOT_FOUND = "201";
    public static final String KEY_DATA = "data";
    public static final String KEY_STATUS = "status";
    public static final String KEY_MESSAGE = "message";
    public static final String KEY_SUCCESS = "success";
    public static final String KEY_ERROR_TXT = "error";
    public static final String KEY_ERROR = "201";
    public static final String KEY_YES = "Yes";
    public static final String KEY_NO = "No";
    public static final String SORT_ORDER_ASC = "ASC";
    public static final String SORT_ORDER_DESC = "DESC";
    // That's 7 days
    public static final long TOKEN_LIFETIME = 604_800_000;
    public static final String TOKEN_PREFIX = "Bearer ";
    public static final String TOKEN_SECRET = "ThisIsOurSecretKeyToSignOurTokens";

}
