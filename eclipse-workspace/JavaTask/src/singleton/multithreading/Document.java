package singleton.multithreading;

public abstract class Document {

	protected String name;
    protected String type;
    Document(){}
    Document(String name){
        this.name = name;
    }
    public String name(){
        return this.name;
    }
    abstract public String type();      
}

class TextDocument extends Document {
    TextDocument(String name){
        super(name);
    }
    @Override
    public String type() {
        return "textDocument";
    }       
}

class PdfDocument extends Document {
    PdfDocument(String name){
        super(name);
    }
    @Override
    public String type() {
        return "PDFDocument";
    }   
}

class Node {
    public Document document;
    public Node next;
    Node(Document nxt){
        document = nxt;
    }    
}

class PrintQueue {
    public Node root;
    Node current;
    private static PrintQueue instance;
    private PrintQueue(){}
    public static synchronized PrintQueue getInstance(){
        if(instance == null){
            instance = new PrintQueue();
        }
        return instance;
    }
    public  void push(Document nxt){
        if(root == null){
            root = new Node(nxt);
            root.next =null;
        }
        else {
        	current = root;
             while(current.next!= null){
            	 current=current.next;
             }
             
             Node newNode = new Node(nxt);
             current.next = newNode;
             newNode.next = null;
         }

     }
     public Document pop(){
         if(root == null){
             System.out.println("Queue is empty");
             return null;
         }else{
             Node temp = root;
             root=root.next;
             System.out.println(temp.document.name() + "   " + temp.document.type() + " popped out");
             return temp.document;
         }
     }
     public void displayContent(){
         if(root == null){
             System.out.println("no pending task");
         }else{
        	 current = root;
             while(current!=null){
                System.out.println(current.document.name() + "    " + current.document.type()); 
                current = current.next;
            }
        }
    }
    
     public void run() {
     
    } 
}


