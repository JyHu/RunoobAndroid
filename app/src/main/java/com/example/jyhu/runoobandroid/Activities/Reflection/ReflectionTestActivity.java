package com.example.jyhu.runoobandroid.Activities.Reflection;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

import com.example.jyhu.runoobandroid.R;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class ReflectionTestActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reflection_test);

        ReflectionTest reflectionTest = new ReflectionTest();
        getReflectionConstructors(reflectionTest);

        addlog("\n\n");
        getReflectionMethods(reflectionTest);

        addlog("\n\n");
        getReflectionFieldValue(reflectionTest);
    }


    /*
    　 Constructor getConstructor(Class[] params)     根据构造函数的参数，返回一个具体的具有public属性的构造函数
　　　　Constructor getConstructors()     返回所有具有public属性的构造函数数组
　　　　Constructor getDeclaredConstructor(Class[] params)     根据构造函数的参数，返回一个具体的构造函数（不分public和非public属性）
　　　　Constructor getDeclaredConstructors()    返回该类中所有的构造函数数组（不分public和非public属性）
     */

    // 获取构造方法
    public void getReflectionConstructors(ReflectionTest r) {
        Class temp = r.getClass();
        String className = temp.getName();  // 获取指定类的类名

        try {
            Constructor constructors[] = temp.getDeclaredConstructors();
            for (int i = 0; i < constructors.length; i++) {
                int mod = constructors[i].getModifiers();
                addlog(Modifier.toString(mod) + " " + className + "(");

                Class paramterTypes[] = constructors[i].getParameterTypes();
                for (int j = 0; j < paramterTypes.length; j++) {
                    addlog(paramterTypes[j].getName());
                    if (paramterTypes.length > j + 1) {
                        addlog(",  ");
                    }
                }
                addlog(")", true);
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
    }




    /*
　　   与获取构造方法的方式相同，存在四种获取成员方法的方式。
　　　　Method getMethod(String name, Class[] params)    根据方法名和参数，返回一个具体的具有public属性的方法
　　　　Method[] getMethods()    返回所有具有public属性的方法数组
　　　　Method getDeclaredMethod(String name, Class[] params)    根据方法名和参数，返回一个具体的方法（不分public和非public属性）
　　　　Method[] getDeclaredMethods()    返回该类中的所有的方法数组（不分public和非public属性）

    　　   getMethods()：用于获取类的所有的public修饰域的成员方法，包括从父类继承的public方法和实现接口的public方法；
　　　     getDeclaredMethods()：用于获取在当前类中定义的所有的成员方法和实现的接口方法，不包括从父类继承的方法。
     */

    // 获取反射类的方法
    public void getReflectionMethods(ReflectionTest r) {
        Class temp = r.getClass();
        Method methods[] = temp.getMethods();
        for (int i = 0; i < methods.length; i++) {

            // 打印方法的修饰域
            int mod = methods[i].getModifiers();
            addlog(Modifier.toString(mod) + " ");

            // 输出方法的返回类型
            addlog(methods[i].getReturnType().getName());
            // 输出方法的方法名
            addlog( " " + methods[i].getName() + " (");
            // 输出方法的参数列表
            Class parameterTypes[] = methods[i].getParameterTypes();
            for (int j = 0; j < parameterTypes.length; j++) {
                addlog(parameterTypes[j].getName());
                if (parameterTypes.length > j + 1) {
                    addlog(", ");
                }
            }
            addlog(")", true);
        }
    }

    public void getReflectionFieldValue(ReflectionTest r) {
        Class temp = r.getClass();
        try {
            addlog("public属性");
            Field fields[] = temp.getFields();
            for (int i = 0; i < fields.length; i++) {
                Class cls = fields[i].getType();
                int md = fields[i].getModifiers();
                Field field = temp.getField(fields[i].getName());
                field.setAccessible(true);
                Object object = (Object)field.get(r);
                if (object == null) {
                    addlog(Modifier.toString(md) + " " + cls + " : " + fields[i].getName(), true);
                } else {
                    addlog(Modifier.toString(md) + " " + cls + " : " + fields[i].getName() + " = " + object.toString(), true);
                }
            }

            addlog("public & 非public 属性", true);

            Field fieldsAll[] = temp.getDeclaredFields();
            for (int i = 0; i < fieldsAll.length; i++) {
                Class cls = fieldsAll[i].getType();
                int md = fieldsAll[i].getModifiers();
                Field field = temp.getDeclaredField(fieldsAll[i].getName());
                field.setAccessible(true);
                Object object = (Object)field.get(r);
                if (object == null) {
                    addlog(Modifier.toString(md) + " " + cls + " : " + fieldsAll[i].getName(), true);
                } else {
                    addlog(Modifier.toString(md) + " " + cls + " : " + fieldsAll[i].getName() + " = " + object.toString(), true);
                }
            }

        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void addlog(String log) {
        EditText editText = (EditText)findViewById(R.id.reflection_test_log_edit_text);
        editText.setText(editText.getText() + log);
    }

    private void addlog(String log, Boolean bl) {
        addlog(log + (bl ? "\n" : ""));
    }
}
