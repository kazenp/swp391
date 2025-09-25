package swp391.fa25.service;

import org.springframework.stereotype.Service;
import swp391.fa25.dto.CreateRoleRequestDTO;
import swp391.fa25.entity.Role;

import java.util.List;

@Service
public interface RoleService {
    public Role findByRoleName(String roleName);
    public Role getRoleById(int roleId);
    public Role createRole(CreateRoleRequestDTO role);
    public Role updateRole(Role role);
    public void deleteRole(int roleId);
    public List<Role> getRoles();


}
