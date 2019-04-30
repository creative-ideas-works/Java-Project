package singleton.multithreading;

import org.junit.Test;

public class DocumentTest {

	@Test
	public static void main(String[] args) {
        Document a= new PdfDocument("Health Insurance");
        Document b= new TextDocument("Home Insurance");
        Document c= new PdfDocument("Car Insurance");
        Document d= new TextDocument("Laptop & Mobile Insurance");
        PrintQueue p = PrintQueue.getInstance();
        PrintQueue q = PrintQueue.getInstance();
        p.push(a);
        p.push(b);
        q.push(c);
        q.push(d);
        p.displayContent();
        System.out.println("\n"+"********************************************");
        p.pop();
        q.pop();
        System.out.println("\n"+"********************************************");
        p.displayContent();
    }    
}

