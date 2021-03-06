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

package org.opencb.commons.filters;

import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: aleman
 * Date: 8/26/13
 * Time: 10:27 PM
 * To change this template use File | Settings | File Templates.
 */
@Deprecated
public class FilterApplicator {

    public static <E> boolean filter(List<E> recordList, List<? extends Filter<E>> filters) {

        Predicate<E> andFilter = Predicates.and(filters);

        List<E> aux = Lists.newArrayList(Iterables.filter(recordList, andFilter));
        return Iterables.retainAll(recordList, aux);

    }

    public static <E> boolean filter(List<E> recordList, Filter<E> filter) {

        List<E> aux = Lists.newArrayList(Iterables.filter(recordList, filter));
        return Iterables.retainAll(recordList, aux);

    }

}
