package ph.com.alliance.service;

import java.util.List;

import ph.com.alliance.entity.User;

public interface ModuleService {

	public String addTwoNumbers(String firstNumber, String secondNumber);

	public List<User> getAllUsers();

	public void addUser(User user);

	public User getUser(String uid);

	public void editUser(User user);

	public void deleteUsers(String[] userIdList);
}
