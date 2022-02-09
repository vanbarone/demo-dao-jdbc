package application;

import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;
import model.entities.Seller;

public class Program2 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		DepartmentDao departmentDao = DaoFactory.createDepartmentDao();
		
		System.out.println("=== Teste 1: department findById ===");
		Department dep = departmentDao.findById(3);
		System.out.println(dep);
		
		System.out.println("\n=== Teste 2: department findAll ===");
		List<Department> lista2 = departmentDao.findAll();
		lista2.forEach(System.out::println);
		
		System.out.println("\n=== Teste 3: department insert ===");
		Department newDep = new Department(null, "Teste");
		departmentDao.insert(newDep);
		System.out.println("Inserted - New id = " + newDep.getId());
		
		System.out.println("\n=== Teste 4: department update ===");
		Department upDep = departmentDao.findById(1);
		upDep.setName("Teste Up");
		departmentDao.update(upDep);
		System.out.println("Update completed");
		
		System.out.println("\n=== Teste 5: department delete ===");
		System.out.print("Informe o id para deletar: ");
		int id = sc.nextInt();
		departmentDao.deleteById(id);
		System.out.println("Deleted completed");
	}

}
