import org.junit.jupiter.api.Test;
import static java.sql.Date.valueOf;
import static org.junit.jupiter.api.Assertions.*;

class TaskItemTest {

    // I decided to keep some of the old tests from project 4.
    // Some of the old tests are redundant, but I figure that additional testing can't hurt.
    // New required tests.

    @Test
    public void constructorFailsWithInvalidDueDate() {
        assertThrows(IllegalArgumentException.class, () -> new TaskItem("B", "", valueOf("")));
    }

    @Test
    public void constructorFailsWithInvalidTitle() {
        assertThrows(IllegalArgumentException.class, () -> new TaskItem("", "", valueOf("2020-12-25")));
    }

    @Test
    public void constructorSucceedsWithValidDueDate() {
        TaskItem task = new TaskItem("blublublu", "", valueOf("0001-01-01"));
        assertEquals(valueOf("0001-01-01"), task.getDate());
    }

    @Test
    public void constructorSucceedsWithValidTitle() {
        TaskItem task = new TaskItem("Xx_c00l GUY42_xX", "", valueOf("0001-01-01"));
        assertEquals("Xx_c00l GUY42_xX", task.getTitle());
    }

    @Test
    public void editingDescriptionSucceedsWithExpectedValue() {
        TaskItem task = new TaskItem("b", "hello world", valueOf("0001-01-01"));
        task.setDescription("");
        assertEquals("", task.getDescription());
    }

    @Test
    public void editingDueDateFailsWithInvalidDateFormat() {
        TaskItem task = new TaskItem("c", "", valueOf("2020-12-13"));
        assertThrows(IllegalArgumentException.class, () -> task.setDate(valueOf("rhgdnmgojkdsfrng")));
    }

    @Test
    public void editingDueDateFailsWithInvalidYYYMMDD() {
        TaskItem task = new TaskItem("e", "", valueOf("2020-12-25"));
        assertThrows(IllegalArgumentException.class, () -> task.setDate(valueOf("001-01-01")));
        assertThrows(IllegalArgumentException.class, () -> task.setDate(valueOf("0000-13-33")));
        assertEquals(task.getDate(), valueOf("2020-12-25"));
    }

    @Test
    public void editingDueDateSucceedsWithExpectedValue() {
        TaskItem task = new TaskItem("d", "", valueOf("9999-12-31"));
        task.setDate(valueOf("2020-12-25"));
        assertEquals(valueOf("2020-12-25"), task.getDate());
    }

    @Test
    public void editingTitleFailsWithEmptyString() {
        TaskItem task = new TaskItem("e", "", valueOf("2020-12-25"));
        assertThrows(IllegalArgumentException.class, () -> task.setTitle(""));
        assertEquals(task.getTitle(), "e");
    }

    @Test
    public void editingTitleSucceedsWithExpectedValue() {
        TaskItem task = new TaskItem("f", "", valueOf("9999-12-12"));
        task.setTitle(" ");
        assertEquals(" ", task.getTitle());
    }

    // Old required tests. Some may be redundant.

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