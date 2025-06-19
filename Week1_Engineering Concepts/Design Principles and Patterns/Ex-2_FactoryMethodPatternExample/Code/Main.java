package FactoryMethodPatternExample;
public class Main{
    interface Doc{
        void opens();
    }
    static class WordDoc implements Doc{
        public void opens(){
            System.out.println("Word Document");
        }
    }
    static class PdfDoc implements Doc{
        public void opens(){
            System.out.println("PDF Document");
        }
    }
    static class ExcelDoc implements Doc{
        public void opens(){
            System.out.println("Excel Document");
        }
    }
    static abstract class Document{
        public abstract Doc createDocument();
    }
    static class WordDocumentFile extends Document{
        public Doc createDocument(){
            return new WordDoc();
        }
    }
    static class PdfDocumentFile extends Document{
        public Doc createDocument(){
            return new PdfDoc();
        }
    }
    static class ExcelDocumentFile extends Document{
        public Doc createDocument(){
            return new ExcelDoc();
        }
    }
    public static void main(String[] args){
        Document wordFactory=new WordDocumentFile();
        Doc wordDoc=wordFactory.createDocument();
        wordDoc.opens();

        Document pdfFactory=new PdfDocumentFile();
        Doc pdfDoc=pdfFactory.createDocument();
        pdfDoc.opens();

        Document excelFactory=new ExcelDocumentFile();
        Doc excelDoc=excelFactory.createDocument();
        excelDoc.opens();
    }
}

