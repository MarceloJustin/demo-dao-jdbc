package application;

import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;

public class Program2 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		DepartmentDao departmentDao = DaoFactory.createDepartmentDao();
		
		System.out.println("=== TEST 1: department insert =====");
		Department newDep = new Department(10, "new dep");
		departmentDao.insert(newDep);
		System.out.println("Inserted! New id = " + newDep.getId());
		
		System.out.println("\n=== TEST 2: department update =====");
		Department department = departmentDao.findByid(10);
		department.setName("new dep1");
		departmentDao.update(department);
		System.out.println("Update completed");
		
		System.out.println("\n=== TEST 3: department delete =====");
		System.out.println("Enter id for delete test: ");
		int id = sc.nextInt();
		departmentDao.deleteByid(id);
		System.out.println("Deleted completed");
		
		System.out.println("=== TEST 4: department findById =====");
		department = departmentDao.findByid(3);
		System.out.println(department);
		
		System.out.println("\n=== TEST 5: department findAll =====");
		List<Department > list = departmentDao.findAll();
		for (Department d : list) {
			System.out.println(d);
		}
		sc.close();
	}
}