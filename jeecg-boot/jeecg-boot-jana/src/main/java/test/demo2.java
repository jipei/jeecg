package test;


import entity.Person;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Date;

public class demo2 {

    public static void main(String[] args) throws  Exception {
      //AA();
       BB();
    }

    public static void BB() throws  IllegalAccessException, NoSuchFieldException {
        Person person = new Person("luoxn28", 23);
        Class clazz = person.getClass();

        Field[] fields = clazz.getDeclaredFields();
        // 获得private修饰Field对象
        Field f1 = clazz.getDeclaredField("name");
        System.out.println(f1);
        f1.setAccessible(true);
        // 通过f1对象给对象stu的gender属性赋值
        f1.set(person,"风清扬");
        // 通过f1对象获取对象stu的gender属性值 S
        String gender = (String) f1.get(person);
         System.out.println("性别：" + person.getName());


       /* for (Field field : fields) {
            System.out.println(field);
            Annotation[] declaredAnnotations = field.getDeclaredAnnotations();
            String key = field.getName();
            PropertyDescriptor descriptor = new PropertyDescriptor(key, clazz);

            Method method = descriptor.getReadMethod();
            method.setAccessible(true);
            Object value = method.invoke(PersonEntity);


            System.out.println(key + ":" + value);

        }*/
    }

    public static void AA() {
        Person person = new Person("luoxn28", 23);
        Class model = person.getClass();
        Field[] field = model.getClass().getDeclaredFields(); // 获取实体类的所有属性，返回Field数组
        try {
            for (int j = 0; j < field.length; j++) { // 遍历所有属性
                String name = field[j].getName(); // 获取属性的名字
                name = name.substring(0, 1).toUpperCase() + name.substring(1); // 将属性的首字符大写，方便构造get，set方法
                //System.out.println(name);
                String type = field[j].getGenericType().toString(); // 获取属性的类型

                if (type.equals("class java.lang.String")) { // 如果type是类类型，则前面包含"class "，后面跟类名
                    Method m = model.getClass().getMethod("get" + name);
                    String value = (String) m.invoke(model); // 调用getter方法获取属性值
                    System.out.println(m+"=>"+value);
                    if (value == null) {
                        m = model.getClass().getMethod("set" + name, String.class);
                        m.invoke(model, "");
                    }

                }
                if (type.equals("class java.lang.Integer")) {
                    Method m = model.getClass().getMethod("get" + name);
                    Integer value = (Integer) m.invoke(model);
                    if (value == null) {
                        m = model.getClass().getMethod("set" + name, Integer.class);
                        m.invoke(model, 0);
                    }
                    System.out.println(person.getAge());
                }
                if (type.equals("class java.lang.Boolean")) {
                    Method m = model.getClass().getMethod("get" + name);
                    Boolean value = (Boolean) m.invoke(model);
                    if (value == null) {
                        m = model.getClass().getMethod("set" + name, Boolean.class);
                        m.invoke(model, false);
                    }
                }
                if (type.equals("class java.util.Date")) {
                    Method m = model.getClass().getMethod("get" + name);
                    Date value = (Date) m.invoke(model);
                    if (value == null) {
                        m = model.getClass().getMethod("set" + name, Date.class);
                        m.invoke(model, new Date());
                    }
                }

            }
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (SecurityException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        System.out.println("姓名："+person.getName());

    }
}
