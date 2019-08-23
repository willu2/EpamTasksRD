package jav.collect;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URISyntaxException;

import static org.testng.Assert.*;

public class TasksCollectionsTest {

    TasksCollections tasksCollections = new TasksCollections();

    @Test
    public void testReverceStack() {

        int checkNumber =  654321;
        int loadNumber =  tasksCollections.reverceStack(123456);
        Assert.assertEquals(loadNumber, checkNumber);
    }

}