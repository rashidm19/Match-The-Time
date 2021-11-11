import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CreateGroup implements ActionListener {

    private JFrame frame;
    private JTextField groupName;
    private JButton submitButton;
    private JButton cancelButton;
    private JButton returnButton;

    private LogIn loginController;
    private GroupController groupController;
    private CalendarController calendarController;
    private StudentController studentController;
    private String studentUsername;

    public CreateGroup(LogIn loginController, GroupController groupController, CalendarController calendarController,
                       StudentController studentController, String studentUsername){

        this.loginController = loginController;
        this.groupController = groupController;
        this.calendarController = calendarController;
        this.studentController = studentController;
        this.studentUsername = studentUsername;

        this.frame = new JFrame();
        this.frame.setLayout(null);
        this.frame.setSize(500,500);

        JLabel groupNameLabel = new JLabel("Group Name: ");
        groupNameLabel.setBounds(110,50,115, 25);
        this.frame.add(groupNameLabel);

        this.groupName = new JTextField();
        this.groupName.setBounds(210,50,165,25);
        this.frame.add(this.groupName);

        this.submitButton = new JButton("Submit");
        this.submitButton.setBounds(150,100,80,25);
        this.submitButton.addActionListener(this);
        this.frame.add(this.submitButton);

        this.cancelButton = new JButton("Cancel");
        this.cancelButton.setBounds(250,100,80,25);
        this.cancelButton.addActionListener(this);
        this.frame.add(this.cancelButton);



        this.frame.setVisible(true);
    }

    public void actionPerformed(ActionEvent e){
        if(e.getSource() == this.submitButton){
            this.returnButton = new JButton("Return");
            this.returnButton.setBounds(200,130,80,25);
            this.frame.add(this.returnButton);

            JLabel validGroupCreation = new JLabel("The group created successfully! Your groupId is ###");
            //this.groupName.getText();
            validGroupCreation.setBounds(80,110,350,250);
            this.frame.add(validGroupCreation);
            this.frame.revalidate();
            this.frame.repaint();

            this.frame.dispose();

            MainMenu menu = new MainMenu(this.loginController, this.groupController, this.calendarController,
                        this.studentController, this.studentUsername);

            //going back to GroupMenu
        }
        else if(e.getSource() == this.cancelButton){
            this.frame.dispose();
            GroupMenu menu = new GroupMenu(this.loginController, this.groupController, this.calendarController,
                    this.studentController, this.studentUsername);
//            going back to GroupMenu
        }
    }

//    public static void main(String[] args) {
//        new CreateGroup();
//    }
}