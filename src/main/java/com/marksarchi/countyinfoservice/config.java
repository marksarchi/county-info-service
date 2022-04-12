package com.marksarchi.countyinfoservice;

import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.test.context.support.TestPropertySourceUtils;

//@Configuration
//@ContextConfiguration(initializers = config.Initializer.class)
public class config {
    public static class Initializer implements ApplicationContextInitializer<ConfigurableApplicationContext> {

        @Override
        public void initialize(ConfigurableApplicationContext applicationContext) {

            TestPropertySourceUtils.addInlinedPropertiesToEnvironment(
                    applicationContext,
                    "https.protocols=", "TLSv1,TLSv1.1,TLSv1.2"

            );
        }
    }
}
