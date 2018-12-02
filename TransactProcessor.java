import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.io.*;

public class TransactProcessor implements Information {
	
	 public String TransactionsProcessed(){
		 return "";
	 }
	 
	 public String UnableToFillPrescription(){
		return ""; 
	 }
	 
	 public String PrescriptionFilledSuccessfully(){
		 return "";
	 };
	 
	 public static void doctorsReport(String lookup, ArrayList<Drugs>drugsArray){
		 //print report to file
	 }
	 
	 public static void drugsContraInd(String lookup, ArrayList<Drugs> drugsArray){
		 //print report to file 
	 }
	 
	 public static void contactDoctor(String lookup, ArrayList<Drugs> drugsArray){
		//print report to file
	 }
	 
	 /**
	  * Method to load the Drugs.txt file into an ArrayList
	  * @param inputFile File to be read
	  * @return loaded arrayList of object Drugs
	  */
	 public static ArrayList<Drugs> loadDrugs(File inputFile) {
		ArrayList<Drugs> arrayDrugs = new ArrayList<>();
	    try{
			System.out.println("----------------------------------------");
			System.out.println("-------- Loading Drugs --------------");
	    	Scanner file = new Scanner(inputFile);
	    	file.useDelimiter(",");
	    	String str = "";
	    	String str1 = "";
			int i = 0;
			while(file.hasNextLine()){
				str = file.nextLine();
				if ( !str.equals("") ){
					Scanner txt = new Scanner(str);				
					txt.useDelimiter(",");
					Drugs d = new Drugs(txt.next(), txt.next(), txt.next(), txt.next(), txt.nextInt(), txt.nextBoolean());
					str1 = txt.next();
					while (!str1.equals("/")){
				 		d.addIngredients(str1);
						str1 = txt.next();
					}
					while (txt.hasNext()){
						d.addContraInd(txt.next());
					}
					arrayDrugs.add(i, d);
					d.getInfo();
					System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
					i++;
				}
			}
			file.close();
			return arrayDrugs;
		}catch (FileNotFoundException e) {
		  	System.out.println(e.toString());
			return arrayDrugs;
	    }
	 }

	 /**
	  * Method to load the Doctor.txt file into an ArrayList
	  * @param inputFile File to be read
	  * @return loaded arrayList of object Doctor
	  */
	 public static ArrayList<Doctor> loadDoctor(File inputFile) {
		ArrayList<Doctor> arrayDoctor = new ArrayList<>();
	    try{
			System.out.println("---------- Loading Doctor --------------");
	    	Scanner file = new Scanner(inputFile);
	    	file.useDelimiter(",");
	    	String str = "";
			int i = 0;
			while(file.hasNextLine()){
				str = file.nextLine();
				if ( !str.equals("") ){
					Scanner txt = new Scanner(str);				
					txt.useDelimiter(",");
					Doctor d = new Doctor(txt.next(), txt.next(), txt.next(), txt.next());
					System.out.println(d.getInfo());
					arrayDoctor.add(i, d);
					i++;
				}
			}
			file.close();
			return arrayDoctor;
		}catch (FileNotFoundException e) {
		  	System.out.println(e.toString());
			return arrayDoctor;
	    }
	 }
	 
	 /**
	  * Method to load the Patients.txt file into an ArrayList
	  * @param inputFile File to be read
	  * @return loaded arrayList of object Patients
	  */
	 public static ArrayList<Patients> loadPatients(File inputFile) {
		 ArrayList<Patients> arrayPatients = new ArrayList<>();
		 try{
			System.out.println("----------------------------------------");
			System.out.println("-------- Loading Patients --------------");
		   	Scanner file = new Scanner(inputFile);
		   	file.useDelimiter(",");
		   	String str = "";
			int i = 0;
			while(file.hasNextLine()){
				str = file.nextLine();
				if ( !str.equals("") ){
					Scanner txt = new Scanner(str);				
					txt.useDelimiter(",");
					Patients p = new Patients(txt.next(), txt.next(), txt.next(), txt.next(), txt.next());
					System.out.println(p.getInfo());
					arrayPatients.add(i, p);
					i++;
				}
			}
			file.close();
			return arrayPatients;
		} catch (FileNotFoundException e) {
		  	System.out.println(e.toString());
		  	return arrayPatients;
	    }
	 }
	 
	 /**
	  * Method to load the Pharmacists.txt file into an ArrayList
	  * @param inputFile File to be read
	  * @return loaded arrayList of object Pharmacists
	  */
	 public static ArrayList<Pharmacists> loadPharmacists(File inputFile) {
		 ArrayList<Pharmacists> arrayPharmacists = new ArrayList<>();
		 try{
			System.out.println("----------------------------------------");
			System.out.println("-------- Loading Pharmacists --------------");
		   	Scanner file = new Scanner(inputFile);
		   	file.useDelimiter(",");
		   	String str = "";
			int i = 0;
			while(file.hasNextLine()){
				str = file.nextLine();
				if ( !str.equals("") ){
					Scanner txt = new Scanner(str);				
					txt.useDelimiter(",");
					Pharmacists p = new Pharmacists(txt.next(), txt.next(), txt.next(), txt.next(), txt.next());
					System.out.println(p.getInfo());
					arrayPharmacists.add(i, p);
					i++;
				}
			}
			file.close();
			return arrayPharmacists;
		}catch (FileNotFoundException e) {
		  	System.out.println(e.toString());
		  	return arrayPharmacists;
	    }
	 }
	 
	 /**
	  * Method to load the Prescriptions.txt file into an ArrayList
	  * @param inputFile File to be read
	  * @return loaded arrayList of object Prescriptions
	  */
	 public static ArrayList<Prescriptions> loadPrescriptions(File inputFile) {
		 ArrayList<Prescriptions> arrayPrescriptions = new ArrayList<>();
		 try{
			System.out.println("---------------------------------------------");
			System.out.println("-------- Loading Prescriptions --------------");
		   	Scanner file = new Scanner(inputFile);
		   	file.useDelimiter(",");
		   	String str = "";
			int i = 0;
			while(file.hasNextLine()){
				str = file.nextLine();
				if ( !str.equals("") ){
					Scanner txt = new Scanner(str);				
					txt.useDelimiter(",");
					Prescriptions p = new Prescriptions(txt.nextInt(), txt.next(), txt.next(), txt.next(), txt.next());
					System.out.println(p.getInfo());
					arrayPrescriptions.add(i, p);
					i++;
				}
			}
			file.close();
			return arrayPrescriptions;
		}
		 	catch (FileNotFoundException e) {
		  	System.out.println(e.toString());
		  	return arrayPrescriptions;
        }
	 }
	 
	 /**
	  * Method to load the DrugLine.txt file into an ArrayList
	  * @param inputFile File to be read
	  * @return loaded arrayList of object DrugLine
	  */
	 public static ArrayList<DrugLine> loadDrugLine(File inputFile) {
		 ArrayList<DrugLine> arrayDrugLine = new ArrayList<>();
		 try{
			System.out.println("---------------------------------------------");
			System.out.println("-------- Loading Drug Line --------------");
			System.out.println("---------------------------------------------");
		   	Scanner file = new Scanner(inputFile);
		   	file.useDelimiter(",");
		   	String str = "";
			int i = 0;
			while(file.hasNextLine()){
				str = file.nextLine();
				if ( !str.equals("") ){
					Scanner txt = new Scanner(str);				
					txt.useDelimiter(",");
					DrugLine dl = new DrugLine(txt.nextInt(), txt.next(), txt.nextInt(), txt.next(), txt.nextInt(), txt.nextInt());
					System.out.println(dl.getInfo());
					arrayDrugLine.add(i, dl);
					i++;
				}
			}
			file.close();
			return arrayDrugLine;
		}
		 catch (FileNotFoundException e) {
		  	System.out.println(e.toString());
		  	return arrayDrugLine;
	    }
	 }
	 
	 /**
	  * This method load txt files into arrays of object types: 
	  * Doctor, Patients, Pharmacists, Drugs, Prescriptions, Drugline
	  */
	 public static void loadFiles(){
		 
			File doctor = new File("Doctor.txt");
			File patients = new File("Patients.txt");
			File pharmacists = new File("Pharmacists.txt");
			File drugs = new File("Drugs.txt");
			File prescriptions = new File("Prescriptions.txt");
			File drugline = new File("DrugLine.txt");
			File transactions = new File("Transactions.txt");
					
			ArrayList<Doctor> doctorArray = new ArrayList<>();
			ArrayList<Patients> patientsArray = new ArrayList<>();
			ArrayList<Pharmacists> pharmacistsArray = new ArrayList<>();
			ArrayList<Drugs> drugsArray = new ArrayList<>();
			ArrayList<Prescriptions> prescriptionsArray = new ArrayList<>();
			ArrayList<DrugLine> druglineArray = new ArrayList<>();
			
			doctorArray = loadDoctor(doctor);
			patientsArray = loadPatients(patients);
			pharmacistsArray = loadPharmacists(pharmacists);
			drugsArray = loadDrugs(drugs);
			prescriptionsArray = loadPrescriptions(prescriptions);
			druglineArray = loadDrugLine(drugline);
			processTransactions(doctorArray, patientsArray, pharmacistsArray, drugsArray, prescriptionsArray, druglineArray, transactions);
			prescriptionsReport(prescriptionsArray, druglineArray);
		 
	 }
	 
	 public static void processTransactions(ArrayList<Doctor> doctorArray, ArrayList<Patients> patientsArray, 
			                                ArrayList<Pharmacists> pharmacistsArray, ArrayList<Drugs> drugsArray, 
			                                ArrayList<Prescriptions> prescriptionsArray, ArrayList<DrugLine>druglineArray, File inputFile){
		 
		 try{
			System.out.println("---------------------------------------------");
			System.out.println("-------- Loading Transactions  --------------");
			System.out.println("---------------------------------------------");
		   	Scanner file = new Scanner(inputFile);
		   	file.useDelimiter(",");
		   	String str = "";
			int count = 0;
			int i = 0;
			String line[] = new String[12];
			String trans = "";
			String lookup = "";
			while(file.hasNextLine()){
				str = file.nextLine();
				if ( !str.equals("") ){
					Scanner txt = new Scanner(str);				
					txt.useDelimiter(",");
					trans = txt.next();
					switch (trans){
						case "FP":
							for (i = 0; i < 12; i++){
								if (!txt.hasNext()){
									break;
								}
								line[i] = txt.next();
							}
							if (i > 2){
								//create new prescription
							}else{
								//lookup prescription and update
							}
							break;
						case "FD": //Find doctors who prescribed a determined drug more then stipulated times
							lookup = txt.next();
							doctorsReport(lookup, drugsArray);
							break;
						case "FDC":
							lookup = txt.next();
							drugsContraInd(lookup, drugsArray);							
							break;
						case "CD":
							lookup = txt.next();
							contactDoctor(lookup, drugsArray);
							break;
						default:
							break;
					}
				}
			}
			file.close();
		}
		 catch (FileNotFoundException e) {
		  	System.out.println(e.toString());
	    }
	 
	 }
	 
	 public static void prescriptionsReport(ArrayList<Prescriptions> pr, ArrayList<DrugLine> dl){
		 
		System.out.println("-----------------------------------------------------------------------------------");
		System.out.println("----------------------------- Prescriptions Report --------------------------------");
		System.out.println("-----------------------------------------------------------------------------------");
		int id = 0;
		int bof = 0;
		for (int i = 0; i < pr.size(); i++){
			System.out.println("-----------------------------------------------------------------------------------");
			System.out.println("Prescription: " + "000"+ pr.get(i).getPre_ID() + "  Patient: " + pr.get(i).getPatient() +
					           "     Date: " + pr.get(i).getDate());
			System.out.println("Doctor: " + pr.get(i).getDoctor() + "    Pharmacist: " + pr.get(i).getPharmacist());
			System.out.println("-----------------------------------------------------------------------------------");
			System.out.println("    -------------------------------------------------------------------------------");
			System.out.println("    |   ID   | Drug Name                |   Qty   | Dosage | Ref Left | Times Ref |");
			System.out.println("    -------------------------------------------------------------------------------");
			for (bof = 0; bof < dl.size(); bof++){
				if (dl.get(bof).getPrescID() == pr.get(i).getPre_ID()){
					break;
				}
			}
			for (int j = bof; j < dl.size(); j++){
				if (dl.get(j).getPrescID() != pr.get(i).getPre_ID()){
					break;
				}else{
					System.out.println(dl.get(bof).getReport());
				}
			}
			System.out.println("    -------------------------------------------------------------------------------");
			System.out.println("");
		}
		

	 }

	
	
//-- Main ---------------------------------------------------------------------	
	public static void main(String[] args){
		
		loadFiles();
		
		
		
		
	}
	
//-----------------------------------------------------------------------------

}
