

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
      //sd.toString();
      System.out.println(sd.toString());
   }
   
      
   
   /**
    * @param args the command line arguments
    */
   public static void main(String[] args) 
   {
      
      Scanner input = new Scanner(System.in);
     //Mobile salariedEmployee =    new Mobile( "John", "Smith", "111-11-1111", 800.00 );
     
         Mobile sd   = new Mobile  ("416-111-2222", "12345", "brand1", 0.50, 10);
         Mobile sd1   = new Mobile  ("647-111-3333", "66789","brand1", 0.6, 40);
         Landline sd3   = new Landline("416-222-3333", "000001", "brand4", .10, 40);
         Phone[] array = new Phone[3];
         array[0] = sd ;
         array[1] = sd1;                 
         array[2] = sd3;
         for (Phone dd : array ) 
         {
            
            printInfo(dd);
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
   
   @Override // indicates that this method overrides a superclass method
   public String toString()
   {
         
         /*return String.format("phone number%s\n", getPhoneNumber(),
          "serial number%s\n", getSerialNumber(),
          "brand%s", getBrand(), 
          "rate%d", billingRate,
          "minutes%i", getMinutes() );*/
         
         return String.format("Phone Number %s, Serial Number %s, Brand %s, Billing Rate %s, Minutes %s", phoneNumber,
				serialNumber, brand, billingRate, minutes);
   }
}
class Landline extends Phone
{

   public Landline(String phoneNumber, String serialNumber, String brand, double billingRate, int minutes) {
      super(phoneNumber, serialNumber, brand, billingRate, minutes);
   }

   @Override
   public String toString()
   {
         
       /* return String.format("phone number%s", getPhoneNumber(),
          "serial number%s", getSerialNumber(),
          "brand%s", getBrand(), 
          "rate%d", billingRate,
          "minutes%i", getMinutes() );*/
      return String.format("Phone Number %s, Serial Number %s, Brand %s, Billing Rate %s, Minutes %s", phoneNumber,
				serialNumber, brand, billingRate, minutes);
   }
   @Override
   public double setBillingRate(double rate) {
     // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
     return rate*(1+0.10);
   }
}