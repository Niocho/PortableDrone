/* AUTO-GENERATED FILE.  DO NOT MODIFY.
 *
 * This class was automatically generated by the
 * java mavlink generator tool. It should not be modified by hand.
 */

// MESSAGE TRAJECTORY_REPRESENTATION_WAYPOINTS PACKING
package com.mavlink.common;
import com.mavlink.MAVLinkPacket;
import com.mavlink.Messages.MAVLinkMessage;
import com.mavlink.Messages.MAVLinkPayload;
        
/**
 * Describe a trajectory using an array of up-to 5 waypoints in the local frame (MAV_FRAME_LOCAL_NED).
 */
public class msg_trajectory_representation_waypoints extends MAVLinkMessage {

    public static final int MAVLINK_MSG_ID_TRAJECTORY_REPRESENTATION_WAYPOINTS = 332;
    public static final int MAVLINK_MSG_LENGTH = 239;
    private static final long serialVersionUID = MAVLINK_MSG_ID_TRAJECTORY_REPRESENTATION_WAYPOINTS;

      
    /**
     * Timestamp (UNIX Epoch time or time since system boot). The receiving end can infer timestamp format (since 1.1.1970 or since system boot) by checking for the magnitude of the number.
     */
    public long time_usec;
      
    /**
     * X-coordinate of waypoint, set to NaN if not being used
     */
    public float pos_x[] = new float[5];
      
    /**
     * Y-coordinate of waypoint, set to NaN if not being used
     */
    public float pos_y[] = new float[5];
      
    /**
     * Z-coordinate of waypoint, set to NaN if not being used
     */
    public float pos_z[] = new float[5];
      
    /**
     * X-velocity of waypoint, set to NaN if not being used
     */
    public float vel_x[] = new float[5];
      
    /**
     * Y-velocity of waypoint, set to NaN if not being used
     */
    public float vel_y[] = new float[5];
      
    /**
     * Z-velocity of waypoint, set to NaN if not being used
     */
    public float vel_z[] = new float[5];
      
    /**
     * X-acceleration of waypoint, set to NaN if not being used
     */
    public float acc_x[] = new float[5];
      
    /**
     * Y-acceleration of waypoint, set to NaN if not being used
     */
    public float acc_y[] = new float[5];
      
    /**
     * Z-acceleration of waypoint, set to NaN if not being used
     */
    public float acc_z[] = new float[5];
      
    /**
     * Yaw angle, set to NaN if not being used
     */
    public float pos_yaw[] = new float[5];
      
    /**
     * Yaw rate, set to NaN if not being used
     */
    public float vel_yaw[] = new float[5];
      
    /**
     * MAV_CMD command id of waypoint, set to UINT16_MAX if not being used.
     */
    public int command[] = new int[5];
      
    /**
     * Number of valid points (up-to 5 waypoints are possible)
     */
    public short valid_points;
    

    /**
     * Generates the payload for a mavlink message for a message of this type
     * @return
     */
    @Override
    public MAVLinkPacket pack() {
        MAVLinkPacket packet = new MAVLinkPacket(MAVLINK_MSG_LENGTH,isMavlink2);
        packet.sysid = sysid;
        packet.compid = compid;
        packet.msgid = MAVLINK_MSG_ID_TRAJECTORY_REPRESENTATION_WAYPOINTS;
        
        packet.payload.putUnsignedLong(time_usec);
        
        for (int i = 0; i < pos_x.length; i++) {
            packet.payload.putFloat(pos_x[i]);
        }
                    
        
        for (int i = 0; i < pos_y.length; i++) {
            packet.payload.putFloat(pos_y[i]);
        }
                    
        
        for (int i = 0; i < pos_z.length; i++) {
            packet.payload.putFloat(pos_z[i]);
        }
                    
        
        for (int i = 0; i < vel_x.length; i++) {
            packet.payload.putFloat(vel_x[i]);
        }
                    
        
        for (int i = 0; i < vel_y.length; i++) {
            packet.payload.putFloat(vel_y[i]);
        }
                    
        
        for (int i = 0; i < vel_z.length; i++) {
            packet.payload.putFloat(vel_z[i]);
        }
                    
        
        for (int i = 0; i < acc_x.length; i++) {
            packet.payload.putFloat(acc_x[i]);
        }
                    
        
        for (int i = 0; i < acc_y.length; i++) {
            packet.payload.putFloat(acc_y[i]);
        }
                    
        
        for (int i = 0; i < acc_z.length; i++) {
            packet.payload.putFloat(acc_z[i]);
        }
                    
        
        for (int i = 0; i < pos_yaw.length; i++) {
            packet.payload.putFloat(pos_yaw[i]);
        }
                    
        
        for (int i = 0; i < vel_yaw.length; i++) {
            packet.payload.putFloat(vel_yaw[i]);
        }
                    
        
        for (int i = 0; i < command.length; i++) {
            packet.payload.putUnsignedShort(command[i]);
        }
                    
        packet.payload.putUnsignedByte(valid_points);
        
        if (isMavlink2) {
            
        }
        return packet;
    }

    /**
     * Decode a trajectory_representation_waypoints message into this class fields
     *
     * @param payload The message to decode
     */
    @Override
    public void unpack(MAVLinkPayload payload) {
        payload.resetIndex();
        
        this.time_usec = payload.getUnsignedLong();
         
        for (int i = 0; i < this.pos_x.length; i++) {
            this.pos_x[i] = payload.getFloat();
        }
                
         
        for (int i = 0; i < this.pos_y.length; i++) {
            this.pos_y[i] = payload.getFloat();
        }
                
         
        for (int i = 0; i < this.pos_z.length; i++) {
            this.pos_z[i] = payload.getFloat();
        }
                
         
        for (int i = 0; i < this.vel_x.length; i++) {
            this.vel_x[i] = payload.getFloat();
        }
                
         
        for (int i = 0; i < this.vel_y.length; i++) {
            this.vel_y[i] = payload.getFloat();
        }
                
         
        for (int i = 0; i < this.vel_z.length; i++) {
            this.vel_z[i] = payload.getFloat();
        }
                
         
        for (int i = 0; i < this.acc_x.length; i++) {
            this.acc_x[i] = payload.getFloat();
        }
                
         
        for (int i = 0; i < this.acc_y.length; i++) {
            this.acc_y[i] = payload.getFloat();
        }
                
         
        for (int i = 0; i < this.acc_z.length; i++) {
            this.acc_z[i] = payload.getFloat();
        }
                
         
        for (int i = 0; i < this.pos_yaw.length; i++) {
            this.pos_yaw[i] = payload.getFloat();
        }
                
         
        for (int i = 0; i < this.vel_yaw.length; i++) {
            this.vel_yaw[i] = payload.getFloat();
        }
                
         
        for (int i = 0; i < this.command.length; i++) {
            this.command[i] = payload.getUnsignedShort();
        }
                
        this.valid_points = payload.getUnsignedByte();
        
        if (isMavlink2) {
            
        }
    }

    /**
     * Constructor for a new message, just initializes the msgid
     */
    public msg_trajectory_representation_waypoints() {
        this.msgid = MAVLINK_MSG_ID_TRAJECTORY_REPRESENTATION_WAYPOINTS;
    }
    
    /**
     * Constructor for a new message, initializes msgid and all payload variables
     */
    public msg_trajectory_representation_waypoints( long time_usec, float[] pos_x, float[] pos_y, float[] pos_z, float[] vel_x, float[] vel_y, float[] vel_z, float[] acc_x, float[] acc_y, float[] acc_z, float[] pos_yaw, float[] vel_yaw, int[] command, short valid_points) {
        this.msgid = MAVLINK_MSG_ID_TRAJECTORY_REPRESENTATION_WAYPOINTS;

        this.time_usec = time_usec;
        this.pos_x = pos_x;
        this.pos_y = pos_y;
        this.pos_z = pos_z;
        this.vel_x = vel_x;
        this.vel_y = vel_y;
        this.vel_z = vel_z;
        this.acc_x = acc_x;
        this.acc_y = acc_y;
        this.acc_z = acc_z;
        this.pos_yaw = pos_yaw;
        this.vel_yaw = vel_yaw;
        this.command = command;
        this.valid_points = valid_points;
        
    }
    
    /**
     * Constructor for a new message, initializes everything
     */
    public msg_trajectory_representation_waypoints( long time_usec, float[] pos_x, float[] pos_y, float[] pos_z, float[] vel_x, float[] vel_y, float[] vel_z, float[] acc_x, float[] acc_y, float[] acc_z, float[] pos_yaw, float[] vel_yaw, int[] command, short valid_points, int sysid, int compid, boolean isMavlink2) {
        this.msgid = MAVLINK_MSG_ID_TRAJECTORY_REPRESENTATION_WAYPOINTS;
        this.sysid = sysid;
        this.compid = compid;
        this.isMavlink2 = isMavlink2;

        this.time_usec = time_usec;
        this.pos_x = pos_x;
        this.pos_y = pos_y;
        this.pos_z = pos_z;
        this.vel_x = vel_x;
        this.vel_y = vel_y;
        this.vel_z = vel_z;
        this.acc_x = acc_x;
        this.acc_y = acc_y;
        this.acc_z = acc_z;
        this.pos_yaw = pos_yaw;
        this.vel_yaw = vel_yaw;
        this.command = command;
        this.valid_points = valid_points;
        
    }

    /**
     * Constructor for a new message, initializes the message with the payload
     * from a mavlink packet
     *
     */
    public msg_trajectory_representation_waypoints(MAVLinkPacket mavLinkPacket) {
        this.msgid = MAVLINK_MSG_ID_TRAJECTORY_REPRESENTATION_WAYPOINTS;
        
        this.sysid = mavLinkPacket.sysid;
        this.compid = mavLinkPacket.compid;
        this.isMavlink2 = mavLinkPacket.isMavlink2;
        unpack(mavLinkPacket.payload);
    }

                                
    /**
     * Returns a string with the MSG name and data
     */
    @Override
    public String toString() {
        return "MAVLINK_MSG_ID_TRAJECTORY_REPRESENTATION_WAYPOINTS - sysid:"+sysid+" compid:"+compid+" time_usec:"+time_usec+" pos_x:"+pos_x+" pos_y:"+pos_y+" pos_z:"+pos_z+" vel_x:"+vel_x+" vel_y:"+vel_y+" vel_z:"+vel_z+" acc_x:"+acc_x+" acc_y:"+acc_y+" acc_z:"+acc_z+" pos_yaw:"+pos_yaw+" vel_yaw:"+vel_yaw+" command:"+command+" valid_points:"+valid_points+"";
    }
    
    /**
     * Returns a human-readable string of the name of the message
     */
    @Override
    public String name() {
        return "MAVLINK_MSG_ID_TRAJECTORY_REPRESENTATION_WAYPOINTS";
    }
}
        