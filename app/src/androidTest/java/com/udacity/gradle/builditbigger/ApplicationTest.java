package com.udacity.gradle.builditbigger;

import android.app.Application;
import android.content.Context;
import android.test.ApplicationTestCase;
import android.test.ServiceTestCase;
import android.test.UiThreadTest;

import junit.framework.TestCase;

import java.lang.reflect.Method;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * <a href="http://d.android.com/tools/testing/testing_android.html">Testing Fundamentals</a>
 */
public class ApplicationTest extends TestCase implements IEndPointListener {
    public ApplicationTest() {

    }

    private Context getTestContext()
    {
        try
        {
            Method getTestContext = ServiceTestCase.class.getMethod("getTestContext");
            return (Context) getTestContext.invoke(this);
        }
        catch (final Exception exception)
        {
            exception.printStackTrace();
            return null;
        }
    }

    public void testDoInBackground()  {
        assertEquals(1,1);
    }

    EndPointTaskWarpper endPointTaskWarpper;
    CountDownLatch signal;

    protected void setUp() throws Exception {
        super.setUp();

        signal = new CountDownLatch(1);
        endPointTaskWarpper = new EndPointTaskWarpper(this);

    }

    @UiThreadTest
    public void testDownload() throws InterruptedException
    {

        endPointTaskWarpper.getJoke(getTestContext());
        signal.await(30, TimeUnit.SECONDS);

        assertTrue( "assert something meaningful here", true );
    }


    @Override
    public void processCompleted(String result){
        signal.countDown();
        assertNotSame(null, result);
        assertNotSame("", result);
        assertEquals("This is totally a funny joke", result);
    }

}