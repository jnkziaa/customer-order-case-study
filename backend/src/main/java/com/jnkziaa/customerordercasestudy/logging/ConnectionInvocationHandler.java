package com.jnkziaa.customerordercasestudy.logging;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.util.logging.Logger;

public class ConnectionInvocationHandler implements InvocationHandler {

    private Connection connection;
    private final static Logger LOGGER =
            Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

    public ConnectionInvocationHandler(Connection connection) {
        this.connection = connection;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        if(!method.getName().contains("prepareStatement")){
            LOGGER.info("connection trace: " + method.getName());
        }

        Object returnValue = method.invoke(connection, args);
        return returnValue;
    }
}
