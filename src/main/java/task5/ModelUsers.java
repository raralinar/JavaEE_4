package task5;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Persistence;
import task4.Role;
import task4.User;

import java.util.List;

public class ModelUsers {

    static EntityManager entityManagerUser = Persistence.createEntityManagerFactory("userPU").createEntityManager();
    public static void createAdmin(String name, String pass) {
        Role role = new Role(); role.setRole_id(1);
        User user = new User(name, pass, role);
        entityManagerUser.getTransaction().begin();
        entityManagerUser.persist(user);
        entityManagerUser.getTransaction().commit();
    }
    public static void createUser(String name, String pass) {
        Role role = new Role(); role.setRole_id(2);
        User user = new User(name, pass, role);
        entityManagerUser.getTransaction().begin();
        entityManagerUser.persist(user);
        entityManagerUser.getTransaction().commit();
    }
    public static void deleteUser(String username) {
        List<task4.User> u = entityManagerUser
                .createQuery("select u from User u where u.username = '" + username + "'").getResultList();
        if (u.size() != 0) {
            entityManagerUser.getTransaction().begin();
            entityManagerUser.remove(u.get(0));
            entityManagerUser.getTransaction().commit();
        }
    }

    public static void editUser(String name, String pass, String currentUser) {
        entityManagerUser.getTransaction().begin();
        User user = entityManagerUser.find(task4.User.class, Integer.parseInt(currentUser));
        user.setUsername(name); user.setPasswd(pass);
        entityManagerUser.persist(user);
        entityManagerUser.getTransaction().commit();
    }

    public static List<User> getAll() {
        entityManagerUser = Persistence.createEntityManagerFactory("userPU").createEntityManager();
        return entityManagerUser.createQuery("select u from User u").getResultList();
    }

    public static boolean checkUser(String username, String pass) {
        return entityManagerUser.createQuery("select u from User u where u.username = '" + username + "' AND u.passwd = '" + pass + "'").getResultList().size() != 0;
    }

    public static User getUser(String username, String pass) {
        return (User) entityManagerUser.createQuery("select u from User u where u.username = '" + username + "' AND u.passwd = '" + pass + "'").getResultList().get(0);
    }
}
