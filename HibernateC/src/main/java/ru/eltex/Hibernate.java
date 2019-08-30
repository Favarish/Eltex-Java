package ru.eltex;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Hibernate {
    public static void main(String[] args) {

        Collection <User> users = new ArrayList<> ();

        users.add(new User("Karter Tibodo", "+67894168"));
        users.add(new User("Renny-young", "+6151353435"));

        User user1 = ((ArrayList <User>) users).get(0);
        User user2 = ((ArrayList <User>) users).get(1);

        Passport pass1 = new Passport("1202","324565");
        Passport pass2 = new Passport("1201", "131456");
        Address adr = new Address("NSK", "Okrughnaya", "29d");

        Collection<Lang> langs = new ArrayList <> ();

        langs.add(new Lang ("C#"));
        langs.add(new Lang ("Java"));

        Lang lang1 = ((ArrayList <Lang>) langs).get(0);
        Lang lang2 = ((ArrayList <Lang>) langs).get(1);


        pass1.setUser(user1);
        pass2.setUser(user2);
        adr.setOwner(users);
        lang1.setUsers(users);
        lang2.setUsers(users);


        user1.setLang(langs);
        user2.setLang(langs);
        user1.setAddress(adr);
        user2.setAddress(adr);
        user1.setPassport(pass1);
        user2.setPassport(pass2);

        final StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();
        SessionFactory sessionFactory = null;
        try {
            sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
        } catch (Exception e) {
            StandardServiceRegistryBuilder.destroy(registry);
            throw e;
        }

        Session session =sessionFactory.openSession();
        session.beginTransaction();
        session.save(user1);
        session.save(user2);
        session.save(pass1);
        session.save(pass2);
        session.save(adr);
        session.save(lang1);
        session.save(lang2);
        session.getTransaction().commit();

        session.beginTransaction();
        List<User> usersOut = session.createQuery("FROM User").list();
        usersOut.forEach(u -> System.out.println(u.getId() + "  " +  u.getFio() + "  "  +  u.getPhone() + "    "
                + u.getAddress().getId() + "      "  + u.getPassport().getId() + "        " + u.indexLang()));
        List<Address> address = session.createQuery("FROM Address").list();
        address.forEach(u -> System.out.println("Address: "+ u.getId()+", " +u.getCity() + ", " + u.getStreet()+ ", " + u.getBuilding()));
        List<Passport> passports = session.createQuery("FROM Passport").list();
        passports.forEach(u -> System.out.println(u.getId() + "  " + u.getSeries() + "  " + u.getNumber()));

        session.getTransaction().commit();
        session.close();

    }
}