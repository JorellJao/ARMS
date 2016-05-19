package ph.com.alliance.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the armsuser database table.
 * 
 */
@Entity
@NamedQuery(name="Armsuser.findAll", query="SELECT a FROM Armsuser a")
public class Armsuser implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private ArmsuserPK id;

	@Column(name="first_name")
	private String firstName;

	@Column(name="last_name")
	private String lastName;

	private String password;

	@Column(name="role_id")
	private int roleId;

	public Armsuser() {
	}

	public ArmsuserPK getId() {
		return this.id;
	}

	public void setId(ArmsuserPK id) {
		this.id = id;
	}

	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getRoleId() {
		return this.roleId;
	}

	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}

}