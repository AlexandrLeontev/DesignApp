package com.example.designapp.ui.lessons

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.example.domain.Lesson
import com.example.domain.repository.LessonsRepository

class LessonsViewModel(private val lessonsRepository: LessonsRepository) : ViewModel() {

    val lessonsLiveData: LiveData<Result<List<Lesson>>>
        get() = lessonsRepository.lessons().asLiveData()

}