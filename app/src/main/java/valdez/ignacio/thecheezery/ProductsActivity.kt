package valdez.ignacio.thecheezery

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.ListView
import android.widget.TextView

class ProductsActivity : AppCompatActivity() {

    var menu = ArrayList<Product>();

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_products)

        val bundle:Bundle? = intent.extras;
        val menuType:String? = bundle?.getString("menuType")

        addProducts(menuType);

        var listView:ListView = findViewById(R.id.lv_products) as ListView
        var adapter:AdapterProducts = AdapterProducts(this, menu)
        var banner:ImageView = findViewById(R.id.iv_menuTitle)

        when(menuType){
            "coldDrinks" -> banner.setImageResource(R.drawable.colddrinks)
            "hotDrinks" -> banner.setImageResource(R.drawable.hotdrinks)
            "sweets" -> banner.setImageResource(R.drawable.sweets)
            "salties" -> banner.setImageResource(R.drawable.salties)
        }

        listView.adapter = adapter;

    }

    fun addProducts(type:String?){
        when(type){
            "coldDrinks" -> {
                menu.add(Product("Caramel Frap", R.drawable.caramelfrap, "Caramel syrup meets coffee, milk and ice and whipped cream and buttery caramel sauce layer the love on top.", 5.0))
                menu.add(Product("Chocolate Frap", R.drawable.chocolatefrap, "Rich mocha-flavored sauce meets up with chocolaty chips, milk and ice for a blender bash.", 6.0))
                menu.add(Product("Cold Brew", R.drawable.coldbrew, "Created by steeping medium-to-coarse ground coffee in room temperature water for 12 hours or longer.", 3.0))
                menu.add(Product("Matcha Latte", R.drawable.matcha, "Leafy taste of matcha green tea powder with creamy milk and a little sugar for a flavor balance that will leave you feeling ready and raring to go.", 4.0))
                menu.add(Product("Oreo Milkshake", R.drawable.oreomilkshake, "Chocolate ice cream, and oreo cookies. Topped with whipped cream with cocoa and chocolate syrup.", 7.0))
                menu.add(Product("Peanut Milkshake", R.drawable.peanutmilkshake, "Vanilla ice cream, mixed with peanut butter and chocolate.", 7.0))
            }
            "hotDrinks" -> {
                menu.add(Product("Latte", R.drawable.latte, "Coffee drink made with espresso and steamed milk", 6.0))
                menu.add(Product("Hot chocolate", R.drawable.hotchocolate, "Heated drink consisting of shaved chocolate, topped with marshmallows.", 5.0))
                menu.add(Product("Espresso", R.drawable.espresso, "Full-flavored, concentrated form of coffee.", 4.0))
                menu.add(Product("Chai Latte", R.drawable.chailatte, "Spiced tea concentrate with milk", 6.0))
                menu.add(Product("Capuccino", R.drawable.capuccino, "A cappuccino is an espresso-based coffee drink, prepared with steamed foam.", 7.0))
                menu.add(Product("American coffee", R.drawable.americano, "Espresso with hot water", 2.0))
            }
            "sweets" -> {
                menu.add(Product("Blueberry cake", R.drawable.blueberrycake, "Vanilla cake flavor, topped with cheese topping and blueberries.", 6.0))
                menu.add(Product("Chocolate cupcake", R.drawable.chocolatecupcake, "Chocolate cupcakes topped with butter cream and cherries", 3.0))
                menu.add(Product("Lemon tartalette", R.drawable.lemontartalette, "Pastry shell with a lemon flavored filling", 4.0))
                menu.add(Product("Red Velvet cake", R.drawable.redvelvetcake, "Soft, moist, buttery cake topped with an easy cream cheese frosting.", 6.0))
                menu.add(Product("Cherry cheesecake", R.drawable. strawberrycheesecake, "This cherry topped cheesecake is positively creamy and delicious and will be your new favorite dessert.", 7.0))
                menu.add(Product("Tiramisu", R.drawable.tiramisu, "Coffee-flavored Italian dessert", 6.0))
            }
            "salties"->{
                menu.add(Product("Chicken crepes", R.drawable.chickencrepes, "Fine crepes stuffed with Alfredo chicken, spinach and mushrooms.", 6.0))
                menu.add(Product("Club Sandwich", R.drawable.clubsandwich, "A delicious sandwich served with french fries.", 5.0))
                menu.add(Product("Panini", R.drawable.hampanini, "Sandwich made with Italian bread  served warmed by grilling.", 4.0))
                menu.add(Product("Philly cheese steak", R.drawable. phillycheesesteak, "Smothered in grilled onions, green peppers, mushrooms, and Provolone.", 6.0))
                menu.add(Product("Nachos", R.drawable. nachos, "Tortilla chips layered with beef and   melted cheddar cheese. Served with fried beans, guacamole, pico de gallo, and sour topping.",  7.0))
            }
        }
    }

    private class AdapterProducts:BaseAdapter{

        var products = ArrayList<Product>();
        var context: Context?= null

        constructor(context:Context, products: ArrayList<Product>){
            this.products = products;
            this.context = context;
        }

        override fun getCount(): Int {
            return products.size;
        }

        override fun getItem(p0: Int): Any {
            return products[p0]
        }

        override fun getItemId(p0: Int): Long {
            return p0.toLong();
        }

        override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
            var product = products[p0]
            var inflador = LayoutInflater.from(context)
            var vista = inflador.inflate(R.layout.product_view, null)

            var imagen = vista.findViewById(R.id.img_product) as ImageView
            var nombre = vista.findViewById(R.id.tv_productName) as TextView
            var desc = vista.findViewById(R.id.tv_productDesc) as TextView
            var precio = vista.findViewById(R.id.tv_productPrice) as TextView

            imagen.setImageResource(product.image)
            nombre.setText(product.name)
            desc.setText(product.description)
            precio.setText("$${product.price}")

            return vista
        }

    }

}