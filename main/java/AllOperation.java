import java.util.List;
import java.util.Scanner;

import com.rentalrides.entity.Admin;
import com.rentalrides.entity.Booking;
import com.rentalrides.entity.Car;
import com.rentalrides.entity.CarMaintenance;
import com.rentalrides.entity.Insurance;
import com.rentalrides.entity.Payment;
import com.rentalrides.entity.User;
import com.rentalrides.exception.AdminException;
import com.rentalrides.entity.Register;
import com.rentalrides.entity.Login;
import com.rentalrides.service.AdminService;
import com.rentalrides.service.BookingService;
import com.rentalrides.service.CarMaintenanceService;
import com.rentalrides.service.CarService;
import com.rentalrides.service.InsuranceService;
import com.rentalrides.service.PaymentService;
import com.rentalrides.service.UserService;
import com.rentalrides.service.RegisterService;
import com.rentalrides.service.LoginService;
import com.rentalrides.serviceImpl.AdminServiceImpl;
import com.rentalrides.serviceImpl.BookingServiceImpl;
import com.rentalrides.serviceImpl.CarMaintenanceServiceImpl;
import com.rentalrides.serviceImpl.CarServiceImpl;
import com.rentalrides.serviceImpl.InsuranceServiceImpl;
import com.rentalrides.serviceImpl.PaymentServiceImpl;
import com.rentalrides.serviceImpl.UserServiceImpl;
import com.rentalrides.serviceImpl.RegisterServiceImpl;
import com.rentalrides.serviceImpl.LoginServiceImpl;


public class AllOperation {

	static AdminService adminService = new AdminServiceImpl();
	static UserService userService = new UserServiceImpl();
	static BookingService bookingService = new BookingServiceImpl();
	static PaymentService paymentService = new PaymentServiceImpl();
	static CarService carService = new CarServiceImpl();
	static CarMaintenanceService carMaintenanceService = new CarMaintenanceServiceImpl();
	static InsuranceService insuranceService = new InsuranceServiceImpl();
	static RegisterService registerService = new RegisterServiceImpl();
	static LoginService loginService = new LoginServiceImpl();

	static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		boolean exit = false;

		while (!exit) {
			System.out.println("Select an option:");
			System.out.println("1. User Operations");
			System.out.println("2. Admin Operations");
			System.out.println("3. Booking Operations");
			System.out.println("4. Car Operations");
			System.out.println("5. Payment Operations");
			System.out.println("6. Car Maintenance Operations");
			System.out.println("7. Insurance Operations");
			System.out.println("0. Exit");

			int choice = scanner.nextInt();
			scanner.nextLine(); // Consume newline

			switch (choice) {
			case 1:
				userOperations(scanner);
				break;
			case 2:
				adminOperations(scanner);
				break;
			case 3:
				bookingOperations(scanner);
				break;
			case 4:
				carOperations(scanner);
				break;
			case 5:
				paymentOperations(scanner);
				break;
			case 6:
				carMaintenanceOperations(scanner);
				break;
			case 7:
				insuranceOperations(scanner);
				break;
			case 0:
				exit = true;
				break;
			default:
				System.out.println("Invalid option. Please try again.");
			}
		}

		scanner.close();
	}

	private static void userOperations(Scanner scanner) {
		System.out.println("User Operations:");
		System.out.println("1. Register User");
		System.out.println("2. Login User");
		// Add other user operations here

		int choice = scanner.nextInt();
		scanner.nextLine(); // Consume newline

		switch (choice) {
		case 1:
			System.out.println("Enter User details: ");
			Register registerUser = new Register();
			System.out.println("Enter Username: ");
			registerUser.setUsername(scanner.nextLine());
			System.out.println("Enter Email: ");
			registerUser.setEmail(scanner.nextLine());
			System.out.println("Enter Password: ");
			registerUser.setPassword(scanner.nextLine());
			registerService.saveRegister(registerUser);
			System.out.println("User registered successfully!");
			break;
		case 2:
			System.out.println("Enter Email: ");
			String email = scanner.nextLine();
			System.out.println("Enter Password: ");
			String password = scanner.nextLine();
			Login login = new Login(email, password);
			boolean isLoginSuccessful = loginService.loginUser(login);
			if (isLoginSuccessful) {
				System.out.println("Login successful!");
			} else {
				System.out.println("Login failed. Please check your credentials.");
			}
			break;
		default:
			System.out.println("Invalid option. Please try again.");
		}
	}

	private static void adminOperations(Scanner scanner) {
		System.out.print("Enter Admin Username: ");
		String adminUsername = scanner.nextLine();
		System.out.print("Enter Admin Password: ");
		String adminPassword = scanner.nextLine();

		try {
			if (adminService.authenticate(adminUsername, adminPassword)) {
				System.out.println("Admin Logged In!");
				boolean continueOperations = true;

				while (continueOperations) {
					System.out.println("\nSelect an operation:");
					System.out.println("1. Manage User Accounts");
					System.out.println("2. Manage Bookings");
					System.out.println("3. Manage Payments");
					System.out.println("4. Manage Cars");
					System.out.println("5. Manage Insurance");
					System.out.println("6. Manage Car Maintenance");
					System.out.println("7. Logout");

					int choice = Integer.parseInt(scanner.nextLine());

					switch (choice) {
					case 1:
						handleUserAccounts(scanner);
						break;
					case 2:
						handleBookings(scanner);
						break;
					case 3:
						handlePayments(scanner);
						break;
					case 4:
						handleCars(scanner);
						break;
					case 5:
						handleInsurance(scanner);
						break;

					case 6:
						continueOperations = false;
						System.out.println("Logged out.");
						break;
					default:
						System.out.println("Invalid choice. Please try again.");
					}
				}
			} else {
				System.out.println("Invalid admin credentials!");
			}
		} catch (AdminException e) {
			e.printStackTrace();
		}
	}

	private static void handleUserAccounts(Scanner scanner) {
		System.out.println("User Account Management:");
		boolean continueUserManagement = true;

		while (continueUserManagement) {
			System.out.println("\nSelect an action:");
			System.out.println("1. List Users");
			System.out.println("2. Add User");
			System.out.println("3. Update User");
			System.out.println("4. Delete User");
			System.out.println("5. Back to Admin Menu");

			int choice = Integer.parseInt(scanner.nextLine());

			switch (choice) {
			case 1:
				// Logic to list users
				List<User> users = userService.getAllUsers();
				for (User user : users) {
					System.out.println(user);
				}
				break;
			case 2:
				// Logic to add a user
				System.out.print("Enter User Name: ");
				String userName = scanner.nextLine();
				System.out.print("Enter User Email: ");
				String userEmail = scanner.nextLine();
				userService.saveUser(new User(userName, userEmail)); // Update with actual User constructor
				System.out.println("User added successfully!");
				break;
			case 3:
				// Logic to update a user
				System.out.print("Enter User ID to Update: ");
				Long userIdToUpdate = Long.parseLong(scanner.nextLine());
				User existingUser = userService.getUserById(userIdToUpdate);
				if (existingUser != null) {
					System.out.print("Enter New User Name: ");
					String newUserName = scanner.nextLine();
					System.out.print("Enter New User Email: ");
					String newUserEmail = scanner.nextLine();
					existingUser.setName(newUserName);
					existingUser.setEmail(newUserEmail);
					userService.updateUser(existingUser);
					System.out.println("User updated successfully!");
				} else {
					System.out.println("User not found!");
				}
				break;
			case 4:
				// Logic to delete a user
				System.out.print("Enter User ID to Delete: ");
				Long userIdToDelete = Long.parseLong(scanner.nextLine());
				userService.deleteUser(userIdToDelete);
				System.out.println("User deleted successfully!");
				break;
			case 5:
				continueUserManagement = false;
				break;
			default:
				System.out.println("Invalid choice. Please try again.");
			}
		}
	}

	private static void handleBookings(Scanner scanner) {
		System.out.println("Booking Management:");

		boolean continueBookingManagement = true;

		while (continueBookingManagement) {
			System.out.println("\nSelect an action:");
			System.out.println("1. List Bookings");
			System.out.println("2. Create Booking");
			System.out.println("3. Update Booking");
			System.out.println("4. Cancel Booking");
			System.out.println("5. Back to Admin Menu");

			int choice = Integer.parseInt(scanner.nextLine());

			switch (choice) {
			case 1:
				// Logic to list bookings
				List<Booking> bookings = bookingService.getAllBookings();
				for (Booking booking : bookings) {
					System.out.println(booking);
				}
				break;
			case 2:
				// Logic to create a booking
				System.out.print("Enter User ID: ");
				Long userId = Long.parseLong(scanner.nextLine());
				System.out.print("Enter Car ID: ");
				Long carId = Long.parseLong(scanner.nextLine());
				Booking newBooking = new Booking(userId, carId); // Update with actual Booking constructor
				bookingService.saveBooking(newBooking);
				System.out.println("Booking created successfully!");
				break;
			case 3:
				// Logic to update a booking
				System.out.print("Enter Booking ID to Update: ");
				Long bookingIdToUpdate = Long.parseLong(scanner.nextLine());
				Booking existingBooking = bookingService.getBookingById(bookingIdToUpdate);
				if (existingBooking != null) {
					System.out.print("Enter New Car ID: ");
					String newCarId =(scanner.nextLine());
					existingBooking.setCar(newCarId);
					bookingService.updateBooking(existingBooking);
					System.out.println("Booking updated successfully!");
				} else {
					System.out.println("Booking not found!");
				}
				break;
			case 4:
				// Logic to cancel a booking
				System.out.print("Enter Booking ID to Cancel: ");
				Long bookingIdToCancel = Long.parseLong(scanner.nextLine());
				bookingService.deleteBooking(bookingIdToCancel);
				System.out.println("Booking canceled successfully!");
				break;
			case 5:
				continueBookingManagement = false;
				break;
			default:
				System.out.println("Invalid choice. Please try again.");
			}
		}
	}

	private static void handlePayments(Scanner scanner) {
		System.out.println("Payment Management:");
		boolean continuePaymentManagement = true;

		while (continuePaymentManagement) {
			System.out.println("\nSelect an action:");
			System.out.println("1. List Payments");
			System.out.println("2. Process Payment");
			System.out.println("3. Refund Payment");
			System.out.println("4. Back to Admin Menu");

			int choice = Integer.parseInt(scanner.nextLine());

			switch (choice) {
			case 1:
				// Logic to list payments
				List<Payment> payments = paymentService.getAllPayments();
				for (Payment payment : payments) {
					System.out.println(payment);
				}
				break;
			case 2:
				// Logic to process a payment
				System.out.print("Enter Booking ID for Payment: ");
				Long bookingId = Long.parseLong(scanner.nextLine());
				paymentService.savePayment(bookingId); // Add any other necessary details
				System.out.println("Payment processed successfully!");
				break;
			case 3:
				// Logic to refund a payment
				System.out.print("Enter Payment ID to Refund: ");
				Long paymentIdToRefund = Long.parseLong(scanner.nextLine());
				paymentService.refundPayment(paymentIdToRefund);
				System.out.println("Payment refunded successfully!");
				break;
			case 4:
				continuePaymentManagement = false;
				break;
			default:
				System.out.println("Invalid choice. Please try again.");
			}
		}
	}

	private static void handleCars(Scanner scanner) {
		System.out.println("Car Management:");

		boolean continueCarManagement = true;

		while (continueCarManagement) {
			System.out.println("\nSelect an action:");
			System.out.println("1. List Cars");
			System.out.println("2. Add Car");
			System.out.println("3. Update Car");
			System.out.println("4. Remove Car");
			System.out.println("5. Back to Admin Menu");

			int choice = Integer.parseInt(scanner.nextLine());

			switch (choice) {
			case 1:
				// Logic to list cars
				List<Car> cars = carService.getAllCars();
				for (Car car : cars) {
					System.out.println(car);
				}
				break;
			case 2:
				// Logic to add a car
				System.out.print("Enter Car Model: ");
				String carModel = scanner.nextLine();
				System.out.print("Enter Car Price: ");
				double carPrice = Double.parseDouble(scanner.nextLine());
				Car newCar = new Car(carModel, carPrice); // Update with actual Car constructor
				carService.saveCar(newCar);
				System.out.println("Car added successfully!");
				break;
			case 3:
				// Logic to update a car
				System.out.print("Enter Car ID to Update: ");
				Long carIdToUpdate = Long.parseLong(scanner.nextLine());
				Car existingCar = carService.getCarById(carIdToUpdate);
				if (existingCar != null) {
					System.out.print("Enter New Car Model: ");
					String newCarModel = scanner.nextLine();
					System.out.print("Enter New Car Price: ");
					double newCarPrice = Double.parseDouble(scanner.nextLine());
					existingCar.setModel(newCarModel);
					existingCar.setPrice(newCarPrice);
					carService.updateCar(existingCar);
					System.out.println("Car updated successfully!");
				} else {
					System.out.println("Car not found!");
				}
				break;
			case 4:
				// Logic to remove a car
				System.out.print("Enter Car ID to Remove: ");
				Long carIdToRemove = Long.parseLong(scanner.nextLine());
				carService.deleteCar(carIdToRemove);
				System.out.println("Car removed successfully!");
				break;
			case 5:
				continueCarManagement = false;
				break;
			default:
				System.out.println("Invalid choice. Please try again.");
			}
		}
	}

	private static void handleInsurance(Scanner scanner) {
		System.out.println("Insurance Management:");

		boolean continueInsuranceManagement = true;

		while (continueInsuranceManagement) {
			System.out.println("\nSelect an action:");
			System.out.println("1. List Insurance Policies");
			System.out.println("2. Add Insurance Policy");
			System.out.println("3. Update Insurance Policy");
			System.out.println("4. Cancel Insurance Policy");
			System.out.println("5. Back to Admin Menu");

			int choice = Integer.parseInt(scanner.nextLine());

			switch (choice) {
			case 1:
				// Logic to list insurance policies
				List<Insurance> insurancePolicies = insuranceService.getAllInsurances();
				for (Insurance policy : insurancePolicies) {
					System.out.println(policy);
				}
				break;
			case 2:
				System.out.println("Enter InsuranceId : ");
				int insurance_id = Integer.parseInt(scanner.nextLine());
				System.out.print("Enter Policy Name: ");
				String policy_number = scanner.nextLine();
				System.out.print("Enter Policy Coverage Amount: ");
				double coverage_amount = Double.parseDouble(scanner.nextLine());
				System.out.print("Enter Policy Duration (in years): ");
				int start_date = Integer.parseInt(scanner.nextLine());
				System.out.print("Enter Policy Duration (in years): ");
				int end_date = Integer.parseInt(scanner.nextLine());
				// Assuming the InsurancePolicy class has a constructor like:
				// public InsurancePolicy(String policyName, double coverageAmount, int
				// duration)
				Insurance newPolicy = new Insurance();
				// Saving the new policy using the insurance service
				insuranceService.saveInsurance(newPolicy);
				System.out.println("Insurance policy added successfully!");
				break;
			}
		}
	}

//    private static void adminOperations(Scanner scanner) {
//        System.out.println("Admin Operations:");
//        System.out.println("1. Register Admin");
//        System.out.println("2. Login Admin");
//        // Add other admin operations here
//
//        int choice = scanner.nextInt();
//        scanner.nextLine();  // Consume newline
//
//        switch (choice) {
//            case 1:
//                System.out.println("Enter Admin details: ");
//                Register registerAdmin = new Register();
//                System.out.println("Enter Username: ");
//                registerAdmin.setUsername(scanner.nextLine());
//                System.out.println("Enter Email: ");
//                registerAdmin.setEmail(scanner.nextLine());
//                System.out.println("Enter Password: ");
//                registerAdmin.setPassword(scanner.nextLine());
//                registerService.saveRegister(registerAdmin);
//                System.out.println("Admin registered successfully!");
//                break;
//            case 2:
//                System.out.println("Enter Login credentials: ");
//                Login loginAdmin = new Login();
//                System.out.println("Enter Email: ");
//                loginAdmin.setEmail(scanner.nextLine());
//                System.out.println("Enter Password: ");
//                loginAdmin.setPassword(scanner.nextLine());
//                if (loginService.loginAdmin(loginAdmin)) {
//                    System.out.println("Login successful!");
//                } else {
//                    System.out.println("Invalid credentials. Login failed.");
//                }
//                break;
//            default:
//                System.out.println("Invalid option. Please try again.");
//        }
//    }

	private static void bookingOperations(Scanner scanner) {
		System.out.println("Booking Operations:");
		System.out.println("1. Create Booking");
		System.out.println("2. View Booking");
		System.out.println("3. Update Booking");
		System.out.println("4. Delete Booking");

		int choice = scanner.nextInt();
		scanner.nextLine(); // Consume newline

		switch (choice) {
		case 1:
			System.out.println("Enter Booking details: ");
			Booking booking = new Booking();
			// Set booking details here
			bookingService.saveBooking(booking);
			System.out.println("Booking created successfully!");
			break;
		case 2:
			System.out.println("Enter Booking ID to view: ");
			Long bookingId = scanner.nextLong();
			Booking retrievedBooking = bookingService.getBookingById(bookingId);
			System.out.println("Booking Details: " + retrievedBooking);
			break;
		case 3:
			System.out.println("Enter Booking ID to update: ");
			Long bookingIdToUpdate = scanner.nextLong();
			// Set new booking details here
			bookingService.updateBooking(new Booking());
			System.out.println("Booking updated successfully!");
			break;
		case 4:
			System.out.println("Enter Booking ID to delete: ");
			Long bookingIdToDelete = scanner.nextLong();
			bookingService.deleteBooking(bookingIdToDelete);
			System.out.println("Booking deleted successfully!");
			break;
		default:
			System.out.println("Invalid option. Please try again.");
		}
	}

	private static void carOperations(Scanner scanner) {
		System.out.println("Car Operations:");
		System.out.println("1. Add Car");
		System.out.println("2. View Car");
		System.out.println("3. Update Car");
		System.out.println("4. Delete Car");

		int choice = scanner.nextInt();
		scanner.nextLine(); // Consume newline

		switch (choice) {
		case 1:
			System.out.println("Enter Car details: ");
			Car car = new Car();
			// Set car details here
			carService.saveCar(car);
			System.out.println("Car added successfully!");
			break;
		case 2:
			System.out.println("Enter Car number to view: ");
			Long carNumber = scanner.nextLong();
			Car retrievedCar = carService.getCarById(carNumber);
			System.out.println("Car Details: " + retrievedCar);
			break;
		case 3:
			System.out.println("Enter Car number to update: ");
			Long carNumberToUpdate = scanner.nextLong();
			// Set new car details here
			carService.updateCar(new Car());
			System.out.println("Car updated successfully!");
			break;
		case 4:
			System.out.println("Enter Car number to delete: ");
			Long carNumberToDelete = scanner.nextLong();
			carService.deleteCar(carNumberToDelete);
			System.out.println("Car deleted successfully!");
			break;
		default:
			System.out.println("Invalid option. Please try again.");
		}
	}

	private static void paymentOperations(Scanner scanner) {
		System.out.println("Payment Operations:");
		System.out.println("1. Add Payment");
		System.out.println("2. View Payment");
		System.out.println("3. Update Payment");
		System.out.println("4. Delete Payment");

		int choice = scanner.nextInt();
		scanner.nextLine(); // Consume newline

		switch (choice) {
		case 1:
			System.out.println("Enter Payment details: ");
			Payment payment = new Payment();
			// Set payment details here
			paymentService.savePayment(payment);
			System.out.println("Payment added successfully!");
			break;
		case 2:
			System.out.println("Enter Payment ID to view: ");
			Long paymentId = scanner.nextLong();
			Payment retrievedPayment = paymentService.getPaymentById(paymentId);
			System.out.println("Payment Details: " + retrievedPayment);
			break;
		case 3:
			System.out.println("Enter Payment ID to update: ");
			Long paymentIdToUpdate = scanner.nextLong();
			// Set new payment details here
			paymentService.updatePayment(new Payment());
			System.out.println("Payment updated successfully!");
			break;
		case 4:
			System.out.println("Enter Payment ID to delete: ");
			Long paymentIdToDelete = scanner.nextLong();
			paymentService.deletePayment(paymentIdToDelete);
			System.out.println("Payment deleted successfully!");
			break;
		default:
			System.out.println("Invalid option. Please try again.");
		}
	}

	private static void carMaintenanceOperations(Scanner scanner) {
		System.out.println("Car Maintenance Operations:");
		System.out.println("1. Add Car Maintenance");
		System.out.println("2. View Car Maintenance");
		System.out.println("3. Update Car Maintenance");
		System.out.println("4. Delete Car Maintenance");

		int choice = scanner.nextInt();
		scanner.nextLine(); // Consume newline

		switch (choice) {
		case 1:
			System.out.println("Enter Car Maintenance details: ");
			CarMaintenance carMaintenance = new CarMaintenance();
			// Set car maintenance details here
			carMaintenanceService.saveCarMaintenance(carMaintenance);
			System.out.println("Car Maintenance added successfully!");
			break;
		case 2:
			System.out.println("Enter Car Maintenance ID to view: ");
			Long maintenanceId = scanner.nextLong();
			CarMaintenance retrievedCarMaintenance = carMaintenanceService.getCarMaintenanceById(maintenanceId);
			System.out.println("Car Maintenance Details: " + retrievedCarMaintenance);
			break;
		case 3:
			System.out.println("Enter Car Maintenance ID to update: ");
			Long maintenanceIdToUpdate = scanner.nextLong();
			// Set new car maintenance details here
			carMaintenanceService.updateCarMaintenance(new CarMaintenance());
			System.out.println("Car Maintenance updated successfully!");
			break;
		case 4:
			System.out.println("Enter Car Maintenance ID to delete: ");
			Long maintenanceIdToDelete = scanner.nextLong();
			carMaintenanceService.deleteCarMaintenance(maintenanceIdToDelete);
			System.out.println("Car Maintenance deleted successfully!");
			break;
		default:
			System.out.println("Invalid option. Please try again.");
		}
	}

	private static void insuranceOperations(Scanner scanner) {
		System.out.println("Insurance Operations:");
		System.out.println("1. Add Insurance");
		System.out.println("2. View Insurance");
		System.out.println("3. Update Insurance");
		System.out.println("4. Delete Insurance");

		int choice = scanner.nextInt();
		scanner.nextLine(); // Consume newline

		switch (choice) {
		case 1:
			System.out.println("Enter Insurance details: ");
			Insurance insurance = new Insurance();
			// Set insurance details here
			insuranceService.saveInsurance(insurance);
			System.out.println("Insurance added successfully!");
			break;
		case 2:
			System.out.println("Enter Insurance ID to view: ");
			Long insuranceId = scanner.nextLong();
			Insurance retrievedInsurance = insuranceService.getInsuranceById(insuranceId);
			System.out.println("Insurance Details: " + retrievedInsurance);
			break;
		case 3:
			System.out.println("Enter Insurance ID to update: ");
			Long insuranceIdToUpdate = scanner.nextLong();
			// Set new insurance details here
			insuranceService.updateInsurance(new Insurance());
			System.out.println("Insurance updated successfully!");
			break;
		case 4:
			System.out.println("Enter Insurance ID to delete: ");
			Long insuranceIdToDelete = scanner.nextLong();
			insuranceService.deleteInsurance(insuranceIdToDelete);
			System.out.println("Insurance deleted successfully!");
			break;
		default:
			System.out.println("Invalid option. Please try again.");
		}
	}
}
