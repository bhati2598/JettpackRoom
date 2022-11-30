package com.bhati.jettpackroom.room

import androidx.room.*

@Dao()
interface EmployeeDao {

    @Insert
    fun insertAll(vararg employee: Employee)

    @Update
    fun update(vararg employee: Employee)

    @Delete
    fun delete(employee: Employee)

    @Query("SELECT * FROM employees")
    fun getAll(): List<Employee>

    @Query("SELECT * FROM employees WHERE empId IN (:empId)")
    fun loadAllByIds(empId: IntArray): List<Employee>

    @Query(
        "SELECT * FROM employees WHERE emp_name LIKE :name AND " +
                "emp_company LIKE :company LIMIT 1"
    )
    fun findByName(name: String, company: String): Employee
}