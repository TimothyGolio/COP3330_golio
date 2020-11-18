import org.junit.jupiter.api.Test;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Date;
import static java.sql.Date.valueOf;
import static org.junit.jupiter.api.Assertions.*;

class TaskListTest {
    @Test
    public void addingTaskItemsIncreasesSize(){
        TaskItem task = new TaskItem("a", "b", valueOf("2020-12-13"));
        TaskList list = new TaskList();
        int initialSize = list.size();
        list.addListItem(task);
        assertEquals(list.size(), initialSize + 1);
        TaskItem task2 = new TaskItem("a", "", valueOf("2020-2-14"));
        list.addListItem(task2);
        assertEquals(list.size(), initialSize + 2);
    }

    @Test
    public void completingTaskItemChangesStatus(){
        TaskItem task = new TaskItem("a", "b", valueOf("2020-12-13"));
        TaskList list = new TaskList();
        list.addListItem(task);
        boolean result = task.isCompleted();
        assertFalse(result);
        list.setIndexCompleted(0, true);
        result = task.isCompleted();
        assertTrue(result);
        TaskItem task2 = new TaskItem("d", "", valueOf("2020-2-4"));
        list.addListItem(task2);
        result = task2.isCompleted();
        assertFalse(result);
        list.setIndexCompleted(1, true);
        result = task2.isCompleted();
        assertTrue(result);
    }

    @Test
    public void completingTaskItemFailsWithInvalidIndex(){
        TaskItem task = new TaskItem("a", "b", valueOf("2020-12-13"));
        TaskList list = new TaskList();
        list.addListItem(task);
        assertThrows(IndexOutOfBoundsException.class, () -> list.setIndexCompleted(1000, true));
        assertThrows(IndexOutOfBoundsException.class, () -> list.setIndexCompleted(1, true));
        assertThrows(IndexOutOfBoundsException.class, () -> list.setIndexCompleted(-1, true));
    }

    @Test
    public void editingTaskItemChangesValues(){
        TaskItem task = new TaskItem("a", "b", valueOf("2020-12-13"));
        TaskList list = new TaskList();
        list.addListItem(task);
        try {
            list.editTaskTitle(0,"changed!!!!gjdfsnmbjs");
            list.editTaskDescription(0, "abcdefghijklmnopqrstuvwxyz");
            list.editTaskDate(0, valueOf("0001-1-1"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        TaskItem testTask = list.get(0);
        assertEquals(testTask.getTitle(), "changed!!!!gjdfsnmbjs");
        assertEquals(testTask.getDescription(), "abcdefghijklmnopqrstuvwxyz");
        assertEquals(testTask.getDate(), valueOf("0001-1-1"));
    }

    @Test
    public void editingTaskItemDescriptionChangesValue(){
        TaskItem task = new TaskItem("a", "ergdfrgeadrbed_   _dfvs788645shfjh", valueOf("2020-12-13"));
        TaskList list = new TaskList();
        list.addListItem(task);
        try {
            list.editTaskDescription(0, "");
        } catch (Exception e) {
            e.printStackTrace();
        }
        TaskItem testTask = list.get(0);
        assertEquals(testTask.getDescription(), "");
    }

    @Test
    public void editingTaskItemDescriptionFailsWithInvalidIndex(){
        TaskItem task = new TaskItem("a", "ergdfrgeadrbed_   _dfvs788645shfjh", valueOf("2020-12-13"));
        TaskList list = new TaskList();
        list.addListItem(task);
        assertThrows(IndexOutOfBoundsException.class, () -> list.editTaskDescription(1000, "aaaaa"));
        assertThrows(IndexOutOfBoundsException.class, () -> list.editTaskDescription(1, "b_b_b"));
        assertThrows(IndexOutOfBoundsException.class, () -> list.editTaskDescription(-1, "          "));
        assertEquals(task.getDescription(), "ergdfrgeadrbed_   _dfvs788645shfjh");
    }

    @Test
    public void editingTaskItemDueDateChangesValue(){
        TaskItem task = new TaskItem("a", "ergdfrgeadrbed_   _dfvs788645shfjh", valueOf("2020-12-13"));
        TaskList list = new TaskList();
        list.addListItem(task);
        try {
            list.editTaskDate(0, valueOf("0001-01-01"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        TaskItem testTask = list.get(0);
        assertEquals(testTask.getDate(), valueOf("0001-01-01"));
    }

    @Test
    public void editingTaskItemDueDateFailsWithInvalidIndex(){
        TaskItem task = new TaskItem("a", "ergdfrgeadrbed_   _dfvs788645shfjh", valueOf("2020-12-13"));
        TaskList list = new TaskList();
        list.addListItem(task);
        assertThrows(IndexOutOfBoundsException.class, () -> list.editTaskDate(1000, valueOf("1984-01-01")));
        assertThrows(IndexOutOfBoundsException.class, () -> list.editTaskDate(1, valueOf("2077-12-13")));
        assertThrows(IndexOutOfBoundsException.class, () -> list.editTaskDate(-1, valueOf("1998-11-15")));
        assertEquals(task.getDate(), valueOf("2020-12-13"));
    }

    @Test
    public void editingTaskItemTitleChangesValue(){
        TaskItem task = new TaskItem("title", "ergdfrgeadrbed_   _dfvs788645shfjh", valueOf("2020-12-13"));
        TaskList list = new TaskList();
        list.addListItem(task);
        try {
            list.editTaskTitle(0, "title2");
        } catch (Exception e) {
            e.printStackTrace();
        }
        TaskItem testTask = list.get(0);
        assertEquals(testTask.getTitle(), "title2");
    }

    @Test
    public void editingTaskItemTitleFailsWithInvalidIndex(){
        TaskItem task = new TaskItem("a", "ergdfrgeadrbed_   _dfvs788645shfjh", valueOf("2020-12-13"));
        TaskList list = new TaskList();
        list.addListItem(task);
        assertThrows(IndexOutOfBoundsException.class, () -> list.editTaskTitle(1000, "aaaaa"));
        assertThrows(IndexOutOfBoundsException.class, () -> list.editTaskTitle(1, "b_b_b"));
        assertThrows(IndexOutOfBoundsException.class, () -> list.editTaskTitle(-1, "          "));
        assertEquals(task.getTitle(), "a");
    }

    @Test
    public void gettingTaskItemDescriptionFailsWithInvalidIndex(){
        TaskItem task = new TaskItem("a", "ergdfrgeadrbed_   _dfvs788645shfjh", valueOf("2020-12-13"));
        TaskList list = new TaskList();
        list.addListItem(task);
        assertThrows(IndexOutOfBoundsException.class, () -> list.getTaskDescription(1000));
        assertThrows(IndexOutOfBoundsException.class, () -> list.getTaskDescription(1));
        assertThrows(IndexOutOfBoundsException.class, () -> list.getTaskDescription(-1));
    }

    @Test
    public void gettingTaskItemDescriptionSucceedsWithValidIndex(){
        TaskItem task = new TaskItem("a", "ergdfrgeadrbed_   _dfvs788645shfjh", valueOf("2020-12-13"));
        TaskList list = new TaskList();
        list.addListItem(task);
        String description = list.getTaskDescription(0);
        assertEquals(description, "ergdfrgeadrbed_   _dfvs788645shfjh");
    }

    @Test
    public void gettingTaskItemDueDateFailsWithInvalidIndex(){
        TaskItem task = new TaskItem("a", "ergdfrgeadrbed_   _dfvs788645shfjh", valueOf("2020-12-13"));
        TaskList list = new TaskList();
        list.addListItem(task);
        assertThrows(IndexOutOfBoundsException.class, () -> list.getTaskDate(1000));
        assertThrows(IndexOutOfBoundsException.class, () -> list.getTaskDate(1));
        assertThrows(IndexOutOfBoundsException.class, () -> list.getTaskDate(-1));
    }

    @Test
    public void gettingTaskItemDueDateSucceedsWithValidIndex(){
        TaskItem task = new TaskItem("a", "ergdfrgeadrbed_   _dfvs788645shfjh", valueOf("2020-12-13"));
        TaskList list = new TaskList();
        list.addListItem(task);
        Date date = list.getTaskDate(0);
        assertEquals(date, valueOf("2020-12-13"));
    }

    @Test
    public void gettingTaskItemTitleFailsWithInvalidIndex(){
        TaskItem task = new TaskItem("a", "ergdfrgeadrbed_   _dfvs788645shfjh", valueOf("2020-12-13"));
        TaskList list = new TaskList();
        list.addListItem(task);
        assertThrows(IndexOutOfBoundsException.class, () -> list.getTaskTitle(1000));
        assertThrows(IndexOutOfBoundsException.class, () -> list.getTaskTitle(1));
        assertThrows(IndexOutOfBoundsException.class, () -> list.getTaskTitle(-1));
    }

    @Test
    public void gettingTaskItemTitleSucceedsWithValidIndex(){
        TaskItem task = new TaskItem("a", "ergdfrgeadrbed_   _dfvs788645shfjh", valueOf("2020-12-13"));
        TaskList list = new TaskList();
        list.addListItem(task);
        String title = list.getTaskTitle(0);
        assertEquals(title, "a");
    }

    @Test
    public void newTaskListIsEmpty(){
        TaskList list = new TaskList();
        assertEquals(list.size(), 0);
        assertThrows(IndexOutOfBoundsException.class, () -> list.getTaskTitle(0));
    }

    @Test
    public void removingTaskItemsDecreasesSize(){
        TaskItem task = new TaskItem("a", "ergdfrgeadrbed_   _dfvs788645shfjh", valueOf("2020-12-13"));
        TaskList list = new TaskList();
        list.addListItem(task);
        int initialSize = list.size();
        list.removeListItem(0);
        assertEquals(list.size(), initialSize - 1);
    }

    @Test
    public void removingTaskItemsFailsWithInvalidIndex(){
        TaskItem task = new TaskItem("a", "ergdfrgeadrbed_   _dfvs788645shfjh", valueOf("2020-12-13"));
        TaskList list = new TaskList();
        list.addListItem(task);

        assertThrows(IndexOutOfBoundsException.class, () -> list.removeListItem(1000));
        assertThrows(IndexOutOfBoundsException.class, () -> list.removeListItem(1));
        assertThrows(IndexOutOfBoundsException.class, () -> list.removeListItem(-1));

        assertEquals(task.getDescription(), list.getTaskDescription(0));
    }


    @Test
    public void savedTaskListCanBeLoaded(){
        TaskItem task = new TaskItem("a", "ergdfrgeadrbed_   _dfvs788645shfjh", valueOf("2020-12-13"));
        TaskList list = new TaskList();
        list.addListItem(task);
        try {
            list.saveList("example.txt");
        } catch (IOException e) {
        }
        list.removeListItem(0);
        assertEquals(list.size(), 0);
        assertThrows(IndexOutOfBoundsException.class, () -> list.getTaskTitle(0));

        try {
            list.loadList("example.txt", true);
        } catch (FileNotFoundException e) {
        }

        assertEquals(list.getTaskDescription(0), "ergdfrgeadrbed_   _dfvs788645shfjh");
        assertEquals(list.getTaskDate(0), valueOf("2020-12-13"));
        assertEquals(list.getTaskTitle(0), "a");
    }

    @Test
    public void uncompletingTaskItemChangesStatus(){
        TaskItem task = new TaskItem("a", "b", valueOf("2020-12-13"));
        TaskList list = new TaskList();
        list.addListItem(task);
        boolean result = task.isCompleted();
        assertFalse(result);
        list.setIndexCompleted(0, true);
        result = task.isCompleted();
        assertTrue(result);
        TaskItem task2 = new TaskItem("d", "", valueOf("2020-2-4"));
        list.addListItem(task2);
        result = task2.isCompleted();
        assertFalse(result);
        list.setIndexCompleted(1, true);
        result = task2.isCompleted();
        assertTrue(result);
        list.setIndexCompleted(0, false);
        result = task.isCompleted();
        assertFalse(result);
        list.setIndexCompleted(1, false);
        result = task.isCompleted();
        assertFalse(result);
    }

    @Test
    public void uncompletingTaskItemFailsWithInvalidIndex(){
        TaskItem task = new TaskItem("a", "b", valueOf("2020-12-13"));
        TaskList list = new TaskList();
        list.addListItem(task);
        TaskItem task2 = new TaskItem("b", "a", valueOf("2020-12-13"));
        list.addListItem(task2);
        assertThrows(IndexOutOfBoundsException.class, () -> list.setIndexCompleted(1000, true));
        assertThrows(IndexOutOfBoundsException.class, () -> list.setIndexCompleted(2, true));
        assertThrows(IndexOutOfBoundsException.class, () -> list.setIndexCompleted(-1, true));
        list.setIndexCompleted(1, true);
        assertThrows(IndexOutOfBoundsException.class, () -> list.setIndexCompleted(1000, false));
        assertThrows(IndexOutOfBoundsException.class, () -> list.setIndexCompleted(2, false));
        assertThrows(IndexOutOfBoundsException.class, () -> list.setIndexCompleted(-1, false));
        assertThrows(IllegalArgumentException.class, () -> list.setIndexCompleted(0, false));
    }
}