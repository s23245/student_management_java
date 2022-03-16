import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Login_Frame implements ActionListener {

    JFrame frame;

    JPanel main_page_panel;

    JLabel main_page_label;
    JLabel main_page_username_label;
    JLabel main_page_password_label;
    JTextField main_page_username;
    JPasswordField main_page_password;
    JCheckBox main_page_student_checkbox;
    JCheckBox main_page_teacher_checkbox;
    JButton main_page_login_button;
    JButton main_page_registration_button;


    public static void main(String[] args) {
        try {
            javax.swing.UIManager.setLookAndFeel( "javax.swing.plaf.nimbus.NimbusLookAndFeel" );
        } catch( Exception e ) {
            e.printStackTrace();
        }
        new Login_Frame();
    }

    public Login_Frame() {
        //Creating JFrame and JPanel (with GridBagLayout)
        frame = new JFrame("STUDENT APP");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 240);
        frame.setLocation(new Point(500, 500));
        frame.setVisible(true);


        main_page_panel = new JPanel();
        main_page_panel.setBackground(new Color(2, 48, 71));
        main_page_panel.setVisible(true);

        main_page_panel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.VERTICAL;
        frame.add(main_page_panel);

        //Creating all elements that will be displayed
        main_page_label = new JLabel("STUDENT APPLICATION ENTRY");
        main_page_label.setFont(new Font("Verdana", Font.BOLD, 16));
        main_page_label.setForeground(new Color(251, 133, 0));

        main_page_username_label = new JLabel("Username");
        main_page_username_label.setFont(new Font("Verdana", Font.BOLD, 16));
        main_page_username_label.setForeground(Color.black);
        main_page_username_label.setHorizontalAlignment(SwingConstants.LEFT);
        main_page_password_label = new JLabel("Password");
        main_page_password_label.setFont(new Font("Verdana", Font.BOLD, 16));
        main_page_password_label.setForeground(Color.black);
        main_page_password_label.setHorizontalAlignment(SwingConstants.LEFT);

        main_page_username = new JTextField();
        main_page_username.setPreferredSize(new Dimension(100, 25));

        main_page_password = new JPasswordField();
        main_page_password.setPreferredSize(new Dimension(100, 25));

        main_page_student_checkbox = new JCheckBox("STUDENT");
        main_page_student_checkbox.setFont(new Font("Verdana", Font.BOLD, 12));
        main_page_student_checkbox.setForeground(Color.white);

        main_page_teacher_checkbox = new JCheckBox("TEACHER");
        main_page_teacher_checkbox.setFont(new Font("Verdana", Font.BOLD, 12));
        main_page_teacher_checkbox.setForeground(Color.white);

        main_page_login_button = new JButton("LOGIN");
        main_page_login_button.setBackground(new Color(142, 202, 230));
        main_page_login_button.setFont(new Font("Verdana", Font.BOLD, 12));
        main_page_login_button.setForeground(new Color(251, 133, 0));
        main_page_login_button.setBorderPainted(false);

        main_page_registration_button = new JButton("REGISTRATION");
        main_page_registration_button.setBackground(new Color(142, 202, 230));
        main_page_registration_button.setFont(new Font("Verdana", Font.BOLD, 12));
        main_page_registration_button.setForeground(new Color(251, 133, 0));
        main_page_registration_button.setBorderPainted(false);



        //Adding all elements with position
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 3;
        gbc.insets = new Insets(5,5,5,5);
        main_page_panel.add(main_page_label, gbc);

        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        main_page_panel.add(main_page_username, gbc);

        gbc.gridx = 1;
        gbc.gridy = 2;
        main_page_panel.add(main_page_password, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        main_page_panel.add(main_page_student_checkbox, gbc);

        gbc.gridx = 2;
        gbc.gridy = 3;
        main_page_panel.add(main_page_teacher_checkbox, gbc);

        gbc.gridx = 1;
        gbc.gridy = 3;
        main_page_panel.add(main_page_login_button, gbc);

        gbc.gridx = 1;
        gbc.gridy = 4;
        gbc.gridwidth = 1;
        main_page_panel.add(main_page_registration_button, gbc);


        main_page_login_button.addActionListener(this);
        main_page_registration_button.addActionListener(this);

        frame.validate();
    }


    @Override
    public void actionPerformed(ActionEvent e)
    {
        if (e.getSource() == main_page_login_button) {
            String username = main_page_username.getText();
            String surname = String.valueOf(main_page_password.getPassword());
            boolean student_status = main_page_student_checkbox.isSelected();
            boolean teacher_staus = main_page_teacher_checkbox.isSelected();
            int userIsInDB = 0;

            if (student_status && teacher_staus) {
                JOptionPane.showMessageDialog(main_page_panel, "Choose only one checkbox");
            } else {
                if (student_status)
                    userIsInDB = User.checkUser(new User(username, surname, "STUDENT"));
                if (teacher_staus)
                    userIsInDB = User.checkUser(new User(username, surname, "TEACHER"));
                if (userIsInDB == 0) {
                    JOptionPane.showMessageDialog(main_page_panel, "There are no user with such username and/or password");
                } else {
                    Main_Frame main_frame = new Main_Frame();
                    main_frame.setVisible();
                    frame.setVisible(false);

                }
            }
        }

        if (e.getSource() == main_page_registration_button) {
            JPanel registrationPanel = new JPanel(new BorderLayout(5, 5));

            JPanel label = new JPanel(new GridLayout(0, 1, 2, 2));
            label.add(new Label("Username"));
            label.add(new Label("Password"));
            registrationPanel.add(label, BorderLayout.WEST);

            JPanel inputs = new JPanel(new GridLayout(0, 1, 2, 2));
            JTextField username = new JTextField();
            inputs.add(username);
            JPasswordField password = new JPasswordField();
            inputs.add(password);
            registrationPanel.add(inputs, BorderLayout.CENTER);

            JPanel boxes = new JPanel(new GridLayout(1, 0, 2, 2));
            JCheckBox checkBox_student = new JCheckBox("Student");
            JCheckBox checkBox_teacher = new JCheckBox("Teacher");
            boxes.add(checkBox_student);
            boxes.add(checkBox_teacher);
            registrationPanel.add(boxes, BorderLayout.SOUTH);


            int ok_var = JOptionPane.showConfirmDialog(main_page_panel, registrationPanel, "Registration", JOptionPane.OK_CANCEL_OPTION);

            if (ok_var == JOptionPane.OK_OPTION)
                if (checkBox_student.isSelected() && checkBox_teacher.isSelected()) {
                    JOptionPane.showMessageDialog(main_page_panel, "Choose only one checkbox");
                } else {
                    if (checkBox_student.isSelected())
                        User.add(new User(username.getText(), String.valueOf(password.getPassword()), "STUDENT"));
                    if (checkBox_teacher.isSelected())
                        User.add(new User(username.getText(), String.valueOf(password.getPassword()), "TEACHER"));
                }


        }


    }
}
