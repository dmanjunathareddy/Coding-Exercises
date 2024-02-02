**Classes and Responsibilities:**
Pizza Class:

Attributes: pizzaId, name, description, price.
Methods: getDetails(), calculatePrice().
Customer Class:

Attributes: customerId, name, address, phone.
Methods: placeOrder(List<Pizza> pizzas), viewOrderHistory().
Order Class:

Attributes: orderId, customer, pizzas, orderTime, status.
Methods: calculateTotalPrice(), updateStatus().
PizzaMenu Class:

Attributes: menuItems (List of available pizzas).
Methods: getPizzaByName(String name), getAllPizzas().
PizzaBookingSystem Class:

Main class managing the entire system.
Contains instances of PizzaMenu and CustomerRepository.
Methods: takeOrder(Customer customer, List<Pizza> pizzas), viewMenu().
CustomerRepository Class:

Manages customer information and order history.
Methods: addCustomer(Customer customer), getCustomerById(int customerId).
**Relationships:**
Pizza is part of PizzaMenu.
Order is associated with Customer and contains a list of Pizza items.
PizzaBookingSystem uses instances of PizzaMenu and CustomerRepository.
CustomerRepository maintains a list of registered customers and their order history