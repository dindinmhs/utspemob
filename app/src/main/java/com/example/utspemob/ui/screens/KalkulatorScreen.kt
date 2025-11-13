package com.example.utspemob.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlin.math.sqrt

@Preview(showBackground = true)
@Composable
fun KalkulatorScreen() {
    var input by remember { mutableStateOf("") }
    var result by remember { mutableStateOf("") }

    fun calculateExpression(expression: String): String {
        return try {
            val cleanExp = expression.replace("×", "*").replace("÷", "/")
            val evalResult = ExpressionEvaluator.evaluate(cleanExp)
            if (evalResult % 1.0 == 0.0)
                evalResult.toInt().toString()
            else
                evalResult.toString()
        } catch (e: Exception) {
            "Error"
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .background(MaterialTheme.colorScheme.background),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 32.dp),
            horizontalAlignment = Alignment.End
        ) {
            Text(
                text = input,
                fontSize = 28.sp,
                color = MaterialTheme.colorScheme.onBackground,
                textAlign = TextAlign.End,
                modifier = Modifier.fillMaxWidth()
            )
            Text(
                text = result,
                fontSize = 36.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF9C27B0),
                textAlign = TextAlign.End,
                modifier = Modifier.fillMaxWidth()
            )
        }

        // Tombol kalkulator
        val buttons = listOf(
            listOf("C", "√", "x²", "÷"),
            listOf("7", "8", "9", "×"),
            listOf("4", "5", "6", "-"),
            listOf("1", "2", "3", "+"),
            listOf("0", ".", "=", "")
        )

        Column(
            modifier = Modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            buttons.forEach { row ->
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    row.forEach { symbol ->
                        if (symbol.isNotEmpty()) {
                            Button(
                                colors = ButtonDefaults.buttonColors(
                                    containerColor = Color(0xFF9C27B0),
                                    contentColor = Color.White
                                ),
                                onClick = {
                                    when (symbol) {
                                        "C" -> {
                                            input = ""
                                            result = ""
                                        }
                                        "=" -> result = calculateExpression(input)
                                        "√" -> {
                                            try {
                                                val value = input.toDoubleOrNull() ?: 0.0
                                                result = sqrt(value).toString()
                                                input = "√($input)"
                                            } catch (e: Exception) {
                                                result = "Error"
                                            }
                                        }
                                        "x²" -> {
                                            try {
                                                val value = input.toDoubleOrNull() ?: 0.0
                                                result = (value * value).toString()
                                                input = "($input)²"
                                            } catch (e: Exception) {
                                                result = "Error"
                                            }
                                        }
                                        else -> input += symbol
                                    }
                                },
                                modifier = Modifier
                                        .weight(1f)
                                    .aspectRatio(1f),
                                shape = RoundedCornerShape(12.dp)

                            ) {
                                Text(
                                    text = symbol,
                                    fontSize = 22.sp,
                                    fontWeight = FontWeight.Bold
                                )
                            }
                        } else {
                            Spacer(modifier = Modifier.weight(1f))
                        }
                    }
                }
            }
        }
    }
}

object ExpressionEvaluator {
    fun evaluate(expr: String): Double {
        val exp = expr.replace("×", "*").replace("÷", "/")
        return object {
            var pos = -1
            var ch = 0

            fun nextChar() {
                ch = if (++pos < exp.length) exp[pos].code else -1
            }

            fun eat(charToEat: Int): Boolean {
                while (ch == ' '.code) nextChar()
                if (ch == charToEat) {
                    nextChar()
                    return true
                }
                return false
            }

            fun parse(): Double {
                nextChar()
                val x = parseExpression()
                if (pos < exp.length) throw RuntimeException("Unexpected: " + exp[pos])
                return x
            }

            fun parseExpression(): Double {
                var x = parseTerm()
                while (true) {
                    when {
                        eat('+'.code) -> x += parseTerm()
                        eat('-'.code) -> x -= parseTerm()
                        else -> return x
                    }
                }
            }

            fun parseTerm(): Double {
                var x = parseFactor()
                while (true) {
                    when {
                        eat('*'.code) -> x *= parseFactor()
                        eat('/'.code) -> x /= parseFactor()
                        else -> return x
                    }
                }
            }

            fun parseFactor(): Double {
                if (eat('+'.code)) return parseFactor()
                if (eat('-'.code)) return -parseFactor()

                var x: Double
                val startPos = pos
                if (eat('('.code)) {
                    x = parseExpression()
                    eat(')'.code)
                } else if ((ch in '0'.code..'9'.code) || ch == '.'.code) {
                    while ((ch in '0'.code..'9'.code) || ch == '.'.code) nextChar()
                    x = exp.substring(startPos, pos).toDouble()
                } else {
                    throw RuntimeException("Unexpected: ${ch.toChar()}")
                }

                return x
            }
        }.parse()
    }
}