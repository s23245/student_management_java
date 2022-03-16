import java.sql.*;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;



public class User
{
    protected int _id;
    protected String _name;
    protected String _surname;
    protected String _status;

    private static final Connection  _connection = connect();
    
    
    private static final int count = 0;

    public User(String name, String surname, String status)
    {
        this._name = name;
        this._surname = surname;
        this._status = status;

        this._id = findId();

        
    }
    public static Connection connect()
    {
        Connection connection = null;
        try
        {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager
                    .getConnection("jdbc:postgresql://localhost:5432/",
                            "postgres", "root123");

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
        return connection;
    }

    public static void add(User acc)
    {
        String statementString = "";

        if(Objects.equals(acc._status, "STUDENT"))
        {
            statementString = "INSERT INTO " + "student_mng."+ acc._status +
                    "(STUDENT_ID,STUDENT_NAME,STUDENT_SURNAME)VALUES(" + "?, ?, ?)";
        }
        else if(Objects.equals(acc._status, "TEACHER"))
        {
            statementString = "INSERT INTO " + "student_mng."+ acc._status +
                    "(TEACHER_ID,TEACHER_NAME,TEACHER_SURNAME)VALUES(" + "?, ?, ?)";
        }


        try {
            PreparedStatement statement = acc._connection.prepareStatement(statementString);
            statement.setInt(1,acc._id);
            statement.setString(2,acc._name);
            statement.setString(3, acc._surname);
            statement.executeUpdate();

            System.out.println("NEW USER WAS ADDED SUCCESSFULLY");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void delete(User acc)
    {
        String statementString = "";

        if(Objects.equals(acc._status, "STUDENT"))
        {
            statementString = "DELETE FROM " + "student_mng." + acc._status + " WHERE STUDENT_ID = ?";
        }
        else if(Objects.equals(acc._status, "TEACHER"))
        {
            statementString = "DELETE FROM " + "student_mng." + acc._status + " WHERE TEACHER_ID = ?";
        }


        try {
            PreparedStatement statement = acc._connection.prepareStatement(statementString);
            statement.setInt(1,acc._id);
            statement.executeUpdate();

            System.out.println("USER WAS DELETED SUCCESSFULLY");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void deleteById(int id,String status)
    {
        String statementString = "";

        if(Objects.equals(status, "STUDENT"))
        {
            statementString = "DELETE FROM " + "student_mng." + status + " WHERE STUDENT_ID = ?";
        }
        else if(Objects.equals(status, "TEACHER"))
        {
            statementString = "DELETE FROM " + "student_mng." + status + " WHERE TEACHER_ID = ?";
        }


        try {
            PreparedStatement statement = _connection.prepareStatement(statementString);
            statement.setInt(1,id);
            statement.executeUpdate();

            System.out.println("USER WAS DELETED SUCCESSFULLY");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static int checkUser(User acc)
    {

        String selectString = "SELECT * FROM student_mng." + acc._status +
                " WHERE " + acc._status + "_NAME = ? AND " +
                acc._status + "_SURNAME = ?;";

        try {
            PreparedStatement preparedStatement = _connection.prepareStatement(selectString);
            preparedStatement.setString(1, acc._name);
            preparedStatement.setString(2, acc._surname);
            ResultSet resultSet = preparedStatement.executeQuery();

            if(!resultSet.next())
            {
                System.out.println("Wrong username and surname!");
                return 0;
            }
            else
            {
                return 1;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return 0;
    }

    private int findId()
    {
        String selectMaxId = "SELECT " + _status + "_ID FROM student_mng." + _status +
                " ORDER BY " + _status + "_ID DESC LIMIT 1";

        try {
            PreparedStatement ps = User._connection.prepareStatement(selectMaxId);
            ResultSet rs = ps.executeQuery();

            if(rs.next())
            {
                System.out.println( "ID " + rs.getInt(1));
                return rs.getInt(1) + 1;
            }
            else
                return 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return 0;
    }

    @Override
    public String toString() {

            return "User{" +
                    "_id=" + _id +
                    ", _name='" + _name + '\'' +
                    ", _surname='" + _surname + '\'' +
                    ", _status='" + _status + '\'' +
                    '}';
    }


}
