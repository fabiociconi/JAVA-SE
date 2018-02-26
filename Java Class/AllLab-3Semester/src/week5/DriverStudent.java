/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package week5;

/**
 *
 * @author ZeusAC
 */
public class DriverStudent {

   /**
    * testanto inheritance
    * @param args the command line arguments
    */
   public static void main(String[] args) {
      // TODO code application logic here
      FulltimeStudent ft = new FulltimeStudent();//see full student/person/Student
      ft.getId();
      
      
      Student st =(Student) ft; //only see person and student
      //Student st =ft; mesmoque a linha de cima
      Person pr = (Person)ft; //only see person
      //Person pr = ft mesmo que o de cima
      printNames(st);
      printNames(ft);
      //  printNames(pr); nao funciona
      Object obj = ft;// toda clase tem isso posso usar por esxplo toString
   }
   static void printNames(Student st)
   {
      // fucniona para todos
      System.out.println("name"+st.getName());
   }
   
}
