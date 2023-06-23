package com.rodrigojscript.yesido.view.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.rodrigojscript.yesido.view.theme.textLight

typealias onChange = (String) -> Unit

/**
 * CustomTextField: un campo de texto personalizado.
 *
 * @param label La etiqueta del campo de texto.
 * @param value El valor actual del campo de texto.
 * @param onChange La función que se llama cuando cambia el valor del campo de texto.
 */
@Composable
fun CustomTextField(
    label: String,
    value: String,
    valorIndividual: Array<String?>,
    index: Int,
    onChange: onChange,
) {
    Row(modifier = Modifier.fillMaxWidth()) {
        Box(
            modifier = Modifier
                .fillMaxWidth(0.5f)
                .widthIn(max = 200.dp)
        ) {
            OutlinedTextField(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp, vertical = 4.dp),
                keyboardOptions = KeyboardOptions.Default.copy(
                    keyboardType = KeyboardType.Number,
                    imeAction = ImeAction.Next
                ),
                value = value,
                singleLine = true,
                shape = RoundedCornerShape(8.dp),
                onValueChange = { onChange(it) },
                textStyle = MaterialTheme.typography.h6,
                label = {
                    Text(text = label)
                }
            )
        }
        Text(
            text = "$${valorIndividual[index] ?: ""}",
            modifier = Modifier
                .padding(start = 20.dp)
                .align(Alignment.CenterVertically)
                .fillMaxHeight(),
            textAlign = TextAlign.Right,
            color = textLight,
            fontSize = 16.sp,
        )
    }
}


@Preview(showBackground = true)
@Composable
fun CustomTextFieldPreview() {
    val textFieldValues = arrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11)
    val valorIndividual = arrayOfNulls<String>(11)

    valorIndividual[0] = (textFieldValues[0] * 1000.0).toString()
    valorIndividual[1] = (textFieldValues[1] * 500.0).toString()
    valorIndividual[2] = (textFieldValues[2] * 200.0).toString()
    valorIndividual[3] = (textFieldValues[3] * 100.0).toString()
    valorIndividual[4] = (textFieldValues[4] * 50.0).toString()
    valorIndividual[5] = (textFieldValues[5] * 20.0).toString()
    valorIndividual[6] = (textFieldValues[6] * 10.0).toString()
    valorIndividual[7] = (textFieldValues[7] * 5.0).toString()
    valorIndividual[8] = (textFieldValues[8] * 2.0).toString()
    valorIndividual[9] = (textFieldValues[9] * 1.0).toString()
    valorIndividual[10] = (textFieldValues[10] * 0.5).toString()

    CustomTextField(
        label = "Label",
        value = "",
        valorIndividual = valorIndividual,
        onChange = {}, index = 4
    )
}

