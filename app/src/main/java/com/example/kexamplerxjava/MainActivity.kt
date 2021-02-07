package com.example.kexamplerxjava

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), IMainView {

    private lateinit var mPresenter: MainPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mPresenter = MainPresenter ()
        mPresenter.attach(this)

        btnObservableJust.setOnClickListener {
            mPresenter.exec()
        }
    }

    override fun screenResult1(t: String) {
        textViewDisplay1.text = textViewDisplay1.text.toString() + t + "\n"
    }

    override fun screenResult2(t: String) {
        textViewDisplay2.text = t + "\n"
    }

}

//        val btnObservableJust: Button = findViewById<Button>(R.id.btnObservableJust)
//        val btnObservableFromArray = findViewById<Button>(R.id.btnObservableFromArray)
//        val btnObservableSimpleEmitter = findViewById<Button>(R.id.btnObservableSimpleEmitter)
//        val editTextField = findViewById<EditText>(R.id.editTextField)
//        val btnObservableOperators = findViewById<Button>(R.id.btnObservableOperators)
//        val btnObservableAnonymous = findViewById<Button>(R.id.btnObservableAnonymous)
//        val btnConsumer = findViewById<Button>(R.id.btnConsumer)
//        val btnTest1 = findViewById<Button>(R.id.btnTest1)
//        val btnTest2 = findViewById<Button>(R.id.btnTest2)
//        val textViewDisplay1 = findViewById<TextView>(R.id.textViewDisplay1)
//        val textViewDisplay2 = findViewById<TextView>(R.id.textViewDisplay2)
