/**
 *
 */

package com.evernoteclone.services;

import java.util.List;

import com.evernoteclone.entities.Profile;

/**
 * Description: Description goes here.
 *
 * @author <a href="mailto:dushyant.shukla@senecaglobal.com@xxx">Dushyant
 *         Shukla</a>
 * @version $Revision$ $Date$
 * @since 0.1
 */
public interface ProfileService {

	/**
	 * @param profile
	 * @return Profile
	 */
	public Profile createProfile(Profile profile);

	/**
	 * @param id
	 */
	public void deleteProfile(Long id);

	/**
	 * @return Profile collection
	 */
	public List<Profile> findAllProfiles();

	/**
	 * @param id
	 * @return Profile
	 */
	public Profile findProfile(Long id);

	/**
	 * @param updatedProfile
	 * @return Profile
	 */
	public Profile updateProfile(Profile updatedProfile);

}
