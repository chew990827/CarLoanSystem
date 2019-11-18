package com.example.carloansystem

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        buttonCalculate.setOnClickListener {
            // Toast.makeText(this,"All text field are required", Toast.LENGTH_SHORT).show()

             val carPrice:Double = editTextCarPrice.text.toString().toDouble()
                val downPayment:Double = editTextDownPayment.text.toString().toDouble()
                val loanPeriod:Double = editTextLoanPeriod.text.toString().toDouble()
                val interestRate:Double = editTextInterestRate.text.toString().toDouble()
                val carLoan: Double = carPrice - downPayment;
                val interest: Double = carLoan * interestRate * loanPeriod
                val monthlyRepayment: Double = (carLoan + interest) / loanPeriod / 12

                textViewLoan.text = "Loan: RM%.2f".format(carLoan)
                textViewInterest.text = "Interest: RM%.2f".format(interest)
                textViewMonthlyRepayment.text =
                    "Monthly Repayment : RM%.2f".format(monthlyRepayment)
        }

        buttonReset.setOnClickListener {
            editTextCarPrice.text = null
            editTextDownPayment.text = null
            editTextLoanPeriod.text = null
            editTextInterestRate.text = null

            textViewLoan.text = "Loan: "
            textViewInterest.text = "Interest:"
            textViewMonthlyRepayment.text =
                "Monthly Repayment :"
        }
    }

}
