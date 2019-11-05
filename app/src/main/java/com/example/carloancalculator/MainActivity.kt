package com.example.carloancalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        buttonCalculate.setOnClickListener {
            calculateLoan()
        }
        buttonReset.setOnClickListener{
            reset()
        }
    }

    private fun calculateLoan(){
        //TODO: get all inputs and calculate Price
        if(editTextCarPrice.text.isEmpty()){
            editTextCarPrice.error = getString(R.string.input_error)
            return //end the program execution
        }
        if(editTextDownPayment.text.isEmpty()){
            editTextDownPayment.error = getString(R.string.input_error)
            return
        }
        if(editTextInterestRate.text.isEmpty()){
            editTextInterestRate.error = getString(R.string.input_error)
            return
        }
        if(editTextLoanPeriod.text.isEmpty()){
            editTextLoanPeriod.error = getString(R.string.input_error)
            return
        }

        val currency : Currency= Currency.getInstance(Locale.getDefault());

        val carPrice: Int = editTextCarPrice.text.toString().toInt()
        val downPayment: Int = editTextDownPayment.text.toString().toInt()
        val interestRate: Float = editTextInterestRate.text.toString().toFloat()
        val loanPeriod: Int = editTextLoanPeriod.text.toString().toInt()
        val carLoan: Int = carPrice - downPayment
        val interest: Float = carLoan * interestRate * loanPeriod
        val monthlyRepayment: Float = (carLoan + interest)/loanPeriod/12

        textViewLoan.text = "Loan :" + String.format("%s %d", currency, carLoan)
        textViewInterest.text = "Interest :" + String.format("%s %.2f", currency, interest)
        textViewMonthlyRepayment.text = "Monthly Repayment :" + String.format("%s %.2f", currency, monthlyRepayment)
    }

    private fun reset(){
        editTextDownPayment.text.clear()
        editTextCarPrice.text.clear()
        editTextInterestRate.text.clear()
        editTextLoanPeriod.text.clear()
    }

}

