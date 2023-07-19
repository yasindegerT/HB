package com.optiim.stepDefinition;

import com.optiim.utilities.DriverFactory;
import org.junit.Test;

public class TestMe {


    @Test
    public void testt() throws InterruptedException {

        DriverFactory.getDriver().get("https://www.google.com");
        Thread.sleep(5);
        DriverFactory.closeDriver();
    }
}
