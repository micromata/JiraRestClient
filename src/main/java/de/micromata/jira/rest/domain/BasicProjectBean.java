package de.micromata.jira.rest.domain;


/**
 * Created with IntelliJ IDEA.
 * User: Christian
 * Date: 01.03.13
 * Time: 11:50
 * To change this template use File | Settings | File Templates.
 */
public class BasicProjectBean extends BaseBean {

    private  String key;

    public BasicProjectBean() {
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }
}
