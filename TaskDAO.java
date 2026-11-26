import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class TaskDAO {

    public void addTask(Task task) {

        String sql =
        "INSERT INTO tasks(title,priority,status,due_date) VALUES(?,?,?,?)";

        try {

            Connection con =
                    DBConnection.getConnection();

            PreparedStatement ps =
                    con.prepareStatement(sql);

            ps.setString(1, task.getTitle());
            ps.setString(2, task.getPriority());
            ps.setString(3, task.getStatus());
            ps.setString(4, task.getDueDate());

            int rows = ps.executeUpdate();
System.out.println("Rows inserted: " + rows);

            System.out.println("Task Added!");

        }
        catch(Exception e) {
            System.out.println(e.getMessage());
        }
    }
    public void viewTasks() {

    String sql = "SELECT * FROM tasks";

    try {

        Connection con =
                DBConnection.getConnection();

        PreparedStatement ps =
                con.prepareStatement(sql);

        ResultSet rs =
                ps.executeQuery();

        while(rs.next()) {

            System.out.println(
                rs.getInt("task_id") + " | " +
                rs.getString("title") + " | " +
                rs.getString("priority") + " | " +
                rs.getString("status") + " | " +
                rs.getDate("due_date")
            );
        }

    }
    catch(Exception e) {
        System.out.println(e.getMessage());
    }
}
public void deleteTask(int taskId) {

    String sql =
        "DELETE FROM tasks WHERE task_id = ?";

    try {

        Connection con =
                DBConnection.getConnection();

        PreparedStatement ps =
                con.prepareStatement(sql);

        ps.setInt(1, taskId);

        int rows = ps.executeUpdate();

        System.out.println(
                rows + " task deleted."
        );

    }
    catch(Exception e) {
        System.out.println(e.getMessage());
    }
}
public void markCompleted(int taskId) {

    String sql =
        "UPDATE tasks SET status='Completed' WHERE task_id=?";

    try {

        Connection con =
                DBConnection.getConnection();

        PreparedStatement ps =
                con.prepareStatement(sql);

        ps.setInt(1, taskId);

        int rows = ps.executeUpdate();

        System.out.println(
                rows + " task updated."
        );

    }
    catch(Exception e) {
        System.out.println(e.getMessage());
    }
}
public void searchTask(String keyword) {

    String sql =
        "SELECT * FROM tasks WHERE title LIKE ?";

    try {

        Connection con =
                DBConnection.getConnection();

        PreparedStatement ps =
                con.prepareStatement(sql);

        ps.setString(1, "%" + keyword + "%");

        ResultSet rs =
                ps.executeQuery();

        while(rs.next()) {

            System.out.println(
                rs.getInt("task_id") + " | " +
                rs.getString("title")
            );
        }

    }
    catch(Exception e) {
        System.out.println(e.getMessage());
    }
}
public String getAllTasks() {

    StringBuilder sb = new StringBuilder();

    String sql = "SELECT * FROM tasks";

    try {

        Connection con =
                DBConnection.getConnection();

        PreparedStatement ps =
                con.prepareStatement(sql);

        ResultSet rs =
                ps.executeQuery();

        while(rs.next()) {

            sb.append(
                    rs.getInt("task_id")
            ).append(" | ");

            sb.append(
                    rs.getString("title")
            ).append(" | ");

            sb.append(
                    rs.getString("priority")
            ).append(" | ");

            sb.append(
                    rs.getString("status")
            ).append("\n");
        }
    }
    catch(Exception e) {
        System.out.println(e.getMessage());
    }

    return sb.toString();
}
public String searchTaskGUI(String keyword) {

    StringBuilder sb = new StringBuilder();

    String sql = "SELECT * FROM tasks WHERE title LIKE ?";

    try {

        Connection con = DBConnection.getConnection();

        PreparedStatement ps =
                con.prepareStatement(sql);

        ps.setString(1, "%" + keyword + "%");

        ResultSet rs = ps.executeQuery();

        while(rs.next()) {

            sb.append(rs.getInt("task_id"))
              .append(" | ")
              .append(rs.getString("title"))
              .append(" | ")
              .append(rs.getString("priority"))
              .append(" | ")
              .append(rs.getString("status"))
              .append("\n");
        }
    }
    catch(Exception e) {
        System.out.println(e.getMessage());
    }

    return sb.toString();
}
}