import java.awt.Taskbar;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class ToDoListGui extends JFrame implements ActionListener {

    private JPanel taskPanel, taskComponentPanel;

    public ToDoListGui() {
        super("To Do List App");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setPreferredSize(CommonConstants.GUI_SIZE);
        pack();
        setLocationRelativeTo(null);
        setResizable(false);
        setLayout(null);

        addGuiComponent();
    }

    private void addGuiComponent() {
        JLabel bannerLabel = new JLabel("To Do List");
        bannerLabel.setBounds(
            (CommonConstants.GUI_SIZE.width -
                bannerLabel.getPreferredSize().width) /
            2,
            15,
            CommonConstants.BANNER_SIZE.width,
            CommonConstants.BANNER_SIZE.height
        );

        taskPanel = new JPanel();
        taskComponentPanel = new JPanel();
        taskComponentPanel.setLayout(
            new BoxLayout(taskComponentPanel, BoxLayout.Y_AXIS)
        );
        taskPanel.add(taskComponentPanel);
        JScrollPane scroll = new JScrollPane(taskPanel);
        scroll.setBounds(
            8,
            70,
            CommonConstants.TASKPANEL_SIZE.width,
            CommonConstants.TASKPANEL_SIZE.height
        );
        scroll.setMaximumSize(CommonConstants.TASKPANEL_SIZE);
        scroll.setVerticalScrollBarPolicy(
            JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED
        );
        scroll.setHorizontalScrollBarPolicy(
            JScrollPane.HORIZONTAL_SCROLLBAR_NEVER
        );

        JButton addTask = new JButton("Add Task");
        addTask.setBounds(
            -5,
            CommonConstants.GUI_SIZE.height - 88,
            CommonConstants.ADDTASK_BUTTON.width,
            CommonConstants.ADDTASK_BUTTON.height
        );
        addTask.addActionListener(this);
        this.getContentPane().add(bannerLabel);
        this.getContentPane().add(scroll);
        this.getContentPane().add(addTask);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        if (command.equalsIgnoreCase("Add Task")) {
            TaskComponent taskComponent = new TaskComponent(taskComponentPanel);
            taskComponentPanel.add(taskComponent);
            taskComponent.getTaskField().requestFocus();
            repaint();
            revalidate();
        }
    }
}
