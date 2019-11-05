package com.example.carloancalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
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
    }

    private fun calculateLoan(){
        //TODO: get all inputs and calculate output
        if(editTextCarPrice.text.isEmpty()){
            editTextCarPrice.setError(getString(R.string.input_error))
            return//end program execution
        }
        if(editTextDownPayement.text.isEmpty()){
            editTextDownPayement.setError(getString(R.string.input_error))
            return
        }
        if(editTextLoanPeriod.text.isEmpty()){
            editTextLoanPeriod.setError((getString(R.string.input_error)))
            return
        }
        if(editTextInterestRate.text.isEmpty()){
            editTextInterestRate.setError((getString(R.string.input_error)))
            return
        }



        val carPrice: Int = editTextCarPrice.text.toString().toInt()
        val downPayment: Int = editTextDownPayement.text.toString().toInt()
        val interestRate:Float =editTextInterestRate.text.toString().toFloat()

        val loanPeriod: Int = editTextLoanPeriod.text.toString().toInt()
        val carLoan:Int = carPrice - downPayment
        val interest:Float = carLoan * interestRate *loanPeriod
        val monthlyRepayment:Float = (carLoan + interest) / loanPeriod / 12

        if(editTextInterestRate.text.isNotEmpty()&&editTextDownPayement.text.isNotEmpty()&&editTextLoanPeriod.text.isNotEmpty()&&editTextCarPrice.text.isNotEmpty()){
            textViewLoan.setText(String.format("%s %d","Loan: ",carLoan))
            textViewInterest.setText(String.format("%s %.2f","Interest: ",interestRate))
            textViewMonthlyPayment.setText(String.format("%s  %.2f","Montnly Repayment", monthlyRepayment))
        }


    }

    fun reset(view: View){
        editTextCarPrice.text.clear()
        editTextDownPayement.text.clear()
        editTextLoanPeriod.text.clear()
        editTextInterestRate.text.clear()
    }
}
