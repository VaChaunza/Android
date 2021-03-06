package com.dodemy.theappfactory.viewModel.viewModels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.liveData
import com.dodemy.theappfactory.model.models.Employee
import com.dodemy.theappfactory.viewModel.repositories.EmployeeRepository
import kotlinx.coroutines.Dispatchers


class DetailViewModel(application: Application) : AndroidViewModel(application) {

    // coordinates between the local and remote databases
    private val employeeRepository = EmployeeRepository.getInstance(application)

    // This LiveData is created using a ktx library shortcut
    fun employeeLiveData(id: Int): LiveData<Employee?> = liveData(Dispatchers.IO) {
        emitSource(employeeRepository.getEmployeeByIdLiveData(id))
    }
}
