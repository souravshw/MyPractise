package io.practise.Exception_Examples;

public class ThrowsExample {
	//Rule: By default, Checked Exceptions are not forwarded in calling chain (propagated).
		//and  must be handled or declared
	
	//Here we will handle
	
		 void m(){  
			 try{
			    throw new java.io.IOException("device error");//checked exception  
			  }  
			 catch(Exception e)
			 {
				 System.out.println("Exception is "+e);
			 }
		 }
			  void n(){  
			    m();  
			  }  
			  void p(){  
			   try{  
			    n();  
			   }catch(Exception e){System.out.println("exception handeled");}  
			  }  
			  public static void main(String args[]){  
				  ThrowsExample obj=new ThrowsExample();  
			   obj.p();  
			   System.out.println("normal flow");  
			  } 
}

class ThrowsExampleDeclare {
	//Rule: By default, Checked Exceptions are not forwarded in calling chain (propagated).
		//and  must be handled or declared
	
	//Here we will declare
	
		 void m()throws java.io.IOException{  
			 
			    throw new java.io.IOException("device error");//checked exception  
			   		
		      }
		 
			  void n()throws java.io.IOException{  
			    m();  
			  }  
			  void p(){  
			   try{  
			    n();  
			   }catch(Exception e){System.out.println("exception handeled");}  
			  }  
			  public static void main(String args[]){  
				  ThrowsExampleDeclare  obj=new ThrowsExampleDeclare ();  
			   obj.p();  
			   System.out.println("normal flow");  
			  } 
}

