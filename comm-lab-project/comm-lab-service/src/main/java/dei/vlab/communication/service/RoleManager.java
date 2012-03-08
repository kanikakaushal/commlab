package dei.vlab.communication.service;

import dei.vlab.communication.model.Role;

import java.util.List;
public interface RoleManager extends GenericManager<Role, Long> {
    /**
     * {@inheritDoc}
     */
    List getRoles(Role role);

    /**
     * {@inheritDoc}
     */
    Role getRole(String rolename);

    /**
     * {@inheritDoc}
     */
    Role saveRole(Role role);

    /**
     * {@inheritDoc}
     */
    void removeRole(String rolename);
}
