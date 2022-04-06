package com.example.designapp.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.example.domain.Homework
import com.example.domain.Lesson
import com.example.domain.repository.HomeworkRepository
import com.example.domain.repository.LessonsRepository

class HomeViewModel(
    private val lessonsRepository: LessonsRepository,
    private val homeworkRepository: HomeworkRepository
) : ViewModel() {

    val lessonsLiveData: LiveData<Result<List<Lesson>>>
        get() = lessonsRepository.lessons().asLiveData()
    val homeworkLiveData: LiveData<Result<List<Homework>>>
        get() = homeworkRepository.homework().asLiveData()

}