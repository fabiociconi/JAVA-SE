package week5;


public class FulltimeStudent extends Student {
   void foo()
   {
      //as duas linhas sao a mesma coisa
      getId();
      super.getId();
   }
   void foo2()
   {
      //mesma coisa
      foo();
      this.foo();
   }

}
