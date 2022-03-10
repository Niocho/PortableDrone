/* AUTO-GENERATED FILE.  DO NOT MODIFY.
 *
 * This class was automatically generated by the
 * java mavlink generator tool. It should not be modified by hand.
 */

package com.mavlink.enums;

/** 
 * Flags to report failure cases over the high latency telemtry.
 */
public class HL_FAILURE_FLAG {
   public static final int HL_FAILURE_FLAG_GPS = 1; /* GPS failure. | */
   public static final int HL_FAILURE_FLAG_DIFFERENTIAL_PRESSURE = 2; /* Differential pressure sensor failure. | */
   public static final int HL_FAILURE_FLAG_ABSOLUTE_PRESSURE = 4; /* Absolute pressure sensor failure. | */
   public static final int HL_FAILURE_FLAG_3D_ACCEL = 8; /* Accelerometer sensor failure. | */
   public static final int HL_FAILURE_FLAG_3D_GYRO = 16; /* Gyroscope sensor failure. | */
   public static final int HL_FAILURE_FLAG_3D_MAG = 32; /* Magnetometer sensor failure. | */
   public static final int HL_FAILURE_FLAG_TERRAIN = 64; /* Terrain subsystem failure. | */
   public static final int HL_FAILURE_FLAG_BATTERY = 128; /* Battery failure/critical low battery. | */
   public static final int HL_FAILURE_FLAG_RC_RECEIVER = 256; /* RC receiver failure/no rc connection. | */
   public static final int HL_FAILURE_FLAG_OFFBOARD_LINK = 512; /* Offboard link failure. | */
   public static final int HL_FAILURE_FLAG_ENGINE = 1024; /* Engine failure. | */
   public static final int HL_FAILURE_FLAG_GEOFENCE = 2048; /* Geofence violation. | */
   public static final int HL_FAILURE_FLAG_ESTIMATOR = 4096; /* Estimator failure, for example measurement rejection or large variances. | */
   public static final int HL_FAILURE_FLAG_MISSION = 8192; /* Mission failure. | */
   public static final int HL_FAILURE_FLAG_ENUM_END = 8193; /*  | */
}
            