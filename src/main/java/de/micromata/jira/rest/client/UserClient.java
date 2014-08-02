package de.micromata.jira.rest.client;

import de.micromata.jira.rest.core.domain.UserBean;

import java.util.List;

/**
 * Author: Christian Schulze
 * Email: c.schulze@micromata.de
 * Date: 02.08.2014
 */
public interface UserClient {


    /**
     * Return a list of all Users which are part of a Project
     *
     * @param projectKey The key of the Project
     * @return A List of UserBeans
     */
    public List<UserBean> getUsersForProject(String projectKey);


    /**
     * Returns a User by his username
     *
     * @param username The username of the User
     * @return UserBean
     */
    public UserBean getUserByUsername(String username);
}
