/**
 *
 */

package com.evernoteclone.entities;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;

import flexjson.JSONDeserializer;
import flexjson.JSONSerializer;

/**
 * Description: Description goes here.
 *
 * @author <a href="mailto:dushyant.shukla@senecaglobal.com@xxx">Dushyant
 *         Shukla</a>
 * @version $Revision$ $Date$
 * @since 0.1
 */
@Entity(name = "Profile")
public class Profile {

	/**
	 * @param json
	 * @return Profile collection
	 */
	public static Collection<Profile> fromJsonArrayToProfiles(String json) {
		return new JSONDeserializer<List<Profile>>().use(null, ArrayList.class).use("values", Profile.class).deserialize(json);
	}

	/**
	 * @param json
	 * @return Profile
	 */
	public static Profile fromJsonToProfile(String json) {
		return new JSONDeserializer<Profile>().use(null, Profile.class).deserialize(json);
	}

	/**
	 * @param collection
	 * @return String
	 */
	public static String toJsonArray(Collection<Profile> collection) {
		return new JSONSerializer().exclude("*.class").serialize(collection);
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	private Long id;

	@NotNull
	@Email
	@Column(name = "email", nullable = false)
	private String email;

	@NotNull
	@Size(min = 6, max = 10)
	@Column(name = "password", nullable = false)
	private String password;

	@NotNull
	@Column(name = "active", nullable = false)
	private boolean active;

	@Column(name = "registeredOn", nullable = false)
	private LocalDate registeredOn = LocalDate.now();

	/**
	 *
	 */
	public Profile() {
	}

	/**
	 * {@inheritDoc}
	 *
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		Profile other = (Profile) obj;
		if (active != other.active) {
			return false;
		}
		if (email == null) {
			if (other.email != null) {
				return false;
			}
		} else if (!email.equals(other.email)) {
			return false;
		}
		if (password == null) {
			if (other.password != null) {
				return false;
			}
		} else if (!password.equals(other.password)) {
			return false;
		}
		return true;
	}

	/**
	 * @return email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @return id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @return password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @return registeredOn
	 */
	public LocalDate getRegisteredOn() {
		return registeredOn;
	}

	/**
	 * {@inheritDoc}
	 *
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (active ? 1231 : 1237);
		result = prime * result + (email == null ? 0 : email.hashCode());
		result = prime * result + (password == null ? 0 : password.hashCode());
		return result;
	}

	/**
	 * @return active status
	 */
	public boolean isActive() {
		return active;
	}

	/**
	 * @param active
	 */
	public void setActive(boolean active) {
		this.active = active;
	}

	/**
	 * @param email
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @param id
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @param password
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @param registeredOn
	 */
	public void setRegisteredOn(LocalDate registeredOn) {
		this.registeredOn = registeredOn;
	}

	/**
	 * @return String
	 */
	public String toJson() {
		return new JSONSerializer().exclude("*.class").serialize(this);
	}

}
