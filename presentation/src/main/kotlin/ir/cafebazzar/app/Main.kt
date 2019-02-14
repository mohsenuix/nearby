package ir.cafebazzar.app
import android.app.Activity
import android.os.Bundle
import ir.cafebazzar.app.nearby.R

class Main:Activity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
    }
}
