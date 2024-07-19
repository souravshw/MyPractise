package myPractice;

public class ExceptionPractice {

	void m(){  
	    int m=50/0;
	  }  
	  void n(){  
	    m();  
	  }  
	  void p(){  
	   try{  
	    n();  
	   }catch(Exception e){System.out.println("Exception Handled");}  
	  }  
	  public static void main(String args[]){  
		  ExceptionPractice obj=new ExceptionPractice();  
	   obj.p();  
	   System.out.println("normal flow");  
	  }  

}
