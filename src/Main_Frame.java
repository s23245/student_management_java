import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Main_Frame implements ActionListener
{
    JFrame frame;

    JPanel main_panel_main_frame;
    JPanel left_column_main_frame;
    JPanel right_column_main_frame;

    JButton home_left_column_button;
    JButton course_left_column_button;
    JButton dashboard_left_column_button;
    JButton exit_left_column_button;

    JPanel home_right_panel;
    JPanel course_right_panel;
    JPanel dashboard_right_panel;


    //Home_right_panel elements
    JLabel headline;
    JLabel developer_info;





    public Main_Frame(User current_user)
    {
        frame = new JFrame("STUDENT APP");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1280, 1024);
        setVisible();
        frame.setLocation(new Point(200, 500));

        main_panel_main_frame = new JPanel(new BorderLayout());
        main_panel_main_frame.setVisible(true);
        main_panel_main_frame.setSize(new Dimension(frame.getWidth(),frame.getHeight()));
        frame.add(main_panel_main_frame);

        left_column_main_frame = new JPanel();
        left_column_main_frame.setLayout(new BoxLayout(left_column_main_frame,BoxLayout.Y_AXIS));
        left_column_main_frame.setSize(new Dimension((int)(frame.getWidth() * 0.25), frame.getHeight()));
        left_column_main_frame.setBackground(new Color(2, 48, 71));
        left_column_main_frame.setVisible(true);
        main_panel_main_frame.add(left_column_main_frame,BorderLayout.CENTER);


        right_column_main_frame = new JPanel();
        right_column_main_frame.setSize(new Dimension((int)(frame.getWidth() * 0.75), frame.getHeight()));
        right_column_main_frame.setBackground(new Color(33, 158, 188));
        right_column_main_frame.setVisible(true);
        main_panel_main_frame.add(right_column_main_frame,BorderLayout.CENTER);


        //ADDING BUTTONS TO LEFT CONSTANT PANEL

        home_left_column_button = new JButton("HOME");
        home_left_column_button.setAlignmentX(Component.LEFT_ALIGNMENT);
        home_left_column_button.setHorizontalAlignment(SwingConstants.LEFT);
        home_left_column_button.setMaximumSize(
                new Dimension(frame.getWidth(), left_column_main_frame.getHeight()/10)
        );
        home_left_column_button.setMinimumSize(
                new Dimension(frame.getWidth(), left_column_main_frame.getHeight()/10)
        );
        home_left_column_button.setFont(new Font("Verdana", Font.BOLD, 18));
        home_left_column_button.setForeground(Color.white);
        home_left_column_button.setBorderPainted(false);
        home_left_column_button.setOpaque(false);
        home_left_column_button.setContentAreaFilled(false);
        left_column_main_frame.add(home_left_column_button);
        home_left_column_button.addActionListener(this);
        home_left_column_button.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                home_left_column_button.setBackground(new Color(2, 28, 51));
                home_left_column_button.setOpaque(true);

            }

            @Override
            public void mouseExited(MouseEvent e) {
                home_left_column_button.setOpaque(false);
            }
        });



        course_left_column_button = new JButton("COURSE");
        course_left_column_button.setHorizontalAlignment(SwingConstants.LEFT);
        course_left_column_button.setMaximumSize(
                new Dimension(left_column_main_frame.getWidth(), left_column_main_frame.getHeight()/10)
        );
        course_left_column_button.setFont(new Font("Verdana", Font.BOLD, 18));
        course_left_column_button.setForeground(Color.white);
        course_left_column_button.setBorderPainted(false);
        course_left_column_button.setOpaque(false);
        course_left_column_button.setContentAreaFilled(false);
        left_column_main_frame.add(course_left_column_button);
        course_left_column_button.addActionListener(this);
        course_left_column_button.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                course_left_column_button.setBackground(new Color(2, 28, 51));
                course_left_column_button.setOpaque(true);

            }

            @Override
            public void mouseExited(MouseEvent e) {
                course_left_column_button.setOpaque(false);
            }
        });


        dashboard_left_column_button = new JButton("DASHBOARD");
        dashboard_left_column_button.setHorizontalAlignment(SwingConstants.LEFT);
        dashboard_left_column_button.setMaximumSize(
                new Dimension(left_column_main_frame.getWidth(), left_column_main_frame.getHeight()/10)
        );
        dashboard_left_column_button.setFont(new Font("Verdana", Font.BOLD, 18));
        dashboard_left_column_button.setForeground(Color.white);
        dashboard_left_column_button.setBorderPainted(false);
        dashboard_left_column_button.setOpaque(false);
        dashboard_left_column_button.setContentAreaFilled(false);
        left_column_main_frame.add(dashboard_left_column_button);
        dashboard_left_column_button.addActionListener(this);
        dashboard_left_column_button.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                dashboard_left_column_button.setBackground(new Color(2, 28, 51));
                dashboard_left_column_button.setOpaque(true);

            }

            @Override
            public void mouseExited(MouseEvent e) {
                dashboard_left_column_button.setOpaque(false);
            }
        });

        exit_left_column_button = new JButton("EXIT");
        exit_left_column_button.setHorizontalAlignment(SwingConstants.LEFT);
        exit_left_column_button.setMaximumSize(
                new Dimension(left_column_main_frame.getWidth(), left_column_main_frame.getHeight()/10)
        );
        exit_left_column_button.setFont(new Font("Verdana", Font.BOLD, 18));
        exit_left_column_button.setForeground(Color.white);
        exit_left_column_button.setBorderPainted(false);
        exit_left_column_button.setOpaque(false);
        exit_left_column_button.setContentAreaFilled(false);
        left_column_main_frame.add(exit_left_column_button);
        exit_left_column_button.addActionListener(this);
        exit_left_column_button.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                exit_left_column_button.setBackground(new Color(2, 28, 51));
                exit_left_column_button.setOpaque(true);

            }

            @Override
            public void mouseExited(MouseEvent e) {
                exit_left_column_button.setOpaque(false);
            }
        });

        home_right_panel = new JPanel();
        home_right_panel.setLayout(new BorderLayout());
        home_right_panel.setSize(new Dimension(right_column_main_frame.getWidth(), right_column_main_frame.getHeight()));
        home_right_panel.setVisible(true);
        home_right_panel.setOpaque(false);
        right_column_main_frame.add(home_right_panel);

        headline = new JLabel("HELLO, " + current_user._name.toUpperCase());
        headline.setFont(new Font("Verdana", Font.BOLD, 18));
        headline.setHorizontalAlignment(SwingConstants.CENTER);
        headline.setForeground(Color.white);
        home_right_panel.add(headline,BorderLayout.NORTH);

        developer_info = new JLabel("Designed by Bohdan Bondarenko 2022");
        developer_info.setFont(new Font("Verdana", Font.BOLD, 10));
        developer_info.setForeground(Color.white);
        home_right_panel.add(developer_info, BorderLayout.SOUTH);


        course_right_panel = new JPanel();
        course_right_panel.setLayout(new BorderLayout());
        course_right_panel.setSize(new Dimension(right_column_main_frame.getWidth(), right_column_main_frame.getHeight()));
        course_right_panel.setVisible(true);
        course_right_panel.setOpaque(false);
        right_column_main_frame.add(course_right_panel);

        dashboard_right_panel = new JPanel();
        dashboard_right_panel.setLayout(new BorderLayout());
        dashboard_right_panel.setSize(new Dimension(right_column_main_frame.getWidth(), right_column_main_frame.getHeight()));
        dashboard_right_panel.setVisible(true);
        dashboard_right_panel.setOpaque(false);
        right_column_main_frame.add(dashboard_right_panel);



        frame.validate();
    }
    public static void main(String[] args)
    {
        try {
            javax.swing.UIManager.setLookAndFeel( "javax.swing.plaf.nimbus.NimbusLookAndFeel" );
        } catch( Exception e ) {
            e.printStackTrace();
        }
        User current_user = new User();
        new Main_Frame(current_user);
    }

    public void setVisible()
    {
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource() == home_left_column_button)
        {
            course_right_panel.setVisible(false);
            dashboard_right_panel.setVisible(false);
            home_right_panel.setVisible(true);
        }
        if(e.getSource() == course_left_column_button)
        {
            dashboard_right_panel.setVisible(false);
            home_right_panel.setVisible(false);
            course_right_panel.setVisible(true);
        }
        if(e.getSource() == dashboard_left_column_button)
        {
            course_right_panel.setVisible(false);
            home_right_panel.setVisible(false);
            dashboard_right_panel.setVisible(true);
        }
        if(e.getSource() == exit_left_column_button)
        {
            frame.setVisible(false);
            Login_Frame login_frame = new Login_Frame();
            login_frame.setVisible();
        }
    }
}
