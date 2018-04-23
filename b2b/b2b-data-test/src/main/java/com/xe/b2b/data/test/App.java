package com.xe.b2b.data.test;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.xe.b2b.data.common.util.SpringUtils;
import com.xe.b2b.data.test.manager.FileManager;
import com.xe.b2b.data.test.manager.ServiceManager;

/**
 * Hello world!
 *
 */
public class App 
{
        static {
            // initialize Spring
            new ClassPathXmlApplicationContext("classpath*:spring.xml");
        }

        /**
         * Launch the application.
         */
        public static void main(String[] args) {

            FileManager fileManager = SpringUtils.getBean(FileManager.class);
            fileManager.startUp();

//            ServiceManager serviceManager = SpringUtils.getBean(ServiceManager.class);
//            serviceManager.startUp();
            
//            Scanner scanner = new Scanner(System.in);
//            while (!scanner.nextLine().equalsIgnoreCase("stop")) {
//                // do nothing
//            }
//            scanner.close();
//            System.exit(0);
    }
}
