package com.vkr.inventory.control;

import static java.util.Arrays.asList;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.util.CollectionUtils;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.vkr.inventory.entity.DBItem;
import com.vkr.inventory.entity.DBRoles;
import com.vkr.inventory.entity.DBUsers;
import com.vkr.inventory.exeption.CustomFieldValidationException;
import com.vkr.inventory.exeption.UsernameOrIdNotFound;
import com.vkr.inventory.repository.ClassRepository;
import com.vkr.inventory.repository.ItemRepository;
import com.vkr.inventory.repository.RolesRepository;
import com.vkr.inventory.services.impl.ItemService;
import com.vkr.inventory.services.impl.UserService;

import lombok.extern.slf4j.Slf4j;


@Controller
@Slf4j
@Transactional
public class HeadControl {
	private final String TAB_FORM = "formTab";
    private final String TAB_LIST = "listTab";

    @Autowired
    private UserService userService;
    @Autowired
    private ItemService itemService;
    @Autowired
    private ItemRepository itemrepo;
    @Autowired
    private RolesRepository roleRepository;

    @GetMapping({"/", "/login"})
    public String index() {
        return "index";
    }

    @GetMapping("/signup")
    public String signup(Model model) {
        DBRoles userRole;
        List<DBRoles> roles = new ArrayList<>();
        List<DBRoles> userRoleList = (List<DBRoles>) roleRepository.findAll();
        
        if (CollectionUtils.isEmpty(userRoleList)) {
        	DBRoles role1 = new DBRoles();
        	role1.setStatus("active");
            role1.setRolename("SUPER ADMIN");
            //role1.setDescription("ROLE SUPER ADMIN");

            DBRoles role2 = new DBRoles();
            role2.setStatus("active");
            role2.setRolename("ADMIN");
           // role2.setDescription("ROLE ADMIN");

            DBRoles role3 = new DBRoles();
            role3.setStatus("active");
            role3.setRolename("USER");
           // role3.setDescription("ROLE USER");
            roleRepository.save(role1);
            roleRepository.save(role2);
            roleRepository.save(role3);
//            userRole = roleRepository.findByName("USER");
//            roles = asList(userRole);
        }
        userRole = roleRepository.findById("USER").orElse(null);
        roles = asList(userRole);
        log.info("User Role List {}", userRole);
        log.info("Accesing singup page");
        model.addAttribute("signup", true);
        model.addAttribute("userForm", new DBUsers());
        model.addAttribute("roles", roles);
        return "user-form/user-signup";
    }

    @PostMapping("/signup")
    @Transactional
    public String signupAction( @ModelAttribute("userForm") DBUsers user, BindingResult result, ModelMap model) throws CustomFieldValidationException {
    	DBRoles userRole = roleRepository.findById("USER").orElse(null);
        List<DBRoles> roles = asList(userRole);
        log.info("Creating user");
        model.addAttribute("userForm", user);
        model.addAttribute("roles", roles);
        model.addAttribute("signup", true);
        userService.createUser(user,roles.get(0));
       
        return index();
    }

    private void baseAttributerForUserForm(Model model, DBUsers user, String activeTab) {
        model.addAttribute("userForm", user);
        model.addAttribute("userList", userService.getAllUsers());
        model.addAttribute("roles", roleRepository.findAll());
        model.addAttribute(activeTab, "active");
    }

    @GetMapping("/userForm")
    public String userForm(Model model) {
        baseAttributerForUserForm(model, new DBUsers(), TAB_LIST);
        ArrayList<DBItem> items= (ArrayList<DBItem>) itemrepo.findAll();
    	log.info("fuck this");
    	log.info(items.toString());
    	model.addAttribute("items",items);
    	DBItem edititem =new DBItem();
    	model.addAttribute("edititem",edititem);
        return "user-form/user-view";
    }

    @PostMapping("/userForm")
    public String createUser(@ModelAttribute("userForm") DBUsers user, BindingResult result, Model model) {
    	
        if (result.hasErrors()) {
            baseAttributerForUserForm(model, user, TAB_FORM);
        } else {
            try {
            	 DBRoles role3 = new DBRoles();
                 role3.setStatus("active");
                 role3.setRolename("USER");
                userService.createUser(user,role3);
                log.info("User created succesfully.");
                baseAttributerForUserForm(model, new DBUsers(), TAB_LIST);

            } catch (CustomFieldValidationException cfve) {
                result.rejectValue(cfve.getFieldName(), null, cfve.getMessage());
                baseAttributerForUserForm(model, user, TAB_FORM);
            } catch (Exception e) {
                model.addAttribute("formErrorMessage", e.getMessage());
                baseAttributerForUserForm(model, user, TAB_FORM);
                log.info("Error  on User creation.");
            }
        }
        log.info("Show user-view page");
        return "user-form/user-view";
    }

  

    @GetMapping("/userForm/cancel")
    public String cancelEditUser() {
        return "redirect:/userForm";
    }

    @GetMapping("/deleteUser/{id}")
    public String deleteUser(Model model, @PathVariable(name = "username") String id) throws UsernameOrIdNotFound {
        userService.deleteUser(id);
		log.info("User deleted successfully.");
        return userForm(model);
    }

@GetMapping("/items/showItems")
public String showitems(Model model)  {
    ArrayList<DBItem> items= (ArrayList<DBItem>) itemrepo.findAll();
	log.info("fuck this");
	log.info(items.toString());
	model.addAttribute("items",items);
	DBItem edititem =new DBItem();
	model.addAttribute("edititem",edititem);
    return "item-form/showItems";
    }


@PostMapping("/items/showItems/edit")
@Transactional
public String edititems(@ModelAttribute("edititem") DBItem edititem,@ModelAttribute("userForm") DBUsers user,Model model)  {
	  baseAttributerForUserForm(model, new DBUsers(), TAB_LIST);
	 ArrayList<DBItem> items= (ArrayList<DBItem>) itemrepo.findAll();
		log.info("fuck this edit");
		log.info(items.toString());
		model.addAttribute("items",items);
	model.addAttribute("edititem",edititem);
	DBItem seconditem = itemrepo.findById(edititem.getId()).orElse(null);
	
	seconditem.setItemname(edititem.getItemname());
	if (edititem.getDbUsers()!=null) {seconditem.setDbUsers(edititem.getDbUsers());}
	if (edititem.getStatus()!=null) {seconditem.setStatus(edititem.getStatus());}
	if (edititem.getRfidId()!=null) {seconditem.setRfidId(edititem.getRfidId());}
	if (edititem.getEditedAt()!=null) {seconditem.setEditedAt(edititem.getEditedAt());}else
	{seconditem.setEditedAt(LocalTime.now());}
	
	itemrepo.save(seconditem);
	items=(ArrayList<DBItem>) itemrepo.findAll();
    return "user-form/user-view";
    }
}
    /*
    @PostMapping("/editUser/changePassword")
    public ResponseEntity postEditUseChangePassword( @RequestBody ChangePasswordForm form, Errors errors) {
        try {
            if (errors.hasErrors()) {
                String result = errors.getAllErrors()
                        .stream().map(DefaultMessageSourceResolvable::getDefaultMessage)
                        .collect(Collectors.joining(""));

                throw new Exception(result);
            }
            userService.changePassword(form);
            log.info("Change password successfully.");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
        return ResponseEntity.ok("Success");
    }

}*/
