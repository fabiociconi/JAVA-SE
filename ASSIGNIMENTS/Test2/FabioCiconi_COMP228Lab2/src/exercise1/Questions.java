/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exercise1;

import java.util.Random;
import javax.swing.*;
/**Class to show questions and Answers
* @author Fabio Alexandre Ciconi -- 300930909
* @version 1
* @since Release 10/02/2017
*/
class Questions 
{
   private String titleQuestions[];
   private String answers[][];
   private int corretAnswers[];
   private int givenAnswers[];
   private String feedAnswersRight[];
   private String feedAnswersWrong[];
   private static final int TOTALQUESTION = 4;  
   
   Questions()
   {
      //titleQuestions = new String[4];
      corretAnswers = new int[]{0,3,2,2,3};
      givenAnswers = new int[5];
      titleQuestions = new String[] {"How is the command used to validate Execeptions?"
                                    ,"Which is not an type of access ?"
                                    ,"Which is the acess type of main method?"
                                    ,"Which Simbols delimit an enum declaration?"
                                    ,"Whis is not a loop in Java?"}; 
      answers = new String[][] {{"(1)try...catch ","(2) try...again","(3) plase...ok","(4) try...error"},
                                              {"(1) private ","(2) public","(3) protected","(4) internal"},
                                              {"(1)int ","(2) boolean","(3) static","(4) protected"},
                                              {"(1)(...) ","(2) [...]","(3) {...}","(4) /.../"},
                                              {"(1) for ","(2) switch","(3) while","(4) perform until"}};
      feedAnswersRight = new String[] {"Good!", "Excellent!", "Keep up the good work!","Nice work!" };
   
      feedAnswersWrong = new String[] {"No. Please try again","Wrong. Try once more",  "Keep up the good work!",
                                       "Don't give up!","No. Keep trying.." };
   }
   
   public int showQuestions (int questionNumber)
    {
       
         return JOptionPane.showOptionDialog(null,titleQuestions[questionNumber],"Question " + (questionNumber + 1),
         JOptionPane.YES_NO_CANCEL_OPTION,JOptionPane.QUESTION_MESSAGE,null,
         answers[questionNumber] ,null); 
   
   }
   //teste
   public String getFeedRigth(int feedAnswer)
   {
      return feedAnswersRight[feedAnswer];
   }
   public void setFeedRight(int feedAnswer, String rightAnswer)
   {
      feedAnswersRight[feedAnswer] = rightAnswer;
   }
   //teste
   
   public int getCorrectAwnsers(int question)
   {
      return corretAnswers[question];
   }
   
   public void setGivenAnswer(int answer, int question)
   {
      givenAnswers[question] = answer;
   }
   public int getGivenAnswer(int question)
   {
      return givenAnswers[question];
   }
   
   public void doTest()
   {
      int answer;
      int recordAnswer = 0;
      String feed = null;
      Random number = new Random();
      
      //Questions quiz = new Questions();
      for (int i = 0; i <= TOTALQUESTION; i++)
      {
         
         //teste
         
         //this.setFeedRight(i,feed);
         //*teste
         
         answer = this.showQuestions(i);
         this.setGivenAnswer(answer,i);
         
         if(this.getCorrectAwnsers(i)==this.getGivenAnswer(i))
            
         {
            recordAnswer ++;
            switch(number.nextInt(4))
            {
               case 0:
                  JOptionPane.showMessageDialog(null, feed=this.getFeedRigth(0), "Question "+(i+1),JOptionPane.INFORMATION_MESSAGE);
                  break;
               case 1:
                  JOptionPane.showMessageDialog(null, feed=this.getFeedRigth(1),"Question "+(i+1),JOptionPane.INFORMATION_MESSAGE);
                  break;
               case 2:
                  JOptionPane.showMessageDialog(null, feed=this.getFeedRigth(2),"Question "+(i+1),JOptionPane.INFORMATION_MESSAGE);
                  break;
               case 3:
                  JOptionPane.showMessageDialog(null, feed=this.getFeedRigth(3),"Question "+(i+1),JOptionPane.INFORMATION_MESSAGE);
                  break;
            }
         }else
         {
            switch(number.nextInt(4))
            {
               case 0:
                  JOptionPane.showMessageDialog(null, "No. Please try again", "Question "+(i+1),JOptionPane.ERROR_MESSAGE);                
                  break;
               case 1:
                  JOptionPane.showMessageDialog(null, "Wrong. Try once more", "Question "+(i+1),JOptionPane.ERROR_MESSAGE);
                  break;
               case 2:
                  JOptionPane.showMessageDialog(null,  "Don't give up!", "Question "+(i+1),JOptionPane.ERROR_MESSAGE);
                  break;
               case 3:
                  JOptionPane.showMessageDialog(null, "No. Keep trying.." , "Question "+(i+1),JOptionPane.ERROR_MESSAGE);
                  break;
            }
            JOptionPane.showMessageDialog(null,"Correct Answer: " +(this.getCorrectAwnsers(i)+1) ,"Question "+(i+1),JOptionPane.PLAIN_MESSAGE);
         }
      }
      double statics =  (double)recordAnswer/(TOTALQUESTION + 1) * 100;
      
      JOptionPane.showMessageDialog(null, "You Achieved "+statics+"%","Final Results",JOptionPane.INFORMATION_MESSAGE);
               
   }
}

      

    


