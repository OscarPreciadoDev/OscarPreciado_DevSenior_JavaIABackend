// Demuestre el operador %

public class N09ModuloDemostracion {
    public static void main(String[] args) {
        
        int iresult, irest;
        double dresult, drest;

        iresult = 10 / 3 ;
        irest = 10 % 3;

        dresult = 10.0 / 3.0;
        drest = 10 % 3;

        System.out.println("Resultado y sobrante de 10/3: " + iresult + " " + irest);
        System.out.println("Resultado y sobrante de 10.0/3.0: " + dresult + " " + drest);

    }
}
