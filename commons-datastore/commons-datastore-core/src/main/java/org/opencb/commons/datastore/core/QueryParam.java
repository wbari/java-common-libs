/*
 * Copyright 2015-2017 OpenCB
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.opencb.commons.datastore.core;

/**
 * @author Jacobo Coll &lt;jacobo167@gmail.com&gt;
 */
public interface QueryParam {

    enum Type {
        STRING,
        TEXT,
        TEXT_ARRAY,
        INTEGER,
        INTEGER_ARRAY,
        DOUBLE,
        DECIMAL,
        DECIMAL_ARRAY,
        BOOLEAN,
        DATE
    }

    String key();

    String description();

    Type type();

    static QueryParam create(String key, String description, Type type) {
        return new QueryParamImpl(key, description, type);
    }

    class QueryParamImpl implements QueryParam {

        private final String key;
        private final String description;
        private final Type type;

        private QueryParamImpl(String key, String description, Type type) {
            this.key = key;
            this.description = description;
            this.type = type;
        }

        @Override
        public String key() {
            return key;
        }

        @Override
        public String description() {
            return description;
        }

        @Override
        public Type type() {
            return type;
        }
    }

}
