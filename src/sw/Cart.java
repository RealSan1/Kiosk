package sw;
public class Cart {
    private String Menu;
    private int Count;
    private int Price;
    private int Inventory;
    
    public Cart(String menu,int count, int price){
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
    
    public void setInventory(int inventory){
        this.Inventory = inventory;
    }
    
    public int getInventory(){
        return Inventory;
    }    
}
