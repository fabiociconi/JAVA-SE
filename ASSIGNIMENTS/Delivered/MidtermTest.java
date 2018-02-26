

import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
        
/**
 *
 * @author Fabio Alexandre Ciconi
 */

public class MidtermTest
{

   /**
    *
    */
   static void printInfo(Phone sd)
   {
 
      System.out.println(sd.toString());
   }
   
      
   
   /**
    * @param args the command line arguments
    */
   public static void main(String[] args) 
   {
      Phone[] array = new Phone[4];
     // Scanner input = new Scanner(System.in);
     
         array[0]   = new Mobile  ("416-111-2222", "12345", "brand1", 0.50, 10);
         array[1]   = new Mobile  ("647-111-3333", "66789","brand1", 0.6, 40);
         array[2]   = new Landline("416-222-3333", "000001", "brand4", .10, 40);
      for (int i =0; i < 3; i++)
      {
         
      
         printInfo(array[i]);
         // PersonalMortgage(morgageType,(i+1), newCustomerName, newAmount,newTerm);
         /*for ( Phone aPhone : array )
         {
            System.out.println( aPhone ); 
            
            if ( aPhone instanceof Mobile) 
               aPhone.setBillingRate(i);
            else
               aPhone.setBillingRate(i);
            //employee.setBaseSalary( 1.10 * employee.getBaseSalary() );*/
         }
         
         
      }
      

     

  
}

abstract class Phone
{
   protected String phoneNumber;
   protected String serialNumber;
   protected String brand;
   protected double billingRate;
   protected int    minutes;

   public Phone(String phoneNumber, String serialNumber, String brand, double billingRate, int minutes) {
      this.phoneNumber = phoneNumber;
      this.serialNumber = serialNumber;
      this.brand = brand;
      this.billingRate = billingRate;
      this.minutes = minutes;
   }

   public String getPhoneNumber() {
      return phoneNumber;
   }

   public void setPhoneNumber(String phoneNumber) {
      this.phoneNumber = phoneNumber;
   }

   public String getSerialNumber() {
      return serialNumber;
   }

   public void setSerialNumber(String serialNumber) {
      this.serialNumber = serialNumber;
   }

   public String getBrand() {
      return brand;
   }

   public void setBrand(String brand) {
      this.brand = brand;
   }

   public int getMinutes() {
      return minutes;
   }

   public void setMinutes(int minutes) {
      this.minutes = minutes;
   }
   
   public abstract double setBillingRate(double rate); 
   
}
class Mobile extends Phone
{

   public Mobile(String phoneNumber, String serialNumber, String brand, double billingRate, int minutes) {
      super(phoneNumber, serialNumber, brand, billingRate, minutes);
   }

   @Override
   public double setBillingRate(double rate) 
   {
      return rate*(1+0.02);
     
     // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
   }
   // return String representation of BasePlusCommissionEmployee
   @Override // indicates that this method overrides a superclass method
   public String toString()
   {
         
        return String.format("phone number%s", phoneNumber, "serial number%s", serialNumber,
          "breand%s", brand, 
          "rate%d", billingRate,
          "minutes", minutes );
   }
}
class Landline extends Phone
{

   public Landline(String phoneNumber, String serialNumber, String brand, double billingRate, int minutes) {
      super(phoneNumber, serialNumber, brand, billingRate, minutes);
   }

   public String toString()
   {
         
        return String.format("phone number%s", phoneNumber,
          "serial number%s", serialNumber,
          "breand%s", brand, 
          "rate%d", billingRate,
          "minutes", minutes );
   }
   @Override
   public double setBillingRate(double rate) {
     // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
     return rate*(1+0.10);
   }
}