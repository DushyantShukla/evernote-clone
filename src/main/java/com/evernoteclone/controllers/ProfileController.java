/**
 *
 */

package com.evernoteclone.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.evernoteclone.entities.Profile;
import com.evernoteclone.services.ProfileService;

/**
 * Description: Description goes here.
 *
 * @author <a href="mailto:dushyant.shukla@senecaglobal.com@xxx">Dushyant
 *         Shukla</a>
 * @version $Revision$ $Date$
 * @since 0.1
 */
@Controller
@RequestMapping("/profiles")
public class ProfileController {

	@Autowired
	private ProfileService profileService;

	/**
	 * @param json
	 * @return ResponseEntity<String>
	 */
	@RequestMapping(method = RequestMethod.POST, headers = "Accept=application/json")
	public ResponseEntity<String> createFromJson(@RequestBody String json) {
		Profile profile = Profile.fromJsonToProfile(json);
		profile = profileService.createProfile(profile);
		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Type", "application/json");
		return new ResponseEntity<String>(String.valueOf(profile.getId()), headers, HttpStatus.CREATED);
	}

	/**
	 * @param id
	 * @return ResponseEntity<String>
	 */
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE, headers = "Accept=application/json")
	public ResponseEntity<String> deleteFromJson(@PathVariable("id") Long id) {
		Profile profile = profileService.findProfile(id);
		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Type", "application/json");
		if (profile == null) {
			return new ResponseEntity<String>(headers, HttpStatus.NOT_FOUND);
		}
		profileService.deleteProfile(id);
		return new ResponseEntity<String>(headers, HttpStatus.OK);
	}

	/**
	 * @return ResponseEntity<String>
	 */
	@RequestMapping(headers = "Accept=application/json")
	@ResponseBody
	public ResponseEntity<String> listJson() {
		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Type", "application/json; charset=utf-8");
		List<Profile> result = profileService.findAllProfiles();
		return new ResponseEntity<String>(Profile.toJsonArray(result), headers, HttpStatus.OK);
	}

	/**
	 * @param id
	 * @return ResponseEntity<String>
	 */
	@RequestMapping(value = "/{id}", headers = "Accept=application/json")
	@ResponseBody
	public ResponseEntity<String> showJson(@PathVariable("id") Long id) {

		Profile profile = profileService.findProfile(id);
		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Type", "application/json; charset=utf-8");
		if (profile == null) {
			return new ResponseEntity<String>(headers, HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<String>(profile.toJson(), headers, HttpStatus.OK);
	}

	/**
	 * @param id
	 * @param json
	 * @return ResponseEntity<String>
	 */
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT, headers = "Accept=application/json")
	public ResponseEntity<String> updateFromJson(@PathVariable("id") Long id, @RequestBody String json) {
		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Type", "application/json");
		Profile profile = Profile.fromJsonToProfile(json);
		profile.setId(id);
		if (profileService.updateProfile(profile) == null) {
			return new ResponseEntity<String>(headers, HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<String>(profile.toJson(), headers, HttpStatus.OK);
	}
}
