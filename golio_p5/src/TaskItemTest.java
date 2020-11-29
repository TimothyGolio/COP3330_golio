import org.junit.jupiter.api.Test;
import static java.sql.Date.valueOf;
import static org.junit.jupiter.api.Assertions.*;

class TaskItemTest {

    @Test
    public void creatingTaskItemFailsWithInvalidDueDate() {
        assertThrows(IllegalArgumentException.class, () -> new TaskItem("A", "", valueOf("")));
    }

    @Test
    public void creatingTaskItemFailsWithInvalidTitle() {
        assertThrows(IllegalArgumentException.class, () -> new TaskItem("", "", valueOf("2020-12-3")));
    }

    @Test
    public void creatingTaskItemSucceedsWithValidDueDate() {
        TaskItem task = new TaskItem("1!1!1!rgd", "", valueOf("9999-12-31"));
        assertEquals(valueOf("9999-12-31"), task.getDate());
    }

    @Test
    public void creatingTaskItemSucceedsWithValidTitle() {
        TaskItem task = new TaskItem("a_", "", valueOf("9999-12-31"));
        assertEquals("a_", task.getTitle());
    }

    @Test
    public void settingTaskItemDueDateFailsWithInvalidDate() {
        TaskItem task = new TaskItem("A", "", valueOf("2020-12-13"));
        assertThrows(IllegalArgumentException.class, () -> task.setDate(valueOf("rhgdnmgojkdsfrng")));
    }

    @Test
    public void settingTaskItemDueDateSucceedsWithValidDate() {
        TaskItem task = new TaskItem("a", "", valueOf("9999-12-31"));
        task.setDate(valueOf("2020-12-13"));
        assertEquals(valueOf("2020-12-13"), task.getDate());
    }

    @Test
    public void settingTaskItemTitleFailsWithInvalidTitle() {
        TaskItem task = new TaskItem("A", "", valueOf("2020-12-13"));
        assertThrows(IllegalArgumentException.class, () -> task.setTitle(""));
    }

    @Test
    public void settingTaskItemTitleSucceedsWithValidTitle() {
        TaskItem task = new TaskItem("a", "", valueOf("9999-12-31"));
        task.setTitle(" ");
        assertEquals(" ", task.getTitle());

    }
}