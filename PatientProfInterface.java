import java.util.Scanner;
public class PatientProfInterface 
{

    private String file;
    private PatientProfDB db;

    public PatientProfInterface(String file)
    {
        this.file = file;
        this.db = new PatientProfDB(file);
    }

    //present the user with a menu and record their choice
    public void getUserChoice()
    {
        System.out.println("==============================");
        System.out.println("");
        System.out.println("Please choose an option below:");
        System.out.println("0. Exit\n" + 
                            "1. Enter a new PatientProf\n" + 
                            "2. Delete A patient by Name and adminID\n" + 
                            "3. Find and display a PatientProf by Name and adminID\n" +
                            "4. PatientProf Modifications\n" + 
                            "5. Display all profiles\n" + 
                            "6. Write to database\n" + 
                            "7. Initalize database\n");
        
        Scanner in = new Scanner(System.in);
        while(!in.hasNextInt())
        {
            System.out.print("Please enter number menu option: ");
            in.nextLine();
        }
        int choice = in.nextInt();
        in.nextLine();

        switch(choice)
        {
            case 0:
                System.out.println("Bye.");
                System.exit(0);
                break;
            case 1:
                this.createNewPatientProf();
                break;
            case 2:
                this.deletePatientProf();
                break;
            case 3:
                this.findPatientProf();
                break;
            case 4:
                this.updatePatientProf();
                break;
            case 5:
                this.displayAllPatientProf();
                break;
            case 6:
                //this.writeToDB();
                break;
            case 7:
                //this.initDB();
                break;
            default:
                System.out.println("Not a valid option");
                break;
        }
        //in.close();
    }

    public void deletePatientProf()
    {
        Scanner in = new Scanner(System.in);
        System.out.print("Please enter a patient last name: ");
        String patient = in.nextLine();
        System.out.print("Please enter your adminID: ");
        String id = in.nextLine();

    
        if(this.db.deleteProfile(id, patient))
        {
            System.out.printf("%s deleted\n", patient);
        }
        else
        {
            System.out.println("Patient does not exist, or you do not have permission to delete.");
        }

        //in.close();
    }

    public void findPatientProf()
    {
        Scanner in = new Scanner(System.in);

        System.out.print("Please enter a patient last name: ");
        String patient = in.nextLine();

        System.out.print("Please enter an admin ID: ");
        String id = in.nextLine();

        PatientProf dude = this.db.findProfile(id, patient);
        if(dude == null)
        {
            System.out.println("Patient does not exist, or you do not have permission to view.");
        }
        else
        {
            this.displayPatientProf(dude);
        }

        //in.close();
    }

    public void updatePatientProf()
    {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter a patient last name: ");
        String patient = in.nextLine();

        System.out.print("Enter admin ID: ");
        String id = in.nextLine();

        PatientProf dude = this.db.findProfile(id, patient);

        if(dude == null)
        {
            System.out.println("Patient does not exist, or you do not have permission to modify the profile");
            //in.close();
            return;
        }

        System.out.println("Patient found. Please choose an option below:");
        System.out.println("0. Cancel\n" + 
                            "1. Modify Patient Address\n" + 
                            "2. Modify patient phone\n" + 
                            "3. Modify patient insuType\n" + 
                            "4. Modify patient copay\n" + 
                            "5. Modify patient patient type\n" + 
                            "6. Modify patient MD Contact\n" + 
                            "7. Modify patient MD Phone\n" + 
                            "8. Modify patient illness type\n" + 
                            "9. Modify patient allergy type\n");
         while(!in.hasNextInt())
        {
            System.out.print("Please enter number menu option: ");
            in.nextLine();
        }
        int choice = in.nextInt();
        in.nextLine();
        
        switch(choice)
        {
            case 0:
                System.out.println("Modification Canceled");
                break;
            case 1:
                System.out.print("Please enter new value:");
                String newAddr = in.nextLine();
                dude.updateAddress(newAddr);
                break;
            case 2:
                System.out.print("Please enter new value:");
                String newPhone = in.nextLine();
                dude.updateAddress(newPhone);
                break;
            case 3:
                System.out.print("Please enter new value:");
                String newInsu = in.nextLine();
                dude.updateInsuType(newInsu);
                break;
            case 4:
                System.out.print("Please enter new value:");
                while(!in.hasNextInt())
                {
                    System.out.print("Please enter a numerical value for new Copay: ");
                    in.nextLine();
                }
                int newCopay = in.nextInt();
                in.nextLine();
                dude.updateCopay(newCopay);
                break;
            case 5:
                System.out.print("Please enter new value:");
                String newType = in.nextLine();
                dude.updatePatientType(newType);
                break;
            case 6:
                System.out.print("Please enter new value:");
                String newContact = in.nextLine();
                dude.getMedCondInfo().updateMdContact(newContact);
                break;
            case 7:
                System.out.print("Please enter new value:");
                String newmdphone = in.nextLine();
                dude.getMedCondInfo().updateMdPhone(newmdphone);
                break;
            case 8:
                System.out.print("Please enter new value:");
                String newIll = in.nextLine();
                dude.getMedCondInfo().updateIllType(newIll);
                break;
            case 9:
                System.out.print("Please enter new value:");
                String newAll = in.nextLine();
                dude.getMedCondInfo().updateAlgType(newAll);
                break;
            default:
                System.out.println("Not a valid option");
                break;
        }
        //in.close();
        
    }

    public void displayPatientProf(PatientProf patient)
    {
        System.out.println("AdminID: " + patient.getAdminID());
        System.out.println("First Name: " + patient.getFirstName());
        System.out.println("Last Name: " + patient.getLastName());
        System.out.println("Address: " + patient.getAddress());
        System.out.println("Phone: " + patient.getPhone());
        System.out.println("Copay: : " + patient.getCopay());
        System.out.println("Insu Type: " + patient.getInsuType());
        System.out.println("Patient Type: " + patient.getPatientType());
        System.out.println("Medical Conditions ======== ");
        System.out.println("MD Contact: " + patient.getMedCondInfo().getMdContact());
        System.out.println("MD Phone: " + patient.getMedCondInfo().getMdPhone());
        System.out.println("Alergy Type: " + patient.getMedCondInfo().getAlgType());
        System.out.println("Illness Type: " + patient.getMedCondInfo().getIllType());
    }

    public void displayAllPatientProf()
    {
        Scanner in = new Scanner(System.in);
        System.out.print("Please enter an admin ID: ");
        String id = in.nextLine();

        PatientProf cur = this.db.findFirstProfile(id);

        if(cur == null)
        {
            System.out.println("No patients!");
            //in.close();
            return;
        }

        do
        {
            this.displayPatientProf(cur);
            cur = this.db.findNextProfile(id);
            System.out.println("Press any key for next patient");
            in.nextLine();
        } while(cur != null);

        System.out.println("End of patients list...");
        //in.close();
    }

    //public void writeToDB()

    //public void initDB()

    public void createNewPatientProf()
    {
        Scanner in = new Scanner(System.in);
        System.out.println("Please enter new patient information:");

        System.out.print("adminID: ");
        String adminid = in.nextLine();

        System.out.print("First Name: ");
        String fname = in.nextLine();

        System.out.print("Last Name: ");
        String lname = in.nextLine();

        System.out.print("Address: ");
        String addr = in.nextLine();

        System.out.print("Phone: ");
        String phn = in.nextLine();

        System.out.print("Copay: ");
        while(!in.hasNextInt())
        {
            System.out.print("Please enter a numerical value for Copay: ");
            in.nextLine();
        }
        int pay = in.nextInt();
        in.nextLine();

        System.out.print("Insu Type: ");
        String insu = in.nextLine();

        System.out.print("Patient Type: ");
        String type = in.nextLine();

        MedCond meds = this.createNewMedCond();

        PatientProf newPatient = new PatientProf(adminid, fname, lname, addr, phn, pay, insu, type, meds);

        this.db.insertNewProfile(newPatient);

        System.out.println("Patient Added!");

        //in.close();

    }

    public MedCond createNewMedCond()
    {
        System.out.println("Please enter patient Medical condition information");

        Scanner in = new Scanner(System.in);
        
        System.out.print("MD Contact: ");
        String contact = in.nextLine();
        
        System.out.print("MD Phone: ");
        String mdphone = in.nextLine();

        System.out.print("Allergy Type: ");
        String alg = in.nextLine();

        System.out.print("Illness Type: ");
        String ill = in.nextLine();

        //in.close();

        return new MedCond(contact, mdphone, alg, ill);
    }


    
    //============================
    //MAIN BELOW
    //============================

    public static void main(String[] args)
    {
        System.out.println("Starting...");

        String path = "C:/test";
        PatientProfInterface face = new PatientProfInterface(path);

        while(true)
        {
            face.getUserChoice();
        }
            
    }
}
