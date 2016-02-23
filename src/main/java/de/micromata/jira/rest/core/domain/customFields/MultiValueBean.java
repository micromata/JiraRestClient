package de.micromata.jira.rest.core.domain.customFields;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by cschulc on 22.02.16.
 */
public class MultiValueBean extends CustomFieldBaseBean {

    private List<ValueBean> values;

    public List<ValueBean> getValues() {
        if(values == null){
            values = new ArrayList<>();
        }
        return values;
    }

    public void setValues(List<ValueBean> values) {
        this.values = values;
    }
}
