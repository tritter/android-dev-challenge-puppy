package com.example.androiddevchallenge.components

import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.R

@Composable
fun CallText(phone: String) {
    var title = stringResource(id = R.string.call, phone);
    val context = LocalContext.current
    Column(modifier = Modifier
        .clickable(onClick = {
            val intent = Intent(Intent.ACTION_CALL, Uri.parse("tel:" + phone))
            context.startActivity(intent)
        })) {
        Text(text = title, style = MaterialTheme.typography.h6, modifier = Modifier.padding(20.dp))
    }
}