package swp391.fa25.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.util.ArrayList;
import java.util.List;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name = "roles")
@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "role_id")
    int roleId;
    @Column(name = "role_name", nullable = false, unique = true, length = 50)
    String roleName;

    @OneToMany(mappedBy = "role")
    List<User> users = new ArrayList<>();




}

