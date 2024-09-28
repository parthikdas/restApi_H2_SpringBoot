package com.example.demo.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.dbWork.demo.entity.UserData;
import com.dbWork.demo.repository_DAO.UserRepository;
import com.dbWork.demo.service.UserService;

public class UserServiceTest {
//	Here we are checking the service and repo is injected so we will use when().then() we will not check db operations
//  We are checking getAllUsers() and getUser() and saveUser() here 
	@InjectMocks
	UserService service;
	
	@Mock
	UserRepository repo; // The mock that will be injected into injectMocks
	
	@BeforeAll
	public static void willStart() {
		System.out.println("Service testing starts");
	}
	
	@BeforeEach
	public void setup() {
		
		MockitoAnnotations.openMocks(this); // scans the current test class for fields annotated with @Mock and @InjectMocks,
		// and sets them up accordingly. This ensures that each test starts with a fresh set of mocks.
		System.out.println("Before each");
	}
	
	// Test Method to check getAllUsers() method
	@Test
	public void testShowAll() {
		System.out.println("Going to check showAll");
		List<UserData> result = Arrays.asList(
			new UserData(1, "aa", "aa", "aa"),
			new UserData(2, "bb", "bb", "bb") 
		);
		 when(repo.findAll()).thenReturn(result); // This line means whenever repo.findAll() is called below then return the above list
		// This does not get database operation to get it
		
		List<UserData> users = service.showAll();
	    System.out.println("Users returned: " + users.size()); // Debug statement

	    // can check values too but only checking size
		assertEquals(2, users.size()); // 0 bcz in starting table has no rows, we can test for any value we want
		// verify() checks whether a specific method on a mock object was called, ensuring that your code interacts with dependencies correctly.
		verify(repo, times(1)).findAll(); // 1 time run only, basically the count too of how many times to be called
		System.out.println("testing done");
	}
	
	// Test Method to check getUser() method
	@Test
	public void testGetUser() {
		System.out.println("Going to check getUser");
		UserData expectedData = new UserData(0, "aa", "aa", "kittu");
	    Optional<UserData> optionalExpectedData = Optional.of(expectedData);
	    when(repo.findById(0)).thenReturn(optionalExpectedData); // mock the repo to return exp data
		UserData user = service.getUser(0); // optional not req as in service we are returning null if not found so u can directly check here
		assertEquals(expectedData , user);
		verify(repo, times(1)).findById(0);
		System.out.println("testing done");
	}
	
	// Test Method to check saveUser() method
	@Test
	public void testSaveUser() {
		System.out.println("Going to check saveUser");
		UserData userToBeEnteredData = new UserData(0,"aa", "aa", "aa") ;
		// mocking it, will send the above data when repo.save is called 
        when(repo.save(any(UserData.class))).thenReturn(userToBeEnteredData);
		UserData user = service.saveUser(userToBeEnteredData);
		assertEquals(userToBeEnteredData, user);
        verify(repo, times(1)).save(userToBeEnteredData);
		System.out.println("testing done");
	}
}
