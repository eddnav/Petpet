/*
 * Copyright 2021 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.edd.androiddevchallenge.petpet

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.edd.androiddevchallenge.petpet.ui.overview.OverviewScreen
import com.edd.androiddevchallenge.petpet.ui.theme.PetPetTheme
import androidx.lifecycle.viewmodel.compose.viewModel

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PetPetTheme {
                PetPet()
            }
        }
    }
}

@Composable
fun PetPet() {
    OverviewScreen(viewModel())
}

@Preview(widthDp = 360, heightDp = 640)
@Composable
fun Preview() {
    PetPetTheme {
        PetPet()
    }
}