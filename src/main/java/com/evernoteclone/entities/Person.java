/**
 *
 */

package com.evernoteclone.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Description: Description goes here.
 *
 * @author <a href="mailto:dushyant.shukla@senecaglobal.com@xxx">Dushyant
 *         Shukla</a>
 * @version $Revision$ $Date$
 * @since 0.1
 */
@Entity
public class Person {

	@Id
	@GeneratedValue
	private Long id;

	private String firstName;

	private String lastName;

	/**
	 * @return value
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @return value
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @param firstName
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * @param lastname
	 */
	public void setLastName(String lastname) {
		lastName = lastname;
	}

	/**
	 * {@inheritDoc}
	 *
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Person [firstName=" + firstName + ", lastName=" + lastName + "]";
	}
}
