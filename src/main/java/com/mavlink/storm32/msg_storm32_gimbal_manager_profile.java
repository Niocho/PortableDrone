/* AUTO-GENERATED FILE.  DO NOT MODIFY.
 *
 * This class was automatically generated by the
 * java mavlink generator tool. It should not be modified by hand.
 */

// MESSAGE STORM32_GIMBAL_MANAGER_PROFILE PACKING
package com.mavlink.storm32;
import com.mavlink.MAVLinkPacket;
import com.mavlink.Messages.MAVLinkMessage;
import com.mavlink.Messages.MAVLinkPayload;
        
/**
 * Message to set a gimbal manager profile. A gimbal device is never to react to this command. The selected profile is reported in the STORM32_GIMBAL_MANAGER_STATUS message.
 */
public class msg_storm32_gimbal_manager_profile extends MAVLinkMessage {

    public static final int MAVLINK_MSG_ID_STORM32_GIMBAL_MANAGER_PROFILE = 60015;
    public static final int MAVLINK_MSG_LENGTH = 22;
    private static final long serialVersionUID = MAVLINK_MSG_ID_STORM32_GIMBAL_MANAGER_PROFILE;

      
    /**
     * System ID
     */
    public short target_system;
      
    /**
     * Component ID
     */
    public short target_component;
      
    /**
     * Gimbal ID of the gimbal manager to address (component ID or 1-6 for non-MAVLink gimbal, 0 for all gimbals, send command multiple times for more than one but not all gimbals).
     */
    public short gimbal_id;
      
    /**
     * Profile to be applied (0 = default).
     */
    public short profile;
      
    /**
     * Priorities for custom profile.
     */
    public short priorities[] = new short[8];
      
    /**
     * Profile flags for custom profile (0 = default).
     */
    public short profile_flags;
      
    /**
     * Rc timeouts for custom profile (0 = infinite, in uints of 100 ms).
     */
    public short rc_timeout;
      
    /**
     * Timeouts for custom profile (0 = infinite, in uints of 100 ms).
     */
    public short timeouts[] = new short[8];
    

    /**
     * Generates the payload for a mavlink message for a message of this type
     * @return
     */
    @Override
    public MAVLinkPacket pack() {
        MAVLinkPacket packet = new MAVLinkPacket(MAVLINK_MSG_LENGTH,isMavlink2);
        packet.sysid = sysid;
        packet.compid = compid;
        packet.msgid = MAVLINK_MSG_ID_STORM32_GIMBAL_MANAGER_PROFILE;
        
        packet.payload.putUnsignedByte(target_system);
        packet.payload.putUnsignedByte(target_component);
        packet.payload.putUnsignedByte(gimbal_id);
        packet.payload.putUnsignedByte(profile);
        
        for (int i = 0; i < priorities.length; i++) {
            packet.payload.putUnsignedByte(priorities[i]);
        }
                    
        packet.payload.putUnsignedByte(profile_flags);
        packet.payload.putUnsignedByte(rc_timeout);
        
        for (int i = 0; i < timeouts.length; i++) {
            packet.payload.putUnsignedByte(timeouts[i]);
        }
                    
        
        if (isMavlink2) {
            
        }
        return packet;
    }

    /**
     * Decode a storm32_gimbal_manager_profile message into this class fields
     *
     * @param payload The message to decode
     */
    @Override
    public void unpack(MAVLinkPayload payload) {
        payload.resetIndex();
        
        this.target_system = payload.getUnsignedByte();
        this.target_component = payload.getUnsignedByte();
        this.gimbal_id = payload.getUnsignedByte();
        this.profile = payload.getUnsignedByte();
         
        for (int i = 0; i < this.priorities.length; i++) {
            this.priorities[i] = payload.getUnsignedByte();
        }
                
        this.profile_flags = payload.getUnsignedByte();
        this.rc_timeout = payload.getUnsignedByte();
         
        for (int i = 0; i < this.timeouts.length; i++) {
            this.timeouts[i] = payload.getUnsignedByte();
        }
                
        
        if (isMavlink2) {
            
        }
    }

    /**
     * Constructor for a new message, just initializes the msgid
     */
    public msg_storm32_gimbal_manager_profile() {
        this.msgid = MAVLINK_MSG_ID_STORM32_GIMBAL_MANAGER_PROFILE;
    }
    
    /**
     * Constructor for a new message, initializes msgid and all payload variables
     */
    public msg_storm32_gimbal_manager_profile( short target_system, short target_component, short gimbal_id, short profile, short[] priorities, short profile_flags, short rc_timeout, short[] timeouts) {
        this.msgid = MAVLINK_MSG_ID_STORM32_GIMBAL_MANAGER_PROFILE;

        this.target_system = target_system;
        this.target_component = target_component;
        this.gimbal_id = gimbal_id;
        this.profile = profile;
        this.priorities = priorities;
        this.profile_flags = profile_flags;
        this.rc_timeout = rc_timeout;
        this.timeouts = timeouts;
        
    }
    
    /**
     * Constructor for a new message, initializes everything
     */
    public msg_storm32_gimbal_manager_profile( short target_system, short target_component, short gimbal_id, short profile, short[] priorities, short profile_flags, short rc_timeout, short[] timeouts, int sysid, int compid, boolean isMavlink2) {
        this.msgid = MAVLINK_MSG_ID_STORM32_GIMBAL_MANAGER_PROFILE;
        this.sysid = sysid;
        this.compid = compid;
        this.isMavlink2 = isMavlink2;

        this.target_system = target_system;
        this.target_component = target_component;
        this.gimbal_id = gimbal_id;
        this.profile = profile;
        this.priorities = priorities;
        this.profile_flags = profile_flags;
        this.rc_timeout = rc_timeout;
        this.timeouts = timeouts;
        
    }

    /**
     * Constructor for a new message, initializes the message with the payload
     * from a mavlink packet
     *
     */
    public msg_storm32_gimbal_manager_profile(MAVLinkPacket mavLinkPacket) {
        this.msgid = MAVLINK_MSG_ID_STORM32_GIMBAL_MANAGER_PROFILE;
        
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
        return "MAVLINK_MSG_ID_STORM32_GIMBAL_MANAGER_PROFILE - sysid:"+sysid+" compid:"+compid+" target_system:"+target_system+" target_component:"+target_component+" gimbal_id:"+gimbal_id+" profile:"+profile+" priorities:"+priorities+" profile_flags:"+profile_flags+" rc_timeout:"+rc_timeout+" timeouts:"+timeouts+"";
    }
    
    /**
     * Returns a human-readable string of the name of the message
     */
    @Override
    public String name() {
        return "MAVLINK_MSG_ID_STORM32_GIMBAL_MANAGER_PROFILE";
    }
}
        