/* AUTO-GENERATED FILE.  DO NOT MODIFY.
 *
 * This class was automatically generated by the
 * java mavlink generator tool. It should not be modified by hand.
 */

// MESSAGE GROUP_END PACKING
package com.mavlink.development;
import com.mavlink.MAVLinkPacket;
import com.mavlink.Messages.MAVLinkMessage;
import com.mavlink.Messages.MAVLinkPayload;
        
/**
 * Emitted during mission execution when control reaches MAV_CMD_GROUP_END.
 */
public class msg_group_end extends MAVLinkMessage {

    public static final int MAVLINK_MSG_ID_GROUP_END = 415;
    public static final int MAVLINK_MSG_LENGTH = 16;
    private static final long serialVersionUID = MAVLINK_MSG_ID_GROUP_END;

      
    /**
     * Timestamp (UNIX Epoch time or time since system boot).
        The receiving end can infer timestamp format (since 1.1.1970 or since system boot) by checking for the magnitude of the number.
     */
    public long time_usec;
      
    /**
     * Mission-unique group id (from MAV_CMD_GROUP_END).
     */
    public long group_id;
      
    /**
     * CRC32 checksum of current plan for MAV_MISSION_TYPE_ALL. As defined in MISSION_CHECKSUM message.
     */
    public long mission_checksum;
    

    /**
     * Generates the payload for a mavlink message for a message of this type
     * @return
     */
    @Override
    public MAVLinkPacket pack() {
        MAVLinkPacket packet = new MAVLinkPacket(MAVLINK_MSG_LENGTH,isMavlink2);
        packet.sysid = sysid;
        packet.compid = compid;
        packet.msgid = MAVLINK_MSG_ID_GROUP_END;
        
        packet.payload.putUnsignedLong(time_usec);
        packet.payload.putUnsignedInt(group_id);
        packet.payload.putUnsignedInt(mission_checksum);
        
        if (isMavlink2) {
            
        }
        return packet;
    }

    /**
     * Decode a group_end message into this class fields
     *
     * @param payload The message to decode
     */
    @Override
    public void unpack(MAVLinkPayload payload) {
        payload.resetIndex();
        
        this.time_usec = payload.getUnsignedLong();
        this.group_id = payload.getUnsignedInt();
        this.mission_checksum = payload.getUnsignedInt();
        
        if (isMavlink2) {
            
        }
    }

    /**
     * Constructor for a new message, just initializes the msgid
     */
    public msg_group_end() {
        this.msgid = MAVLINK_MSG_ID_GROUP_END;
    }
    
    /**
     * Constructor for a new message, initializes msgid and all payload variables
     */
    public msg_group_end( long time_usec, long group_id, long mission_checksum) {
        this.msgid = MAVLINK_MSG_ID_GROUP_END;

        this.time_usec = time_usec;
        this.group_id = group_id;
        this.mission_checksum = mission_checksum;
        
    }
    
    /**
     * Constructor for a new message, initializes everything
     */
    public msg_group_end( long time_usec, long group_id, long mission_checksum, int sysid, int compid, boolean isMavlink2) {
        this.msgid = MAVLINK_MSG_ID_GROUP_END;
        this.sysid = sysid;
        this.compid = compid;
        this.isMavlink2 = isMavlink2;

        this.time_usec = time_usec;
        this.group_id = group_id;
        this.mission_checksum = mission_checksum;
        
    }

    /**
     * Constructor for a new message, initializes the message with the payload
     * from a mavlink packet
     *
     */
    public msg_group_end(MAVLinkPacket mavLinkPacket) {
        this.msgid = MAVLINK_MSG_ID_GROUP_END;
        
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
        return "MAVLINK_MSG_ID_GROUP_END - sysid:"+sysid+" compid:"+compid+" time_usec:"+time_usec+" group_id:"+group_id+" mission_checksum:"+mission_checksum+"";
    }
    
    /**
     * Returns a human-readable string of the name of the message
     */
    @Override
    public String name() {
        return "MAVLINK_MSG_ID_GROUP_END";
    }
}
        