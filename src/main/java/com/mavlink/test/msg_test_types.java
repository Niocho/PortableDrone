/* AUTO-GENERATED FILE.  DO NOT MODIFY.
 *
 * This class was automatically generated by the
 * java mavlink generator tool. It should not be modified by hand.
 */

// MESSAGE TEST_TYPES PACKING
package com.mavlink.test;
import com.mavlink.MAVLinkPacket;
import com.mavlink.Messages.MAVLinkMessage;
import com.mavlink.Messages.MAVLinkPayload;
        
/**
 * Test all field types
 */
public class msg_test_types extends MAVLinkMessage {

    public static final int MAVLINK_MSG_ID_TEST_TYPES = 17000;
    public static final int MAVLINK_MSG_LENGTH = 179;
    private static final long serialVersionUID = MAVLINK_MSG_ID_TEST_TYPES;

      
    /**
     * uint64_t
     */
    public long u64;
      
    /**
     * int64_t
     */
    public long s64;
      
    /**
     * double
     */
    public double d;
      
    /**
     * uint64_t_array
     */
    public long u64_array[] = new long[3];
      
    /**
     * int64_t_array
     */
    public long s64_array[] = new long[3];
      
    /**
     * double_array
     */
    public double d_array[] = new double[3];
      
    /**
     * uint32_t
     */
    public long u32;
      
    /**
     * int32_t
     */
    public int s32;
      
    /**
     * float
     */
    public float f;
      
    /**
     * uint32_t_array
     */
    public long u32_array[] = new long[3];
      
    /**
     * int32_t_array
     */
    public int s32_array[] = new int[3];
      
    /**
     * float_array
     */
    public float f_array[] = new float[3];
      
    /**
     * uint16_t
     */
    public int u16;
      
    /**
     * int16_t
     */
    public short s16;
      
    /**
     * uint16_t_array
     */
    public int u16_array[] = new int[3];
      
    /**
     * int16_t_array
     */
    public short s16_array[] = new short[3];
      
    /**
     * char
     */
    public byte c;
      
    /**
     * string
     */
    public byte s[] = new byte[10];
      
    /**
     * uint8_t
     */
    public short u8;
      
    /**
     * int8_t
     */
    public byte s8;
      
    /**
     * uint8_t_array
     */
    public short u8_array[] = new short[3];
      
    /**
     * int8_t_array
     */
    public byte s8_array[] = new byte[3];
    

    /**
     * Generates the payload for a mavlink message for a message of this type
     * @return
     */
    @Override
    public MAVLinkPacket pack() {
        MAVLinkPacket packet = new MAVLinkPacket(MAVLINK_MSG_LENGTH,isMavlink2);
        packet.sysid = sysid;
        packet.compid = compid;
        packet.msgid = MAVLINK_MSG_ID_TEST_TYPES;
        
        packet.payload.putUnsignedLong(u64);
        packet.payload.putLong(s64);
        packet.payload.putDouble(d);
        
        for (int i = 0; i < u64_array.length; i++) {
            packet.payload.putUnsignedLong(u64_array[i]);
        }
                    
        
        for (int i = 0; i < s64_array.length; i++) {
            packet.payload.putLong(s64_array[i]);
        }
                    
        
        for (int i = 0; i < d_array.length; i++) {
            packet.payload.putDouble(d_array[i]);
        }
                    
        packet.payload.putUnsignedInt(u32);
        packet.payload.putInt(s32);
        packet.payload.putFloat(f);
        
        for (int i = 0; i < u32_array.length; i++) {
            packet.payload.putUnsignedInt(u32_array[i]);
        }
                    
        
        for (int i = 0; i < s32_array.length; i++) {
            packet.payload.putInt(s32_array[i]);
        }
                    
        
        for (int i = 0; i < f_array.length; i++) {
            packet.payload.putFloat(f_array[i]);
        }
                    
        packet.payload.putUnsignedShort(u16);
        packet.payload.putShort(s16);
        
        for (int i = 0; i < u16_array.length; i++) {
            packet.payload.putUnsignedShort(u16_array[i]);
        }
                    
        
        for (int i = 0; i < s16_array.length; i++) {
            packet.payload.putShort(s16_array[i]);
        }
                    
        packet.payload.putByte(c);
        
        for (int i = 0; i < s.length; i++) {
            packet.payload.putByte(s[i]);
        }
                    
        packet.payload.putUnsignedByte(u8);
        packet.payload.putByte(s8);
        
        for (int i = 0; i < u8_array.length; i++) {
            packet.payload.putUnsignedByte(u8_array[i]);
        }
                    
        
        for (int i = 0; i < s8_array.length; i++) {
            packet.payload.putByte(s8_array[i]);
        }
                    
        
        if (isMavlink2) {
            
        }
        return packet;
    }

    /**
     * Decode a test_types message into this class fields
     *
     * @param payload The message to decode
     */
    @Override
    public void unpack(MAVLinkPayload payload) {
        payload.resetIndex();
        
        this.u64 = payload.getUnsignedLong();
        this.s64 = payload.getLong();
        this.d = payload.getDouble();
         
        for (int i = 0; i < this.u64_array.length; i++) {
            this.u64_array[i] = payload.getUnsignedLong();
        }
                
         
        for (int i = 0; i < this.s64_array.length; i++) {
            this.s64_array[i] = payload.getLong();
        }
                
         
        for (int i = 0; i < this.d_array.length; i++) {
            this.d_array[i] = payload.getDouble();
        }
                
        this.u32 = payload.getUnsignedInt();
        this.s32 = payload.getInt();
        this.f = payload.getFloat();
         
        for (int i = 0; i < this.u32_array.length; i++) {
            this.u32_array[i] = payload.getUnsignedInt();
        }
                
         
        for (int i = 0; i < this.s32_array.length; i++) {
            this.s32_array[i] = payload.getInt();
        }
                
         
        for (int i = 0; i < this.f_array.length; i++) {
            this.f_array[i] = payload.getFloat();
        }
                
        this.u16 = payload.getUnsignedShort();
        this.s16 = payload.getShort();
         
        for (int i = 0; i < this.u16_array.length; i++) {
            this.u16_array[i] = payload.getUnsignedShort();
        }
                
         
        for (int i = 0; i < this.s16_array.length; i++) {
            this.s16_array[i] = payload.getShort();
        }
                
        this.c = payload.getByte();
         
        for (int i = 0; i < this.s.length; i++) {
            this.s[i] = payload.getByte();
        }
                
        this.u8 = payload.getUnsignedByte();
        this.s8 = payload.getByte();
         
        for (int i = 0; i < this.u8_array.length; i++) {
            this.u8_array[i] = payload.getUnsignedByte();
        }
                
         
        for (int i = 0; i < this.s8_array.length; i++) {
            this.s8_array[i] = payload.getByte();
        }
                
        
        if (isMavlink2) {
            
        }
    }

    /**
     * Constructor for a new message, just initializes the msgid
     */
    public msg_test_types() {
        this.msgid = MAVLINK_MSG_ID_TEST_TYPES;
    }
    
    /**
     * Constructor for a new message, initializes msgid and all payload variables
     */
    public msg_test_types( long u64, long s64, double d, long[] u64_array, long[] s64_array, double[] d_array, long u32, int s32, float f, long[] u32_array, int[] s32_array, float[] f_array, int u16, short s16, int[] u16_array, short[] s16_array, byte c, byte[] s, short u8, byte s8, short[] u8_array, byte[] s8_array) {
        this.msgid = MAVLINK_MSG_ID_TEST_TYPES;

        this.u64 = u64;
        this.s64 = s64;
        this.d = d;
        this.u64_array = u64_array;
        this.s64_array = s64_array;
        this.d_array = d_array;
        this.u32 = u32;
        this.s32 = s32;
        this.f = f;
        this.u32_array = u32_array;
        this.s32_array = s32_array;
        this.f_array = f_array;
        this.u16 = u16;
        this.s16 = s16;
        this.u16_array = u16_array;
        this.s16_array = s16_array;
        this.c = c;
        this.s = s;
        this.u8 = u8;
        this.s8 = s8;
        this.u8_array = u8_array;
        this.s8_array = s8_array;
        
    }
    
    /**
     * Constructor for a new message, initializes everything
     */
    public msg_test_types( long u64, long s64, double d, long[] u64_array, long[] s64_array, double[] d_array, long u32, int s32, float f, long[] u32_array, int[] s32_array, float[] f_array, int u16, short s16, int[] u16_array, short[] s16_array, byte c, byte[] s, short u8, byte s8, short[] u8_array, byte[] s8_array, int sysid, int compid, boolean isMavlink2) {
        this.msgid = MAVLINK_MSG_ID_TEST_TYPES;
        this.sysid = sysid;
        this.compid = compid;
        this.isMavlink2 = isMavlink2;

        this.u64 = u64;
        this.s64 = s64;
        this.d = d;
        this.u64_array = u64_array;
        this.s64_array = s64_array;
        this.d_array = d_array;
        this.u32 = u32;
        this.s32 = s32;
        this.f = f;
        this.u32_array = u32_array;
        this.s32_array = s32_array;
        this.f_array = f_array;
        this.u16 = u16;
        this.s16 = s16;
        this.u16_array = u16_array;
        this.s16_array = s16_array;
        this.c = c;
        this.s = s;
        this.u8 = u8;
        this.s8 = s8;
        this.u8_array = u8_array;
        this.s8_array = s8_array;
        
    }

    /**
     * Constructor for a new message, initializes the message with the payload
     * from a mavlink packet
     *
     */
    public msg_test_types(MAVLinkPacket mavLinkPacket) {
        this.msgid = MAVLINK_MSG_ID_TEST_TYPES;
        
        this.sysid = mavLinkPacket.sysid;
        this.compid = mavLinkPacket.compid;
        this.isMavlink2 = mavLinkPacket.isMavlink2;
        unpack(mavLinkPacket.payload);
    }

                                       
    /**
    * Sets the buffer of this message with a string, adds the necessary padding
    */
    public void setS(String str) {
        int len = Math.min(str.length(), 10);
        for (int i=0; i<len; i++) {
            s[i] = (byte) str.charAt(i);
        }

        for (int i=len; i<10; i++) {            // padding for the rest of the buffer
            s[i] = 0;
        }
    }

    /**
    * Gets the message, formatted as a string
    */
    public String getS() {
        StringBuffer buf = new StringBuffer();
        for (int i = 0; i < 10; i++) {
            if (s[i] != 0)
                buf.append((char) s[i]);
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
        return "MAVLINK_MSG_ID_TEST_TYPES - sysid:"+sysid+" compid:"+compid+" u64:"+u64+" s64:"+s64+" d:"+d+" u64_array:"+u64_array+" s64_array:"+s64_array+" d_array:"+d_array+" u32:"+u32+" s32:"+s32+" f:"+f+" u32_array:"+u32_array+" s32_array:"+s32_array+" f_array:"+f_array+" u16:"+u16+" s16:"+s16+" u16_array:"+u16_array+" s16_array:"+s16_array+" c:"+c+" s:"+s+" u8:"+u8+" s8:"+s8+" u8_array:"+u8_array+" s8_array:"+s8_array+"";
    }
    
    /**
     * Returns a human-readable string of the name of the message
     */
    @Override
    public String name() {
        return "MAVLINK_MSG_ID_TEST_TYPES";
    }
}
        