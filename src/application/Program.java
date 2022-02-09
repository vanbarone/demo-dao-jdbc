package application;

import java.util.Date;
import java.util.List;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class Program {

	public static void main(String[] args) {
		
		SellerDao sellerDao = DaoFactory.createSellerDao();
		
		System.out.println("=== Teste 1: seller findById ===");
		Seller seller = sellerDao.findById(3);
		System.out.println(seller);
		
		System.out.println("\n=== Teste 2: seller findByDepartmentId ===");
		List<Seller> lista = sellerDao.findByDepartment(new Department(2, null));
		lista.forEach(System.out::println);
		
		System.out.println("\n=== Teste 3: seller findAll ===");
		List<Seller> lista2 = sellerDao.findAll();
		lista2.forEach(System.out::println);
		
		System.out.println("\n=== Teste 4: seller insert ===");
		Seller newSeller = new Seller(null, "Greg", "greg@gmail.com", new Date(), 1000.0, new Department(2, null));
		sellerDao.insert(newSeller);
		System.out.println("Inserted - New id = " + newSeller.getId());
		
	}

}
