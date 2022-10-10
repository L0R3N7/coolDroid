package at.htl.leonding.bhitm5.cooldroid

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*;

class MainActivity : AppCompatActivity() {
    val LOG_TAG = MainActivity::class.java.simpleName
    private val COUNTER = "counter"
    var counter = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Logic
        textViewDroid.text = "New Way"

        if (savedInstanceState != null){
            counter = savedInstanceState.getInt(COUNTER);
            textViewDroid.text = getMessageText();
        }


        imageViewDroid.setOnClickListener{
            counter++
            Log.d(LOG_TAG, "onCreate(), counter: ${counter}")
            textViewDroid.text = getMessageText();
        }
    }

    private fun getMessageText() =
        when (counter) {
            1 -> getString(R.string.once)
            2 -> getString(R.string.twice)
            else -> getString(R.string.text_view_numbers, counter)
        }

    override fun onSaveInstanceState(outState: Bundle) {
        outState.putInt(COUNTER, counter)
        Log.d(LOG_TAG, "onSaveInstanceState(), counter: ${counter}")
        super.onSaveInstanceState(outState)
    }
}