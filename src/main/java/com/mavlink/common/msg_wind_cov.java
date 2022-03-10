/* AUTO-GENERATED FILE.  DO NOT MODIFY.
 *
 * This class was automatically generated by the
 * java mavlink generator tool. It should not be modified by hand.
 */

// MESSAGE WIND_COV PACKING
package com.mavlink.common;
import com.mavlink.MAVLinkPacket;
import com.mavlink.Messages.MAVLinkMessage;
import com.mavlink.Messages.MAVLinkPayload;
        
/**
 * Wind covariance estimate from vehicle.
 */
public class msg_wind_cov extends MAVLinkMessage {

    public static final int MAVLINK_MSG_ID_WIND_COV = 231;
    public static final int MAVLINK_MSG_LENGTH = 40;
    private static final long serialVersionUID = MAVLINK_MSG_ID_WIND_COV;

      
    /**
     * Timestamp (UNIX Epoch time or time since system boot). The receiving end can infer timestamp format (since 1.1.1970 or since system boot) by checking for the magnitude of the number.
     */
    public long time_usec;
      
    /**
     * Wind in X (NED) direction
     */
    public float wind_x;
      
    /**
     * Wind in Y (NED) direction
     */
    public float wind_y;
      
    /**
     * Wind in Z (NED) direction
     */
    public float wind_z;
      
    /**
     * Variability of the wind in XY. RMS of a 1 Hz lowpassed wind estimate.
     */
    public float var_horiz;
      
    /**
     * Variability of the wind in Z. RMS of a 1 Hz lowpassed wind estimate.
     */
    public float var_vert;
      
    /**
     * Altitude (MSL) that this measurement was taken at
     */
    public float wind_alt;
      
    /**
     * Horizontal speed 1-STD accuracy
     */
    public float horiz_accuracy;
      
    /**
     * Vertical speed 1-STD accuracy
     */
    public float vert_accuracy;
    

    /**
     * Generates the payload for a mavlink message for a message of this type
     * @return
     */
    @Override
    public MAVLinkPacket pack() {
        MAVLinkPacket packet = new MAVLinkPacket(MAVLINK_MSG_LENGTH,isMavlink2);
        packet.sysid = sysid;
        packet.compid = compid;
        packet.msgid = MAVLINK_MSG_ID_WIND_COV;
        
        packet.payload.putUnsignedLong(time_usec);
        packet.payload.putFloat(wind_x);
        packet.payload.putFloat(wind_y);
        packet.payload.putFloat(wind_z);
        packet.payload.putFloat(var_horiz);
        packet.payload.putFloat(var_vert);
        packet.payload.putFloat(wind_alt);
        packet.payload.putFloat(horiz_accuracy);
        packet.payload.putFloat(vert_accuracy);
        
        if (isMavlink2) {
            
        }
        return packet;
    }

    /**
     * Decode a wind_cov message into this class fields
     *
     * @param payload The message to decode
     */
    @Override
    public void unpack(MAVLinkPayload payload) {
        payload.resetIndex();
        
        this.time_usec = payload.getUnsignedLong();
        this.wind_x = payload.getFloat();
        this.wind_y = payload.getFloat();
        this.wind_z = payload.getFloat();
        this.var_horiz = payload.getFloat();
        this.var_vert = payload.getFloat();
        this.wind_alt = payload.getFloat();
        this.horiz_accuracy = payload.getFloat();
        this.vert_accuracy = payload.getFloat();
        
        if (isMavlink2) {
            
        }
    }

    /**
     * Constructor for a new message, just initializes the msgid
     */
    public msg_wind_cov() {
        this.msgid = MAVLINK_MSG_ID_WIND_COV;
    }
    
    /**
     * Constructor for a new message, initializes msgid and all payload variables
     */
    public msg_wind_cov( long time_usec, float wind_x, float wind_y, float wind_z, float var_horiz, float var_vert, float wind_alt, float horiz_accuracy, float vert_accuracy) {
        this.msgid = MAVLINK_MSG_ID_WIND_COV;

        this.time_usec = time_usec;
        this.wind_x = wind_x;
        this.wind_y = wind_y;
        this.wind_z = wind_z;
        this.var_horiz = var_horiz;
        this.var_vert = var_vert;
        this.wind_alt = wind_alt;
        this.horiz_accuracy = horiz_accuracy;
        this.vert_accuracy = vert_accuracy;
        
    }
    
    /**
     * Constructor for a new message, initializes everything
     */
    public msg_wind_cov( long time_usec, float wind_x, float wind_y, float wind_z, float var_horiz, float var_vert, float wind_alt, float horiz_accuracy, float vert_accuracy, int sysid, int compid, boolean isMavlink2) {
        this.msgid = MAVLINK_MSG_ID_WIND_COV;
        this.sysid = sysid;
        this.compid = compid;
        this.isMavlink2 = isMavlink2;

        this.time_usec = time_usec;
        this.wind_x = wind_x;
        this.wind_y = wind_y;
        this.wind_z = wind_z;
        this.var_horiz = var_horiz;
        this.var_vert = var_vert;
        this.wind_alt = wind_alt;
        this.horiz_accuracy = horiz_accuracy;
        this.vert_accuracy = vert_accuracy;
        
    }

    /**
     * Constructor for a new message, initializes the message with the payload
     * from a mavlink packet
     *
     */
    public msg_wind_cov(MAVLinkPacket mavLinkPacket) {
        this.msgid = MAVLINK_MSG_ID_WIND_COV;
        
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
        return "MAVLINK_MSG_ID_WIND_COV - sysid:"+sysid+" compid:"+compid+" time_usec:"+time_usec+" wind_x:"+wind_x+" wind_y:"+wind_y+" wind_z:"+wind_z+" var_horiz:"+var_horiz+" var_vert:"+var_vert+" wind_alt:"+wind_alt+" horiz_accuracy:"+horiz_accuracy+" vert_accuracy:"+vert_accuracy+"";
    }
    
    /**
     * Returns a human-readable string of the name of the message
     */
    @Override
    public String name() {
        return "MAVLINK_MSG_ID_WIND_COV";
    }
}
        