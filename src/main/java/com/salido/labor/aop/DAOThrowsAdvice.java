/*
 * <h4>Description</h4>
 * This class handles exceptions from DAO layer and convert them to LATSystemException
 * 
 * @author Amit Rathi
 */
package com.salido.labor.aop;

import java.lang.reflect.Method;

import org.springframework.aop.ThrowsAdvice;
import org.springframework.dao.DataAccessException;

import com.salido.labor.exception.SalidoLaborBusinessException;
import com.salido.labor.exception.AppSystemException;

/**
 * The Class DAOThrowsAdvice.
 */
public class DAOThrowsAdvice implements ThrowsAdvice {

    /**
     * After throwing.
     * 
     * @param ex
     *            the ex
     */
    public void afterThrowing(AppSystemException ex) {
        throw ex;
    }

    /**
     * After throwing.
     * 
     * @param ex
     *            the ex
     */
    public void afterThrowing(SalidoLaborBusinessException ex) {
        throw ex;
    }

    /**
     * After throwing.
     * 
     * @param ex
     *            the ex
     */
    public void afterThrowing(DataAccessException ex) {
        String[] errorArgs = { ex.getClass().getSimpleName(), ex.getMessage() };
        AppSystemException sdfpEx = new AppSystemException("errors.system.dataAccess", errorArgs, ex, ex.getMessage());
        throw sdfpEx;
    }

    /**
     * After throwing.
     * 
     * @param method
     *            the method
     * @param args
     *            the args
     * @param target
     *            the target
     * @param ex
     *            the ex
     */
    public void afterThrowing(Method method, Object[] args, Object target, RuntimeException ex) {
        String[] errorArgs = { ex.getClass().getSimpleName(), ex.getMessage() };
        AppSystemException sdfpEx = new AppSystemException("errors.system.dao", errorArgs, ex, ex.getMessage());
        throw sdfpEx;
    }

}
