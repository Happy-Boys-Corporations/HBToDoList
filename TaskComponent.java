import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class TaskComponent extends JPanel implements ActionListener {

    private JCheckBox checkBox;
    private JTextPane taskfield;
    private JButton delButton;

    public JTextPane getTaskField() {
        return taskfield;
    }

    private JPanel parentPanel;

    public TaskComponent(JPanel parenPanel) {
        this.parentPanel = parentPanel;
        taskfield = new JTextPane();
        taskfield.setPreferredSize(CommonConstants.TASKFIELD_SIZE);
        taskfield.setContentType("text/html");
        checkBox = new JCheckBox();
        checkBox.setPreferredSize(CommonConstants.CHECKBOX_SIZE);
        checkBox.setActionListener(this);
        delButton = new JButton("X");
        delButton.setPreferredSize(CommonConstants.DELBUTTON_SIZE);

        add(checkBox);
        add(taskfield);
        add(delButton);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (checkBox.isSelected()) {
            String taskText = taskfield.getText().replaceAll("<[^>]*", "");
            taskfield.setText("<html><s>" + taskText + "</s></html>");
        } else if (!checkBox.isSelected()) {
            String taskText = taskfield.getText().replaceAll("<[^>]*", "");
            taskfield.setText(taskText);
        }
    }
}
