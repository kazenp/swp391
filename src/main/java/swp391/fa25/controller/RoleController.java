package swp391.fa25.controller;

import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import swp391.fa25.dto.CreateRoleRequestDTO;
import swp391.fa25.entity.Role;
import swp391.fa25.service.RoleService;

import java.util.List;

@RestController
@RequestMapping("/api/roles")
@CrossOrigin
@FieldDefaults(level = AccessLevel.PRIVATE)
public class RoleController {
    @Autowired
    RoleService roleService;

    @GetMapping("/")
    public ResponseEntity<List<Role>> getAllRoles() {
        return ResponseEntity.ok(roleService.getRoles());
    }

    @GetMapping("/{roleId}")
    public ResponseEntity<Role> getRoleById(@PathVariable int roleId) {
        Role role = roleService.getRoleById(roleId);
        if (role != null) {
            return ResponseEntity.ok(role);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/")
    public ResponseEntity<Role> createRole(@RequestBody CreateRoleRequestDTO role) {
        return ResponseEntity.ok(roleService.createRole(role));
    }

    @DeleteMapping("/{roleId}")
    public ResponseEntity<Void> deleteRole(@PathVariable int roleId) {
        roleService.deleteRole(roleId);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/")
    public ResponseEntity<Role> updateRole(@RequestBody Role role) {
        return ResponseEntity.ok(roleService.updateRole(role));
    }
}
