/* AUTO-GENERATED FILE.  DO NOT MODIFY.
 *
 * This class was automatically generated by the
 * java mavlink generator tool. It should not be modified by hand.
 */

// MESSAGE REMOTE_LOG_BLOCK_STATUS PACKING
package com.mavlink.ardupilotmega;
import com.mavlink.MAVLinkPacket;
import com.mavlink.Messages.MAVLinkMessage;
import com.mavlink.Messages.MAVLinkPayload;
        
/**
 * Send Status of each log block that autopilot board might have sent.
 */
public class msg_remote_log_block_status extends MAVLinkMessage {

    public static final int MAVLINK_MSG_ID_REMOTE_LOG_BLOCK_STATUS = 185;
    public static final int MAVLINK_MSG_LENGTH = 7;
    private static final long serialVersionUID = MAVLINK_MSG_ID_REMOTE_LOG_BLOCK_STATUS;

      
    /**
     * Log data block sequence number.
     */
    public long seqno;
      
    /**
     * System ID.
     */
    public short target_system;
      
    /**
     * Component ID.
     */
    public short target_component;
      
    /**
     * Log data block status.
     */
    public short status;
    

    /**
     * Generates the payload for a mavlink message for a message of this type
     * @return
     */
    @Override
    public MAVLinkPacket pack() {
        MAVLinkPacket packet = new MAVLinkPacket(MAVLINK_MSG_LENGTH,isMavlink2);
        packet.sysid = sysid;
        packet.compid = compid;
        packet.msgid = MAVLINK_MSG_ID_REMOTE_LOG_BLOCK_STATUS;
        
        packet.payload.putUnsignedInt(seqno);
        packet.payload.putUnsignedByte(target_system);
        packet.payload.putUnsignedByte(target_component);
        packet.payload.putUnsignedByte(status);
        
        if (isMavlink2) {
            
        }
        return packet;
    }

    /**
     * Decode a remote_log_block_status message into this class fields
     *
     * @param payload The message to decode
     */
    @Override
    public void unpack(MAVLinkPayload payload) {
        payload.resetIndex();
        
        this.seqno = payload.getUnsignedInt();
        this.target_system = payload.getUnsignedByte();
        this.target_component = payload.getUnsignedByte();
        this.status = payload.getUnsignedByte();
        
        if (isMavlink2) {
            
        }
    }

    /**
     * Constructor for a new message, just initializes the msgid
     */
    public msg_remote_log_block_status() {
        this.msgid = MAVLINK_MSG_ID_REMOTE_LOG_BLOCK_STATUS;
    }
    
    /**
     * Constructor for a new message, initializes msgid and all payload variables
     */
    public msg_remote_log_block_status( long seqno, short target_system, short target_component, short status) {
        this.msgid = MAVLINK_MSG_ID_REMOTE_LOG_BLOCK_STATUS;

        this.seqno = seqno;
        this.target_system = target_system;
        this.target_component = target_component;
        this.status = status;
        
    }
    
    /**
     * Constructor for a new message, initializes everything
     */
    public msg_remote_log_block_status( long seqno, short target_system, short target_component, short status, int sysid, int compid, boolean isMavlink2) {
        this.msgid = MAVLINK_MSG_ID_REMOTE_LOG_BLOCK_STATUS;
        this.sysid = sysid;
        this.compid = compid;
        this.isMavlink2 = isMavlink2;

        this.seqno = seqno;
        this.target_system = target_system;
        this.target_component = target_component;
        this.status = status;
        
    }

    /**
     * Constructor for a new message, initializes the message with the payload
     * from a mavlink packet
     *
     */
    public msg_remote_log_block_status(MAVLinkPacket mavLinkPacket) {
        this.msgid = MAVLINK_MSG_ID_REMOTE_LOG_BLOCK_STATUS;
        
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
        return "MAVLINK_MSG_ID_REMOTE_LOG_BLOCK_STATUS - sysid:"+sysid+" compid:"+compid+" seqno:"+seqno+" target_system:"+target_system+" target_component:"+target_component+" status:"+status+"";
    }
    
    /**
     * Returns a human-readable string of the name of the message
     */
    @Override
    public String name() {
        return "MAVLINK_MSG_ID_REMOTE_LOG_BLOCK_STATUS";
    }
}
        