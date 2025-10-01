import javax.print.PrintService;
import javax.print.PrintServiceLookup;
//import javax.print.PrintServiceAttributeSet;
import javax.print.DocPrintJob;
import javax.print.SimpleDoc;
import javax.print.DocFlavor;

public class SimpleJavaxPrinter {
    public static void main(String args[]) {
        try {
            PrintService service = PrintServiceLookup.lookupDefaultPrintService();

            if (service == null) {
                System.out.println("No default print service found.");
                return;
            }

            DocPrintJob job = service.createPrintJob();

            String messsage = "Hello from Javx Print API!";
            DocFlavor flavor = DocFlavor.STRING.TEXT_PLAIN;
            SimpleDoc doc = new SimpleDoc(messsage, flavor, null);
            job.print(doc, null);
            System.out.println("Print job submitted successfully.");
        } catch (Exception e) {
            System.out.println("An error occurred while printing: " + e.getMessage());
        }
    }
}
