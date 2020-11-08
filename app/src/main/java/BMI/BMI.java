package BMI;

public class BMI {
    String name;
    String height;
    String weight;
    String gender;
public BMI(){


}
public BMI(String name,String height,String weight,String gender){
    this.name=name;
    this.height=height;
    this.weight=weight;
    this.gender=gender;
}
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public String getHeight() {
        return height;
    }

    public void setHeight(String  height) {
        this.height = height;
    }
    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }
    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

}