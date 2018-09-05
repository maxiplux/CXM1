package imp1.models;

import javax.persistence.*;

/**
 * User: franc
 * Date: 05/09/2018
 * Time: 3:54
 */

@Entity
public class Appointment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String appdate;
    @OneToOne(cascade = CascadeType.PERSIST)
    private Patient patient;

    @Embedded
    private Payment payment;

    @ManyToOne(cascade = CascadeType.PERSIST)
    private Doctor doctor;

    public Appointment() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAppdate() {
        return appdate;
    }

    public void setAppdate(String appdate) {
        this.appdate = appdate;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    @Override
    public String toString() {
        return "Appointment{" +
                "id=" + id +
                ", appdate='" + appdate + '\'' +
                ", patient=" + patient +
                ", payment=" + payment +
                ", doctor=" + doctor +
                '}';
    }
}
