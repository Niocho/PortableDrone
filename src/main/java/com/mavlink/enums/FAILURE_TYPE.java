/* AUTO-GENERATED FILE.  DO NOT MODIFY.
 *
 * This class was automatically generated by the
 * java mavlink generator tool. It should not be modified by hand.
 */

package com.mavlink.enums;

/** 
 * List of possible failure type to inject.
 */
public class FAILURE_TYPE {
   public static final int FAILURE_TYPE_OK = 0; /* No failure injected, used to reset a previous failure. | */
   public static final int FAILURE_TYPE_OFF = 1; /* Sets unit off, so completely non-responsive. | */
   public static final int FAILURE_TYPE_STUCK = 2; /* Unit is stuck e.g. keeps reporting the same value. | */
   public static final int FAILURE_TYPE_GARBAGE = 3; /* Unit is reporting complete garbage. | */
   public static final int FAILURE_TYPE_WRONG = 4; /* Unit is consistently wrong. | */
   public static final int FAILURE_TYPE_SLOW = 5; /* Unit is slow, so e.g. reporting at slower than expected rate. | */
   public static final int FAILURE_TYPE_DELAYED = 6; /* Data of unit is delayed in time. | */
   public static final int FAILURE_TYPE_INTERMITTENT = 7; /* Unit is sometimes working, sometimes not. | */
   public static final int FAILURE_TYPE_ENUM_END = 8; /*  | */
}
            