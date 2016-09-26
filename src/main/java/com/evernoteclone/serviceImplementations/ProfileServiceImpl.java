/**
 *
 */

package com.evernoteclone.serviceImplementations;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.evernoteclone.entities.Profile;
import com.evernoteclone.repositories.ProfileRepository;
import com.evernoteclone.services.ProfileService;

/**
 * Description: Description goes here.
 *
 * @author <a href="mailto:dushyant.shukla@senecaglobal.com@xxx">Dushyant
 *         Shukla</a>
 * @version $Revision$ $Date$
 * @since 0.1
 */
@Service
public class ProfileServiceImpl
	implements ProfileService
{

	@Autowired
	private ProfileRepository profileRepository;

	/**
	 * {@inheritDoc}
	 *
	 * @see com.evernoteclone.services.ProfileService#createProfile(com.evernoteclone.entities.Profile)
	 */
	@Override
	public Profile createProfile(Profile profile) {
		return profileRepository.save(profile);
	}

	/**
	 * {@inheritDoc}
	 *
	 * @see com.evernoteclone.services.ProfileService#deleteProfile(java.lang.Long)
	 */
	@Override
	public void deleteProfile(Long id) {
		profileRepository.delete(id);
	}

	/**
	 * {@inheritDoc}
	 *
	 * @see com.evernoteclone.services.ProfileService#findAllProfiles()
	 */
	@Override
	public List<Profile> findAllProfiles() {
		return profileRepository.findAll();
	}

	/**
	 * {@inheritDoc}
	 *
	 * @see com.evernoteclone.services.ProfileService#findProfile(java.lang.Long)
	 */
	@Override
	public Profile findProfile(Long id) {
		return profileRepository.findOne(id);
	}

	/**
	 * {@inheritDoc}
	 *
	 * @see com.evernoteclone.services.ProfileService#updateProfile(com.evernoteclone.entities.Profile)
	 */
	@Override
	public Profile updateProfile(Profile updatedProfile) {
		return profileRepository.save(updatedProfile);
	}

}
