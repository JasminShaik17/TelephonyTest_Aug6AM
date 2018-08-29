package cubex.mahesh.telephonytest

import android.content.Context
import android.net.ConnectivityManager
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.telephony.TelephonyManager
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var tManager = getSystemService(Context.TELEPHONY_SERVICE)
                                            as TelephonyManager

        var list = mutableListOf<String>()
        list.add("IMEI : "+tManager.imei)
        list.add("Sim SNo :"+tManager.simSerialNumber)
        list.add("Op Name :"+tManager.simOperatorName)
        list.add("Op Country :"+tManager.simCountryIso)
        list.add("Op  Carrier :"+tManager.simCarrierIdName)

        var cManager = getSystemService(Context.CONNECTIVITY_SERVICE)
                                            as ConnectivityManager
        if(cManager.activeNetworkInfo != null){
            list.add("Data Enabled : Yes")
        }else{
            list.add("Data Enabled : No")
        }


        var adapter = ArrayAdapter<String>(this@MainActivity,
                android.R.layout.simple_list_item_single_choice, list)
        lview.adapter = adapter
    }
}
