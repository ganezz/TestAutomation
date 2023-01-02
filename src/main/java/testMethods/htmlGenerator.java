package testMethods;

import lombok.Data;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import lombok.val;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static j2html.TagCreator.*;
public class htmlGenerator {
    public static void main(String[] args) throws JSONException {
        jsonsample();
     //   tableContent();
    }

    public static void tableContent(JSONObject json1) throws JSONException {
     /*   List<List<String>> lists = Jsoniterator(json1);


        String filePath = "target/htmlreport/Sample2.html";
        String htmlTable = html(
                head(
                        title("Title"),
                        style("table {\n" +
                                "  border-collapse: collapse;\n" +
                                "  width: 90%;\n" +
                                 "margin-left: auto;\n"+
                                 "margin-right: auto;\n"+
                                "}\n" +
                                "\n" +
                                "th, td {\n" +
                                "  text-align: left;\n" +
                                "  padding: 8px;\n" +
                                "}\n" +
                                "\n" +
                                "tr:nth-child(even){background-color: #f2f2f2}\n" +
                                "\n" +
                                "th {\n" +
                                "  background-color: #04AA6D;\n" +
                                "  color: white;\n" +
                                "} ")
                        //link().withRel("stylesheet").withHref("/css/main.css")
                ),
                body(
                        h1("Test Scenario"),
                     table().with(
                         tr().with(
                                 th().with(
                                         span("Test Cases ID")
                                 ),
                                 th().with(
                                         span("Test Cases")
                                   ),
                                 th().with(
                                         span("Given Input")
                                 ),
                                 th().with(
                                         span("Expected Result")
                                 ),
                                  th().with(
                                         span("Actual Result")
                                 )
                         ),
                             each(lists,value -> tr(
                                     each(value,text ->td(
                                                String.valueOf(text)
                                             )
                                     )
                                     )
                             )


                        )
                     )

        ).render();
        htmlWritter(filePath,htmlTable);

      */
    }

    private static void htmlWritter(String filePath,String html) {
      try {
          FileOutputStream htmlObj = new FileOutputStream(filePath);
          OutputStreamWriter writter = new OutputStreamWriter(htmlObj);
          writter.write(html);
          writter.close();
          System.out.println("Report Generated on the path :"+filePath);
      }catch (Exception e){
        System.out.println(e);
      }
    }
    public static void sample() {
        List header = new ArrayList<String>();
      header.add("Test Cases ID");
        header.add("Test Cases ID");
        header.add("Test Cases ID");
        header.add("Test Cases ID");
        header.add("Test Cases ID");
    }
    public static void jsonsample() throws JSONException {
        JSONObject file = new JSONObject();
        JSONObject json1 = new JSONObject();
        json1.put("id", "001");
        json1.put("testcase", "Ritu ganesh");
        json1.put("input","12323");
        json1.put("expected","pass");
        json1.put("actual","pass");

        JSONObject json2 = new JSONObject();
        json2.put("id", "001");
        json2.put("testcase", "Ritu ganesh");
        json2.put("input","12323");
        json2.put("expected","pass");
        json2.put("actual","pass");

        file.put("Student0", json1);
        file.put("Student1", json2);

        tableContent(file);

    }
    public static List<List<String>> Jsoniterator(JSONObject data) throws JSONException {
        List<List<String>> lists = new ArrayList<>();

        Iterator iterator = data.keys();
        String key = null;
        while (iterator.hasNext()) {
            List<String> result = new ArrayList<>();
            key = (String) iterator.next();
            System.out.println(key);
            JSONObject element = data.getJSONObject(key);
            System.out.println(element.get("id"));
            result.add((String) element.get("id"));
            result.add((String) element.get("testcase"));
            result.add((String) element.get("input"));
            result.add((String) element.get("expected"));
            result.add((String) element.get("actual"));
            lists.add(result);
        }
        return lists;
    }


}


