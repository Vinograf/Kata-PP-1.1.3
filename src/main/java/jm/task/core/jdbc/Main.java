package jm.task.core.jdbc;


import jm.task.core.jdbc.dao.UserDao;
import jm.task.core.jdbc.dao.UserDaoJDBCImpl;

public class Main {
    public static void main(String[] args) {
        // реализуйте алгоритм здесь
        Util.getConnection();

        UserDao userDao = new UserDaoJDBCImpl();
//        userDao.dropUsersTable();
        System.out.println("OK");
        userDao.createUsersTable();
        System.out.println( "done");


        userDao.saveUser("Name1", "LastName1", (byte) 20);
//        userDao.saveUser("Name2", "LastName2", (byte) 25);
//        userDao.saveUser("Name3", "LastName3", (byte) 31);
//        userDao.saveUser("Name4", "LastName4", (byte) 38);

//        userDao.removeUserById(1);

        System.out.println( userDao.getAllUsers().size());
        userDao.cleanUsersTable();
        userDao.dropUsersTable();


        }

}
