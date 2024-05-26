package com.vkr.inventory.services.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.vkr.inventory.dto.UserDTO;
import com.vkr.inventory.entity.DBRoles;
import com.vkr.inventory.entity.DBUserRoles;
import com.vkr.inventory.entity.DBUsers;
import com.vkr.inventory.exeption.CustomFieldValidationException;
import com.vkr.inventory.exeption.UsernameOrIdNotFound;
import com.vkr.inventory.repository.UserRepository;
import com.vkr.inventory.repository.UserRolesRepository;
import com.vkr.inventory.services.interfaces.IUserService;

@Service
@Transactional
public class UserService implements IUserService {
    @Autowired
    private UserRepository repository;
    @Autowired
    private UserRolesRepository userRolesRepository;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
	@Override
	public Iterable<DBUsers> getAllUsers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean checkUsernameAvailable(DBUsers user) throws CustomFieldValidationException {
		Optional<DBUsers> userFound = repository.findByUsername(user.getUsername());
        if (userFound.isPresent()) {
            throw new CustomFieldValidationException("Username not available", "username");
        }
        return true;
	}

	@Override
	public boolean checkPasswordValid(DBUsers user) {
		//  if (DBuser.getConfirmPassword() == null || user.getConfirmPassword().isEmpty()) {
	   //         throw new CustomFieldValidationException("Confirm Password is required", "confirmPassword");
	   //     }
	   //    if (!user.getPassword().equals(user.getConfirmPassword())) {
	    //     throw new CustomFieldValidationException("Password and Confirm Password are not the same", "password");
	     //   }
	     return true;
	}

	@Override
	public DBUsers createUser(DBUsers user,DBRoles role) throws CustomFieldValidationException  {
		
			 String encodedPassword = bCryptPasswordEncoder.encode(user.getPassword());
			 user.setPassword(encodedPassword);
			 user = repository.save(user);
			 DBUserRoles roles=new DBUserRoles();
			 roles.setDbRoles(role);
			 roles.setDbUsers(user);
			 userRolesRepository.save(roles);
		
        return user;
	}

	@Override
	public DBUsers getUserByUsername(String id) {
		 try {
			return repository.findByUsername(id).orElseThrow(() -> new UsernameOrIdNotFound("User id does not exist."));
		} catch (UsernameOrIdNotFound e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public DBUsers updateUser(DBUsers fromUser) {
		 DBUsers toUser = getUserByUsername(fromUser.getUsername());
	     mapUser(fromUser, toUser);
	     return repository.save(toUser);
	}

	@Override
	public void mapUser(DBUsers from, DBUsers to) {
		to.setUsername(from.getUsername());
        to.setMail(from.getMail());
        to.setDbUserRoles(from.getDbUserRoles());
	}

	@Override
	public void deleteUser(String id) {
		  DBUsers user =getUserByUsername (id);
	      repository.delete(user);
	}

	@Override
	public boolean isLoggedUserADMIN() {
		  Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

	        UserDetails loggedUser = null;
	        Object roles = null;

	        //Verify that this fetched session object is the user
	        if (principal instanceof UserDetails) {
	            loggedUser = (UserDetails) principal;

	            roles = loggedUser.getAuthorities().stream()
	                    .filter(x -> "ROLE_ADMIN".equals(x.getAuthority())).findFirst()
	                    .orElse(null);
	        }
	        return roles != null;
	}

	@Override
	public DBUsers getLoggedUser() throws Exception {
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        UserDetails loggedUser = null;

        //Verify that this fetched session object is the user
        if (principal instanceof UserDetails) {
            loggedUser = (UserDetails) principal;
        }

        DBUsers myUser = repository
                .findByUsername(loggedUser.getUsername()).orElseThrow(() -> new Exception("Error getting the logged " +
                        "in user from the session."));

        return myUser;
	}

	

}
