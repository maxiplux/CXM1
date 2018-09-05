package imp1.controllers;

/**
 * User: franc
 * Date: 05/09/2018
 * Time: 4:09
 */
import imp1.models.Appointment;
import imp1.models.Doctor;
import imp1.models.Patient;
import imp1.models.Payment;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.time.LocalDate;
import java.util.List;

public class Hospital {
    private static SessionFactory sessionFactory;

    /* Reads hibernate.cfg.xml and prepares Hibernate for use     */
    protected static void setUp() throws Exception {
        // A SessionFactory is set up once for an application!
        final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .configure()
                .build();
        try {
            sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
        } catch (Exception e) {
            e.printStackTrace();
            StandardServiceRegistryBuilder.destroy(registry);
        }
    }

    protected static void tearDown() throws Exception {
        if (sessionFactory != null)
        {
            sessionFactory.close();
        }
    }


    public static void main(String[] args) throws Exception {
        setUp();

        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();

            Appointment appointment = new Appointment();
            Doctor drLina=new Doctor();
            drLina.setFirstname("Lina");
            drLina.setLastname("Triana");
            drLina.setDoctortype("Eye Doctor");

            appointment.setDoctor(drLina);
            appointment.setAppdate("15/05/08");
            Patient patient = new Patient();
            patient.setName("Francisco");
            patient.setCity("Cali");
            patient.setZip("760041");
            patient.setStreet("Kra 48");

            appointment.setPatient(patient);

            Payment payment = new Payment();
            payment.setAmount(500);
            payment.setPaydate("12/06/08");
            appointment.setPayment(payment);

            session.persist(appointment);


            session.getTransaction().commit();


        // retieve all cars
        @SuppressWarnings("unchecked")
        List<Appointment> appointments = session.createQuery("from Appointment ").getResultList();
            for (Appointment appointment1 : appointments) {
            System.out.println(appointment1);
        }

        tearDown();
        }
    }
}
