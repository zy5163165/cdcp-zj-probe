package org.asb.mule.probe.framework;

import org.springframework.context.support.AbstractXmlApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import java.io.File;

/**
 * Author: Ronnie.Chen
 * Date: 13-7-18
 * Time: 下午6:00
 * rongrong.chen@alcatel-sbell.com.cn
 */
public class Main {
    public static void main(String[] args) {
        String configFilePath = "interfaces.xml";
        AbstractXmlApplicationContext applicationContext = null;
        if (args != null && args.length > 0)
            configFilePath = args[0];
        String[] locations =  configFilePath.split(",|;|\\s");
        if (locations != null && locations.length == 1) {
            String xml = locations[0] ;
            File file = new File(xml);
            if (file.exists() && file.isFile() ) {
                System.out.println("Init by FileSystemXmlApplicationContext");
                applicationContext = new FileSystemXmlApplicationContext(locations);
            }
        }
        if (applicationContext == null) {
            System.out.println("Init by ClassPathXmlApplicationContext");
            applicationContext = new ClassPathXmlApplicationContext(locations);
        }
        System.out.println("Spring init finished !");
        if (args != null && args.length > 1) {
            String commandbeanId = args[1];
            String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();
            for (int i = 0; i < beanDefinitionNames.length; i++) {
                String beanDefinitionName = beanDefinitionNames[i];
                if (beanDefinitionName.equals(commandbeanId.trim())) {
                    Object bean = applicationContext.getBean(beanDefinitionName);
                    if (bean instanceof CommandBean) {
                        System.out.println("Execute CommandBean : "+bean);
                        ((CommandBean) bean).execute();
                    }
                }
            }
        }
    }
}
