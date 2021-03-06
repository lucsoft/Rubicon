/*
 * Copyright (c) 2017 Rubicon Bot Development Team
 *
 * Licensed under the MIT license. The full license text is available in the LICENSE file provided with this project.
 */

package fun.rubicon.data;

import java.util.Comparator;

/**
 * Specifies a group of users that can access permission-locked features.
 * @deprecated Use the {@link fun.rubicon.permission} package instead.
 */
@Deprecated
public enum PermissionLevel implements Comparator<PermissionLevel> {
    /**
     * Every user can access the feature.
     */
    EVERYONE(0),
    /**
     * Only users with the corresponding permission node can access the feature.
     */
    WITH_PERMISSION(1),
    /**
     * @deprecated Administrator permissions should be defined by server owners, not by defaults.
     */
    @Deprecated
    ADMINISTRATOR(2),
    /**
     * @deprecated As server owners have access to all permission-restricted things (except author exclusive ones),
     * this level is redundant.
     */
    @Deprecated
    SERVER_OWNER(3),
    /**
     * Only bot authors can access the feature.
     */
    BOT_AUTHOR(4);

    /**
     * An id for permission levels that can also be compared.
     */
    public final int value;

    PermissionLevel(int value) {
        this.value = value;
    }

    /**
     * @param value the permission level id.
     * @return the PermissionLevel corresponding to value or null if the value is invalid.
     */
    public static PermissionLevel getByValue(int value) {
        for (PermissionLevel level : values())
            if (level.value == value)
                return level;
        return null;
    }

    @Override
    public int compare(PermissionLevel o1, PermissionLevel o2) {
        return Integer.compare(o1.value, o2.value);
    }
}
