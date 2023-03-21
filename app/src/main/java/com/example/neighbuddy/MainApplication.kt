package com.example.neighbuddy

import android.app.Application
import com.example.neighbuddy.domain.repository.MyRepository
import dagger.hilt.android.HiltAndroidApp
import javax.inject.Inject

@HiltAndroidApp
class MainApplication: Application()