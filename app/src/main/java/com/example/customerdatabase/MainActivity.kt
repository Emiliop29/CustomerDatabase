
package com.example.customerdatabase

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.MaterialTheme
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.customerdatabase.data.AppDatabase
import com.example.customerdatabase.ui.theme.CustomerViewModel
import com.example.customerdatabase.ui.theme.CustomerViewModelFactory
import com.example.customerdatabase.ui.theme.CustomerDatabaseTheme
import com.example.customerdatabase.ui.theme.CustomerApp

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val database = AppDatabase.getDatabase(applicationContext)

        setContent {
            CustomerDatabaseTheme {
                val viewModel: CustomerViewModel = viewModel(
                    factory = CustomerViewModelFactory(
                        database.customerDao()
                    )
                )

                MaterialTheme {
                    CustomerApp(viewModel)
                }
            }
        }
    }
}
