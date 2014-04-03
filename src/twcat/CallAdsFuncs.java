/**
 * Created by dongxl on 14-4-2.
 */
package twcat;

import de.beckhoff.jni.Convert;
import de.beckhoff.jni.JNIByteBuffer;
import de.beckhoff.jni.tcads.AmsAddr;
import de.beckhoff.jni.tcads.AdsCallDllFunction;

public class CallAdsFuncs {
    public String getPLCVar() {
        long nPort, nErr;
        int intVal = 0;
        AmsAddr addr = new AmsAddr();
        JNIByteBuffer hdlBuff = new JNIByteBuffer(4);
        // Symbol name: String to byte[]
        JNIByteBuffer symBuff = new JNIByteBuffer(Convert.StringToByteArr(
                "MAIN.PLCVar"));
        JNIByteBuffer dataBuff = new JNIByteBuffer(4);

        // Open communication
        nPort = AdsCallDllFunction.adsPortOpen();
        nErr = AdsCallDllFunction.getLocalAddress(addr);

        addr.setPort(801);
        if (nErr != 0) {
            System.out.println("Error: Open Communication: 0x"
                    + Long.toHexString(nErr));
        }

        // Get handle by symbol name
        nErr = AdsCallDllFunction.adsSyncReadWriteReq(addr,
                0xF003,
                0x0,
                hdlBuff.getUsedBytesCount(),
                hdlBuff,
                symBuff.getUsedBytesCount(),
                symBuff);
        if (nErr != 0) {
            System.out.println("Error: Get handle: 0x"
                    + Long.toHexString(nErr));
        }

        // Handle: byte[] to int
        int hdlBuffToInt = Convert.ByteArrToInt(hdlBuff.getByteArray());
        // Read value by handle
        nErr = AdsCallDllFunction.adsSyncReadReq(addr,
                0xF005,
                hdlBuffToInt,
                0x4,
                dataBuff);
        if (nErr != 0) {
            System.out.println("Error: Read by handle: 0x"
                    + Long.toHexString(nErr));
        } else {
            // Data: byte[] to int
            intVal = Convert.ByteArrToInt(dataBuff.getByteArray());
            System.out.println("PLCVar value: " + intVal);
        }

        // Close communication
        nErr = AdsCallDllFunction.adsPortClose();
        if (nErr != 0) {
            System.out.println("Error: Close Communication: 0x"
                    + Long.toHexString(nErr));
        }
        return Integer.toString(intVal);
    }
}