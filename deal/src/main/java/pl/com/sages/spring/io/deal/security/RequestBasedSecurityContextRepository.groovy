package pl.com.sages.spring.io.deal.security

import groovy.transform.TypeChecked
import org.springframework.security.core.context.SecurityContext
import org.springframework.security.web.context.HttpRequestResponseHolder
import org.springframework.security.web.context.SecurityContextRepository

import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

import static org.springframework.security.core.context.SecurityContextHolder.createEmptyContext

@TypeChecked
class RequestBasedSecurityContextRepository implements SecurityContextRepository {

    String attributeName = "${getClass().getCanonicalName()}_SECURITY_CONTEXT"

    @Override
    boolean containsContext(HttpServletRequest request) {
        return request.getAttribute(attributeName) != null
    }

    @Override
    void saveContext(SecurityContext context, HttpServletRequest request, HttpServletResponse response) {
        writeContext(request, context);
    }

    @Override
    SecurityContext loadContext(HttpRequestResponseHolder holder) {
        return Optional.ofNullable(readContext(holder.request)).orElseGet({
            writeContext(holder.request, createEmptyContext())
        })
    }

    private SecurityContext readContext(HttpServletRequest request) {
        return request.getAttribute(attributeName) as SecurityContext
    }

    private SecurityContext writeContext(HttpServletRequest request, SecurityContext context) {
        request.setAttribute(attributeName, context)
        return context
    }
}