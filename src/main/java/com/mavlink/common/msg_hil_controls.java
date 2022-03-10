/* AUTO-GENERATED FILE.  DO NOT MODIFY.
 *
 * This class was automatically generated by the
 * java mavlink generator tool. It should not be modified by hand.
 */

// MESSAGE HIL_CONTROLS PACKING
package com.mavlink.common;
import com.mavlink.MAVLinkPacket;
import com.mavlink.Messages.MAVLinkMessage;
import com.mavlink.Messages.MAVLinkPayload;
        
/**
 * Sent from autopilot to simulation. Hardware in the loop control outputs
 */
public class msg_hil_controls extends MAVLinkMessage {

    public static final int MAVLINK_MSG_ID_HIL_CONTROLS = 91;
    public static final int MAVLINK_MSG_LENGTH = 42;
    private static final long serialVersionUID = MAVLINK_MSG_ID_HIL_CONTROLS;

      
    /**
     * Timestamp (UNIX Epoch time or time since system boot). The receiving end can infer timestamp format (since 1.1.1970 or since system boot) by checking for the magnitude of the number.
     */
    public long time_usec;
      
    /**
     * Control output -1 .. 1
     */
    public float roll_ailerons;
      
    /**
     * Control output -1 .. 1
     */
    public float pitch_elevator;
      
    /**
     * Control output -1 .. 1
     */
    public float yaw_rudder;
      
    /**
     * Throttle 0 .. 1
     */
    public float throttle;
      
    /**
     * Aux 1, -1 .. 1
     */
    public float aux1;
      
    /**
     * Aux 2, -1 .. 1
     */
    public float aux2;
      
    /**
     * Aux 3, -1 .. 1
     */
    public float aux3;
      
    /**
     * Aux 4, -1 .. 1
     */
    public float aux4;
      
    /**
     * System mode.
     */
    public short mode;
      
    /**
     * Navigation mode (MAV_NAV_MODE)
     */
    public short nav_mode;
    

    /**
     * Generates the payload for a mavlink message for a message of this type
     * @return
     */
    @Override
    public MAVLinkPacket pack() {
        MAVLinkPacket packet = new MAVLinkPacket(MAVLINK_MSG_LENGTH,isMavlink2);
        packet.sysid = sysid;
        packet.compid = compid;
        packet.msgid = MAVLINK_MSG_ID_HIL_CONTROLS;
        
        packet.payload.putUnsignedLong(time_usec);
        packet.payload.putFloat(roll_ailerons);
        packet.payload.putFloat(pitch_elevator);
        packet.payload.putFloat(yaw_rudder);
        packet.payload.putFloat(throttle);
        packet.payload.putFloat(aux1);
        packet.payload.putFloat(aux2);
        packet.payload.putFloat(aux3);
        packet.payload.putFloat(aux4);
        packet.payload.putUnsignedByte(mode);
        packet.payload.putUnsignedByte(nav_mode);
        
        if (isMavlink2) {
            
        }
        return packet;
    }

    /**
     * Decode a hil_controls message into this class fields
     *
     * @param payload The message to decode
     */
    @Override
    public void unpack(MAVLinkPayload payload) {
        payload.resetIndex();
        
        this.time_usec = payload.getUnsignedLong();
        this.roll_ailerons = payload.getFloat();
        this.pitch_elevator = payload.getFloat();
        this.yaw_rudder = payload.getFloat();
        this.throttle = payload.getFloat();
        this.aux1 = payload.getFloat();
        this.aux2 = payload.getFloat();
        this.aux3 = payload.getFloat();
        this.aux4 = payload.getFloat();
        this.mode = payload.getUnsignedByte();
        this.nav_mode = payload.getUnsignedByte();
        
        if (isMavlink2) {
            
        }
    }

    /**
     * Constructor for a new message, just initializes the msgid
     */
    public msg_hil_controls() {
        this.msgid = MAVLINK_MSG_ID_HIL_CONTROLS;
    }
    
    /**
     * Constructor for a new message, initializes msgid and all payload variables
     */
    public msg_hil_controls( long time_usec, float roll_ailerons, float pitch_elevator, float yaw_rudder, float throttle, float aux1, float aux2, float aux3, float aux4, short mode, short nav_mode) {
        this.msgid = MAVLINK_MSG_ID_HIL_CONTROLS;

        this.time_usec = time_usec;
        this.roll_ailerons = roll_ailerons;
        this.pitch_elevator = pitch_elevator;
        this.yaw_rudder = yaw_rudder;
        this.throttle = throttle;
        this.aux1 = aux1;
        this.aux2 = aux2;
        this.aux3 = aux3;
        this.aux4 = aux4;
        this.mode = mode;
        this.nav_mode = nav_mode;
        
    }
    
    /**
     * Constructor for a new message, initializes everything
     */
    public msg_hil_controls( long time_usec, float roll_ailerons, float pitch_elevator, float yaw_rudder, float throttle, float aux1, float aux2, float aux3, float aux4, short mode, short nav_mode, int sysid, int compid, boolean isMavlink2) {
        this.msgid = MAVLINK_MSG_ID_HIL_CONTROLS;
        this.sysid = sysid;
        this.compid = compid;
        this.isMavlink2 = isMavlink2;

        this.time_usec = time_usec;
        this.roll_ailerons = roll_ailerons;
        this.pitch_elevator = pitch_elevator;
        this.yaw_rudder = yaw_rudder;
        this.throttle = throttle;
        this.aux1 = aux1;
        this.aux2 = aux2;
        this.aux3 = aux3;
        this.aux4 = aux4;
        this.mode = mode;
        this.nav_mode = nav_mode;
        
    }

    /**
     * Constructor for a new message, initializes the message with the payload
     * from a mavlink packet
     *
     */
    public msg_hil_controls(MAVLinkPacket mavLinkPacket) {
        this.msgid = MAVLINK_MSG_ID_HIL_CONTROLS;
        
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
        return "MAVLINK_MSG_ID_HIL_CONTROLS - sysid:"+sysid+" compid:"+compid+" time_usec:"+time_usec+" roll_ailerons:"+roll_ailerons+" pitch_elevator:"+pitch_elevator+" yaw_rudder:"+yaw_rudder+" throttle:"+throttle+" aux1:"+aux1+" aux2:"+aux2+" aux3:"+aux3+" aux4:"+aux4+" mode:"+mode+" nav_mode:"+nav_mode+"";
    }
    
    /**
     * Returns a human-readable string of the name of the message
     */
    @Override
    public String name() {
        return "MAVLINK_MSG_ID_HIL_CONTROLS";
    }
}
        