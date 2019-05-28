/*
 * <h4>Description</h4>
 * This class handles exceptions from DAO layer and convert them to LATSystemException
 * 
 * @author Amit Rathi
 */
package com.salido.labor.aop;

import java.lang.reflect.Method;

import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.aop.ThrowsAdvice;
import org.springframework.dao.DataAccessException;

import com.salido.labor.exception.SalidoLaborBusinessException;
import com.salido.labor.exception.AppSystemException;

/**
 * The Class LogicThrowsAdvice.
 */
@Aspect
public class LogicThrowsAdvice implements ThrowsAdvice {

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
    @AfterThrowing(pointcut = "")
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
        AppSystemException appSystemException = new AppSystemException("errors.system.dataAccess", errorArgs, ex,
                ex.getMessage());
        throw appSystemException;
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
        AppSystemException appSystemException = new AppSystemException("errors.logic", errorArgs, ex, ex.getMessage());
        throw appSystemException;
    }

}
