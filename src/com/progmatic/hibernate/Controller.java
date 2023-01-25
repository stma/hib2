package com.progmatic.hibernate;

import com.progmatic.hibernate.model.Course;
import com.progmatic.hibernate.model.HibernateContext;
import com.progmatic.hibernate.model.Pizza;
import com.progmatic.hibernate.model.Student;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.hibernate.query.SelectionQuery;

public class Controller implements AutoCloseable {

    private HibernateContext model = new HibernateContext();

    public void initStudentsAndCourses() {
        Session s = model.getSession();
        Transaction tx = s.beginTransaction();

        try {
            Student s1 = new Student();
            s1.setName("Miklos");
            s1.setAddress("Bp");
            s.persist(s1);

            Student s2 = new Student();
            s2.setName("Klari");
            s2.setAddress("Szeged");
            s.persist(s2);

            Course c1 = new Course();
            c1.setMaxHeadCount(50);
            c1.setMinHeadCount(15);
            c1.setName("Angol B - 2023-01");
            c1.setTeacher("Tanarka");
            s.persist(c1);

            tx.commit();
        } catch (Exception e) {
            System.out.println(e);
            tx.rollback();
        }
    }


    public void addPizza(String name, Integer price) {

        Pizza p = new Pizza();

        p.setName(name);
        p.setPrice(price);

        Session session = model.getSession();

        Transaction tx = session.beginTransaction();

        session.persist(p);

//            session.clear();
//            session.merge(p);
//
//            session.remove(p);
//            session.persist(p);
//
//            Pizza a = session.find(Pizza.class, p.getId());

        session.flush();

        session.getTransaction().commit();
        System.out.println("Pizza id = " + p.getId());
    }

    public void getAllPizza() {
        Session session = model.getSession();

        Transaction tx = session.beginTransaction();

//        Pizza1 p1 = new Pizza1();
//        p1.setName("Almas");
//        session.persist(p1);

//        Query<Pizza1> q = session.createQuery("FROM Pizza1", Pizza1.class);
//        for (Pizza1 p : q.list()) {
//            System.out.println(p);
//        }

//        NativeQuery<Object> pizzas = session.createNativeQuery("SELECT * FROM pizza p", Object.class);
//
//        for (Object a: pizzas.list()) {
//            System.out.println(a);
//        }

//        session.flush();

        SelectionQuery<Pizza> q = session.createSelectionQuery("SELECT p FROM Pizza p", Pizza.class);

//        Query<String> q = session.createQuery("SELECT p.name FROM Pizza p", String.class);
//        for (String p : q.list()) {
//            System.out.println(p);
//        }

//        Query<Pizza> q = session.createQuery("SELECT P FROM Pizza P WHERE P.id = 6", Pizza.class);
//        Query<Pizza> q = session.createQuery("FROM Pizza P WHERE P.id > 3 ORDER BY P.price DESC", Pizza.class);

//        Query<Pizza> q = session.createQuery("FROM Pizza P WHERE P.price < :priceLimit ORDER BY P.price DESC", Pizza.class);
//        q.setParameter("priceLimit", 1000);

//        Query<Pizza> q = session.createQuery("FROM Pizza P ORDER BY P.price DESC Limit 10 offset 5", Pizza.class);
//        Query<Pizza> q = session.createQuery("FROM Pizza P ORDER BY P.price DESC", Pizza.class);
//        q.setFirstResult(5);
//        q.setMaxResults(10);

        for (Pizza p : q.list()) {
            System.out.println(p);
        }
        session.clear();

//        Long priceSum = session.createQuery("select sum(p.price) from Pizza p ", Long.class)
//                .getSingleResult();
//        System.out.println(String.format("Osszes pizza ara: %d", priceSum));
//
//        String pizzasName = session.createQuery("select group_concat(p.name) from Pizza p ", String.class)
//                .getSingleResult();
//        System.out.printf("Osszes pizza neve: %s%n", pizzasName);


        session.getTransaction().commit();
    }

    @Override
    public void close() throws Exception {
        model.close();
    }

    public void deletePizza(Integer pid) {
        Session session = model.getSession();
        Transaction tx = null;
        try {

            tx = session.beginTransaction();

            Pizza p = session.find(Pizza.class, pid);
            session.remove(p);

//            MutationQuery q = session.createMutationQuery("DELETE FROM Pizza WHERE id=:pid");
//            q.setParameter("pid", pid);
//            q.executeUpdate();

//            session.flush();

            tx.commit();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
        }
    }

    public void listStudent() {
        Session session = model.getSession();

        Transaction tx = session.beginTransaction();

        Query<Student> q = session.createQuery("FROM Student", Student.class);
        for (Student p : q.list()) {
            System.out.println(p);
        }
        session.clear();

        tx.commit();
    }

    public void connectS2C(Integer sid, Integer cid) {
        Session session = model.getSession();
        Transaction tx = session.beginTransaction();
        try {
            Student s = session.find(Student.class, sid);
            Course c = session.find(Course.class, cid);

            s.getCourses().add(c);
            session.persist(s);

            tx.commit();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
        }
    }

    public void listCourses() {
        Session session = model.getSession();

        Transaction tx = session.beginTransaction();

        Query<Course> q = session.createQuery("FROM Course", Course.class);
        for (Course p : q.list()) {
            System.out.println(p);
        }
        session.clear();

        session.getTransaction().commit();
    }
}
