package sample.controllers;


/**
 *
 * @author Hoa Doan
 */
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import sample.dto.I_List;
import sample.dto.Product;
import sample.utils.Utils;
public class ProductList extends ArrayList<Product> implements I_List {

    @Override
    public int find(String code) {
        return 0;
    }

    @Override
    public void add() {
        boolean check = true;
        do {
            String code = Utils.getString("Enter ID: ");
            if(find(code) != -1) {
                System.out.println("Code is exists");
                check = false;
            }
        } while (check);
        String name = Utils.getString("Enter product's name: ");
        String brand_id = Utils.getString("Enter Brand ID: ");
        String category = Utils.getString("Enter Product's Category: ");
        int model_year = Utils.getInt("Enter model year", 0, 2025);
        int list_price = Utils.getInt("Enter Price: ", 0, 1000000);
        
        this.add(new Product(name, name, brand_id, category, model_year, list_price));
        System.out.println("Product has been add successfully");
    }

    @Override
    public void remove() {
        String fid = Utils.getString("Enter ID, Which you want to remove: ");
        int index = this.find(fid);
        if(find(fid) > 0) {
            this.remove(index);
            System.out.println("The Product has been removed");
        } else {
            System.out.println("The ID is not exits");
            System.out.println("Removed fail");
        }
    }

    @Override
    public void update() {
        String fid = Utils.getString("Enter ID, Which you want to update: ");
        int index = this.find(fid);
        if(index < 0) {
            System.out.println("Product does not exits");
            return;
        }
        String newName = Utils.getStringBlank("Enter new product's name: ");
        if(!newName.isEmpty()) {
            this.get(index).setName(newName);
        }
        
        String brand_id = Utils.getStringBlank("Enter new product's brand id: ");
    }

    @Override
    public void sort() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void output() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void search() {
        if(this.isEmpty()) {
            System.out.println("Have no any product");
        }
        boolean found = false;
        String fname = Utils.getString("Enter name, Which do you want to search: ").toLowerCase();
        for(Product x : this) {
            if(x.getName().toLowerCase().contains(fname)) {
                System.out.println(x.toString());
                found = true;
            }
            Collections.sort(this, new Comparator<Product>() {
                @Override
                public int compare(Product o1,Product o2) {
                    return o1.getModel_year() - o2.getModel_year();
                }
            });
            if(!found) {
                System.out.println("The Name is not exist!!");
            }
        }
    }
   
    
    
}
