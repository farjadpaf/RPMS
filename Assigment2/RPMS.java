import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;
import javax.mail.*;
import javax.mail.internet.*;
import java.util.Properties;

public class RPMS { // public class
    public static void main(String arg[]) { // main Function

        // Array list so that if the object is recreatd the precious data is saved into
        // these lists
        ArrayList<Feedback> feedbackList = new ArrayList<>();
        ArrayList<Prescription> prescriptionarr = new ArrayList<>();
        ArrayList<Appointment> Appoint = new ArrayList<>();
        ArrayList<Doctor> doctors = new ArrayList<>();



        int choice1; // variable for do-while loop
        Feedback feedback1; // object declaration outsiede the conditional statments so that they remain

        Doctor copyDoctor = null ;
        // accessable
        Doctor doctor, doctor2 = null;
        Patient patient = null;
        MedicalHistory medicalhistory = null;
        AppointmentManager apointmentmanager;
        Appointment appointment = null;
        VitalsDataBase vitaldatabase = null;
        Administrator admin = null;

        Scanner scannerobj = new Scanner(System.in); // object of Scanner class to take input from user

        do {
            System.out.println("* * * * Remote Patient Monitoring System * * * *  \n");
            System.out.println(
                    "What is Your Domian\n* 1.Patient \n* 2.Doctor \n* 3.Appoitment Manager \n* 4.Administrator  \n* 5.Exit");
            System.out.println("Enter your option from 1 to 5");

            String newinput = scannerobj.nextLine();
            int input = Integer.parseInt(newinput);

            if (input == 1) {
                String name, patientID2, email, password, contactNumber, doctorsEmail  ;;
                int age;
                System.out.println("Enter PatientID :");
                patientID2 = scannerobj.nextLine();

                System.out.println("Enter your age");
                age = scannerobj.nextInt();
                scannerobj.nextLine();

                System.out.println("Enter your name");
                name = scannerobj.nextLine();

                System.out.println("Enter your email");
                email = scannerobj.nextLine();

                System.out.println("Enter your password");
                password = scannerobj.nextLine();

                System.out.println("Enter your contact  Number");
                contactNumber = scannerobj.nextLine();

                System.out.println("Enter your Doctors Email for emergency cases:");
                doctorsEmail = scannerobj.nextLine();



                patient = new Patient(age, name, email, password, contactNumber, patientID2);

                System.out.println("\nWellcome as a Patient to our RPMS ! Which service You want to use");
                do {
                    System.out.println(
                            "\n1.Add Your Medical History\n2.View Doctors Feedback\n3.MakeAppointment\n4.View Your Medical History\n5.Add VitalSigns\n6.See Priscription\n7.Press Panic Button\n8.Start  a VedioCall\n9.Start a Whatsapp Chat");
                    System.out.println("Enter your option from 1 to 9");
                    String option = scannerobj.nextLine();

                    int input2 = Integer.parseInt(option);

                    if (input2 == 1) {
                        String patientID, illness, treatment, doctorName;

                        System.out.println("Add Your PatientID :");
                        patientID = scannerobj.nextLine();

                        System.out.println("Add Your previous Doctor Name :");
                        doctorName = scannerobj.nextLine();

                        System.out.println("Add Your illness :");
                        illness = scannerobj.nextLine();

                        System.out.println("Add Your treatment :");
                        treatment = scannerobj.nextLine();

                        medicalhistory = new MedicalHistory(patientID, illness, treatment, doctorName);

                        patient.addMedicalHistory(medicalhistory); // adding medical history to medicalhistory array of
                                                                   // particular patient
                    } else if (input2 == 2) {
                        patient.viewFeedBack(feedbackList);
                        // seeing all the feedbacks given to a particular student
                    } else if (input2 == 3) {
                        String specialist, name1, email1, contactNumber1 , date , time , docID;

                        System.out.println("Enter the Speciality of Doctor :");
                        specialist = scannerobj.nextLine();
                        System.out.println("Enter doctors name :");
                        name1 = scannerobj.nextLine();
                        System.out.println("Enter doctors Id :");
                        docID = scannerobj.nextLine();
                        System.out.println("Enter doctors email :");
                        email1 = scannerobj.nextLine();
                        System.out.println("Enter doctors Contact Number :");
                        contactNumber1 = scannerobj.nextLine();
                        System.out.println("Enter Date on which you want appointment  :");
                        date= scannerobj.nextLine();
                        System.out.println("Enter Time on which you want appointment  :");
                        time= scannerobj.nextLine();

                        doctor = new Doctor(specialist, name1, email1, "N/A", contactNumber1,docID);

                        // adding a appointment to Appoint array of Appointment manager class
                        apointmentmanager = new AppointmentManager();
                        patient.makeAppointment(apointmentmanager, doctor, date, time, Appoint,email);
                    } else if (input2 == 4) { // Viwing the medical history of patient in medicalHistory Array in
                                              // patient Class
                        patient.viewMedicalHistory();
                    } else if (input2 == 5) {
                        // adding vitalsigns
                        String patientID;
                        int heartRate, oxygenLevel, bloodPressre;
                        double temprature ;


                        System.out.println("Enter Patient ID :");
                        patientID = scannerobj.nextLine();

                        System.out.println("Enter HeartRate :");
                        heartRate = scannerobj.nextInt();

                        System.out.println("Enter OxygenLevel :");
                        oxygenLevel = scannerobj.nextInt();

                        System.out.println("Enter Blood Pressure :");
                        bloodPressre = scannerobj.nextInt();

                        System.out.println("Enter Body Temprature :");
                        temprature = scannerobj.nextDouble();
                        scannerobj.nextLine();



                        vitaldatabase = new VitalsDataBase();
                        patient.addVitalSigns(vitaldatabase, patientID, heartRate, oxygenLevel, bloodPressre,
                                temprature);

                {

                    VitalSigns vitalsign = new VitalSigns(patientID, heartRate, oxygenLevel, bloodPressre, temprature);
                    EmergencyAlert alert = new EmergencyAlert(new EmailNotification("seecs968@gmail.com" , "meib qggm bmoz jxsl "));
                    alert.checkVitals(vitalsign,doctorsEmail);
            }
                                
                    } else if (input2 == 6) {
                        patient.viewPrescriptions(prescriptionarr);
                    }else if(input2 == 7){
                        PanicButton button = new PanicButton(new EmailNotification("seecs968@gmail.com","meib qggm bmoz jxsl "));
                        button.Press(patient.getPatientID(),doctorsEmail);

                    }else if (input2 == 8){
                        Vediocall vedio = new Vediocall( "https://us05web.zoom.us/j/81911765772?pwd=ir85LpKaWNNNz2uBno6PEd3O5eBbBI.1 ", "Zoom" , new EmailNotification("seecs968@gmail.com","meib qggm bmoz jxsl "));
                        vedio.start(doctorsEmail);
                    }else if(input2 == 9){
                        if (contactNumber.startsWith("0")) {
                            contactNumber = "92" + contactNumber.substring(1); // replace leading 0 with country code
                        }
                        String link = "https://wa.me/" + contactNumber ;

                        ChatClient chat = new ChatClient(contactNumber,link,new EmailNotification("seecs968@gmail.com","meib qggm bmoz jxsl "));
                        chat.start(doctorsEmail);
                    }

                    String choice;
                    System.out.print("if you want to reuse the patient portal press '1' else press any number");
                    choice = scannerobj.nextLine();
                    choice1 = Integer.parseInt(choice);
                } while (choice1 == 1);

            }
            // if user choses to be a doctor
            else if (input == 2) {
                System.out.println("\nWellcome as a Doctor to our RPMS !");
                String name, email, password, contactNumber, speciality , patientsEmail,doctorID;
                System.out.println("Enter the Speciality of Doctor :");
                speciality = scannerobj.nextLine();

                System.out.println("Enter doctors ID :");
                doctorID = scannerobj.nextLine();

                System.out.println("Enter doctors name :");
                name = scannerobj.nextLine();

                System.out.println("Enter doctors email :");
                email = scannerobj.nextLine();

                System.out.println("Enter your password :");
                password = scannerobj.nextLine();

                System.out.println("Enter doctors Contact Number :");
                contactNumber = scannerobj.nextLine();

                System.out.println("Enter Your Particular Patients Email for chat and vedio call purpose :");
                patientsEmail = scannerobj.nextLine();


                doctor2 = new Doctor(speciality, name, password, contactNumber, patientsEmail,doctorID );

                boolean alreadyexists = false ;
                for(Doctor x : doctors) {
                    if(x.getdoctorID().equals(doctor2.getdoctorID())) {
                       alreadyexists =true ;
                       break;
                    }
                }if(alreadyexists){
                    System.out.println("Doctor with ID " + doctor2.getdoctorID() + " already exists");
                }else {doctors.add(doctor2) ;}



                do {
                    System.out.println(
                            "\nDoctor Menu: \n1. View Patient Vitals\n2. Create Prescription\n3. Provide Feedback\n4. View Medical History\n5.Start a VedioCall\n6.Start a Whatsapp Chat\n7.Send a Remainder about Medication");
                    System.out.println("Enter from 1 to 7");
                    String choice = scannerobj.nextLine();
                    int doctorChoice = Integer.parseInt(choice);

                    if (doctorChoice == 1) {
                        System.out.println("Enter Patient ID:");
                        String patientID = scannerobj.nextLine();
                        if (vitaldatabase == null) {
                            vitaldatabase = new VitalsDataBase();
                        }
                        vitaldatabase.getvitalSigns(patientID); // Viewing the vital signs

                    } else if (doctorChoice == 2) {
                        System.out.println("Enter Patient ID:");
                        String patientID = scannerobj.nextLine();

                        System.out.println("Enter Patient Email:");
                        String pEmail = scannerobj.nextLine();

                        System.out.println("Enter Medication:");
                        String medication = scannerobj.nextLine();

                        System.out.println("Enter Dosage:");
                        String dosage = scannerobj.nextLine();

                        System.out.println("Enter Doctor Name:");
                        String doctorName = scannerobj.nextLine();

                        Prescription prescription = new Prescription(patientID, medication, dosage, doctorName,pEmail);
                        System.out.println(
                                "Prescription Created:\n" + prescription + "\nAlso added in Prescription list");

                        doctor2.addPrescription(patient, prescription, prescriptionarr);

                    } else if (doctorChoice == 3) {
                        System.out.println("Enter Patient Name:");
                        String patientName = scannerobj.nextLine();

                        System.out.println("Enter Patient ID:");
                        String patientID = scannerobj.nextLine();

                        System.out.println("Enter Feedback Message:");
                        String message = scannerobj.nextLine();

                        Feedback feedback = new Feedback(message, doctorID, patientID, patientName); // adding feedback
                                                                                                     // to patients
                                                                                                     // feedback arrar
                        if (patient == null) {
                            patient = new Patient();
                        }
                        doctor2.addFeedback(feedback, patient, feedbackList);
                        System.out.println("Feedback Submitted:\n" + feedback);

                    } else if (doctorChoice == 4) {
                        System.out.println("Enter Patient ID:");
                        String patientID = scannerobj.nextLine();
                        if (medicalhistory == null) {
                            medicalhistory = new MedicalHistory(patientID);
                        }
                        System.out.println("Medical History:\n" + medicalhistory);

                    }else if(doctorChoice == 5){ // for doctor wanting to start vedio chat with patient
                        Vediocall vedio = new Vediocall( "https://us05web.zoom.us/j/81911765772?pwd=ir85LpKaWNNNz2uBno6PEd3O5eBbBI.1 ", "Zoom" , new EmailNotification("seecs968@gmail.com","meib qggm bmoz jxsl "));
                        vedio.start(patientsEmail);

                    }else if (doctorChoice == 6){ // for doctor wanting to start chat with patient
                        if (contactNumber.startsWith("0")) {
                            contactNumber = "92" + contactNumber.substring(1); // replace leading 0 with country code
                        }
                        String link = "https://wa.me/" + contactNumber;
                        ChatClient chat = new ChatClient(contactNumber,link,new EmailNotification("seecs968@gmail.com","meib qggm bmoz jxsl "));
                        chat.start(patientsEmail);

                    }else if (doctorChoice == 7){
                        System.out.println("Enter the PatintId of Patient who You to send the Remainder");
                        String patientID = scannerobj.nextLine();
                        for(Prescription x : prescriptionarr ){
                            if(x.getPatientID().equals(patientID) ){
                                    RemainderService remind = new RemainderService(new EmailNotification("seecs968@gmail.com","meib qggm bmoz jxsl "));
                                    remind.sendMedicationReminder(x.getpEmail(),x);
                                }}}
                    
                    String choicemade;
                    System.out.print("if you want to reuse the Doctor's portal '1' else press any number");
                    choicemade = scannerobj.nextLine();
                    choice1 = Integer.parseInt(choicemade);
                } while (choice1 == 1);
            }

            // if user is a Apointment Manager
            else if (input == 3) { // creating object to appointmenManager class to perform functions of
                                   // adminstrator
                String choice;
                int input2;
                apointmentmanager = new AppointmentManager();
                System.out.println("Wellcome to as a Appointment Manager to RPMS !");
                do {
                    System.out.println("1.View all  Appointments that are on your  List\n2.Update appointment Status");
                    System.out.println("Enter your option from 1 or 2");
                    choice = scannerobj.nextLine();
                    input2 = Integer.parseInt(choice);

                    if (input2 == 1) {
                        if (Appoint.isEmpty()) {
                            System.out.print("Appointment List is empty !");
                        } else {
                            for (Appointment x : Appoint) {
                                System.out.println(x);
                            }
                        }
                    } else if (input2 == 2) {
                        System.out.println("Enter Appoitment ID of appointment which you want to update :");
                        String choice_made = scannerobj.nextLine();
                        int choice_made1 = Integer.parseInt(choice_made);

                        System.out.println("Enter the new Status of Appointment :");
                        String choice_made2 = scannerobj.nextLine();

                        apointmentmanager.updateAppointmentStatus(choice_made1, choice_made2, Appoint);
                    }
                    String choice5;
                    System.out.print(
                            "if you want to reuse the Appointment Manager portal press '1' else press any number");
                    choice = scannerobj.nextLine();
                    choice1 = Integer.parseInt(choice);
                } while (choice1 == 1);

            }
            // if user is a adminstrator
            else if (input == 4) {
                String name, email, password, contactNumber, AdminID , docID;
                System.out.println("Wellcome to as a Adminstrator to RPMS !");

                System.out.println("Enter AdminID :");
                AdminID = scannerobj.nextLine();

                System.out.println("Enter your name");
                name = scannerobj.nextLine();

                System.out.println("Enter your email");
                email = scannerobj.nextLine();

                System.out.println("Enter your password");
                password = scannerobj.nextLine();

                System.out.println("Enter your contact  Number");
                contactNumber = scannerobj.nextLine();

                admin = new Administrator(name, email, password, contactNumber, AdminID);

                do {
                    System.out.println(
                            "1.Add patients to the list \n2.Remove patients from the list \n3.View all patients ");
                    System.out.println("Enter your option from 1 to 3");
                    String choice = scannerobj.nextLine();
                    int input2 = Integer.parseInt(choice);

                    switch (input2) {

                        case 1: {
                              System.out.println("Enter DoctorsID to whom to want to add patient");
                              docID = scannerobj.nextLine();

                            if (patient == null)
                                System.out.println("Patient doesnt exist ");
                            else {
                                admin.addPatient(doctors,patient,docID);
                                System.out.println("Patient added to doctors list");
                            }
                        }

                            break;
                        case 2: {
                            String ID;
                            System.out.println("Enter PatientID of patient which you want to remove ");
                            ID = scannerobj.nextLine();
                            admin.removePatient(doctor2, ID);
                        }
                            break;
                        case 3: {
                            if (doctor2 == null)
                                System.out.println("Doctor doesnt exist ");
                            else {
                                admin.viewPatients(doctor2);
                                System.out.println("Patient removed from doctor's list");
                            }
                        }
                            break;
                        default:
                            System.out.println("Error !");
                    }
                    String choice6;
                    System.out.print("if you want to reuse the Administrator portal press '1' else press any number");
                    choice = scannerobj.nextLine();
                    choice1 = Integer.parseInt(choice);
                } while (choice1 == 1);
            } else
                return;

            String choice;
            System.out.print("if you want to reuse the Hospital Managment  System press '1' else press any number");
            choice = scannerobj.nextLine();
            choice1 = Integer.parseInt(choice);

        } while (choice1 == 1);
    }
}

// * * * * * User class * * * * *

class User {
    private String name;
    private String email;
    private String password;
    private String contactNumber;

    User() { // used the concept of constructor chaining
        this("N/A");
    }

    User(String name) {
        this(name, "N/A");
    }

    User(String name, String email) {
        this(name, email, "N/A");

    }

    User(String name, String email, String password) {
        this(name, email, password, "N/A");

    }

    User(String name, String email, String password, String contactNumber) {

        this.name = name;
        this.email = email;
        this.password = password;
        this.contactNumber = contactNumber;
    }

    // created setters
    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setContact(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    // created getters
    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getcontactNumber() {
        return contactNumber;
    }

    public String toString() { // overrided to string methode for user class
        return "User Name :" + name + "\nUser Email : " + email + "\nUser Password : " + password
                + "\nUser Contact Number : " + contactNumber;
    }

}

// * * * * * patient class that extends user class * * * * *

class Patient extends User {

    // patient class instances
    private String patientID;
    public int age;

    // List of feedbacks for this patient
    private ArrayList<MedicalHistory> medicalHistoryList;

    // constructors for assigning values to instances
    Patient() {
        super();

        medicalHistoryList = new ArrayList<>();
        this.patientID = "N/A";
        age = 0;
    }

    Patient(int age, String patientID) { // if only age is entered
        super();
        medicalHistoryList = new ArrayList<>();
        this.patientID = patientID;
        this.age = age;

    }

    Patient(int age, String name, String patientID) {
        super(name);
        medicalHistoryList = new ArrayList<>();
        this.patientID = patientID;
        this.age = age;
    }

    Patient(int age, String name, String email, String patientID) {
        super(name, email);
        medicalHistoryList = new ArrayList<>();
        this.patientID = patientID;
        this.age = age;
    }

    Patient(int age, String name, String email, String password, String patientID) {
        super(name, email, password);
        medicalHistoryList = new ArrayList<>();
        this.patientID = patientID;

        this.age = age;
    }

    Patient(int age, String name, String email, String password, String contactNumber, String patientID) {
        super(name, email, password, contactNumber);
        medicalHistoryList = new ArrayList<>();
        this.patientID = patientID;
        this.age = age;
    }

    // getters and setters
    public void setPatientID(String patientID) {
        this.patientID = patientID;
    }

    public String getPatientID() {
        return this.patientID;
    }

    // adding medical history to medical history list
    public void addMedicalHistory(MedicalHistory medicalHistory) {
        this.medicalHistoryList.add(medicalHistory);
    }

    // patient will be able to view doctors feedback
    public void viewFeedBack(ArrayList<Feedback> feedbacklist) {
        if (feedbacklist.isEmpty()) {
            System.out.println("FeedBack List is Empty ");
        } else {
            for (Feedback viper : feedbacklist) {
                if (patientID.equals(viper.getPatientID()))
                    System.out.println(viper);
            }
        }
    }

    // patient will be able to see medical history
    public void viewMedicalHistory() {
        System.out.println("Medical History for " + this.getName() + ":");
        if (medicalHistoryList.isEmpty()) {
            System.out.println("No medical history available.");
        } else {
            for (MedicalHistory history : medicalHistoryList) {
                System.out.println(history);
            }
        }
    }

    public void viewPrescriptions(ArrayList<Prescription> prescriptionarr) { // function to see the prescrptions made by
                                                                             // a doctor
        System.out.println("Prescriptions  for " + this.getName() + "  :");
        if (prescriptionarr.isEmpty()) {
            System.out.println("No medical history available.");
        } else {
            for (Prescription x : prescriptionarr) {
                if (patientID.equals(x.getPatientID()))
                    System.out.println(x);
            }

        }
    }

    // patient will be able to make appoitments
    public void makeAppointment(AppointmentManager appointmentManager, Doctor doctor, String date, String time,
            ArrayList<Appointment> Appoint, String pEmial) {
        appointmentManager.addAppointment(new Appointment(date, time, doctor, this,pEmial), Appoint);
        System.out.println("Appointment requested with Dr. " + doctor.getName() + " on " + date + " at " + time
                + " Appoitment ID :" + Appointment.getAppoitmentID());
    }

    // Method to add vital signs
    public void addVitalSigns(VitalsDataBase vitaldatabase, String patientID, int heartRate, int oxygenLevel,
            int bloodPressure, double temprature) {
        VitalSigns vitalSigns = new VitalSigns(patientID, heartRate, oxygenLevel, bloodPressure, temprature);
        vitaldatabase.vitalsadd(vitalSigns);
    }

    public String toString() { // overrided to string methode for patient class
        return "Patient Name :" + this.getName() + "\nPatient Email : " + this.getEmail()
                + "\nPatient  Contact Number : " +
                this.getcontactNumber();
    }

}

// * * * * * subclass doctor that has all the attributes and methodes of User
// class * * * * *

class Doctor extends User {
    public String Speciality;
    private String doctorId ;
    ArrayList<Patient> patientList;

    public Doctor() { // constructor chaing used with super keyword to call the constructors of parent
                      // class
        super();
        patientList = new ArrayList<>();
        Speciality = "N/A";
        doctorId = "N/A";
    }

    public Doctor(String Speciality) {
        super();
        patientList = new ArrayList<>();
        this.Speciality = Speciality;
        doctorId = "N/A";
    }

    public Doctor(String Speciality, String name) {
        super(name);
        patientList = new ArrayList<>();
        this.Speciality = Speciality;
        doctorId = "N/A";
    }

    public Doctor(String Speciality, String name, String email) {
        super(name, email);
        patientList = new ArrayList<>();
        this.Speciality = Speciality;
        doctorId = "N/A";
    }

    public Doctor(String Speciality, String name, String email, String password) {
        super(name, email, password);
        patientList = new ArrayList<>();
        this.Speciality = Speciality;
        doctorId = "N/A";
    }

    public Doctor(String Speciality, String name, String email, String password, String contactNUmber ,String doctorId) {
        super(name, email, password, contactNUmber);
        patientList = new ArrayList<>();
        this.Speciality = Speciality;
        this.doctorId = doctorId;
    }

    public void SeePatientRecord(Patient patient1) { // function to see patient record
        System.out.println("Patient Name : " + patient1.getName());
        System.out.println("Patient email : " + patient1.getEmail());
        System.out.println("Patient Contact Number : " + patient1.getcontactNumber());
        System.out.println("Patient Medical History : ");
        patient1.viewMedicalHistory();
    }

    // doctor should be able to give feedback
    public void giveFeedback(Feedback Feedback, String message, String doctorID, String patientID, String patientName,
            LocalDate dateGiven) {
        Feedback.setMessage(message);
        Feedback.setDoctorID(doctorID);
        Feedback.setPatientID(patientID);
        Feedback.setPatientName(patientName);
        Feedback.dateGiven = dateGiven;

    }

    public String getdoctorID(){
        return doctorId;
    }

    // doctor should be able to add priscriptions
    public void addPrescription(Patient patient, Prescription prescription, ArrayList<Prescription> prescriptionarr) {
        prescriptionarr.add(prescription);
    }

    // adding feedback to the feedback list
    public void addFeedback(Feedback feedback, Patient patient, ArrayList<Feedback> feedbackList) {
        if (feedback.getPatientID().equals(patient.getPatientID())) // if patientID and feedbacID are same this s to
                                                                    // ensure that feedback is saved in right persons
                                                                    // list
            feedbackList.add(feedback);
    }
}

// * * * * * addministators class that extends User class * * * * *

class Administrator extends User {
    private String adminID;

    // addministrator class Constructors
    public Administrator() {
        super();
        this.adminID = "N/A";
    }

    public Administrator(String name, String adminID) {
        super(name);
        this.adminID = adminID;
    }

    public Administrator(String name, String email, String adminID) {
        super(name, email);
        this.adminID = adminID;
    }

    public Administrator(String name, String email, String Password, String adminID) {
        super(name, email, Password);
        this.adminID = adminID;
    }

    public Administrator(String name, String email, String password, String contactNumber, String adminID) {
        super(name, email, password, contactNumber);
        this.adminID = adminID;
    }

    void setAdminID(String adminID) { // setter for adminID
        this.adminID = adminID;
    }

    public String getAdminID() { // getter for adminID
        return adminID;
    }

    // adding patients of a particular Doctor
    public void addPatient(ArrayList<Doctor> doctors, Patient patient , String doctorid) {
        for(Doctor x : doctors){
            if(x.getdoctorID().equals(doctorid)){
                x.patientList.add(patient);
                return ;
            }
        }System.out.println("Doctor not found !");


    }

    // Removing patients from a particular Doctor
    public void removePatient(Doctor doctor, String patientID) {
        for (int i = 0; i < doctor.patientList.size(); i++) {
            Patient patient = doctor.patientList.get(i);
            if (patient.getPatientID().equals(patientID)) {
                doctor.patientList.remove(i);
                System.out.println("Patient removed: " + patientID);
                return; // Exit after removing the patient
            }
        }
        System.out.println("Patient not found: " + patientID);
    }

    // viewing pateints
    public void viewPatients(Doctor doctor) {
        if (doctor.patientList.isEmpty())
            System.out.println("List is Empty");
        else {
            for (Patient x : doctor.patientList) {
                System.out.println(x);
            }
        }
    }

}

// * * * * * VitalSigns class * * * * *

class VitalSigns {
    private String patientID;
    private int heartRate;
    private int oxygenLevel;
    private int bloodPressure;
    private double temprature;

    // constructors for vitalsign class
    public VitalSigns() {
        this("N/A");
    }

    public VitalSigns(String patientID) {
        this(patientID, 0);
    }

    public VitalSigns(String patientID, int heartRate) {
        this(patientID, heartRate, 0);
    }

    public VitalSigns(String patientID, int heartRate, int oxygenLevel) {
        this(patientID, heartRate, oxygenLevel, 0);
    }

    public VitalSigns(String patientID, int heartRate, int oxygenLevel, int bloodPressure) {
        this(patientID, heartRate, oxygenLevel, bloodPressure, 0.0);
    }

    public VitalSigns(String patientID, int heartRate, int oxygenLevel, int bloodPressure, double temprature) {
        this.heartRate = heartRate;
        this.oxygenLevel = oxygenLevel;
        this.bloodPressure = bloodPressure;
        this.temprature = temprature;
        this.patientID = patientID;
    }

    // setters for vitalsigns class
    void setHeartRate(int heartRate) {
        this.heartRate = heartRate;
    }

    void setOxygenLevel(int oxygenLevel) {
        this.oxygenLevel = oxygenLevel;
    }

    void setbloodPressure(int bloodPressre) {
        this.bloodPressure = bloodPressre;

    }

    void setTemprature(double temprature) {
        this.temprature = temprature;

    }

    // getters fro vitalsigns class
    public int gethearRate() {
        return heartRate;
    }

    public int getOxygenLevel() {
        return oxygenLevel;
    }

    public int getBoodPressure() {
        return bloodPressure;
    }

    public double getTemprature() {
        return temprature;
    }

    public String getPatientID() {
        return patientID;
    }

    public String toString() { // overriden to string methode
        return "\nPatient ID : " + patientID + "\nHeartrate : " + heartRate + "\nOxygen Level :" + oxygenLevel +
                "\nTemprature : " + temprature;

    }
}

// * * * * * database creation for storing vital signs * * * * *

class VitalsDataBase {

    ArrayList<VitalSigns> vitalsigns1;

    VitalsDataBase() {
        vitalsigns1 = new ArrayList<>();
    }

    public void vitalsadd(VitalSigns obj) {
        vitalsigns1.add(obj);
        System.out.println("Vital signs of patient : " + obj.getPatientID() + " have been Saved");
    }

    public void getvitalSigns(String patientID) { // methdoe to get vitalsigns of a patient
        if (vitalsigns1.isEmpty()) {
            System.out.println("Vital Signs Database is empty");
            return;
        } else {
            for (VitalSigns vital : vitalsigns1) { // for each loop extrating array elements one by one
                if (vital.getPatientID().equals(patientID)) {
                    System.out.println(vital);
                }
            }
        }
    }
}

// * * * * * Appoitment class * * * * *

class Appointment {
    private static int appoitmentID;
    private String date;
    private String time;
    private Doctor doctor; // Reference to the doctor
    private Patient patient; // Reference to the patient
    private String status; // Appointment status
    private String pEmial;
    // Constructor

    public Appointment(String date, String time, Doctor doctor, Patient patient,String pEmial) {
        this.date = date;
        this.time = time;
        this.doctor = doctor;
        this.patient = patient;
        this.pEmial=pEmial;
        this.status = "Pending";
        this.appoitmentID = AppointmentManager.nextAppointmentID++;
    }

    // Getters for Appoitment class
    public String getDate() {
        return date;
    }
    public String getpEmial(){return pEmial;}

    public String getTime() {
        return time;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public Patient getPatient() {
        return patient;
    }

    public String getStatus() {
        return status;
    }

    public static int getAppoitmentID() {
        return appoitmentID;
    }

    // Setters for Appoitments
    public void setDate(String date) {
        this.date = date;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setAppoitmentID(int appoitmentID) {
        this.appoitmentID = appoitmentID;
    }

    public String toString() { // overriden toString function
        return "Appointment Date: " + date + ", \nTime: " + time + ", \nDoctor: " + doctor.getName() +
                ", \nPatient: " + patient.getName() + ", \nStatus: " + status;
    }
}

// * * * * * Appointment manager Class * * * * *

class AppointmentManager {

    static int nextAppointmentID = 1; // id generation

    public void addAppointment(Appointment appointment, ArrayList<Appointment> Appoint) { // Adding Appointments to the
                                                                                          // array list
        Appoint.add(appointment);
        System.out.println("Appointment Added for patient " + appointment.getPatient().getName());
    }

    // Method to change appointment status
    public void updateAppointmentStatus(int appointmentID, String newStatus, ArrayList<Appointment> Appoint) {
        boolean found = false;
        for (Appointment appointment : Appoint) {
            if (appointment.getAppoitmentID() == appointmentID) {
                appointment.setStatus(newStatus); // Set new status
                System.out.println("Appointment ID " + appointmentID + " status updated to: " + newStatus);
                found = true;
                boolean Approved;
                if(newStatus.toLowerCase().equals("approved") ) {Approved = true;} else Approved = false ;
                if(Approved){
                    RemainderService notifi = new RemainderService (new EmailNotification("seecs968@gmail.com","meib qggm bmoz jxsl "));
                    notifi.sendAppointmentReminder(appointment.getpEmial(), appointment.getDate(), appointment.getTime(),appointment.getDoctor().getName());
                }
                break;


            }
        }
        if (!found) {
            System.out.println("Appointment with ID " + appointmentID + " not found.");
        }
    }

    public void PrintAllAppointments(ArrayList<Appointment> Appoint) {
        int i = 1; // function to print appointments
        for (Appointment appointment : Appoint) {

            System.out.println("Appointment Number " + i + " : ");
            System.out.println(appointment.toString()); // caliing the overrideen to string function to print all
                                                        // appointments
            ++i;

        }
    }
}

// * * * * * Feedback class * * * * *

class Feedback {

    private String message;
    private String doctorID;
    private String patientID;
    private String patientName;
    public LocalDate dateGiven;

    // constructors used to initilize the varaibles
    public Feedback() {
        this("N/A");

    }

    public Feedback(String message) {
        this(message, "N/A");

    }

    public Feedback(String message, String doctorID) {
        this(message, doctorID, "N/A");
    }

    public Feedback(String message, String doctorID, String patientID) {
        this(message, doctorID, patientID, "N/A");
    }

    public Feedback(String message, String doctorID, String patientID, String PatientName) {
        this.message = message;
        this.doctorID = doctorID;
        this.patientID = patientID;
        this.patientName = PatientName;
        this.dateGiven = LocalDate.now();
    }

    // setters

    public void setMessage(String message) {
        this.message = message;
    }

    public void setDoctorID(String doctorID) {
        this.doctorID = doctorID;
    }

    public void setPatientID(String patientID) {
        this.patientID = patientID;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    // getters

    public String getMessage() {
        return message;
    }

    public String getDoctorID() {
        return doctorID;
    }

    public String getPatientID() {
        return patientID;
    }

    public String getPatientName() {
        return patientName;
    }

    @Override
    public String toString() { // overridden to string function
        return "Patient to which Feedback is given : " + patientName +
                "\n Doctor which gave the Feedback : " + doctorID +
                "\n Feedback : " + message + "\nDate : " + dateGiven;

    }
}

// * * * * * Medical History class * * * * *

class MedicalHistory {
    private String patientID;
    private String illness;
    private String treatment;
    private String doctorName;

    // Constructors using chaining
    public MedicalHistory() {
        this("N/A", "N/A", "N/A", "N/A");
    }

    public MedicalHistory(String patientID) {
        this(patientID, "N/A", "N/A", "N/A");
    }

    public MedicalHistory(String patientID, String illness) {
        this(patientID, illness, "N/A", "N/A");
    }

    public MedicalHistory(String patientID, String illness, String treatment) {
        this(patientID, illness, treatment, "N/A");
    }

    public MedicalHistory(String patientID, String illness, String treatment, String doctorName) {
        this.patientID = patientID;
        this.illness = illness;
        this.treatment = treatment;
        this.doctorName = doctorName;
    }

    // Setters
    public void setPatientID(String patientID) {
        this.patientID = patientID;
    }

    public void setIllness(String illness) {
        this.illness = illness;
    }

    public void setTreatment(String treatment) {
        this.treatment = treatment;
    }

    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }

    // Getters
    public String getPatientID() {
        return patientID;
    }

    public String getIllness() {
        return illness;
    }

    public String getTreatment() {
        return treatment;
    }

    public String getDoctorName() {
        return doctorName;
    }

    @Override
    public String toString() {
        return "Medical History for patient ID: " + patientID +
                "\nIllness: " + illness +
                "\nTreatment: " + treatment +
                "\nDoctor: " + doctorName;
    }
}

// * * * * * Priscription class * * * * *

class Prescription {
    private String patientID;
    private String medication;
    private String dosage;
    private String doctorName;
    private String pEmail;

    // Constructors using chaining
    public Prescription() {
        this("N/A", "N/A", "N/A", "N/A","N/A");
    }

    public Prescription(String patientID) {
        this(patientID, "N/A", "N/A", "N/A");
    }

    public Prescription(String patientID, String medication) {
        this(patientID, medication, "N/A", "N/A","N/A");
    }

    public Prescription(String patientID, String medication, String dosage) {
        this(patientID, medication, dosage, "N/A","N/A");
    }

    public Prescription(String patientID, String medication, String dosage,String doctorName) {
        this(patientID, medication, dosage,doctorName,"N/A");
    }

    public Prescription(String patientID, String medication, String dosage, String doctorName,String pEmail) {
        this.patientID = patientID;
        this.medication = medication;
        this.dosage = dosage;
        this.doctorName = doctorName;
        this.pEmail = pEmail;
    }

    // Setters
    public void setPatientID(String patientID) {
        this.patientID = patientID;
    }

    public void setMedication(String medication) {
        this.medication = medication;
    }

    public void setDosage(String dosage) {
        this.dosage = dosage;
    }

    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }

    // Getters
    public String getpEmail(){
        return pEmail;
    }
    public String getPatientID() {
        return patientID;
    }

    public String getMedication() {
        return medication;
    }

    public String getDosage() {
        return dosage;
    }

    public String getDoctorName() {
        return doctorName;
    }

    @Override
    public String toString() { // overriden to string function
        return "Prescription for patient ID: " + patientID +
                "\nMedication: " + medication +
                "\nDosage: " + dosage +
                "\nDoctor: " + doctorName;
    }
}






//  Assignment 3

//interfaces
interface NotificationService{
    void sendAlert(String message,String tomedium);
}
interface Contact{
    void start(String toemail);
}
interface Notifiable{
    void sendRemainder(String message , String to);
}


//ReminderSerive class
class RemainderService{ // reminder service class
    private Notifiable notifiable ;  // will be used for doing upcasting

    public RemainderService(Notifiable notifiable ){ // constructor
        this.notifiable=notifiable;
    }

    public void sendAppointmentReminder(String recipientEmail, String appointmentDate, String appointmentTime, String doctorName) {
        String message = " Asalam-o-Alikum Dear Patient! Reminder:(Appointment Approved) You have an appointment with Dr. " + doctorName +
                " on " + appointmentDate + " at " + appointmentTime;
        notifiable.sendRemainder(message, recipientEmail);
    }

    public void sendMedicationReminder(String recipientEmail, Prescription prescription) {
        String message = " Asalam-o-Alikum Dear Patient! Reminder: Take your medication - " + prescription.getMedication() +
                " (" + prescription.getDosage() + ")" + " as prescriberd by (and Reminded by)  Dr : " + prescription.getDoctorName();

        notifiable.sendRemainder(message, recipientEmail);
    }

    public void sendGeneralReminder(String recipient, String message) {
        notifiable.sendRemainder(message, recipient);
    }


}

//EmailNotification Class which implements NotificationService and Notifiable interfaces
class EmailNotification implements NotificationService,Notifiable{
    final String fromEmail ;
    final String password ;

    EmailNotification(String fromEmail , String password){
        this.fromEmail = fromEmail ;
        this.password = password;
    }


    public void sendAlert(String message, String toEmail){
        Properties variable = new Properties(); // properties class to hold Simple mail transfer proptocal settings
        variable.put("mail.smtp.auth", "true");
        variable.put("mail.smtp.starttls.enable", "true");
        variable.put("mail.smtp.host", "smtp.gmail.com");
        variable.put("mail.smtp.port", "587");


        Session session = Session.getInstance(variable,
                new Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(fromEmail, password);
                    }
                });

        try {
            Message emailMessage = new MimeMessage(session);
            emailMessage.setFrom(new InternetAddress(fromEmail));
            emailMessage.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toEmail));
            emailMessage.setSubject(" Asalam-o-Alikum! Emergency Alert from Hospital");
            emailMessage.setText(message);


            Transport.send(emailMessage);
            System.out.println(" Email Alert Sent to " + toEmail);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(" Failed to send email.");
        }

    }


    public void sendRemainder(String message , String toEmail){
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

        Session session = Session.getInstance(props,
                new Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(fromEmail, password);
                    }
                });

        try {
            Message emailMessage = new MimeMessage(session);
            emailMessage.setFrom(new InternetAddress(fromEmail));
            emailMessage.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toEmail));
            emailMessage.setSubject("Reminder from Hospital");
            emailMessage.setText(message);

            Transport.send(emailMessage);
            System.out.println("Reminder email sent to " + toEmail);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Failed to send reminder email.");
        }

    }



}

/*SmsNotification Class which implements NotificationService and Notifiable interfaces
Currently its just a body we have  mainly worked with email class */

class SmsNotification implements NotificationService,Notifiable{ //this class  can be extended


    public void sendAlert(String message , String doctorID){
        System.out.println("Sms Alert Send : " + message + " To doctor : " + doctorID ) ;

    }

    public void sendRemainder(String message, String phoneNumber) {
        System.out.println("SMS Reminder Sent: " + message + " To: " + phoneNumber);
    }

}

//EmergencyAlert Class
class EmergencyAlert{

    private NotificationService notification ;

    public EmergencyAlert(NotificationService notification){
        this.notification = notification ;
    }


    public boolean checkVitals(VitalSigns vitalsign, String doctorsEmail){ // function to check if the patients condtion is critical

        if(vitalsign.gethearRate()<50 || vitalsign.gethearRate()>100 || vitalsign.getOxygenLevel()<90 ||
                vitalsign.getBoodPressure()>140  || vitalsign.getTemprature() > 38.0){

            System.out.println("Emergency declared for patient " + vitalsign.getPatientID());
            // sending notification
            String messsage =  " ** Emergency! vital signs exceeded maxmium limit ** \n🚨 ALERT for Patient " + vitalsign.getPatientID() + ": \nHR=" + vitalsign.gethearRate() +
                        "\nO2=" + vitalsign.getOxygenLevel() + "\nBP=" + vitalsign.getBoodPressure() +
                        "\nTemp=" + vitalsign.getTemprature() + "\nat " + java.time.LocalDateTime.now() ;


            notification.sendAlert( messsage, doctorsEmail);
            return true ;
        } return false ;

    }

}

//PanicButton Class
class PanicButton{

    private NotificationService notification ;

    public PanicButton(NotificationService notification){ // constructor to initilize NotificationService Object
        this.notification = notification ;
    }

    public void Press(String patientID,String doctorsEmail ){ // function to send notification about panic button

        System.out.println("Panic button pressed by Patient " + patientID) ;
        notification.sendAlert("Panic button pressed by Patient " + patientID , doctorsEmail);

    }


}

//VedioCall class which implements inteface Contact
class Vediocall implements  Contact{
    private String link;
    protected String platform ;
    private NotificationService emailNotification ;

    Vediocall(String link , String platform , NotificationService emailNotification){
        this.link=link;
        this.platform = platform ;
        this.emailNotification = emailNotification ;
    }

    public void setLink(String link){
        this.link=link;
    }
    public void setPlatform(String platform){
        this.platform=platform;
    }

    public String getLink(){
        return this.link;
    }

    public String getPlatform(){
        return this.platform;
    }

    public void start(String toemail){
        String message = "Dear User Please Join Vedio Call via the Link undergiven : \n" + this.link +
                "\nusing platform" + this.platform;
        emailNotification.sendAlert(message , toemail);
    }

}

//chatClient class for whatsapp chats which implements inteface Contact
class ChatClient implements Contact{
    private String senderContact ; // class variables
    private String chatLink ;
    private NotificationService emailNotification ;

    ChatClient(String senderContact , String chatLink , NotificationService emailNotification){  // constructors
        this.senderContact = senderContact;
        this.chatLink = chatLink;
        this.emailNotification = emailNotification ;

    }



    // setters and getters
    public void setSenderContact(String senderContact){
        this.senderContact=senderContact;
    }
    public void setChatLink(String chatLink){
        this.chatLink=chatLink;
    }

    public String getSenderContact(){
        return this.senderContact;
    }

    public String getChatLink(){
        return this.chatLink;
    }

    public void start(String toemail){ // methode which is the core methode to send the chatlink via email
        String message = "Dear User Please Join the chat through the undergiven Link : \n" + this.chatLink +
                "\nusing Whatsapp" ;
        emailNotification.sendAlert(message , toemail);

    }
}




