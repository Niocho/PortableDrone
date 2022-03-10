/* AUTO-GENERATED FILE.  DO NOT MODIFY.
 *
 * This class was automatically generated by the
 * java mavlink generator tool. It should not be modified by hand.
 */

package com.mavlink.enums;

/** 
 * Bitmask of (optional) autopilot capabilities (64 bit). If a bit is set, the autopilot supports this capability.
 */
public class MAV_PROTOCOL_CAPABILITY {
   public static final int MAV_PROTOCOL_CAPABILITY_MISSION_FLOAT = 1; /* Autopilot supports the MISSION_ITEM float message type.
          Note that MISSION_ITEM is deprecated, and autopilots should use MISSION_INT instead.
         | */
   public static final int MAV_PROTOCOL_CAPABILITY_PARAM_ENCODE_C_CAST = 2; /* Parameter protocol uses C-cast of parameter values to set the param_value (float) fields: https://mavlink.io/en/services/parameter.html#parameter-encoding.
          Note that either this flag or MAV_PROTOCOL_CAPABILITY_PARAM_ENCODE_BYTEWISE should be set if the parameter protocol is supported.
         | */
   public static final int MAV_PROTOCOL_CAPABILITY_MISSION_INT = 4; /* Autopilot supports MISSION_ITEM_INT scaled integer message type.
          Note that this flag must always be set if missions are supported, because missions must always use MISSION_ITEM_INT (rather than MISSION_ITEM, which is deprecated).
         | */
   public static final int MAV_PROTOCOL_CAPABILITY_COMMAND_INT = 8; /* Autopilot supports COMMAND_INT scaled integer message type. | */
   public static final int MAV_PROTOCOL_CAPABILITY_PARAM_ENCODE_BYTEWISE = 16; /* Parameter protocol uses byte-wise encoding of parameter values into param_value (float) fields: https://mavlink.io/en/services/parameter.html#parameter-encoding.
          Note that either this flag or MAV_PROTOCOL_CAPABILITY_PARAM_ENCODE_BYTEWISE should be set if the parameter protocol is supported.
         | */
   public static final int MAV_PROTOCOL_CAPABILITY_FTP = 32; /* Autopilot supports the File Transfer Protocol v1: https://mavlink.io/en/services/ftp.html. | */
   public static final int MAV_PROTOCOL_CAPABILITY_SET_ATTITUDE_TARGET = 64; /* Autopilot supports commanding attitude offboard. | */
   public static final int MAV_PROTOCOL_CAPABILITY_SET_POSITION_TARGET_LOCAL_NED = 128; /* Autopilot supports commanding position and velocity targets in local NED frame. | */
   public static final int MAV_PROTOCOL_CAPABILITY_SET_POSITION_TARGET_GLOBAL_INT = 256; /* Autopilot supports commanding position and velocity targets in global scaled integers. | */
   public static final int MAV_PROTOCOL_CAPABILITY_TERRAIN = 512; /* Autopilot supports terrain protocol / data handling. | */
   public static final int MAV_PROTOCOL_CAPABILITY_SET_ACTUATOR_TARGET = 1024; /* Autopilot supports direct actuator control. | */
   public static final int MAV_PROTOCOL_CAPABILITY_FLIGHT_TERMINATION = 2048; /* Autopilot supports the MAV_CMD_DO_FLIGHTTERMINATION command (flight termination). | */
   public static final int MAV_PROTOCOL_CAPABILITY_COMPASS_CALIBRATION = 4096; /* Autopilot supports onboard compass calibration. | */
   public static final int MAV_PROTOCOL_CAPABILITY_MAVLINK2 = 8192; /* Autopilot supports MAVLink version 2. | */
   public static final int MAV_PROTOCOL_CAPABILITY_MISSION_FENCE = 16384; /* Autopilot supports mission fence protocol. | */
   public static final int MAV_PROTOCOL_CAPABILITY_MISSION_RALLY = 32768; /* Autopilot supports mission rally point protocol. | */
   public static final int MAV_PROTOCOL_CAPABILITY_RESERVED2 = 65536; /* Reserved for future use. | */
   public static final int MAV_PROTOCOL_CAPABILITY_ENUM_END = 65537; /*  | */
}
            