/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Serviço;

/**
 *
 * @author nalis
 */


public class JSONObject {

    private final java.util.HashMap<String, Object> map;

    public JSONObject() {
        map = new java.util.HashMap<>();
    }

    public JSONObject put(String key, boolean value) {
        map.put(key, value);
        return this;
    }

    public JSONObject put(String key, double value) {
        map.put(key, value);
        return this;
    }

    public JSONObject put(String key, int value) {
        map.put(key, value);
        return this;
    }

    public JSONObject put(String key, long value) {
        map.put(key, value);
        return this;
    }

    public JSONObject put(String key, Object value) {
        map.put(key, value);
        return this;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        map.entrySet().forEach((entry) -> {
            if (sb.length() > 1) {
                sb.append(",");
            }
            sb.append("\"").append(entry.getKey()).append("\":");
            if (entry.getValue() instanceof String) {
                sb.append("\"").append(entry.getValue()).append("\"");
            } else {
                sb.append(entry.getValue());
            }
        });
        sb.append("}");
        return sb.toString();
    }
}
