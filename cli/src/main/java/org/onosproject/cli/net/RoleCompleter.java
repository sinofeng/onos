/*
 * Copyright 2014-present Open Networking Laboratory
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
package org.onosproject.cli.net;

import org.apache.karaf.shell.console.Completer;
import org.apache.karaf.shell.console.completer.StringsCompleter;
import org.onosproject.net.MastershipRole;

import java.util.List;
import java.util.SortedSet;

/**
 * Device mastership role completer.
 */
public class RoleCompleter implements Completer {
    @Override
    public int complete(String buffer, int cursor, List<String> candidates) {
        // Delegate string completer
        StringsCompleter delegate = new StringsCompleter();
        SortedSet<String> strings = delegate.getStrings();
        strings.add(MastershipRole.MASTER.toString().toLowerCase());
        strings.add(MastershipRole.STANDBY.toString().toLowerCase());
        strings.add(MastershipRole.NONE.toString().toLowerCase());

        // Now let the completer do the work for figuring out what to offer.
        return delegate.complete(buffer, cursor, candidates);
    }

}
