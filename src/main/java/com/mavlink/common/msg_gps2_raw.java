/* AUTO-GENERATED FILE.  DO NOT MODIFY.
 *
 * This class was automatically generated by the
 * java mavlink generator tool. It should not be modified by hand.
 */

// MESSAGE GPS2_RAW PACKING
package com.mavlink.common;
import com.mavlink.MAVLinkPacket;
import com.mavlink.Messages.MAVLinkMessage;
import com.mavlink.Messages.MAVLinkPayload;
        
/**
 * Second GPS data.
 */
public class msg_gps2_raw extends MAVLinkMessage {

    public static final int MAVLINK_MSG_ID_GPS2_RAW = 124;
    public static final int MAVLINK_MSG_LENGTH = 57;
    private static final long serialVersionUID = MAVLINK_MSG_ID_GPS2_RAW;

      
    /**
     * Timestamp (UNIX Epoch time or time since system boot). The receiving end can infer timestamp format (since 1.1.1970 or since system boot) by checking for the magnitude of the number.
     */
    public long time_usec;
      
    /**
     * Latitude (WGS84)
     */
    public int lat;
      
    /**
     * Longitude (WGS84)
     */
    public int lon;
      
    /**
     * Altitude (MSL). Positive for up.
     */
    public int alt;
      
    /**
     * Age of DGPS info
     */
    public long dgps_age;
      
    /**
     * GPS HDOP horizontal dilution of position (unitless * 100). If unknown, set to: UINT16_MAX
     */
    public int eph;
      
    /**
     * GPS VDOP vertical dilution of position (unitless * 100). If unknown, set to: UINT16_MAX
     */
    public int epv;
      
    /**
     * GPS ground speed. If unknown, set to: UINT16_MAX
     */
    public int vel;
      
    /**
     * Course over ground (NOT heading, but direction of movement): 0.0..359.99 degrees. If unknown, set to: UINT16_MAX
     */
    public int cog;
      
    /**
     * GPS fix type.
     */
    public short fix_type;
      
    /**
     * Number of satellites visible. If unknown, set to UINT8_MAX
     */
    public short satellites_visible;
      
    /**
     * Number of DGPS satellites
     */
    public short dgps_numch;
      
    /**
     * Yaw in earth frame from north. Use 0 if this GPS does not provide yaw. Use UINT16_MAX if this GPS is configured to provide yaw and is currently unable to provide it. Use 36000 for north.
     */
    public int yaw;
      
    /**
     * Altitude (above WGS84, EGM96 ellipsoid). Positive for up.
     */
    public int alt_ellipsoid;
      
    /**
     * Position uncertainty.
     */
    public long h_acc;
      
    /**
     * Altitude uncertainty.
     */
    public long v_acc;
      
    /**
     * Speed uncertainty.
     */
    public long vel_acc;
      
    /**
     * Heading / track uncertainty
     */
    public long hdg_acc;
    

    /**
     * Generates the payload for a mavlink message for a message of this type
     * @return
     */
    @Override
    public MAVLinkPacket pack() {
        MAVLinkPacket packet = new MAVLinkPacket(MAVLINK_MSG_LENGTH,isMavlink2);
        packet.sysid = sysid;
        packet.compid = compid;
        packet.msgid = MAVLINK_MSG_ID_GPS2_RAW;
        
        packet.payload.putUnsignedLong(time_usec);
        packet.payload.putInt(lat);
        packet.payload.putInt(lon);
        packet.payload.putInt(alt);
        packet.payload.putUnsignedInt(dgps_age);
        packet.payload.putUnsignedShort(eph);
        packet.payload.putUnsignedShort(epv);
        packet.payload.putUnsignedShort(vel);
        packet.payload.putUnsignedShort(cog);
        packet.payload.putUnsignedByte(fix_type);
        packet.payload.putUnsignedByte(satellites_visible);
        packet.payload.putUnsignedByte(dgps_numch);
        
        if (isMavlink2) {
             packet.payload.putUnsignedShort(yaw);
             packet.payload.putInt(alt_ellipsoid);
             packet.payload.putUnsignedInt(h_acc);
             packet.payload.putUnsignedInt(v_acc);
             packet.payload.putUnsignedInt(vel_acc);
             packet.payload.putUnsignedInt(hdg_acc);
            
        }
        return packet;
    }

    /**
     * Decode a gps2_raw message into this class fields
     *
     * @param payload The message to decode
     */
    @Override
    public void unpack(MAVLinkPayload payload) {
        payload.resetIndex();
        
        this.time_usec = payload.getUnsignedLong();
        this.lat = payload.getInt();
        this.lon = payload.getInt();
        this.alt = payload.getInt();
        this.dgps_age = payload.getUnsignedInt();
        this.eph = payload.getUnsignedShort();
        this.epv = payload.getUnsignedShort();
        this.vel = payload.getUnsignedShort();
        this.cog = payload.getUnsignedShort();
        this.fix_type = payload.getUnsignedByte();
        this.satellites_visible = payload.getUnsignedByte();
        this.dgps_numch = payload.getUnsignedByte();
        
        if (isMavlink2) {
             this.yaw = payload.getUnsignedShort();
             this.alt_ellipsoid = payload.getInt();
             this.h_acc = payload.getUnsignedInt();
             this.v_acc = payload.getUnsignedInt();
             this.vel_acc = payload.getUnsignedInt();
             this.hdg_acc = payload.getUnsignedInt();
            
        }
    }

    /**
     * Constructor for a new message, just initializes the msgid
     */
    public msg_gps2_raw() {
        this.msgid = MAVLINK_MSG_ID_GPS2_RAW;
    }
    
    /**
     * Constructor for a new message, initializes msgid and all payload variables
     */
    public msg_gps2_raw( long time_usec, int lat, int lon, int alt, long dgps_age, int eph, int epv, int vel, int cog, short fix_type, short satellites_visible, short dgps_numch, int yaw, int alt_ellipsoid, long h_acc, long v_acc, long vel_acc, long hdg_acc) {
        this.msgid = MAVLINK_MSG_ID_GPS2_RAW;

        this.time_usec = time_usec;
        this.lat = lat;
        this.lon = lon;
        this.alt = alt;
        this.dgps_age = dgps_age;
        this.eph = eph;
        this.epv = epv;
        this.vel = vel;
        this.cog = cog;
        this.fix_type = fix_type;
        this.satellites_visible = satellites_visible;
        this.dgps_numch = dgps_numch;
        this.yaw = yaw;
        this.alt_ellipsoid = alt_ellipsoid;
        this.h_acc = h_acc;
        this.v_acc = v_acc;
        this.vel_acc = vel_acc;
        this.hdg_acc = hdg_acc;
        
    }
    
    /**
     * Constructor for a new message, initializes everything
     */
    public msg_gps2_raw( long time_usec, int lat, int lon, int alt, long dgps_age, int eph, int epv, int vel, int cog, short fix_type, short satellites_visible, short dgps_numch, int yaw, int alt_ellipsoid, long h_acc, long v_acc, long vel_acc, long hdg_acc, int sysid, int compid, boolean isMavlink2) {
        this.msgid = MAVLINK_MSG_ID_GPS2_RAW;
        this.sysid = sysid;
        this.compid = compid;
        this.isMavlink2 = isMavlink2;

        this.time_usec = time_usec;
        this.lat = lat;
        this.lon = lon;
        this.alt = alt;
        this.dgps_age = dgps_age;
        this.eph = eph;
        this.epv = epv;
        this.vel = vel;
        this.cog = cog;
        this.fix_type = fix_type;
        this.satellites_visible = satellites_visible;
        this.dgps_numch = dgps_numch;
        this.yaw = yaw;
        this.alt_ellipsoid = alt_ellipsoid;
        this.h_acc = h_acc;
        this.v_acc = v_acc;
        this.vel_acc = vel_acc;
        this.hdg_acc = hdg_acc;
        
    }

    /**
     * Constructor for a new message, initializes the message with the payload
     * from a mavlink packet
     *
     */
    public msg_gps2_raw(MAVLinkPacket mavLinkPacket) {
        this.msgid = MAVLINK_MSG_ID_GPS2_RAW;
        
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
        return "MAVLINK_MSG_ID_GPS2_RAW - sysid:"+sysid+" compid:"+compid+" time_usec:"+time_usec+" lat:"+lat+" lon:"+lon+" alt:"+alt+" dgps_age:"+dgps_age+" eph:"+eph+" epv:"+epv+" vel:"+vel+" cog:"+cog+" fix_type:"+fix_type+" satellites_visible:"+satellites_visible+" dgps_numch:"+dgps_numch+" yaw:"+yaw+" alt_ellipsoid:"+alt_ellipsoid+" h_acc:"+h_acc+" v_acc:"+v_acc+" vel_acc:"+vel_acc+" hdg_acc:"+hdg_acc+"";
    }
    
    /**
     * Returns a human-readable string of the name of the message
     */
    @Override
    public String name() {
        return "MAVLINK_MSG_ID_GPS2_RAW";
    }
}
        