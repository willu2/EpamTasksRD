import jav.collect.TasksCollections;
import jav.errorexception.TaskExeption;
import jav.errorexception.datacreator.RandDataCreator;

/**
 * @author Dmytro [RD]
 */

public class RdTasks {


    public static void main(String[] args)  {

        TasksCollections tasksCollections = new TasksCollections();
        tasksCollections.showTaskResult();

        TaskExeption taskExeption = new TaskExeption();
        taskExeption.showResults();

    }
}

