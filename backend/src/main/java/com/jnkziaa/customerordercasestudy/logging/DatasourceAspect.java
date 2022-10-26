/*ackage com.jnkziaa.customerordercasestudy.logging;

import com.mysql.cj.jdbc.ConnectionImpl;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.lang.reflect.Proxy;
import java.sql.Connection;
import java.util.logging.Logger;

@Component
@Aspect
public class DatasourceAspect {
    private final static Logger LOGGER =
            Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

    @Around("target(javax.sql.DataSource)")
    public Object logDataSourceConnectionInfo(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        LOGGER.info("Datasource Tracker + " + proceedingJoinPoint.getSignature());

        LOGGER.info(proceedingJoinPoint.proceed().toString());

        Object returnValue = proceedingJoinPoint.proceed();

        if (returnValue instanceof Connection) {
            Connection con = (Connection) Proxy.newProxyInstance(
                    ConnectionImpl.class.getClassLoader(),
                    new Class[]{Connection.class},
                    new ConnectionInvocationHandler((Connection) returnValue));

            return con;
        }

        return returnValue;
    }
}
*
 */
