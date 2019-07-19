package cn.xiaojf.temple.netbar.service.model;

/**
 * @Description
 * @Author wangyu
 * @Date 2019/7/19 10:23
 */
public class Person {

    private String name;

    private String code;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", code='" + code + '\'' +
                '}';
    }
}
