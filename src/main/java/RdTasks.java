import jav.errorexception.datacreator.RandDataCreator;

/**
 * @author Dmytro [RD]
 */

public class RdTasks {


    public static void main(String[] args)  {

//        TasksCollections tasksCollections = new TasksCollections();
//        tasksCollections.showTaskResult();

        RandDataCreator randDataCreator = new RandDataCreator();
        System.out.println(randDataCreator.facultyCreator());

    }
}

