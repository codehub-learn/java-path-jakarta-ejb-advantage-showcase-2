package gr.codelearn.javapathjakartaejbadvantageshowcase.util;


import lombok.extern.slf4j.Slf4j;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.util.Hashtable;

@Slf4j
public class JNDILookup {
    private JNDILookup(){}
    /*private static Context createInitialContext() throws NamingException {
        Hashtable<String,String> jndiProperties = new Hashtable<>();
        jndiProperties.put(Context.URL_PKG_PREFIXES,"org.jboss.ejb.client.naming");
        return new InitialContext(jndiProperties);
    }

    public static Object beanInvocation(String beanName, String viewClassName, String... args) {
        try {
            Context initialContext = createInitialContext();
            //final String appName = "";
            final String moduleName = "advantage-ejb";
            final String stateful = args.length > 0 ? args[0] : "";
            return  initialContext.lookup(
                    "ejb:" + "/" + moduleName + "/" + beanName + "!" + viewClassName + stateful
            );

        } catch (NamingException e) {
            throw new RuntimeException(e);
        }
    }*/
}
