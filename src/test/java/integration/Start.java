package integration;


import org.junit.platform.launcher.Launcher;
import org.junit.platform.launcher.LauncherDiscoveryRequest;
import org.junit.platform.launcher.TestPlan;
import org.junit.platform.launcher.core.LauncherDiscoveryRequestBuilder;
import org.junit.platform.launcher.core.LauncherFactory;
import org.junit.platform.launcher.listeners.SummaryGeneratingListener;


import java.io.PrintWriter;

import static org.junit.platform.engine.discovery.DiscoverySelectors.selectClass;

public class Start {

    public static void main(String[] args) {

        new Thread(new Runnable() {
            @Override
            public void run() {
                runTest("chrome");
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                runTest("firefox");
            }
        }).start();

//        runTest("chrome");
//        runTest("firefox");
    }


    public static void runTest(String browser) {

        System.out.println(browser);

        SummaryGeneratingListener listener = new SummaryGeneratingListener();

        LauncherDiscoveryRequest request = LauncherDiscoveryRequestBuilder.request()
                .selectors(selectClass(MainPageTest.class))
                .configurationParameter("browser", browser)
                .configurationParameter("junit.jupiter.execution.parallel.enabled", "true")
                .configurationParameter("junit.jupiter.execution.parallel.mode.default", "concurrent")
                .build();

        Launcher launcher = LauncherFactory.create();
        TestPlan testPlan = launcher.discover(request);
        launcher.registerTestExecutionListeners(listener);
        launcher.execute(request);
        listener.getSummary().printTo(new PrintWriter(System.out));

        System.out.println(browser);
    }


}
