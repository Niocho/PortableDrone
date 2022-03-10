/* AUTO-GENERATED FILE.  DO NOT MODIFY.
 *
 * This class was automatically generated by the
 * java mavlink generator tool. It should not be modified by hand.
 */

// MESSAGE FOLLOW_TARGET PACKING
package com.mavlink.common;
import com.mavlink.MAVLinkPacket;
import com.mavlink.Messages.MAVLinkMessage;
import com.mavlink.Messages.MAVLinkPayload;
        
/**
 * Current motion information from a designated system
 */
public class msg_follow_target extends MAVLinkMessage {

    public static final int MAVLINK_MSG_ID_FOLLOW_TARGET = 144;
    public static final int MAVLINK_MSG_LENGTH = 93;
    private static final long serialVersionUID = MAVLINK_MSG_ID_FOLLOW_TARGET;

      
    /**
     * Timestamp (time since system boot).
     */
    public long timestamp;
      
    /**
     * button states or switches of a tracker device
     */
    public long custom_state;
      
    /**
     * Latitude (WGS84)
     */
    public int lat;
      
    /**
     * Longitude (WGS84)
     */
    public int lon;
      
    /**
     * Altitude (MSL)
     */
    public float alt;
      
    /**
     * target velocity (0,0,0) for unknown
     */
    public float vel[] = new float[3];
      
    /**
     * linear target acceleration (0,0,0) for unknown
     */
    public float acc[] = new float[3];
      
    /**
     * (0 0 0 0 for unknown)
     */
    public float attitude_q[] = new float[4];
      
    /**
     * (0 0 0 for unknown)
     */
    public float rates[] = new float[3];
      
    /**
     * eph epv
     */
    public float position_cov[] = new float[3];
      
    /**
     * bit positions for tracker reporting capabilities (POS = 0, VEL = 1, ACCEL = 2, ATT + RATES = 3)
     */
    public short est_capabilities;
    

    /**
     * Generates the payload for a mavlink message for a message of this type
     * @return
     */
    @Override
    public MAVLinkPacket pack() {
        MAVLinkPacket packet = new MAVLinkPacket(MAVLINK_MSG_LENGTH,isMavlink2);
        packet.sysid = sysid;
        packet.compid = compid;
        packet.msgid = MAVLINK_MSG_ID_FOLLOW_TARGET;
        
        packet.payload.putUnsignedLong(timestamp);
        packet.payload.putUnsignedLong(custom_state);
        packet.payload.putInt(lat);
        packet.payload.putInt(lon);
        packet.payload.putFloat(alt);
        
        for (int i = 0; i < vel.length; i++) {
            packet.payload.putFloat(vel[i]);
        }
                    
        
        for (int i = 0; i < acc.length; i++) {
            packet.payload.putFloat(acc[i]);
        }
                    
        
        for (int i = 0; i < attitude_q.length; i++) {
            packet.payload.putFloat(attitude_q[i]);
        }
                    
        
        for (int i = 0; i < rates.length; i++) {
            packet.payload.putFloat(rates[i]);
        }
                    
        
        for (int i = 0; i < position_cov.length; i++) {
            packet.payload.putFloat(position_cov[i]);
        }
                    
        packet.payload.putUnsignedByte(est_capabilities);
        
        if (isMavlink2) {
            
        }
        return packet;
    }

    /**
     * Decode a follow_target message into this class fields
     *
     * @param payload The message to decode
     */
    @Override
    public void unpack(MAVLinkPayload payload) {
        payload.resetIndex();
        
        this.timestamp = payload.getUnsignedLong();
        this.custom_state = payload.getUnsignedLong();
        this.lat = payload.getInt();
        this.lon = payload.getInt();
        this.alt = payload.getFloat();
         
        for (int i = 0; i < this.vel.length; i++) {
            this.vel[i] = payload.getFloat();
        }
                
         
        for (int i = 0; i < this.acc.length; i++) {
            this.acc[i] = payload.getFloat();
        }
                
         
        for (int i = 0; i < this.attitude_q.length; i++) {
            this.attitude_q[i] = payload.getFloat();
        }
                
         
        for (int i = 0; i < this.rates.length; i++) {
            this.rates[i] = payload.getFloat();
        }
                
         
        for (int i = 0; i < this.position_cov.length; i++) {
            this.position_cov[i] = payload.getFloat();
        }
                
        this.est_capabilities = payload.getUnsignedByte();
        
        if (isMavlink2) {
            
        }
    }

    /**
     * Constructor for a new message, just initializes the msgid
     */
    public msg_follow_target() {
        this.msgid = MAVLINK_MSG_ID_FOLLOW_TARGET;
    }
    
    /**
     * Constructor for a new message, initializes msgid and all payload variables
     */
    public msg_follow_target( long timestamp, long custom_state, int lat, int lon, float alt, float[] vel, float[] acc, float[] attitude_q, float[] rates, float[] position_cov, short est_capabilities) {
        this.msgid = MAVLINK_MSG_ID_FOLLOW_TARGET;

        this.timestamp = timestamp;
        this.custom_state = custom_state;
        this.lat = lat;
        this.lon = lon;
        this.alt = alt;
        this.vel = vel;
        this.acc = acc;
        this.attitude_q = attitude_q;
        this.rates = rates;
        this.position_cov = position_cov;
        this.est_capabilities = est_capabilities;
        
    }
    
    /**
     * Constructor for a new message, initializes everything
     */
    public msg_follow_target( long timestamp, long custom_state, int lat, int lon, float alt, float[] vel, float[] acc, float[] attitude_q, float[] rates, float[] position_cov, short est_capabilities, int sysid, int compid, boolean isMavlink2) {
        this.msgid = MAVLINK_MSG_ID_FOLLOW_TARGET;
        this.sysid = sysid;
        this.compid = compid;
        this.isMavlink2 = isMavlink2;

        this.timestamp = timestamp;
        this.custom_state = custom_state;
        this.lat = lat;
        this.lon = lon;
        this.alt = alt;
        this.vel = vel;
        this.acc = acc;
        this.attitude_q = attitude_q;
        this.rates = rates;
        this.position_cov = position_cov;
        this.est_capabilities = est_capabilities;
        
    }

    /**
     * Constructor for a new message, initializes the message with the payload
     * from a mavlink packet
     *
     */
    public msg_follow_target(MAVLinkPacket mavLinkPacket) {
        this.msgid = MAVLINK_MSG_ID_FOLLOW_TARGET;
        
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
        return "MAVLINK_MSG_ID_FOLLOW_TARGET - sysid:"+sysid+" compid:"+compid+" timestamp:"+timestamp+" custom_state:"+custom_state+" lat:"+lat+" lon:"+lon+" alt:"+alt+" vel:"+vel+" acc:"+acc+" attitude_q:"+attitude_q+" rates:"+rates+" position_cov:"+position_cov+" est_capabilities:"+est_capabilities+"";
    }
    
    /**
     * Returns a human-readable string of the name of the message
     */
    @Override
    public String name() {
        return "MAVLINK_MSG_ID_FOLLOW_TARGET";
    }
}
        