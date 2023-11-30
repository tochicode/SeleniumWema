package wematests;

import org.apache.hc.core5.reactor.Command;
import org.testng.annotations.*;
import wemaObjects.Selector;
import wemaObjects.WemaPageObject;

public class wemaTestPage {

    // @Test => It runs a specific test
    // @BeforeSuite => Before all test in the test suit runs
    // @AfterSuite => After all test in the test suit runs
    // @BeforeClass => Runs once before any test in the class runs
    // @BeforeTest => it runs once before any method inside that class runs
    // @BeforeMethod =>  runs before each method runs

    WemaPageObject wema = new WemaPageObject();

    @BeforeTest
    public void openPage(){

        wema.setUp();
    }

    @Test(priority = 0)
    public void loginStandard(){

        wema.allUserLogin(Selector.standard);
        wema.logoutUser();
    }

    @Test(priority = 1)
    public void loginError(){

        wema.allUserLogin(Selector.error);
        wema.logoutUser();
    }

    @Test(priority = 2)
    public void loginProblem(){

        wema.allUserLogin(Selector.problem);
        wema.logoutUser();
    }

    @Test(priority = 3)
    public void loginPerformance(){

        wema.allUserLogin(Selector.performance);
        wema.logoutUser();
    }

    @Test(priority = 4)
    public void loginVisual(){

        wema.allUserLogin(Selector.visual);
        wema.logoutUser();
    }

    @Test(priority = 5)
    public void loginLocked(){

        wema.allUserLogin(Selector.locked);
    }

    @AfterTest
    public void closePage(){

        wema.teardown();
    }
}
