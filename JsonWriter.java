public class JsonWriter{

  public static void main(String[] args) throws Exception {
        writeJsonSimpleDemo("example.json");
  }

  public static void writeJsonSimpleDemo(String filename) throws Exception {
    JSONObject sampleObject = new JSONObject();
    sampleObject.put("name", "Stackabuser");
    sampleObject.put("age", 35);

    JSONArray messages = new JSONArray();
    messages.add("Hey!");
    messages.add("What's up?!");

    sampleObject.put("messages", messages);
    Files.write(Paths.get(filename), sampleObject.toJSONString().getBytes());
  }

}
