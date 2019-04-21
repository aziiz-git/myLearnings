package javaPracticing;

public class FinalizeConcept {
	
	public void finalize() {		
		System.out.println("finalize method used for cleanup before Garbage Collection process"); 		
	}

	public static void main(String[] args) {
		
		FinalizeConcept f1 = new FinalizeConcept();	// Memory allocated. f1 is referring to the FinalizeConcept object. 
		FinalizeConcept f2 = new FinalizeConcept();
		
		f1 = null;	// Means, Nobody is referring this object. Garbage collector will kill this object to free up the space. We cannot tell when.
		f2 = null;
		
		// Garbage Collector can be called explicitly as well:
		
		System.gc();	// Garbage collector is called		
	}
}