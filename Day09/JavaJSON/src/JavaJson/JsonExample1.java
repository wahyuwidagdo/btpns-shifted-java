package JavaJson;

import org.json.simple.JSONObject;
import org.json.simple.JSONArray;
import org.json.simple.JSONValue;
public class JsonExample1{
    public static void main(String args[]){
        JSONObject obj=new JSONObject();
        obj.put("name","sonoo");
        obj.put("age",new Integer(27));
        obj.put("salary",new Double(600000));
//        System.out.print(obj);

        JSONObject obj2=new JSONObject();
        obj2.put("name","konoo");
        obj2.put("age",new Integer(25));
        obj2.put("salary",new Double(500000));
//        System.out.print(obj);

        JSONObject obj3=new JSONObject();
        obj3.put("name","diooo");
        obj3.put("age",new Integer(31));
        obj3.put("salary",new Double(60000000));
//        System.out.print(obj);

        JSONArray arr = new JSONArray();
        arr.add(obj);
        arr.add(obj2);
        arr.add(obj3);
        JSONObject employees = new JSONObject();
        employees.put("employee", arr);
        System.out.println(employees);

        String coba = "{\"employee\":[{\"name\":\"sonoo\",\"salary\":600000.0,\"age\":27},{\"name\":\"konoo\",\"salary\":500000.0,\"age\":25},{\"name\":\"diooo\",\"salary\":6.0E7,\"age\":31}]}";

        JSONObject cobaObject = new JSONObject(employees);
        JSONArray test = (JSONArray) cobaObject.get("employee");

        for (int i = 0, size = test.size(); i < size; i++)
        {
            JSONObject testbaru = (JSONObject) test.get(i);
            String name = (String) testbaru.get("name");
            Integer age = (Integer) testbaru.get("age");
            Double salary = (Double) testbaru.get("salary");
            System.out.println("Nama : " + name + "\n" + "Age : " + age + "\n" + "Salary : " + salary);
        }

//        Object objek = JSONValue.parse(employees);
//        JSONObject jsonObject = (JSONObject)obj;
//
//        String name = (String) jsonObject.get("name");
//        double salary = (Double) jsonObject.get("salary");
//        long age = (Long) jsonObject.get("age");
//        System.out.println(name+""+salary+""+age);
    }
}