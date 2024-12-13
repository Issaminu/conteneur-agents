package com.enset.issamboubcher.aspects;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class SecurityAspect {

    @Before("@annotation(securedBy) && execution(* *(..))")
    public void checkSecurity(SecuredBy securedBy) {
        String[] requiredRoles = securedBy.roles();

        String[] userRoles = {"role1", "role2"};

        for (String requiredRole : requiredRoles) {
            boolean hasRole = false;
            for (String userRole : userRoles) {
                if (userRole.equals(requiredRole)) {
                    hasRole = true;
                    break;
                }
            }
            if (!hasRole) {
                throw new SecurityException("Access Denied: User does not have the required role " + requiredRole);
            }
        }
    }
}
