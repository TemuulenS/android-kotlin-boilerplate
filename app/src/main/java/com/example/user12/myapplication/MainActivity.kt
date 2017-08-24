package com.example.user12.myapplication

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.google.gson.JsonArray

class MainActivity : AppCompatActivity(), MainView {


  lateinit var textView: TextView
  lateinit var editText: EditText
  lateinit var button: Button
  lateinit var presenter: MainPresenter

  override fun showErrorEdittext() {
    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
  }

  override fun showRequestError() {
    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
  }

  override fun showData(jsonArray: JsonArray) {
    textView.text = jsonArray.toString()
  }

  override fun initViews() {
    textView = findViewById(R.id.text) as TextView
    button = findViewById(R.id.button) as Button
    editText = findViewById(R.id.editText) as EditText
    button.setOnClickListener { v -> presenter.sendRequest(editText.text.toString()) }
  }

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)
    presenter = MainPresenter(this)
    presenter.initalize()

  }


}

interface MainView {
  fun showErrorEdittext()
  fun showRequestError()
  fun showData(jsonArray: JsonArray)
  fun initViews()
}