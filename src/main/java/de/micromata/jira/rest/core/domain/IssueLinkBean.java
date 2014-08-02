/*
 * Copyright 2013 the original author or authors.
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package de.micromata.jira.rest.core.domain;

/**
 * @author Christian Schulze
 * @author Vitali Filippow
 */
public class IssueLinkBean extends BaseBean {

    private TypeBean typeBean = null;

    private IssueBasicBean outwardIssueBean = null;

    private IssueBasicBean inwardIssueBean = null;

    public TypeBean getTypeBean() {
        return typeBean;
    }

    public void setTypeBean(TypeBean typeBean) {
        this.typeBean = typeBean;
    }

    public IssueBasicBean getOutwardIssue() {
        return outwardIssueBean;
    }

    public void setOutwardIssue(IssueBasicBean outwardIssueBean) {
        this.outwardIssueBean = outwardIssueBean;
    }

    public IssueBasicBean getInwardIssue() {
        return inwardIssueBean;
    }

    public void setInwardIssue(IssueBasicBean inwardIssueBean) {
        this.inwardIssueBean = inwardIssueBean;
    }
}
