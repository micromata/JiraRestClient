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

package de.micromata.jira.rest.core.jql;

import org.apache.commons.lang3.StringUtils;

/**
 * JQL builder
 * <p/>
 * <p>JQL condition = ( field + operator + operand ) + JqlKeyword + ...
 * <p>Example: ( PROJECT = DEMO ) + AND ...
 *
 * @author Christian Schulze
 * @author Vitali Filippow
 */
public class JqlBuilder {

    private StringBuffer jql = null;

    public JqlBuilder() {
        jql = new StringBuffer();
    }

    public JqlKeyword addCondition(EField field, EOperator operator, String... operand) {
        JqlKeyword jqlKeyword = new JqlKeyword();

        if (field != null) {
            jql.append(field).append(" ");
        }
        if (operator != null) {
            jql.append(operator).append(" ");
        }
        if (operand != null) {
            if(operand.length > 1){
                String join = StringUtils.join(operand, ",");
                jql.append("(").append(join).append(") ");
            }else {
                jql.append(operand[0]).append(" ");
            }
        }

        return jqlKeyword;
    }

    public JqlBuilder getJqlBuilder() {
        return this;
    }

    public void clear() {
        jql.setLength(0);
    }

    public class JqlKeyword {

        public JqlBuilder and() {
            jql.append(EKeyword.AND + " ");
            return getJqlBuilder();
        }

        public JqlBuilder or() {
            jql.append(EKeyword.OR + " ");
            return getJqlBuilder();
        }

        public String orderBy(SortOrder order, EField... fields) {
            if (fields == null || order == null || fields.length == 0) {
                return build();
            }

            jql.append(EKeyword.ORDER_BY ).append(" ");
            jql.append(fields[0]);

            for (int i = 1; i < fields.length; i++) {
                jql.append(", ");
                jql.append(fields[i]);
            }

            jql.append(" ").append(order);

            return build();
        }

        /**
         * Return the request String and clear the buffer.
         *
         * @return
         */
        public String build() {
            String request = jql.toString();
            clear();
            return request;
        }
    }
}
