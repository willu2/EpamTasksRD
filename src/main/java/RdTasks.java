import jav.collect.TasksCollections;
import jav.errorexception.TaskExeption;
import jav.errorexception.datacreator.RandDataCreator;
import jav.threadsplane.PlaneProducer;
import jav.threadsplane.Strip;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @author Dmytro [RD]
 */

public class RdTasks {


    public static void main(String[] args)  {

        TasksCollections tasksCollections = new TasksCollections();
        tasksCollections.showTaskResult();

        TaskExeption taskExeption = new TaskExeption();
        taskExeption.showResults();

        BlockingQueue<Integer> queue = new LinkedBlockingQueue<Integer>(5);
        new Thread(new PlaneProducer(queue)).start();
      //  new Thread(new Strip(queue)).start();

    }
}

