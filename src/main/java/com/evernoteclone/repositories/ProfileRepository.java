/**
 *
 */

package com.evernoteclone.repositories;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.evernoteclone.entities.Profile;

/**
 * Description: Description goes here.
 *
 * @author <a href="mailto:dushyant.shukla@senecaglobal.com@xxx">Dushyant
 *         Shukla</a>
 * @version $Revision$ $Date$
 * @since 0.1
 */
public interface ProfileRepository
	extends PagingAndSortingRepository<Profile, Long>
{

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.springframework.data.repository.CrudRepository#findAll()
	 */
	@Override
	List<Profile> findAll();
}
