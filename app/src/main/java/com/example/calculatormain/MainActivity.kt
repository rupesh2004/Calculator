package com.example.calculatormain

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast
import java.util.Stack


class MainActivity : AppCompatActivity() {
    lateinit var editbox : EditText
    var input : String= ""
    var result: Double = 0.0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        editbox = findViewById(R.id.t1)
        editbox.isEnabled=false
    }
    fun setzero(view: View) {
        val newvalue: String = editbox.text?.toString() ?: ""
        input= newvalue+"0"
        updateeditbox()
    }

    fun setdot(view: View) {
        val newvalue: String = editbox.text?.toString() ?: ""
        input=newvalue+"."
        updateeditbox()
    }

    fun setequals(view: View) {
        try {
            val currentResult = evaluateExpression(input)
            result = currentResult
            editbox.setText(result.toString())
        } catch (e: Exception) {
            Toast.makeText(this, "Enter Data", Toast.LENGTH_SHORT).show()
        }
    }

    fun setone(view: View) {
        val newvalue: String = editbox.text?.toString() ?: ""
        input =newvalue+ "1"
        updateeditbox()
    }

    fun settwo(view: View) {
        val newvalue: String = editbox.text?.toString() ?: ""
        input =newvalue+ "2"
        updateeditbox()
    }

    fun setthree(view: View) {
        val newvalue: String = editbox.text?.toString() ?: ""
        input =newvalue+ "3"
        updateeditbox()
    }

    fun setplus(view: View) {
        val newvalue: String = editbox.text?.toString() ?: ""
        input =newvalue+ "+"
        updateeditbox()
    }

    fun setfour(view: View) {
        val newvalue: String = editbox.text?.toString() ?: ""
        input =newvalue+ "4"
        updateeditbox()
    }

    fun setfive(view: View) {
        val newvalue: String = editbox.text?.toString() ?: ""
        input =newvalue+ "5"
        updateeditbox()
    }

    fun setsix(view: View) {
        val newvalue: String = editbox.text?.toString() ?: ""
        input =newvalue+ "6"
        updateeditbox()
    }

    fun setminus(view: View) {
        val newvalue: String = editbox.text?.toString() ?: ""
        input =newvalue+ "-"
        updateeditbox()
    }

    fun setseven(view: View) {
        val newvalue: String = editbox.text?.toString() ?: ""
        input =newvalue+ "7"
        updateeditbox()
    }

    fun seteight(view: View) {
        val newvalue: String = editbox.text?.toString() ?: ""
        input =newvalue+ "8"
        updateeditbox()
    }

    fun setnine(view: View) {
        val newvalue: String = editbox.text?.toString() ?: ""
        input =newvalue+ "9"
        updateeditbox()
    }

    fun setmultiplication(view: View) {
        val newvalue: String = editbox.text?.toString() ?: ""
        input =newvalue+ "*"
        updateeditbox()
    }

    fun setclear(view: View) {
        input = ""
        editbox.setText("")
        result = 0.0 // Clear the stored result
    }

    fun setmodulus(view: View) {
        val newvalue: String = editbox.text?.toString() ?: ""
        input =newvalue+ "%"
        updateeditbox()
    }

    fun setdivide(view: View) {
        val newvalue: String = editbox.text?.toString() ?: ""
        input =newvalue+ "/"
        updateeditbox()
    }

    fun setbracket1(view: View) {
        val newvalue: String = editbox.text?.toString() ?: ""
        input =newvalue+"("
        updateeditbox()
    }

    fun setbracket2(view: View) {
        val newvalue: String = editbox.text?.toString() ?: ""
        input =newvalue+ ")"
        updateeditbox()
    }

    fun erase(view: View) {
        if (input.equals("")) {
            Toast.makeText(this, "Enter Data", Toast.LENGTH_SHORT).show()
        } else {
            input = input.substring(0, input.length - 1)
            updateeditbox()
        }
    }
    fun updateeditbox() {
        editbox.setText(input)
    }

    private fun evaluateExpression(expression: String): Double {
        val stack = Stack<Double>()
        val operators = Stack<Char>()

        var i = 0
        while (i < expression.length) {
            if (Character.isDigit(expression[i])) {
                val numBuilder = StringBuilder()
                while (i < expression.length && (Character.isDigit(expression[i]) || expression[i] == '.')) {
                    numBuilder.append(expression[i])
                    i++
                }
                stack.push(numBuilder.toString().toDouble())
            } else if (isOperator(expression[i])) {
                while (!operators.isEmpty() && hasPrecedence(expression[i], operators.peek())) {
                    applyOperator(stack, operators.pop())
                }
                operators.push(expression[i])
                i++
            } else if (expression[i] == '(') {
                operators.push(expression[i])
                i++
            } else if (expression[i] == ')') {
                while (!operators.isEmpty() && operators.peek() != '(') {
                    applyOperator(stack, operators.pop())
                }
                operators.pop() // Pop '('
                i++
            } else {
                throw IllegalArgumentException("Invalid character in expression")
            }
        }

        while (!operators.isEmpty()) {
            applyOperator(stack, operators.pop())
        }

        return stack.pop()
    }

    private fun isOperator(c: Char): Boolean {
        return c == '+' || c == '-' || c == '*' || c == '/'
    }

    private fun hasPrecedence(op1: Char, op2: Char): Boolean {
        return (op2 == '(' || op2 == ')') || (op1 == '*' || op1 == '/') && (op2 == '+' || op2 == '-')
    }

    private fun applyOperator(stack: Stack<Double>, operator: Char) {
        val operand2 = stack.pop()
        val operand1 = stack.pop()
        when (operator) {
            '+' -> stack.push(operand1 + operand2)
            '-' -> stack.push(operand1 - operand2)
            '*' -> stack.push(operand1 * operand2)
            '/' -> stack.push(operand1 / operand2)
        }
    }

    fun setzerozero(view: View) {
        val newvalue: String = editbox.text?.toString() ?: ""
        input =newvalue+ "00"
        updateeditbox()
    }
}
   