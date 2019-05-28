/**
<h4>Description</h4>
 * @author Amit Rathi
 * 
 */
package com.salido.labor.util;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

@Component
public class ResourceMsgUtil {

    @Autowired
    MessageSource messageSource;

    @Nullable
    Object[] args = {};

    public String getMessage(String key) {
        return messageSource.getMessage(key, args, Locale.US);
    }
}
