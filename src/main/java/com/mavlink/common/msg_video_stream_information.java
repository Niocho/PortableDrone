/* AUTO-GENERATED FILE.  DO NOT MODIFY.
 *
 * This class was automatically generated by the
 * java mavlink generator tool. It should not be modified by hand.
 */

// MESSAGE VIDEO_STREAM_INFORMATION PACKING
package com.mavlink.common;
import com.mavlink.MAVLinkPacket;
import com.mavlink.Messages.MAVLinkMessage;
import com.mavlink.Messages.MAVLinkPayload;
        
/**
 * Information about video stream. It may be requested using MAV_CMD_REQUEST_MESSAGE, where param2 indicates the video stream id: 0 for all streams, 1 for first, 2 for second, etc.
 */
public class msg_video_stream_information extends MAVLinkMessage {

    public static final int MAVLINK_MSG_ID_VIDEO_STREAM_INFORMATION = 269;
    public static final int MAVLINK_MSG_LENGTH = 213;
    private static final long serialVersionUID = MAVLINK_MSG_ID_VIDEO_STREAM_INFORMATION;

      
    /**
     * Frame rate.
     */
    public float framerate;
      
    /**
     * Bit rate.
     */
    public long bitrate;
      
    /**
     * Bitmap of stream status flags.
     */
    public int flags;
      
    /**
     * Horizontal resolution.
     */
    public int resolution_h;
      
    /**
     * Vertical resolution.
     */
    public int resolution_v;
      
    /**
     * Video image rotation clockwise.
     */
    public int rotation;
      
    /**
     * Horizontal Field of view.
     */
    public int hfov;
      
    /**
     * Video Stream ID (1 for first, 2 for second, etc.)
     */
    public short stream_id;
      
    /**
     * Number of streams available.
     */
    public short count;
      
    /**
     * Type of stream.
     */
    public short type;
      
    /**
     * Stream name.
     */
    public byte name[] = new byte[32];
      
    /**
     * Video stream URI (TCP or RTSP URI ground station should connect to) or port number (UDP port ground station should listen to).
     */
    public byte uri[] = new byte[160];
    

    /**
     * Generates the payload for a mavlink message for a message of this type
     * @return
     */
    @Override
    public MAVLinkPacket pack() {
        MAVLinkPacket packet = new MAVLinkPacket(MAVLINK_MSG_LENGTH,isMavlink2);
        packet.sysid = sysid;
        packet.compid = compid;
        packet.msgid = MAVLINK_MSG_ID_VIDEO_STREAM_INFORMATION;
        
        packet.payload.putFloat(framerate);
        packet.payload.putUnsignedInt(bitrate);
        packet.payload.putUnsignedShort(flags);
        packet.payload.putUnsignedShort(resolution_h);
        packet.payload.putUnsignedShort(resolution_v);
        packet.payload.putUnsignedShort(rotation);
        packet.payload.putUnsignedShort(hfov);
        packet.payload.putUnsignedByte(stream_id);
        packet.payload.putUnsignedByte(count);
        packet.payload.putUnsignedByte(type);
        
        for (int i = 0; i < name.length; i++) {
            packet.payload.putByte(name[i]);
        }
                    
        
        for (int i = 0; i < uri.length; i++) {
            packet.payload.putByte(uri[i]);
        }
                    
        
        if (isMavlink2) {
            
        }
        return packet;
    }

    /**
     * Decode a video_stream_information message into this class fields
     *
     * @param payload The message to decode
     */
    @Override
    public void unpack(MAVLinkPayload payload) {
        payload.resetIndex();
        
        this.framerate = payload.getFloat();
        this.bitrate = payload.getUnsignedInt();
        this.flags = payload.getUnsignedShort();
        this.resolution_h = payload.getUnsignedShort();
        this.resolution_v = payload.getUnsignedShort();
        this.rotation = payload.getUnsignedShort();
        this.hfov = payload.getUnsignedShort();
        this.stream_id = payload.getUnsignedByte();
        this.count = payload.getUnsignedByte();
        this.type = payload.getUnsignedByte();
         
        for (int i = 0; i < this.name.length; i++) {
            this.name[i] = payload.getByte();
        }
                
         
        for (int i = 0; i < this.uri.length; i++) {
            this.uri[i] = payload.getByte();
        }
                
        
        if (isMavlink2) {
            
        }
    }

    /**
     * Constructor for a new message, just initializes the msgid
     */
    public msg_video_stream_information() {
        this.msgid = MAVLINK_MSG_ID_VIDEO_STREAM_INFORMATION;
    }
    
    /**
     * Constructor for a new message, initializes msgid and all payload variables
     */
    public msg_video_stream_information( float framerate, long bitrate, int flags, int resolution_h, int resolution_v, int rotation, int hfov, short stream_id, short count, short type, byte[] name, byte[] uri) {
        this.msgid = MAVLINK_MSG_ID_VIDEO_STREAM_INFORMATION;

        this.framerate = framerate;
        this.bitrate = bitrate;
        this.flags = flags;
        this.resolution_h = resolution_h;
        this.resolution_v = resolution_v;
        this.rotation = rotation;
        this.hfov = hfov;
        this.stream_id = stream_id;
        this.count = count;
        this.type = type;
        this.name = name;
        this.uri = uri;
        
    }
    
    /**
     * Constructor for a new message, initializes everything
     */
    public msg_video_stream_information( float framerate, long bitrate, int flags, int resolution_h, int resolution_v, int rotation, int hfov, short stream_id, short count, short type, byte[] name, byte[] uri, int sysid, int compid, boolean isMavlink2) {
        this.msgid = MAVLINK_MSG_ID_VIDEO_STREAM_INFORMATION;
        this.sysid = sysid;
        this.compid = compid;
        this.isMavlink2 = isMavlink2;

        this.framerate = framerate;
        this.bitrate = bitrate;
        this.flags = flags;
        this.resolution_h = resolution_h;
        this.resolution_v = resolution_v;
        this.rotation = rotation;
        this.hfov = hfov;
        this.stream_id = stream_id;
        this.count = count;
        this.type = type;
        this.name = name;
        this.uri = uri;
        
    }

    /**
     * Constructor for a new message, initializes the message with the payload
     * from a mavlink packet
     *
     */
    public msg_video_stream_information(MAVLinkPacket mavLinkPacket) {
        this.msgid = MAVLINK_MSG_ID_VIDEO_STREAM_INFORMATION;
        
        this.sysid = mavLinkPacket.sysid;
        this.compid = mavLinkPacket.compid;
        this.isMavlink2 = mavLinkPacket.isMavlink2;
        unpack(mavLinkPacket.payload);
    }

                         
    /**
    * Sets the buffer of this message with a string, adds the necessary padding
    */
    public void setName(String str) {
        int len = Math.min(str.length(), 32);
        for (int i=0; i<len; i++) {
            name[i] = (byte) str.charAt(i);
        }

        for (int i=len; i<32; i++) {            // padding for the rest of the buffer
            name[i] = 0;
        }
    }

    /**
    * Gets the message, formatted as a string
    */
    public String getName() {
        StringBuffer buf = new StringBuffer();
        for (int i = 0; i < 32; i++) {
            if (name[i] != 0)
                buf.append((char) name[i]);
            else
                break;
        }
        return buf.toString();

    }
                          
    /**
    * Sets the buffer of this message with a string, adds the necessary padding
    */
    public void setUri(String str) {
        int len = Math.min(str.length(), 160);
        for (int i=0; i<len; i++) {
            uri[i] = (byte) str.charAt(i);
        }

        for (int i=len; i<160; i++) {            // padding for the rest of the buffer
            uri[i] = 0;
        }
    }

    /**
    * Gets the message, formatted as a string
    */
    public String getUri() {
        StringBuffer buf = new StringBuffer();
        for (int i = 0; i < 160; i++) {
            if (uri[i] != 0)
                buf.append((char) uri[i]);
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
        return "MAVLINK_MSG_ID_VIDEO_STREAM_INFORMATION - sysid:"+sysid+" compid:"+compid+" framerate:"+framerate+" bitrate:"+bitrate+" flags:"+flags+" resolution_h:"+resolution_h+" resolution_v:"+resolution_v+" rotation:"+rotation+" hfov:"+hfov+" stream_id:"+stream_id+" count:"+count+" type:"+type+" name:"+name+" uri:"+uri+"";
    }
    
    /**
     * Returns a human-readable string of the name of the message
     */
    @Override
    public String name() {
        return "MAVLINK_MSG_ID_VIDEO_STREAM_INFORMATION";
    }
}
        