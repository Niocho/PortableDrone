/* AUTO-GENERATED FILE.  DO NOT MODIFY.
 *
 * This class was automatically generated by the
 * java mavlink generator tool. It should not be modified by hand.
 */

// MESSAGE SENSOR_AIRFLOW_ANGLES PACKING
package com.mavlink.ASLUAV;
import com.mavlink.MAVLinkPacket;
import com.mavlink.Messages.MAVLinkMessage;
import com.mavlink.Messages.MAVLinkPayload;
        
/**
 * Calibrated airflow angle measurements
 */
public class msg_sensor_airflow_angles extends MAVLinkMessage {

    public static final int MAVLINK_MSG_ID_SENSOR_AIRFLOW_ANGLES = 8016;
    public static final int MAVLINK_MSG_LENGTH = 18;
    private static final long serialVersionUID = MAVLINK_MSG_ID_SENSOR_AIRFLOW_ANGLES;

      
    /**
     * Timestamp
     */
    public long timestamp;
      
    /**
     * Angle of attack
     */
    public float angleofattack;
      
    /**
     * Sideslip angle
     */
    public float sideslip;
      
    /**
     * Angle of attack measurement valid
     */
    public short angleofattack_valid;
      
    /**
     * Sideslip angle measurement valid
     */
    public short sideslip_valid;
    

    /**
     * Generates the payload for a mavlink message for a message of this type
     * @return
     */
    @Override
    public MAVLinkPacket pack() {
        MAVLinkPacket packet = new MAVLinkPacket(MAVLINK_MSG_LENGTH,isMavlink2);
        packet.sysid = sysid;
        packet.compid = compid;
        packet.msgid = MAVLINK_MSG_ID_SENSOR_AIRFLOW_ANGLES;
        
        packet.payload.putUnsignedLong(timestamp);
        packet.payload.putFloat(angleofattack);
        packet.payload.putFloat(sideslip);
        packet.payload.putUnsignedByte(angleofattack_valid);
        packet.payload.putUnsignedByte(sideslip_valid);
        
        if (isMavlink2) {
            
        }
        return packet;
    }

    /**
     * Decode a sensor_airflow_angles message into this class fields
     *
     * @param payload The message to decode
     */
    @Override
    public void unpack(MAVLinkPayload payload) {
        payload.resetIndex();
        
        this.timestamp = payload.getUnsignedLong();
        this.angleofattack = payload.getFloat();
        this.sideslip = payload.getFloat();
        this.angleofattack_valid = payload.getUnsignedByte();
        this.sideslip_valid = payload.getUnsignedByte();
        
        if (isMavlink2) {
            
        }
    }

    /**
     * Constructor for a new message, just initializes the msgid
     */
    public msg_sensor_airflow_angles() {
        this.msgid = MAVLINK_MSG_ID_SENSOR_AIRFLOW_ANGLES;
    }
    
    /**
     * Constructor for a new message, initializes msgid and all payload variables
     */
    public msg_sensor_airflow_angles( long timestamp, float angleofattack, float sideslip, short angleofattack_valid, short sideslip_valid) {
        this.msgid = MAVLINK_MSG_ID_SENSOR_AIRFLOW_ANGLES;

        this.timestamp = timestamp;
        this.angleofattack = angleofattack;
        this.sideslip = sideslip;
        this.angleofattack_valid = angleofattack_valid;
        this.sideslip_valid = sideslip_valid;
        
    }
    
    /**
     * Constructor for a new message, initializes everything
     */
    public msg_sensor_airflow_angles( long timestamp, float angleofattack, float sideslip, short angleofattack_valid, short sideslip_valid, int sysid, int compid, boolean isMavlink2) {
        this.msgid = MAVLINK_MSG_ID_SENSOR_AIRFLOW_ANGLES;
        this.sysid = sysid;
        this.compid = compid;
        this.isMavlink2 = isMavlink2;

        this.timestamp = timestamp;
        this.angleofattack = angleofattack;
        this.sideslip = sideslip;
        this.angleofattack_valid = angleofattack_valid;
        this.sideslip_valid = sideslip_valid;
        
    }

    /**
     * Constructor for a new message, initializes the message with the payload
     * from a mavlink packet
     *
     */
    public msg_sensor_airflow_angles(MAVLinkPacket mavLinkPacket) {
        this.msgid = MAVLINK_MSG_ID_SENSOR_AIRFLOW_ANGLES;
        
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
        return "MAVLINK_MSG_ID_SENSOR_AIRFLOW_ANGLES - sysid:"+sysid+" compid:"+compid+" timestamp:"+timestamp+" angleofattack:"+angleofattack+" sideslip:"+sideslip+" angleofattack_valid:"+angleofattack_valid+" sideslip_valid:"+sideslip_valid+"";
    }
    
    /**
     * Returns a human-readable string of the name of the message
     */
    @Override
    public String name() {
        return "MAVLINK_MSG_ID_SENSOR_AIRFLOW_ANGLES";
    }
}
        