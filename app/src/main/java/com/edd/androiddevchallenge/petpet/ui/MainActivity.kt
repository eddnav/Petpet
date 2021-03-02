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
package com.edd.androiddevchallenge.petpet.ui

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.edd.androiddevchallenge.petpet.ui.overview.OverviewScreen
import com.edd.androiddevchallenge.petpet.ui.petdetail.PetDetailScreen
import com.edd.androiddevchallenge.petpet.ui.petdetail.PetDetailViewModelFactory
import com.edd.androiddevchallenge.petpet.ui.route.Route.OverviewRoute
import com.edd.androiddevchallenge.petpet.ui.route.Route.PetDetailRoute
import com.edd.androiddevchallenge.petpet.ui.theme.PetPetTheme

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
    val navController = rememberNavController()
    NavHost(navController, startDestination = OverviewRoute.value) {
        composable(OverviewRoute.value) {
            OverviewScreen(navController, viewModel())
        }
        composable(PetDetailRoute.value) {
            val petId = it.arguments?.getString(PetDetailRoute.PET_ARG)
                ?: error("No ${PetDetailRoute.PET_ARG} argument found")
            // TODO: Figure out how to use Koin with Compose
            // TODO: Delete the factory class
            PetDetailScreen(viewModel(factory = PetDetailViewModelFactory(petId)))
        }
    }
}

@Preview(widthDp = 360, heightDp = 640)
@Composable
fun Preview() {
    PetPetTheme {
        PetPet()
    }
}