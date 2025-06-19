import java.util.*;
public class Main{
    static class Product{
        int id;
        String name;
        String category;
        Product(int id,String name,String category){
            this.id=id;
            this.name=name;
            this.category=category;
        }
        public String toString(){
            return id+" - "+name+"(" +category+ ")";
        }
    }
    public static Product linearSearch(Product products[],String targetName){
        for(int i=0;i<products.length;i++){
            if(products[i].name.equalsIgnoreCase(targetName)){
                return products[i];
            }
        }
        return null;
    }
    public static Product binarySearch(Product products[],String targetName) {
        int left=0;
        int right=products.length-1;
        while(left<=right){
            int mid=(left + right)/2;
            String midName=products[mid].name.toLowerCase();
            int compareResult=targetName.toLowerCase().compareTo(midName);
            if(compareResult==0){
                return products[mid];
            } 
            else if(compareResult<0){
                right=mid-1;
            } 
            else{
                left=mid+1;
            }
        }
        return null;
    }
    public static void main(String args[]) {
        Product products[]={
            new Product(101,"Laptop","Electronics"),
            new Product(102,"Shoes","Fashion"),
            new Product(103,"Smartphone","Electronics"),
            new Product(104,"Book","Education"),
            new Product(105,"SmartWatch","Electronics")
        };
        System.out.println("LINEAR SEARCH:");
        String searchName="SmartWatch";
        Product result1=linearSearch(products,searchName);
        if(result1!=null)
            System.out.println("Product Found: "+result1);
        else
            System.out.println("Product Not Found");
        Arrays.sort(products,new java.util.Comparator<Product>(){
            public int compare(Product p1, Product p2) {
                return p1.name.toLowerCase().compareTo(p2.name.toLowerCase());
            }
        });
        System.out.println("\nBINARY SEARCH:");
        Product result2=binarySearch(products,searchName);
        if (result2!=null)
            System.out.println("Product Found: "+result2);
        else
            System.out.println("Product Not Found");
    }
}
