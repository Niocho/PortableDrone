/* AUTO-GENERATED FILE.  DO NOT MODIFY.
 *
 * This class was automatically generated by the
 * java mavlink generator tool. It should not be modified by hand.
 */

// MESSAGE COMPONENT_PREARM_STATUS PACKING
package com.mavlink.storm32;
import com.mavlink.MAVLinkPacket;
import com.mavlink.Messages.MAVLinkMessage;
import com.mavlink.Messages.MAVLinkPayload;
        
/**
 * Message reporting the status of the prearm checks. The flags are component specific.
 */
public class msg_component_prearm_status extends MAVLinkMessage {

    public static final int MAVLINK_MSG_ID_COMPONENT_PREARM_STATUS = 60025;
    public static final int MAVLINK_MSG_LENGTH = 10;
    private static final long serialVersionUID = MAVLINK_MSG_ID_COMPONENT_PREARM_STATUS;

      
    /**
     * Currently enabled prearm checks. 0 means no checks are being performed, UINT32_MAX means not known.
     */
    public long enabled_flags;
      
    /**
     * Currently not passed prearm checks. 0 means all checks have been passed.
     */
    public long fail_flags;
      
    /**
     * System ID
     */
    public short target_system;
      
    /**
     * Component ID
     */
    public short target_component;
    

    /**
     * Generates the payload for a mavlink message for a message of this type
     * @return
     */
    @Override
    public MAVLinkPacket pack() {
        MAVLinkPacket packet = new MAVLinkPacket(MAVLINK_MSG_LENGTH,isMavlink2);
        packet.sysid = sysid;
        packet.compid = compid;
        packet.msgid = MAVLINK_MSG_ID_COMPONENT_PREARM_STATUS;
        
        packet.payload.putUnsignedInt(enabled_flags);
        packet.payload.putUnsignedInt(fail_flags);
        packet.payload.putUnsignedByte(target_system);
        packet.payload.putUnsignedByte(target_component);
        
        if (isMavlink2) {
            
        }
        return packet;
    }

    /**
     * Decode a component_prearm_status message into this class fields
     *
     * @param payload The message to decode
     */
    @Override
    public void unpack(MAVLinkPayload payload) {
        payload.resetIndex();
        
        this.enabled_flags = payload.getUnsignedInt();
        this.fail_flags = payload.getUnsignedInt();
        this.target_system = payload.getUnsignedByte();
        this.target_component = payload.getUnsignedByte();
        
        if (isMavlink2) {
            
        }
    }

    /**
     * Constructor for a new message, just initializes the msgid
     */
    public msg_component_prearm_status() {
        this.msgid = MAVLINK_MSG_ID_COMPONENT_PREARM_STATUS;
    }
    
    /**
     * Constructor for a new message, initializes msgid and all payload variables
     */
    public msg_component_prearm_status( long enabled_flags, long fail_flags, short target_system, short target_component) {
        this.msgid = MAVLINK_MSG_ID_COMPONENT_PREARM_STATUS;

        this.enabled_flags = enabled_flags;
        this.fail_flags = fail_flags;
        this.target_system = target_system;
        this.target_component = target_component;
        
    }
    
    /**
     * Constructor for a new message, initializes everything
     */
    public msg_component_prearm_status( long enabled_flags, long fail_flags, short target_system, short target_component, int sysid, int compid, boolean isMavlink2) {
        this.msgid = MAVLINK_MSG_ID_COMPONENT_PREARM_STATUS;
        this.sysid = sysid;
        this.compid = compid;
        this.isMavlink2 = isMavlink2;

        this.enabled_flags = enabled_flags;
        this.fail_flags = fail_flags;
        this.target_system = target_system;
        this.target_component = target_component;
        
    }

    /**
     * Constructor for a new message, initializes the message with the payload
     * from a mavlink packet
     *
     */
    public msg_component_prearm_status(MAVLinkPacket mavLinkPacket) {
        this.msgid = MAVLINK_MSG_ID_COMPONENT_PREARM_STATUS;
        
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
        return "MAVLINK_MSG_ID_COMPONENT_PREARM_STATUS - sysid:"+sysid+" compid:"+compid+" enabled_flags:"+enabled_flags+" fail_flags:"+fail_flags+" target_system:"+target_system+" target_component:"+target_component+"";
    }
    
    /**
     * Returns a human-readable string of the name of the message
     */
    @Override
    public String name() {
        return "MAVLINK_MSG_ID_COMPONENT_PREARM_STATUS";
    }
}
        