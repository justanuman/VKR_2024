package com.vkr.inventory.services.interfaces;

import java.util.Optional;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import com.vkr.inventory.dto.UserDTO;
import com.vkr.inventory.entity.DBRoles;
import com.vkr.inventory.entity.DBUsers;
import com.vkr.inventory.exeption.CustomFieldValidationException;
import com.vkr.inventory.exeption.UsernameOrIdNotFound;

@Component
public interface IUserService {
	public Iterable<DBUsers> getAllUsers();
	public boolean checkUsernameAvailable(DBUsers user) throws CustomFieldValidationException;
	public boolean checkPasswordValid(DBUsers user);
    public DBUsers createUser(DBUsers user,DBRoles role) throws CustomFieldValidationException;
    public DBUsers getUserByUsername(String id);
    public DBUsers updateUser(DBUsers fromUser);
    public void mapUser(DBUsers from, DBUsers to);
    //@PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    public void deleteUser(String id);
    public boolean isLoggedUserADMIN();
    public DBUsers getLoggedUser() throws Exception;

}
