/* AUTO-GENERATED FILE.  DO NOT MODIFY.
 *
 * This class was automatically generated by the
 * java mavlink generator tool. It should not be modified by hand.
 */

// MESSAGE GIMBAL_MANAGER_SET_MANUAL_CONTROL PACKING
package com.mavlink.common;
import com.mavlink.MAVLinkPacket;
import com.mavlink.Messages.MAVLinkMessage;
import com.mavlink.Messages.MAVLinkPayload;
        
/**
 * High level message to control a gimbal manually. The angles or angular rates are unitless; the actual rates will depend on internal gimbal manager settings/configuration (e.g. set by parameters). This message is to be sent to the gimbal manager (e.g. from a ground station). Angles and rates can be set to NaN according to use case.
 */
public class msg_gimbal_manager_set_manual_control extends MAVLinkMessage {

    public static final int MAVLINK_MSG_ID_GIMBAL_MANAGER_SET_MANUAL_CONTROL = 288;
    public static final int MAVLINK_MSG_LENGTH = 23;
    private static final long serialVersionUID = MAVLINK_MSG_ID_GIMBAL_MANAGER_SET_MANUAL_CONTROL;

      
    /**
     * High level gimbal manager flags.
     */
    public long flags;
      
    /**
     * Pitch angle unitless (-1..1, positive: up, negative: down, NaN to be ignored).
     */
    public float pitch;
      
    /**
     * Yaw angle unitless (-1..1, positive: to the right, negative: to the left, NaN to be ignored).
     */
    public float yaw;
      
    /**
     * Pitch angular rate unitless (-1..1, positive: up, negative: down, NaN to be ignored).
     */
    public float pitch_rate;
      
    /**
     * Yaw angular rate unitless (-1..1, positive: to the right, negative: to the left, NaN to be ignored).
     */
    public float yaw_rate;
      
    /**
     * System ID
     */
    public short target_system;
      
    /**
     * Component ID
     */
    public short target_component;
      
    /**
     * Component ID of gimbal device to address (or 1-6 for non-MAVLink gimbal), 0 for all gimbal device components. Send command multiple times for more than one gimbal (but not all gimbals).
     */
    public short gimbal_device_id;
    

    /**
     * Generates the payload for a mavlink message for a message of this type
     * @return
     */
    @Override
    public MAVLinkPacket pack() {
        MAVLinkPacket packet = new MAVLinkPacket(MAVLINK_MSG_LENGTH,isMavlink2);
        packet.sysid = sysid;
        packet.compid = compid;
        packet.msgid = MAVLINK_MSG_ID_GIMBAL_MANAGER_SET_MANUAL_CONTROL;
        
        packet.payload.putUnsignedInt(flags);
        packet.payload.putFloat(pitch);
        packet.payload.putFloat(yaw);
        packet.payload.putFloat(pitch_rate);
        packet.payload.putFloat(yaw_rate);
        packet.payload.putUnsignedByte(target_system);
        packet.payload.putUnsignedByte(target_component);
        packet.payload.putUnsignedByte(gimbal_device_id);
        
        if (isMavlink2) {
            
        }
        return packet;
    }

    /**
     * Decode a gimbal_manager_set_manual_control message into this class fields
     *
     * @param payload The message to decode
     */
    @Override
    public void unpack(MAVLinkPayload payload) {
        payload.resetIndex();
        
        this.flags = payload.getUnsignedInt();
        this.pitch = payload.getFloat();
        this.yaw = payload.getFloat();
        this.pitch_rate = payload.getFloat();
        this.yaw_rate = payload.getFloat();
        this.target_system = payload.getUnsignedByte();
        this.target_component = payload.getUnsignedByte();
        this.gimbal_device_id = payload.getUnsignedByte();
        
        if (isMavlink2) {
            
        }
    }

    /**
     * Constructor for a new message, just initializes the msgid
     */
    public msg_gimbal_manager_set_manual_control() {
        this.msgid = MAVLINK_MSG_ID_GIMBAL_MANAGER_SET_MANUAL_CONTROL;
    }
    
    /**
     * Constructor for a new message, initializes msgid and all payload variables
     */
    public msg_gimbal_manager_set_manual_control( long flags, float pitch, float yaw, float pitch_rate, float yaw_rate, short target_system, short target_component, short gimbal_device_id) {
        this.msgid = MAVLINK_MSG_ID_GIMBAL_MANAGER_SET_MANUAL_CONTROL;

        this.flags = flags;
        this.pitch = pitch;
        this.yaw = yaw;
        this.pitch_rate = pitch_rate;
        this.yaw_rate = yaw_rate;
        this.target_system = target_system;
        this.target_component = target_component;
        this.gimbal_device_id = gimbal_device_id;
        
    }
    
    /**
     * Constructor for a new message, initializes everything
     */
    public msg_gimbal_manager_set_manual_control( long flags, float pitch, float yaw, float pitch_rate, float yaw_rate, short target_system, short target_component, short gimbal_device_id, int sysid, int compid, boolean isMavlink2) {
        this.msgid = MAVLINK_MSG_ID_GIMBAL_MANAGER_SET_MANUAL_CONTROL;
        this.sysid = sysid;
        this.compid = compid;
        this.isMavlink2 = isMavlink2;

        this.flags = flags;
        this.pitch = pitch;
        this.yaw = yaw;
        this.pitch_rate = pitch_rate;
        this.yaw_rate = yaw_rate;
        this.target_system = target_system;
        this.target_component = target_component;
        this.gimbal_device_id = gimbal_device_id;
        
    }

    /**
     * Constructor for a new message, initializes the message with the payload
     * from a mavlink packet
     *
     */
    public msg_gimbal_manager_set_manual_control(MAVLinkPacket mavLinkPacket) {
        this.msgid = MAVLINK_MSG_ID_GIMBAL_MANAGER_SET_MANUAL_CONTROL;
        
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
        return "MAVLINK_MSG_ID_GIMBAL_MANAGER_SET_MANUAL_CONTROL - sysid:"+sysid+" compid:"+compid+" flags:"+flags+" pitch:"+pitch+" yaw:"+yaw+" pitch_rate:"+pitch_rate+" yaw_rate:"+yaw_rate+" target_system:"+target_system+" target_component:"+target_component+" gimbal_device_id:"+gimbal_device_id+"";
    }
    
    /**
     * Returns a human-readable string of the name of the message
     */
    @Override
    public String name() {
        return "MAVLINK_MSG_ID_GIMBAL_MANAGER_SET_MANUAL_CONTROL";
    }
}
        