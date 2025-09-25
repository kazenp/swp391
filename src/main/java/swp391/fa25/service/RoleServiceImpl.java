package swp391.fa25.service;

import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import swp391.fa25.dto.CreateRoleRequestDTO;
import swp391.fa25.entity.Role;
import swp391.fa25.repository.RoleRepository;

import java.util.List;

@Service
@FieldDefaults(level = AccessLevel.PRIVATE)
public class RoleServiceImpl implements RoleService {
    @Autowired
    RoleRepository roleRepository;

    @Override
    public Role findByRoleName(String roleName) {
        return roleRepository.findByRoleName(roleName);
    }

    @Override
    public Role getRoleById(int roleId) {
        return roleRepository.findById(roleId).orElse(null);
    }

    @Override
    public Role createRole(CreateRoleRequestDTO role) {
        Role newRole = new Role();
        newRole.setRoleName(role.getRoleName());
        return roleRepository.save(newRole);
    }

    @Override
    public Role updateRole(Role role) {
        Role existingRole = roleRepository.findById(role.getRoleId()).orElse(null);
        if (existingRole != null) {
            existingRole.setRoleName(role.getRoleName());
            return roleRepository.save(existingRole);
        }
        return existingRole;
    }

    @Override
    public void deleteRole(int roleId) {
        roleRepository.deleteById(roleId);
    }

    @Override
    public List<Role> getRoles() {
        return roleRepository.findAll();
    }
}
