/* AUTO-GENERATED FILE.  DO NOT MODIFY.
 *
 * This class was automatically generated by the
 * java mavlink generator tool. It should not be modified by hand.
 */

// MESSAGE AIS_VESSEL PACKING
package com.mavlink.common;
import com.mavlink.MAVLinkPacket;
import com.mavlink.Messages.MAVLinkMessage;
import com.mavlink.Messages.MAVLinkPayload;
        
/**
 * The location and information of an AIS vessel
 */
public class msg_ais_vessel extends MAVLinkMessage {

    public static final int MAVLINK_MSG_ID_AIS_VESSEL = 301;
    public static final int MAVLINK_MSG_LENGTH = 58;
    private static final long serialVersionUID = MAVLINK_MSG_ID_AIS_VESSEL;

      
    /**
     * Mobile Marine Service Identifier, 9 decimal digits
     */
    public long MMSI;
      
    /**
     * Latitude
     */
    public int lat;
      
    /**
     * Longitude
     */
    public int lon;
      
    /**
     * Course over ground
     */
    public int COG;
      
    /**
     * True heading
     */
    public int heading;
      
    /**
     * Speed over ground
     */
    public int velocity;
      
    /**
     * Distance from lat/lon location to bow
     */
    public int dimension_bow;
      
    /**
     * Distance from lat/lon location to stern
     */
    public int dimension_stern;
      
    /**
     * Time since last communication in seconds
     */
    public int tslc;
      
    /**
     * Bitmask to indicate various statuses including valid data fields
     */
    public int flags;
      
    /**
     * Turn rate
     */
    public byte turn_rate;
      
    /**
     * Navigational status
     */
    public short navigational_status;
      
    /**
     * Type of vessels
     */
    public short type;
      
    /**
     * Distance from lat/lon location to port side
     */
    public short dimension_port;
      
    /**
     * Distance from lat/lon location to starboard side
     */
    public short dimension_starboard;
      
    /**
     * The vessel callsign
     */
    public byte callsign[] = new byte[7];
      
    /**
     * The vessel name
     */
    public byte name[] = new byte[20];
    

    /**
     * Generates the payload for a mavlink message for a message of this type
     * @return
     */
    @Override
    public MAVLinkPacket pack() {
        MAVLinkPacket packet = new MAVLinkPacket(MAVLINK_MSG_LENGTH,isMavlink2);
        packet.sysid = sysid;
        packet.compid = compid;
        packet.msgid = MAVLINK_MSG_ID_AIS_VESSEL;
        
        packet.payload.putUnsignedInt(MMSI);
        packet.payload.putInt(lat);
        packet.payload.putInt(lon);
        packet.payload.putUnsignedShort(COG);
        packet.payload.putUnsignedShort(heading);
        packet.payload.putUnsignedShort(velocity);
        packet.payload.putUnsignedShort(dimension_bow);
        packet.payload.putUnsignedShort(dimension_stern);
        packet.payload.putUnsignedShort(tslc);
        packet.payload.putUnsignedShort(flags);
        packet.payload.putByte(turn_rate);
        packet.payload.putUnsignedByte(navigational_status);
        packet.payload.putUnsignedByte(type);
        packet.payload.putUnsignedByte(dimension_port);
        packet.payload.putUnsignedByte(dimension_starboard);
        
        for (int i = 0; i < callsign.length; i++) {
            packet.payload.putByte(callsign[i]);
        }
                    
        
        for (int i = 0; i < name.length; i++) {
            packet.payload.putByte(name[i]);
        }
                    
        
        if (isMavlink2) {
            
        }
        return packet;
    }

    /**
     * Decode a ais_vessel message into this class fields
     *
     * @param payload The message to decode
     */
    @Override
    public void unpack(MAVLinkPayload payload) {
        payload.resetIndex();
        
        this.MMSI = payload.getUnsignedInt();
        this.lat = payload.getInt();
        this.lon = payload.getInt();
        this.COG = payload.getUnsignedShort();
        this.heading = payload.getUnsignedShort();
        this.velocity = payload.getUnsignedShort();
        this.dimension_bow = payload.getUnsignedShort();
        this.dimension_stern = payload.getUnsignedShort();
        this.tslc = payload.getUnsignedShort();
        this.flags = payload.getUnsignedShort();
        this.turn_rate = payload.getByte();
        this.navigational_status = payload.getUnsignedByte();
        this.type = payload.getUnsignedByte();
        this.dimension_port = payload.getUnsignedByte();
        this.dimension_starboard = payload.getUnsignedByte();
         
        for (int i = 0; i < this.callsign.length; i++) {
            this.callsign[i] = payload.getByte();
        }
                
         
        for (int i = 0; i < this.name.length; i++) {
            this.name[i] = payload.getByte();
        }
                
        
        if (isMavlink2) {
            
        }
    }

    /**
     * Constructor for a new message, just initializes the msgid
     */
    public msg_ais_vessel() {
        this.msgid = MAVLINK_MSG_ID_AIS_VESSEL;
    }
    
    /**
     * Constructor for a new message, initializes msgid and all payload variables
     */
    public msg_ais_vessel( long MMSI, int lat, int lon, int COG, int heading, int velocity, int dimension_bow, int dimension_stern, int tslc, int flags, byte turn_rate, short navigational_status, short type, short dimension_port, short dimension_starboard, byte[] callsign, byte[] name) {
        this.msgid = MAVLINK_MSG_ID_AIS_VESSEL;

        this.MMSI = MMSI;
        this.lat = lat;
        this.lon = lon;
        this.COG = COG;
        this.heading = heading;
        this.velocity = velocity;
        this.dimension_bow = dimension_bow;
        this.dimension_stern = dimension_stern;
        this.tslc = tslc;
        this.flags = flags;
        this.turn_rate = turn_rate;
        this.navigational_status = navigational_status;
        this.type = type;
        this.dimension_port = dimension_port;
        this.dimension_starboard = dimension_starboard;
        this.callsign = callsign;
        this.name = name;
        
    }
    
    /**
     * Constructor for a new message, initializes everything
     */
    public msg_ais_vessel( long MMSI, int lat, int lon, int COG, int heading, int velocity, int dimension_bow, int dimension_stern, int tslc, int flags, byte turn_rate, short navigational_status, short type, short dimension_port, short dimension_starboard, byte[] callsign, byte[] name, int sysid, int compid, boolean isMavlink2) {
        this.msgid = MAVLINK_MSG_ID_AIS_VESSEL;
        this.sysid = sysid;
        this.compid = compid;
        this.isMavlink2 = isMavlink2;

        this.MMSI = MMSI;
        this.lat = lat;
        this.lon = lon;
        this.COG = COG;
        this.heading = heading;
        this.velocity = velocity;
        this.dimension_bow = dimension_bow;
        this.dimension_stern = dimension_stern;
        this.tslc = tslc;
        this.flags = flags;
        this.turn_rate = turn_rate;
        this.navigational_status = navigational_status;
        this.type = type;
        this.dimension_port = dimension_port;
        this.dimension_starboard = dimension_starboard;
        this.callsign = callsign;
        this.name = name;
        
    }

    /**
     * Constructor for a new message, initializes the message with the payload
     * from a mavlink packet
     *
     */
    public msg_ais_vessel(MAVLinkPacket mavLinkPacket) {
        this.msgid = MAVLINK_MSG_ID_AIS_VESSEL;
        
        this.sysid = mavLinkPacket.sysid;
        this.compid = mavLinkPacket.compid;
        this.isMavlink2 = mavLinkPacket.isMavlink2;
        unpack(mavLinkPacket.payload);
    }

                                   
    /**
    * Sets the buffer of this message with a string, adds the necessary padding
    */
    public void setCallsign(String str) {
        int len = Math.min(str.length(), 7);
        for (int i=0; i<len; i++) {
            callsign[i] = (byte) str.charAt(i);
        }

        for (int i=len; i<7; i++) {            // padding for the rest of the buffer
            callsign[i] = 0;
        }
    }

    /**
    * Gets the message, formatted as a string
    */
    public String getCallsign() {
        StringBuffer buf = new StringBuffer();
        for (int i = 0; i < 7; i++) {
            if (callsign[i] != 0)
                buf.append((char) callsign[i]);
            else
                break;
        }
        return buf.toString();

    }
                          
    /**
    * Sets the buffer of this message with a string, adds the necessary padding
    */
    public void setName(String str) {
        int len = Math.min(str.length(), 20);
        for (int i=0; i<len; i++) {
            name[i] = (byte) str.charAt(i);
        }

        for (int i=len; i<20; i++) {            // padding for the rest of the buffer
            name[i] = 0;
        }
    }

    /**
    * Gets the message, formatted as a string
    */
    public String getName() {
        StringBuffer buf = new StringBuffer();
        for (int i = 0; i < 20; i++) {
            if (name[i] != 0)
                buf.append((char) name[i]);
            else
                break;
        }
        return buf.toString();

    }
                         
    /**
     * Returns a string with the MSG name and data
     */
    @Override
    public String toString() {
        return "MAVLINK_MSG_ID_AIS_VESSEL - sysid:"+sysid+" compid:"+compid+" MMSI:"+MMSI+" lat:"+lat+" lon:"+lon+" COG:"+COG+" heading:"+heading+" velocity:"+velocity+" dimension_bow:"+dimension_bow+" dimension_stern:"+dimension_stern+" tslc:"+tslc+" flags:"+flags+" turn_rate:"+turn_rate+" navigational_status:"+navigational_status+" type:"+type+" dimension_port:"+dimension_port+" dimension_starboard:"+dimension_starboard+" callsign:"+callsign+" name:"+name+"";
    }
    
    /**
     * Returns a human-readable string of the name of the message
     */
    @Override
    public String name() {
        return "MAVLINK_MSG_ID_AIS_VESSEL";
    }
}
        