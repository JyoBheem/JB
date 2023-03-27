package com.myntra.jb;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;

import java.io.File;
import java.io.IOException;


public class Listeners extends MainPage implements ITestListener {
    public void onTestStart(ITestContext result){
        System.out.println("Starting the execution");
    }
    public void onTestSuccess(ITestContext result){
        System.out.println("Test executed successfully");
    }
    public void onTestFailure(ITestContext result) throws IOException {
        System.out.println("Test failed");
//        TakesScreenshot ts = (TakesScreenshot) driver;
//        File srcFile = ts.getScreenshotAs(OutputType.FILE);
//        File destFile =  new File(System.getProperty("user.dir")+"/result/failed.png");
//        FileUtils.copyFile(srcFile,destFile);
//        test.log(LogStatus.FAIL,"Test is passed");
    }
}
