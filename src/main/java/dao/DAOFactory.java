package dao;

public class DAOFactory {
    public static UserDAO getUserDAOInstance() {
        return new UserDAOImplement();
    }
}