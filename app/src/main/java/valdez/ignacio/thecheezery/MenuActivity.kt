package valdez.ignacio.thecheezery

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MenuActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)

        val btn_coldDrinks: Button = findViewById(R.id.btn_coldDrinks);
        val btn_hotDrinks:Button = findViewById(R.id.btn_hotDrinks);
        val btn_salties:Button = findViewById(R.id.btn_salties);
        val btn_sweets:Button = findViewById(R.id.btn_sweets)

        btn_coldDrinks.setOnClickListener {
            var intent: Intent = Intent(this, ProductsActivity::class.java);
            var type = Bundle()
            type.putString("menuType","coldDrinks")
            intent.putExtras(type)
            startActivity(intent)
        }

        btn_hotDrinks.setOnClickListener {
            var intent: Intent = Intent(this, ProductsActivity::class.java);
            var type = Bundle()
            type.putString("menuType","hotDrinks")
            intent.putExtras(type)
            startActivity(intent)
        }

        btn_salties.setOnClickListener {
            var intent: Intent = Intent(this, ProductsActivity::class.java);
            var type = Bundle()
            type.putString("menuType","salties")
            intent.putExtras(type)
            startActivity(intent)
        }

        btn_sweets.setOnClickListener {
            var intent: Intent = Intent(this, ProductsActivity::class.java);
            var type = Bundle()
            type.putString("menuType","sweets")
            intent.putExtras(type)
            startActivity(intent)
        }

    }
}