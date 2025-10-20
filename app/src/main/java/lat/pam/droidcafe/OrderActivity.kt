package lat.pam.droidcafe

import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class OrderActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_order)

        // ======== Spinner City ========
        val spinner: Spinner = findViewById(R.id.city_spinner)
        ArrayAdapter.createFromResource(
            this,
            R.array.city_array,
            android.R.layout.simple_spinner_item
        ).also { adapter ->
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            spinner.adapter = adapter
        }

        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>,
                view: View?,
                position: Int,
                id: Long
            ) {
                val city = parent.getItemAtPosition(position).toString()
                Toast.makeText(this@OrderActivity, "City selected: $city", Toast.LENGTH_SHORT).show()
            }

            override fun onNothingSelected(parent: AdapterView<*>) {
                // Do nothing
            }
        }
    }

    // ======== RadioButton Logic (sudah ada) ========
    fun onRadioButtonClicked(view: View) {
        val checked = (view as RadioButton).isChecked
        when (view.id) {
            R.id.sameday -> if (checked)
                displayToast(getString(R.string.same_day_messenger_service))
            R.id.nextday -> if (checked)
                displayToast(getString(R.string.next_day_ground_delivery))
            R.id.pickup -> if (checked)
                displayToast(getString(R.string.pick_up))
        }
    }

    private fun displayToast(message: String) {
        Toast.makeText(applicationContext, message, Toast.LENGTH_SHORT).show()
    }
}
