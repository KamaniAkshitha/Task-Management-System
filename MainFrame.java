import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainFrame extends JFrame {

    JTextField titleField;
    JComboBox<String> priorityBox;
    JTextField dueDateField;

    JButton addButton;
    JButton viewButton;
    JButton deleteButton;
    JButton completeButton;
    JButton searchButton;

    JTextArea displayArea;

    public MainFrame() {

        setTitle("Task Manager");
        setSize(700, 450);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        setLayout(new FlowLayout());

        add(new JLabel("Task Title:"));

        titleField = new JTextField(20);
        add(titleField);
        add(new JLabel("Due Date (YYYY-MM-DD):"));

dueDateField = new JTextField(10);
add(dueDateField);

        add(new JLabel("Priority:"));

        priorityBox = new JComboBox<>(
                new String[]{"High", "Medium", "Low"}
        );
        add(priorityBox);

        addButton = new JButton("Add Task");
        add(addButton);

        viewButton = new JButton("View Tasks");
        add(viewButton);

        deleteButton = new JButton("Delete Task");
        add(deleteButton);

        completeButton = new JButton("Mark Complete");
        add(completeButton);

        searchButton = new JButton("Search");
        add(searchButton);

        displayArea = new JTextArea(15, 50);
        displayArea.setEditable(false);

        add(new JScrollPane(displayArea));

        // ADD TASK
        addButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                String title = titleField.getText();

                String priority =
                        priorityBox.getSelectedItem().toString();

                Task task = new Task(
    0,
    title,
    priority,
    "Pending",
    dueDateField.getText()
);
                TaskDAO dao = new TaskDAO();

                dao.addTask(task);

                displayArea.setText(
                        dao.getAllTasks()
                );

                JOptionPane.showMessageDialog(
                        null,
                        "Task Added Successfully!"
                );

                titleField.setText("");
            }
        });

        // VIEW TASKS
        viewButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                TaskDAO dao = new TaskDAO();

                displayArea.setText(
                        dao.getAllTasks()
                );
            }
        });

        // DELETE TASK
        deleteButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                String id =
                        JOptionPane.showInputDialog(
                                "Enter Task ID to Delete"
                        );

                TaskDAO dao = new TaskDAO();

                dao.deleteTask(
                        Integer.parseInt(id)
                );

                displayArea.setText(
                        dao.getAllTasks()
                );

                JOptionPane.showMessageDialog(
                        null,
                        "Task Deleted!"
                );
            }
        });

        // MARK COMPLETE
        completeButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                String id =
                        JOptionPane.showInputDialog(
                                "Enter Task ID"
                        );

                TaskDAO dao = new TaskDAO();

                dao.markCompleted(
                        Integer.parseInt(id)
                );

                displayArea.setText(
                        dao.getAllTasks()
                );

                JOptionPane.showMessageDialog(
                        null,
                        "Task Updated!"
                );
            }
        });

        // SEARCH TASK
        searchButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                String keyword =
                        JOptionPane.showInputDialog(
                                "Enter Task Title"
                        );

                TaskDAO dao = new TaskDAO();

                displayArea.setText(
                        dao.searchTaskGUI(keyword)
                );
            }
        });

        setVisible(true);
    }
}