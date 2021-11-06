package Interview;

import java.time.Instant;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.time.Instant;
import java.io.*;
import java.nio.*;
import java.util.*;
import java.text.*;
import java.math.*;


public class Akuna {
    public static class HashTable {

        private HashMap<String,String>map;
        private Instant time;
        public HashTable(ArrayList<String> rawEvents) {
            // TODO
            this.map = new HashMap<>();
            this.time = Instant.EPOCH;

            for (String rawEvent : rawEvents) {
                if (rawEvent==null ||rawEvent.length()==0){
                    continue;
                }
                String[] inputs = rawEvent.trim().split("\\|");
                time = Instant.ofEpochMilli(Long.parseLong(inputs[0].trim()));
                if (inputs.length == 4){
                    if (inputs[1].trim().equals("INSERT")){
                        if (!map.containsKey(inputs[2])){
                            map.put(inputs[2],inputs[3]);
                        }
                    }
                    else {
                        map.put(inputs[2],inputs[3]);
                    }
                }
                else if (inputs.length ==3){
                    if (map.containsKey(inputs[2])){
                        map.remove(inputs[2]);
                    }
                }
            }
        }

        /**
         * Retrieve the state of the HashTable after applying all input events
         *
         * @return a Map representing the Keys and Values of the current state
         */
        public Map<String, String> getTable() {
            return map;  // TODO
        }

        /**
         * Retrieve the high-watermark of the HashTable as the millisecond epoch timestamp
         * of the latest event read or Instant.EPOCH in the case where no event occurred.
         *
         * @return an Instant representing the high watermark
         */
        public Instant getHighWatermark() {
            return time;  // TODO
        }
    }

    public static class WAL {
        private ByteBuffer _inputBuffer;
        private ArrayList<String>eventsList;
        /**
         * Construct the WAL
         * @param input the raw binary WAL
         */
        public WAL(byte[] input) {
            // TODO
            _inputBuffer = ByteBuffer.wrap(input);
        }

        /**
         * Retrieve all events contained within the WAL as their string values in time order
         * DML Event String Format: "<epoch_milli>|<message_name>|<key>|<value>"
         *
         * @return a time-ordered sequence of DML Event strings
         */
        public ArrayList<String> getEvents() {
            // TODO
            eventsList = new ArrayList<>();
            StringBuffer event;
            while (_inputBuffer.hasRemaining()){
                event = new StringBuffer();
                Long time = _inputBuffer.getLong();
                event.append(time);
                event.append("|");
                byte type = _inputBuffer.get();
                if (type == 0){
                    event.append("INSERT");
                }
                else if (type == 1){
                    event.append("UPSERT");
                }
                else if (type == 2){
                    event.append("DELETE");
                }
                event.append("|");
                short keyLen = _inputBuffer.getShort();
                byte[] keyArr = new byte[keyLen];
                _inputBuffer.get(keyArr);
                String key = new String(keyArr);
                event.append(key);
                if (type==0 || type == 1){
                    event.append("|");
                    short valLen = _inputBuffer.getShort();
                    byte[] varArr = new byte[valLen];
                    _inputBuffer.get(varArr);
                    String val = new String(varArr);
                    event.append(val);
                }
                eventsList.add(event.toString());
            }
            return eventsList;
        }
    }


}
