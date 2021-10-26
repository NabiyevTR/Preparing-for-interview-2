package ru.ntr.preparing.hw06;

import lombok.extern.java.Log;
import org.apache.catalina.LifecycleException;
import org.apache.catalina.WebResourceRoot;
import org.apache.catalina.core.StandardContext;
import org.apache.catalina.startup.Tomcat;
import org.apache.catalina.webresources.DirResourceSet;
import org.apache.catalina.webresources.StandardRoot;

import javax.servlet.ServletException;
import java.io.File;

@Log
public class Server {

    private final Tomcat tomcat;
    private final StandardContext ctx;

    private final static String WEB_APP_LOCATION = "src/main/java/ru/ntr/preparing/hw06";
    private final static String ADDITIONAL_WEB_INFO_CLASSES = "target/classes";
    private final static String RESOURCE_LOCATION = "/WEB-INF/classes";
    private final static int PORT = 8080;

    public Server() throws ServletException {

        tomcat = new Tomcat();
        tomcat.setPort(PORT);
        ctx = (StandardContext) tomcat.addWebapp("/", new File(WEB_APP_LOCATION).getAbsolutePath());
        log.info("Configuring app with basedir: " + new File("./" + WEB_APP_LOCATION).getAbsolutePath());
        File additionWebInfClasses = new File(ADDITIONAL_WEB_INFO_CLASSES);
        WebResourceRoot resources = new StandardRoot(ctx);
        resources.addPreResources(new DirResourceSet(resources, RESOURCE_LOCATION,
                additionWebInfClasses.getAbsolutePath(), "/"));


        ctx.setResources(resources);
    }

    public void start() throws LifecycleException {
        tomcat.start();
        tomcat.getServer().await();
    }
}
