/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sw;

/**
 *
 * @author 산
 */
public class Cart {
    private String Menu;
    private int Count;
    private int Price;
    
    public Cart(String menu, int count, int price){
        this.Menu = menu;
        this.Count = count;
        this.Price = price;
                
    }
    public void setMenu(String menu){
        this.Menu = menu;
    }
    
    public String getMenu(){
        return Menu;
    }
    
    public void setCount(int count){
        this.Count = count;
    }
    
    public int getCount(){
        return Count;
    }
    public void setPrice(int price){
        this.Price = price;
    }
    
    public int getPrice(){
        return Price;
    }    

}
