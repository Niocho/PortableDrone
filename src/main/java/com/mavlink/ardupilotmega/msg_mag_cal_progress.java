/* AUTO-GENERATED FILE.  DO NOT MODIFY.
 *
 * This class was automatically generated by the
 * java mavlink generator tool. It should not be modified by hand.
 */

// MESSAGE MAG_CAL_PROGRESS PACKING
package com.mavlink.ardupilotmega;
import com.mavlink.MAVLinkPacket;
import com.mavlink.Messages.MAVLinkMessage;
import com.mavlink.Messages.MAVLinkPayload;
        
/**
 * Reports progress of compass calibration.
 */
public class msg_mag_cal_progress extends MAVLinkMessage {

    public static final int MAVLINK_MSG_ID_MAG_CAL_PROGRESS = 191;
    public static final int MAVLINK_MSG_LENGTH = 27;
    private static final long serialVersionUID = MAVLINK_MSG_ID_MAG_CAL_PROGRESS;

      
    /**
     * Body frame direction vector for display.
     */
    public float direction_x;
      
    /**
     * Body frame direction vector for display.
     */
    public float direction_y;
      
    /**
     * Body frame direction vector for display.
     */
    public float direction_z;
      
    /**
     * Compass being calibrated.
     */
    public short compass_id;
      
    /**
     * Bitmask of compasses being calibrated.
     */
    public short cal_mask;
      
    /**
     * Calibration Status.
     */
    public short cal_status;
      
    /**
     * Attempt number.
     */
    public short attempt;
      
    /**
     * Completion percentage.
     */
    public short completion_pct;
      
    /**
     * Bitmask of sphere sections (see http://en.wikipedia.org/wiki/Geodesic_grid).
     */
    public short completion_mask[] = new short[10];
    

    /**
     * Generates the payload for a mavlink message for a message of this type
     * @return
     */
    @Override
    public MAVLinkPacket pack() {
        MAVLinkPacket packet = new MAVLinkPacket(MAVLINK_MSG_LENGTH,isMavlink2);
        packet.sysid = sysid;
        packet.compid = compid;
        packet.msgid = MAVLINK_MSG_ID_MAG_CAL_PROGRESS;
        
        packet.payload.putFloat(direction_x);
        packet.payload.putFloat(direction_y);
        packet.payload.putFloat(direction_z);
        packet.payload.putUnsignedByte(compass_id);
        packet.payload.putUnsignedByte(cal_mask);
        packet.payload.putUnsignedByte(cal_status);
        packet.payload.putUnsignedByte(attempt);
        packet.payload.putUnsignedByte(completion_pct);
        
        for (int i = 0; i < completion_mask.length; i++) {
            packet.payload.putUnsignedByte(completion_mask[i]);
        }
                    
        
        if (isMavlink2) {
            
        }
        return packet;
    }

    /**
     * Decode a mag_cal_progress message into this class fields
     *
     * @param payload The message to decode
     */
    @Override
    public void unpack(MAVLinkPayload payload) {
        payload.resetIndex();
        
        this.direction_x = payload.getFloat();
        this.direction_y = payload.getFloat();
        this.direction_z = payload.getFloat();
        this.compass_id = payload.getUnsignedByte();
        this.cal_mask = payload.getUnsignedByte();
        this.cal_status = payload.getUnsignedByte();
        this.attempt = payload.getUnsignedByte();
        this.completion_pct = payload.getUnsignedByte();
         
        for (int i = 0; i < this.completion_mask.length; i++) {
            this.completion_mask[i] = payload.getUnsignedByte();
        }
                
        
        if (isMavlink2) {
            
        }
    }

    /**
     * Constructor for a new message, just initializes the msgid
     */
    public msg_mag_cal_progress() {
        this.msgid = MAVLINK_MSG_ID_MAG_CAL_PROGRESS;
    }
    
    /**
     * Constructor for a new message, initializes msgid and all payload variables
     */
    public msg_mag_cal_progress( float direction_x, float direction_y, float direction_z, short compass_id, short cal_mask, short cal_status, short attempt, short completion_pct, short[] completion_mask) {
        this.msgid = MAVLINK_MSG_ID_MAG_CAL_PROGRESS;

        this.direction_x = direction_x;
        this.direction_y = direction_y;
        this.direction_z = direction_z;
        this.compass_id = compass_id;
        this.cal_mask = cal_mask;
        this.cal_status = cal_status;
        this.attempt = attempt;
        this.completion_pct = completion_pct;
        this.completion_mask = completion_mask;
        
    }
    
    /**
     * Constructor for a new message, initializes everything
     */
    public msg_mag_cal_progress( float direction_x, float direction_y, float direction_z, short compass_id, short cal_mask, short cal_status, short attempt, short completion_pct, short[] completion_mask, int sysid, int compid, boolean isMavlink2) {
        this.msgid = MAVLINK_MSG_ID_MAG_CAL_PROGRESS;
        this.sysid = sysid;
        this.compid = compid;
        this.isMavlink2 = isMavlink2;

        this.direction_x = direction_x;
        this.direction_y = direction_y;
        this.direction_z = direction_z;
        this.compass_id = compass_id;
        this.cal_mask = cal_mask;
        this.cal_status = cal_status;
        this.attempt = attempt;
        this.completion_pct = completion_pct;
        this.completion_mask = completion_mask;
        
    }

    /**
     * Constructor for a new message, initializes the message with the payload
     * from a mavlink packet
     *
     */
    public msg_mag_cal_progress(MAVLinkPacket mavLinkPacket) {
        this.msgid = MAVLINK_MSG_ID_MAG_CAL_PROGRESS;
        
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
        return "MAVLINK_MSG_ID_MAG_CAL_PROGRESS - sysid:"+sysid+" compid:"+compid+" direction_x:"+direction_x+" direction_y:"+direction_y+" direction_z:"+direction_z+" compass_id:"+compass_id+" cal_mask:"+cal_mask+" cal_status:"+cal_status+" attempt:"+attempt+" completion_pct:"+completion_pct+" completion_mask:"+completion_mask+"";
    }
    
    /**
     * Returns a human-readable string of the name of the message
     */
    @Override
    public String name() {
        return "MAVLINK_MSG_ID_MAG_CAL_PROGRESS";
    }
}
        