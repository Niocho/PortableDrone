/* AUTO-GENERATED FILE.  DO NOT MODIFY.
 *
 * This class was automatically generated by the
 * java mavlink generator tool. It should not be modified by hand.
 */

// MESSAGE OPEN_DRONE_ID_LOCATION PACKING
package com.mavlink.common;
import com.mavlink.MAVLinkPacket;
import com.mavlink.Messages.MAVLinkMessage;
import com.mavlink.Messages.MAVLinkPayload;
        
/**
 * Data for filling the OpenDroneID Location message. The float data types are 32-bit IEEE 754. The Location message provides the location, altitude, direction and speed of the aircraft.
 */
public class msg_open_drone_id_location extends MAVLinkMessage {

    public static final int MAVLINK_MSG_ID_OPEN_DRONE_ID_LOCATION = 12901;
    public static final int MAVLINK_MSG_LENGTH = 59;
    private static final long serialVersionUID = MAVLINK_MSG_ID_OPEN_DRONE_ID_LOCATION;

      
    /**
     * Current latitude of the unmanned aircraft. If unknown: 0 (both Lat/Lon).
     */
    public int latitude;
      
    /**
     * Current longitude of the unmanned aircraft. If unknown: 0 (both Lat/Lon).
     */
    public int longitude;
      
    /**
     * The altitude calculated from the barometric pressue. Reference is against 29.92inHg or 1013.2mb. If unknown: -1000 m.
     */
    public float altitude_barometric;
      
    /**
     * The geodetic altitude as defined by WGS84. If unknown: -1000 m.
     */
    public float altitude_geodetic;
      
    /**
     * The current height of the unmanned aircraft above the take-off location or the ground as indicated by height_reference. If unknown: -1000 m.
     */
    public float height;
      
    /**
     * Seconds after the full hour with reference to UTC time. Typically the GPS outputs a time-of-week value in milliseconds. First convert that to UTC and then convert for this field using ((float) (time_week_ms % (60*60*1000))) / 1000. If unknown: 0xFFFF.
     */
    public float timestamp;
      
    /**
     * Direction over ground (not heading, but direction of movement) measured clockwise from true North: 0 - 35999 centi-degrees. If unknown: 36100 centi-degrees.
     */
    public int direction;
      
    /**
     * Ground speed. Positive only. If unknown: 25500 cm/s. If speed is larger than 25425 cm/s, use 25425 cm/s.
     */
    public int speed_horizontal;
      
    /**
     * The vertical speed. Up is positive. If unknown: 6300 cm/s. If speed is larger than 6200 cm/s, use 6200 cm/s. If lower than -6200 cm/s, use -6200 cm/s.
     */
    public short speed_vertical;
      
    /**
     * System ID (0 for broadcast).
     */
    public short target_system;
      
    /**
     * Component ID (0 for broadcast).
     */
    public short target_component;
      
    /**
     * Only used for drone ID data received from other UAs. See detailed description at https://mavlink.io/en/services/opendroneid.html. 
     */
    public short id_or_mac[] = new short[20];
      
    /**
     * Indicates whether the unmanned aircraft is on the ground or in the air.
     */
    public short status;
      
    /**
     * Indicates the reference point for the height field.
     */
    public short height_reference;
      
    /**
     * The accuracy of the horizontal position.
     */
    public short horizontal_accuracy;
      
    /**
     * The accuracy of the vertical position.
     */
    public short vertical_accuracy;
      
    /**
     * The accuracy of the barometric altitude.
     */
    public short barometer_accuracy;
      
    /**
     * The accuracy of the horizontal and vertical speed.
     */
    public short speed_accuracy;
      
    /**
     * The accuracy of the timestamps.
     */
    public short timestamp_accuracy;
    

    /**
     * Generates the payload for a mavlink message for a message of this type
     * @return
     */
    @Override
    public MAVLinkPacket pack() {
        MAVLinkPacket packet = new MAVLinkPacket(MAVLINK_MSG_LENGTH,isMavlink2);
        packet.sysid = sysid;
        packet.compid = compid;
        packet.msgid = MAVLINK_MSG_ID_OPEN_DRONE_ID_LOCATION;
        
        packet.payload.putInt(latitude);
        packet.payload.putInt(longitude);
        packet.payload.putFloat(altitude_barometric);
        packet.payload.putFloat(altitude_geodetic);
        packet.payload.putFloat(height);
        packet.payload.putFloat(timestamp);
        packet.payload.putUnsignedShort(direction);
        packet.payload.putUnsignedShort(speed_horizontal);
        packet.payload.putShort(speed_vertical);
        packet.payload.putUnsignedByte(target_system);
        packet.payload.putUnsignedByte(target_component);
        
        for (int i = 0; i < id_or_mac.length; i++) {
            packet.payload.putUnsignedByte(id_or_mac[i]);
        }
                    
        packet.payload.putUnsignedByte(status);
        packet.payload.putUnsignedByte(height_reference);
        packet.payload.putUnsignedByte(horizontal_accuracy);
        packet.payload.putUnsignedByte(vertical_accuracy);
        packet.payload.putUnsignedByte(barometer_accuracy);
        packet.payload.putUnsignedByte(speed_accuracy);
        packet.payload.putUnsignedByte(timestamp_accuracy);
        
        if (isMavlink2) {
            
        }
        return packet;
    }

    /**
     * Decode a open_drone_id_location message into this class fields
     *
     * @param payload The message to decode
     */
    @Override
    public void unpack(MAVLinkPayload payload) {
        payload.resetIndex();
        
        this.latitude = payload.getInt();
        this.longitude = payload.getInt();
        this.altitude_barometric = payload.getFloat();
        this.altitude_geodetic = payload.getFloat();
        this.height = payload.getFloat();
        this.timestamp = payload.getFloat();
        this.direction = payload.getUnsignedShort();
        this.speed_horizontal = payload.getUnsignedShort();
        this.speed_vertical = payload.getShort();
        this.target_system = payload.getUnsignedByte();
        this.target_component = payload.getUnsignedByte();
         
        for (int i = 0; i < this.id_or_mac.length; i++) {
            this.id_or_mac[i] = payload.getUnsignedByte();
        }
                
        this.status = payload.getUnsignedByte();
        this.height_reference = payload.getUnsignedByte();
        this.horizontal_accuracy = payload.getUnsignedByte();
        this.vertical_accuracy = payload.getUnsignedByte();
        this.barometer_accuracy = payload.getUnsignedByte();
        this.speed_accuracy = payload.getUnsignedByte();
        this.timestamp_accuracy = payload.getUnsignedByte();
        
        if (isMavlink2) {
            
        }
    }

    /**
     * Constructor for a new message, just initializes the msgid
     */
    public msg_open_drone_id_location() {
        this.msgid = MAVLINK_MSG_ID_OPEN_DRONE_ID_LOCATION;
    }
    
    /**
     * Constructor for a new message, initializes msgid and all payload variables
     */
    public msg_open_drone_id_location( int latitude, int longitude, float altitude_barometric, float altitude_geodetic, float height, float timestamp, int direction, int speed_horizontal, short speed_vertical, short target_system, short target_component, short[] id_or_mac, short status, short height_reference, short horizontal_accuracy, short vertical_accuracy, short barometer_accuracy, short speed_accuracy, short timestamp_accuracy) {
        this.msgid = MAVLINK_MSG_ID_OPEN_DRONE_ID_LOCATION;

        this.latitude = latitude;
        this.longitude = longitude;
        this.altitude_barometric = altitude_barometric;
        this.altitude_geodetic = altitude_geodetic;
        this.height = height;
        this.timestamp = timestamp;
        this.direction = direction;
        this.speed_horizontal = speed_horizontal;
        this.speed_vertical = speed_vertical;
        this.target_system = target_system;
        this.target_component = target_component;
        this.id_or_mac = id_or_mac;
        this.status = status;
        this.height_reference = height_reference;
        this.horizontal_accuracy = horizontal_accuracy;
        this.vertical_accuracy = vertical_accuracy;
        this.barometer_accuracy = barometer_accuracy;
        this.speed_accuracy = speed_accuracy;
        this.timestamp_accuracy = timestamp_accuracy;
        
    }
    
    /**
     * Constructor for a new message, initializes everything
     */
    public msg_open_drone_id_location( int latitude, int longitude, float altitude_barometric, float altitude_geodetic, float height, float timestamp, int direction, int speed_horizontal, short speed_vertical, short target_system, short target_component, short[] id_or_mac, short status, short height_reference, short horizontal_accuracy, short vertical_accuracy, short barometer_accuracy, short speed_accuracy, short timestamp_accuracy, int sysid, int compid, boolean isMavlink2) {
        this.msgid = MAVLINK_MSG_ID_OPEN_DRONE_ID_LOCATION;
        this.sysid = sysid;
        this.compid = compid;
        this.isMavlink2 = isMavlink2;

        this.latitude = latitude;
        this.longitude = longitude;
        this.altitude_barometric = altitude_barometric;
        this.altitude_geodetic = altitude_geodetic;
        this.height = height;
        this.timestamp = timestamp;
        this.direction = direction;
        this.speed_horizontal = speed_horizontal;
        this.speed_vertical = speed_vertical;
        this.target_system = target_system;
        this.target_component = target_component;
        this.id_or_mac = id_or_mac;
        this.status = status;
        this.height_reference = height_reference;
        this.horizontal_accuracy = horizontal_accuracy;
        this.vertical_accuracy = vertical_accuracy;
        this.barometer_accuracy = barometer_accuracy;
        this.speed_accuracy = speed_accuracy;
        this.timestamp_accuracy = timestamp_accuracy;
        
    }

    /**
     * Constructor for a new message, initializes the message with the payload
     * from a mavlink packet
     *
     */
    public msg_open_drone_id_location(MAVLinkPacket mavLinkPacket) {
        this.msgid = MAVLINK_MSG_ID_OPEN_DRONE_ID_LOCATION;
        
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
        return "MAVLINK_MSG_ID_OPEN_DRONE_ID_LOCATION - sysid:"+sysid+" compid:"+compid+" latitude:"+latitude+" longitude:"+longitude+" altitude_barometric:"+altitude_barometric+" altitude_geodetic:"+altitude_geodetic+" height:"+height+" timestamp:"+timestamp+" direction:"+direction+" speed_horizontal:"+speed_horizontal+" speed_vertical:"+speed_vertical+" target_system:"+target_system+" target_component:"+target_component+" id_or_mac:"+id_or_mac+" status:"+status+" height_reference:"+height_reference+" horizontal_accuracy:"+horizontal_accuracy+" vertical_accuracy:"+vertical_accuracy+" barometer_accuracy:"+barometer_accuracy+" speed_accuracy:"+speed_accuracy+" timestamp_accuracy:"+timestamp_accuracy+"";
    }
    
    /**
     * Returns a human-readable string of the name of the message
     */
    @Override
    public String name() {
        return "MAVLINK_MSG_ID_OPEN_DRONE_ID_LOCATION";
    }
}
        