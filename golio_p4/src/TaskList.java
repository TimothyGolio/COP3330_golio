import java.util.ArrayList;

public class TaskList {
    private ArrayList<TaskItem> list = new ArrayList<TaskItem>();

    public TaskList() {
    }

    public void addListItem(TaskItem task){
        list.add(task);
    }

    public int size(){
        return list.size();
    }

    public TaskItem get(int index){
        return list.get(index);
    }
}
