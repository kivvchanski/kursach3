package com.example.kursaaach.service;

import org.springframework.stereotype.Component;

@Component
public class SessionManager {
    private final ThreadLocal<Session> sessionThreadLocal = ThreadLocal.withInitial(Session::new);

    public Session getSession() {
        return sessionThreadLocal.get();
    }

    public void setSession(String username, String role) {
        sessionThreadLocal.set(new Session(username, role));
    }

    public void invalidateSession() {
        sessionThreadLocal.remove();
    }
}